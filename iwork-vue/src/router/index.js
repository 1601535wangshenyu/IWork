import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login.vue'
import Register from '@/components/Register.vue'
import Layout from '../layout'
import About from '../views/About.vue'
import Dashboard from '@/views/dashboard/index'
import Documentation from'@/views/documentation/index'
import Icons from '@/views/icons/index'
Vue.use(Router)

export const routes = [
  {
    path: '/',
    name: '登录',
    component: Login
  },
  {
    path: '/login',
    name: '登录',
    component: Login
  },
  {
    path: 'register',
    name: '登录',
    component: Register
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    // 当设置 true 的时候该路由不会再侧边栏出现 如401，login等页面，或者如一些编辑页面/edit/1
    hidden: false, // (默认 false)
    // 当设置 noRedirect 的时候该路由在面包屑导航中不可被点击
    // redirect: 'noRedirect',
    // 当你一个路由下面的 children 声明的路由大于1个时，自动会变成嵌套的模式--如组件页面
    // 只有一个时，会将那个子路由当做根路由显示在侧边栏--如引导页面
    // 若你想不管路由下面的 children 声明的个数都显示你的根路由
    // 你可以设置 alwaysShow: true，这样它就会忽略之前定义的规则，一直显示根路由
    // alwaysShow: true,
    path: '/',
    name: 'index', // 设定路由的名字，一定要填写不然使用<keep-alive>时会出现各种问题
    component: Layout,
    redirect: '/dashboard',
    children: [
      {
        path: 'dashboard',
        component: Dashboard,
        name: 'Dashboard',
        meta: { title: 'Dashboard', icon: 'dashboard', affix: true }
      }
    ]
  },
  {
    path: '/documentation',
    component: Layout,
    children: [
      {
        path: 'index',
        component: Documentation,
        name: 'Documentation',
        meta: { title: 'Documentation', icon: 'documentation', affix: true }
      }
    ]
  }
]
export const asyncRoutes = [
  {
    path: '/icon',
    component: Layout,
    children: [
      {
        path: 'index',
        component: Icons,
        name: 'Icons',
        meta: { title: 'Icons', icon: 'icon', noCache: true }
      }
    ]
  }
]

const createRouter = () => new Router({
  mode: 'history',
  routes: routes,
  scrollBehavior: () => ({ y: 0 })
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
