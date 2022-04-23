﻿CREATE DATABASE MANAGE_COFFEE_STORE;

USE MANAGE_COFFEE_STORE;

--CREATE TABLES

CREATE TABLE CLASSIFY (
	CLASSIFY_ID CHAR(5) NOT NULL,
	CLASSIFY_NAME VARCHAR(50) NOT NULL
)

ALTER TABLE CLASSIFY ADD CLASSIFY_BUSINESS BIT;
ALTER TABLE CLASSIFY ADD CONSTRAINT C_CLASSIFY_ID_PK PRIMARY KEY (CLASSIFY_ID);

CREATE TABLE PRODUCT (
	CLASSIFY_ID CHAR(5) NOT NULL,
	PRODUCT_ID CHAR(5) NOT NULL,
	PRODUCT_NAME VARCHAR(100) NOT NULL,
	PRODUCT_NICKNAME VARCHAR(50) NOT NULL,
	PRODUCT_STATUS CHAR(4) CHECK (PRODUCT_STATUS IN ('HOT', 'COLD', 'BOTH')) NOT NULL,
	PRODUCT_BUSINESS BIT NOT NULL,
)

ALTER TABLE PRODUCT ADD CONSTRAINT P_PRODUCT_ID_PK PRIMARY KEY (PRODUCT_ID);
ALTER TABLE PRODUCT ADD CONSTRAINT P_CLASSIFY_ID_FK FOREIGN KEY (CLASSIFY_ID) REFERENCES CLASSIFY (CLASSIFY_ID);


CREATE TABLE PRODUCT_SIZE (
	PRODUCT_ID CHAR(5) NOT NULL,
	PRODUCT_SIZE CHAR(1) CHECK (PRODUCT_SIZE IN ('S', 'M', 'L')) NOT NULL,
	PRODUCT_PRICE MONEY NOT NULL,
)

ALTER TABLE PRODUCT_SIZE ADD CONSTRAINT PS_PRODUCT_ID_PRODUCT_SIZE_PK PRIMARY KEY (PRODUCT_ID, PRODUCT_SIZE);
ALTER TABLE PRODUCT_SIZE ADD CONSTRAINT PS_PRODUCT_ID_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID);

CREATE TABLE TOPPING (
	TOPPING_ID CHAR(5) NOT NULL,
	TOPPING_NAME VARCHAR(50) NOT NULL,
	TOPPING_PRICE MONEY NOT NULL,
	TOPPING_BUSINESS BIT NOT NULL
)

ALTER TABLE TOPPING ADD CONSTRAINT TP_TOPPING_ID_PK PRIMARY KEY (TOPPING_ID);

CREATE TABLE PRODUCT_TOPPING (
	PRODUCT_ID CHAR(5) NOT NULL,
	TOPPING_ID CHAR(5) NOT NULL
)

ALTER TABLE PRODUCT_TOPPING ADD CONSTRAINT PT_PRODUCT_ID_TOPPING_ID_PK PRIMARY KEY (PRODUCT_ID, TOPPING_ID);
ALTER TABLE PRODUCT_TOPPING ADD CONSTRAINT PT_PRODUCT_ID_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID);
ALTER TABLE PRODUCT_TOPPING ADD CONSTRAINT PT_TOPPING_ID_FK FOREIGN KEY (TOPPING_ID) REFERENCES TOPPING (TOPPING_ID);

CREATE TABLE BILL (
	BILL_ID CHAR(5) NOT NULL,
	BILL_DATE DATETIME NOT NULL,
	BILL_TOTAL MONEY,
	RECEIVED_MONEY MONEY,
	EXCESS_MONEY MONEY,
	BILL_STATUS BIT,
	STAFF_ID CHAR(5) NOT NULL
)

ALTER TABLE BILL ADD CONSTRAINT B_BILL_ID_PK PRIMARY KEY (BILL_ID);
ALTER TABLE BILL ADD CONSTRAINT B_STAFF_ID_FK FOREIGN KEY (STAFF_ID) REFERENCES STAFF (STAFF_ID);
ALTER TABLE BILL ADD BILL_TYPE VARCHAR(10);

CREATE TABLE DETAIL_BILL (
	DETAIL_BILL_ID CHAR(10) NOT NULL,
	BILL_ID CHAR(5) NOT NULL,
	PRODUCT_ID CHAR(5) NOT NULL,
	ORDINAL_NUMBER INT NOT NULL,
	QUANTTY INT NOT NULL,
	UNIT_PRICE MONEY
)

ALTER TABLE DETAIL_BILL DROP COLUMN QUANTTY;
ALTER TABLE DETAIL_BILL ADD QUANTITY INT NOT NULL;

ALTER TABLE DETAIL_BILL ADD PRODUCT_SIZE CHAR(1), PRODUCT_STATUS  CHAR(4);

ALTER TABLE DETAIL_BILL ADD CONSTRAINT DB_DETAIL_BILL_ID_PK PRIMARY KEY (DETAIL_BILL_ID);
ALTER TABLE DETAIL_BILL ADD CONSTRAINT DB_BILL_ID_FK FOREIGN KEY (BILL_ID) REFERENCES BILL (BILL_ID);
ALTER TABLE DETAIL_BILL ADD CONSTRAINT DB_PRODUCT_ID_FK FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (PRODUCT_ID);

CREATE TABLE DETAILBILL_TOPPING (
	DETAIL_BILL_ID CHAR(10) NOT NULL,
	TOPPING_ID CHAR(5) NOT NULL
)

ALTER TABLE DETAILBILL_TOPPING ADD QUANTITY INT, PRICE MONEY;

ALTER TABLE DETAILBILL_TOPPING ADD CONSTRAINT DT_DETAIL_BILL_ID_TOPPING_ID_PK PRIMARY KEY (DETAIL_BILL_ID, TOPPING_ID);
ALTER TABLE DETAILBILL_TOPPING ADD CONSTRAINT DT_DETAIL_BILL_ID_FK FOREIGN KEY (DETAIL_BILL_ID) REFERENCES DETAIL_BILL (DETAIL_BILL_ID);
ALTER TABLE DETAILBILL_TOPPING ADD CONSTRAINT DT_TOPPING_ID_FK FOREIGN KEY (TOPPING_ID) REFERENCES TOPPING (TOPPING_ID);

