package org.example.deekseek_backend.dal.vo.request.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author chengyiyang
 */
@Data
public class UserLoginRequest {
    @NotBlank(message = "身份信息不能为空")
    private String mergedName;

    @NotBlank(message = "密码不能为空")
    private String password;
}
