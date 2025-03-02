package org.example.deekseek_backend.dal.dao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.deekseek_backend.dal.dao.entity.ChatHistory;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author qtcyy
 * @since 2025-02-28
 */
public interface IChatHistoryService extends IService<ChatHistory> {

    List<ChatHistory> getChatHistoryByUserId(String userId);
}
