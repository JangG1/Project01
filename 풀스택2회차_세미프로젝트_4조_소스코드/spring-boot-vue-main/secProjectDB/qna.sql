DROP TABLE s_qna CASCADE CONSTRAINTS;

DROP SEQUENCE qna_seq;

CREATE TABLE s_qna (
    qnano     NUMBER(10) PRIMARY KEY,
    productno NUMBER(10) NOT NULL,
    state     VARCHAR2(20) DEFAULT '검토중',
    title     VARCHAR2(200) NOT NULL,
    answer    VARCHAR2(2100) DEFAULT '아직 답변이 작성되지 않았습니다',
    id        VARCHAR2(20) NOT NULL,
    regdate   DATE DEFAULT sysdate NOT NULL,
    CONSTRAINT fk_qnaproduct FOREIGN KEY ( productno )
        REFERENCES s_product ( productno )
            ON DELETE CASCADE
);

CREATE SEQUENCE qna_seq START WITH 1 INCREMENT BY 1 MAXVALUE 9999999999 NOCYCLE NOCACHE;

INSERT INTO s_qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '답변완료',
    '225에 신는데 사이즈 어떻게 시켜야되나요?',
    '안녕하세요 고객님 뉴발란스 남성사이즈의 경우 여성분들은 사이즈가 넉넉하게나와 1~2치수정도 작게착용하시는 분들이 계시오나 사이즈는 개인차가 큰 부분이므로 판매자가 고객님의 정확한 개인차 및 특이사항을 확인 할 수 없어 구체적인 사이즈 답변이 어려운 점 양해바랍니다. 제품별 사이즈표와 타 고객님의 이용후기 등을 참고하시어 고객님의 발모양과 발볼 너비, 발길이 등을 고려하셔서 주문부탁드리겠습니다. 감사합니다.',
    'tester0001',
    '2021-12-20'
);

INSERT INTO s_qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '답변완료',
    '반품을 챙겨가셨는데 아직 반품처리가 안되네요',
    '안녕하세요, 신세계몰 고객센터 입니다. 문의주신 내용으로 12/28일 유선상 연락을 주셨으며, 담당 상담원분이 확인 중에 있습니다. 확인 후 고객 안내 및 처리도와 드릴 예정이오니 고객님의 소중한 시간 양해 부탁드립니다. 편안하고 행복한 하루 되십시오.',
    'tester0001',
    '2021-12-20'
);

INSERT INTO s_qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '답변완료',
    '배송완료 처리되었는데 물건이 안왔어요',
    '안녕하세요 고객님 2021-11-25목 2007 에 배송완료된것으로 확인됩니다. 택배 기사님들중에 사전 연락없이 위탁장소에 맡겨 놓으시는 경우가 있습니다.경비실, 양수기함, 무인 택배함 등 위탁 가능한 곳에도 확인해보셨는데도 제품 확인되지 않는다면 담당 기사님 연락처 010-0000-0000 로 문의부탁드립니다. 직접 통화를 해보시면 물품 위치 확인이 가능하십니다.',
    'tester0004',
    '2021-12-20'
);

INSERT INTO s_qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '답변완료',
    '하자없는상품으로 보내주세요~^^',
    '안녕하세요 고객님 주문하신 상품이 내일 출고 예정입니다. 배송은 평균적으로 1-2일[공휴일제외] 정도 소요됩니다. 실질적인 배송 수령일 관련 문의는 출고일 다음날 로젠택배[1588-9988] 로 문의하시면 정확한 안내 받으실 수 있습니다. 구매해주셔서 감사합니다.',
    'tester0005',
    '2021-12-20'
);

INSERT INTO s_qna VALUES (
    qna_seq.NEXTVAL,
    1,
    '답변완료',
    '취소신청이요. 확인해주세요',
    '안녕하세요.고객님 교환반품취소변경 접수 문의는 구매 하신 신세계 고객센터 1577-3419 로 문의주시기 바랍니다 감사합니다.',
    'tester0006',
    '2021-12-20'
);

INSERT INTO s_qna (
    qnano,
    productno,
    title,
    id
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '취소신청했는데,연락주신다더니 연락도없고..취소부탁드립니다',
    'tester0007'
);

INSERT INTO s_qna (
    qnano,
    productno,
    title,
    id
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '물건 2개 다 갔는데 1개만 반품완료? 확인 부탁드립니다.',
    'tester0008'
);

INSERT INTO s_qna (
    qnano,
    productno,
    title,
    id
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '상품과 배송잘부탁드려요.',
    'tester0009'
);

INSERT INTO s_qna (
    qnano,
    productno,
    title,
    id
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '아직 반품처리가 되지않아 문의남깁니다!',
    'ctester0003'
);

INSERT INTO s_qna (
    qnano,
    productno,
    title,
    id
) VALUES (
    qna_seq.NEXTVAL,
    1,
    '오늘출고예정 맞는거죠!!',
    'btester0002'
);

COMMIT;

SELECT
    *
FROM
    s_qna;