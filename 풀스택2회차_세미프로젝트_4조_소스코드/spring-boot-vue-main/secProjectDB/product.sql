DROP TABLE s_product CASCADE CONSTRAINTS;

DROP SEQUENCE prod_seq;

CREATE TABLE s_product (
    productno       NUMBER(9) PRIMARY KEY,
    sellerid        VARCHAR2(20) NOT NULL,
    productname     VARCHAR2(200) NOT NULL,
    ptype           VARCHAR2(50) NOT NULL,
    imagename       VARCHAR2(500) NOT NULL,
    price           NUMBER(10) NOT NULL,
    option1         VARCHAR2(2000) NOT NULL,
    option2         VARCHAR2(2000) NOT NULL,
    amount          NUMBER(6) DEFAULT 0,
    regdate         VARCHAR2(30),
    detailimagename VARCHAR2(500) NOT NULL,
    onsale          CHAR(1) DEFAULT 0,
    CONSTRAINT fk_prodmem FOREIGN KEY ( sellerid )
        REFERENCES s_member ( id )
);

CREATE SEQUENCE prod_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[뉴발란스] 남여공용 574/327/530 운동화 씨쏠트 문빔',
    '신발',
    '1.jpg',
    23800,
    '상품 번호;01.NB_CM997HCA;02.NB_CM997HCC;03.NB_ML574RC2;04.NB_MR530SG;05.NB_MR530KA;06.NB_MS327FE;07.NB_MS327LAB;08.NB_MS327CPG;09.NB_MS327LH1;10.NB_WS327KC;11.NB_MS327WE;12.NB_MS327BD;13.NB_MR530SH;14.NB_WS327LW;15.NB_MS327CLA;16.NB_ML574EVB;17.NB_ML574EVG;18.NB_ML574EVW;19.NB_ML574EVE',
    '사이즈;225;230;235;240;245;250;255;260;265;270;275;280;285;290',
    1,
  '2022.01.01 12:00',
    'productDetail01.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[닉스/카이아크만외]케이브랜즈 시즌오프 ~87%+25%쿠폰! 겨울다운/기모티/플리스외',
    '상의/아우터/여성의류/남성의류',
    '2.jpg',
    10500,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.02 12:00',
    'intro.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[마인드브릿지]본사 단독연말세일! 정해인 신상/이월 겨울인기템',
    '아우터/여성의류/남성의류',
    '3.jpg',
    13000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.03 12:00',
    'intro.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '컬럼비아 유니버시티 신년맞이 겨울 시즌 오프 SALE',
    '상의/남성의류',
    '4.jpg',
    16900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.04 12:00',
    'intro_0119.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[어스앤뎀/유지아이지/케이스위스]남녀공용/패딩/맨투맨',
    '상의/아우터/여성의류/남성의류',
    '5.jpg',
    11000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.05 12:00',
    '5f995d3e-e36c-4da0-9fe5-f44374c14da4_1640538764389.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '비트로 엄스톤(화이트/블랙) 발 볼 넓은 테니스화',
    '신발',
    '6.jpg',
    155000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.06 12:00',
    '비트로 엄스톤 화이트,블랙 상세설명.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[슈망] 남녀공용 신발 스니커즈 슬립온 단화 운동화 러닝화 슬리퍼 모음전!',
    '신발',
    '7.jpg',
    9900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.07 12:00',
    'new.jpg',
    0
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    'SOVO 겨울Best 여성부츠 앵클 롱 미들 삭스 구두 워커 로퍼 슬리퍼 스니커즈 정장 캐쥬얼',
    '신발',
    '8.jpg',
    19900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.08 12:00',
    '1835339176.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    'TOMS 남성용 Carlo 미드 터레인 스니커즈, 방수 토파즈 브라운',
    '신발',
    '9.jpg',
    73960,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.09 12:00',
    '8db1f838-ee20-4b38-ba10-31346447bb73.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0001',
    '[솔로이스트] SACKDH06',
    '아우터/여성의류',
    '10.jpg',
    72040,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.10 12:00',
    'A.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[25%쿠폰][지오송지오 外] 홈쇼핑 BEST 100/겨울 클리어런스 역대급 득템찬스!',
    '상의/아우터/여성의류',
    '11.jpg',
    59000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.11 12:00',
    'A_4.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '로레알파리 한소희 헤어팩/오일/샴푸/컨디셔너/염색약',
    '헤어',
    '12.jpg',
    19900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.12 12:00',
    '1368439939.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    'Razer Xbox 시리즈 X|S용 범용 고속 충전 스탠드 마그네틱 안전 충전',
    '전자 제품',
    '13.jpg',
    63170,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.13 12:00',
    '1429899c-5104-4acc-8465-5b370022c4c8.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[코코블랑]예뻐지는코디/기모/데일리룩/데이트룩/패딩/팬츠/맨투맨/원피스',
    '여성의류/상의/하의/원피스',
    '14.jpg',
    7900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.14 12:00',
    'A_1.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[제이엘프]겨울인기/시즌오프 데일리룩/팬츠/니트/원피스/울자켓/패딩/어나더리즈/청순',
    '여성의류/상의/하의/원피스',
    '15.jpg',
    16900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.15 12:00',
    'jellpe-main.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[기프티박스]코디맛집/기모/폴라/맨투맨/패딩/니트/원피스/팬츠/파자마',
    '여성의류/상의/하의/원피스',
    '16.jpg',
    10000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
 '2022.01.16 12:00',
    '3bd35944-0562-4c32-b4e6-17e87b4a81f0_1641960582596.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[업타운홀릭]인기템99종!맨투맨/슬랙스/니트/가디건/트레이닝 외',
    '여성의류/상의/하의/원피스',
    '17.jpg',
    18000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
    '2022.01.17 12:00',
    '5cd_image_01.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[리얼코코]대표데일리룩/데이트룩/기모/원피스/패딩/니트/맨투맨/데님',
    '여성의류/상의/하의/원피스',
    '18.jpg',
    14900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.18 12:00',
    '0120.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[나크21] 사랑스러운 데이트룩/하객룩/니트/블라우스/팬츠/원피스~',
    '여성의류/상의/하의/원피스',
    '19.jpg',
    12900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
  '2022.01.19 12:00',
    'intro.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '갤럭시 GALAX 지포스 RTX 3080 SG D6X 10GB',
    '전자 제품',
    '20.jpg',
    5000000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.20 12:00',
    'bt.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '트렌디스타일 남성,공용 양털,패딩점퍼,패딩조끼,청자켓 모음',
    '남성의류/상의/아우터',
    '21.jpg',
    36900,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.21 12:00',
    'd1.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '아이리버 BS-BT101 무선블루투스헤드폰 5.0 노이즈캔슬링 접이식 스마트폰 헤드셋',
    '전자 제품',
    '22.jpg',
    49000,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
    '2022.01.22 12:00',
    '01_2.jpg',
    1
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[20매+6]김태희 마스크 아이바나리 KF-AD 새부리형 대형 중형 6가지 색상',
    '잡화',
    '23.jpg',
    16980,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
   '2022.01.23 12:00',
    '1622826005597_E.jpg',
    0
);

