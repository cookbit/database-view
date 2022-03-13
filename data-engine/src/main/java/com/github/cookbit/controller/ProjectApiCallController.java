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

import com.github.cookbit.model.InvokeApiCodeParam;
import com.github.cookbit.service.impl.ProjectApiInvokeService;
import com.github.jinzhaosn.common.model.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目功能函数API调用
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
@RestController
@RequestMapping("/api")
public class ProjectApiCallController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiCallController.class);
    @Autowired
    ProjectApiInvokeService invokeService;

    /**
     * 通过API code调用
     *
     * @return 调用返回
     */
    @PostMapping("invokeByApiCode")
    public ResultVo<?> invokeByApiCode(@RequestBody InvokeApiCodeParam param) {
        logger.info("invoke api param: [{}]", param);
        JSONObject result = invokeService.invokeByApiCode(param);
        return ResultVo.success("success", result);
    }
}
