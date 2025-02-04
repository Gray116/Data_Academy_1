-- �� ���⹮��
DROP TABLE CUSTOMER;
DROP TABLE CUS_LEVEL;
DROP SEQUENCE CUS_SQ;

CREATE SEQUENCE CUS_SQ
	NOCACHE
	NOCYCLE;

CREATE TABLE CUS_LEVEL (
	LEVELNO NUMBER (3) PRIMARY KEY,
	LEVELNAME VARCHAR (8) NOT NULL
);

INSERT INTO CUS_LEVEL
	VALUES (1, 'VVIP');

INSERT INTO CUS_LEVEL
	VALUES (2, 'VIP');

INSERT INTO CUS_LEVEL
	VALUES (3, 'NORMAL');

INSERT INTO CUS_LEVEL
	VALUES (4, 'BLACK');

SELECT *
	FROM CUS_LEVEL;

CREATE TABLE CUSTOMER (
	CNO NUMBER (3) PRIMARY KEY,
	CNAME VARCHAR (30) NOT NULL,
	JOINDATE DATE DEFAULT SYSDATE,
	PHONE VARCHAR2 (50) UNIQUE,
	POINT NUMBER (4) CHECK (POINT >= 0),
	LEVELNO NUMBER (3) REFERENCES CUS_LEVEL (LEVELNO)
);

SELECT *
	FROM CUSTOMER;

INSERT INTO CUSTOMER 
	VALUES (CUS_SQ.NEXTVAL, 'ȫ�浿', '21/06/10', '010-9999-9999', 0, 1);

INSERT INTO CUSTOMER (CNO, CNAME, JOINDATE, PHONE, LEVELNO)
	VALUES (CUS_SQ.NEXTVAL, '��ö��', '20/11/12', '010-8888-8888', 2);

UPDATE CUSTOMER
	SET POINT  = POINT + 300
	WHERE CNAME = 'ȫ�浿';

UPDATE CUSTOMER 
	SET JOINDATE = '16/09/06', PHONE  = '010-9999-9888'
	WHERE CNAME = '��ö��';

SELECT CNO, CNAME, TO_CHAR(JOINDATE, 'YYYY-MM-DD') JOINDATE, PHONE, POINT, LEVELNAME
	FROM CUSTOMER C, CUS_LEVEL L
	WHERE C.LEVELNO = L.LEVELNO;