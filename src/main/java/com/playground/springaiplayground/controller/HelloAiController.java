package com.playground.springaiplayground.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloAiController {

    private final ChatClient chatClient;

    public HelloAiController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/api/hello-ai")
    public String helloAi() {
        return chatClient.prompt()
                .user("Hello, what's spring Ai?")
                .call()
                .content();
    }
}