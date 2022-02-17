DROP TABLE s_basket CASCADE CONSTRAINTS;

DROP SEQUENCE basket_seq;

CREATE TABLE s_basket (
    basketidx NUMBER(20) PRIMARY KEY,
    id        VARCHAR2(20) NOT NULL,
    productno NUMBER(9) NOT NULL,
    option1   VARCHAR2(100) NOT NULL,
    option2   VARCHAR2(100) NOT NULL,
    amount    NUMBER(3) NOT NULL,
    CONSTRAINT fk_basmem FOREIGN KEY ( id )
        REFERENCES s_member ( id )
            ON DELETE CASCADE,
    CONSTRAINT fk_basprod FOREIGN KEY ( productno )
        REFERENCES s_product ( productno )
            ON DELETE CASCADE
);

CREATE SEQUENCE basket_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO s_basket VALUES (
    basket_seq.NEXTVAL,
    'tester0001',
    1,
    '08.NB_MS327CPG',
    '230',
    1
);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',2,'2','d',2);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',3,'3','f',3);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',4,'4','s',4);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',5,'1','a',5);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',6,'2','s',6);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',7,'3','d',7);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',8,'4','f',8);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',9,'1','f',9);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',10,'2','d',10);
insert into s_basket values (basket_seq.NEXTVAL,'btester0002',11,'3','s',11);
insert into s_basket values (basket_seq.NEXTVAL,'ctester0003',12,'4','a',12);
insert into s_basket values (basket_seq.NEXTVAL,'ctester0003',13,'1','a',13);
insert into s_basket values (basket_seq.NEXTVAL,'tester0004',14,'2','s',14);
insert into s_basket values (basket_seq.NEXTVAL,'tester0004',15,'3','a',15);
insert into s_basket values (basket_seq.NEXTVAL,'tester0005',16,'4','s',16);
insert into s_basket values (basket_seq.NEXTVAL,'tester0005',17,'1','d',17);
insert into s_basket values (basket_seq.NEXTVAL,'tester0006',18,'2','f',18);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',19,'3','f',19);
insert into s_basket values (basket_seq.NEXTVAL,'tester0001',20,'4','d',2);
COMMIT;

SELECT
    *
FROM
    s_basket;

--SELECT b.basketidx, b.id, b.productno, b.option1, b.option2, b.amount, p.productname, p.imagename, p.price FROM s_basket  b LEFT JOIN s_product p ON b.productno = p.productno WHERE b.id = 'tester0001';
--SELECT b.basketidx, b.id, b.productno, b.option1, b.option2, b.amount, p.productname, p.imagename, p.price*b.amount price, m.nickname FROM s_basket  b LEFT JOIN s_product p ON b.productno = p.productno right join s_member m on m.id = p.id WHERE b.id = 'tester0001' order by b.basketidx;