package org.example.deekseek_backend.dal.dao.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
@Schema(title = "Permissions对象", description = "")
@Getter
@Setter
public class Permissions extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String permission;

    @Override
    public String toString() {
        return "Permissions{" +
                ", permission = " + permission +
                "}";
    }
}
