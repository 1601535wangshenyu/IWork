<template>
  <div class="login-view">
    <div class="login-wrap">
      <el-form :model="ruleForm" status-icon :rules="rules" label-width="100px" inline>
        <div class="title-container">
          <h1 class="title">iWork</h1>
        </div>

        <el-form-item prop="username" clearable="clearable">
          <el-input
            ref="username"
            v-model="loginForm.username"
            placeholder="Email/Phone"
            name="username"
            type="text"
            tabindex="2"
            autocomplete="on"
            clearable="true"
          />
        </el-form-item>

        <el-form-item prop="password" clearable="clearable" prefix-icon>
          <el-input
            ref="password"
            v-model="loginForm.password"
            placeholder="Password"
            name="password"
            tabindex="2"
            autocomplete="on"
            show-password
            clearable
          />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </el-form-item>
      </el-form>

      <el-button type="text" @click="dialogVisible = true">忘记密码</el-button>
      <el-button type="text" @click="dialogVisible = true">还没账号？快速注册</el-button>
      <el-button type="text" @click="dialogVisible = true">其他登录方式</el-button>
      <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
        <span>这是一段信息</span>
        <span slot="footer" class="dialog-footer">
          <el-button @click="dialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      dialogVisible: false
    }
  },
  methods: {
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done()
        })
        .catch(_ => {})
    }
  }
}
</script>

<style scoped lang="stylus">
.login-view {
  background: #00FF00  no-repeat fixed top;
  height: 100vh;

  .login-wrap {
    width: 50vw;
    background-color: #be2;
    text-align: center;
    margin: 0 auto;
  }
}
</style>
