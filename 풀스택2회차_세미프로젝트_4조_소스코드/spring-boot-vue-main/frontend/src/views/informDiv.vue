<template>
<div class="informDiv">
    <hr>
    <div class="upper">
        <div>
            <ul class="menu">
                <li v-for="(item, idx) in menuList" :key="idx">
                    <label v-if="idx==4 || idx==6" style="font-weight:bold;" for="">
                        <router-link :to="item.link">{{item.name}}</router-link>
                    </label>
                    <label v-else for="">
                        <router-link :to="item.link">{{item.name}}</router-link>
                    </label>
                </li>
            </ul>
        </div>
        <div class="selectDiv">
            <select name="" id="" class="selectBox">
                <option value="">셀러오피스</option>
                <option value="">셀러존</option>
                <option value="">애드오피스</option>
                <option value="">판매자광고센터</option>
            </select>
            <select name="" id="" class="selectBox">
                <option value="default">FAMILY SITE</option>
                <option value="">Fomily 주식화사</option>
                <option value="">기프티콘</option>
                <option value="">행복스토어</option>
                <option value="">Editor Office</option>
            </select>
        </div>
    </div>

    <div class="container">
        <div class="temp1">
            <p class="first">Fomily(주)</p><br>
            <p class="second">대표이사 : 가나다, 주소: 서울특별시 중구 한강대로 123, Tel: 1234-5678</p>
            <p class="second">사업자등록번호 : 123-45-67890, 통신판매업신고 : 2021-서울중구-0000사업자정보확인</p>
            <div class="">
                <span class="box">최저가110%보상제</span>
                <span class="box">위조품110%보상제</span>
                <span class="box">고객실수 보상서비스</span>
                <span class="box">앱다운로드</span>
            </div>
            <p class="fourth">Fomily(주)는 통신판매중개자로서 오픈마켓 Fomily의 거래당사자가 아니며, 입점판매자가 등록한 상품정보 및 거래에 대해 Fomily(주)는 일체 책임을 지지 않습니다.</p>
            <p class="fourth">Copyright © 2021 Fomily Co.,Ltd. All Rights Reserved.</p>
        </div>

        <div class="temp3">
            <p>고객센터 8765-4321</p>
            <p class="second">01234) 서울특별시 구로구 디지털로 123 (구로동)</p>
            <p class="second">Fax : 02-111-2222 / E-mail : customerservice@Fomily.co.kr</p>
            <router-link v-bind:to="'/customerService'">
                <p>고객센터 바로가기 ></p>
            </router-link>
            <p class="first">전자금융거래분쟁담당</p>
            <p class="fourth">Tel : 2222-3333 / Fax : 02-222-3333</p>
            <p class="fourth">E-mail : customerservice@Fomily.co.kr</p>
            <p> <a href="/blank">안전거래센터</a> <a href="/blank">지식재산권보호센터</a></p>
        </div>
    </div>
</div>
</template>

<script>
export default {
    data() {
        return {
            menuList: [{
                    name: '회사소개',
                    link: '/blank',
                },
                {
                    name: '채용정보',
                    link: '/blank',
                },
                {
                    name: '이용약관',
                    link: '/blank',
                },
                {
                    name: '전자금융거래약관',
                    link: '/blank',
                },
                {
                    name: '개인정보처리방침',
                    link: '/blank',
                },
                {
                    name: '입점신청',
                    link: '/blank',
                },
                {
                    name: '광고안내',
                    link: '/blank',
                },

                {
                    name: '서비스맵',
                    link: '/blank',
                },
            ],
        }
    }
}
</script>

<style scoped>
.informDiv {
    background-color: #fafafa;
}

.container {
    display: flex;
}

.upper {
    width: 100%;
    display: flex;
    align-items: center;
}

.selectDiv {
    margin-left: auto;
}

.selectBox {
    width: 160px;
    height: 30px;
    margin-right: 15px;
}

.temp1 {
    width: 762px;
    margin-right: auto;
}

.temp3 {
    width: 350px;
    margin-left: auto;
    margin-right: 0px;
}

.menu {
    padding: 0;
    list-style: none;
    display: flex;
    text-align: center;
}

.menu>li {
    margin-right: 13px;
}

:any-link {
    text-decoration: none;
    color: black;
}

hr {
    width: 100vw;
    margin-left: calc(-15vw);
}

.first,
.second,
.fourth {
    margin: 0;
    padding: 0;
}

.first {
    font-size: 18px;
    font-weight: bold;
}

.second {
    font-size: 13px;
}

.fourth {
    font-size: 11px;
}

.box {
    border: 1px solid gray;
    margin-right: 10px;
    padding: 0 2px 0 2px;
    font-size: 12px;
}
</style>