CREATE TABLE TABLE_IN_STORE (
	TABLE_ID CHAR(5) NOT NULL,
	TABLE_TYPE INT CHECK (TABLE_TYPE IN (2, 4, 8)) NOT NULL,
	TABLE_STATUS BIT NOT NULL
)

ALTER TABLE TABLE_IN_STORE ADD CONSTRAINT TB_TABLE_ID_PK PRIMARY KEY (TABLE_ID);

CREATE TABLE SPOT_BILL (
	BILL_ID CHAR(5) NOT NULL,
	TABLE_ID CHAR(5) NOT NULL
)

ALTER TABLE SPOT_BILL ADD CONSTRAINT SB_BILL_ID_TABLE_ID_PK PRIMARY KEY (BILL_ID, TABLE_ID);
ALTER TABLE SPOT_BILL ADD CONSTRAINT SB_BILL_ID_FK FOREIGN KEY (BILL_ID) REFERENCES BILL (BILL_ID);
ALTER TABLE SPOT_BILL ADD CONSTRAINT SB_TABLE_ID_FK FOREIGN KEY (TABLE_ID) REFERENCES TABLE_IN_STORE (TABLE_ID);

CREATE TABLE STAFF (
	STAFF_ID CHAR(5) NOT NULL,
	STAFF_NAME NVARCHAR(100) NOT NULL,
	STAFF_ADDRESS NVARCHAR(200),
	STAFF_BIRTHDAY DATETIME,
	STAFF_PHONE CHAR(20),
	STAFF_POSITION VARCHAR(50)
)

ALTER TABLE STAFF ADD CONSTRAINT S_STAFF_ID_PK PRIMARY KEY (STAFF_ID);

CREATE TABLE ACCOUNT (
	A_USERNAME VARCHAR(20) NOT NULL,
	A_PASSWORD VARCHAR(20) NOT NULL,
	STAFF_ID CHAR(5) NOT NULL
)

ALTER TABLE ACCOUNT ADD CONSTRAINT ACC_A_USERNAME_PK PRIMARY KEY (A_USERNAME);
ALTER TABLE ACCOUNT ADD CONSTRAINT ACC_STAFF_ID_FK FOREIGN KEY (STAFF_ID) REFERENCES STAFF (STAFF_ID);

--INSERT VALUES FOR TABLES

INSERT INTO CLASSIFY (CLASSIFY_ID, CLASSIFY_NAME) VALUES
	('CL001', 'Coffee'),
	('CL002', 'Tea'),
	('CL003', 'Fruit Juice'),
	('CL004', 'Yogurt'),
	('CL005', 'Smoothie');



UPDATE CLASSIFY SET CLASSIFY_BUSINESS = 1;
UPDATE CLASSIFY SET CLASSIFY_BUSINESS = 1 WHERE CLASSIFY_ID = 'CL001';

SELECT * FROM CLASSIFY;

INSERT INTO TOPPING (TOPPING_ID, TOPPING_NAME, TOPPING_PRICE, TOPPING_BUSINESS) VALUES
	('TP001', 'Golden Pearl', 6000, 1),
	('TP002', 'Brown Sugar Pearl', 8000, 1),
	('TP003', 'Konjac Caramel Jelly', 8000, 1),
	('TP004', 'Diamond Jelly', 6000, 1),
	('TP005', 'Fruit Diamond Jelly', 6000, 1),
	('TP006', 'Pudding', 6000, 1),
	('TP007', 'Red Bean', 10000, 1),
	('TP008', 'Cookies', 8000, 1),
	('TP009', 'Condensed Milk', 6000, 1);

INSERT INTO PRODUCT (CLASSIFY_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_NICKNAME, PRODUCT_STATUS, PRODUCT_BUSINESS) VALUES
	('CL001', 'CF001', 'Traditional Coffe', 'Traditional', 'COLD', '1'),
	('CL001', 'CF002', 'Espresso', 'Espresso', 'HOT', '1'),
	('CL001', 'CF003', 'Lattee', 'Lattee', 'HOT', '1'),
	('CL001', 'CF004', 'Cappuccino', 'Cappuccino', 'HOT', '1'),
	('CL001', 'CF005', 'Mocha', 'Mocha', 'HOT', '1'),
	('CL001', 'CF006', 'Macchiato', 'Macchiato', 'BOTH', '1'),
	('CL001', 'CF007', 'Milk Coffee', 'Milk Coffee', 'BOTH', '1');

INSERT INTO PRODUCT_TOPPING (PRODUCT_ID, TOPPING_ID) VALUES
	('CF003', 'TP009'),
	('CF007', 'TP009');

INSERT INTO PRODUCT_SIZE (PRODUCT_ID, PRODUCT_SIZE, PRODUCT_PRICE) VALUES
	('CF001', 'S', 19000),
	('CF001', 'M', 29000),
	('CF002', 'S', 19000),
	('CF002', 'M', 29000),
	('CF003', 'S', 19000),
	('CF003', 'M', 25000),
	('CF003', 'L', 34000),
	('CF004', 'S', 19000),
	('CF004', 'M', 29000),
	('CF005', 'S', 19000),
	('CF005', 'M', 29000),
	('CF006', 'S', 19000),
	('CF006', 'M', 29000),
	('CF007', 'S', 15000),
	('CF007', 'M', 20000),
	('CF007', 'L', 25000);

