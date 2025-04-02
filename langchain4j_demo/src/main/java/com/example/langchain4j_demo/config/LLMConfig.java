package com.example.langchain4j_demo.config;

import com.example.langchain4j_demo.service.AiServices;
import com.example.langchain4j_demo.service.ChatAssistant;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiStreamingChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * ⼤模型配置
 *
 */
@Configuration(proxyBeanMethods = false)
public class LLMConfig {
    // 普通配置
    @Bean
    public ChatLanguageModel chatLanguageModel() {
        return OpenAiChatModel.builder()
                .apiKey("sk-0a03b129a48d470892ae03c797d9d5ca")
                .modelName("qwen-turbo")
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }

//    @Bean
//    public ChatAssistant chatAssistant(ChatLanguageModel chatLanguageModel) {
//        return AiServices.create(ChatAssistant.class, chatLanguageModel);
//    }

    @Bean
    public StreamingChatLanguageModel streamingChatLanguageModel(){
        return OpenAiStreamingChatModel.builder()
                .apiKey("sk-0a03b129a48d470892ae03c797d9d5ca")
                .modelName("qwen-turbo")
                .timeout(Duration.ofSeconds(10))
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .build();
    }
}
