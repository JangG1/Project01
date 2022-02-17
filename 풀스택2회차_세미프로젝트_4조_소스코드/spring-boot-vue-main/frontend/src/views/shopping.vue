<template>
<div>
    <div class="all">
        <div class="container2">
            <div class="aside_info">
                <h2>가격대</h2>
                <ul>
                    <li>
                        <input type="text" id="min" class="priceSearch" placeholder="최소금액">~<input type="text" id="max" class="priceSearch" placeholder="최대금액">
                        <button class="priceSearchBtn" @click="searchProd">검색</button>
                    </li>
                </ul>
                <h2>가격비교</h2>
                <ul class="buy">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">숙박대전</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">배송선물</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">희망쇼핑</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">할인금액</a></li>
                </ul>
                <h2>사이즈</h2>
                <ul class="size">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">230~240이상</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">245~255이상</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">260~270이상</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">275이상</a></li>
                </ul>
                <h2>색상</h2>
                <ul class="color">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">블랙 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">화이트 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">레드 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">옐로우 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">그린 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">블루 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">브라운 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">실버 계열</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">골드 계열</a></li>
                </ul>
                <h2>판매처</h2>
                <ul class="aside_vendor">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">공식인증셀러</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">대형몰</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">홈쇼핑</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">전문몰</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">해외몰</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">아울렛</a></li>
                </ul>
                <h2>배송혜택</h2>
                <ul class="aside_delivery">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">무료배송</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">오늘발송</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">반품 배송비지원</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">무료선물포장</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">장보기</a></li>
                </ul>
                <h2>브랜드</h2>
                <ul class="aside_brand">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">아디다스</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">나이키</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">리복</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">뉴발란스</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">휠라</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">퓨마</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">프로스펙스</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">르꼬끄</a></li>
                </ul>
                <h2>백화점</h2>
                <ul class="aside_brand">
                    <li><input type="checkbox" class="blank"><a href="" class="blank">AK플라자</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">아이파크몰</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">현대백화점</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">롯데백화점</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">신세계백화점</a></li>
                    <li><input type="checkbox" class="blank"><a href="" class="blank">갤러리아백화점</a></li>
                </ul>
            </div>
        </div>
        <div class="container0" v-if="prod.length == 0">
            <h1>검색된 상품이 없습니다. 다른 검색어를 입력해주세요</h1>
        </div>
        <div class="container0" v-if="prod.length > 0">
            <div class="container">
                <div class="products_fa">
                    <h2 class='span1'> 인기상품</h2>
                    <div class="products" v-for="(pop, idx) in popular" :key="idx">
                        <router-link v-bind:to="`/productDetail/${pop.productno}`">
                            <img :src="`/api/product/productimage/${popular[idx].productno}/${popular[idx].imagename}`" alt="productImage">
                            <p style="height:70px">{{pop.productname}}</p>
                            <p class="price">{{AddComma(pop.price)}}원</p>
                        </router-link>
                    </div>
                </div>

                <h2 class="span1"> 관련상품</h2>
                <div class="products1">
                    <ul v-for="(prd, idx) in prod" :key="idx">
                        <li class="item">
                            <router-link v-bind:to="`/productDetail/${prd.productno}`">
                                <img :src="`/api/product/productimage/${prod[idx].productno}/${prod[idx].imagename}`" alt="productImage">
                            </router-link>
                            <div class="desc">
                                <router-link v-bind:to="`/productDetail/${prd.productno}`">
                                    <p class="name">{{prd.productname}}</p>
                                </router-link>
                                <p class="price"> 가격: {{AddComma(prd.price)}}원</p>
                                <p class="rate"> 10%할인: {{AddComma(prd.price*0.9)}}원</p>
                                <p class="delivery" v-if="prd.price >= 50000"> 무료배송</p>
                                <p class="delivery" v-if="prd.price < 50000"> {{AddComma(2500)}}원</p>
                            </div>
                            <div class="desc">
                                <span class="vendor"> 판매처: {{prd.nickname}}</span>
                            </div>
                        </li>
                    </ul>
                </div>
                <div style="text-align: center">
                    <button @click="pageMinus" class="pageBtn">이전 페이지</button>
                    <span v-for="idx in maxPage" :key="idx">
                        <span v-if="idx != page" class="pageOther" @click="setPage(idx)">{{idx}}</span>
                        <span v-if="idx == page" class="pageNow">{{idx}}</span>
                    </span>
                    <button @click="pagePlus" class="pageBtn">다음 페이지</button>
                </div>
            </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            popular: "",
            prod: "",
            test: "",
            min: 0,
            max: 99999999,
            page: 1,
            content: 5,
            maxPage: 0,
            prodCount: 0,
        }
    },
    methods: {
        getProd() {
            const productname = this.$route.params.id;
            axios({
                method: 'get',
                url: `/api/product/count`,
                params: {
                    productname: productname,
                    min: this.min,
                    max: this.max,
                }
            }).then(res => {
                this.prodCount = res.data;
                this.maxPage = Math.ceil(this.prodCount / this.content);
                axios({
                    method: 'get',
                    url: `/api/product/search`,
                    params: {
                        productname: productname,
                        page: 1,
                        content: this.content,
                        min: this.min,
                        max: this.max,
                    }
                }).then(res => {
                    this.prod = res.data;
                })
            })

        },
        getPopular() {
            const productname = this.$route.params.id;
            axios.get(`/api/product/popular/${productname}`).then(res => {
                this.popular = res.data;
            })
        },
        searchProd() {
            let min = document.getElementById('min').value;
            let max = document.getElementById('max').value;
            if (min.length == 0) {
                this.min = 0;
            } else {
                this.min = min;
            }
            if (max.length == 0) {
                this.max = 99999999;
            } else {
                this.max = max;
            }

            const productname = this.$route.params.id;
            axios({
                method: 'get',
                url: `/api/product/count`,
                params: {
                    productname: productname,
                    min: this.min,
                    max: this.max,
                }
            }).then(res => {
                this.prodCount = res.data;
                this.maxPage = Math.ceil(this.prodCount / this.content);
                axios({
                    method: 'get',
                    url: `/api/product/search`,
                    params: {
                        productname: productname,
                        page: 1,
                        content: this.content,
                        min: this.min,
                        max: this.max,
                    }
                }).then(res => {
                    this.prod = res.data;
                })
            })
        },
        AddComma(num) {
            let regexp = /\B(?=(\d{3})+(?!\d))/g;
            return num.toString().replace(regexp, ",");
        },
        pageMinus() {
            const productname = this.$route.params.id;
            if (this.page > 1) {
                this.page--;
                axios({
                    method: 'get',
                    url: `/api/product/search`,
                    params: {
                        productname: productname,
                        page: this.page,
                        content: this.content,
                        min: this.min,
                        max: this.max,
                    }
                }).then(res => {
                    this.prod = res.data;
                })
            }
        },
        pagePlus() {
            const productname = this.$route.params.id;
            if (this.page < this.maxPage) {
                this.page++;
                axios({
                    method: 'get',
                    url: `/api/product/search`,
                    params: {
                        productname: productname,
                        page: this.page,
                        content: this.content,
                        min: this.min,
                        max: this.max,
                    }
                }).then(res => {
                    this.prod = res.data;
                })
            }
        },
        setPage(idx) {
            const productname = this.$route.params.id;
            this.page = idx;
            axios({
                method: 'get',
                url: `/api/product/search`,
                params: {
                    productname: productname,
                    page: this.page,
                    content: this.content,
                    min: this.min,
                    max: this.max,
                }
            }).then(res => {
                this.prod = res.data;
            })
        }
    },
    mounted() {
        this.getProd();
        this.getPopular();
    }
}
</script>

