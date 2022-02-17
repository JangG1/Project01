DROP TABLE s_member CASCADE CONSTRAINTS;

CREATE TABLE s_member (
    id         VARCHAR2(20) PRIMARY KEY,
    nickname   VARCHAR2(50) NOT NULL,
    password   VARCHAR2(30) NOT NULL,
    name       VARCHAR2(50) NOT NULL,
    tel        VARCHAR2(11) NOT NULL,
    email      VARCHAR2(30),
    zipcode    VARCHAR2(5) NOT NULL,
    address    VARCHAR2(80) NOT NULL,
    detailaddr VARCHAR2(50) NOT NULL,
    point      NUMBER(10) DEFAULT 2000,
    authority  VARCHAR2(20) NOT NULL,
    companyno  VARCHAR2(20)
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'admin',
    'admin',
    'Admin123',
    '관리자',
    '0212345678',
    '01234',
    '서울특별시 중구 한강대로 123',
    '관리실',
    'ADMIN'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    point,
    authority
) VALUES (
    'tester0001',
    '테스터1',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호',
    3548,
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'btester0002',
    'btester0002',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '2층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'ctester0003',
    'ctester0003',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '3층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0004',
    'tester0004',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '4층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0005',
    'tester0005',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '5층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0006',
    'tester0006',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '6층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0007',
    'tester0007',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '7층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0008',
    'tester0008',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '8층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority
) VALUES (
    'tester0009',
    'tester0009',
    'Asdqwe123',
    '테스터1',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '9층 1호',
    'USER'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority,
    companyno
) VALUES (
    'seller0001',
    '신세계몰',
    'Asdqwe123',
    '신세계몰',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 1호',
    'SELLER',
    '1111111111'
);

INSERT INTO s_member (
    id,
    nickname,
    password,
    name,
    tel,
    zipcode,
    address,
    detailaddr,
    authority,
    companyno
) VALUES (
    'seller0002',
    '롯데아이몰',
    'Asdqwe123',
    '셀러2',
    '01000000000',
    '06220',
    '서울 강남구 테헤란로 212',
    '1층 2호',
    'SELLER',
    '2222222222'
);

COMMIT;

SELECT
    *
FROM
    s_member;
    
--    update s_member set point = point - 20 where id = 'tester0001';