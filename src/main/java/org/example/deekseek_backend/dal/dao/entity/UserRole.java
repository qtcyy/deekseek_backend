package org.example.deekseek_backend.dal.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * <p>
 *
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
@TableName("user_role")
@Schema(title = "UserRole对象", description = "")
public class UserRole extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String roleId;

    @Override
    public String toString() {
        return "UserRole{" +
                ", userId = " + userId +
                ", roleId = " + roleId +
                "}";
    }
}
