<template>
<div class="review">
    <div class="reviewTitle">
        <h2>상품평</h2>
    </div>
    <div class="reviewMain">
        <table class="reviewTable">
            <tr v-for="(review, idx) in reviews" :key="idx">
                <td style="width: 10%">
                    <img :src="`/api/review/reviewImage/${review.productno}/${review.reviewno}/${review.image}`" style="width:100px; height: 100px" />
                </td>
                <td style="text-align: left">
                    <span v-html="review.content"></span>
                </td>
                <td style="width: 10%"><span v-html="review.id.slice(0,4) + '****'"></span></td>
            </tr>
        </table>
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
export default {
    data() {
        return {
            reviews: "",
            page: 1,
            content: 5,
            maxPage: 0,
            prodCount: 0,
        };
    },
    methods: {
        getReview() {
            const productno = this.$route.params.id;
            axios.get(`/api/review/count/${productno}`).then(res => {
                this.prodCount = res.data;
                this.maxPage = Math.ceil(this.prodCount / this.content);
                axios({
                    method: 'get',
                    url: `/api/review/getReview`,
                    params: {
                        productno: productno,
                        page: 1,
                        content: this.content,
                    }
                }).then(res => {
                    this.reviews = res.data;
                })
            });
        },
        pageMinus() {
            const productno = this.$route.params.id;
            if (this.page > 1) {
                this.page--;
                axios({
                    method: 'get',
                    url: `/api/review/getReview`,
                    params: {
                        productno: productno,
                        page: this.page,
                        content: this.content,
                    }
                }).then(res => {
                    this.reviews = res.data;
                })
            }
        },
        pagePlus() {
            const productno = this.$route.params.id;
            if (this.page < this.maxPage) {
                this.page++;
                axios({
                    method: 'get',
                    url: `/api/review/getReview`,
                    params: {
                        productno: productno,
                        page: this.page,
                        content: this.content,
                    }
                }).then(res => {
                    this.reviews = res.data;
                })
            }
        },
        setPage(idx) {
            const productno = this.$route.params.id;
            this.page = idx;
            axios({
                method: 'get',
                url: `/api/review/getReview`,
                params: {
                    productno: productno,
                    page: this.page,
                    content: this.content,
                }
            }).then(res => {
                this.reviews = res.data;
            })
        }
    },
    mounted() {
        this.getReview();
    }
};
</script>

<style scoped>
.reviewMain {
    width: 100%;
}

.reviewTable {
    width: 100%;
    text-align: center;
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