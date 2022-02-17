<template>
<div class="main">
    <!-- 상단 메뉴바 -->
    <div class="nav">
        <ul class="search">
            <!-- 드랍메뉴 -->
            <li>
                <div class="dropDownMenu">
                    <button class="dropDownMenuBtn">
                       <div class="wrapper">
                           <div class="line"></div>
                           <div class="line"></div>
                           <div class="line"></div>
                       </div>
                    </button>
                    <div class="dropDownMenuContent">
                        <router-link class="pageLink" style="color:white" v-for="(link, index) in leftMenuName" :key="index" v-bind:to="link.link">
                            {{link.name}}
                        </router-link>
                    </div>
                </div>
            </li>
            <!-- 로고 -->
            <li>
                <router-link class="pageLink" v-bind:to="'/'">
                    <div class="logo">
                        <router-link v-bind:to="'/'"> <img src="@/assets/logo.jpg" alt="logo" style="width:65px; height:65px; "></router-link>
                    </div>
                </router-link>
            </li>
            <!-- 검색창 -->
            <li>
                <div class="searchBar">
                    <select name="searchSelect" id="" class="searchSelectBox">
                        <option value="1">통합검색</option>
                        <option value="2">오늘발송</option>
                        <option value="3">가격비교</option>
                    </select>
                    <input id="search" type="text" v-on:keyup.enter="search()" style="font-size: 20px" placeholder="검색어 입력">
                    <button @click="search()">검색</button>
                </div>
            </li>
        </ul>
        <!-- 회원 관련 버튼 -->
        <!-- getLogin을 통해 로그인 여부를 확인하여 
            로그인을 했을 경우 1번 로그인을 안했을 경우 2번 로그인이 필요없는 경우 3번이 실행-->
        <ul class="member">
            <li v-for="(link, i) in memberMenu" :key="i">
                <router-link v-bind:to="link.link" class="pageLink">
                    <item>{{link.name}}</item>
                </router-link>
            </li>
        </ul>
    </div>
    <div class="menu">
        <ul class="leftMenu">
            <li v-for="(link, i) in leftMenuName" :key="i">
                <router-link v-bind:to="link.link" class="pageLink">
                    <item>{{link.name}}</item>
                </router-link>
            </li>
        </ul>
        <!-- 회원의 접속 관련 메뉴 로그인 로그아웃 회원가입 버튼 -->
        <ul class="rightMenu">
            <li v-if="getLogin" >
                <router-link :to="'/seller'" class="pageLink" v-if="getLogin.user_auth == 'ADMIN' || getLogin.user_auth == 'SELLER'">
                    <item>셀러페이지</item>
                </router-link>
            </li>
            <li v-for="(link, i) in rightMenuName" :key="i">
                <!-- 미로그인 상태에서의 로그인 버튼과 회원가입 버튼 -->
                <router-link v-if="i==0 && !getLogin" v-bind:to="link.link" class="pageLink">
                    <item>로그인</item>
                </router-link>
                <router-link v-else-if="i==1 && !getLogin" v-bind:to="link.link" class="pageLink">
                    <item>회원가입</item>
                </router-link>
                <!-- 로그인상태에서의 접속자의 아이디 표시와 누르면 마이페이지 이동 기능과 로그아웃 버튼 -->
                <router-link v-else-if="i==2 && getLogin" v-bind:to="link.link" class="pageLink">
                    <item>{{getLogin.user_nickname}}님</item>
                </router-link>
                <router-link v-else-if="i==3 && getLogin" v-bind:to="link.link" class="pageLink">
                    <item @click="Logout">로그아웃</item>
                </router-link>
            </li>
        </ul>
    </div>
    <hr class="lineNav">
    <!-- 메인 하위 컴포넌트 표시 구역 -->
    <router-view></router-view>
</div>
</template>

<script>
// @ is an alias to /src
import "@/css/common.css"
// 새로고침과 페이지 이동시 로그인 상태 확인 및 유지 기능
import {
    createNamespacedHelpers
} from 'vuex';
// 로그인 상태 관련 모듈
const loginStore = createNamespacedHelpers('loginStore');
export default {
    name: 'Main',
    components: {},
    data() {
        return {
            memberMenu: [{
                    link: "/Mypage",
                    name: '마이페이지'
                }, {
                    link: "/basket",
                    name: '장바구니'
                },
                {
                    link: "/customerService",
                    name: '고객센터'
                },
            ],
            leftMenuName: [{
                link: "/blank",
                name: '베스트'
            }, {
                link: "/blank",
                name: '최신'
            }, {
                link: "/blank",
                name: '인기'
            }, {
                link: "/blank",
                name: '특별'
            }, ],
            rightMenuName: [{
                link: "/login",
                name: ''
            }, {
                link: "/signUp",
                name: ''
            }, {
                link: "/Mypage2",
                name: ""
            }, {
                link: "/",
                name: ''
            }, ]
        }
    },
    computed: {
        // 로그인한 유저정보를 반환
        ...loginStore.mapGetters(['getLogin'])
    },
    methods: {
        // 검색 기능 신발만 가능
        search() {
            const targetId = document.getElementById("search").value;
            this.$router.push(`/shopping/${targetId}`);
        },
        // 로그아웃 상태로 전환
        ...loginStore.mapMutations([
            'Logout'
        ]),
      
    },
    watch: {
        $route(from){
            if(from.path.indexOf('/shopping') != -1){
                this.$router.go();
            }
        }
    },
    mounted() {
      
    }
}
</script>

