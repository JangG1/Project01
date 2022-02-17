<template>
<div>
    <table style="width: 1000px">
        <tr>
            <td>상품명</td>
            <td colspan="2">
                <input type="text" class="inputData" v-model="productname" name="상품명">
            </td>
        </tr>
        <tr>
            <td>상품 타입</td>
            <td colspan="2">
                <input type="text" class="inputData" v-model="ptype" name="상품타입">
            </td>
        </tr>
        <tr>
            <td>상품 가격</td>
            <td colspan="2">
                <input type="text" class="inputData" v-model="price" name="상품 가격">
            </td>
        </tr>
        <tr>
            <td>수량</td>
            <td colspan="2">
                <input type="text" class="inputData" v-model="amount" name="수량">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>옵션명</td>
            <td>옵션(;로 구분)</td>
        </tr>
        <tr>
            <td>옵션1</td>
            <td>
                <input type="text" class="inputData" v-model="option1name" name="옵션1의 옵션명" placeholder="옵션명">
            </td>
            <td>
                <input type="text" class="inputData" v-model="option1" name="옵션1의 옵션">
            </td>
        </tr>
        <tr>
            <td>옵션2</td>
            <td>
                <input type="text" class="inputData2" v-model="option2name" placeholder="옵션명">
            </td>
            <td>
                <input type="text" class="inputData2" v-model="option2" :disabled='option2name ==""'>
            </td>
        </tr>
        <tr>
            <td>이미지</td>
            <td>
                <label for="" class="inputLabel">상품 이미지</label>
                <div class="imagePreviewWrapper" :style="{ 'background-image': `url(${image1})` }" @click="selectImage1">
                </div>
                <input ref="fileInput1" type="file" @change="pickFile1" accept="image/png, image/gif, image/jpeg">
            </td>
            <td>
                <label for="" class="inputLabel">상품 상세 이미지</label>
                <div class="imagePreviewWrapper" :style="{ 'background-image': `url(${image2})` }" @click="selectImage2">
                </div>
                <input ref="fileInput2" type="file" @change="pickFile2" accept="image/png, image/gif, image/jpeg">
            </td>
        </tr>
        <tr>
            <td colspan="3" style="text-align : center">
                <button v-if="productno==''" @click="sendFile">입력</button>
                <button v-else @click="updateFile">수정</button>
            </td>
        </tr>
    </table>
</div>
</template>

