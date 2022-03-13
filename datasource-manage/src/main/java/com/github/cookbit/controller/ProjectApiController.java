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
import com.github.cookbit.entity.ProjectApi;
import com.github.cookbit.model.api.ProjectApiAddRequest;
import com.github.cookbit.model.api.ProjectApiQueryRequest;
import com.github.cookbit.model.api.ProjectApiUpdateRequest;
import com.github.cookbit.service.IProjectApiService;
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
 * 项目功能函数API
 *
 * @auther 961374431@qq.com
 * @date 2022年03月12日
 */
@RestController
@RequestMapping("/v1/project/api/")
public class ProjectApiController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiController.class);
    @Autowired
    IProjectApiService apiService;

    /**
     * 项目功能函数API查询
     *
     * @param request 查询参数
     * @return API数据
     */
    @PostMapping("/list")
    public ResultVo<?> listProjectApis(@RequestBody ProjectApiQueryRequest request) {
        logger.info("list project apis param: [{}]", request);
        Page<ProjectApi> apiPage = apiService.listProjectApis(request);
        Long total = Optional.ofNullable(apiPage).map(Page::getTotal).orElse(0L);
        logger.info("list project apis total: [{}]", total);
        return ResultVo.success("success", apiPage);
    }

    /**
     * 项目功能函数新增请求
     *
     * @param request API新增请求
     * @return 是否成功
     */
    @PostMapping("/add")
    public ResultVo<?> addProjectApi(@RequestBody ProjectApiAddRequest request) {

        return ResultVo.success();
    }

    /**
     * 更新功能函数
     *
     * @param request 更新数据
     * @return 是否成功
     */
    @PostMapping("/update")
    public ResultVo<?> updateProjectApi(@RequestBody ProjectApiUpdateRequest request) {
        return ResultVo.success();
    }

    /**
     * 删除项目功能函数
     *
     * @param apiId 功能API ID
     * @return 是否成功
     */
    @PostMapping("/delete/{apiId}")
    public ResultVo<?> deleteProjectApi(@PathVariable String apiId) {
        return ResultVo.success();
    }
}
