<template>
<!-- 1대1 문의 -->
<div class="otoQ">
    <table>
        <tr>
            <th colspan="2" style="padding: 0 0">
                <h2>문의글 작성</h2>
            </th>
        </tr>
        <!-- 유형 선택 -->
        <tr>
            <td style="width: 20%"><span>유형</span></td>
            <td>
                <select class="qnaType">
                    <option value="회원">회원</option>
                    <option value="쿠폰/혜택/이벤트">
                        쿠폰/혜택/이벤트
                    </option>
                    <option value="주문/결제">주문/결제</option>
                    <option value="배송">배송</option>
                    <option value="취소/반품/교환">취소/반품/교환</option>
                    <option value="기타">기타</option>
                </select>
            </td>
        </tr>
        <!-- 제목(입력 필수) -->
        <tr>
            <td><span>제목</span></td>
            <td>
                <input type="text" name="제목" class="longInput inputValues" />
            </td>
        </tr>
        <!-- 내용(입력 필수) -->
        <tr>
            <td><span>내용</span></td>
            <td>
                <textarea name="내용" id="otoTextarea" class="otoTextarea inputValues" maxlength="2000" placeholder="문의 내용을 입력해주세요." style="resize: none"></textarea>
            </td>
        </tr>
        <!-- 연락처(입력 필수, 정규식) -->
        <tr>
            <td><span>연락처</span></td>
            <td>
                <p>
                    <span>
                        <input type="text" name="연락처" class="shortInput inputValues" placeholder="-없이 숫자만" id="mobile" @keyup="phoneCheck()" />
                    </span>
                    <span>
                        <span class="validate" v-if="!phoneValidate">- 없이 숫자만 입력해주세요</span>
                    </span>
                </p>
            </td>
        </tr>
        <!-- 파일 첨부 -->
        <tr>
            <td><span>파일 첨부</span></td>
            <td><input type="file" /></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <router-link class="signUpLink" v-bind:to="'/customerService'">
                    <button class="otoQBtn">취소하기</button></router-link>
                <button class="otoQBtn" type="submit" @click="QuestionRegister">
                    등록하기
                </button>
            </td>
        </tr>
    </table>
</div>
</template>

<script>
export default {
    data() {
        return {
            phoneValidate: true,
        };
    },
    methods: {
        // 전화번호 정규식 검사
        phoneCheck() {
            let mobile = document.getElementById("mobile").value;
            if (
                /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})[0-9]{3,4}[0-9]{4}$/.test(
                    mobile
                )
            ) {
                this.phoneValidate = true;
            } else {
                this.phoneValidate = false;
            }
        },
          // 유효성 검사
        QuestionRegister() {  
            const checked = document.getElementsByClassName("inputValues");
            for (var i = 0; i < checked.length; i++) {
                if (checked[i].value.length == 0) {
                    alert(`${checked[i].name}을/를 입력하세요`);
                    checked[i].focus();
                    return;
                }
            }
            if(this.phoneValidate == false){
                alert('전화번호를 확인해주세요')
            } else {
                alert("질문을 등록했습니다");
                this.$router.push("/customerService")
            }
        },
    },
};
document.getElementById("file");
</script>

<style scoped>
.otoQ {
    width: 700px;
    margin: 0 auto;
    display: flex;
    background-color: #fafafa;
}

.otoQForm {
    margin: auto;
}

.otoTextarea {
    height: 500px;
    width: 100%;
    border: 1px solid rgb(197, 195, 195);
}

table {
    border: 1px rgb(197, 195, 195) solid;
    border-collapse: collapse;
    padding: 20px 20px;
    width: 700px;
}

th,
td {
    border: 1px rgb(197, 195, 195) solid;
    padding: 20px 20px;
}

.shortInput {
    width: 150px;
    border: 1px rgb(197, 195, 195) solid;
    font-size: 16px;
}

.longInput {
    width: 100%;
    border: 1px rgb(197, 195, 195) solid;
    font-size: 16px;
}

::-webkit-file-upload-button {
    background: rgb(0, 153, 255);
    color: #fafafa;
    border-radius: 4px;
    font-size: 16px;
    -webkit-appearance: none;
    border: none;
}

.validate {
    margin-left: 10px;
    color: red;
}

.otoQBtn {
    height: 40px;
    width: 100px;
    font-size: 22px;
    padding: 0 0;
    margin: 0 10px;
}

.qnaType {
    font-size: 16px;
}
</style>
