package org.example.deekseek_backend.dal.service;

import cn.dev33.satoken.util.SaResult;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateContentRequest;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateNameRequest;
import org.example.deekseek_backend.dal.vo.request.chat.WriteHistoryRequest;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengyiyang
 */
public interface ChatService {
    SaResult getHistory();

    @Transactional
    SaResult writeHistory(WriteHistoryRequest request);

    @Transactional
    SaResult updateHistoryName(UpdateNameRequest request);

    @Transactional
    SaResult updateHistory(WriteHistoryRequest request);

    @Transactional
    SaResult updateHistoryContent(UpdateContentRequest request);

    @Transactional
    SaResult deleteChat(String id);
}
