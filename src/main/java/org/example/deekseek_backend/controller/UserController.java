package org.example.deekseek_backend.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengyiyang
 */
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @SaIgnore
    @PostMapping("/user/register")
    public SaResult register(@Valid @RequestBody Users user) {
        return userService.register(user);
    }
}
