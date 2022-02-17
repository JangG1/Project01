<template>
<div>
    <div class="top">
        <router-link class="pageLink" v-bind:to="'/'">
            <div class="logo">
                <router-link v-bind:to="'/'"> <img src="@/assets/logo.jpg" alt="logo" style="width:65px; height:65px; "></router-link>
            </div>
        </router-link>
    </div>
    <div class="container">
        <div class="leftSide">
            <item v-on:click="selectedComponent = 'appTest1', changeSelected(0)" class="leftButton" :class=' { "selected": selected == 0 } '>상품관리</item>
            <item v-on:click="selectedComponent = 'appTest2', changeSelected(1), productno= ''" class="leftButton" :class=' { "selected": selected == 1 } '>상품등록</item>
            <item v-on:click="selectedComponent = 'appTest3', changeSelected(2)" class="leftButton" :class=' { "selected": selected == 2 } '>주문관리</item>
        </div>
        <div class="body">
            <div class="">
                <component v-bind:is="selectedComponent" v-on:set-productno="getProductNo" v-bind:sendProduct="productno" />
            </div>
        </div>
    </div>
</div>
</template>

<script>
import test1 from "@/components/seller/SalesList.vue"
import test2 from "@/components/seller/AddSales.vue"
import test3 from "@/components/seller/OrderList.vue"
import {
    createNamespacedHelpers
} from 'vuex';
// 로그인 상태 관련 모듈
const loginStore = createNamespacedHelpers('loginStore');
export default {
    data() {
        return {
            productno: '',
            selectedComponent: 'appTest1',
            selected: 0,
        }
    },
    components: {
        appTest1: test1,
        appTest2: test2,
        appTest3: test3,
    },
    methods: {
        changeSelected(idx) {
            this.selected = idx;
        },
        getProductNo(productno) {
            this.productno = productno;
            this.selectedComponent = 'appTest2',
                this.changeSelected(1)
        }
    },
    computed: {
        // 로그인한 유저정보를 반환
        ...loginStore.mapGetters(['getLogin'])
    },
}
</script>

<style scoped>
.top {
    height: 100px;
}

.container {
    display: flex;
}

.leftSide {
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
    width: 200px;
    height: 1000px;
}

.leftButton {
    display: block;
    background-color: white;
    text-align: center;
    font-size: 20px;
    padding : 10px 0 10px 0;
}

.body {
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
    width: 1100px;
    height: 1000px;
    margin-left: 30px;
}

.item {
    display: block;
    margin-bottom: 20px;

}

.item:hover {
    cursor: pointer;
}

.selected {
    background-color:  rgb(0, 153, 255);
    color: white;
}
</style>
