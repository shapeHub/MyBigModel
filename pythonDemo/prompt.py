# 写一个简单调用gpt的python代码
from openai import OpenAI
import os
from dotenv import load_dotenv
load_dotenv()
os.environ["http_proxy"] = "http://127.0.0.1:7897"
os.environ["https_proxy"] = "http://127.0.0.1:7898"
client = OpenAI()

message = [
    {"role": "system", "content": "You are a helpful assistant."},
    {"role": "user", "content": "Hello!"},
    {"role": "assistant", "content": "Hi there! How can I assist you today?"},
    {"role": "user", "content": "I'd like to book a flight."},
]

response = client.chat.completions.create(
    model="gpt-3.5-turbo",
    messages=message,
    temperature=0,
)


print(response.choices[0].message.content)

