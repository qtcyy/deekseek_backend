package org.example.deekseek_backend.dal.dao.entity;

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
@Schema(title = "Users对象", description = "")
public class Users extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    private String email;

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