INSERT INTO PRODUCT (CLASSIFY_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_NICKNAME, PRODUCT_STATUS, PRODUCT_BUSINESS) VALUES
	('CL002', 'TE001', 'Black Tea', 'Black Tea', 'COLD', '1'),
	('CL002', 'TE002', 'Black Tea Latte', 'Black Tea Latte', 'COLD', '1'),
	('CL002', 'TE003', 'Pearl Black Tea', 'Pearl Black Tea', 'COLD', '1'),
	('CL002', 'TE004', 'Peach Tea', 'Peach Tea', 'COLD', '1'),
	('CL002', 'TE005', 'Strawberry Tea', 'Strawberry Tea', 'COLD', '1'),
	('CL002', 'TE006', 'Traditional Milk Tea', 'Traditional MT', 'BOTH', '1'),
	('CL002', 'TE007', 'Golden Pearl Milk Tea', 'Golden Peral MT', 'COLD', '1'),
	('CL002', 'TE008', 'Brown Sugar Milk Tea', 'Brown Sugar MT', 'COLD', '1'),
	('CL002', 'TE009', 'Black Diamond Milk Tea', 'Diamond MT', 'COLD', '1'),
	('CL002', 'TE010', 'Pudding Milk Tea', 'Pudding MT', 'COLD', '1'),
	('CL002', 'TE011', 'Read Bean Milk Tea', 'Red Bean MT', 'COLD', '1'),
	('CL002', 'TE012', 'Strawberry Milk Tea', 'Strawberry MT', 'COLD', '1'),
	('CL002', 'TE013', 'Chocolate Milk Tea', 'Chocolate MT', 'COLD', '1'),
	('CL002', 'TE014', 'Matcha Milk Tea', 'Matcha MT', 'COLD', '1'),
	('CL002', 'TE015', 'Mango Milk Tea', 'Mango MT', 'COLD', '1'),
	('CL002', 'TE016', 'Blueberry Milk Tea', 'Blueberry MT', 'BOTH', '1'),
	('CL002', 'TE017', 'Mix Milk Tea', 'Mix MT', 'COLD', '1'),
	('CL002', 'TE018', 'Taro Milk Tea', 'Taro MT', 'COLD', '1'),
	('CL002', 'TE019', 'Green Milk Tea', 'Green MT', 'COLD', '1'),
	('CL002', 'TE020', 'Coffee Milk Tea', 'Coffee MT', 'COLD', '1'),
	('CL002', 'TE021', 'Japanese Milk Tea', 'Japanese MT', 'COLD', '1');

INSERT INTO PRODUCT_TOPPING (PRODUCT_ID, TOPPING_ID) VALUES
	('TE001', 'TP001'),
	('TE001', 'TP003'),
	('TE001', 'TP004'),
	('TE001', 'TP005'),
	('TE001', 'TP006'),
	('TE002', 'TP001'),
	('TE002', 'TP003'),
	('TE002', 'TP004'),
	('TE002', 'TP005'),
	('TE002', 'TP006'),
	('TE003', 'TP001'),
	('TE003', 'TP003'),
	('TE003', 'TP004'),
	('TE003', 'TP005'),
	('TE003', 'TP006'),
	('TE004', 'TP001'),
	('TE004', 'TP003'),
	('TE004', 'TP004'),
	('TE004', 'TP005'),
	('TE004', 'TP006'),
	('TE005', 'TP001'),
	('TE005', 'TP003'),
	('TE005', 'TP004'),
	('TE005', 'TP005'),
	('TE005', 'TP006'),
	('TE006', 'TP001'),
	('TE006', 'TP002'),
	('TE006', 'TP003'),
	('TE006', 'TP004'),
	('TE006', 'TP005'),
	('TE006', 'TP006'),
	('TE006', 'TP007'),
	('TE006', 'TP008'),
	('TE007', 'TP001'),
	('TE007', 'TP002'),
	('TE007', 'TP003'),
	('TE007', 'TP004'),
	('TE007', 'TP005'),
	('TE007', 'TP006'),
	('TE007', 'TP007'),
	('TE007', 'TP008'),
	('TE008', 'TP001'),
	('TE008', 'TP002'),
	('TE008', 'TP003'),
	('TE008', 'TP004'),
	('TE008', 'TP005'),
	('TE008', 'TP006'),
	('TE008', 'TP007'),
	('TE008', 'TP008'),
	('TE009', 'TP001'),
	('TE009', 'TP002'),
	('TE009', 'TP003'),
	('TE009', 'TP004'),
	('TE009', 'TP005'),
	('TE009', 'TP006'),
	('TE009', 'TP007'),
	('TE009', 'TP008'),
	('TE010', 'TP001'),
	('TE010', 'TP002'),
	('TE010', 'TP003'),
	('TE010', 'TP004'),
	('TE010', 'TP005'),
	('TE010', 'TP006'),
	('TE010', 'TP007'),
	('TE010', 'TP008'),
	('TE011', 'TP001'),
	('TE011', 'TP002'),
	('TE011', 'TP003'),
	('TE011', 'TP004'),
	('TE011', 'TP005'),
	('TE011', 'TP006'),
	('TE011', 'TP007'),
	('TE011', 'TP008'),
	('TE012', 'TP001'),
	('TE012', 'TP002'),
	('TE012', 'TP003'),
	('TE012', 'TP004'),
	('TE012', 'TP005'),
	('TE012', 'TP006'),
	('TE012', 'TP007'),
	('TE012', 'TP008'),
	('TE013', 'TP001'),
	('TE013', 'TP002'),
	('TE013', 'TP003'),
	('TE013', 'TP004'),
	('TE013', 'TP005'),
	('TE013', 'TP006'),
	('TE013', 'TP007'),
	('TE013', 'TP008'),
	('TE014', 'TP001'),
	('TE014', 'TP002'),
	('TE014', 'TP003'),
	('TE014', 'TP004'),
	('TE014', 'TP005'),
	('TE014', 'TP006'),
	('TE014', 'TP007'),
	('TE014', 'TP008'),
	('TE015', 'TP001'),
	('TE015', 'TP002'),
	('TE015', 'TP003'),
	('TE015', 'TP004'),
	('TE015', 'TP005'),
	('TE015', 'TP006'),
	('TE015', 'TP007'),
	('TE015', 'TP008'),
	('TE016', 'TP001'),
	('TE016', 'TP002'),
	('TE016', 'TP003'),
	('TE016', 'TP004'),
	('TE016', 'TP005'),
	('TE016', 'TP006'),
	('TE016', 'TP007'),
	('TE016', 'TP008'),
	('TE017', 'TP001'),
	('TE017', 'TP002'),
	('TE017', 'TP003'),
	('TE017', 'TP004'),
	('TE017', 'TP005'),
	('TE017', 'TP006'),
	('TE017', 'TP007'),
	('TE017', 'TP008'),
	('TE018', 'TP001'),
	('TE018', 'TP002'),
	('TE018', 'TP003'),
	('TE018', 'TP004'),
	('TE018', 'TP005'),
	('TE018', 'TP006'),
	('TE018', 'TP007'),
	('TE018', 'TP008'),
	('TE019', 'TP001'),
	('TE019', 'TP002'),
	('TE019', 'TP003'),
	('TE019', 'TP004'),
	('TE019', 'TP005'),
	('TE019', 'TP006'),
	('TE019', 'TP007'),
	('TE019', 'TP008'),
	('TE020', 'TP001'),
	('TE020', 'TP002'),
	('TE020', 'TP003'),
	('TE020', 'TP004'),
	('TE020', 'TP005'),
	('TE020', 'TP006'),
	('TE020', 'TP007'),
	('TE020', 'TP008'),
	('TE021', 'TP001'),
	('TE021', 'TP002'),
	('TE021', 'TP003'),
	('TE021', 'TP004'),
	('TE021', 'TP005'),
	('TE021', 'TP006'),
	('TE021', 'TP007'),
	('TE021', 'TP008');

	

