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


