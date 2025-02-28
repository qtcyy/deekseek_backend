package org.example.deekseek_backend.dal.dao.service.impl;

import org.example.deekseek_backend.dal.dao.entity.Messages;
import org.example.deekseek_backend.dal.dao.mapper.MessagesMapper;
import org.example.deekseek_backend.dal.dao.service.IMessagesService;
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
public class MessagesServiceImpl extends ServiceImpl<MessagesMapper, Messages> implements IMessagesService {

}
