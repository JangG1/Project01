<template>
<!-- 내용 -->
<div>
    <!-- 탭을 이용함 -->
    <div class="tabs">
        <TabItem v-for="item in list" v-bind="item" :key="item.id" v-model="currentId" class="tabTop" />
    </div>
    <!-- 중간부분 -->
    <div class="contents">
        <transition>
            <section class="item" :key="currentId">
                <!-- 상품 상세 정보 -->
                <div v-if="currentId === 1">
                    <img :src="`/api/product/detailimage/${prod.productno}/${prod.detailimagename}`" style="margin: 0 auto" />
                </div>
                <!-- 리뷰 -->
                <div v-else-if="currentId === 2">
                    <review></review>
                </div>
                <!-- 판매자와의 QNA -->
                <div v-else-if="currentId === 3">
                    <qna></qna>
                </div>
            </section>
        </transition>
    </div>
    <!-- 하단 탭버튼 -->
    <div class="tabs">
        <TabItem v-for="item in list" v-bind="item" :key="item.id" v-model="currentId" class="tabBottom" />
    </div>
</div>
</template>

<script>
import TabItem from "./TabItem.vue";
import review from "./review.vue";
import qna from "./qna.vue";
import axios from 'axios'
export default {
    components: {
        TabItem,
        review,
        qna,
    },
    data() {
        return {
            currentId: 1,
            prod: "",
            list: [{
                    id: 1,
                    label: "상품 상세 정보",
                },
                {
                    id: 2,
                    label: "상품 리뷰",
                },
                {
                    id: 3,
                    label: "상품 문의",
                },
            ],
        };
    },
    methods: {
        getProd() {
            const id = this.$route.params.id;
            axios.get(`/api/product/productDetail/${id}`).then(res => this.prod = res.data);
        },
    },
    computed: {
        current() {
            return this.list.find((el) => el.id === this.currentId) || {};
        },
    },
    mounted() {
        this.getProd();
    }
};
</script>

<style scoped>
.tabs {
    width: 200%;
}

.tabTop {
    border-top-left-radius: 4px;
    border-top-right-radius: 4px;
}

.tabBottom {
    border-top-left-radius: 0;
    border-top-right-radius: 0;
    border-bottom-left-radius: 4px;
    border-bottom-right-radius: 4px;
}

.contents {
    position: relative;
    width: 100%;
    border: 1px solid rgb(0, 153, 255);
    margin-left: 1px;
    overflow-y: auto;
    overflow-x: hidden;
    max-height: 1600px;
}

.item {
    box-sizing: border-box;
    padding: 10px;
    width: 100%;
    /* transition: all 0.8s ease; */
}

/* 트랜지션 전용 스타일 */
.v-leave-active {
    position: absolute;
}

.v-enter {
    transform: translateX(-100%);
}

.v-leave-to {
    transform: translateX(100%);
}

img {
    width: 80%;
    display: block;
    margin: 0px auto;
}
</style>
