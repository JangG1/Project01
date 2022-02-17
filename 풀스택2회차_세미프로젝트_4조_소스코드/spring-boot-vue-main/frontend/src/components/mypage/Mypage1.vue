<template>
<div>
    <!--top-->
    <!--right-->
    <div class="right">
        <div class="pList1">
            <h2>나의쇼핑내역</h2>
        </div>
        <div class="date1">
            <div class="table1st">
                <div class="tables_header">조회기간</div>
                <div>
                    <div class="row1">
                        <button class="dateBtn">오늘</button>
                        <button class="dateBtn">1주일</button>
                        <button class="dateBtn">1개월</button>
                        <button class="dateBtn">6개월</button>
                        <button class="dateBtn">12월</button>
                        <button class="dateBtn">11월</button>
                        <button class="dateBtn">10월</button>
                    </div>
                    <div class="row2">
                        <!--기간별 주문/취소한 상품 내역 조회-->
                        <select name="" id="" @change="setStartYear">
                            <option v-for="n in years" :key="n" :value="n" :selected="n == getYear()-1">{{n}}</option>
                        </select>
                        <label for="">년</label>
                        <select name="" id="" @change="setStartMonth">
                            <option v-for="n in 12" :key="n" :value="n" :selected="n == getMonth()">{{n}}</option>
                        </select>
                        <label for="">월</label>
                        <select name="" id="" @change="setStartDate">
                            <option v-for="n in 31" :key="n" :value="n" :selected="n == getDate()">{{n}}</option>
                        </select>
                        <label for="">일</label>
                        -
                        <select name="" id="" @change="setEndYear">
                            <option v-for="n in years" :key="n" :value="n" :selected="n == getYear()">{{n}}</option>
                        </select>
                        <label for="">년</label>
                        <select name="" id="" @change="setEndMonth">
                            <option v-for="n in 12" :key="n" :value="n" :selected="n == getMonth()">{{n}}</option>
                        </select>
                        <label for="">월</label>
                        <select name="" id="" @change="setEndDate">
                            <option v-for="n in 31" :key="n" :value="n" :selected="n == getDate()">{{n}}</option>
                        </select>
                        <label for="">일</label>
                    </div>
                    <div class="row3">
                        <input type="text" class="searchBar" id="searchInput" placeholder="주문 상품명을 검색하세요!">
                        <button class="searchBtn" @click="search">조회하기</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="pList2">
            <h2>주문내역 조회</h2>
            <!--주문내역 조회 테이블-->
        </div>
        <div>
            <div class="table1Header">
                <table style="width:1000px; text-align:center">
                    <tr style="height:50px;">
                        <td class="td1">주문일자</td>
                        <td class="td2">이미지</td>
                        <td class="td3">판매자명</td>
                        <td class="td4">상품명</td>
                        <td class="td5">옵션</td>
                        <td class="td6">가격</td>
                        <td class="td7">상태</td>
                    </tr>
                </table>
            </div>
            <div class="table1Body">
                <table style="width:1000px; text-align:center">
                    <!-- 날짜, 검색 정보를 비교하여 화면 목록에 표시 -->
                    <tr v-for="(order, idx) in orders" :key="idx" style="height:50px;">
                        <td class="td1">{{order.orderdate}}</td>
                        <td class="td2">
                            <img :src="`/api/product/productimage/${order.productno}/${order.imagename}`" alt="banner" style="width:50px; height:50px;">
                        </td>
                        <td class="td3">{{order.seller}}</td>
                        <td class="td4" style="text-align:left">{{order.productname}}</td>
                        <td class="td5">{{order.selectedoption}}</td>
                        <td class="td6" style="text-align:right">{{AddComma(order.totalprice)}}원</td>
                        <td class="td7">{{order.state}}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="pList3">
            <h2>취소/환불 조회</h2>
            <!--취소/환불 내역 조회 테이블-->
        </div>
        <div>
            <div class="table2Header">
                <table style="width:1000px; text-align:center">
                    <thead>
                        <tr style="height:50px;">
                            <td class="td1">주문일자</td>
                            <td class="td2">이미지</td>
                            <td class="td3">판매자명</td>
                            <td class="td4">상품명</td>
                            <td class="td5">옵션</td>
                            <td class="td6">가격</td>
                            <td class="td7">상태</td>
                        </tr>
                    </thead>
                </table>
            </div>
            <div class="table2Body">
                <table style="width:1000px; text-align:center">
                    <tbody>
                        <tr v-for="(cancel, idx) in cancels" :key="idx" class="tr1" style="height:50px;">
                            <td class="td1">{{cancel.orderdate}}</td>
                            <td class="td2">
                                <img :src="`/api/product/productimage/${cancel.productno}/${cancel.imagename}`" alt="banner" style="width:50px; height:50px;">
                            </td>
                            <td class="td3">{{cancel.seller}}</td>
                            <td class="td4" style="text-align:left">{{cancel.productname}}</td>
                            <td class="td5">{{cancel.selectedoption}}</td>
                            <td class="td6" style="text-align:right">{{AddComma(cancel.totalprice)}}원</td>
                            <td class="td7">{{cancel.state}}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
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
            startPoint: {
                year: this.getYear() - 1,
                month: this.getMonth(),
                date: this.getDate(),
            },
            endPoint: {
                year: this.getYear(),
                month: this.getMonth(),
                date: this.getDate(),
            },
            years: [],
            months: [],
            dates: [],
            orders: "",
            cancels: "",
        }
    },
    methods: {
        getDate() {
            let today = new Date();
            let date = today.getDate();
            return date;
        },
        getMonth() {
            let today = new Date();
            let month = today.getMonth() + 1;
            return month;
        },
        getYear() {
            let today = new Date();
            let year = today.getFullYear();
            return year;
        },
        setStartDate(event) {
            if (event.target.value < 10)
                this.startPoint.date = 0 + event.target.value;
            else
                this.startPoint.date = event.target.value;
        },
        setStartMonth(event) {
            if (event.target.value < 10)
                this.startPoint.month = 0 + event.target.value;
            else
                this.startPoint.month = event.target.value;
        },
        setStartYear(event) {
            this.startPoint.year = event.target.value;
        },
        setEndDate(event) {
            if (event.target.value < 10)
                this.endPoint.date = 0 + event.target.value;
            else
                this.endPoint.date = event.target.value;
        },
        setEndMonth(event) {
            if (event.target.value < 10)
                this.endPoint.month = 0 + event.target.value;
            else
                this.endPoint.month = event.target.value;
        },
        setEndYear(event) {
            this.endPoint.year = event.target.value;
        },
        search() {
            let search = document.getElementById("searchInput").value
            this.getOrder(search);
            this.getCancel(search)
        },

        //가격부분 콤마 추가
        AddComma(num) {
            var regexp = /\B(?=(\d{3})+(?!\d))/g;
            return num.toString().replace(regexp, ",");
        },

        getOrder(search) {
            const id = this.getLogin.user_id;
            axios({
                method: 'get',
                url: `/api/order/getOrders`,
                params: {
                    id: id,
                    startdate: this.startdate,
                    enddate: this.enddate,
                    productname: search,
                }
            }).then(res => {
                this.orders = res.data;
            })
        },
        getCancel(search) {
            const id = this.getLogin.user_id;
            axios({
                method: 'get',
                url: `/api/order/getCancels`,
                params: {
                    id: id,
                    startdate: this.startdate,
                    enddate: this.enddate,
                    productname: search,
                }
            }).then(res => {
                this.cancels = res.data;
            })
        },
        // 로그아웃 상태로 전환
        ...loginStore.mapMutations([
            'Logout'
        ]),
    },
    computed: {
        ...loginStore.mapGetters(["getLogin"]),
        startdate() {
            let temp = `${this.startPoint.year}`;
            if (this.startPoint.month < 10) {
                temp = temp + "0" + this.startPoint.month;
            } else {
                temp = temp + this.startPoint.month;
            }
            if (this.startPoint.date < 10) {
                temp = temp + "0" + this.startPoint.date;
            } else {
                temp = temp + this.startPoint.date;
            }
            return temp;
        },
        enddate() {
            let temp = `${this.endPoint.year}`;
            if (this.endPoint.month < 10) {
                temp = temp + "0" + this.endPoint.month;
            } else {
                temp = temp + this.endPoint.month;
            }
            if (this.endPoint.date < 10) {
                temp = temp + "0" + this.endPoint.date;
            } else {
                temp = temp + this.endPoint.date;
            }
            return temp;
        }
    },
    mounted() {
        {
            for (let i = this.getYear() - 10; i <= this.getYear(); i++) {
                this.years.push(i);
            }
            this.year = this.getYear();
            this.month = this.getMonth();
            this.date = this.getDate();
        }
        this.getOrder("");
        this.getCancel("");
    }
}
</script>

