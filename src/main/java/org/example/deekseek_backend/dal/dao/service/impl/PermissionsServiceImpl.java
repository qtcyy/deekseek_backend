package org.example.deekseek_backend.dal.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.deekseek_backend.dal.dao.entity.Permissions;
import org.example.deekseek_backend.dal.dao.mapper.PermissionsMapper;
import org.example.deekseek_backend.dal.dao.service.IPermissionsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements IPermissionsService {

    @Override
    public List<Permissions> getByNames(List<String> permissions) {
        LambdaQueryWrapper<Permissions> permissionsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        permissionsLambdaQueryWrapper.in(Permissions::getPermission, permissions);

        return list(permissionsLambdaQueryWrapper);
    }
}
