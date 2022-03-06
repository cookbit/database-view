package com.github.cookbit.service.impl;

import com.github.cookbit.entity.DatasourceConfig;
import com.github.cookbit.mapper.DatasourceConfigMapper;
import com.github.cookbit.service.IDatasourceConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 *  数据源配置服务实现类
 *
 * @author 961374431@qq.com
 * @since 2022-03-06
 */
@Service
public class DatasourceConfigServiceImpl extends ServiceImpl<DatasourceConfigMapper, DatasourceConfig>
        implements IDatasourceConfigService {
    private static final Logger logger = LoggerFactory.getLogger(DatasourceConfigServiceImpl.class);
}
