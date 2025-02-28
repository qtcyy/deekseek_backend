package org.example.deekseek_backend.dal.dao.entity;

import java.io.Serializable;

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
@Schema(title = "Roles对象", description = "")
@Getter
@Setter
public class Roles extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String role;

    @Override
    public String toString() {
        return "Roles{" +
                ", role = " + role +
                "}";
    }
}
