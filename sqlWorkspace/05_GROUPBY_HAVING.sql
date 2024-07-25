/*
    <GROUP BY>
        �׷� ������ ������ �� �ִ� ����
        ���� ���� ������ �ϳ��� �׷����� ��� ó���� �������� ����Ѵ�.
*/


-- ��ü �޿� ���� ��ȸ
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- �� �μ��� �޿� ���� ��ȸ
SELECT DEPT_CODE , SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- ��ü ��� �� ��ȸ
SELECT COUNT(*)
FROM EMPLOYEE
;

-- �� �μ��� ��� �� ��ȸ
SELECT DEPT_CODE , COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- �� �μ��� ���ʽ��� �޴� �����
SELECT DEPT_CODE , COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- �� ���޺� �޿� ��� ��ȸ
SELECT JOB_CODE , AVG(BONUS)
FROM EMPLOYEE
GROUP BY JOB_CODE
;

-- �μ��� �����, ���ʽ��� �޴� �����, �޿��� ��, ��� �޿�, �ְ� �޿�, ���� �޿� ��ȸ
SELECT DEPT_CODE AS "�μ� �ڵ�",
       COUNT(*) AS "�����",
       COUNT(BONUS) AS "���ʽ��� �޴� �����",
       TO_CHAR(SUM(SALARY), '99,999,999') AS "�޿��� ��",
       TO_CHAR(FLOOR(AVG(NVL(SALARY, 0))), '99,999,999') AS "��� �޿�",
       TO_CHAR(MAX(SALARY), '99,999,999') AS "�ְ� �޿�",
       TO_CHAR(MIN(SALARY), '99,999,999') AS "���� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE DESC NULLS LAST
;

-- ���� �� ����� ��ȸ
SELECT SUBSTR(EMP_NO, 8, 1) AS "���� �ڵ�",
       COUNT(*) AS "�����"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1)
ORDER BY "���� �ڵ�"
;

/*
    <HAVING>
        �׷쿡 ���� ������ ������ �� ����ϴ� ����(�ַ� �׷� �Լ��� ����� ������ �� ����)
    
    * ���� ����
        5: SELECT      ��ȸ�ϰ��� �ϴ� Į���� AS "��Ī" | ���� | �Լ���
        1: FROM        ��ȸ�ϰ��� �ϴ� ���̺��
        2: WHERE       ���ǽ�
        3: GROUP BY    �׷� ���ؿ� �ش��ϴ� Į���� | ���� | �Լ���
        4: HAVING      �׷쿡 ���� ���ǽ�
        6: ORDER BY    ���� ���ؿ� �ش��ϴ� Į���� | ��Ī | Į�� ����
*/


-- �� �μ��� ��� �޿� ��ȸ
SELECT 
    DEPT_CODE       �μ�
    , FLOOR(AVG(SALARY)) || '��'   "��� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
;

-- �μ��� ��� �޿��� 300���� �̻��� ��츸 ��ȸ
SELECT 
    DEPT_CODE       �μ�
    , FLOOR(AVG(SALARY)) || '��'   "��� �޿�"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000
;


-- ���޺� �� �޿��� ���� 10000000 �̻��� ���޵鸸 ��ȸ
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000
ORDER BY JOB_CODE;

-- �μ��� ���ʽ��� �޴� ����� ���� �μ��鸸 ��ȸ
SELECT DEPT_CODE, COUNT(BONUS)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0
ORDER BY DEPT_CODE;

-- ���ʽ��� ���� �ʴ� ������� �������
-- �μ��� ��� �޿��� ��ȸ
-- (����޿��� 300���� �̻��� �μ��� ����)
-- (��ձ޿��� ���� ������� ����)

SELECT 
    DEPT_CODE 
    , FLOOR(AVG(SALARY)) ��ձ޿�
FROM EMPLOYEE
WHERE BONUS IS NULL
GROUP BY DEPT_CODE
HAVING AVG(SALARY) < 3000000
ORDER BY ��ձ޿� DESC
;



/*
    <���� �Լ�>
        �׷캰 ������ ��� ���� �߰� ���踦 ��� ���ִ� �Լ�
*/

-- ���޺� �޿��� �հ踦 ��ȸ
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

-- ������ �࿡ ��ü �� �޿��� �հ���� ��ȸ
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(JOB_CODE)
ORDER BY JOB_CODE;

SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(JOB_CODE)
ORDER BY JOB_CODE;

-- �μ� �ڵ嵵 ���� ���� �ڵ嵵 ���� ������� �׷� ��� �޿��� �հ踦 ��ȸ
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE, JOB_CODE;

-- ROLLUP(�÷� 1, �÷� 2, ...) -> �÷� 1�� ������ �߰����踦 ���� �Լ�
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY ROLLUP(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE, JOB_CODE;

-- CUBE(�÷� 1, �÷� 2, ...) -> �÷� 1�� ������ �߰����踦 ����, �÷� 2�� ������ �߰����踦 ����. ��, ���޵Ǵ� �÷� ��� �����ϴ� �Լ�
SELECT DEPT_CODE, JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY CUBE(DEPT_CODE, JOB_CODE)
ORDER BY DEPT_CODE, JOB_CODE;



/*
    <���� ������>
        ���� ���� �������� ������ �ϳ��� ���������� ����� �������̴�.
        
        UNION       : �� �������� ������ ������� ���� �� �ߺ��Ǵ� ���� �����Ѵ�. (������)
        UNION ALL   : UNION�� �����ϰ� �� �������� ������ ������� ���ϰ� �ߺ��� ����Ѵ�. (������)
        INTERSECT   : �� �������� ������ ������� �ߺ��� ������� �����Ѵ�. (������)
        MINUS       : ���� ������ ��������� ���� ������ ������� �� ������ ������� �����Ѵ�. (������)
*/

-- �μ��ڵ� D5 �� ����� ��ȸ --6��
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
;

-- �޿��� 300���� �ʰ��� ����� ��ȸ --8��
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
;

-- �μ��ڵ尡 D5�� ��� �Ǵ� �޿��� 300���� �ʰ��� ���
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID , EMP_NAME , DEPT_CODE , SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
;






























