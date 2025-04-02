import os
from openai import OpenAI

client = OpenAI(
    # 若没有配置环境变量，请用百炼API Key将下行替换为：api_key="sk-xxx",  ##os.getenv("DASHSCOPE_API_KEY"), 
    api_key="sk-0a03b129a48d470892ae03c797d9d5ca",
    base_url="https://dashscope.aliyuncs.com/compatible-mode/v1",
)

def get_completion(prompt,model="qwen-plus"):
    completion = client.chat.completions.create(
    model = model, # 此处以qwen-plus为例，可按需更换模型名称。模型列表：https://help.aliyun.com/zh/model-studio/getting-started/models
    messages=[
        {'role': 'system', 'content': 'You are a helpful assistant.'},
        {'role': 'user', 'content': prompt}],
    )
    return completion.choices[0].message.content
# 示例使用
if __name__ == "__main__":
    model="qwen-plus"
    user_input = input("请输入你的问题: ")
    print("GPT 回复:", get_completion(user_input,model))    