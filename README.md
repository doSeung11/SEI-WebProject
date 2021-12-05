# SEI-WebProject
### 소프트웨어공학개론 - 영화 예매 웹사이트 

---
## System Architecture
<img width="676" alt="스크린샷 2021-12-05 오후 10 26 16" src="https://user-images.githubusercontent.com/49158155/144748432-6256e8fd-4f65-4700-9211-0ef53560a7e1.png">


    Backend: Spring Boot
    Frontend: html, css, javascript
    etc: Tomcat, Amazon Web Service
---
## Class Architecture
<img width="1411" alt="스크린샷 2021-12-05 오후 10 34 27" src="https://user-images.githubusercontent.com/49158155/144748698-df5b941b-97c4-4298-9856-1acd64dbb1cf.png">

## Requirements
>jdk: 1.8.0이상, gradle: 7.2

## Installation
>### Clone Repository

    $git clone git@github.com:doSeung11/SEI-WebProject.git

>### Start
    $ cd SEI-WebProject
    $ ./gradlew build -x test 
    $ java jar
    $ sudo nohup java -jar build/libs/jarfile_name.jar &

    jarfile_name은 build/libs 안에 있는 jar file명으로 수정

>### Access
```
http://localhost:8080
```
---
## Features
1) 메인 페이지
<img width="772" alt="스크린샷 2021-12-05 오후 10 35 38" src="https://user-images.githubusercontent.com/49158155/144748741-f35ac683-c74d-491d-bd84-65493123d108.png">

<img width="772" alt="스크린샷 2021-12-05 오후 10 37 44" src="https://user-images.githubusercontent.com/49158155/144748812-152273fa-70e6-4bfb-a4db-a27f10dfdff7.png">
- 메인 페이지에서는 현재 상영중인 영화 목록을 확인 할 수 있다.

2) 영화 상세 정보 확인
<img width="770" alt="스크린샷 2021-12-05 오후 10 37 59" src="https://user-images.githubusercontent.com/49158155/144748819-de218ae6-0ba2-4198-b9a5-ed342e40e657.png">
- 상세 정보 페이지에서는 영화의 예고편, 해당 영화의 정보를 확인할 수 있다.

3) 영화 예매
<img width="791" alt="스크린샷 2021-12-05 오후 10 38 11" src="https://user-images.githubusercontent.com/49158155/144748822-00fbb4cd-cf95-4835-9841-6af3412720ff.png">
<img width="794" alt="스크린샷 2021-12-05 오후 10 38 22" src="https://user-images.githubusercontent.com/49158155/144748830-b480c7e5-5b84-4f0e-a47d-6adff7fe953d.png">

- 영화 예매 페이지에서는 비회원 방식으로 영화 예매를 진행할 수 있다.

4) 영화 예매 정보 확인
<img width="782" alt="스크린샷 2021-12-05 오후 10 38 36" src="https://user-images.githubusercontent.com/49158155/144748836-87f49912-47d1-4ae8-89cc-825b9b6bed8c.png">
- 영화 예매 확인 페이지에서는 영화 예매 정보를 확인하고 예매 취소를 할 수 있다.

---
## Reference
https://github.com/webstoryboy/megabox2019
https://github.com/loy124/CGV_Clone

---
## Members

|도승희|박지은|안도영|이진오|조영욱|
|---|---|---|---|---|
|[**@doSeung11**](https://github.com/doSeung11)|[**@jieun1128**](https://github.com/jieun1128)|[**@AhnDo0**](https://github.com/AhnDo0)|[**@choyeongwook**](https://github.com/choyeongwook)|[**@Ljinoh**](https://github.com/Ljinoh)

