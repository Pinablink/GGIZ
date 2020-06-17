import Vue from 'vue'
import App from './App.vue'
import Login from './components/Login.vue'

Vue.config.productionTip = false

Vue.component ('ggiz-login', Login)

new Vue({
  render: h => h(App),
}).$mount('#app')
