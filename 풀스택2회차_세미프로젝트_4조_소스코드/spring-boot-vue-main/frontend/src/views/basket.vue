<template>
<div class="basket">
    <div class="main">
        <div class="title">
            <h2>장바구니</h2>
        </div>
        <!-- 장바구니 목록 선택 체크 버튼 -->
        <div class="selectDiv">
            <div class="allSelectDiv">
                <button class="selectBtn" @click="allCheck">전체선택</button>
                <button class="selectBtn" @click="allDisCheck">전체해제</button>
                <button class="selectBtn" @click="deleteBasket">선택삭제</button>
            </div>
        </div>
        <div>
            <!-- 장바구니 목록 표시 -->
            <div class="listDiv" v-for="(item, idx) in basket" :key="idx">
                <ul class="list">
                    <li class="list1">
                        <div><input class="checkedList" type="checkbox" @click="calcPrice"></div>
                    </li>
                    <li class="list2">
                        <div class="listImage">
                            <img class="productImage" :src="`/api/product/productimage/${item.productno}/${item.imagename}`" alt="">
                        </div>
                    </li>
                    <li class="list3">
                        <div>
                            <p>{{item.productname}}</p>
                            <p>옵션1 : {{item.option1}}</p>
                            <p>옵션2 : {{item.option2}}</p>
                            <p>수량 : {{item.amount}}</p>
                        </div>
                    </li>
                    <li class="list4">
                        <div>
                            <p class="price">{{AddComma(item.price)}}원</p>
                            <p class="rate">{{AddComma(item.price*0.9)}}원</p>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="right">
        <!-- 결제 금액 내역 표시 -->
        <div class="inform">
            <div class="line">
                <h2>결제예정금액</h2>
            </div>
            <div>
                <h3>상품금액</h3>
                <label class="price" id="totalPro">0원</label>
            </div>
            <div>
                <h3>배송비(선결제)</h3>
                <label class="price" id="totalDel">0원</label>
            </div>
            <div>
                <h3>할인금액</h3>
                <label class="price" style="color:red;" id="totalSale">0원</label>
            </div>
            <div style="color:red; ">
                <h2>합계</h2>
                <label class="price" style="font-size:25px;" id="totalSum">0원</label>
            </div>
        </div>
        <div class="orderBtn">
            <router-link class="signUpLink" v-bind:to="'/payment'"> <button @click="selectList">주문</button></router-link>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
