package org.example.deekseek_backend.dal.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.deekseek_backend.dal.dao.entity.Users;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
public interface IUsersService extends IService<Users> {

    Users getUsersByInfo(String mergedInfo);

    boolean hasUsername(String username);

    boolean hasPhone(String phone);

    boolean hasEmail(String email);
}
