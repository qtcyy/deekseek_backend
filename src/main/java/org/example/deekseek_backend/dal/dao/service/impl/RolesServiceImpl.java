package org.example.deekseek_backend.dal.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.deekseek_backend.dal.dao.entity.Roles;
import org.example.deekseek_backend.dal.dao.mapper.RolesMapper;
import org.example.deekseek_backend.dal.dao.service.IRolesService;
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
public class RolesServiceImpl extends ServiceImpl<RolesMapper, Roles> implements IRolesService {
    @Override
    public String getIdByName(String role) {
        LambdaQueryWrapper<Roles> rolesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        rolesLambdaQueryWrapper.eq(Roles::getRole, role);

        return getOne(rolesLambdaQueryWrapper).getId();
    }
}
