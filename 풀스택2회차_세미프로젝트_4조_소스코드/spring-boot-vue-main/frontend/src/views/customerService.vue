<template>
<div>
    <div class="customerService">
        <div class="csTop">
            <table style="width: 100%">
                <tr>
                    <!-- 자주 묻는 질문 검색 -->
                    <td style="border: none; width: 50%" colspan="2">
                        <input type="text" class="search" placeholder="자주 묻는 질문 검색" style="padding: 0 20px" />
                        <button class="searchBtn">검색</button>
                    </td>
                    <!-- 전화번호 -->
                    <td style="border: none">
                        <h2>전화 문의 : 1234-5678</h2>
                    </td>
                    <!-- 1대1 문의 버튼 -->
                    <td style="border: none">
                        <router-link v-bind:to="'/otoQ'">
                            <button class="toOtoQ">1대1 문의하기</button>
                        </router-link>
                    </td>
                </tr>
            </table>
        </div>
        <!-- 자주 묻는 질문 목록 -->
        <div class="csFAQ">
            <div>
                <h2 style="text-align: left">자주 묻는 질문</h2>
            </div>
            <div>
                <table class="tableMain">
                    <tr>
                        <td><span>번호</span></td>
                        <td style="
                                    border-left: 1px rgb(197, 195, 195) solid;
                                ">
                            <span>제목</span>
                        </td>
                    </tr>
                    <tr v-for="FAQ in FAQs" :key="FAQ.number">
                        <td style="width: 10%">
                            <span v-html="FAQ.number" style="text-decoration: none"></span>
                        </td>
                        <td class="question">
                            <a href="#">{{ FAQ.question }}</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <!-- 공지사항 목록 -->
        <div class="csNotice">
            <div>
                <h2 style="text-align: left">공지 사항</h2>
            </div>
            <div>
                <table class="tableMain">
                    <tr>
                        <td><span>번호</span></td>
                        <td style="
                                    border-left: 1px rgb(197, 195, 195) solid;
                                ">
                            <span>제목</span>
                        </td>
                    </tr>
                    <tr v-for="notice in notices" :key="notice.number">
                        <td style="width: 10%">
                            <span v-html="notice.number"></span>
                        </td>
                        <td class="notice">
                            <a href="#">{{ notice.notice }}</a>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            FAQs: [{
                    number: "1",
                    question: "[구매] 세금계산서를 발급받고 싶어요.",
                },
                {
                    number: "2",
                    question: "[구매] 취소/반품했는데, 언제 환불되나요.",
                },
                {
                    number: "3",
                    question: "[구매] 고객센터 이용 시간은 어떻게되나요.(1:1 상담을 원합니다.)",
                },
                {
                    number: "4",
                    question: "[배송] 주문한 상품은 언제 배송되나요?",
                },
                {
                    number: "5",
                    question: "[구매] 간편회원도 쿠폰을 사용할 수 있나요?",
                },
            ],
            notices: [{
                    number: "1",
                    notice: "[공지] 구매이용약관 개정 공지 (2022년 1월 3일 시행)",
                },
                {
                    number: "2",
                    notice: "[공지] 정기점검으로 인한 서비스 일시중지 - 12월 14일(금)",
                },
                {
                    number: "3",
                    notice: "환경부 공고, '요소수 판매에 관한 조정명령' (12/8~ )",
                },
                {
                    number: "4",
                    notice: "[공지] 정기점검으로 인한 서비스 일시중지 - 11월 17일(금)",
                },
                {
                    number: "5",
                    notice: "[공지] 정기점검으로 인한 서비스 일시중지 - 10월 26일(금)",
                },
            ],
        };
    },
};
</script>

<style scoped>
.customerService {
    text-align: center;
    width: 100%;
    background-color: #fafafa;
}

.csTop {
    height: 100px;
    display: flex;
    align-items: center;
    margin: 10px 10px;
}

.search {
    font-size: 22px;
    height: 40px;
    padding: 5px 20px;
    margin: 10px;
    outline: 1px solid rgb(0, 153, 255);
    -webkit-appearance: none;
    border: none;
}

.searchBtn,
.toOtoQ {
    font-size: 22px;
    height: 42px;
    padding: 5px 20px;
    margin: 10px;
}

.csFAQ,
.csNotice {
    padding: 0 10px 10px 10px;
    margin: 20px 20px;
    border-top: 1px solid rgb(197, 195, 195);
}

.tableMain {
    width: 100%;
    border: 1px rgb(197, 195, 195) solid;
    border-collapse: collapse;
    padding: 10px 10px;
}

th,
td {
    border-bottom: 2px rgb(197, 195, 195) solid;
    padding: 5px 5px;
}

.question,
.notice {
    border-left: 1px rgb(197, 195, 195) solid;
    text-align: left;
    padding: 7px 20px;
}

:any-link {
    text-decoration: none;
    color: black;
}
</style>
