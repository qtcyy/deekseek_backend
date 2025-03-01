package org.example.deekseek_backend.dal.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.deekseek_backend.dal.dao.entity.Permissions;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
public interface PermissionsMapper extends BaseMapper<Permissions> {
    @Select("SELECT DISTINCT p.permission " +
            "FROM users u " +
            "JOIN user_role ur ON u.id = ur.user_id " +
            "JOIN role_permission rp ON ur.role_id = rp.role_id " +
            "JOIN permissions p ON p.id = rp.permission_id " +
            "WHERE u.username = #{username}")
    List<Permissions> getPermissionsByUsername(@Param("username") String username);

    @Select("SELECT DISTINCT p.permission " +
            "FROM users u " +
            "JOIN user_role ur ON u.id = ur.user_id " +
            "JOIN role_permission rp ON ur.role_id = rp.role_id " +
            "JOIN permissions p ON p.id = rp.permission_id " +
            "WHERE u.id = #{id}")
    List<Permissions> getPermissionsById(@Param("id") String userId);
}