INSERT INTO s_product VALUES (
    prod_seq.NEXTVAL,
    'seller0002',
    '[시크루즈]50+30% 따뜻한 기모원피스/루즈핏 원피스/상하세트/트레이닝/롱티셔츠/니트/조거팬츠',
    '여성의류/상의/하의/원피스',
    '24.jpg',
    9700,
    '옵션1;1;2;3;4',
    '옵션2;a;s;d;f',
    1,
    '2022.01.24 12:00',
    '220122_A.jpg',
    0
);

COMMIT;

SELECT
    *
FROM
    s_product
ORDER BY
    productno;

--select * from s_product where sellerid = 'seller0002' order by regdate;
--SELECT imagename, productname, productno, price FROM s_product;    
--select prod_seq.nextval from dual;
--select s_product.productno, s_product.productname, s_product.ptype, s_product.imagename, s_product.price, s_product.id, s_member.nickname from s_product left join s_member on s_product.id = s_member.id where UPPER(productname) like UPPER('%여성의류%') or UPPER(ptype) like UPPER('%여성의류%') order by s_product.productno;
--select count(productno) from s_product where price > 20000 and price < 999999999999 and (UPPER(productname) like UPPER('%여성의류%') or UPPER(ptype) like UPPER('%여성의류%'));
--select count(productno) from s_product where price >= 20000 and price <= 9999999 and (UPPER(productname) like UPPER('%여성의류%') or UPPER(ptype) like UPPER('%여성의류%'))