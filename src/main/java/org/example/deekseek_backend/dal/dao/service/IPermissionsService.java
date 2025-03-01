package org.example.deekseek_backend.dal.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.deekseek_backend.dal.dao.entity.Permissions;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
public interface IPermissionsService extends IService<Permissions> {

    List<Permissions> getByNames(List<String> permissions);
}
