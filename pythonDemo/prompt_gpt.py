import openai

# 设置你的 OpenAI API 密钥
openai.api_key = "your-api-key"

# 调用 GPT 生成文本
def chat_with_gpt(prompt, model="gpt-3.5-turbo"):
    response = openai.ChatCompletion.create(
        model=model,
        messages=[{"role": "user", "content": prompt}]
    )
    return response["choices"][0]["message"]["content"]

# 示例使用
if __name__ == "__main__":
    user_input = input("请输入你的问题: ")
    response = chat_with_gpt(user_input)
    print("GPT 回复:", response)