<style scoped>
.table1Header,
.table2Header {
    background-color: rgb(0, 153, 255)
}

.table1Header tr,
.table2Header tr {
    color: white;
}

.table1Body {
    height: 350px;
    overflow-y: scroll;
}

.table2Body {
    height: 150px;
    overflow-y: scroll;
}

.td1 {
    width: 100px
}

.td2 {
    width: 80px
}

.td3 {
    width: 80px
}

.td4 {
    width: 370px
}

.td5 {
    width: 90px
}

.td6 {
    width: 100px
}

.td7 {
    width: 100px
}

.td8 {
    width: 80px
}

.date1 {
    width: 1000px;
    display: flex;
    text-align: center;
    justify-items: center;
}

a {
    text-decoration: none;
    color: inherit;
    margin-left: 15px;
}

hr {
    width: 200px;
}

tr {
    border: inherit;
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

.right {
    display: inline-block;
    height: 1150px;
    /* width: 85%; */
    border: 1px solid rgb(197, 195, 195);
    /* margin-left: 50px; */
    background-color: #fafafa;
    border-radius: 4px;
}

.pList1,
.pList2,
.pList3 {
    text-align: center;
    border-bottom: 1px solid rgb(197, 195, 195);

}

.date1,
.date2 {

    border-bottom: 1px solid rgb(197, 195, 195);
    padding-top: 20px;
    padding-bottom: 20px;
}

.date1 {
    display: flex;
}

.date2 {
    height: 300px;
    overflow-y: scroll;
}

.date3 {
    margin-top: 20px;
    padding-top: 15px;
    height: 300px;
    overflow-y: scroll;
}

.table1st {
    margin-left: auto;
    margin-right: auto;
    display: flex;

}

.tables_header {
    width: 140px;
    height: 100px;
    padding-top: 20px;
    text-align: center;
    line-height: 80px;
    font-weight: bold;
    border: 1px solid;
    border-radius: 4px;
    background-color: #00ba54;
    color: white;
    margin-right: 20px;
}

.searchBtn {
    margin-left: 20px;
}

.row1,
.row2 {
    padding: 1px;
    border-radius: 4px;
}

.row2 {
    margin-left: 6px;
}

.row3 {
    display: flex;
    padding: 5px 0px;
}

.searchBar {
    width: 400px;
    margin-left: auto;
    margin-right: 1px;
    border-radius: 4px;
    border: 1px solid;
    padding: 20px;
}

.table2,
.table3 {
    margin-left: auto;
    margin-right: auto;
    border-collapse: collapse;
    text-align: center;
    background-color: white;
}

.table2 td,
.table3 td {
    border-bottom: 2px solid rgb(184, 181, 181);
    padding: 7px 4px;
    font-size: 16px;
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

.Check li {
    width: 150px;
    padding: 0;
    margin: 10px 0px;
}

.dateBtn {
    border-radius: 4px;
    border: none;
    color: white;
    padding: 5px 10px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 13px;
    cursor: pointer;
    margin: 0px 1px;
    margin: 0px 5px;

}

#edge1 {
    border-top-left-radius: 8px;
}

#edge2 {
    border-top-right-radius: 8px;
}
</style>
