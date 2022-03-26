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

import com.github.cookbit.entity.DatasourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.util.Map;

/**
 * 数据语句执行
 *
 * @auther 961374431@qq.com
 * @date 2022年03月26日
 */
public class DataStatementExecutor {
    private static final Logger logger = LoggerFactory.getLogger(DataStatementExecutor.class);

    /**
     * 语句执行
     *
     * @param datasource   数据源
     * @param sqlStatement 语句
     * @param param        参数
     * @return 执行结果
     */
    public static JSONObject execute(DatasourceConfig datasource, String sqlStatement, Map<String, Object> param) {
        return null;
    }
}
