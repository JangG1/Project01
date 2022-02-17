<template>
<div class="main">
    <!-- 배너영역 -->
    <div class="banner">
        <bannerImage />
    </div>
    <!-- 메인 화면에 이미지를 출력하는 기능 -->
    <div>
        <h1>추천상품</h1>
        <div class="imageArea">
            <div class="card_image" v-for='(idx) in limitLength' :key="idx">
                <div class="imageDiv">
                    <router-link v-bind:to="images[idx-1].link">
                        <img :src="`/api/product/productimage/${images[idx-1].prodno}/${images[idx-1].image}`" alt="productImage">
                    </router-link>
                </div>
                <div class="imageTitle">
                    <router-link v-bind:to="images[idx-1].link">
                        <div class="temp"><label for="">{{images[idx-1].name}}</label></div>
                        <h3 for="">{{AddComma(images[idx-1].price) }}원</h3>
                    </router-link>
                </div>
            </div>
        </div>
        <div class="moreImageDiv">
            <button v-on:click="moreImage" class="moreImageBtn">더 보기</button>
        </div>
    </div>
</div>
</template>

<script>
import axios from 'axios'
// import imageJson from './image.json'
import bannerImage from '@/components/mainPage/mainPageBanner.vue'
export default {
    data() {
        return {
            limitLength: 0,
            imageLength: 0,
            images: []
        }
    },
    components: {
        bannerImage
    },
    methods: {
        // 화면에 보이는 이미지 출력 길이를 늘리는 기능
        moreImage() {
            if (this.limitLength < this.imageLength) {
                if (this.imageLength - this.limitLength < 4)
                    this.limitLength = this.imageLength;
                else
                    this.limitLength += 4;
            }
            // else{

            // }
        },
        AddComma(num) {
            let regexp = /\B(?=(\d{3})+(?!\d))/g;
            return num.toString().replace(regexp, ",");
        },
        async getImagesData() {
            await axios.get("/api/product/productDetail/all").then(res => {
                this.data = res.data;
                this.data.forEach(element => {
                    let temp = {
                        image: element.imagename,
                        name: element.productname,
                        prodno: element.productno,
                        link: '/productDetail/' + element.productno,
                        price: element.price
                    }
                    this.images.push(temp);
                });
                this.imageLength = this.images.length;
                if (this.imageLength > 12)
                    this.limitLength = 12;
                else
                    this.limitLength = this.imageLength;
            })
            // alert(this.imageLength)
        }
    },
    mounted() {
        this.getImagesData();

    }

}
</script>

<style scoped>
.banner img {
    max-width: 100%;
    height: auto;
}

h2 {
    text-align: left;
    margin: 0 0 0 10px;
    padding: 0;
    margin-bottom: 20px;
}

ul {
    list-style: none;
    display: flex;
    margin: 10;
    padding: 0;
}

.imageArea {
    /* margin-left: auto;
    margin-right: auto;
    width:1300px; */
    display: flex;
    flex-wrap: wrap;
    text-align: center;
    /* padding-left :10px; */
}

.card_image {
    margin-bottom: 10px;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
}

.card_image:nth-child(4n-3) {
    /* border: 1px solid black; */
    margin-left: 2px;
    margin-right: 20px;
}

.card_image:nth-child(4n-2) {
    /* border: 1px solid red; */
    margin-left: 20px;
    margin-right: 20px;
}

.card_image:nth-child(4n-1) {
    /* border: 1px solid blue; */
    margin-left: 20px;
    margin-right: 20px;
}

.card_image:nth-child(4n) {
    /* border: 1px solid green; */
    margin-left: 20px;
    margin-right: 0;
}

/* .card_image:last-child {
    margin-left: 20px;
    margin-right: auto;
} */

.card_image>.imageDiv {
    width: 300px;
    height: 200px;
    overflow: hidden;
    margin-top: 0px;
    margin-bottom: 0px;
    border-radius: 4px 4px 0 0;
}

.imageDiv img {
    width: 100%;
    height: 100%;
    object-fit: cover;
}

.card_image>.imageTitle {
    display: block;
    text-align: left;
    width: 290px;
    overflow: hidden;
    margin-top: 0px;
    margin-bottom: 0px;
    background-color: #fafafa;
    border-radius: 0 0 4px 4px;
    padding-top: 5px;
    padding-left: 10px;
}

.imageTitle a:link {
    color: rgb(78, 76, 76);
    text-decoration: none;
}

.imageTitle a:hover {
    color: rgb(78, 76, 76);
    text-decoration: none;
}

.imageTitle a:visited {
    color: rgb(78, 76, 76);
    text-decoration: none;
}

.imageTitle a {
    font-weight: none;
    color: rgb(78, 76, 76);
}

.moreImageDiv {
    text-align: center;
}

label {
    font-weight: 600;
}

.temp {
    height: 48px;
    display: block;
}

h1 {
    text-align: left;
    background-color: #fafafa;
    padding: 10px;
    border: 1px solid rgb(197, 195, 195);
    border-radius: 4px;
    color: rgb(78, 76, 76);
}

/*  */
</style>