INSERT INTO PRODUCT_SIZE (PRODUCT_ID, PRODUCT_SIZE, PRODUCT_PRICE) VALUES
	('TE001', 'S', 15000),
	('TE001', 'M', 20000),
	('TE001', 'L', 25000),
	('TE002', 'S', 19000),
	('TE002', 'M', 25000),
	('TE002', 'L', 30000),
	('TE003', 'S', 19000),
	('TE003', 'M', 25000),
	('TE003', 'L', 30000),
	('TE004', 'S', 15000),
	('TE004', 'M', 25000),
	('TE004', 'L', 35000),
	('TE005', 'S', 15000),
	('TE005', 'M', 25000),
	('TE005', 'L', 35000),
	('TE006', 'S', 15000),
	('TE006', 'M', 20000),
	('TE006', 'L', 25000),
	('TE007', 'S', 19000),
	('TE007', 'M', 25000),
	('TE007', 'L', 35000),
	('TE008', 'S', 19000),
	('TE008', 'M', 25000),
	('TE008', 'L', 35000),
	('TE009', 'S', 19000),
	('TE009', 'M', 25000),
	('TE009', 'L', 35000),
	('TE010', 'S', 19000),
	('TE010', 'M', 25000),
	('TE010', 'L', 35000),
	('TE011', 'S', 19000),
	('TE011', 'M', 25000),
	('TE011', 'L', 35000),
	('TE012', 'S', 19000),
	('TE012', 'M', 25000),
	('TE012', 'L', 35000),
	('TE013', 'S', 21000),
	('TE013', 'M', 29000),
	('TE013', 'L', 40000),
	('TE014', 'S', 21000),
	('TE014', 'M', 29000),
	('TE014', 'L', 40000),
	('TE015', 'S', 19000),
	('TE015', 'M', 25000),
	('TE015', 'L', 35000),
	('TE016', 'S', 19000),
	('TE016', 'M', 25000),
	('TE016', 'L', 35000),
	('TE017', 'S', 19000),
	('TE017', 'M', 25000),
	('TE017', 'L', 35000),
	('TE018', 'S', 19000),
	('TE018', 'M', 25000),
	('TE018', 'L', 35000),
	('TE019', 'S', 19000),
	('TE019', 'M', 25000),
	('TE019', 'L', 35000),
	('TE020', 'S', 19000),
	('TE020', 'M', 25000),
	('TE020', 'L', 35000),
	('TE021', 'S', 19000),
	('TE021', 'M', 25000),
	('TE021', 'L', 35000);

INSERT INTO PRODUCT (CLASSIFY_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_NICKNAME, PRODUCT_STATUS, PRODUCT_BUSINESS) VALUES
	('CL003', 'FJ001', 'Mango Juice', 'Mango Juice', 'COLD', '1'),
	('CL003', 'FJ002', 'Apple Juice', 'Apple Juice', 'COLD', '1'),
	('CL003', 'FJ003', 'Carrot Juice', 'Carrot Juice', 'COLD', '1'),
	('CL003', 'FJ004', 'Guava Juice', 'Guava Juice', 'COLD', '1'),
	('CL003', 'FJ005', 'Orange Juice', 'Orange Juice', 'COLD', '1'),
	('CL003', 'FJ006', 'Squash Juice', 'Squash Juice', 'COLD', '1'),
	('CL003', 'FJ007', 'Pineapple Juice', 'Pineapple Juice', 'COLD', '1'),
	('CL003', 'FJ008', 'Tomato Juice', 'Tomato Juice', 'COLD', '1'),
	('CL003', 'FJ009', 'Strawberry Juice', 'Strawberry Juice', 'COLD', '1'),
	('CL003', 'FJ010', 'Waterlemon Juice', 'Waterlemon Juice', 'COLD', '1');

