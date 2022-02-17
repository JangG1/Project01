DROP TABLE s_review CASCADE CONSTRAINTS;

DROP SEQUENCE review_seq;

CREATE TABLE s_review (
    reviewno  NUMBER(10) PRIMARY KEY,
    productno NUMBER(10) NOT NULL,
    image     VARCHAR(50),
    content   VARCHAR(600) NOT NULL,
    id        VARCHAR(50) NOT NULL,
    CONSTRAINT fk_qnareview FOREIGN KEY ( productno )
        REFERENCES s_product ( productno )
            ON DELETE CASCADE
);

CREATE SEQUENCE review_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    'review01.jpg',
    '후기가 워낙 좋았던 모델이라 믿고 샀는데 역시나 이쁘고 너무 마음에 들어요 늦게알아서 정가보다 비싸게주고샀지먼 그래도 만족합니다',
    'tester0001'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    'review02.jpg',
    '평소 255~260신는데 발볼조금있어서 260 구매했고 잘 맞아요. 굿굿 입니다',
    'btester0002'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    'review03.jpg',
    '일단 이뻐서 마음에 들어요! 신발이 가볍고 약간 크게 나온건지 제 신발 사이즈가 257인데 255 넉넉하게 들어가요 ㅎㅎ 나일론 재질 같은 느낌이라 모양이 잘 안잡힐까 걱정했는데 괜한 걱정이었네요 ㅎㅎ 전 너무 만족합니당!!',
    'tester0005'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    'review04.jpg',
    '마감이 깔끔하지 못해요 정품인거 맞나요?;; 훔 사이즈 택표시도 흐릿해서 조금 그래요..',
    'ctester0003'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    'review05.jpg',
    '신발 혀 뒷편에 잉크가 지워져있네요 신발끈은 이물질 묻어있구요',
    'tester0004'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    1,
    '2022-01-28 103400.jpg',
    '무난한 디자인에 색깔도 매번 블랙으로 신다가 회색이라 밝고 좋네요 볼이 넉넉해서 편안하게 신을 수 있겠어요. 뉴발란스신발은 처음인데 튼튼해보여서 좋아요',
    'tester0004'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    2,
    '2022-01-28 103734.jpg',
    '평소27입는데 사이즈 살짝여유있어서 불편하지않게 잘맞아요. 블랙주문했는데 약간 빛바랜듯한느낌의 블랙?이네요. 그래서 차콜같이 보였어요. 안에 기모가 있어서 입을때 부드럽고 따뜻해요 얇지도 두껍지도않은 딱겨울기모에요 적당한두께라서 입었을때 부해보이지않고 좋았어요',
    'tester0010'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    2,
    '2022-01-28 104142.jpg',
    '면이라 재질도 맘에들고 9330원 세트 가격 대만족임. 다만 라지 사이즈 받아보니 105되있던데 정말 큼. 티는 남자가 입어도 남을만큼 크고 바지는 허리는 편하나 기장이 좀 짧음. 55,66입는데 동생이랑 깔별루 같이 입으려구 샀다가 너무 커서 새로 주문하려고 보니 딜이 끝났네요 ㅜㅜ',
    'tester0009'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    3,
    '2022-01-28 104341.jpg',
    '두께감도 독톡하고 따뜻합니다. 무게감은 좀 있구요 소재도 모람량이 높아요. 가격도 저렴하고 디자인도 오버핏이라 예쁩니다',
    'tester0008'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    3,
    '2022-01-28 104455.jpg',
    '싸이즈딱이고 저럼하게 잘구매해서 사입습니다',
    'tester0007'
);

INSERT INTO s_review VALUES (
    review_seq.NEXTVAL,
    4,
    '2022-01-28 104606.jpg',
    '점퍼 앞판이 원래 저런 디자인건지ㅠ.왼쪽가슴윗부분에 찍찍이가 붙어있네요.상표브랜드가 있는데 ㅠ. 짝퉁느낌이네요',
    'tester0006'
);

COMMIT;

SELECT
    *
FROM
    s_review;
    

--SELECT id FROM s_product WHERE productno = 1;
--select s_product.productno, s_product.imagename, sum(s_order.totalprice) totalsell from s_product left join s_order on s_product.productno = s_order.productno where s_product.id = (SELECT id FROM s_product WHERE productno = 1) and s_order.totalprice > 0 group by s_product.productno, s_product.imagename order by totalsell desc;