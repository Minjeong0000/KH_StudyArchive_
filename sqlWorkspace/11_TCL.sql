-- TCL (COMMIT, ROLLBACK)

/*
    <TCL(Transaction Control Language)>
        트랜잭션을 제어하는 언어이다.
        
        * 트랜잭션
          - 하나의 논리적인 작업 단위를 트랜잭션이라고 한다.
            ATM에서 현금 출금
              1. 카드 삽입
              2. 메뉴 선택
              3. 금액 확인 및 인증
              4. 실제 계좌에서 금액만큼 차감
              5. 실제 현금 인출
              6. 완료
          - 각각의 작업들을 묶어서 하나의 작업 단위로 만들어 버리는 것을 트랜잭션이라고 한다.
          - 하나의 트랜잭션으로 이루어진 작업들은 반드시 한꺼번에 완료가 되어야 하며, 그렇지 않을 경우에는 한꺼번에 취소되어야 한다.
          - 데이터의 변경 사항(DML(INSERT, UPDATE, DELETE))들을 묶어서 하나에 트랜잭션에 담아 처리한다.
          - COMMIT(트랜잭션 종료 처리 후 저장), ROLLBACK(트랜잭션 취소), SAVEPOINT(임시저장)를 통해서 트랜잭션을 제어한다.
*/


DROP TABLE BOARD CASCADE CONSTRAINTS;
CREATE TABLE BOARD(
    TITLE       VARCHAR2(100)
    , CONTENT   VARCHAR2(4000)
);

INSERT INTO BOARD
(
    TITLE
    , CONTENT
)
VALUES
(
    '제목ㅋㅋㅋ'
    , '내용 ㅋㅋㅋ'
)
;

SELECT *
FROM BOARD;






















































