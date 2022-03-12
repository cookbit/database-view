/*
 * Copyright 2021-2022 COOKBIT
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.cookbit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.cookbit.dao.DatasourceConfigDao;
import com.github.cookbit.entity.DatasourceConfig;
import com.github.cookbit.model.datasource.DatasourceAddRequest;
import com.github.cookbit.model.datasource.DatasourceModifyRequest;
import com.github.cookbit.model.datasource.DatasourceQueryRequest;
import com.github.cookbit.service.IDatasourceConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.commons.lang3.StringUtils.isNotBlank;


/**
 * 数据源配置服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月07日
 */
@Service
public class DatasourceConfigServiceImpl implements IDatasourceConfigService {
    private static final Logger logger = LoggerFactory.getLogger(DatasourceConfigServiceImpl.class);
    @Autowired
    DatasourceConfigDao datasourceDao;

    /**
     * 查询数据源配置
     *
     * @param query 数据源配置查询参数
     * @return 数据源配置列表
     */
    @Override
    public Page<DatasourceConfig> listDatasourceConfigs(DatasourceQueryRequest query) {
        logger.info("list datasource configs params: [{}]", query);
        LambdaQueryWrapper<DatasourceConfig> queryWrapper = Wrappers.<DatasourceConfig>lambdaQuery()
                .like(isNotBlank(query.getKeyword()), DatasourceConfig::getSourceName, query.getKeyword())
                .orderByDesc(DatasourceConfig::getModifyTime);
        return datasourceDao.page(Page.of(query.getPageNum(), query.getPageSize()), queryWrapper);
    }

    /**
     * 新增数据源配置
     *
     * @param request 数据源配置请求
     * @return 是否更新成功
     */
    @Override
    public boolean addDatasourceConfig(DatasourceAddRequest request) {
        DatasourceConfig config = new DatasourceConfig();
        BeanUtils.copyProperties(request, config);
        return datasourceDao.save(config);
    }

    /**
     * 删除数据源配置
     *
     * @param configId 配置ID
     * @return 是否成功
     */
    @Override
    public boolean deleteDatasource(String configId) {
        DatasourceConfig config = new DatasourceConfig();
        config.setId(Long.valueOf(configId));
        return datasourceDao.removeById(config);
    }

    /**
     * 更新数据源配置
     *
     * @param request 更新请求
     * @return 是否更新成功
     */
    @Override
    public boolean updateDatasourceConfig(DatasourceModifyRequest request) {
        LambdaUpdateWrapper<DatasourceConfig> updateWrapper =
                Wrappers.<DatasourceConfig>lambdaUpdate().eq(DatasourceConfig::getId, request.getId());
        return datasourceDao.update(request, updateWrapper);
    }
}
