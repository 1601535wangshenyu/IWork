<template>
  <el-form :rules="rules" class="login-container" label-position="left" label-width="0px" v-loading="loading">
    <h3 class="login_title">登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.username" prefix-icon="el-icon-user" auto-complete="off" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.password" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="checkCode">
      <el-row>
        <el-col span="10">
          <el-input type="text" auto-complete="off" prefix-icon="el-icon-key" style="width:180px" placeholder="验证码" >
          </el-input>
        </el-col>
        <el-col span="2">
          <div class="divIdentifyingCode" @click="getIdentifyingCode(true)">
            <img id="imgIdentifyingCode" style="height:40px; width: 100px; cursor: pointer;" alt="点击更换" title="图片" />
          </div>
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
    </el-form-item>
  </el-form>
</template>
<script>
  export default {
    data() {
      return {
        rules: {
          account: [{
            required: false,
            message: '请输入用户名',
            trigger: 'blur'
          }],
          checkPass: [{
            required: false,
            message: '请输入密码',
            trigger: 'blur'
          }]
        },
        checked: true,
        loginForm: {
          username: '',
          password: ''
        },
        loading: false,
      }
    },
    methods: {
      submitClick: function() {
        var _this = this;
        this.loading = true;
        this.postRequestLogin("/login", {
          username: this.loginForm.username,
          password: this.loginForm.password
        }).then(resp => {
          _this.loading = false;
          if (resp && resp.status == 200) {
            var data = resp.data
            var roleId = data.roleInfos[0].roleId
            this.$store.state.user.userId = data.userId
            this.$store.state.user.username = data.username
            this.$store.state.user.cname = data.cname
            this.$store.state.user.roleId = data.roleInfos[0].roleId
            this.$store.state.user.roleName = data.roleInfos[0].roleDesc
            this.$store.state.user.roleDepart = data.roleDepart
            this.initRoutesStore(data.roleInfos[0].sysFuns)
            // 当前登录用户的第一个子地址
            var firstSubUri = data.roleInfos[0].sysFuns[0].subSysFunList[0].nodeURL;
            var path = _this.$route.query.redirect;
            //管理员端：
            if (this.$store.state.user.roleId === 1) {
              _this.$router.replace({
                path: path == "/" || path == undefined ? "/schedule/note" : path
              })
            }
            //普通用户端
            else if (this.$store.state.user.roleId === 2) {
              _this.$router.replace({
                path: path == "/" || path == undefined ? "/attendence/staff" : path
              })
            }
            // 其他的用户
            else {
              _this.$router.replace({
                path: path == "/" || path == undefined ? firstSubUri : path
              })
            }
          }
        })
      },
      /**
       * 是否刷新
       */
      getIdentifyingCode: function(bRefresh) {
      },
      initUserStore: function(userInfo) {},
      initRoutesStore: function(routes) {
        console.log(routes)
        this.$store.state.routes = []
        for (let i of routes) {
          this.$store.state.routes.push({
            name: i.displayName,
            displayOrder: i.displayOrder,
            nodeId: i.nodeId,
            children: i.subSysFunList
          })
        }
      }
    }
  }
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 180px auto;
    width: 300px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .divIdentifyingCode {
    margin-left: 74px;
    width: 100px;
    /*设置图片显示的宽*/
    height: 40px;
    /*图片显示的高*/
    background: #f1f1f1;
    text-align: center;
  }
</style>