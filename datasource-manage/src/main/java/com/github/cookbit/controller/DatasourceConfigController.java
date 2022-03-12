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

package com.github.cookbit.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.cookbit.entity.DatasourceConfig;
import com.github.cookbit.model.datasource.DatasourceAddRequest;
import com.github.cookbit.model.datasource.DatasourceModifyRequest;
import com.github.cookbit.model.datasource.DatasourceQueryRequest;
import com.github.cookbit.service.IDatasourceConfigService;
import com.github.jinzhaosn.common.model.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 数据源配置
 *
 * @auther 961374431@qq.com
 * @date 2022年03月06日
 */
@RestController
@RequestMapping("/v1/datasource")
public class DatasourceConfigController {
    private static final Logger logger = LoggerFactory.getLogger(DatasourceConfigController.class);
    @Autowired
    IDatasourceConfigService datasourceService;

    /**
     * 查询数据源配置
     *
     * @param queryRequest 查询参数
     * @return 数据源列表
     */
    @PostMapping("list")
    public ResultVo<?> listDatasourceConfigs(@RequestBody DatasourceQueryRequest queryRequest) {
        logger.info("list datasource configs param: [{}]", queryRequest);
        Page<DatasourceConfig> configs = datasourceService.listDatasourceConfigs(queryRequest);
        logger.info("datasource list: [{}]", configs);
        return ResultVo.success("success", configs);
    }

    /**
     * 新增数据源配置
     *
     * @param addRequest 添加数据源配置请求
     * @return 添加配置的结果
     */
    @PostMapping("add")
    public ResultVo<?> addDatasourceConfig(@RequestBody DatasourceAddRequest addRequest) {
        logger.info("add datasource config param: [{}]", addRequest);
        boolean ret = datasourceService.addDatasourceConfig(addRequest);
        return ret ? ResultVo.success() : ResultVo.fail();
    }

    /**
     * 删除数据源配置
     *
     * @param configId 数据源ID
     * @return 是否成功
     */
    @PostMapping("delete/{configId}")
    public ResultVo<?> deleteDatasourceConfig(@PathVariable("configId") String configId) {
        logger.info("delete datasource by id: [{}]", configId);
        boolean ret = datasourceService.deleteDatasource(configId);
        return ret ? ResultVo.success() : ResultVo.fail();
    }

    /**
     * 更改数据源配置
     *
     * @param request 数据配置更新请求
     * @return 是否成功
     */
    @PostMapping("update")
    public ResultVo<?> updateDatasource(@RequestBody DatasourceModifyRequest request) {
        logger.info("datasource config update param: [{}]", request);
        boolean ret = datasourceService.updateDatasourceConfig(request);
        return ret ? ResultVo.success() : ResultVo.fail();
    }
}
