<template>
<div class="banner">
    <div class="test">
        <carousel v-bind="options">
            <!-- // @initialized="init" -->
            <div class="test" v-for="(banners,idx) in bannerImage" :key="idx">
                <img :src="require(`@/assets/bannerImage/${banners.image}`)" alt="banner">
            </div>
        </carousel>
    </div>
</div>
</template>

<script>
import carousel from 'vue-owl-carousel2'
import BannerImage from './banner.json'
export default {
    components: {
        carousel,
    },
    data() {
        return {
            options: {
                autoplay: true,
                items: 1,
                autoplayTimeout: 3000,
                nav: true,
                navText: ["<i class='prev'></i>", "<i class='next'></i>"]
            },
                bannerImage: BannerImage
        }
    }
}
</script>

<style>
.test img {
    height: 400px;
}

.owl-theme .owl-nav [class*='owl-'] {
    color: black;
    font-size: 14px;
    margin: 0;
    padding: 0;
    background: gray;
    display: inline-block;
    cursor: pointer;
    border-radius: 3px;
}

.test {
}

.prev::after {
    content: '';
    width: 50px;
    /* 사이즈 */
    height: 50px;
    /* 사이즈 */
    border-top: 5px solid #121212;
    /* 선 두께 */
    border-right: 5px solid #121212;
    /* 선 두께 */
    display: inline-block;
    transform: rotate(225deg);
    /* 각도 */
    position: absolute;
    top: 50%;
    left: 10px;
}

.next::after {
    content: '';
    width: 50px;
    /* 사이즈 */
    height: 50px;
    /* 사이즈 */
    border-top: 5px solid #121212;
    /* 선 두께 */
    border-right: 5px solid #121212;
    /* 선 두께 */
    display: inline-block;
    transform: rotate(45deg);
    /* 각도 */
    position: absolute;
    top: 50%;
    right: 10px;
}
</style>
