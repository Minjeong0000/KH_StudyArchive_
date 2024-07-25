---------- MEMBER ----------
-- JOIN
INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES(SEQ_MEMBER.NEXTVAL , ?, ?, ?);
ROLLBACK;

-- LOGIN
SELECT * FROM MEMBER WHERE ID = ? AND PWD = ? AND DEL_YN = 'N';

-- EDIT
UPDATE MEMBER SET PWD = ? WHERE NO = ?;
ROLLBACK;

-- QUIT
UPDATE MEMBER SET DEL_YN = ? WHERE NO = ?;
ROLLBACK;


---------- BOARD ----------
-- INSERT
INSERT INTO BOARD(NO, TITLE, CONTENT, CATEGORY_NO, WRITER_NO) VALUES(SEQ_BOARD.NEXTVAL, ?, ?, ?, ?);
ROLLBACK;

-- SELECT LIST
-- SELECT * FROM BOARD WHERE DEL_YN = 'N';
SELECT * FROM 
(
  SELECT 
    ROWNUM AS RNUM
    , T.*
  FROM 
  (
    SELECT *
    FROM BOARD B
    JOIN CATEGORY C ON B.CATEGORY_NO = C.NO
    JOIN MEMBER M ON B.WRITER_NO = M.NO
    WHERE B.DEL_YN = 'N'
    ORDER BY B.NO DESC
  ) T
) 
WHERE RNUM BETWEEN 11 AND 20;


-- SELECT BOARD BY NO
SELECT 
    B.NO
    , B.TITLE
    , B.CONTENT
    , B.CATEGORY_NO
    , C.NAME
    , B.WRITER_NO
    , M.NICK
    , B.HIT
    , B.CREATE_DATE
FROM BOARD B
JOIN MEMBER M ON B.WRITER_NO = M.NO
JOIN CATEGORY C ON B.CATEGORY_NO = C.NO
WHERE B.NO = 5 
AND B.DEL_YN = 'N'
;


-- 게시글 삭제 (여러개)
UPDATE BOARD
    SET
        DEL_YN = 'Y'
    WHERE NO IN (?,?,?, ...)
;
ROLLBACK;


-- 댓글 작성
INSERT INTO BOARD_REPLY
(
    NO          
    ,CONTENT
    ,REF_NO
    ,WRITER_NO
)
VALUES
(
    SEQ_BOARD_REPLY.NEXTVAL          
    , ?
    , ?
    , ?
)
;

-- 댓글 목록 조회
SELECT 
    R.NO
    ,R.CONTENT
    ,R.REF_NO
    ,R.WRITER_NO
    ,R.CREATE_DATE
    ,R.DEL_YN
    ,M.NICK AS WRITER_NICK
FROM BOARD_REPLY R
JOIN MEMBER M ON R.WRITER_NO = M.NO
WHERE R.REF_NO = ?
AND R.DEL_YN = 'N'
ORDER BY R.NO DESC
;

-- 댓글 수정

-- 댓글 삭제



-- 공지사항 작성
INSERT INTO NOTICE 
(
    NO
    ,TITLE
    ,CONTENT
    ,WRITER_NO
) 
VALUES 
(
    SEQ_NOTICE.NEXTVAL
    , '공지사항제목ㅋㅋㅋ'
    , '공지내용ㅎㅎㅎ'
    , 1
)
;
COMMIT;


-- 공지사항 목록 조회
SELECT
    N.NO
    ,N.TITLE
    ,N.CONTENT
    ,N.WRITER_NO
    ,N.HIT
    ,N.CREATE_DATE
    ,N.DEL_YN
    ,A.NICK AS WRITER_NICK
FROM NOTICE N
JOIN ADMIN A ON N.WRITER_NO = A.NO
WHERE N.DEL_YN = 'N'
;


-- 공지사항 상세 조회
SELECT
    N.NO
    ,N.TITLE
    ,N.CONTENT
    ,N.WRITER_NO
    ,N.HIT
    ,N.CREATE_DATE
    ,N.DEL_YN
    ,A.NICK AS WRITER_NICK
FROM NOTICE N
JOIN ADMIN A ON N.WRITER_NO = A.NO
WHERE N.NO = 1
AND N.DEL_YN = 'N'
;


-- 공지사항 수정


-- 공지사항 삭제































SELECT 
			COUNT(NO)
		FROM NOTICE
		WHERE DEL_YN = 'N'