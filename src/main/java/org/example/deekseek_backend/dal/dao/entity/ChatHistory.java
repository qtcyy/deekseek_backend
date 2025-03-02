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
@TableName("chat_history")
@Schema(title = "ChatHistory对象", description = "")
@Getter
@Setter
public class ChatHistory extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userId;

    private String name;

    private String content;

    @Override
    public String toString() {
        return "ChatHistory{" +
                ", userId = " + userId +
                ", name = " + name +
                ", content = " + content +
                "}";
    }
}
