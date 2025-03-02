package org.example.deekseek_backend.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.util.SaResult;
import org.example.deekseek_backend.dal.service.ChatService;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateContentRequest;
import org.example.deekseek_backend.dal.vo.request.chat.UpdateNameRequest;
import org.example.deekseek_backend.dal.vo.request.chat.WriteHistoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author chengyiyang
 */
@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @SaCheckPermission("chat.read")
    @GetMapping("/history")
    public SaResult getHistory() {
        return chatService.getHistory();
    }

    @SaCheckPermission("chat.write")
    @PostMapping("/history/write")
    public SaResult writeHistory(@RequestBody WriteHistoryRequest request) {
        return chatService.writeHistory(request);
    }

    @SaCheckPermission("chat.write")
    @PostMapping("/history/update")
    public SaResult updateHistory(@RequestBody WriteHistoryRequest request) {
        return chatService.updateHistory(request);
    }

    @SaCheckPermission("chat.write")
    @PostMapping("/history/update/name")
    public SaResult updateHistoryName(@RequestBody UpdateNameRequest request) {
        return chatService.updateHistoryName(request);
    }

    @SaCheckPermission("chat.write")
    @PostMapping("/history/update/content")
    public SaResult updateHistoryContent(@RequestBody UpdateContentRequest request) {
        return chatService.updateHistoryContent(request);
    }

    @SaCheckPermission("chat.delete")
    @DeleteMapping("/history/delete/{id}")
    public SaResult deleteChat(@PathVariable String id) {
        return chatService.deleteChat(id);
    }
}
