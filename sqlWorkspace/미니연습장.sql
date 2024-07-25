-- �̴Ͽ�����


-- ȸ������
INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES( SEQ_MEMBER_NO.NEXTVAL, ?, ?, ? );

-- �α���
SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?;

-- ���� ���� (��� ����)
UPDATE MEMBER SET PWD = ? WHERE NO = ?;

-- ���� ���� (�г��� ����)
UPDATE MEMBER SET NICK = ? WHERE NO = ?;

-- ȸ�� Ż��
UPDATE MEMBER SET QUIT_YN = 'Y' WHERE NO = ?;

-- ȸ�� ��ü ��� ��ȸ (������ ����)
SELECT * FROM MEMBER ORDER BY NO DESC;

-- ȸ�� �� ��ȸ (������ ����)
SELECT * FROM MEMBER WHERE NO = ?;

-- �Խñ� �ۼ�
INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL , ?, ?, ?);

-- �Խñ� ��� ��ȸ(�ֽż�)
SELECT 
    B.NO
    , B.TITLE
    , M.NICK
    , B.HIT
FROM BOARD B
JOIN MEMBER M ON B.WRITER_NO = M.NO
ORDER BY B.NO DESC
;

-- �Խñ� ��� ��ȸ(�����ȼ�)
SELECT * FROM BOARD ORDER BY NO ASC;

-- �Խñ� ��� ��ȸ(��ȸ�� ���� ��)
SELECT * FROM BOARD ORDER BY HIT DESC;

-- �Խñ� �� ��ȸ 
SELECT 
    B.NO
    , TITLE
    , CONTENT
    , HIT
    , NICK AS WRITER_NO
    , TO_CHAR(B.ENROLL_DATE , 'YYYY"��"MM"��"DD"��" HH24"��"MI"��"SS"��"') AS ENROLL_DATE
FROM BOARD B
JOIN MEMBER M ON B.WRITER_NO = M.NO
WHERE B.NO = ?
AND DEL_YN = 'N'
;

-- �Խñ� ��ȸ�� ����
UPDATE BOARD
    SET HIT = HIT+1
    WHERE NO = ?
;

-- �Խñ� �˻� (����)
SELECT * FROM BOARD WHERE TITLE LIKE '%?%';

-- �Խñ� �˻� (����)
SELECT * FROM BOARD WHERE CONTENT LIKE '%?%';

-- �Խñ� ���� (�ۼ��� �Ǵ� ������ �� ����)
UPDATE BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?;

-- �Խñ� ���� (�ۼ��� �Ǵ� ������ �� ����)
UPDATE BOARD SET DEL_YN = 'Y' , MODIFY_DATE = SYSDATE WHERE NO = ?;













