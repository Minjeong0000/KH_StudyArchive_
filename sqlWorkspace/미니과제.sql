--------------------------------
---------- 시퀀스 삭제-----------
--------------------------------
DROP SEQUENCE SEQ_MEMBER_NO;
DROP SEQUENCE SEQ_BOARD_NO;



--------------------------------
---------- 시퀀스 생성 ----------
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;---------
------------------------



--------------------------------
---------- 테이블 삭제 -----------
--------------------------------
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;



--------------------------------
---------- 테이블 생성 -----------
--------------------------------
CREATE TABLE MEMBER(
    NO              NUMBER          CONSTRAINT PK_MEMBER_NO PRIMARY KEY
    , ID            VARCHAR2(100)   CONSTRAINT NN_MEMBER_ID NOT NULL CONSTRAINT UQ_MEMBER_ID UNIQUE
    , PWD           VARCHAR2(100)   CONSTRAINT NN_MEMBER_PWD NOT NULL
    , NICK          VARCHAR2(100)   CONSTRAINT NN_MEMBER_NICK NOT NULL --우리 사이트는 닉네임 중복은 허용할거임
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       
    , QUIT_YN       CHAR(1)         DEFAULT 'N' CONSTRAINT CK_MEMBER_QUIT CHECK( QUIT_YN IN ('Y','N')  )
);

CREATE TABLE BOARD(
    NO              NUMBER          PRIMARY KEY
    , TITLE         VARCHAR2(100)   NOT NULL
    , CONTENT       VARCHAR2(4000)  NOT NULL
    , WRITER_NO     NUMBER          NOT NULL
    , HIT           NUMBER          DEFAULT 0
    , ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
    , MODIFY_DATE   TIMESTAMP       
    , DEL_YN        CHAR(1)         DEFAULT 'N' CONSTRAINT CK_BOARD_DELYN CHECK( DEL_YN IN ('Y','N')  )
);



--------------------------------
---------- 외래키 추가 -----------
--------------------------------
ALTER TABLE BOARD
ADD CONSTRAINT FK_BOARD_MEMBER
FOREIGN KEY (WRITER_NO) REFERENCES MEMBER(NO);







