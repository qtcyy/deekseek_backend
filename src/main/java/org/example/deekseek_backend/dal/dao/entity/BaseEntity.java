package org.example.deekseek_backend.dal.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author chengyiyang
 */
@Data
public class BaseEntity {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    @TableLogic
    private Boolean deleted;
}
