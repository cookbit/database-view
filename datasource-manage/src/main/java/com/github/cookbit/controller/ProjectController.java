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
import com.github.cookbit.entity.ProjectDatasource;
import com.github.cookbit.model.project.ProjectAddRequest;
import com.github.cookbit.model.project.ProjectQueryRequest;
import com.github.cookbit.model.project.ProjectUpdateRequest;
import com.github.cookbit.service.IProjectService;
import com.github.jinzhaosn.common.model.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 项目
 *
 * @auther 961374431@qq.com
 * @date 2022年03月12日
 */
@RestController
@RequestMapping("/v1/project")
public class ProjectController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectController.class);
    @Autowired
    IProjectService projectService;

    /**
     * 查询项目
     *
     * @param request 项目查询参数
     * @return 项目数据
     */
    @PostMapping("/list")
    public ResultVo<?> listProjects(@RequestBody ProjectQueryRequest request) {
        logger.info("list projects param: [{}]", request);
        Page<ProjectDatasource> page = projectService.listProjects(request);
        Long total = Optional.ofNullable(page).map(Page::getTotal).orElse(0L);
        logger.info("list projects result total: [{}]", total);
        return ResultVo.success("success", page);
    }

    /**
     * 新增项目
     *
     * @param request 新增项目配置
     * @return 是否成功
     */
    @PostMapping("/add")
    public ResultVo<?> addProject(@RequestBody ProjectAddRequest request) {
        logger.info("add project param: [{}]", request);
        boolean ret = projectService.addProject(request);
        return ret ? ResultVo.success() : ResultVo.fail();
    }

    /**
     * 删除项目
     *
     * @param projectId 项目ID
     * @return 是否成功
     */
    @PostMapping("/delete/{projectId}")
    public ResultVo<?> deleteProject(@PathVariable Long projectId) {
        logger.info("delete project param: [{}]", projectId);
        boolean ret = projectService.deleteProject(projectId);
        return ret ? ResultVo.success() : ResultVo.fail();
    }

    /**
     * 更新项目信息
     *
     * @param request 更新项目请求
     * @return 是否成功
     */
    @PostMapping("/update")
    public ResultVo<?> updateProject(@RequestBody ProjectUpdateRequest request) {
        logger.info("update project param: [{}]", request);
        boolean ret = projectService.updateProject(request);
        return ret ? ResultVo.success() : ResultVo.fail();
    }
}
