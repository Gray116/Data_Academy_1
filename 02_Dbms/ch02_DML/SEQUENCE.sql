--	1. SEQUENCE (시퀀스) : 순차 번호 생성기
--	 1) 대부분 인위적인 PK 사용 용도
--	 2) 테이블과 관계 없이 생성, 저장됨. 오라클 내부 루틴에 의해 발생되고 증가, 감소됨
DROP SEQUENCE FRIEND_SEQ;

CREATE SEQUENCE FRIEND_SEQ
	START WITH 1 -- 기본은 1
	INCREMENT BY 1 -- 기본은 1, 얼마씩 증가시키고 싶은지
	MAXVALUE 9999
	MINVALUE 1
	NOCACHE
	NOCYCLE;

CREATE SEQUENCE TEST_SEQ
	START WITH 100
	-- INCREMENT BY 1
	MAXVALUE 999999
	-- MINVALUE 1
	NOCACHE
	NOCYCLE;
SELECT TEST_SEQ.NEXTVAL FROM DUAL;
SELECT TEST_SEQ.CURRVAL FROM DUAL;
DROP SEQUENCE TEST_SEQ;

DROP TABLE FRIEND;

CREATE TABLE FRIEND (
	NUM NUMBER (4) PRIMARY KEY, -- 시퀀스
	NAME VARCHAR2 (30) NOT NULL,
	TEL VARCHAR2 (20) UNIQUE,
	ADDRESS VARCHAR2 (100),
	LAST_MODIFIED DATE DEFAULT SYSDATE
);

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
	VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', NULL, '서울시 마포구');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
	VALUES (FRIEND_SEQ.NEXTVAL, '홍길동', '010-9999-9999', '서울시 서대문구');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
	VALUES (FRIEND_SEQ.NEXTVAL, '문길동', '010-1344-8888', '고양시 일산동구');

INSERT INTO FRIEND (NUM, NAME, TEL, ADDRESS)
	VALUES (FRIEND_SEQ.NEXTVAL, '신길동', '010-1199-9499', '서울시 동작구');

SELECT *
	FROM FRIEND;

SELECT FRIEND_SEQ.CURRVAL -- 현재 시퀀스 값
	FROM DUAL;

COMMIT;

















































