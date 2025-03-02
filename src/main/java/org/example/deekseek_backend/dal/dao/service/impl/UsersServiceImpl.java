package org.example.deekseek_backend.dal.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.deekseek_backend.dal.dao.entity.Users;
import org.example.deekseek_backend.dal.dao.mapper.UsersMapper;
import org.example.deekseek_backend.dal.dao.service.IUsersService;
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
    @Override
    public Users getUsersByInfo(String mergedInfo) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, mergedInfo)
                .or().eq(Users::getEmail, mergedInfo)
                .or().eq(Users::getPhone, mergedInfo)
                .last("limit 1");
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean hasUsername(String username) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getUsername, username);

        return this.count(queryWrapper) > 0;
    }

    @Override
    public boolean hasPhone(String phone) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getPhone, phone);

        return this.count(queryWrapper) > 0;
    }

    @Override
    public boolean hasEmail(String email) {
        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Users::getEmail, email);

        return this.count(queryWrapper) > 0;
    }
}
