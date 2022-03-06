package com.github.cookbit.service.impl;

import com.github.cookbit.entity.ProjectApi;
import com.github.cookbit.mapper.ProjectApiMapper;
import com.github.cookbit.service.IProjectApiService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  项目功能函数API服务实现类
 *
 * @author 961374431@qq.com
 * @since 2022-03-06
 */
@Service
public class ProjectApiServiceImpl extends ServiceImpl<ProjectApiMapper, ProjectApi>
        implements IProjectApiService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectApiServiceImpl.class);
}
