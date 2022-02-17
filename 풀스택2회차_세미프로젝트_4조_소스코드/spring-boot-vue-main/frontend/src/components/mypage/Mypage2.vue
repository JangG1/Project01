<template>
<div class="container">
    <!--top-->

    <!--right-->
    <div class="right">
        <div class="pList1">
            <h2>회원 정보 변경</h2>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">닉네임</label>
            <input type="text" class="mdText" v-model="putnick">
            <button class="classBtn" @click="nickMod"> 수정하기 </button>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">비밀번호</label>
            <input v-model="signup.password" type="password" class="mdText" @keyup="passwordValid">
            <!-- <div for="" style="display:inline-block; width:100px;"></div> -->
            <div v-if="!passwordValidFlag" class="pwFlag hiddenArea wrongInput"> 유효하지 않은 비밀번호 입니다. </div>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">비밀번호확인</label>
            <input v-model="passwordCheck" type="password" name="비밀번호 확인" class="mdText" @keyup="passwordCheckValid">
            <button class="classBtn" @click="pwMod"> 수정하기 </button>
            <div v-if="!passwordCheckFlag" class="re_pwFlag hiddenArea  wrongInput"> 비밀번호가 동일하지 않습니다. </div>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">전화번호</label>
            <input v-model="putNum" type="text" class="mdText" @keyup="numValid" placeholder="- 없이 숫자만" maxlength="11">
            <button class="classBtn" @click="numMod"> 수정하기 </button>
            <div v-if="!numValidFlag" class="numFlag hiddenArea  wrongInput"> 유효하지 않은 전화번호 입니다. </div>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">*우편번호</label>

            <input type="text" class="mdText" v-model="postcode" placeholder="우편번호" @click="execDaumPostcode()">
            <span>
                <button type="button" class="classBtn" @click="execDaumPostcode()">주소검색</button>
            </span>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">*주소</label>
            <input type="text" class="mdText" id="address" v-model="address" placeholder="주소">

        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">*상세주소</label>
            <input type="text" class="mdText" id="detailAddress" placeholder="상세주소" v-model="putadd">
            <button class="classBtn" @click="addMod"> 수정하기 </button>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
