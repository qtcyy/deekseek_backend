package org.example.deekseek_backend.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.service.UserService;
import org.example.deekseek_backend.dal.vo.request.user.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyiyang
 */
@Slf4j
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

    @SaIgnore
    @GetMapping("/user/register/checkUsername")
    public SaResult checkUsername(@RequestParam String username) {
        return userService.checkUsername(username);
    }

    @SaIgnore
    @GetMapping("/user/register/checkPhone")
    public SaResult checkPhone(@RequestParam String phone) {
        return userService.checkPhone(phone);
    }

    @SaIgnore
    @GetMapping("/user/register/checkEmail")
    public SaResult checkEmail(@RequestParam String email) {
        return userService.checkEmail(email);
    }

    @SaIgnore
    @PostMapping("/user/login")
    public SaResult login(@Valid @RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @SaCheckLogin
    @GetMapping("/user/isLogin")
    public SaResult isLogin() {
        String id = StpUtil.getLoginIdAsString();
        return SaResult.ok(id + " is login")
                .set("id", id);
    }

    @SaCheckLogin
    @GetMapping("/user/getLoginUsername")
    public SaResult getLoginUsername() {
        return userService.getLoginUsername();
    }

    @SaCheckLogin
    @GetMapping("/user/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok("success");
    }
}
