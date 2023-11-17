# 한밭대학교 컴퓨터공학과 EduBot팀
# Online_Judge_cap2

**팀 구성**
- 20181624 신희관 
- 20187098 이지형
- 20207131 조윤선

## <u>Teamate</u> Project Background
- ### 필요성
  - 학습에 어려움이 있는 학생들에게 개인별 맞춤형 학습 서비스를 제공함으로써 학습능력 향상
  - 학생이 원하면 언제든 시공간의 제약을 받지 않고 부족한 부분을 도움 받을 수 있도록 챗봇을 개발하여 학습 적응 지원
  - 프로그래밍은 이론도 중요하지만 그보다 더 중요한건 실습으로 배운걸 활용하는것이 매우 중요함.
- ### 기존 해결책의 문제점
  - 기존의 프로그래밍 언어 관련 수업에서는 학생 개개인의 역량과 이해도 차이로 인해 편차가 크게 발생하는 문제가 존재
  - 학생들을 지도할 때 1:1로 살피고 개별 피드백을 해주는 것이 중요하지만 현실적으로 어려움 이러한 문제를 해결하기위해 챗봇 개발을 목표로함
  - 챗봇으로 이론공부를 도와주었고, 학생들의 의견을 들었을때 실습환경이 부족하다는 피드백을 받았음
  
