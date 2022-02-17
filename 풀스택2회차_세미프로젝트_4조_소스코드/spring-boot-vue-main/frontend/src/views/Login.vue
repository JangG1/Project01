<template>
<div class="login">
    <!-- 로그인 입력 양식 -->
    <div class="inputForm">
        <router-link class="logoLink" v-bind:to="'/'">
            <div class="logo">
                <router-link v-bind:to="'/'"> <img src="@/assets/logo.jpg" alt="logo" style="width:130px; height:130px;"></router-link>
            </div>
        </router-link>
        <input class="inputID" type="text" v-model="id" placeholder="아이디 입력" @keyup.enter="signIn">
        <input class="inputPWD" type="password" v-model="password" placeholder="비밀번호 입력" @keyup.enter="signIn">
        <button class="inputBtn" @click="signIn">로그인</button>
        <div class="etc">
            <div class="checkBoxDiv"><input type="checkbox" id="a"> <label for="a">자동로그인</label></div>
            <div class="findBoxDiv"><label>| 아이디찾기 | 비밀번호찾기</label></div>
        </div>
        <router-link class="signUpLink" v-bind:to="'/signUp'"><button class="signUpBtn">회원가입 </button></router-link>
    </div>
</div>
</template>

<script>
// import axios from 'axios'
import {
    createNamespacedHelpers
} from 'vuex'
const loginStore = createNamespacedHelpers('loginStore')
export default {
    data() {
        return {
            id: '',
            password: '',
            msg: '',
        }
    },
    methods: {
        // 로그인 버튼을 눌렀을 때 아이디, 비밀번호 검사
        signIn() {
            if (this.id == '') {
                alert("아이디를 입력해주세요")
            } else if (this.password == '') {
                alert("비밀번호를 입력해주세요")
            } else {
                this.Login({
                    id: this.id,
                    password: this.password
                })
            }
        },
        ...loginStore.mapActions([
            'Login'
        ]),
        ...loginStore.mapMutations([
            'setPath'
        ])
    },
    computed: {
        ...loginStore.mapGetters(['getLogin']),
        // ...loginStore.mapGetters(['getPath']),
    },
    mounted() {
        if (this.$route.params.nextPage != null)
            this.setPath(`${this.$route.params.nextPage}`)
        else
            this.setPath('/')
    }
}
</script>

<style scoped>
.login {
    height: 950px;
    text-align: center;
    margin: 0 auto;

}

.inputForm {
    display: block;
    position: relative;
    left: 50%;
    top: 40%;
    transform: translate(-50%, -50%);
    text-align: center;
    width: 400px;
    padding: 50px;
    margin: 0;
    background-color: #f0f0f0;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.etc {
    background-color: white;
}

.inputID,
.inputPWD {
    outline: 1px solid rgb(0, 153, 255);
    -webkit-appearance: none;
    border: none;
    width: 386px;
    height: 40px;
    margin: 0;
    padding: 5px;
    font-size: 15px;
}

.inputID {
    margin-top: 10px;
    border-radius: 4px 4px 0 0;
}

.inputBtn {
    border-radius: 0;
    border: none;
    color: white;
    text-decoration: none;

    width: 398px;
    font-size: 20px;
    height: 50px;
    margin: 0;
    padding: 5px 0 5px 0;
    font-size: 25px;
}

.etc {
    display: flex;
    border: 1px solid rgb(0, 153, 255);
    height: 40px;
    width: 396px;
    margin-left: 1px;
}

.etc>* {
    margin: 10px 0px;
}

.findBoxDiv {
    margin-right: 5px;
    margin-left: auto;
}

.signUpBtn {
    width: 398px;
    border-radius: 0 0 4px 4px;
    padding: 5px 0 5px 0;
    font-size: 25px;
}

.signUpLink {
    text-decoration: none;
}

.logo {
    width: 130px;
    height: 130px;
    margin-left: auto;
    margin-right: auto;
}

.logo>p {
    width: 130px;
    font-size: 100px;
}
</style>
