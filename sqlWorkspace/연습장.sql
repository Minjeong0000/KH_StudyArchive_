-- ������

-- MEMBER ���̺� ���� (���̵�, ��й�ȣ, �г���)
DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID      VARCHAR2(100)   NOT NULL UNIQUE
    , PWD   VARCHAR2(100)   NOT NULL
    , NICK  VARCHAR2(100)   UNIQUE
);

-- ȸ�� ��� ��ȸ
SELECT * FROM MEMBER;

-- Ư�� ȸ�� ��ȸ (���̵�� ��ȸ)
SELECT * FROM MEMBER WHERE ID = 'USER01';

-- Ư�� ȸ�� ��ȸ (�г������� ��ȸ)

-- ȸ������
INSERT INTO MEMBER(ID, PWD, NICK) VALUES(?, ?, ?);

-- �α���
SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?;

-- ȸ������ ���� (��� ����)
UPDATE MEMBER SET PWD = ? WHERE ID = ?;

-- ȸ������ ���� (�г��� ����)


-- ȸ�� Ż��
DELETE MEMBER WHERE ID = ?;


--------------------- �ǽ�-----------------

-- BOARD ���̺� ���� (����, ����, �ۼ��Ͻ�)
DROP TABLE BOARD CASCADE CONSTRAINTS;
CREATE TABLE BOARD(
    TITLE           VARCHAR2(100)       NOT NULL
    , CONTENT       VARCHAR2(4000)      NOT NULL
    , ENROLL_DATE   TIMESTAMP           DEFAULT SYSDATE
);

-- �Խñ� ��� ��ȸ
SELECT * FROM BOARD;

-- �Խñ� �˻� (�������� �˻�)
SELECT * FROM BOARD WHERE TITLE LIKE '%?%';

-- �Խñ� �˻� (�������� �˻�)
SELECT * FROM BOARD WHERE CONTENT LIKE '%?%';

-- �Խñ� �ۼ�
INSERT INTO BOARD(TITLE, CONTENT) VALUES(?, ?);

-- �Խñ� ���� (���� ����)
UPDATE BOARD SET CONTENT = ? WHERE TITLE = ?;

-- �Խñ� ����
DELETE BOARD WHERE TITLE = ?;








































