package org.example.deekseek_backend.dal.dao.service.impl;

import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.dao.mapper.UsersMapper;
import org.example.deekseek_backend.dal.dao.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

}
