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

import com.github.cookbit.model.api.ProjectApiAddRequest;
import com.github.cookbit.model.api.ProjectApiQueryRequest;
import com.github.jinzhaosn.common.model.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 项目功能函数API查询
     *
     * @param request  查询参数
     * @return API数据
     */
    public ResultVo<?> listProjectApis(@RequestBody ProjectApiQueryRequest request) {
        return ResultVo.success();
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
}