INSERT INTO PRODUCT_TOPPING (PRODUCT_ID, TOPPING_ID) VALUES
	('FJ001', 'TP001'),
	('FJ001', 'TP003'),
	('FJ001', 'TP004'),
	('FJ001', 'TP005'),
	('FJ001', 'TP006'),
	('FJ002', 'TP001'),
	('FJ002', 'TP003'),
	('FJ002', 'TP004'),
	('FJ002', 'TP005'),
	('FJ002', 'TP006'),
	('FJ003', 'TP001'),
	('FJ003', 'TP003'),
	('FJ003', 'TP004'),
	('FJ003', 'TP005'),
	('FJ003', 'TP006'),
	('FJ004', 'TP001'),
	('FJ004', 'TP003'),
	('FJ004', 'TP004'),
	('FJ004', 'TP005'),
	('FJ004', 'TP006'),
	('FJ005', 'TP001'),
	('FJ005', 'TP003'),
	('FJ005', 'TP004'),
	('FJ005', 'TP005'),
	('FJ005', 'TP006'),
	('FJ006', 'TP001'),
	('FJ006', 'TP003'),
	('FJ006', 'TP004'),
	('FJ006', 'TP005'),
	('FJ006', 'TP006'),
	('FJ007', 'TP001'),
	('FJ007', 'TP003'),
	('FJ007', 'TP004'),
	('FJ007', 'TP005'),
	('FJ007', 'TP006'),
	('FJ008', 'TP001'),
	('FJ008', 'TP003'),
	('FJ008', 'TP004'),
	('FJ008', 'TP005'),
	('FJ008', 'TP006'),
	('FJ009', 'TP001'),
	('FJ009', 'TP003'),
	('FJ009', 'TP004'),
	('FJ009', 'TP005'),
	('FJ009', 'TP006'),
	('FJ010', 'TP001'),
	('FJ010', 'TP003'),
	('FJ010', 'TP004'),
	('FJ010', 'TP005'),
	('FJ010', 'TP006');

INSERT INTO PRODUCT_SIZE (PRODUCT_ID, PRODUCT_SIZE, PRODUCT_PRICE) VALUES
	('FJ001', 'S', 15000),
	('FJ001', 'M', 20000),
	('FJ001', 'L', 25000),
	('FJ002', 'S', 15000),
	('FJ002', 'M', 20000),
	('FJ002', 'L', 25000),
	('FJ003', 'S', 15000),
	('FJ003', 'M', 20000),
	('FJ003', 'L', 25000),
	('FJ004', 'S', 15000),
	('FJ004', 'M', 20000),
	('FJ004', 'L', 25000),
	('FJ005', 'S', 15000),
	('FJ005', 'M', 20000),
	('FJ005', 'L', 25000),
	('FJ006', 'S', 15000),
	('FJ006', 'M', 20000),
	('FJ006', 'L', 25000),
	('FJ007', 'S', 15000),
	('FJ007', 'M', 20000),
	('FJ007', 'L', 25000),
	('FJ008', 'S', 15000),
	('FJ008', 'M', 20000),
	('FJ008', 'L', 25000),
	('FJ009', 'S', 15000),
	('FJ009', 'M', 20000),
	('FJ009', 'L', 25000),
	('FJ010', 'S', 15000),
	('FJ010', 'M', 20000),
	('FJ010', 'L', 25000);

INSERT INTO PRODUCT (CLASSIFY_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_NICKNAME, PRODUCT_STATUS, PRODUCT_BUSINESS) VALUES
	('CL004', 'YG001', 'Orange Yogurt', 'Orange Yogurt', 'COLD', '1'),
	('CL004', 'YG002', 'Mango Yogurt', 'Mango Yogurt', 'COLD', '1'),
	('CL004', 'YG003', 'Lemon Yogurt', 'Lemon Yogurt', 'COLD', '1'),
	('CL004', 'YG004', 'Kumquat Yogurt', 'Kumquat Yogurt', 'COLD', '1'),
	('CL004', 'YG005', 'Passion Fruit Yogurt', 'Passion Fruit YG', 'COLD', '1'),
	('CL004', 'YG006', 'Blueberry Yogurt', 'Blueberry Yogurt', 'COLD', '1'),
	('CL004', 'YG007', 'Mix Yogurt', 'Mix Yogurt', 'COLD', '1'),
	('CL004', 'YG008', 'Berry Yogurt', 'Berry Yogurt', 'COLD', '1'),
	('CL004', 'YG009', 'Pomelo Yogurt', 'Pomelo Yogurt', 'COLD', '1');

INSERT INTO PRODUCT_TOPPING (PRODUCT_ID, TOPPING_ID) VALUES
	('YG001', 'TP001'),
	('YG001', 'TP003'),
	('YG001', 'TP004'),
	('YG001', 'TP005'),
	('YG001', 'TP006'),
	('YG002', 'TP001'),
	('YG002', 'TP003'),
	('YG002', 'TP004'),
	('YG002', 'TP005'),
	('YG002', 'TP006'),
	('YG003', 'TP001'),
	('YG003', 'TP003'),
	('YG003', 'TP004'),
	('YG003', 'TP005'),
	('YG003', 'TP006'),
	('YG004', 'TP001'),
	('YG004', 'TP003'),
	('YG004', 'TP004'),
	('YG004', 'TP005'),
	('YG004', 'TP006'),
	('YG005', 'TP001'),
	('YG005', 'TP003'),
	('YG005', 'TP004'),
	('YG005', 'TP005'),
	('YG005', 'TP006'),
	('YG006', 'TP001'),
	('YG006', 'TP003'),
	('YG006', 'TP004'),
	('YG006', 'TP005'),
	('YG006', 'TP006'),
	('YG007', 'TP001'),
	('YG007', 'TP003'),
	('YG007', 'TP004'),
	('YG007', 'TP005'),
	('YG007', 'TP006'),
	('YG008', 'TP001'),
	('YG008', 'TP003'),
	('YG008', 'TP004'),
	('YG008', 'TP005'),
	('YG008', 'TP006'),
	('YG009', 'TP001'),
	('YG009', 'TP003'),
	('YG009', 'TP004'),
	('YG009', 'TP005'),
	('YG009', 'TP006');

