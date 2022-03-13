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
import com.github.cookbit.dao.ProjectDatasourceDao;
import com.github.cookbit.entity.ProjectDatasource;
import com.github.cookbit.model.project.ProjectAddRequest;
import com.github.cookbit.model.project.ProjectQueryRequest;
import com.github.cookbit.model.project.ProjectUpdateRequest;
import com.github.cookbit.service.IProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * 项目服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月11日
 */
@Service
public class ProjectServiceImpl implements IProjectService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);
    @Autowired
    ProjectDatasourceDao projectDatasourceDao;

    /**
     * 查询项目
     *
     * @param request 查询参数
     * @return 项目数据
     */
    @Override
    public Page<ProjectDatasource> listProjects(ProjectQueryRequest request) {
        Page<ProjectDatasource> page = Page.of(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<ProjectDatasource> queryWrapper = listProjectQueryWrapper(request);
        return request.selectPage(page, queryWrapper);
    }

    private LambdaQueryWrapper<ProjectDatasource> listProjectQueryWrapper(ProjectQueryRequest request) {
        String keyword = request.getKeyword();
        String datasourceCode = request.getDatasourceCode();
        String datasourceName = request.getDatasourceName();
        String projectCode = request.getProjectCode();
        String projectName = request.getProjectName();
        Date startTime = request.getStartTime();
        Date endTime = request.getEndTime();

        return Wrappers.<ProjectDatasource>lambdaQuery()
                .eq(ProjectDatasource::getEnable, true)
                .and(isNotBlank(keyword), cond -> cond.like(ProjectDatasource::getDatasourceCode, keyword)
                        .or().like(ProjectDatasource::getDatasourceName, keyword)
                        .or().like(ProjectDatasource::getProjectCode, keyword)
                        .or().like(ProjectDatasource::getProjectName, keyword))
                .eq(isNotBlank(datasourceCode), ProjectDatasource::getDatasourceCode, datasourceCode)
                .eq(isNotBlank(datasourceName), ProjectDatasource::getDatasourceName, datasourceName)
                .eq(isNotBlank(projectCode), ProjectDatasource::getProjectCode, projectCode)
                .eq(isNotBlank(projectName), ProjectDatasource::getProjectName, projectName)
                .ge(nonNull(startTime), ProjectDatasource::getCreateTime, startTime)
                .le(nonNull(endTime), ProjectDatasource::getCreateTime, endTime);
    }

    /**
     * 新增项目
     *
     * @param request 新增项目请求
     * @return 是否成功
     */
    @Override
    public boolean addProject(ProjectAddRequest request) {
        return request.insert();
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 是否成功
     */
    @Override
    public boolean deleteProject(Long projectId) {
        return projectDatasourceDao.removeById(projectId);
    }

    /**
     * 更新项目信息
     *
     * @param request 更新项目请求
     * @return 是否成功
     */
    @Override
    public boolean updateProject(ProjectUpdateRequest request) {
        return request.updateById();
    }
}
