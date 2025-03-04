package org.example.deekseek_backend.dal.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.deekseek_backend.dal.dao.entity.UserRole;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.dao.service.IRolesService;
import org.example.deekseek_backend.dal.dao.service.IUserRoleService;
import org.example.deekseek_backend.dal.dao.service.IUsersService;
import org.example.deekseek_backend.dal.service.UserService;
import org.example.deekseek_backend.dal.vo.request.user.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chengyiyang
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private static final String UNFINISHED_MESSAGE = "unfinished";

    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IRolesService rolesService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    @Transactional
    @Override
    public SaResult register(@Valid @RequestBody Users user) {
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            usersService.save(user);
            String userId = user.getId();
            String roleId = rolesService.getIdByName("user");
            UserRole userRole = new UserRole();
            userRole.setUserId(userId);
            userRole.setRoleId(roleId);
            userRoleService.save(userRole);

            StpUtil.login(userId);
            return SaResult.ok("success")
                    .set("token", StpUtil.getTokenValue());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SaResult checkUsername(String username) {
        try {
            if (usersService.hasUsername(username)) {
                return SaResult.error("occupying username");
            } else {
                return SaResult.ok("success");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SaResult checkPhone(String phone) {
        try {
            if (usersService.hasPhone(phone)) {
                return SaResult.error("occupying phone");
            } else {
                return SaResult.ok("success");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SaResult checkEmail(String email) {
        try {
            if (usersService.hasEmail(email)) {
                return SaResult.error("occupying email");
            } else {
                return SaResult.ok("success");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SaResult login(UserLoginRequest request) {
        try {
            if (StpUtil.isLogin()) {
                return SaResult.ok("success")
                        .set("token", StpUtil.getTokenValue());
            }
            String mergedInfo = request.getMergedName();
            Users users = usersService.getUsersByInfo(mergedInfo);
            if (users == null) {
                return SaResult.error("empty");
            }
            if (verifyPassword(request.getPassword(), users.getPassword())) {
                StpUtil.login(users.getId());
                return SaResult.ok("success")
                        .set("token", StpUtil.getTokenValue());
            } else {
                return SaResult.error("failed");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SaResult getLoginUsername() {
        String id = StpUtil.getLoginIdAsString();
        Users users = usersService.getById(id);

        return SaResult.ok("success")
                .set("username", users.getUsername());
    }
}
