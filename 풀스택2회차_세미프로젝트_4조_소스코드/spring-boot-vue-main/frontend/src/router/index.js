import Vue from 'vue'
import VueRouter from 'vue-router'
import Main from '../views/Main.vue'
import store from '../store/index'
Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        // name: 'Main',
        component: Main,
        children: [
            {
                path: '',
                // name: 'Main',
                component: () => import ('@/components/mainPage/productTable.vue')
            }, {
                path: "/productDetail/:id",
                // name: 'productDetail',
                component: () => import ('@/views/productDetail.vue')
            },  {
                path: '/basket',
                // name: 'basket',
                component: () => import ('../views/basket.vue'),
                beforeEnter: (to, from, next) => {
                    console.log(`${from.path} ---> ${to.path}`)
                    const isLogin = store.getters['loginStore/getLogin']
                    console.log(isLogin)
                    if(isLogin){
                        next();
                    }
                    else{
                        next({name:'Login', params:{nextPage: to.fullPath}})
                    }
                },
            }, {
                path: '/customerService',
                // name: 'customerService',
                component: () => import ('../views/customerService.vue')
            }, {
                path: '/payment',
                // name: 'payment',
                component: () => import ('../views/payment.vue'),
                beforeEnter: (to, from, next) => {
                    console.log(`${from.path} ---> ${to.path}`)
                    const isLogin = store.getters['loginStore/getLogin']
                    console.log(isLogin)
                    if(isLogin){
                        next();
                    }
                    else{
                        next({name:'Login', params:{nextPage: to.fullPath}})
                    }
                },
            }, {
                path: '/otoQ',
                component: () => import ('../views/otoQ.vue')
            }, {
                path: '/shopping/:id',
                component: () => import ('../views/shopping.vue')
            }, {
                path: '/Mypage',
                component: () => import ('../views/Mypage.vue'),
                children: [
                    {
                        path: '/Mypage',
                        component: () => import ('@/components/mypage/Mypage1.vue')
                    }, {
                        path: '/Mypage2',
                        component: () => import ('@/components/mypage/Mypage2.vue')
                    }, {
                        path: '/Mypage3',
                        component: () => import ('@/components/mypage/Mypage3.vue')
                    }
                ],
                beforeEnter: (to, from, next) => {
                    console.log(`${from.path} ---> ${to.path}`)
                    const isLogin = store.getters['loginStore/getLogin']
                    console.log(isLogin)
                    if(isLogin){
                        next();
                    }
                    else{
                        next({name:'Login', params:{nextPage: to.fullPath}})
                    }
                },
            }
        ]
    }, {
        path: '/Login',
        name: 'Login',
        component: () => import ('../views/Login.vue')
    }, {
        path: '/blank',
        // name: 'blank',
        component: () => import ('../views/blank.vue')
    }, {
        path: '/signUp',
        // name: 'signUp',
        component: () => import ('../views/signUp.vue')
    }, {
        path: '/join1',
        component: () => import ('../views/Join.vue')
    }, {
        path: '/join2',
        component: () => import ('../views/Join.vue')
    },  {
        path: '/seller',
        component: () => import ('../views/seller.vue'),
        beforeEnter: (to, from, next) => {
            console.log(`${from.path} ---> ${to.path}`)
            const isLogin = store.getters['loginStore/getLogin']
            console.log(isLogin)
            if(isLogin){
                next();
            }
            else{
                next({name:'Login', params:{nextPage: to.fullPath}})
            }
        },
    }, {
        path: '*',
        component: () => import ('../views/blank.vue')
    }
]

const router = new VueRouter(
    {mode: 'history', base: process.env.BASE_URL, routes}
)

export default router
