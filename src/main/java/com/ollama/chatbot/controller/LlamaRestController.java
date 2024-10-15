package com.ollama.chatbot.controller;

import com.ollama.chatbot.response.LlamaResponse;
import com.ollama.chatbot.service.impl.LlamaAiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LlamaRestController {

    private final LlamaAiServiceImpl llamaService;

    @GetMapping("/api/v1/ai/generate")
    public ResponseEntity<LlamaResponse> generate(@RequestParam(value = "promptMessage") String promptMessage) {
        final LlamaResponse aiResponse = llamaService.generateMessage(promptMessage);
        return ResponseEntity.status(HttpStatus.OK).body(aiResponse);
    }
}
