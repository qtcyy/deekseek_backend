package org.example.deekseek_backend.dal.config;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import org.example.deekseek_backend.dal.dao.entity.Permissions;
import org.example.deekseek_backend.dal.dao.mapper.PermissionsMapper;
import org.example.deekseek_backend.dal.dao.mapper.RolesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengyiyang
 */
@Slf4j
@Component
public class StpInterfaceImpl implements StpInterface {
    @Autowired
    private PermissionsMapper permissionsMapper;
    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        String userId = String.valueOf(o);
        return permissionsMapper.getPermissionsById(userId).stream()
                .map(Permissions::getPermission).toList();
    }

    @Override
    public List<String> getRoleList(Object o, String s) {
        String userId = String.valueOf(o);
        return rolesMapper.getRolesById(userId);
    }
}
