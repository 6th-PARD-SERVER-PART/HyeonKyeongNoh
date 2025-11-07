1. 자료형 (Data Types)
   숫자형 (Numeric)
   INTEGER (INT): 정수 저장 (예: 직원 수, 부서 번호)

SMALLINT: INTEGER보다 작은 범위의 정수

DECIMAL(i, j) (NUMERIC, DEC): 고정 소수점 숫자 (총 i자리 중 소수점 아래 j자리)

예: DECIMAL(10,2)는 총 10자리, 소수점 아래 2자리 (급여 등)

Oracle에서는 NUMBER 사용 가능

FLOAT (REAL, DOUBLE PRECISION): 부동 소수점 숫자

문자열형 (Character String)
CHAR(n) (CHARACTER(n)): 고정 길이 n의 문자열. n보다 짧으면 공백으로 채움 (예: 주민번호 CHAR(9))

VARCHAR(n) (CHARACTER VARYING(n)): 최대 길이 n의 가변 길이 문자열 (예: 이름 VARCHAR(15), 주소 VARCHAR(30))

Oracle에서는 VARCHAR2(n) 사용

CLOB (CHARACTER LARGE OBJECT): 매우 큰 텍스트 데이터 (예: CLOB(20M)은 최대 20MB 문서)

날짜/시간형 (Date/Time)
DATE: 날짜 'YYYY-MM-DD' (년, 월, 일)

TIME: 시간 'HH:MM:SS' (시, 분, 초)

TIMESTAMP: 날짜와 시간을 함께 저장 (초의 소수점 이하 포함)

2. SQL 기본 구조 및 명령어
   기본 쿼리 구조 (SELECT)
   SQL

SELECT <attribute list>
FROM <relation list>
[ WHERE <condition> ]         -- 집계 전 조건
[ GROUP BY <attribute list> ] -- 그룹화
[ HAVING <condition> ]        -- 집계 후 조건
[ ORDER BY <attribute list> [DESC | ASC] ]; -- 정렬 (기본 ASC)
데이터 조작 (DML) & 정의 (DDL) 예시
UPDATE:

SQL

UPDATE PROJECT p SET p.Plocation = 'Bellaire', p.Dnum = 5 WHERE p.Pnumber = 10;
DELETE:

SQL

DELETE FROM EMPLOYEE WHERE Dno = 5;
-- WHERE절 생략 시 테이블 전체 데이터 삭제
CREATE TABLE LIKE (테이블 구조 및 데이터 복사):

SQL

CREATE TABLE DSEMPS LIKE EMPLOYEE (SELECT E.* FROM EMPLOYEE E WHERE E.Dno=5) WITH DATA;
3. 연산자 (Operators)
   집합 연산자 (Set Operators)
   UNION: 합집합 (중복 제거)

UNION ALL: 합집합 (중복 포함)

EXCEPT (MINUS): 차집합 (첫 번째 쿼리 결과에서 두 번째 쿼리 결과 제거)

INTERSECT: 교집합 (공통된 결과만)

논리 연산자 (Logical Operators)
AND: 둘 다 TRUE일 때만 TRUE (하나라도 FALSE면 FALSE, 그 외 UNKNOWN)

OR: 하나라도 TRUE면 TRUE (둘 다 FALSE일 때만 FALSE, 그 외 UNKNOWN)

NOT: TRUE ↔ FALSE 반전 (UNKNOWN은 그대로 UNKNOWN)

비교 및 기타 연산자
LIKE: 패턴 매칭

%: 0개 이상의 문자열 (예: 'Houston, TX%')

_: 정확히 1개의 문자 (예: '199_-_-_-__')

이스케이프 문자: %나 _ 자체를 검색할 때는 앞에 역슬래시(\) 사용

IN: 목록 중 하나와 일치 (예: IN (1, 2, 3))

IS NULL / IS NOT NULL: NULL 값 확인

CASE WHEN: 조건에 따른 분기 처리 (IF-THEN-ELSE와 유사)

SQL

CASE WHEN 조건 THEN 결과 ELSE 다른결과 END
4. 조인 및 하위 쿼리 (Joins & Subqueries)
   조인 (JOIN)
   NATURAL JOIN: 이름이 같은 모든 속성을 기준으로 자동 조인

OUTER JOIN (LEFT/RIGHT/FULL): 조인 조건(ON)에 일치하지 않는 튜플도 결과에 포함 (NULL로 채움)

하위 쿼리 (Subquery)
IN (Subquery): 하위 쿼리 결과 집합에 값이 존재하는지 확인

NOT EXISTS: 하위 쿼리 결과가 하나도 없으면 TRUE

Correlated Nested Query: 메인 쿼리의 값을 하위 쿼리에서 참조하는 상호 연관 쿼리

ALL: 하위 쿼리의 모든 값과 비교

5. 뷰 (View) 및 기타 객체
   뷰 (View)
   개념: 가상의 테이블. DBMS가 최신 상태(up-to-date)를 유지할 책임이 있음.

구현 방식:

Query Modification: 필요할 때마다 뷰 정의를 원본 쿼리와 결합하여 실행

View Materialization: 실제 임시 테이블로 생성 (업데이트 방식: Immediate, Lazy, Periodic)

업데이트 제한: 여러 테이블 조인, 집계 함수 등이 포함된 뷰는 원본의 어떤 부분을 수정해야 할지 모호하여 업데이트가 불가능한 경우가 많음. (단일 테이블 참조 시 가능)

기타
DROP 옵션:

CASCADE: 연쇄 삭제 (해당 객체를 참조하는 다른 객체도 함께 삭제)

RESTRICT: 참조하는 객체가 있으면 삭제 취소

WITH 절: 쿼리 실행 동안만 존재하는 임시 테이블(CTE) 생성 (뷰와 유사하지만 일회성)

집계 함수: SUM(), MAX(), MIN(), AVG(), COUNT() (주로 GROUP BY와 함께 사용)