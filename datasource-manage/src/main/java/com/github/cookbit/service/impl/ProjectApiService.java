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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.cookbit.dao.ProjectApiDao;
import com.github.cookbit.entity.ProjectApi;
import com.github.cookbit.model.api.ProjectApiAddRequest;
import com.github.cookbit.model.api.ProjectApiQueryRequest;
import com.github.cookbit.model.api.ProjectApiUpdateRequest;
import com.github.cookbit.service.IProjectApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目功能函数API服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
@Service
public class ProjectApiService implements IProjectApiService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiService.class);
    @Autowired
    ProjectApiDao projectApiDao;

    /**
     * 查询项目功能函数API
     *
     * @param request 查询参数
     * @return 功能函数API
     */
    @Override
    public Page<ProjectApi> listProjectApis(ProjectApiQueryRequest request) {

        return null;
    }

    /**
     * 新增项目API
     *
     * @param request 请求参数
     * @return 是否成功
     */
    @Override
    public boolean addProjectApi(ProjectApiAddRequest request) {
        return request.insert();
    }

    /**
     * 删除项目API
     *
     * @param projectApiId 项目API ID
     * @return 是否成功
     */
    @Override
    public boolean deleteProjectApi(String projectApiId) {
        return projectApiDao.removeById(projectApiId);
    }

    /**
     * 更新项目API
     *
     * @param request 更新请求
     * @return 是否成功
     */
    @Override
    public boolean updateProjectApi(ProjectApiUpdateRequest request) {
        return request.updateById();
    }
}
