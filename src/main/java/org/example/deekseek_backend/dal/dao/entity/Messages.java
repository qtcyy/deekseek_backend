package org.example.deekseek_backend.dal.dao.entity;

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
@Schema(title = "Messages对象", description = "")
@Getter
@Setter
public class Messages extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String chatId;

    private String content;

    @Override
    public String toString() {
        return "Messages{" +
                ", chatId = " + chatId +
                ", content = " + content +
                "}";
    }
}
