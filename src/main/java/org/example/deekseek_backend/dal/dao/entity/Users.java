package org.example.deekseek_backend.dal.dao.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
@Schema(title = "Users对象", description = "")
@Getter
@Setter
public class Users extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "邮件不能为空")
    private String email;

    @NotBlank(message = "手机号不能为空")
    private String phone;

    @Override
    public String toString() {
        return "Users{" +
                ", username = " + username +
                ", password = " + password +
                ", email = " + email +
                ", phone = " + phone +
                "}";
    }
}
