package com.github.cookbit.service.impl;

import com.github.cookbit.entity.ProjectDatasource;
import com.github.cookbit.mapper.ProjectDatasourceMapper;
import com.github.cookbit.service.IProjectDatasourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  项目数据源服务实现类
 *
 * @author 961374431@qq.com
 * @since 2022-03-06
 */
@Service
public class ProjectDatasourceServiceImpl extends ServiceImpl<ProjectDatasourceMapper, ProjectDatasource>
        implements IProjectDatasourceService {
    private static final Logger logger = LoggerFactory.getLogger(ProjectDatasourceServiceImpl.class);
}
