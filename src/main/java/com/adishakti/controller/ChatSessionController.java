package com.adishakti.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adishakti.entity.ChatSession;
import com.adishakti.service.ChatSessionService;

@RestController
@CrossOrigin
@RequestMapping("/api/chatsessions")
public class ChatSessionController {
    @Autowired
    private ChatSessionService chatSessionService;

    @PostMapping("/addsession")
    public ChatSession createChatSession(@RequestBody ChatSession chatSession) {
        return chatSessionService.saveChatSession(chatSession);
    }
    
    @GetMapping("/getallsession")
    public List<ChatSession> getAllChatSessions() {
        return chatSessionService.getAllChatSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatSession> getChatSessionById(@PathVariable Long id) {
        Optional<ChatSession> chatSession = chatSessionService.getChatSessionById(id);
        return chatSession.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChatSession(@PathVariable Long id) {
        chatSessionService.deleteChatSession(id);
        return ResponseEntity.ok().build();
    }
}
