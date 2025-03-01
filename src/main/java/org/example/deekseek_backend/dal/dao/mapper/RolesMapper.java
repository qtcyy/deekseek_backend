package org.example.deekseek_backend.dal.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.deekseek_backend.dal.dao.entity.Roles;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
public interface RolesMapper extends BaseMapper<Roles> {
    @Select("SELECT DISTINCT r.role " +
            "FROM users u " +
            "JOIN user_role ur ON u.id = ur.user_id " +
            "JOIN roles r ON ur.role_id = r.id " +
            "WHERE u.username = #{username}")
    List<String> getRolesByUsername(@Param("username") String username);

    @Select("SELECT DISTINCT r.role " +
            "FROM users u " +
            "JOIN user_role ur ON u.id = ur.user_id " +
            "JOIN roles r ON ur.role_id = r.id " +
            "WHERE u.id = #{id}")
    List<String> getRolesById(@Param("id") String userId);
}
