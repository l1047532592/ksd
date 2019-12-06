package com.pattern.ksdSystem.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName BasePlusEntity
 * @Author lfl
 * @Date 2019/8/20 10:01
 * @Description TODD
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BasePlusEntity<T extends Model> extends Model implements Serializable {
    private static final long serialVersionUId = 1L;

    protected String id;
    /**
     * 备注信息
     */
    private String remarks;
    /**
     * 创建者
     */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    protected String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Date createDate;
    /**
     * 更新者
     */
    @TableField(value = "update_by",fill = FieldFill.INSERT_UPDATE)
    protected String updateBy;
    /**
     * 更新时间
     */
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    protected Date updateDate;
    /**
     * 删除标记
     */
    @TableField(value = "del_flag",fill = FieldFill.INSERT)
    @JSONField(serialize = false)
    @TableLogic
    protected String delFlag;
}
