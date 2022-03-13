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
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.cookbit.dao.ProjectApiLogDao;
import com.github.cookbit.entity.ProjectApiLog;
import com.github.cookbit.model.log.ProjectApiLogQueryRequest;
import com.github.cookbit.service.IProjectApiLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.baomidou.mybatisplus.core.toolkit.StringUtils.isNotBlank;

/**
 * 项目功能函数API调用日志服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
@Service
public class ProjectApiLogService implements IProjectApiLogService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiLogService.class);

    /**
     * 项目功能函数API调用日志
     *
     * @param request 查询参数
     * @return 日志
     */
    @Override
    public Page<ProjectApiLog> listProjectApiLogs(ProjectApiLogQueryRequest request) {
        Page<ProjectApiLog> page = Page.of(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<ProjectApiLog> queryWrapper = projectApiLogQueryWrapper(request);
        return request.selectPage(page, queryWrapper);
    }

    private LambdaQueryWrapper<ProjectApiLog> projectApiLogQueryWrapper(ProjectApiLogQueryRequest request) {
        String datasourceCode = request.getDatasourceCode();
        String projectCode = request.getProjectCode();
        return Wrappers.<ProjectApiLog>lambdaQuery()
                .eq(isNotBlank(datasourceCode), ProjectApiLog::getDatasourceCode, datasourceCode)
                .eq(isNotBlank(projectCode), ProjectApiLog::getProjectCode, projectCode);
    }
}
