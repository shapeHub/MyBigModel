package com.example.langchain4j_demo;

import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.chat.response.StreamingChatResponseHandler;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.openai.OpenAiImageModel;
import dev.langchain4j.model.output.Response;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Langchain4jDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ChatLanguageModel chatLanguageModel;

    @Test
    void test1() {
        String generate = chatLanguageModel.chat("你好");
        System.out.println(generate);
    }

    @Autowired
    private StreamingChatLanguageModel streamingChatLanguageModel;

    @Test
    void streamingChatLanguageModelTest() {
        StreamingChatResponseHandler responseHandler = new StreamingChatResponseHandler() {
            @Override
            public void onPartialResponse(String token) {
                // 处理接收到的消息
                System.out.println("处理接收到的消息" + token);
            }

            @Override
            public void onCompleteResponse(ChatResponse chatResponse) {
                // 处理完成时的逻辑
                System.out.println("响应处理完成");
            }

            @Override
            public void onError(Throwable error) {
                // 处理错误情况
                System.err.println("发⽣错误: " + error.getMessage());
            }
        };
        streamingChatLanguageModel.chat("背诵出师表", responseHandler);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    //OpenAi的模型
    @Test
    void test3() {
        String generate = openAiChatModel.chat("你是什么模型");
        System.out.println(generate);
    }
    @Test
    void test4() {
        OpenAiImageModel openAiImageModel = OpenAiImageModel.builder()
                .apiKey("sk-0a03b129a48d470892ae03c797d9d5ca")
                .modelName("wanx2.1-t2i-plus")

                .build();
        Response<Image> response =  openAiImageModel.generate("一张猫的图片");
        System.out.println(response.content().url());
    }
}
