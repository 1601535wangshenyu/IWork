<template>
  <div :class="{'has-logo':showLogo}">
    <logo v-if="showLogo" :collapse="isCollapse" />
    <el-scrollbar wrap-class="scrollbar-wrapper">
      <el-menu
        :default-active="activeMenu"
        :collapse="isCollapse"
        :background-color="variables.menuBg"
        :text-color="variables.menuText"
        :unique-opened="false"
        :active-text-color="variables.menuActiveText"
        :collapse-transition="false"
        mode="vertical"
      >
        <sidebar-item v-for="route in permission_routes" :key="route.path" :item="route" :base-path="route.path" />
      </el-menu>
    </el-scrollbar>
  </div>
</template>

<script>
import Logo from './Logo'
import SidebarItem from './SidebarItem'
import { mapGetters } from 'vuex'
import variables from '@/assets/styles/_variables.scss'

export default {
  name: 'Sidebar',
  components: {
    Logo,
    SidebarItem
  },
  computed: {
    ...mapGetters([
      'permission_routes'
    ]),
    showLogo() {
      return this.$store.state.settings.sidebarLogo
    },
    /**
     * 选取默认激活的菜单
     * @returns {string|default.computed.activeMenu}
     */
    activeMenu() {
      // 获取当前路由
      const route = this.$route
      // 对象的解构赋值 取得路由中的配置信息
      const { meta, path } = route
      // 判断 meta 中是否有默认的激活状态路由
      if (meta.activeMenu) {
        return meta.activeMenu
      }
      // 没有返回 route 对象的 path 作为激活路由
      return path
    },
    isCollapse() {
      return false
    },
    variables() {
      return variables
    }
  }
}
</script>

<style scoped>

</style>
