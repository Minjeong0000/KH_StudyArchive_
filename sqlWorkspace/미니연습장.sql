-- 미니연습장


-- 회원가입
INSERT INTO MEMBER(NO, ID, PWD, NICK) VALUES( SEQ_MEMBER_NO.NEXTVAL, ?, ?, ? );

-- 로그인
SELECT * FROM MEMBER WHERE ID = ? AND PWD = ?;

-- 정보 수정 (비번 변경)
UPDATE MEMBER SET PWD = ? WHERE NO = ?;

-- 정보 수정 (닉네임 변경)
UPDATE MEMBER SET NICK = ? WHERE NO = ?;

-- 회원 탈퇴
UPDATE MEMBER SET QUIT_YN = 'Y' WHERE NO = ?;

-- 회원 전체 목록 조회 (관리자 전용)
SELECT * FROM MEMBER ORDER BY NO DESC;

-- 회원 상세 조회 (관리자 전용)
SELECT * FROM MEMBER WHERE NO = ?;

-- 게시글 작성
INSERT INTO BOARD(NO, TITLE, CONTENT, WRITER_NO) VALUES(SEQ_BOARD_NO.NEXTVAL , ?, ?, ?);

-- 게시글 목록 조회(최신순)
SELECT 
    B.NO
    , B.TITLE
    , M.NICK
    , B.HIT
FROM BOARD B
JOIN MEMBER M ON B.WRITER_NO = M.NO
ORDER BY B.NO DESC
;

-- 게시글 목록 조회(오래된순)
SELECT * FROM BOARD ORDER BY NO ASC;

-- 게시글 목록 조회(조회수 높은 순)
SELECT * FROM BOARD ORDER BY HIT DESC;

-- 게시글 상세 조회 
SELECT 
    B.NO
    , TITLE
    , CONTENT
    , HIT
    , NICK AS WRITER_NO
    , TO_CHAR(B.ENROLL_DATE , 'YYYY"년"MM"월"DD"일" HH24"시"MI"분"SS"초"') AS ENROLL_DATE
FROM BOARD B
JOIN MEMBER M ON B.WRITER_NO = M.NO
WHERE B.NO = ?
AND DEL_YN = 'N'
;

-- 게시글 조회수 증가
UPDATE BOARD
    SET HIT = HIT+1
    WHERE NO = ?
;

-- 게시글 검색 (제목)
SELECT * FROM BOARD WHERE TITLE LIKE '%?%';

-- 게시글 검색 (내용)
SELECT * FROM BOARD WHERE CONTENT LIKE '%?%';

-- 게시글 수정 (작성자 또는 관리자 만 가능)
UPDATE BOARD SET TITLE = ? , CONTENT = ? , MODIFY_DATE = SYSDATE WHERE NO = ?;

-- 게시글 삭제 (작성자 또는 관리자 만 가능)
UPDATE BOARD SET DEL_YN = 'Y' , MODIFY_DATE = SYSDATE WHERE NO = ?;













