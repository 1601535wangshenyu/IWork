<template>
  <div class="home">
    <el-row class="block-col-2">
      <el-col :span="12">
        <img alt="IWork Cloud Logo" src="">
      </el-col>
      <el-col :span="12">
        <el-dropdown trigger="click">
          用户名<i class="el-icon-user"></i>
        </el-dropdown>
      </el-col>
    </el-row>
    <!-- <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handSelect">
      <el-menu-item index="1" >
        <img alt="IWork Cloud Logo" src="">
      </el-menu-item>
      <el-menu-item index="4">
        <div> 姓名
          <el-avatar src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
        </div>
      </el-menu-item>
    </el-menu> -->
    <!-- <img alt="Vue logo" src="../assets/logo.png">
      <HelloWorld msg="Welcome to Your Vue.js App"/> -->
  </div>
</template>

<script>
  // @ is an alias to /src
  import HelloWorld from '@/components/HelloWorld.vue'
  export default {
    name: 'home',
    // components: {
    //   HelloWorld
    // }
  }
</script>
<style>
.home-container {
  height: 100%;
  position: absolute;
  top: 0px;
  left: 0px;
  width: 100%;
}

.home-header {
  background-color: #12ABDB;
  color: #ffffff;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: space-between;
  box-sizing: content-box;
  padding: 0px;
}
</style>