INSERT INTO PRODUCT_SIZE (PRODUCT_ID, PRODUCT_SIZE, PRODUCT_PRICE) VALUES
	('YG001', 'S', 15000),
	('YG001', 'M', 20000),
	('YG001', 'L', 25000),
	('YG002', 'S', 15000),
	('YG002', 'M', 20000),
	('YG002', 'L', 25000),
	('YG003', 'S', 15000),
	('YG003', 'M', 20000),
	('YG003', 'L', 25000),
	('YG004', 'S', 15000),
	('YG004', 'M', 20000),
	('YG004', 'L', 25000),
	('YG005', 'S', 15000),
	('YG005', 'M', 20000),
	('YG005', 'L', 25000),
	('YG006', 'S', 15000),
	('YG006', 'M', 20000),
	('YG006', 'L', 25000),
	('YG007', 'S', 15000),
	('YG007', 'M', 20000),
	('YG007', 'L', 25000),
	('YG008', 'S', 15000),
	('YG008', 'M', 20000),
	('YG008', 'L', 25000),
	('YG009', 'S', 15000),
	('YG009', 'M', 20000),
	('YG009', 'L', 25000);

INSERT INTO PRODUCT (CLASSIFY_ID, PRODUCT_ID, PRODUCT_NAME, PRODUCT_NICKNAME, PRODUCT_STATUS, PRODUCT_BUSINESS) VALUES
	('CL005', 'SM001', 'Mango Smoothie', 'Mango Smoothie', 'COLD', '1'),
	('CL005', 'SM002', 'Berry Smoothie', 'Berry Smoothie', 'COLD', '1'),
	('CL005', 'SM003', 'Black Diamond Coffee Smoothie', 'Diamond Coffee', 'COLD', '1'),
	('CL005', 'SM004', 'Strawberry Smoothie', 'Strawberry SM', 'COLD', '1'),
	('CL005', 'SM005', 'Matcha Smoothie', 'Matcha Smoothie', 'COLD', '1');

INSERT INTO PRODUCT_TOPPING (PRODUCT_ID, TOPPING_ID) VALUES
	('SM001', 'TP001'),
	('SM001', 'TP003'),
	('SM001', 'TP004'),
	('SM001', 'TP005'),
	('SM001', 'TP006'),
	('SM001', 'TP007'),
	('SM002', 'TP001'),
	('SM002', 'TP003'),
	('SM002', 'TP004'),
	('SM002', 'TP005'),
	('SM002', 'TP006'),
	('SM002', 'TP007'),
	('SM003', 'TP001'),
	('SM003', 'TP003'),
	('SM003', 'TP004'),
	('SM003', 'TP005'),
	('SM003', 'TP006'),
	('SM003', 'TP007'),
	('SM004', 'TP001'),
	('SM004', 'TP003'),
	('SM004', 'TP004'),
	('SM004', 'TP005'),
	('SM004', 'TP006'),
	('SM004', 'TP007'),
	('SM005', 'TP001'),
	('SM005', 'TP003'),
	('SM005', 'TP004'),
	('SM005', 'TP005'),
	('SM005', 'TP006'),
	('SM005', 'TP007');

INSERT INTO PRODUCT_SIZE (PRODUCT_ID, PRODUCT_SIZE, PRODUCT_PRICE) VALUES
	('SM001', 'S', 30000),
	('SM001', 'M', 40000),
	('SM002', 'S', 30000),
	('SM002', 'M', 40000),
	('SM003', 'S', 30000),
	('SM003', 'M', 40000),
	('SM004', 'S', 30000),
	('SM004', 'M', 40000),
	('SM005', 'S', 35000),
	('SM005', 'M', 45000);

INSERT INTO TABLE_IN_STORE (TABLE_ID, TABLE_TYPE, TABLE_STATUS) VALUES
	('TB001', 2, 1),
	('TB002', 2, 1),
	('TB003', 2, 1),
	('TB004', 2, 1),
	('TB005', 4, 1),
	('TB006', 4, 1),
	('TB007', 4, 1),
	('TB008', 4, 1),
	('TB009', 8, 1),
	('TB010', 8, 1),
	('TB011', 8, 1),
	('TB012', 8, 1);

	INSERT INTO STAFF (STAFF_ID, STAFF_NAME, STAFF_ADDRESS, STAFF_BIRTHDAY, STAFF_PHONE, STAFF_POSITION) VALUES
		('SF001', N'Võ Văn Hùng', N'521/91E, CMT8, P13, Q10, TP HCM', '2002/07/15', '0907604514', 'Manager'),
		('SF002', N'Thiều Việt Hoàng', N'521/91E, CMT8, P13, Q10, TP HCM', '2002/01/01', '0907604514', 'Seller'),
		('SF003', N'Lộc Gia Phúc', N'521/91E, CMT8, P13, Q10, TP HCM', '2002/01/01', '0907604514', 'Seller'),
		('SF004', N'Đoàn Thành Lợi', N'521/91E, CMT8, P13, Q10, TP HCM', '2002/01/01', '0907604514', 'Seller'),
		('SF005', N'Nguyễn Hoàng Giang Trường', N'521/91E, CMT8, P13, Q10, TP HCM', '2002/01/01', '0907604514', 'Seller');

INSERT INTO BILL VALUES ('BL001', '2022/04/16', 0, 0, 0, 1, 'SF002');

DELETE FROM BILL WHERE BILL_ID = 'BL002';

INSERT INTO DETAIL_BILL VALUES ('BL0011', 'BL001', 'TE001', 1, 30000, 'S', 'COLD', 2);
INSERT INTO DETAIL_BILL VALUES ('BL0022', 'BL002', 'TE002', 2, 57000, 'S', 'COLD', 3);

DELETE FROM DETAIL_BILL WHERE DETAIL_BILL_ID = 'BL0022';
UPDATE DETAIL_BILL SET UNIT_PRICE = 90000 WHERE DETAIL_BILL_ID = 'BL0012';

INSERT INTO DETAILBILL_TOPPING VALUES ('BL0011', 'TP001', 3, 18000);
INSERT INTO DETAILBILL_TOPPING VALUES ('BL0011', 'TP003', 2, 16000);

UPDATE DETAILBILL_TOPPING SET TOPPING_ID = 'TP003' WHERE DETAIL_BILL_ID = 'BL0011' AND TOPPING_ID = 'TP002';