## System Design
  - ### System Requirements
    - 사용자가 챗봇에 파이썬 이론에 관한 질문을 하면 답변된 Q&A 데이터에서 적절한 답변을 추출 후 답변 
    - 모바일, 웹 환경 모두 챗봇 환경 지원
    - 파이썬 코딩 실습 환경 제공을 위한 온라인 저지 구축

  - ### Web System Architecture
  ![image01](https://github.com/HBNU-SWUNIV/come-capstone23-edubot/assets/52690408/628faea1-c0f2-4cf9-a609-44d634dfeb75)   

  - ### Web System Data Flow
  ![Web_system_flowchart](https://github.com/HBNU-SWUNIV/come-capstone23-edubot/assets/52690408/f4d5e774-1ff2-49dc-88ae-8e5ad390fc22)

## 💻 Tech Stack
<h4> Platforms & Languages </h4>

<div align="left">
	<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
    <img src="https://img.shields.io/badge/python-3776AB?style=for-the-badge&logo=python&logoColor=white">
    <img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white"> 
   <img src="https://img.shields.io/badge/css-155312?style=for-the-badge&logo=css&logoColor=white"> 
   <img src="https://img.shields.io/badge/javascript-678445?style=for-the-badge&logo=javascript&logoColor=white"> 
    <img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">
    <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
    <img src="https://img.shields.io/badge/fastapi-000000?style=for-the-badge&logo=fastapi&logoColor=white">\
   <img src="https://img.shields.io/badge/jpa-893462?style=for-the-badge&logo=jpa&logoColor=white">
    <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
	
</div>

<h4> Tools </h4>
<div align=left>
	<img src="https://img.shields.io/badge/Intellij%20IDE-000000?style=flat&logo=intellijidea&logoColor=white" />
	<img src="https://img.shields.io/badge/PyCharm-000000?style=flat-square&logo=PyCharm&logoColor=white"/>
    <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/>
	<img src="https://img.shields.io/badge/GitHub-181717?style=flat&logo=GitHub&logoColor=white" />
</div>
  
## Conclusion
  - 컴퓨터공학과 1학년 파이썬 수업에서 학생들에게 질문을 받아 답변해주며 5000개 이상의 Q&A 데이터를 확보하고 모델 학습에 사용함
  - 학생들은 시공간의 제약 없이 각자의 학습 속도와 이해 수준에 맞게 질문을 할 수 있게 되었고, 원하는 질문에 대한 답을 얻을 수 있게 되었음
  - 해당 챗봇 시스템은 프로그래밍 수업뿐만 아니라 다양한 학습 환경에서 유용하게 활용될 수 있음
  - 모바일, 웹 환경 모두 사용이 가능하며 웹에서는 간단한 온라인저지를 통해 간단한 코딩 실습 공간으로 이용 가능
  
## Project Outcome
- ### Web ChatRoom 
<img width="1107" alt="KakaoTalk_Photo_2023-10-25-16-42-20" src="https://github.com/HBNU-SWUNIV/come-capstone23-edubot/assets/124351914/eb7e4784-8b12-4389-bff1-894d8fcf6869">

- ### Web OnlineJudge
<img width="1109" alt="KakaoTalk_Photo_2023-10-25-16-42-13" src="https://github.com/HBNU-SWUNIV/come-capstone23-edubot/assets/124351914/0d2b8b07-4c57-404e-9f89-caa50bd59ddf">



## 개발과정

### 2학기 
	1학기 동안 서버를 운영하면서 수집한 학습데이터로 챗봇모델을 완성하였지만, 교육부분중 이론부분밖에 담당하지 못하였고 텔레그램이라는 모바일 틀 안에서는 원하는 실습환경을 구축할 수 없을 것 같아
 	웹으로 온라인저지를 구축하기로 하였다.
  	구축 목표 웹에는 챗봇을 활용한 파이썬 이론교육 채팅방, 온라인저지 기능을 활용한 파이썬 실습환경 구축이다.
 
### 채팅방 
	1학기때 학생들 상대로 질문을 학습시켜 만든 파이썬 모델을 사용하여 질문과 답변을 하는 채팅방

### 온라인저지 기능
	1. 문제 추가
	   ADD 버튼을 눌러 문제이름 ( 띄어쓰기 X ), 문제 코드, 문제 설명 정보를 입력한다
	   저장받은 이름, 코드를 데이터베이스에 넣고( 서버가 껏다가 켜져도 문제가 유지되게 )
	   입력받은 코드, 설명 정보를 python파일, txt파일로 생성한다.
	
	2. 문제 풀기
	   Test버튼을 눌러 문제의 설명과 출력값을 보고, 문제에 맞는 코드를 작성해 submit 버튼을 클릭하여 출력값이 같으면 correct, 오답시 incorrect 출력
	   Test버튼을 누르면 문제이름, 정보, 출력값이 나타나는데, 정보와 출력값은 txt파일로 생성되어있기때문에 값을 불러들여서 넣음
	   코드를 넣고 제출 버튼을 누르면 사용자가 입력한 코드가 py로 변환되고 결과값을 저장된 결과값과 비교한다. 비교후 같으면 correct 출력

## 막힌점

	프론트에서 입력받은 데이터를 데이터베이스에 저장하는건 쉽게 했지만,
	예외처리의 문제인지, 데이터베이스에 들어가는 Description의 양이 길어지면 Test버튼이 활성화가 되지않는 문제가 발생함
	데이터베이스를 사용하지 않아도 output 출력에 영향을 줘서 문제가 발생했음
	
	해결 : 데이터베이스에 Transient를 사용하여 Description을 저장하지않고, 텍스트파일로 남겨서 저장시킴
	
	아마 문자열 길이 255를 넘었기 때문이다. 생각보다 길었음

 ## 추가 개선안

기존의 온라인 저지 서버는 flask api 서버를 사용했는데, 이 방식보단 fast api (비동기 처리) 방식의 서버로 변환하여 조금 더 개선했다.

### 깃허브 공동작업 관리
여러명이 협업할때는 브랜치를 사용한다.
branch작업 -> master와 merge -> push순이다.

여러명이 작업하다 지맘대로 push하면 충돌이 일어남
branch에서 commit후 원래의 main과 합치고 푸시하기

## 작동방식

프론트에서  채팅방, 온라인저지 기능 사용가능

### 채팅방 
1학기때 학생들상대로 질문을 수집하여 만든 파이썬 모델을 사용하여 질문과 답변을 하는 채팅방

### 온라인저지 기능
1. 문제 추가
   ADD 버튼을 눌러 문제이름 ( 띄어쓰기 X ), 문제 코드, 문제 설명 정보를 입력한다
   저장받은 이름, 코드를 데이터베이스에 넣고( 서버가 껏다가 켜져도 문제가 유지되게 )
   입력받은 코드, 설명 정보를 python파일, txt파일로 생성한다.

2. 문제 풀기
   Test버튼을 눌러 문제의 설명과 출력값을 보고, 문제에 맞는 코드를 작성해 submit 버튼을 클릭하여 출력값이 같으면 correct, 오답시 incorrect 출력
   Test버튼을 누르면 문제이름, 정보, 출력값이 나타나는데, 정보와 출력값은 txt파일로 생성되어있기때문에 값을 불러들여서 넣음
   코드를 넣고 제출 버튼을 누르면 사용자가 입력한 코드가 py로 변환되고 결과값을 저장된 결과값과 비교한다. 비교후 같으면 correct 출력
   

### OnlineJudge 칭따오 오픈소스

oj-backend - 웹 서버의 소스코드 형태, 변경시 사용자가 온라인 시스템을 변경 가능
judge-server - api형태로 작동, 채점을 맡길때만 사용
나머지 두개 상관 없음

## 도커
리눅스 컨테이너를 기반으로 하여 특정한 서비스를 패키징하고 배포하는데 유용한 오픈소스 프로그램이다.

컨테이너에 이미지를 담아서 구동시키는 방식으로 손쉽게 배포함

도커는 변경 불가능한 인프라를 주요 패러다임으로 상정한다.
그렇다면 서버에 문제가 생겨서 업데이트를 해야 되는 경우는 그냥 삭제한다.
서버를 업데이트할 때는 새운 도커 이미지 자체를 업데이트해서 그냥 컨테이너에 올린다. 기존에 돌아가던 컨테이너는 완전히 제거된다.

DockerFile : DockerFile은 Docker 이미지를 생성하는 방법을 정의한 스크립트 파일, 이 파일에는 기본 이미지 설정, 필요한 소프트웨어 설치 명령 및 애플리케이션 구동 명령 등이 포함됨

DockerImage : DockerImage는 응용 프로그램과 그 응용 프로그램의 종속성을 패키징하는 데 사용되는 가볍고 독립적인 구조, 이것은 코드, 런타임, 도구, 라이브러리 등 모든 것을 포함한다.

DockerContainer : DockerContainer은 DockerImage를 기반으로 실행되며, 격리된 공간에서 애플리케이션의 실행 환경을 제공한다. 각 컨테이너는 서로 분리되어 있으며 하나의 시스템에서 여러 개의 컨테이너를 동시에 실행 가능

DockerHub : Docker Hub는 Docker Image를 공유하기 위한 클라우드 기반 저장소 서비스, 여기서 다양한 오픈 소스 및 상용 Docker 이미지를 찾아 사용 가능

운영 방식
         build           run 
Dockerfile -> DockerImage -> Docker Container

도커 사용법
    기본 명령어
    docker pull [image_name] : 지정된 이름의 이미지를 다운로드
    docker run [image_name] : 지정된 이름의 이미지를 기반으로 새로운 컨테이너를 생성하고 실행한다.
    docker ps : 현재 실행중인 컨테이너의 목록을 보여준다
    docker stop [container_id] : 지정된 ID의 컨테이너를 정지한다.

    Docker Hub 사용
    docker push [your_image_name] 명령어를 사용하여 자신의 이미지를 Docker Hub에 업로드


### 도커 m1

Dokcer Desktop for Apple silicon 설치 -> docker 애플리케이션 실행하면 docker engine 작동
    테스트 : docker run -it -p 포트번호 : 번호 nginx

참고용 : https://www.lainyzine.com/ko/article/how-to-install-docker-for-m1-apple-silicon/


### 스프링
@Controller: 전통적인 스프링 웹 애플리케이션에서 사용되며 HTML 뷰를 렌더링하고 데이터를 화면에 전달

@RestController: RESTful 웹 서비스에서 사용되며 JSON 또는 XML 형식의 데이터를 반환하고 외부 시스템과의 API 통신에 사용, 뷰 템플릿 없이 데이터만 반환


### 온라인 저지
아직 예외처리해야할 부분이 좀 더 개선사항으로 남았음
간단한 코드는 가능하지만 좀더 복잡하고 여러 특수문자를 사용하면 에러가 발생함 

