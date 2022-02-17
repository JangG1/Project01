DROP TABLE s_order CASCADE CONSTRAINTS;

DROP SEQUENCE order_seq;

CREATE TABLE s_order (
    orderidx       NUMBER(20) PRIMARY KEY,
    id             VARCHAR2(20) NOT NULL,
    productno      NUMBER(9) NOT NULL,
    selectedoption VARCHAR2(100) NOT NULL,
    amount         NUMBER(6) NOT NULL,
    totalprice     NUMBER(10) NOT NULL,
    orderdate      DATE DEFAULT sysdate,
    state          VARCHAR2(20) DEFAULT '결제완료',
    ordermethod    VARCHAR2(40) NOT NULL,
    seller         VARCHAR2(40) NOT NULL,
    dname          VARCHAR2(50) NOT NULL,
    dtel           VARCHAR2(11) NOT NULL,
    dzipcode       VARCHAR2(5) NOT NULL,
    daddress       VARCHAR2(200) NOT NULL,
    ddetailaddr    VARCHAR2(50) NOT NULL,
    CONSTRAINT fk_ordmem FOREIGN KEY ( id )
        REFERENCES s_member ( id )
            ON DELETE CASCADE,
    CONSTRAINT fk_ordprod FOREIGN KEY ( productno )
        REFERENCES s_product ( productno )
            ON DELETE CASCADE
);

CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    1,
    'a',
    1,
    3373800,
    '2019-01-01',
    '배송 완료',
    '무통장 입금',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    1,
    'b',
    1,
    73800,
    '2019-02-25',
    '취소 요청',
    '카드',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    2,
    'a',
    1,
    73800,
    '2019-03-10',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    2,
    'b',
    1,
    73800,
    '2019-04-10',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    3,
    'a',
    1,
    73800,
    '2019-05-10',
    '배송중',
    '무통장 입금',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    3,
    'b',
    1,
    73800,
    '2019-06-15',
    '취소 완료',
    '카드',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    1,
    'a',
    1,
    73800,
    '2019-07-10',
    '배송중',
    '휴대폰 결제',
    '신세계몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0001',
    14,
    'a',
    1,
    73800,
    '2019-08-10',
    '결제 완료',
    '카드',
    '롯데아이몰',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0004',
    4,
    '2',
    1,
    1200000,
    '2019-09-19',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터4',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0005',
    5,
    '2',
    1,
    1500000,
    '2019-10-19',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터5',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0006',
    6,
    '2',
    1,
    1050000,
    '2019-11-19',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터6',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0007',
    7,
    '2',
    1,
    500000,
    '2019-12-19',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터7',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0008',
    8,
    '2',
    1,
    3000000,
    '2020-01-01',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터8',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0009',
    9,
    '2',
    1,
    1000000,
    '2020-01-03',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터9',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0004',
    10,
    '2',
    1,
    2000000,
    '2020-01-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터4',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0005',
    11,
    '2',
    1,
    100000,
    '2020-04-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터5',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0006',
    12,
    '2',
    1,
    200000,
    '2021-01-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터6',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0007',
    13,
    '2',
    1,
    300000,
    '2021-02-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터7',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0008',
    14,
    '2',
    1,
    250000,
    '2021-03-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터8',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0009',
    15,
    '2',
    1,
    430000,
    '2021-04-17',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터9',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0004',
    16,
    '2',
    1,
    1231500,
    '2021-05-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터4',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0005',
    17,
    '2',
    1,
    7500600,
    '2021-06-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터5',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0006',
    18,
    '2',
    1,
    3743400,
    '2021-07-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터6',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0007',
    19,
    '2',
    1,
    12300,
    '2021-08-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터7',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0008',
    20,
    '2',
    1,
    243400,
    '2021-09-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터8',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'tester0009',
    21,
    '2',
    1,
    123500,
    '2021-10-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터9',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'btester0002',
    22,
    '2',
    1,
    85000,
    '2021-11-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터2',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'ctester0003',
    23,
    '2',
    1,
    353000,
    '2021-12-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터3',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

INSERT INTO s_order VALUES (
    order_seq.NEXTVAL,
    'ctester0003',
    24,
    '2',
    1,
    45600,
    '2022-01-23',
    '배송 완료',
    '카드',
    '신세계몰',
    '테스터3',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호'
);

COMMIT;

SELECT
    *
FROM
    s_order
ORDER BY
    orderidx;
--select * from s_order o left join s_product p on p.productno = o.productno where p.productno = 1 and o.id = 'seller0001';
--select * from s_order o left join s_product on s_product.productno = o.productno where s_product.productname like '%뉴%' and o.id = 'seller0001';
--state 종류 : 결제 완료 -> 배송중 -> 배송완료 / 취소 요청 -> 취소 완료 / 환불 요청 -> 환불 완료    
--select s_order.orderidx, s_order.productno, s_product.productname, s_order.totalprice, s_order.amount, s_order.orderdate, s_order.state from s_order left join s_product on s_order.productno = s_product.productno where s_product.sellerid = 'seller0001' order by s_order.orderdate desc;
--SELECT s_order.id, s_order.dzipcode, s_order.daddress, s_order.ddetailaddr, s_order.productno, s_order.selectedoption, s_order.totalprice, s_order.state FROM s_order, s_product WHERE s_order.productno = s_product.productnoAND s_product.sellerid = 'seller0001';    
--SELECT s_member.id 구매자id, s_order.dzipcode, s_order.daddress, s_order.ddetailaddr  FROM s_member, s_order, s_product WHERE s_member.id = s_order.id AND s_order.productno = s_product.productno AND s_product.sellerid = 'seller0001';    
--select count(orderidx) from s_order where id = 'tester0001' and state in ('결제완료', '배송중', '취소 요청');
--select s_product.productno, s_product.imagename, sum(s_order.totalprice) tot from s_product left join s_order on s_product.productno = s_order.productno where sellerid = (select sellerid from s_product where productno = 1) and s_product.productno != 1 group by s_product.productno,s_product.imagename order by tot desc;
--SELECT * FROM s_order RIGHT OUTER JOIN s_member ON s_member.id = s_order.id LEFT OUTER JOIN s_product ON s_product.productno = s_order.productno WHERE s_product.id = 'seller0001';
--SELECT * FROM s_member, s_order, s_product WHERE s_member.id = s_order.id AND s_order.productno = s_product.productno AND s_product.sellerid = 'seller0001';
--Select s_order.orderidx, s_order.productno, s_order.selectedoption, s_order.totalprice, s_order.orderdate, s_order.state, s_product.productname, s_product.sellerid, s_product.imagename from s_order, s_product, s_member where s_order.id = 'tester0001' and s_order.state in ('결제 완료', '배송중', '배송 완료')
--Select s_member.nickname from s_product left join s_member on s_product.sellerid = s_member.id where s_product.productno = 1;
--Select s_order.orderidx, s_order.productno, s_order.selectedoption, s_order.totalprice, s_order.orderdate, s_order.state, s_order.seller, s_product.productname, s_product.imagename from s_order left join s_product on s_order.productno = s_product.productno where s_order.id = 'tester0001' and s_order.orderdate  >= TO_DATE('20210127', 'YYYYMMDD') and TO_CHAR(s_order.orderdate, 'YYYYMMDD') <= '20220127' and s_product.productname like '%%' and s_order.state in ('결제 완료', '배송중', '배송 완료') order by s_order.orderdate desc;