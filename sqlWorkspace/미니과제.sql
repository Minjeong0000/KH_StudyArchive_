--------------------------------
---------- ������ ����-----------
--------------------------------
DROP SEQUENCE SEQ_MEMBER_NO;
DROP SEQUENCE SEQ_BOARD_NO;



--------------------------------
---------- ������ ���� ----------
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE NOCYCLE;
CREATE SEQUENCE SEQ_BOARD_NO NOCACHE NOCYCLE;---------
------------------------



--------------------------------
---------- ���̺� ���� -----------
--------------------------------
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE BOARD CASCADE CONSTRAINTS;



--------------------------------
---------- ���̺� ���� -----------
--------------------------------
CREATE TABLE MEMBER(
    NO              NUMBER          CONSTRAINT PK_MEMBER_NO PRIMARY KEY
    , ID            VARCHAR2(100)   CONSTRAINT NN_MEMBER_ID NOT NULL CONSTRAINT UQ_MEMBER_ID UNIQUE
    , PWD           VARCHAR2(100)   CONSTRAINT NN_MEMBER_PWD NOT NULL
    , NICK          VARCHAR2(100)   CONSTRAINT NN_MEMBER_NICK NOT NULL --�츮 ����Ʈ�� �г��� �ߺ��� ����Ұ���
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
---------- �ܷ�Ű �߰� -----------
--------------------------------
ALTER TABLE BOARD
ADD CONSTRAINT FK_BOARD_MEMBER
FOREIGN KEY (WRITER_NO) REFERENCES MEMBER(NO);







