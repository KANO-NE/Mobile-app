import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// 解决导航栏或者底部导航tabBar中的vue-router在3.0版本以上频繁点击菜单报错的问题。
const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (location) {
  return originalPush.call(this, location).catch(err => err)
}

const routes = [
  {
    path: '/',
    name: 'Manager',
    component: () => import('../views/Manager.vue'),
    redirect: '/home',  // 重定向到主页
    children: [
      { path: '403', name: 'NoAuth', meta: { name: '无权限' }, component: () => import('../views/manager/403') },
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/manager/Home') },
      { path: 'admin', name: 'Admin', meta: { name: '管理员信息' }, component: () => import('../views/manager/Admin') },
      { path: 'user', name: 'User', meta: { name: '用户信息' }, component: () => import('../views/manager/User') },
      { path: 'adminPerson', name: 'AdminPerson', meta: { name: '个人信息' }, component: () => import('../views/manager/AdminPerson') },
      { path: 'password', name: 'Password', meta: { name: '修改密码' }, component: () => import('../views/manager/Password') },
      { path: 'notice', name: 'Notice', meta: { name: '公告信息' }, component: () => import('../views/manager/Notice') },
      { path: 'topic', name: 'Topic', meta: { name: '话题信息' }, component: () => import('../views/manager/Topic') },
      { path: 'banner', name: 'Banner', meta: { name: '话题信息' }, component: () => import('../views/manager/Banner') },
      { path: 'activity', name: 'Activity', meta: { name: '活动信息' }, component: () => import('../views/manager/Activity') },
      { path: 'activitytype', name: 'Activitytype', meta: { name: '活动类型' }, component: () => import('../views/manager/Activitytype') },
      { path: 'topicreply', name: 'Topicreply', meta: { name: '活动类型' }, component: () => import('../views/manager/Topicreply') },
      { path: 'activityrecords', name: 'Activityrecords', meta: { name: '活动类型' }, component: () => import('../views/manager/Activityrecords') },
      { path: 'historyrecord', name: 'Historyrecord', meta: { name: '浏览信息' }, component: () => import('../views/manager/Historyrecord') },
      { path: 'collect', name: 'Collect', meta: { name: '收藏信息' }, component: () => import('../views/manager/Collect') },
      { path: 'usercollect', name: 'Usercollect', meta: { name: '用户关注' }, component: () => import('../views/manager/Usercollect') },
      { path: 'customer', name: 'Customer', meta: { name: '客服聊天' }, component: () => import('../views/manager/Customer') },
    ]
  },
  {
    path: '/front',
    name: 'Front',
    component: () => import('../views/Front.vue'),
    children: [
      { path: 'home', name: 'Home', meta: { name: '系统首页' }, component: () => import('../views/front/Home') },
      { path: 'person', name: 'Person', meta: { name: '个人信息' }, component: () => import('../views/front/Person') },
    ]
  },
  { path: '/login', name: 'Login', meta: { name: '登录' }, component: () => import('../views/Login.vue') },
  { path: '/register', name: 'Register', meta: { name: '注册' }, component: () => import('../views/Register.vue') },
  { path: '*', name: 'NotFound', meta: { name: '无法访问' }, component: () => import('../views/404.vue') },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

// 注：不需要前台的项目，可以注释掉该路由守卫
// 路由守卫
// router.beforeEach((to ,from, next) => {
//   let user = JSON.parse(localStorage.getItem("xm-user") || '{}');
//   if (to.path === '/') {
//     if (user.role) {
//       if (user.role === 'USER') {
//         next('/front/home')
//       } else {
//         next('/home')
//       }
//     } else {
//       next('/login')
//     }
//   } else {
//     next()
//   }
// })

export default router
