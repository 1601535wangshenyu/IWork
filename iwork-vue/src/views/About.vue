<template>
  <div class="about">
    <h1>This is an about page</h1>
    <el-form :rules="registerRules" class="registerForm" label-position="left" label-width="100px" v-loading="loading">
        <h3 class="login_title" style="margin-bottom:24px;">注   册</h3>
          <el-radio v-model="radio" label="1" @change="changeRadio" style="margin:0px 20px 16px 30px;">邮箱注册</el-radio>
          <el-radio v-model="radio" label="2" @change="changeRadio" style="margin-bottom:5px;">手机注册</el-radio>
        <el-form-item prop="tel" label="手机：" v-if="isTel" >
          <el-input  v-model="registerForm.tel" prefix-icon="el-icon-phone" auto-complete="off" placeholder="手机号"></el-input>
        </el-form-item>
        <el-form-item prop="mail" label="邮箱：" v-else >
          <el-input  v-model="registerForm.mail" prefix-icon="el-icon-message" auto-complete="off" placeholder="邮箱"></el-input>
        </el-form-item>
          <el-form-item prop="checkCode" label="验证码：">
              <el-input type="text" v-model="registerForm.checkCode" auto-complete="off"  prefix-icon="el-icon-key" placeholder="验证码">
              </el-input>
        </el-form-item>
        <el-form-item>
            <el-button plain style="font-size:14px;width:100%;margin-top:-10px;">点击发送验证码</el-button>
        </el-form-item>
        <el-form-item prop="id" label="员工ID：">
          <el-input type="text" v-model="registerForm.id" prefix-icon="el-icon-bank-card" auto-complete="off" placeholder="员工ID"></el-input>
        </el-form-item>
        <el-form-item prop="key" label="账号：">
          <el-input type="text" v-model="registerForm.key" prefix-icon="el-icon-user" auto-complete="off" placeholder="用户名"></el-input>
        </el-form-item>

        <el-form-item prop="checkPass1" label="密码：">
          <el-input type="password" v-model="registerForm.checkPass1" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="新密码"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass2" label="确认密码：">
          <el-input type="password" v-model="registerForm.checkPass2" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="确认新密码"></el-input>
        </el-form-item>
          <el-button type="primary" style="width: 100%" @click="submitClick()">注册</el-button>
      </el-form>
  </div>
</template>
<script>
import {validatePhone,validateMail,isEngNumLine} from "@/utils/validate";
export default {
  data(){
    return{
      registerForm:{
          id: '',
          key: '',
          checkPass1: '',
          checkPass2: '',
          tel:'',
          mail:'',
          checkCode:'',
        },
       registerRules: {
          mail:[{required: true,validator:validateMail,trigger:"blur"}],
          tel:[{required: true,message: '请输入手机号',trigger: 'blur'},{validator:validatePhone,trigger:"blur"}],
          checkCode:[{required: true,message: '请输入验证码',trigger: 'blur'}],
          id: [{ required: true,message: '请输入员工id',trigger: 'blur'}],
          key: [{ required: true,message: '请输入用户名',trigger: 'blur'},
                {validator:isEngNumLine,message: '请输入字母数字或下划线',trigger:'blur'}],
          checkPass1: [{ required: true,message: '请输入密码',trigger: 'blur'},{validator:isEngNumLine,trigger:"blur"}],
          checkPass2: [{ required: true,message: '请输入密码',trigger: 'blur'},
                       {validator:(rule,value,callback)=>{
                         if(value===''){callback(new Error('请再次输入密码'))}
                         else if(value!==this.registerForm.checkPass2){callback(new Error('两次输入密码不一致'))}
                         else{callback( )}},trigger:'blur'}
                      ],
        },
        checked: true,
        loginForm: {
          key: '',
          password: '',
          vcode: ''
        },
        
        loading: false,
        contentWidth: 100,
        contentHeight: 40,
        imgCode: '',
        radio:'1',
        isTel:false,
        diaglogVisible:false,
        forgetRadio:'',
    }
  },
  methods:{
    changeRadio:function(){
        this.isTel = !this.isTel;
      },
    submitClick(){

    }
  }
}
</script>
