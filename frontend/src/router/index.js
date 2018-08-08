import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Claims from '@/components/Claims'
import Notifications from '@/components/Notifications'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: {
          name: "Login"
      }
    },
    {
        path: "/login",
        name: "Login",
        component: Login
    },
    {
      path: '/home',
      name: 'Home',
      component: Home
    },
         {
           path: '/claims',
           name: 'Claims',
           component: Claims
         },
              {
                path: '/notifications',
                name: 'Notifications',
                component: Notifications
              }
  ]
})
