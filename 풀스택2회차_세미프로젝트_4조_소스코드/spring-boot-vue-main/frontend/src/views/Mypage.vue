<template>
<div>
    <!--top-->
    <div class="top" style="text-align:center">

        <h1>마이페이지</h1>
    </div>
    <div class="container">
        <!--left-->
        <div class="left">
            <div class="List1">
                <router-link v-bind:to="'/Mypage'">
                    <h3>나의쇼핑내역</h3>
                </router-link>
                <hr>
            </div>
            <div class="Check">
                <a href="">주문/배송 조회</a><br>
                <a href="">취소/반품/교환 신청</a><br>
                <a href="">취소/반품/교환 현황</a><br>
                <a href="">환불/입금내역</a><br>
                <a href="">영수증/소득공제</a><br>
            </div>
            <div class="List2">
                <router-link v-bind:to="'/Mypage2'">
                    <h3>회원정보 열람</h3>
                </router-link>
                <hr>
            </div>
            <div class="Check">
                <router-link v-bind:to="'/Mypage2'">
                    회원정보 변경
                </router-link>
                <br>
                <a href="">로그인 관리</a><br>
                <a href="">개인정보 이용내역</a><br>
                <router-link v-bind:to="'/Mypage3'">
                    회원탈퇴
                </router-link>
            </div>
        </div>
        <!--right-->
        <div class="right">
            <router-view></router-view>
        </div>

    </div>
</div>
</template>

<script>
export default {
    data() {
        return {}
    },
    computed: {},
    methods: {

    },
    mounted() {

    }
}
</script>

<style scoped>
a {
    text-decoration: none;
    color: inherit;
    margin-left: 15px;
}

hr {
    width: 200px;
}

.top {
    margin-left: 70px;
}

.container {
    display: flex;
    border: none;
}

.left {
    display: inline-block;
    height: 1095px;
    border: 1px solid rgb(197, 195, 195);
    background-color: #fafafa;
    border-radius: 4px;
    width: 210px;
    padding: 15px;
    padding-top: 1px;
    font-size: 18px;
}

.Check {
    margin-left: 20px;
    color: rgb(129, 124, 124);
    border-color: inherit;
    line-height: 35px;
    font-size: 18px
}

.Check li {
    width: 150px;
    padding: 0;
    margin: 10px 0px;
}

.List1,
.List2 {
    text-align: center;
    padding-top: 15px;
    padding-bottom: 10px;
    margin-right: 20px;
    font-size: 22px;
}

.List2 {
    padding-top: 70px;
}

.right {
    margin-left: 50px;
}
</style>