DELETE FROM DETAILBILL_TOPPING WHERE DETAIL_BILL_ID = 'BL0011' AND TOPPING_ID = 'TP003';

DELETE FROM DETAILBILL_TOPPING WHERE PRICE = 18000;

INSERT INTO SPOT_BILL VALUES ('BL001', 'TB001');

DELETE FROM SPOT_BILL WHERE BILL_ID = 'BL001';

--Trigger trong DETAIL_BILL
CREATE TRIGGER TRG_DETAIL

GO

--Trigger khi them mot chi tiet bill thi tong tien cua bill se tang len
ALTER TRIGGER TRG_DETAIL_BILL_INSERT ON DETAIL_BILL AFTER INSERT
AS
BEGIN
	UPDATE BILL
	SET BILL_TOTAL = BILL_TOTAL + (SELECT SUM(I.UNIT_PRICE)  FROM INSERTED AS I)
	WHERE BILL_ID IN (SELECT I.BILL_ID  FROM INSERTED AS I);
END;

GO

--Trigger khi xoa mot chi tiet bill thi tong tien cua bill se giam xuong
CREATE TRIGGER TRG_DETAIL_BILL_DELETE ON DETAIL_BILL AFTER DELETE
AS
BEGIN
	UPDATE BILL
	SET BILL_TOTAL = BILL_TOTAL - (SELECT SUM(D.UNIT_PRICE) FROM DELETED AS D)
	WHERE BILL_ID IN (SELECT D.BILL_ID FROM DELETED AS D);
END;

GO

--Trigger khi update mot chi tiet bill thi tong tien cua bill cua se duoc update theo
CREATE TRIGGER TRG_DETAIL_BILL_UPDATE ON DETAIL_BILL AFTER UPDATE
AS
IF UPDATE(UNIT_PRICE)
BEGIN
	UPDATE BILL
	SET BILL_TOTAL = BILL_TOTAL - (SELECT SUM(D.UNIT_PRICE) FROM DELETED AS D) + (SELECT SUM(I.UNIT_PRICE) FROM INSERTED AS I)
	WHERE BILL_ID IN (SELECT D.BILL_ID FROM DELETED AS D);
END;

GO

--Trigger trong BILLDETAIL_TOPPING
--Trigger khi them mot chi tiet bill_topping thi don gia trong chi tiet bill se tang len
CREATE TRIGGER TRG_DETAILBILL_TOPPING_INSERT ON DETAILBILL_TOPPING AFTER INSERT
AS
BEGIN
	UPDATE DETAIL_BILL
	SET UNIT_PRICE = UNIT_PRICE + (SELECT SUM(I.PRICE) FROM INSERTED AS I)
	WHERE DETAIL_BILL_ID IN (SELECT I.DETAIL_BILL_ID FROM INSERTED AS I);
END;

GO

--Trigger khi xoa mot chi tiet bill_topping thi don gia trong chi tiet bill se giam xuong
CREATE TRIGGER TRG_DETAILBILL_TOPPING_DELETE ON DETAILBILL_TOPPING AFTER DELETE
AS
BEGIN
	UPDATE DETAIL_BILL
	SET UNIT_PRICE = UNIT_PRICE - (SELECT SUM(D.PRICE) FROM DELETED AS D)
	WHERE DETAIL_BILL_ID IN (SELECT D.DETAIL_BILL_ID FROM DELETED AS D);
END;

GO

--Trigger khi update mot chi tiet bill_topping thi don gia trong chi tiet bill se thay doi
CREATE TRIGGER TRG_DETAILBILL_TOPPING_UPDATE ON DETAILBILL_TOPPING AFTER UPDATE
AS
IF UPDATE (PRICE)
BEGIN
	UPDATE DETAIL_BILL
	SET UNIT_PRICE = UNIT_PRICE - (SELECT SUM(D.PRICE) FROM DELETED AS D) + (SELECT SUM(I.PRICE) FROM INSERTED AS I)
	WHERE DETAIL_BILL_ID IN (SELECT D.DETAIL_BILL_ID FROM DELETED AS D);
END;

GO
--Procedure
--Procedure lay danh sach chi tiet bill
CREATE PROCEDURE GET_DETAIL_BILL_LIST
AS
BEGIN
	SELECT * FROM DETAIL_BILL;
END;

GO

EXECUTE GET_DETAIL_BILL_LIST;

GO

--Procedure lay danh sach chi tiet bill _ topping
CREATE PROCEDURE GET_DETAILBILL_TOPPING_LIST
AS
BEGIN
	SELECT * FROM DETAILBILL_TOPPING;
END;

GO

EXECUTE GET_DETAILBILL_TOPPING_LIST;

GO

EXECUTE DELETE_BILL 'BL012';

GO

--PROCEDURE ABOUT BILL
--PROCEDURE INSERT A BILL
ALTER PROCEDURE INSERT_BILL @BILL_ID CHAR(6), @BILL_DATE DATETIME, @BILL_TOTAL MONEY, @RECEIVED MONEY, @EXCESS MONEY, @BILL_STATUS BIT, @STAFF_ID CHAR(5), @BILL_TYPE VARCHAR(10)
AS
BEGIN
	INSERT INTO BILL VALUES (@BILL_ID, @BILL_DATE, @BILL_TOTAL, @RECEIVED, @EXCESS, @BILL_STATUS, @STAFF_ID, @BILL_TYPE);
END;

GO

--PROCEDURE UPDATE A BILL WITH STATUS, RECEIVED, EXCESS
CREATE PROCEDURE UPDATE_BILL @BILL_ID CHAR(5), @STATUS BIT, @RECEIVED MONEY, @EXCESS MONEY
AS
BEGIN
	UPDATE BILL
	SET BILL_STATUS = @STATUS, RECEIVED_MONEY = @RECEIVED, EXCESS_MONEY = @EXCESS
	WHERE BILL_ID = @BILL_ID;

END;

GO

