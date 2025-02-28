package org.example.deekseek_backend.dal.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
@TableName("role_permission")
@Schema(title = "RolePermission对象", description = "")
@Getter
@Setter
public class RolePermission extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleId;

    private String permissionId;

    @Override
    public String toString() {
        return "RolePermission{" +
                ", roleId = " + roleId +
                ", permissionId = " + permissionId +
                "}";
    }
}
