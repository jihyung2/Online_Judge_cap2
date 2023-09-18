import requests

# 서버 URL
url = "http://localhost:8090/submit"

# 제출할 코드
code = """
n = 5

star_pattern = ''

for i in range(n):
    star_pattern += (' ' * (n - i - 2) + '*' * (2 * i + 1)) + '\\n'

print(star_pattern)
"""

# POST 요청 보내기
response = requests.post(url, json={"code": code})

# 응답 출력하기
print(response.json())