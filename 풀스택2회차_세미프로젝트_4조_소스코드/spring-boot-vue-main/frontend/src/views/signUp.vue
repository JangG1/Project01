<template>
<div class="signUp">
    <div class="header">
        <div class="logo">
              <router-link v-bind:to="'/'"> <img src="@/assets/logo.jpg" alt="logo" style="width:65px; height:65px"></router-link>
        </div>
        <div class="sequence">
            <ul class="sequenceMenu">
                <li>1 회원선택</li>
                <li>2 약관동의</li>
                <li>3 정보입력</li>
                <li>4 가입완료</li>
            </ul>
        </div>
    </div>
    <hr>
    <!-- section --------------------------------------------- -->
    <div class="container">
        <div class="Box">
            <div class="imgBox">
                <img src="@/assets/signUp.jpg" class="banner">
                <router-link v-bind:to="'/join1'"> <button class="simpleSignUpBtn">회원가입 </button></router-link>
            </div>
            <div class="content">
                <div class="seller">
                    <h3>셀러 회원이신가요?</h3>
                </div>
                <div class="sellerSignUp">
                    <h3>셀러 회원</h3>
                    <router-link v-bind:to="'/join2'"> <button class="sellerSignUpBtn">셀러 회원가입</button></router-link>

                </div>
            </div>
        </div>
    </div>
    <div class="clear"></div>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
.logo{
    margin-top: 25px;
    margin-bottom: 10px;
}
h1{
    font-size: 32px;
}
h2{
    font-size: 22px;
}
h3{
    font-size: 18px;
}
p, label, span{
    font-size: 16px;
}

li{
    font-size: 17px;
    font-weight: 1000;
}
.signUp {
 background-color: #fafafa;
}
.banner{
    border-radius: 8px;
    width: 1150px;
    height: 500px;
}
.header {
    display: flex;

}
hr{
    margin-left: 85px;
    margin-right: 85px;
    border-color: rgb(177, 171, 171);
}
.header * {
    margin-left: auto;
    margin-right: auto;
}

.header>.sequence {
    width: 50%;
    position: relative;
    padding-top: 0;
    padding-bottom: 0;
}

.sequenceMenu {
    position: absolute;
    left: 47%;
    top: 75%;
    transform: translate(-50%, -50%);
    display: flex;
    list-style: none;
    margin: 0;
    padding: 0;
    margin-left: 200px;
}

.sequenceMenu li {
    width: 100px;
}

.container>.box {
    position: relative;
    text-align: center;
}

.imgBox {
    display: block;
    text-align: center;
}

.simpleSignUpBtn {
    position: absolute;
    left: 50%;
    top: 45%;
    transform: translate(-50%, -50%);
    background-color: #00ba54;
    border: 1px solid;
    border-color: white;
}

.content {
    display: flex;
}

.content>div {
    width: 25%;
    height: 200px;
    margin-left: 220px;
    margin-bottom: 100px;
}

.seller {
    margin-top: 70px;
    position: relative;
    border: 2px solid;
    border-radius: 8px;
    margin-right: 10px;
    border-color: rgb(177, 171, 171);
    background-color: rgb(243, 240, 240);
}

.seller h3 {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    padding: 0;
    margin: 0;
 
}

.sellerSignUp {
    margin-top: 70px;
    position: relative;
    display: block;
    border: 2px solid;
    border-radius: 8px;
    border-color: rgb(177, 171, 171);
    background-color: rgb(243, 240, 240);
}

.sellerSignUp>h3 {
    margin-top: 50px;
    text-align: center;
}

.sellerSignUpBtn {
    position: absolute;
    left: 50%;
    top: 65%;
    transform: translate(-50%, -50%);
    width: 180px;
    height: 50px;
    font-size: 20px;
    padding: 0 10px;
    text-align: center;
    border: 2px solid;
    border-color: white;
}


</style>