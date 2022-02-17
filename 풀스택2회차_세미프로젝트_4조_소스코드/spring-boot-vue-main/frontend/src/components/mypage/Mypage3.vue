<template>
<div class="container">
    <!--right-->
    <div class="right">
        <div class="pList1">
            <h2>회원 탈퇴</h2>
        </div>
        <div class="tempDiv">
            <label class="labelClass" for="">비밀번호</label>
            <input v-model="password" type="password" class="mdText">
            <button class="quit" @click="quit">회원탈퇴</button>
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
            password: null,
        }
    },
    methods: {
        quit() {
            if (this.getLogin.user_auth == "USER") {
                let id = this.getLogin.user_id;
                axios.get(`/api/order/canquit/${id}`).then(res => {
                    if (res.data > 0) {
                        alert('상품 구매가 완료되지 않은 주문이 있습니다');
                        return;
                    } else {
                        axios({
                            method: "delete",
                            url: `/api/member/delete`,
                            params: {
                                id: id,
                                password: this.password,
                            }
                        }).then(res => {
                            console.log(res.status);
                            if (res.status == 200) {
                                alert("탈퇴하셨습니다.")
                                this.Logout();
                                this.$router.push("/");
                            }
                        }).catch(err => {
                            if (err.response.status == 401) {
                                alert("비밀번호가 틀렸습니다.")
                            } else {
                                console.log(err.response);
                            }
                        });
                    }
                })
            } else {
                alert('유저가 아닙니다');
            }
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

.quit {
    width: 100px;
    height: 35px;
    margin-left: 0px;
    padding: 0;
}
</style>
