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

package com.github.cookbit.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 项目功能函数API(t_project_api)实体类
 *
 * @author 961374431@qq.com
 * @since 2022-03-07 23:07:11
 * @description generated by mybatis code generator
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_project_api")
public class ProjectApi extends Model<ProjectApi> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
	private Long id;
    /**
     * 功能函数编码
     */
    private String apiCode;
    /**
     * 功能函数名称
     */
    private String apiName;
    /**
     * 归属项目编码
     */
    private String projectCode;
    /**
     * 归属项目名称
     */
    private String projectName;
    /**
     * 数据库编码
     */
    private String datasourceCode;
    /**
     * SQL语句
     */
    private String sqlStatement;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 修改人
     */
    private String modifyUser;

}