// 새로고침과 페이지 이동시 로그인 상태 확인 및 유지 기능
import {
    createNamespacedHelpers
} from 'vuex';
// 로그인 상태 관련 모듈
const loginStore = createNamespacedHelpers('loginStore');
const basketList = createNamespacedHelpers("basketList");
const orderList = createNamespacedHelpers("orderList");
export default {
    data() {
        return {
            sum: 0,
            delivery: 0,
            product: 0,
            sale: 0,
            basket: "",
            checkedBasket: "",
        }
    },
    methods: {
        // 체크박스를 선택할때 금액 계산
        calcPrice() {
            let checkedList = document.getElementsByClassName("checkedList");
            let totalPro = document.getElementById("totalPro");
            let totalDel = document.getElementById("totalDel")
            let totalSale = document.getElementById("totalSale");
            let totalSum = document.getElementById("totalSum");
            this.product = 0;
            this.delivery = 0;
            this.sale = 0;
            this.sum = 0;
            for (let i = 0; i < checkedList.length; i++) {
                if (checkedList[i].checked == true) {
                    this.product += Number(this.basket[i].price);
                    this.sale += this.basket[i].price * 0.1;
                    this.sum += Number(this.basket[i].price);
                }
            }
            if (this.sum - this.sale >= 50000) {
                this.delivery = 0;
            } else if (this.sum == 0) {
                this.delivery = 0;
            } else {
                this.delivery = 2500;
            }
            totalPro.textContent = this.AddComma(this.product) + "원";
            totalDel.textContent = this.AddComma(this.delivery) + "원";
            totalSale.textContent = "-" + this.AddComma(this.sale) + "원";
            totalSum.textContent = this.AddComma(this.sum + this.delivery - this.sale) + "원";
        },
        // 체크박스 전체 선택
        allCheck() {
            let checkedList = document.getElementsByClassName("checkedList");
            for (let i = 0; i < checkedList.length; i++) {
                checkedList[i].checked = true;
            }
            this.calcPrice();
        },
        // 체크박스 전체 선택 해제
        allDisCheck() {
            let checkedList = document.getElementsByClassName("checkedList");
            for (let i = 0; i < checkedList.length; i++) {
                checkedList[i].checked = false;
            }
            this.calcPrice();
        },
        AddComma(num) {
            var regexp = /\B(?=(\d{3})+(?!\d))/g;
            return `${num}`.toString().replace(regexp, ',');
        },
        // 장바구니 목록 삭제
        deleteBasket() {
            let checkedList = document.getElementsByClassName("checkedList");
            console.log(1);
            let basketidx = [];
            for (let i = checkedList.length - 1; i >= 0; i--) {
                if (checkedList[i].checked == true) {
                    basketidx.push(this.basket[i].basketidx);
                }
            }
            axios.delete(`/api/basket/delete`, {
                    data: basketidx
                })
                .then(res => {
                    if (res.status == 200) {
                        for (let i = checkedList.length - 1; i >= 0; i--) {
                            if (checkedList[i].checked == true) {
                                checkedList[i].checked = false;
                            }
                        }
                        this.getBasket();
                    }
                }).catch(err => {
                    console.log(err.response)
                })

            let totalPro = document.getElementById("totalPro");
            let totalDel = document.getElementById("totalDel")
            let totalSale = document.getElementById("totalSale");
            let totalSum = document.getElementById("totalSum");

            totalPro.textContent = "0원";
            totalDel.textContent = "0원";
            totalSale.textContent = "0원";
            totalSum.textContent = "0원";
        },
        // 주문 버튼을 누를 때 구매 목록에 장바구니 목록 넣기
        selectList() {
            this.clearOrderList();
            let checkedList = document.getElementsByClassName("checkedList");
            for (let i = 0; i < checkedList.length; i++) {
                if (checkedList[i].checked == true) {
                    this.addOrderList(this.basket[i])
                }
            }
        },
        getBasket() {
            axios({
                method: 'get',
                url: `/api/basket/read`,
                params: {
                    id: this.getLogin.user_id,
                }
            }).then(res => {
                this.basket = res.data;
            })
        },
        ...basketList.mapMutations(["delList"]),
        ...orderList.mapMutations(["addOrderList"]),
        ...orderList.mapMutations(["clearOrderList"]),
        ...basketList.mapGetters(["getBasketList"]),
        // 로그아웃 상태로 전환
        ...loginStore.mapMutations([
            'Logout'
        ]),
    },
    computed: {
        delivery_fee() {
            if (this.sum + this.delivery - this.sale >= 50000) {
                return 0;
            } else {
                return 2500;
            }
        },
        // 로그인한 유저정보를 반환
        ...loginStore.mapGetters(['getLogin']),
    },
    mounted() {
        this.getBasket();
    },
}
</script>

<style scoped>
.basket {
    display: flex;
}

.main {
    display: inline-block;
    width: 85%;
}

.selectDiv {
    display: flex;
    width: 100%;
}

.selectDiv>div {
    width: 50%;
}

.allSelectDiv {
    display: flex;
}

.list {
    list-style: none;
    display: flex;
    width: 100%;
    margin: 0;
    padding: 0;
    margin-top: 10px;
    margin-bottom: 10px;
    background-color: #fafafa;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.list3 p {
    margin: 10px 0;
    padding: 0px;
}

.list3 .option {
    margin-right: 10px;
}

.list4 .price {
    font-size: 16px;
    margin: 10px 0;
    text-decoration: line-through;
    opacity: 0.5;
}

.list5 .info {
    margin: 10px 0;
    padding: 0px;
}

.list4 .rate {
    font-weight: bold;
}

.list :nth-child(3) {
    width: 70%;
}

.list :nth-child(4) {
    width: 20%;

}

.list li {
    border-left: 1px solid rgb(197, 195, 195);
    position: relative;

    padding: 5px;
}

.list1 {
    width: 30px;
    margin: 0;
    padding: 0;
}

.list1 input {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    margin: 0;
    padding: 0;
}

.right {
    position: relative;
    display: inline-block;
    width: 30%;
    padding: 10px;
    margin-left: 20px;
    min-height: 600px;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.inform {
    width: 100%;
    background-color: #fafafa;
    border-radius: 4px;
    border: 1px solid rgb(197, 195, 195);
    margin: 0;
}

.inform .line {
    margin: 0;
    border-bottom: 1px solid rgb(197, 195, 195);

}

.inform>div {
    display: flex;
    padding: 20px 5px;

}

.price {
    margin-left: auto;
    margin-top: 20px;

}

.orderBtn {
    margin-top: 20px;
    width: 100%;
    text-align: center;
    background-color: #0099ff;
    border-radius: 4px;
}

.productImage {
    width: 150px;
    height: 150px;
    object-fit: cover;
}

.productImage {
    width: 150px;
    height: 150px;
    object-fit: cover;
}

h1 {
    background-color: #fafafa;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.selectBtn {
    font-size: 15px;
    height: 22px;
    padding-top: 1px;
    padding-bottom: 1px;
}

.signUpLink>button {
    font-size: 22px;
    width: 100%;

}
</style>
