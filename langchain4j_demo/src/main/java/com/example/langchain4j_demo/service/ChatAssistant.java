package com.example.langchain4j_demo.service;

/**
 * 聊天助⼿
 *
 */
public interface ChatAssistant {
    /**
     * 聊天
     *
     * @param message 消息
     * @return {@link String }
     */
    String chat(String message);
}
