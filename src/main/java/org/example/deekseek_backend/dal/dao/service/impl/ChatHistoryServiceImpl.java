package org.example.deekseek_backend.dal.dao.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.deekseek_backend.dal.dao.entity.ChatHistory;
import org.example.deekseek_backend.dal.dao.mapper.ChatHistoryMapper;
import org.example.deekseek_backend.dal.dao.service.IChatHistoryService;
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
public class ChatHistoryServiceImpl extends ServiceImpl<ChatHistoryMapper, ChatHistory> implements IChatHistoryService {

    @Override
    public List<ChatHistory> getChatHistoryByUserId(String userId) {
        LambdaQueryWrapper<ChatHistory> queryWrapper = new LambdaQueryWrapper<ChatHistory>();
        queryWrapper.eq(ChatHistory::getUserId, userId).orderByDesc(ChatHistory::getUpdateTime);

        return list(queryWrapper);
    }
}
