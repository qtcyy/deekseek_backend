package org.example.deekseek_backend.dal.vo.request.chat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author chengyiyang
 */
@Data
public class WriteHistoryRequest {
    @NotNull(message = "id不能为空")
    private String id;

    @NotBlank(message = "对话名不能为空")
    private String name;

    @NotBlank(message = "对话内容不能为空")
    private String content;
}
