# Online_Judge_cap2

oj-backend - 웹 서버의 소스코드 형태, 변경시 사용자가 온라인 시스템을 변경 가능
judge-server - api형태로 작동, 채점을 맡길때만 사용
나머지 두개 상관 없음

## 도커
리눅스 컨테이너를 기반으로 하여 특정한 서비스를 패키징하고 배포하는데 유용한 오픈소스 프로그램이다.

컨테이너에 이미지를 담아서 구동시키는 방식으로 손쉽게 배포함

도커는 변경 불가능한 인프라를 주요 패러다임으로 상정한다.
그렇다면 서버에 문제가 생겨서 업데이트를 해야 되는 경우는 그냥 삭제한다.
서버를 업데이트할 때는 새운 도커 이미지 자체를 업데이트해서 그냥 컨테이너에 올린다. 기존에 돌아가던 컨테이너는 완전히 제거된다.

운영 방식
         build           run 
Dockerfile -> DockerImage -> Docker Container


### 도커 m1

Dokcer Desktop for Apple silicon 설치 -> docker 애플리케이션 실행하면 docker engine 작동
    테스트 : docker run -it -p 포트번호 : 번호 nginx

docker-compose up -d : 한번에 여러개 

참고용 : https://www.lainyzine.com/ko/article/how-to-install-docker-for-m1-apple-silicon/