<style scoped>
.nav {
    display: flex;
    width: 100%;
    height: 80px;
    position: fixed;
    z-index: 200;
    background-color: white;
}

.search {
    display: flex;
    list-style: none;
    padding: 0;
    width: 51.4%;
    margin: 0;
    height: 80px;
}

.search li {
    padding: 0 2px;
    margin: 0;
    margin-left: 50px;
    display: flex;
    align-items: center;

}

.search li:first-child {
    margin-left: 0px;
}

.search img {
    height: 65px;
}

.dropDownMenu {
    position: relative;
    display: inline-block;
}

.dropDownMenuBtn {
    padding: 10px;
    width: 100px;
    text-align: center;
    cursor: pointer;
    margin-left: 0;
}

.dropDownMenuBtn:hover {
    border-radius: 4px 4px 0 0;
}
.line {
  position:relative;
  background:#ffffff;
  margin-top:6px;
  margin-bottom:6px;
  margin-left:auto;
  margin-right: auto;
  width:48px;
  height:3px; 
  border-radius:2px;
  /* box-shadow:0 1px 3px rgb(255, 255, 255); */
}
.dropDownMenuContent {
    display: none;
    position: absolute;
    z-index: 2;
    /*다른 요소들보다 앞에 배치*/
    font-weight: 400;
    background-color: rgb(0, 153, 255);
    width: 100px;
    max-width: 100px;
    border-radius: 0 0 4px 4px;

}

.dropDownMenuContent * {
    display: block;
    text-decoration: none;
    color: white;
    font-size: 16px;
    padding: 12px 10px;
    text-align: center;
}

.dropDownMenuContent *:hover {
    background-color: rgb(0, 153, 255);
    cursor: pointer;

}

.dropDownMenu:hover .dropDownMenuContent {
    display: block;
}

.member {
    display: flex;
    list-style: none;
    padding: 0;
    margin: 0;
}

.member li {
    padding: 0;
    margin: 0;
    display: flex;
    align-items: center;
}

item {
    display: inline-block;
    text-align: center;
    font-weight: 600;
}

item:hover {
    border-bottom: 3px solid rgb(0, 153, 255);
    margin-bottom: -3px;
}

.member item {
    width: 115px;
}

.searchBar {
    display: flex;
}

.searchSelectBox {
    min-width: 100px;
    font-size: 20px;
    border: 2px solid rgb(0, 153, 255);
    border-radius: 4px 0 0 4px;
    outline: none;
}

.searchBar input {
    margin-top: 2px;
    padding-left: 5px;
    height: 48px;
    width: 395px;
    outline: 2px solid rgb(0, 153, 255);
    -webkit-appearance: none;
    border: none;
    font-size: 40px;
}

.searchBar button {
    border-radius: 0 4px 4px 0;
}

.searchBar input:focus {
    outline: 2px solid rgb(0, 153, 255);
}

.searchBar button {
    margin: 0;
}

.menu {
    display: flex;
    padding-top: 80px;
    height: 80px;
    align-items: center;
}

.menu ul {
    display: flex;
    list-style: none;
}

.menu li {
    padding: 0;
    margin: 0;
}

.leftMenu {
    margin-left: 5px;
    padding: 0;
}

.leftMenu item {
    width: 90px;
}

.rightMenu {
    margin-right: 5px;
    margin-left: auto;
    padding: 0;
}

.rightMenu item {
     width: auto;
    margin-right: 10px;
}

.lineNav {
    width: 100vw;
    margin-left: calc(-15vw);
    margin-top: 20px;
}

.pageLink,
.pageLink:hover,
.pageLink:visited,
.pageLink:active {
    text-decoration: none;
    font-size: 20px;
    color: rgb(0, 153, 255);
}

.logo {
    display: flex;
    height: 65px;
    background-color: rgb(0, 153, 255);
    color: white;
    align-items: center;
    text-align: center;
}

.logo>p {
    width: 65px;
    padding: 0;
    margin: 0;
    font-size: 50px;
    font-weight: bold;
}


</style>
