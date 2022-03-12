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
import com.github.cookbit.entity.ProjectDatasource;
import com.github.cookbit.model.project.ProjectAddRequest;
import com.github.cookbit.model.project.ProjectQueryRequest;
import com.github.cookbit.model.project.ProjectUpdateRequest;

/**
 * 项目管理服务
 *
 * @auther 961374431@qq.com
 * @date 2022年03月11日
 */
public interface IProjectService {
    /**
     * 查询项目
     *
     * @param request 查询参数
     * @return 项目数据
     */
    Page<ProjectDatasource> listProjects(ProjectQueryRequest request);

    /**
     * 新增项目
     *
     * @param request 新增项目请求
     * @return 是否成功
     */
    boolean addProject(ProjectAddRequest request);

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 是否成功
     */
    boolean deleteProject(Long projectId);

    /**
     * 更新项目信息
     *
     * @param request 更新项目请求
     * @return 是否成功
     */
    boolean updateProject(ProjectUpdateRequest request);
}
