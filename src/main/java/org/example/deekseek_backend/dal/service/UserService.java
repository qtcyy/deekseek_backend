package org.example.deekseek_backend.dal.service;

import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.vo.request.user.UserLoginRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chengyiyang
 */
public interface UserService {
    SaResult register(@Valid @RequestBody Users user);

    @Transactional(readOnly = true)
    SaResult checkUsername(String username);

    @Transactional(readOnly = true)
    SaResult checkPhone(String phone);

    @Transactional(readOnly = true)
    SaResult checkEmail(String email);

    @Transactional(readOnly = true)
    SaResult login(UserLoginRequest request);
}
