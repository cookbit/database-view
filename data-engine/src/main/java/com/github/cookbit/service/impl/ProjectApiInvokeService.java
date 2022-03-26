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
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.cookbit.dao.DatasourceConfigDao;
import com.github.cookbit.dao.ProjectApiDao;
import com.github.cookbit.entity.DatasourceConfig;
import com.github.cookbit.entity.ProjectApi;
import com.github.cookbit.model.InvokeApiCodeParam;
import com.github.cookbit.service.IProjectApiInvokeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.github.jinzhaosn.common.util.CheckUtil.checkTrue;

/**
 * 项目API调用服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
@Service
public class ProjectApiInvokeService implements IProjectApiInvokeService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiInvokeService.class);
    @Autowired
    DatasourceConfigDao datasourceConfigDao;
    @Autowired
    ProjectApiDao apiDao;


    /**
     * API调用
     *
     * @param param 调用参数
     * @return 调用返回
     */
    @Override
    public JSONObject invokeByApiCode(InvokeApiCodeParam param) {
        // 查找API配置
        LambdaQueryWrapper<ProjectApi> apiQueryWrapper =
                Wrappers.<ProjectApi>lambdaQuery().eq(ProjectApi::getApiCode, param.getApiCode());
        ProjectApi projectApi = apiDao.getOne(apiQueryWrapper);
        logger.info("query project api code: [{}] api: [{}]", param.getApiCode(), projectApi);
        checkTrue(Objects.nonNull(projectApi), "can't find project api");

        // 查找归属数据源
        String datasourceCode = projectApi.getDatasourceCode();
        LambdaQueryWrapper<DatasourceConfig> datasourceQueryWrapper =
                Wrappers.<DatasourceConfig>lambdaQuery().eq(DatasourceConfig::getSourceCode, datasourceCode);
        DatasourceConfig datasourceConfig = datasourceConfigDao.getOne(datasourceQueryWrapper);
        checkTrue(Objects.nonNull(datasourceConfig), "can't find datasource config");

        return DataStatementExecutor.execute(datasourceConfig, projectApi.getSqlStatement(), param.getParam());
    }
}