--TRIGGER UPDATE BILL STATUS, IF IT IS SPOT BILL, SET TABLE STATUS 
CREATE TRIGGER TRG_BILL_UPDATE ON BILL AFTER UPDATE
AS
IF UPDATE(BILL_STATUS)
BEGIN
	UPDATE TABLE_IN_STORE
	SET TABLE_STATUS = 1
	WHERE TABLE_ID = (SELECT TABLE_ID FROM SPOT_BILL WHERE BILL_ID = (SELECT I.BILL_ID FROM INSERTED AS I));
END;

GO

--PROCEDURE DELETE A BILL

CREATE PROCEDURE DELETE_BILL @BILL_ID CHAR(5)
AS
BEGIN
	DELETE FROM DETAILBILL_TOPPING WHERE DETAIL_BILL_ID IN (SELECT DB.DETAIL_BILL_ID FROM DETAIL_BILL AS DB WHERE BILL_ID = @BILL_ID);
	DELETE FROM DETAIL_BILL WHERE BILL_ID = @BILL_ID;
	DELETE FROM SPOT_BILL WHERE BILL_ID = @BILL_ID;
	DELETE FROM BILL WHERE BILL_ID = @BILL_ID;
END;

GO

EXECUTE DELETE_BILL 'BL001';

--PROCEDURE ABOUT DETAIL_BILL
--PROCEDURE INSERT A DETAIL BILL

GO

CREATE PROCEDURE INSERT_DETAIL_BILL @DETAIL_BILL_ID CHAR(10), @BILL_ID CHAR(5), @PRODUCT_ID CHAR(5), @ORDINAL_NUMBER INT, @UNIT_PRICE MONEY, @PRODUCT_SIZE CHAR(1), @PRODUCT_STATUS CHAR(4), @QUANTITY INT
AS
BEGIN
	INSERT INTO DETAIL_BILL VALUES (@DETAIL_BILL_ID, @BILL_ID, @PRODUCT_ID, @ORDINAL_NUMBER, @UNIT_PRICE, @PRODUCT_SIZE, @PRODUCT_STATUS, @QUANTITY);
END;

--PROCEDURE DELETE A DETAIL BILL
GO

CREATE PROCEDURE DELETE_DETAIL_BILL @DETAIL_BILL_ID CHAR(10)
AS
BEGIN
	DELETE FROM DETAILBILL_TOPPING WHERE DETAIL_BILL_ID = @DETAIL_BILL_ID;
	DELETE FROM DETAIL_BILL WHERE DETAIL_BILL_ID = @DETAIL_BILL_ID;
END;

GO

--PROCEDURE ABOUT DETAILBILL_TOPPING
--PROCEDURE INSERT A DETAILBILL_TOPPING

CREATE PROCEDURE INSERT_DETAILBILL_TOPPING @DETAIL_BILL_ID CHAR(10), @TOPPING_ID CHAR(5), @QUANTITY INT, @PRICE MONEY
AS
BEGIN
	INSERT INTO DETAILBILL_TOPPING VALUES (@DETAIL_BILL_ID, @TOPPING_ID, @QUANTITY, @PRICE);
END;

GO

--PROCEDURE OF TABLE
--PROCEDUR UPDATE STATUS OF A TABLE
CREATE PROCEDURE UPDATE_TABLE_STATUS @TABLE_ID CHAR(5), @STATUS BIT
AS
BEGIN
	UPDATE TABLE_IN_STORE
	SET TABLE_STATUS = @STATUS
	WHERE TABLE_ID = @TABLE_ID;
END;

EXECUTE UPDATE_TABLE_STATUS 'TB005', 1;

GO

--PROCEDURE ABOUT SPOT BILL
CREATE PROCEDURE INSERT_SPOT_BILL @BILL_ID CHAR(5), @TABLE_ID CHAR(5)
AS
BEGIN
	INSERT INTO SPOT_BILL VALUES (@BILL_ID, @TABLE_ID);
END;

GO

EXECUTE INSERT_SPOT_BILL 'BL001', 'TB001';
DELETE FROM SPOT_BILL WHERE BILL_ID = 'BL001';

--TRIGGER IF DELETE A DETAIL, CHECK BILL, IF DOESN'T EXIT DETAIL, DELETE BILL

GO

ALTER TRIGGER TRG_DETAIL_BILL_CHECKBILL ON DETAIL_BILL AFTER DELETE
AS
BEGIN
	IF NOT EXISTS (SELECT * FROM BILL AS BL, DETAIL_BILL AS DT WHERE BL.BILL_ID = DT.BILL_ID AND BL.BILL_ID = (SELECT DISTINCT BILL_ID FROM DELETED))
	BEGIN
		DECLARE @BILL_ID CHAR(5);
		SET @BILL_ID = (SELECT DISTINCT D.BILL_ID FROM DELETED AS D);
		EXECUTE DELETE_BILL @BILL_ID;
	END
END;

GO

--TRIGGER KHI XOA MOT SPOT BILL THI CAP NHAP LAI TRANG THAI TABLE
CREATE TRIGGER TRG_SPOTBILL_DELETE ON SPOT_BILL AFTER DELETE
AS
BEGIN
	UPDATE TABLE_IN_STORE
	SET TABLE_STATUS = 1
	WHERE TABLE_ID = (SELECT TABLE_ID FROM DELETED);
END;

GO

SELECT * FROM CLASSIFY;
SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT_SIZE;
SELECT * FROM PRODUCT_TOPPING;
SELECT * FROM TOPPING;
SELECT * FROM STAFF;
SELECT * FROM BILL;
SELECT * FROM DETAIL_BILL;
SELECT * FROM DETAILBILL_TOPPING;
SELECT * FROM SPOT_BILL;
SELECT * FROM TABLE_IN_STORE;

GO

EXECUTE DELETE_BILL 'BL001';

EXECUTE UPDATE_BILL 'BL001', 1, '700000', '28000';

SELECT P.PRODUCT_NAME, PS.PRODUCT_SIZE, PS.PRODUCT_PRICE
FROM PRODUCT AS P, PRODUCT_SIZE AS PS
WHERE P.PRODUCT_ID = PS.PRODUCT_ID;
