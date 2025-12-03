package com.sofftekbackend.api.controller;
import com.sofftekbackend.api.service.GeminiChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


record ChatRequest(String message) {}
record ChatResponse(String response) {}


//controller do chat gemini
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private GeminiChatService geminiChatService;

    @PostMapping
    public ChatResponse conversarComIA(@RequestBody ChatRequest request) {
        String respostaDaIA = geminiChatService.gerarResposta(request.message());
        return new ChatResponse(respostaDaIA);
    }
}