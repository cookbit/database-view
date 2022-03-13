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
import com.github.cookbit.entity.ProjectApiLog;
import com.github.cookbit.model.log.ProjectApiLogQueryRequest;
import com.github.cookbit.service.IProjectApiLogService;
import com.github.jinzhaosn.common.model.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * 项目功能函数调用日志
 *
 * @auther 961374431@qq.com
 * @date 2022年03月13日
 */
@RestController
@RequestMapping("/v1/project/api/log")
public class ProjectApiLogController {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiLogController.class);
    @Autowired
    IProjectApiLogService apiLogService;

    /**
     * 查询项目功能函数调用日志
     *
     * @param request 查询参数
     * @return 日志数据
     */
    @PostMapping("/list")
    public ResultVo<?> listProjectApiLogs(@RequestBody ProjectApiLogQueryRequest request) {
        logger.info("list project api logs param: [{}]", request);
        Page<ProjectApiLog> logPage = apiLogService.listProjectApiLogs(request);
        Long total = Optional.ofNullable(logPage).map(Page::getTotal).orElse(0L);
        logger.info("project api logs total: [{}]", total);
        return ResultVo.success("success", logPage);
    }
}
