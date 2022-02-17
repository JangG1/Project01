<template>
<!-- 판매자와의 QNA -->
<div class="qna">
    <div class="qnaTitle">
        <h2 style="display: inline-block">상품 문의</h2>
        <span style="margin-left: 86%"><button style="padding: 10px 20px" @click="addOpen">문의하기</button></span>
    </div>
    <div class="questionAdd" v-if="question">
        <table style="border-collapse: collapse;">
            <tr style="text-align: center">
                <th style="width:81px">질문 내용</th>
                <td style="width: 1015px"><input type="text" style="width: 1000px" id="questionInput"></td>
                <td style="width: 151px">
                    <button style="padding: 5px 10px" @click="addQuestion">문의하기</button></td>
            </tr>
        </table>
    </div>
    <div class="qnaMain">
        <tr>
            <div>
                <th style="width: 81px">번호</th>
                <th style="width: 151px">상태</th>
                <th style="width: 651px">제목</th>
                <th style="width: 171px">문의자</th>
                <th style="width: 151px">등록일</th>
            </div>
        </tr>

        <tr v-for="qna in qnas" :key="qna.number">
            <div>
                <!-- 클릭 시 드롭다운 방식 -->
                <collapse :selected="false">
                    <div slot="collapse-header">
                        <td style="width: 80px">
                            <span v-html="qna.qnano"></span>
                        </td>
                        <td style="width: 150px">
                            <span v-html="qna.state"></span>
                        </td>
                        <td style="width: 650px; text-align: left">
                            <span v-html="qna.title"></span>
                        </td>
                        <td style="width: 170px">
                            <span v-html="qna.id.slice(0,4) + '****'"></span>
                        </td>
                        <td style="width: 150px">
                            <span v-html="qna.regdate"></span>
                        </td>
                    </div>
                    <div slot="collapse-body" style="text-align: left">
                        <td style="width: 210px; border: 0; text-align:right">
                            <span class="ic_qs">Q</span>
                        </td>
                        <td style="width: 950px; border: 0;">
                            <span v-html="qna.title"></span>
                        </td>
                    </div>
                    <div slot="collapse-body" style="text-align: left">
                        <td style="width: 210px; border: 0; text-align:right">
                            <span class="ic_as">A</span>
                        </td>
                        <td style="width: 950px; border: 0;">
                            <span v-html="qna.answer"></span>
                        </td>
                    </div>
                </collapse>
            </div>

        </tr>
    </div>
    <div style="text-align: center">
        <button @click="pageMinus" class="pageBtn">이전 페이지</button>
        <span v-for="idx in maxPage" :key="idx">
            <span v-if="idx != page" class="pageOther" @click="setPage(idx)">{{idx}}</span>
            <span v-if="idx == page" class="pageNow">{{idx}}</span>
        </span>
        <button @click="pagePlus" class="pageBtn">다음 페이지</button>
    </div>
</div>
</template>

<script>
import axios from 'axios'
// 새로고침과 페이지 이동시 로그인 상태 확인 및 유지 기능
import {
    createNamespacedHelpers
} from 'vuex';
// 로그인 상태 관련 모듈
const loginStore = createNamespacedHelpers('loginStore');
import Collapse from "@/components/productDetail/Collapse.vue";
export default {
    components: {
        Collapse: Collapse,
    },
    data() {
        return {
            qnas: "",
            question: false,
            page: 1,
            content: 10,
            maxPage: 0,
            prodCount: 0,
        };
    },
    methods: {
        getQna() {
            const productno = this.$route.params.id;
            axios.get(`/api/qna/count/${productno}`).then(res => {
                this.prodCount = res.data;
                this.maxPage = Math.ceil(this.prodCount / this.content);
                axios({
                    method: 'get',
                    url: `/api/qna/getQna`,
                    params: {
                        productno: productno,
                        page: 1,
                        content: this.content,
                    }
                }).then(res => {
                    this.qnas = res.data;
                })
            });
        },
        pageMinus() {
            const productno = this.$route.params.id;
            if (this.page > 1) {
                this.page--;
                axios({
                    method: 'get',
                    url: `/api/qna/getQna`,
                    params: {
                        productno: productno,
                        page: this.page,
                        content: this.content,
                    }
                }).then(res => {
                    this.qnas = res.data;
                })
            }
        },
        pagePlus() {
            const productno = this.$route.params.id;
            if (this.page < this.maxPage) {
                this.page++;
                axios({
                    method: 'get',
                    url: `/api/qna/getQna`,
                    params: {
                        productno: productno,
                        page: this.page,
                        content: this.content,
                    }
                }).then(res => {
                    this.qnas = res.data;
                })
            }
        },
        setPage(idx) {
            const productno = this.$route.params.id;
            this.page = idx;
            axios({
                method: 'get',
                url: `/api/qna/getQna`,
                params: {
                    productno: productno,
                    page: this.page,
                    content: this.content,
                }
            }).then(res => {
                this.qnas = res.data;
            })
        },
        addOpen() {
            if (this.getLogin == null) {
                alert('로그인을 해주세요');
            } else {
                this.question = !this.question;
            }
        },
        addQuestion() {
            let que = document.getElementById('questionInput').value;
            const id = this.$route.params.id;
            axios({
                method: 'post',
                url: `/api/qna/${id}`,
                params: {
                    title: que,
                    id: this.getLogin.user_id,
                }
            })
            alert('질문을 등록하셨습니다');
            this.question = false;
            this.$router.go();
        },
        // 로그아웃 상태로 전환
        ...loginStore.mapMutations([
            'Logout'
        ]),
    },
    computed: {
        // 로그인한 유저정보를 반환
        ...loginStore.mapGetters(['getLogin'])
    },
    mounted() {
        this.getQna();
    },
};
</script>

<style scoped>
.qnaMain {
    width: 1600px;
    text-align: center;
    border-collapse: collapse;
}

td,
th {
    padding: 10px;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

body {
    padding: 1rem;
}

.thTemp {
    margin: 0 0;
}

.questionAdd {
    height: auto;
    margin-bottom: 20px;
}

.ic_qs,
.ic_as {
    font-size: 22px;
    font-weight: bold;
}

.ic_as {
    color: rgb(21, 170, 21);
}

.pageBtn {
    padding: 5px 10px;
    margin: 0 10px
}

.pageNow {
    font-size: 22px;
    margin: 0 5px;
}

.pageOther {
    margin: 0 5px;
}
</style>
