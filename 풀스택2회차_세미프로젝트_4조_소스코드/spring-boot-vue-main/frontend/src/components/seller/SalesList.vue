<template>
<div class="container">
    <div class="selectBox">
        <select name="" id="searchSelect" v-model="searchItemSelect">
            <option value="0">상품명</option>
            <option value="1">상품번호</option>
            <!-- <option value="2">가격</option>
            <option value="3">등록일</option>
            <option value="4">재고</option>
            <option value="5">판매여부</option> -->
        </select>
        <input type="text" v-model="findItem">
           <button @click="itemSearch" style="padding: 0px 10px">검색</button>
    </div>
    <div>
        <table>
            <thead>
                <tr>
                    <td class="td1 header" style=" cursor: pointer;" @click="productnoSort">상품번호</td>
                    <td class="td2 header">사진</td>
                    <td class="td3 header">상품명</td>
                    <td class="td4 header" style=" cursor: pointer;" @click="priceSort">가격</td>
                    <td class="td5 header" style=" cursor: pointer;" @click="regdateSort">등록일</td>
                    <td class="td6">재고</td>
                    <td class="td7">판매여부</td>
                    <td class="td8" colspan="2" style="width:111px;"></td>
                    <!-- <td class="td9">수정</td> -->
                </tr>
            </thead>
        </table>
    </div>
    <div class="tableBody">
        <table>
            <tbody>
                <tr v-for="(product,idx) in products" :key="idx" class="tableRow">

                    <td class="td1">
                        {{product.productno}}
                    </td>
                    <td class="td2">
                        <!-- {{setImage(product)}} -->
                        <img :src="`/api/product/productimage/${product.productno}/${product.imagename}`" alt="productImage">
                    </td>
                    <td class="td3">
                        {{product.productname}}
                    </td>
                    <td class="td4">
                        {{AddComma(product.price)}}원
                    </td>
                    <td class="td5">
                        {{product.regdate}}
                    </td>
                    <td class="td6">{{product.amount}}</td>
                    <td class="td7" style=" cursor: pointer;" @click="onSale(product)">
                        <p v-if="product.onsale==0">미판매</p>
                        <p v-if="product.onsale==1">판매중</p>
                    </td>
                    <td class="td8">
                        <router-link v-bind:to="`/productDetail/${product.productno}`" tag="div" class="routerLink">
                            이동
                        </router-link>
                    </td>
                    <td class="td9">
                        <item @click="$emit('set-productno',product.productno)">수정</item>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
    <div>
    </div>
    <div></div>

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

    data: function () {
        return {
            products: [],
            searchItemSelect: '0',
            findItem: '',
        };
    },
    methods: {
        async getData() {
            this.products=[];
            await axios.get("/api/product/productDetail/saleslist/" + this.getLogin.user_id).then(res => {
                this.data = res.data;
                this.data.forEach(element => {
                    this.products.push(element);
                });
            });
        },
        AddComma(num) {
            let regexp = /\B(?=(\d{3})+(?!\d))/g;
            return num.toString().replace(regexp, ",");
        },
        productnoSort() {
            console.log(this.productnoSortState)
            this.productnoSortState = -this.productnoSortState;
            this.products.sort((a, b) => {
                if (this.productnoSortState < 0) {
                    return a.productno - b.productno;
                } else {
                    return b.productno - a.productno;
                }

            })

        },
        priceSort() {
            this.priceSortState = -this.priceSortState;
            this.products.sort((a, b) => {
                if (this.priceSortState < 0) {
                    if (a.price == b.price) {
                        return a.productno - b.productno;
                    }
                    return a.price - b.price;
                } else {
                    if (a.price == b.price) {
                        return a.productno - b.productno;
                    }
                    return b.price - a.price;
                }
            })
        },
        onSale(product) {
            let onsale;
            if (product.onsale == 0)
                onsale = '1';
            else
                onsale = '0';
            console.log(onsale)
            let params = new URLSearchParams();
            params.append("onsale", onsale)
            axios.patch('/api/product/onsale/' + product.productno, params)
                .then(res => {
                    if (res.data == 'success') {
                        alert("변경했습니다.")
                        this.$router.go();
                    }
                })
                .catch()
        },
        itemSearch() {
            if (this.findItem === '') {
                this.getData();
                return;
            }
            if (this.searchItemSelect == 0) {
                this.products = [];
                let lower = this.findItem.toLowerCase();

                axios.get(`/api/product/findByName/${lower}`)
                    .then(res => {
                        this.data = res.data;
                        this.data.forEach(element => {
                            this.products.push(element);
                        });
                    })
            } else if (this.searchItemSelect == 1) {
                this.products = [];

                axios.get(`/api/product/findByNo/${this.findItem}`)
                    .then(res => {
                        this.data = res.data;
                        this.data.forEach(element => {
                            this.products.push(element);
                        });
                    })
            }
        },
        regdateSort() {
            this.regdateSortState = -this.regdateSortState;
            this.products.sort((a, b) => {
                let a_time = {
                    year: a.regdate.slice(0, 4),
                    month: a.regdate.slice(5, 7) - 1,
                    date: a.regdate.slice(8, 10),
                    hour: a.regdate.slice(11, 13),
                    minute: a.regdate.slice(14, 16)
                }
                let b_time = {
                    year: b.regdate.slice(0, 4),
                    month: b.regdate.slice(5, 7) - 1,
                    date: b.regdate.slice(8, 10),
                    hour: b.regdate.slice(11, 13),
                    minute: b.regdate.slice(14, 16)
                }
                // console.log(new Date(a_time.year, a_time.month, a_time.date, a_time.hour, a_time.minute));
                // console.log(new Date(b_time.year, b_time.month, b_time.date, b_time.hour, b_time.minute));
                let a_Date = new Date(a_time.year, a_time.month, a_time.date, a_time.hour, a_time.minute);
                let b_Date = new Date(b_time.year, b_time.month, b_time.date, b_time.hour, b_time.minute);
                if (this.regdateSortState < 0) {
                    if (a_Date - b_Date == 0) {
                        return a.productno - b.productno;
                    }
                    return a_Date - b_Date;
                } else {
                    if (a_Date - b_Date == 0) {
                        return a.productno - b.productno;
                    }
                    return b_Date - a_Date;
                }

            })
        }
    },
    computed: {
        ...loginStore.mapGetters(['getLogin'])
    },
    mounted() {
        this.productnoSortState = 1;
        this.priceSortState = 1;
        this.regdateSortState = 1;
        this.getData();
    }
}
</script>

<style scoped>
.container {
    width: 1099px;
    overflow: hidden;
}

.container div {
    display: block;
}

.selectBox{
    margin: 10px 0 10px 10px;
}

.tableBody {
    height: 800px;
    overflow-y: scroll;
}

td {
    border: 1px solid #444444;
}

.td1 {
    width: 79px;
    text-align: center;
}

.td2 {
    width: 62px;
    height: 62px;
    background-color: white;
    text-align: center;
}

.routerLink {
    cursor: pointer;

}

.td2>img {
    width: 60px;
    height: 60px;
    object-fit: scale-down;
}

.td3 {
    width: 450px;
}

.td4 {
    width: 130px;
    text-align: right;
}

.td5 {
    width: 90px;
}

.td6 {
    width: 52px;
    text-align: center;
}

.td7 {
    width: 82px;
    text-align: center;
}
.td8, .td9 {
    width: 54px;
    text-align: center;
}
/* .td9 {
    width: 30px;
    text-align: center;
} */

.header {
    height: 60px;
    text-align: center;
}

.tableRow:nth-child(2n) {
     background-color: rgb(187, 228, 255);
}

table {
    border-collapse: collapse;
}
</style>
