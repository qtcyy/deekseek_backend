package org.example.deekseek_backend.dal.service;

import cn.dev33.satoken.util.SaResult;
import jakarta.validation.Valid;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author chengyiyang
 */
public interface UserService {
    SaResult register(@Valid @RequestBody Users user);
}
