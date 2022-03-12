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

package com.github.cookbit.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.cookbit.entity.DatasourceConfig;
import com.github.cookbit.model.datasource.DatasourceAddRequest;
import com.github.cookbit.model.datasource.DatasourceModifyRequest;
import com.github.cookbit.model.datasource.DatasourceQueryRequest;

/**
 * 数据源配置服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月07日
 */
public interface IDatasourceConfigService {
    /**
     * 查询数据源配置
     *
     * @param query 数据源配置查询参数
     * @return 数据源配置列表
     */
    Page<DatasourceConfig> listDatasourceConfigs(DatasourceQueryRequest query);

    /**
     * 添加数据源配置
     *
     * @param request 数据源配置请求
     * @return 更新
     */
    boolean addDatasourceConfig(DatasourceAddRequest request);

    /**
     * 删除数据源配置
     *
     * @param configId 配置ID
     * @return 是否成功
     */
    boolean deleteDatasource(String configId);

    /**
     * 更新数据源配置
     *
     * @param request 更新请求
     * @return 是否成功
     */
    boolean updateDatasourceConfig(DatasourceModifyRequest request);
}
