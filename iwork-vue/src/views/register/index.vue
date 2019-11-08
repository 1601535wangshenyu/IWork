<template>
  <div>
    <div class="login-wrap">
      <el-form :model="ruleForm" status-icon :rules="rules" label-width="100px" inline>
        <el-radio v-model="radio" label="1">备选项</el-radio>
        <el-radio v-model="radio" label="2">备选项</el-radio>

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
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose"
      >
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
  name: 'Index'
}
</script>

<style scoped>

</style>
