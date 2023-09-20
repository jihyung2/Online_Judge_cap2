from flask import Flask, request, jsonify
import subprocess
import os

#모든 문제는 Python으로 해결되어야 합니다.
# 모든 문제는 단일 출력 문자열을 생성해야 합니다.
# 서버에서 직접 코드를 실행할 수 있습니다.

app = Flask(__name__)

@app.route('/submit', methods=['POST'])
def submit():
    # 사용자가 제출한 코드 받기
    code = request.json.get('code')

    # 코드를 .py 파일로 저장하기
    with open('UserAnswer/user_code.py', 'w') as f:
        f.write(code)

    # 테스트 케이스 실행하고 결과 확인하기
    try:
        output = subprocess.check_output(['python3', 'UserAnswer/user_code.py'], timeout=5)
        output = output.decode('utf-8')

        expected_output = subprocess.check_output(['python3', 'Correct/correct1.py'])
        expected_output = expected_output.decode('utf-8')

        if output == expected_output:
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
    app.run(host='0.0.0.0', port=8090)