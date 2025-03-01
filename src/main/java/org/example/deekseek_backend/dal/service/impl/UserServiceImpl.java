package org.example.deekseek_backend.dal.service.impl;

import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.dao.service.IUsersService;
import org.example.deekseek_backend.dal.service.UserService;
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
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public SaResult register(@Valid @RequestBody Users user) {
        try {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            usersService.save(user);

            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
