package org.example.deekseek_backend.dal.vo.request.chat;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author chengyiyang
 */
@Data
public class UpdateContentRequest {
    @NotBlank(message = "对话ID不能为空")
    private String id;

    @NotBlank(message = "内容不能为空")
    private String content;
}
