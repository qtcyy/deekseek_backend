package org.example.deekseek_backend;

import org.example.deekseek_backend.dal.dao.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DeekseekBackendApplicationTests {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IRolesService rolesService;
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRolePermissionService rolePermissionService;
    @Autowired
    private IPermissionsService permissionsService;

    @Test
    void contextLoads() {
    }
/*
    @Test
    void insertRoles() {
        List<String> roleList = new ArrayList<>(Arrays.asList("root", "user", "admin"));
        List<Roles> roles = new ArrayList<>();
        roleList.forEach(roleName -> {
            Roles role = new Roles();
            role.setRole(roleName);
            roles.add(role);
        });
        rolesService.saveBatch(roles);
    }

    @Test
    void linkUserRoles() {
        List<String> roleId = rolesService.list().stream().map(Roles::getId).toList();
    }

    @Test
    void insertPermissions() {
        List<String> permissionList = new ArrayList<>(Arrays.asList("chat.write", "chat.delete", "chat.read",
                "user.read", "user.add", "user.edit", "user.delete"));
        List<Permissions> permissions = new ArrayList<>();
        permissionList.forEach(permissionName -> {
            Permissions permission = new Permissions();
            permission.setPermission(permissionName);
            permissions.add(permission);
        });
        permissionsService.saveBatch(permissions);
    }

    @Test
    void linkRolePermissions() {
        List<String> permissionList = new ArrayList<>(Arrays.asList("chat.write", "chat.delete", "chat.read",
                "user.read", "user.add", "user.edit", "user.delete"));
        List<String> permissionIds = permissionsService.getByNames(permissionList)
                .stream().map(Permissions::getId).toList();
        String roleId = rolesService.getIdByName("admin");
        List<RolePermission> entities = new ArrayList<>();
        permissionIds.forEach(permissionId -> {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(roleId);
            rolePermission.setPermissionId(permissionId);
            entities.add(rolePermission);
        });
        rolePermissionService.saveBatch(entities);
    }
*/
}
