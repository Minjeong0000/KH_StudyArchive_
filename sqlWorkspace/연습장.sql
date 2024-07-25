-- 연습장

-- MEMBER 테이블 생성 (아이디, 비밀번호, 닉네임)
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID      VARCHAR2(100)   NOT NULL UNIQUE
    , PWD   VARCHAR2(100)   NOT NULL
    , NICK  VARCHAR2(100)   UNIQUE
);

-- 회원 목록 조회
SELECT * FROM MEMBER;

-- 특정 회원 조회 (아이디로 조회)
SELECT * FROM MEMBER WHERE ID = 'USER01';

-- 특정 회원 조회 (닉네임으로 조회)

-- 회원가입
INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?);

-- 로그인
SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?;

-- 회원정보 수정 (비번 변경)
UPDATE MEMBER SET PWD = ? WHERE ID = ?;

-- 회원정보 수정 (닉네임 변경)


-- 회원 탈퇴
DELETE MEMBER WHERE ID = ?;


--------------------- 실습-----------------

-- BOARD 테이블 생성 (제목, 내용, 작성일시)
DROP TABLE BOARD CASCADE CONSTRAINTS;
CREATE TABLE BOARD(
    TITLE           VARCHAR2(100)       NOT NULL
    , CONTENT       VARCHAR2(4000)      NOT NULL
    , ENROLL_DATE   TIMESTAMP           DEFAULT SYSDATE
);

-- 게시글 목록 조회
SELECT * FROM BOARD;

-- 게시글 검색 (제목으로 검색)
SELECT * FROM BOARD WHERE TITLE LIKE '%?%';

-- 게시글 검색 (내용으로 검색)
SELECT * FROM BOARD WHERE CONTENT LIKE '%?%';

-- 게시글 작성
INSERT INTO BOARD(TITLE, CONTENT) VALUES(?, ?);

-- 게시글 수정 (내용 수정)
UPDATE BOARD SET CONTENT = ? WHERE TITLE = ?;

-- 게시글 삭제
DELETE BOARD WHERE TITLE = ?;








