import {
    createNamespacedHelpers
} from "vuex";
const loginStore = createNamespacedHelpers("loginStore");
export default {
    data() {
        return {
            postcode: "",
            address: "",
            extraAddress: "",
            signup: {
                password: null,
                putNum: null,
            },
            passwordValidFlag: true,
            passwordCheck: '',
            passwordCheckFlag: true,
            numValidFlag: true,
            putNum: '',
            putnick: '',
            putadd: '',
            msg: '',
        }
    },
    methods: {
        nickMod() { // 닉네임 수정버튼 이벤트
            try {
                if ("" === this.putnick) {
                    alert("수정할 닉네임을 입력해주세요.");
                } else {
                    axios({
                        method: 'put',
                        url: '/api/member/nickname',
                        params: {
                            id: this.getLogin.user_id,
                            nickname: this.putnick,
                        }
                    })
                    alert("수정 되었습니다.");
                    this.$router.go();
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        passwordValid() { // 비밀번호 유효성 검사 및 플래그
            this.passwordCheckValid();
            if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.signup.password)) {
                this.passwordValidFlag = true
            } else {
                this.passwordValidFlag = false
            }

        },
        passwordCheckValid() { // 비밀번호 재확인 - 비밀번호 일치 여부 검사 및 플래그
            if (this.signup.password === this.passwordCheck) {
                this.passwordCheckFlag = true;
                this.checkRePwdFlag = true;
            } else {
                this.passwordCheckFlag = false;
                this.checkRePwdFlag = false;
            }
        },
        pwMod() { // 비밀번호 수정버튼 이벤트
            try {
                console.log(this.signup.password);
                if (this.signup.password === null) {
                    alert("수정할 비밀번호를 입력해주세요.");
                } else if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.signup.password)) {
                    if (this.passwordValidFlag == true) {
                        if (this.signup.password === this.passwordCheck) {
                            axios({
                                method: 'put',
                                url: '/api/member/password',
                                params: {
                                    id: this.getLogin.user_id,
                                    password: this.signup.password,
                                }
                            })
                            alert("수정 되었습니다.");
                            this.$router.go();
                        } else {
                            alert("비밀번호와 비밀번호 확인이 다릅니다")
                        }
                    }
                } else {
                    if (!this.passwordValidFlag == true)
                        alert("비밀번호 형식은 대문자,소문자,숫자 포함 8~16글자 입니다.");
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        numValid() { // 휴대전화번호 유효성 검사 및 플래그
            if (/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(this.putNum)) {
                this.numValidFlag = true
            } else {
                this.numValidFlag = false
            }

        },
        numMod() { // 휴대전화 번호 수정버튼 이벤트
            try {
                if ("" === this.putNum) {
                    alert("수정할 전화번호를 입력해주세요.");
                } else if (/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(this.putNum)) {
                    axios({
                        method: 'put',
                        url: '/api/member/tel',
                        params: {
                            id: this.getLogin.user_id,
                            tel: this.putNum,
                        }
                    })
                    alert("수정 되었습니다.");
                    this.$router.go();
                } else {
                    alert("전화번호를 확인해주세요.")
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        addMod() { // 주소 수정버튼 이벤트
            try {
                if ("" === this.putadd) {
                    alert("수정할 주소를 입력해주세요.");
                } else {
                    axios({
                        method: 'put',
                        url: '/api/member/address',
                        params: {
                            id: this.getLogin.user_id,
                            zipcode: this.postcode,
                            address: this.address,
                            detailaddr: this.putadd,
                        }
                    })
                    alert("수정 되었습니다.");
                    this.$router.go();
                }
            } catch (err) {
                this.msg = "error";
            }
        },
        execDaumPostcode() { // Daum 우편번호 조회 API 인용
            new window.daum.Postcode({
                oncomplete: (data) => {
                    if (this.extraAddress !== "") {
                        this.extraAddress = "";
                    }
                    if (data.userSelectedType === "R") {
                        // 사용자가 도로명 주소를 선택했을 경우
                        this.address = data.roadAddress;
                    } else {
                        // 사용자가 지번 주소를 선택했을 경우(J)
                        this.address = data.jibunAddress;
                    }

                    // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                    if (data.userSelectedType === "R") {
                        // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                        // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                        if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
                            this.extraAddress += data.bname;
                        }
                        // 건물명이 있고, 공동주택일 경우 추가한다.
                        if (data.buildingName !== "" && data.apartment === "Y") {
                            this.extraAddress +=
                                this.extraAddress !== "" ?
                                `, ${data.buildingName}` :
                                data.buildingName;
                        }
                        // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                        if (this.extraAddress !== "") {
                            this.extraAddress = `(${this.extraAddress})`;
                        }
                    } else {
                        this.extraAddress = "";
                    }
                    // 우편번호를 입력한다.
                    this.postcode = data.zonecode;
                },
            }).open();
        },
        // 로그아웃 상태로 전환
        ...loginStore.mapMutations([
            'Logout'
        ]),
    },
    computed: {
        ...loginStore.mapGetters(["getLogin"]),
    },
}
</script>

<style scoped>
.container {
    width: 1000px;
}

.right {
    margin-left: auto;
    margin-right: auto;
}

.tempDiv {
    padding-top: 30px;
}

.labelClass {
    display: inline-block;
    width: 100px;
}

.mdText {
    width: 350px;
    height: 30px;
    margin-right: 10px;
    border-radius: 4px;
    border: 1px solid;
    text-align: center;
    font-size: 16px;
}

.content1 {
    padding-top: 10px;
    text-align: center;
}

.hiddenArea {
    margin-top: 10px;
    margin-left: 100px;
    display: block;
}

.currentInput {
    color: green;
}

.wrongInput {
    color: red;
}

.classBtn {
    width: 100px;
    height: 30px;
    margin-left: 0px;
    padding: 0;
}

/* a {
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
}

.left {
    display: inline-block;
    height: 887px;
    border: 1px solid rgb(197, 195, 195);
    background-color: #fafafa;
    border-radius: 4px;
    width: 210px;
    padding: 15px;
    padding-top: 1px;
    font-size: 18px;
}

.right {
    display: inline-block;
     width: 85%;
    border: 1px solid rgb(197, 195, 195);
    margin-left: 50px;
    background-color: #fafafa;
    border-radius: 4px;
}

.right>div:not(.content1) {
    border-bottom: 1px solid rgb(197, 195, 195);
}

.List1 {
    text-align: center;
    padding-top: 15px;
    padding-bottom: 10px;
    margin-right: 20px;
    font-size: 22px;
}

.List2 {
    text-align: center;
    padding-top: 70px;
    padding-bottom: 10px;
    margin-right: 20px;
    font-size: 22px
}

.Check {
    margin-left: 20px;
    color: rgb(129, 124, 124);
    border-color: inherit;
    line-height: 35px;
    font-size: 18px
}

.check li {
    width: 150px;
    padding: 0;
    margin: 10px 0px;
}

.pList1 {
    text-align: center;
    border-bottom: 1px solid black;
}

.content {
    padding: 10px;
}

.content>h3 {
    margin-left: 150px;
}

.mdText {
    width: 350px;
    height: 30px;
    margin-right: 30px;
    border-radius: 4px;
    border: 1px solid;
    text-align: center;
    font-size: 16px;
}

.mdBtn {
    margin-left: 20px;
}

.quit {
    width: 130px;
    height: 65px;
    margin-left: 450px;
    margin-bottom: 30px;
    background-color: #00ba54;
}

.pwFlag,
.re_pwFlag,
.numFlag {
    color: red;
    margin-left: 20px;
}

.tempDiv {
    display: flex;
    margin: 40px 0 40px 0;
}

.labelClass {
    margin-left: 150px;
    padding-bottom: 40px;
    min-width: 120px;
    font-weight: bold;
}

.classBtn {
    width: 100px;
    height: 30px;
    margin-left: 10px;
    padding: 0;
} */
</style>
