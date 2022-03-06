package com.github.cookbit.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 项目功能函数API调用日志
 *
 * @author 961374431@qq.com
 * @since 2022-03-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_project_api_log")
public class ProjectApiLog extends Model<ProjectApiLog> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 数据源编码
     */
    private String datasourceCode;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 共能函数编码
     */
    private String apiCode;

    /**
     * 功能函数名称
     */
    private String apiName;

    /**
     * 调用参数
     */
    private String params;

    /**
     * 结果编码
     */
    private String resultCode;

    /**
     * 结果消息
     */
    private String msg;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 创建人
     */
    private String createUser;
}
