from flask import Flask, request, jsonify
import subprocess
import base64
import os

#모든 문제는 Python으로 해결되어야 합니다.
# 모든 문제는 단일 출력 문자열을 생성해야 합니다.
# 서버에서 직접 코드를 실행할 수 있습니다.

app = Flask(__name__)

@app.route('/submit', methods=['POST'])
def submit():
    # 사용자가 제출한 Base64 인코딩된 코드와 예상 출력값 받기
    code = request.json.get('code')
    code  = eval('f' + f'"{code}"')

    expected_output_str = request.json.get('output')
    filename = request.json.get('name')
    print(code,expected_output_str)

    current_directory = os.getcwd()

    # 상대 경로 설정
    relative_path = "UserAnswer"  # 현재 디렉토리 기준으로 UserAnswer 디렉토리
    filename = filename+"_usercode.py"
    file_path = os.path.join(current_directory, relative_path, filename)

    # 파일 저장
    with open(file_path, 'w') as f:
        f.write(code)

    # 테스트 케이스 실행하고 결과 확인하기
    try:
        output = subprocess.check_output(['python3', file_path], timeout=5)
        output = output.decode('utf-8')
        print(output)
        print(expected_output_str)

        if output == expected_output_str:
            return jsonify({"result": "Correct", "output": output})
        else:
            return jsonify({"result": "Incorrect", "output": output})

    except subprocess.TimeoutExpired:
        return jsonify({"error": "Time limit exceeded"})

@app.route('/addProblemRunCode', methods=['POST'])
def addProblemRunCode():
    # 사용자가 등록한 코드 받기
    code = request.json.get('code')

    # 코드를 .py 파일로 저장하기
    file_path = 'UserAnswer/problem_code.py'
    with open(file_path, 'w') as f:
        f.write(code)

    # 테스트 케이스 실행하고 결과 확인하기
    try:
        output = subprocess.check_output(['python3', file_path], timeout=5)
        output = output.decode('utf-8')

        # 파일 삭제하기
        if os.path.exists(file_path):
            os.remove(file_path)

        return output

    except subprocess.TimeoutExpired:
        return jsonify({"error": "Time limit exceeded"})

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=8065)