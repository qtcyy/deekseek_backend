package org.example.deekseek_backend.dal.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.example.deekseek_backend.common.BaseContext;
import org.example.deekseek_backend.dal.dao.entity.ChatHistory;
import org.example.deekseek_backend.dal.dao.service.IChatHistoryService;
import org.example.deekseek_backend.dal.service.ChatService;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateContentRequest;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateNameRequest;
import org.example.deekseek_backend.dal.vo.request.chat.WriteHistoryRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chengyiyang
 */
@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private IChatHistoryService chatHistoryService;

    @Transactional(readOnly = true)
    @Override
    public SaResult getHistory() {
        try {
            String userId = StpUtil.getLoginIdAsString();
            List<ChatHistory> chatHistoryList = chatHistoryService.getChatHistoryByUserId(userId);

            return SaResult.ok("success")
                    .setData(chatHistoryList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SaResult writeHistory(WriteHistoryRequest request) {
        String userId = StpUtil.getLoginIdAsString();
        BaseContext.setCurrentId(userId);
        try {
            ChatHistory chatHistory = new ChatHistory();
            BeanUtils.copyProperties(request, chatHistory);
            chatHistory.setUserId(userId);

            chatHistoryService.save(chatHistory);

            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SaResult updateHistoryName(UpdateNameRequest request) {
        String userId = StpUtil.getLoginIdAsString();
        BaseContext.setCurrentId(userId);
        try {
            ChatHistory chatHistory = chatHistoryService.getById(request.getId());
            chatHistory.setName(request.getName());

            chatHistoryService.updateById(chatHistory);

            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SaResult updateHistory(WriteHistoryRequest request) {
        String userId = StpUtil.getLoginIdAsString();
        BaseContext.setCurrentId(userId);
        System.out.println(request);
        try {
            ChatHistory chatHistory = new ChatHistory();
            BeanUtils.copyProperties(request, chatHistory);

            chatHistory.setUserId(userId);
            chatHistoryService.updateById(chatHistory);
            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SaResult updateHistoryContent(UpdateContentRequest request) {
        String userId = StpUtil.getLoginIdAsString();
        BaseContext.setCurrentId(userId);
        System.out.println(request);
        try {
            String id = request.getId();
            ChatHistory chatHistory = chatHistoryService.getById(id);
            chatHistory.setContent(request.getContent());

            chatHistoryService.updateById(chatHistory);

            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    @Override
    public SaResult deleteChat(String id) {
        String userId = StpUtil.getLoginIdAsString();
        BaseContext.setCurrentId(userId);
        try {
            chatHistoryService.removeById(id);

            return SaResult.ok("success");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