<style scoped>
.all {
    display: flex;
    justify-content: space-evenly;
    margin: 0;
    padding: 0;
}

.container0 {
    width: 905px;
    margin: 0;
    padding: 0;
    display: flex;
}

.container {
    margin: 0;
    padding: 0;
    display: inline;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.priceSearch {
    width: 60px;
    border: 1px solid black;
    border-radius: 4px;
    outline: none;
}

.priceSearchBtn {
    padding: 0 5px;
    margin: 0 0 0 10px;
    width: 50px;
}

.products_fa {
    display: inline;
}

.span1 {
    display: flex;
    font-size: 22px;
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    margin: 10px;
    background-color: #fafafa;
    border-radius: 4px;
    border: 1px solid rgb(197, 195, 195);
    padding-left: 5px;
}

.products {
    display: inline-flex;
    justify-content: center;
}

.products router-link {
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 16px;
}

.products a {
    display: inline;
    width: 203px;
    margin: 0 10px;
    background-color: #fafafa;
    border-radius: 4px;
    border: 1px solid rgb(197, 195, 195);
}

.products a:visited,
.products a:hover,
.products a:link {
    color: black;
    text-decoration: none;
}

.products img {
    width: 200px;
    height: 200px;
    border-radius: 4px;
}

.products p {
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 16px;
}

.products p:nth-child(3) {
    font-weight: bold;
    font-size: 22px;
}

.products1 ul {
    list-style: none;
    padding: 0;
    margin: 0;

}

.products1 li {
    margin: 10px 10px;
    padding: 0;
    display: flex;
    align-items: center;
    background-color: #fafafa;
    border-radius: 4px;
    margin-left: 1px solid rgb(197, 195, 195);
    border: 1px solid rgb(197, 195, 195);
}

.products1 .item a>img {
    width: 200px;
    height: 200px;
    margin-top: 8px;
    border-radius: 4px;
}

.desc {
    margin: 0;
    display: inline-block;
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 16px;
}

.products1 .item .desc p {
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 16px;
    margin: 0 10px;
    width: 450px;
}

.products1 .item .desc p:nth-child(2) {
    text-decoration: line-through;
}

.products1 .item .desc p:nth-child(3) {
    font-weight: bold;
    font-size: 22px;
}

.desc .vendor {
    display: inline-block;
    border-left: 1px solid rgb(197, 195, 195);
    width: 200px;
    margin: 0;
    padding-top: 60px;
    padding-bottom: 60px;
    padding-left: 10px;
}

.container2 {
    display: inline-block;
    margin: 0;
    padding: 0;
}

.aside_info {
    border: 1px solid rgb(197, 195, 195);
    width: 250px;
    background-color: #fafafa;
    border-radius: 4px;
}

.aside_info h2 {
    margin: 0;
    display: flex;
    padding-left: 10px;
    border-bottom: 1px solid rgb(197, 195, 195);
    background-color: white;
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 22px;
}

.aside_info li .blank {
    text-decoration: none;
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    font-size: 18px;
}

.aside_info ul {
    list-style: none;
    margin: 10px;
    padding: 0;
    align-items: center;
}

.aside_info li {
    list-style: none;
    font-size: 16px;
    font-family: 맑은고딕, Malgun Gothic, dotum, gulim, sans-serif;
    padding: 5px;
    margin: 0;
}

.aside_info .buy a {
    list-style: none;
}

.clearfix {
    clear: both;
}

a:any-link {
    color: inherit;
}

.products p {
    padding-left: 5px;
}

:any-link {
    text-decoration: none;
    color: black;
}

.pageBtn {
    padding: 5px 10px;
    margin: 0 10px
}

.pageNow {
    font-size: 22px;
    margin: 0 5px;
}

.pageOther {
    margin: 0 5px;
}
</style>
