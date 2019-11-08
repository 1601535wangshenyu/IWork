import Vue from 'vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/index.js'

Vue.config.productionTip = false
Vue.use(VueAxios, axios)
Vue.use(ElementUI)

import App from './App.vue'
import router from './router'
import store from './store'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)

import './assets/styles/index.scss'
import './assets/styles/reset.css'
import './assets/styles/border.css'
import './icons'

import fastClick from 'fastclick'
Vue.config.productionTip = false
fastClick.attach(document.body)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
