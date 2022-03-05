package com.github.cookbit.service.impl;

import com.github.cookbit.entity.ProjectApiLog;
import com.github.cookbit.mapper.ProjectApiLogMapper;
import com.github.cookbit.service.IProjectApiLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  项目功能函数API日志调用服务实现类
 *
 * @author 961374431@qq.com
 * @since 2022-03-06
 */
@Service
public class ProjectApiLogServiceImpl extends ServiceImpl<ProjectApiLogMapper, ProjectApiLog>
        implements IProjectApiLogService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiLogServiceImpl.class);
}
