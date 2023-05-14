# 당장마켓


### 신나고 즐거운 중고거래 생활


# 설명
교육과정에서 배운 React와 스프링 부트를 기반으로 해당 사이트들을 분석하여
구현해보고싶은 기능들을 벤치마킹하여 프로젝트에 구현하였다

## 사용기술 : 
    - FRONT : React, React-Router-Dom, Axios, HTML5, CSS3, Javascript, Visual Studio Code
    - COMMON : Spring Tool Suite 4
    - BACK : MySQL 8.028, JSTL 1.2, AJAX, Spring Security, Node.js, MyBatis 3.4.6, JAVA 11
    
## 프로젝트 기간 : 2022-03-21 ~ 2022-04-15
    - 리스트 무한스크롤 구현
    - 다중 이미지 파일 업로드 기능 구현
    - DROPZONE (이미지 끌어다 올리기) 기능 구현
    - 썸네일 기능 구현
    - 스프링 시큐리티 사용하여 암호화
    - 주소 api를 사용하여 회원가입시 실제 주소 입력
    
    
# ERD
![image](https://user-images.githubusercontent.com/95205529/165308411-201d5ee5-1828-45bf-80b2-d4c8f1996719.png)


# 실행화면

- 메인페이지

![image](https://user-images.githubusercontent.com/95205529/165308501-076cae72-2903-439d-aced-150455ff637f.png)

- 마켓페이지

![image](https://user-images.githubusercontent.com/95205529/165308570-48b0c069-0090-46cb-96de-a8781f613b8f.png)

- 게시글 작성페이지

![image](https://user-images.githubusercontent.com/95205529/165308683-9e10445c-2d1a-420b-8e98-48efd8545bbd.png)

- 게시글 상세보기 페이지

![image](https://user-images.githubusercontent.com/95205529/165308725-8806b60c-8914-4a36-b8f7-1f9f46e4daba.png)

- 내가 쓴 게시글 목록 페이지

![image](https://user-images.githubusercontent.com/95205529/165308820-866d38f3-ed47-49e5-a866-b40bd7c47cfb.png)

# 작업기록
- 여러분 형식을 정해서 리드미 파일에 기록을 남기는게 어떨까요

- [용환] .gitignore 추가(깃 크라켄에 잡다한 파일 stage되지 않게 수정) 22-03-29

- [혁주] 당장마켓 DB 생성 쿼리문 작성 #14 (21.03.27)
    당장마켓 DB 생성 쿼리문 작성 및 application properties mysql 경로 수정

- [혁주] 당장마켓 board 수정중 #15 (21.03.28)
    board.xml 작성
    board 관련 package 수정
    commonconst file upload 경로 수정
    application.properties 를 통한 url 경로 수정

- [혁주] 당장마켓 board controller #18 (21.03.29)
    boardController list/write/view/delete/update 작성
    board.xml 수정

- [정진] search package 작성(22.03.31 PM 3:50)
    SearchController list 작성
    search.xml 작성 및 수정, (팀원들의 검토 필요해요!)

- [혁주] 당장마켓 파일업로드 경로수정 #19 (22.03.30)
    application.properties 를 통한 파일업로드 경로 수정  
    board.xml 쿼리문 수정

- [용환] 당장마켓 왁자지껄 crud 구축 #20 (22.04.01)
    freeboardController list/write/view/delete/update 작성
    freeboard.xml 작성     
    
- [한우] qna 백앤드 crud 구축  

- [혁주] 당장마켓 수정 #22 (22.04.04)
    - zzim 관련 dao, impl, service, service impl, xml 생성
    - board 관련 업로드 문제 수정
- [혁주] 당장마켓 리스트 수정 삭제 기능 추가 #23 (22.04.07)
    - board dao, daoimpl, service, serviceimpl, xml, controller - totalCnt 부분 수정

- [용환] 당장마켓 왁자지껄 수정 #24 (22.04.09)
    -  board dao, daoimpl, service, serviceimpl, xml, controller 수정

- [혁주] board.xml 파일 수정 #26 (22.04.10)
    - 이미지 확대기능을 위한 board.xml 수정

- [혁주] 찜 기능 구현 중 및 테이블 명 수정 #27 (22.04.11)
    - 찜하기 찜 취소 구현 완료, 나라님이 변경하신 테이블 명세서대로 xml 파일 수정

- [혁주] 찜기능 구현 완료 #28 (22.04.12)
    - zzim.xml / controller, dao, daoImpl, service, serviceImpl 구현 완료

- [혁주] 깃 연동 오류 수정 #29 (22.04.12)
    - 스프링시큐리티 부분 오류 수정

- [혁주] 마이페이지 내 판매목록 구현 #30 (22.04.13)
    - board.xml 에서 쿼리문 수정

- [혁주] 로그인 세션 수정 #33 (22.04.14)
    - 세션에 user_seq도 저장될 수 있도록 수정

- [용환] 좋아요 구현, 댓글 수정중 #31 (22.04.14)
    - 좋아요, 좋아요취소 구현 완료, 댓글 

- [용환] 댓글 구현 #32 (22.04.15)
    - 댓글 구현 완료 

- [혁주] 찜기능 에러 수정 #35 (22.04.15)
    - 여러명 동시 찜하기 에러 수정 xml 파일 수정

- [용환] 좋아요, 왁자지껄 세션 수정 (22.04.16)
    - 왁자지껄 세션, 좋아요 수정
