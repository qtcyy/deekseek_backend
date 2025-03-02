package org.example.deekseek_backend.dal.vo.request.chat;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * @author chengyiyang
 */
@Data
public class UpdateNameRequest {
    @NotEmpty(message = "对话ID不能为空")
    private String id;

    @NotEmpty(message = "修改的名字不能为空")
    private String name;
}
