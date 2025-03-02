package org.example.deekseek_backend.dal.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

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
@Getter
@Setter
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
