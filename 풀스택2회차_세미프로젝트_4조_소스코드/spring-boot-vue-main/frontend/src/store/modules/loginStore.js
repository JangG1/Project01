import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios'
import router from '../../router/index'
Vue.use(Vuex);

const loginStore = {
    namespaced: true,
    state: {
        user: null,
        toPath: ''
    },
    mutations: {
        Login(state, payload) {
            let user = {
                user_id: payload.id,
                user_nickname: payload.nickname,
                user_auth: payload.auth
            }
            state.user = user;
        },
        Logout(state) {
            state.user = null;
            // localStorage.clear();
        },
        setPath(state, payload) {
            state.toPath = payload;
        }
    },
    actions: {
        Login(context, payload) {
            let params = new URLSearchParams();
            params.append('id', payload.id);
            params.append('password', payload.password);
            axios
                .post('/api/member/login', params)
                .then(res => {
                    let user = {
                        id: res.data.id,
                        nickname: res.data.nickname,
                        auth: res.data.auth
                    }
                    return context.commit('Login', user);
                })
                .then(() => router.push(context.getters.getPath))
                .catch(err => {
                    if (err.response.status == 401) {
                        alert(err.response.data)
                        console.log(err.response.data)
                    }
                });
        }
    },
    getters: {
        getLogin: function (state) {
            return state.user;
        },
        getPath(state) {
            return state.toPath;
        }
    }
}

export default loginStore;
