import os
import requests

# Step 1: Store your API key as an environment variable
os.environ["OPENAI_API_KEY"] = "25092cc469msh3cfd3ba967ac527p198060jsn84f661706744"

def generate_text(prompt, max_tokens=50, temperature=0.7):
    endpoint = "https://api.openai.com/v1/completions"
    headers = {
        "Content-Type": "application/json",
        "Authorization": f"Bearer {os.getenv('OPENAI_API_KEY')}"
    }
    data = {
        "prompt": prompt,
        "max_tokens": max_tokens,
        "temperature": temperature
    }
    response = requests.post(endpoint, json=data, headers=headers)
    if response.status_code == 200:
        return response.json()["choices"][0]["text"]
    else:
        print("Error:", response.status_code)
        return None

prompt = "Once upon a time"
generated_text = generate_text(prompt)
print(generated_text)

