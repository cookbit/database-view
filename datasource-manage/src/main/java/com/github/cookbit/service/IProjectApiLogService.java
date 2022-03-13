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
import com.github.cookbit.entity.ProjectApiLog;
import com.github.cookbit.model.log.ProjectApiLogQueryRequest;

/**
 * 项目功能函数API调用日志服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
public interface IProjectApiLogService {

    /**
     * 项目功能函数API调用日志
     *
     * @param request 查询参数
     * @return 日志
     */
    Page<ProjectApiLog> listProjectApiLogs(ProjectApiLogQueryRequest request);
}