<script>
import axios from 'axios'
import {
    createNamespacedHelpers
} from 'vuex';
// 로그인 상태 관련 모듈
const loginStore = createNamespacedHelpers('loginStore');
export default {
    props: ['sendProduct'],
    data() {
        return {
            productno: '',
            productname: '',
            ptype: '',
            price: 0,
            amount:0,
            option1name: '',
            option1: '',
            option2name: '',
            option2: '',
            image1: null,
            image2: null,
            iamgefile1: null,
            imagefile2: null,
        };
    },
    watch: {

    },
    computed: {
        ...loginStore.mapGetters(['getLogin']),
    },
    methods: {
        selectImage1() {
            this.$refs.fileInput1.click()
        },
        selectImage2() {
            this.$refs.fileInput2.click()
        },
        pickFile1() {
            let input = this.$refs.fileInput1.files[0];
            if (input) {
                let reader = new FileReader
                reader.onload = e => {
                    this.image1 = e.target.result
                }
                reader.readAsDataURL(input)
                this.$emit('input', input)
            }
            this.imagename = input.name
            this.imageFile1 = input;
            // this.formData.append('fileList', input[0])

        },
        pickFile2() {
            let input = this.$refs.fileInput2.files[0];
            console.log(input);
            if (input) {
                let reader = new FileReader
                reader.onload = e => {
                    // this.image2.push(e.target.result)
                    this.image2 = e.target.result;
                }
                reader.readAsDataURL(input)
                this.$emit('input', input)
            }
            this.detailimagename = input.name
            this.imageFile2 = input;
            // this.formData.append('fileList', input[0])
        },
        async sendFile() {
            const checked = document.getElementsByClassName('inputData')
            let checkLength = checked.length
            for (let i = 0; i < checkLength; i++) {
                if (checked[i].value.length == 0) {
                    alert(`${checked[i].name} 을/를 입력하세요`)
                    checked[i].focus();
                    return;
                }
            }
            if(this.image1 == null){
                alert('이미지를 입력하세요')
                return;
            }
            if(this.image2 == null){
                alert('상세 이미지를 입력하세요')
                return;
            }
            if(this.option2name == ''){
                this.option2 = '';
            }

            let data = {
                sellerid: this.getLogin.user_id,
                productname: this.productname,
                ptype: this.ptype,
                price: this.price,
                amount : this.amount,
                option1: this.option1name + ';' + this.option1,
                option2: this.option2name + ';' + this.option2,
                imagename: this.imagename,
                detailimagename: this.detailimagename,
            }
            this.formData = new FormData();
            this.formData.append('data', new Blob([JSON.stringify(data)], {
                type: "application/json"
            }))
            this.formData.append('fileList', this.imageFile1)
            this.formData.append('fileList', this.imageFile2)
            axios.post('/api/product/insertProduct', this.formData)
                .then(res => {
                    console.log(res.status);
                    alert("상품을 추가하셨습니다");
                    this.$router.go();
                }).catch(err => {
                    if (err.response.status === 404)
                        alert("error")
                })
        },
        updateFile() {
            const checked = document.getElementsByClassName('inputData')
            let checkLength = checked.length
            for (let i = 0; i < checkLength; i++) {
                if (checked[i].value.length == 0) {
                    alert(`${checked[i].name} 을/를 입력하세요`)
                    checked[i].focus();
                    return;
                }
            }
            if(this.image1 == null){
                alert('이미지를 입력하세요')
                return;
            }
            if(this.image2 == null){
                alert('상세 이미지를 입력하세요')
                return;
            }
            if(this.option2name == ''){
                this.option2 = '';
            }

            let data = {
                productno: this.productno,
                sellerid: this.getLogin.user_id,
                productname: this.productname,
                ptype: this.ptype,
                price: this.price,
                amount: this.amount,
                option1: this.option1name + ';' + this.option1,
                option2: this.option2name + ';' + this.option2,
                imagename: this.imagename,
                detailimagename: this.detailimagename,
            }
            this.formData = new FormData();
            this.formData.append('data', new Blob([JSON.stringify(data)], {
                type: "application/json"
            }))
            this.formData.append('file1', this.imageFile1)
            this.formData.append('file2', this.imageFile2)
            axios.put('/api/product/updateProduct', this.formData)
                .then(res => {
                    console.log(res.status);
                    alert("상품을 수정하셨습니다");
                    this.$router.go();
                }).catch(err => {
                    if (err.response.status === 404)
                        alert("error")
                })
        }
    },
    mounted() {
        if (this.sendProduct != '')
            axios.get(`/api/product/findByNo/${this.sendProduct}`)
            .then(res => {
                console.log(res.data[0])
                this.productno = res.data[0].productno;
                this.productname = res.data[0].productname;
                this.ptype = res.data[0].ptype;
                this.price = res.data[0].price;
                this.amount = res.data[0].amount;
                
                let opt1 = res.data[0].option1.split(";");
                let opt2 = res.data[0].option2.split(";");

                this.option1name = opt1[0];
                this.option2name = opt2[0];

                opt1.splice(0, 1);
                opt2.splice(0, 1);

                this.option1 = opt1.join(";");
                this.option2 = opt2.join(";");

                this.imagename = res.data[0].imagename;
                this.detailimagename = res.data[0].detailimagename;

                this.image1 = `/api/product/productimage/${res.data[0].productno}/${res.data[0].imagename}`;
                this.image2 = `/api/product/detailimage/${res.data[0].productno}/${res.data[0].detailimagename}`;
            })
    }
}
</script>

<style scoped>
.imagePreviewWrapper {
    width: 200px;
    height: 200px;
    display: block;
    cursor: pointer;
    margin: 0;
    background-size: cover;
    /* background-position: center center; */
}

.inputLabel {
    display: inline-block;
    width: 120px;
}
.inputData{
    /* height: 20px; */
    font-size: 20px;
    width :300px;
}
.inputData2{
    /* height: 20px; */
    font-size: 20px;
    width :300px;
}


tr,
td {
    border: 1px black solid;
    padding: 10px 10px;
}

table {
    border-collapse: collapse;
}

div {
    padding: 10px 5px;

}
</style>
