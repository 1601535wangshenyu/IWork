<template>
  <el-tabs type="border-card" class="login-container" strech="true">
    <el-tab-pane label="登录" style="border-radius:15px;">
      <el-form :rules="loginRules" :model="loginForm" class="loginForm" label-position="left" label-width="0px" v-loading="loading">
        <h3 class="login_title">登 录</h3>
        <el-form-item prop="key">
          <el-input type="text" v-model="loginForm.key" prefix-icon="el-icon-user" auto-complete="off" placeholder="用户名"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass">
          <el-input type="password" v-model="loginForm.password" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="密码"></el-input>
        </el-form-item>
        <el-form-item prop="checkCode">
          <el-row>
            <el-col :span="8">
              <el-input type="text" v-model="loginForm.vcode" auto-complete="off" style="width:160px;" prefix-icon="el-icon-key" placeholder="验证码">
              </el-input>
            </el-col>
            <el-col :span="2" :offset="7">
              <div class="divIdentifyCode" @click="getIdentifyCode">
                <img :src="imgCode" id="imgCode">
              </div>
            </el-col>
          </el-row>
        </el-form-item>
        <el-form-item style="width: 100%">
          <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
        </el-form-item>
        <!-- 忘记密码 -->
        <el-button type="text" @click="diaglogVisible=true">忘记密码</el-button>
        <el-dialog>
        </el-dialog>
      </el-form>

      <el-dialog title="重置密码" :visible.sync="diaglogVisible" width="36%" >
        <el-form class="loginForm" :model="forgetForm" :rules="forgetRules" label-position="left" label-width="100px" v-loading="loading">
          <el-radio-group v-model="forgetRadio" @change="changeForgetRadio" style="margin-bottom: 30px;">
            <el-radio-button :label="1" >邮箱验证</el-radio-button>
            <el-radio-button :label="2" >手机验证</el-radio-button>
          </el-radio-group>
          <el-form-item prop="id" label="员工ID：">
            <el-input type="text" v-model="forgetForm.id" prefix-icon="el-icon-bank-card" auto-complete="off" placeholder="员工ID"></el-input>
          </el-form-item>
          <el-form-item prop="tel" label="手机：" v-if="isTel1" >
            <el-input  v-model="forgetForm.tel" prefix-icon="el-icon-phone" auto-complete="off" placeholder="手机号"></el-input>
          </el-form-item>
          <el-form-item prop="mail" label="邮箱：" v-else >
            <el-input  v-model="forgetForm.mail" key="mail" prefix-icon="el-icon-message" auto-complete="off" placeholder="邮箱"></el-input>
          </el-form-item>
          <el-form-item prop="checkCode" label="验证码：">
              <el-input type="text" v-model="forgetForm.checkCode" auto-complete="off"  prefix-icon="el-icon-key" placeholder="验证码">
              </el-input>
          </el-form-item>
          <el-form-item>
              <el-button plain style="font-size:14px;width:100%;margin-top:-10px;" @click="sendCode('forget')">点击发送验证码</el-button>
          </el-form-item>
          <el-form-item prop="checkPass1" label="新密码：">
            <el-input type="password" v-model="forgetForm.checkPass1" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="新密码"></el-input>
          </el-form-item>
          <el-form-item prop="checkPass2" label="确认密码：">
            <el-input type="password" v-model="forgetForm.checkPass2" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="确认新密码"></el-input>
          </el-form-item>
          <el-button type="primary" @click="ChangePassword">确认</el-button>
          <el-button  @click="Cancel">取消</el-button>
        </el-form>
      </el-dialog>
    </el-tab-pane>

    <!-- 注册 -->
    <el-tab-pane label="注册" style="border-radius:15px;">
      <el-form :rules="registerRules" :model="registerForm" ref="registerForm" class="loginForm" label-position="left" label-width="100px" v-loading="loading">
        <h3 class="login_title" style="margin-bottom:24px;">注   册</h3>
          <el-radio v-model="radio" label="1" @change="changeRadio" style="margin:0px 20px 16px 30px;">邮箱注册</el-radio>
          <el-radio v-model="radio" label="2" @change="changeRadio" style="margin-bottom:5px;">手机注册</el-radio>
        <el-form-item prop="tel" label="手机：" v-if="isTel" >
          <el-input  v-model="registerForm.tel" prefix-icon="el-icon-phone" auto-complete="off" placeholder="手机号"></el-input>
        </el-form-item>
        <el-form-item prop="mail" label="邮箱：" v-else >
          <el-input  v-model="registerForm.mail" key="mail" prefix-icon="el-icon-message" auto-complete="off" placeholder="邮箱"></el-input>
        </el-form-item>
          <el-form-item prop="checkCode" label="验证码：">
              <el-input type="text" v-model="registerForm.checkCode" auto-complete="off"  prefix-icon="el-icon-key" placeholder="验证码">
              </el-input>
        </el-form-item>
        <el-form-item>
            <el-button plain style="font-size:14px;width:100%;margin-top:-10px;" @click="sendCode('register')">点击发送验证码</el-button>
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
          <el-button type="primary" style="width: 100%" @click="registerClick">注册</el-button>
     
      </el-form>
    </el-tab-pane>
  </el-tabs>
</template>
<script>
import {validatePhone,validateMail,isEngNumLine} from "@/utils/validate";
const TIME_COUNT = 60
  export default {
    data() {
      return {
        //登录
        loginRules: {
          account: [{required: false, message: '请输入用户名', trigger: 'blur'}],
          checkPass: [{required: false, message: '请输入密码', trigger: 'blur'}],
          checkCode: [{required: false,message: '请输入验证码',trigger: 'blur'}]
        },
        //注册
        registerRules: {
          mail:[{required: true,validator:validateMail,trigger:"blur"}],
          tel:[{required: true,message: '请输入手机号',trigger: 'blur'},{validator:validatePhone,trigger:"blur"}],
          checkCode:[{required: true,message: '请输入验证码',trigger: 'blur'}],
          id: [{ required: true,message: '请输入员工id',trigger: 'blur'},{type:'number',message:'请输入正确的员工ID',trigger:"blur"}],
          key: [{ required: true,message: '请输入用户名',trigger: 'blur'},
                {validator:isEngNumLine,message: '请输入字母数字或下划线',trigger:'blur'}],
          checkPass1: [{ required: true,message: '请输入密码',trigger: 'blur'},{validator:isEngNumLine,trigger:"blur"}],
          checkPass2: [{ required: true,message: '请再次输入密码',trigger: 'blur'},
                       {validator:(rule,value,callback)=>{
                         if(value===''){callback(new Error('请再次输入密码'))}
                         else if(value!==this.registerForm.checkPass1){callback(new Error('两次输入密码不一致'))}
                         else{callback( )}},trigger:'blur'}
                      ],
        },
        //忘记密码
        forgetRules:{
          mail:[{required: true,validator:validateMail,trigger:"blur"}],
          tel:[{required: true,message: '请输入手机号',trigger: 'blur'},{validator:validatePhone,trigger:"blur"}],
          checkCode:[{required: true,message: '请输入验证码',trigger: 'blur'}],
          id: [{ required: true,message: '请输入员工id',trigger: 'blur'},{validator:isEngNumLine,trigger:"blur"}],
          checkPass1: [{ required: true,message: '请输入密码',trigger: 'blur'},{validator:isEngNumLine,trigger:"blur"}],
          checkPass2: [{ required: true,message: '请再次输入密码',trigger: 'blur'},
                       {validator:(rule,value,callback)=>{
                         if(value===''){callback(new Error('请再次输入密码'))}
                         else if(value!==this.registerForm.checkPass1){callback(new Error('两次输入密码不一致'))}
                         else{callback( )}},trigger:'blur'}
                      ],
        },
        checked: true,
        loginForm: {
          key: '',
          password: '',
          vcode: ''
        },
        registerForm:{
          id: '',
          key: '',
          checkPass1: '',
          checkPass2: '',
          tel:'',
          mail:'',
          checkCode:'',
        },
        forgetForm:{
          id: '',
          checkPass1: '',
          checkPass2: '',
          tel:'',
          mail:'',
          checkCode:'',
        },
        loading: false,
        contentWidth: 100,
        contentHeight: 40,
        imgCode: '',
        radio:'1',
        isTel:false,
        isTel1:false,
        diaglogVisible:false,
        forgetRadio:'1',
      }
    },
    created() {
      //this.getIdentifyCode();
    },

    methods: {
      submitClick: function() {
        var _this = this;
        this.loading = true;
        this.axios.post("/user/password/login/operation", {
          key: this.loginForm.key, //this.loginForm.username,
          password: this.loginForm.password, // this.loginForm.password,
          vcode: this.loginForm.vcode
        }).then(response => {
          console.log(response);
          _this.loading = false;
          if (response && response.status == 200) {
            var data = response.data
            _this.$store.commit("login", data.obj);
            var path = _this.$route.query.redirect;
            _this.$router.replace({
              path: path == "/" || path == undefined ? "/about" : path
            })
          }
        })
      },
      changeRadio:function(){
        this.isTel = !this.isTel;
      },
      changeForgetRadio:function(){
        console.log(!this.isTel1);
        this.isTel1 = !this.isTel1;
      },
      sendCode: function(str) {
        let userid='' ;
        let email='';
        let tel=''; 
        let obj;
        let target='';
        if (str==='forget') {//忘记密码
          userid=this.forgetForm.id;
          obj = this.forgetForm;
          if (this.isTel1===true) {
            tel = this.forgetForm.tel;
          }else{
            email = this.forgetForm.mail;
          }
        }else if (str==='register') {//注册
          userid=this.registerForm.id;
          obj = this.registerForm;
          if (this.isTel===true) {
            tel = this.registerForm.tel;
          }else{
            email = this.registerForm.mail;
          }
        }else{
          console.error('Send Code Error!');
        }
        //手机号验证
        if (this.isTel||this.isTel1) {
          this.axios.post("/message/vcode/register",tel).then(resp => {
            console.log(resp.data);
            console.log(resp.data.status)
            if (resp.data && resp.data.status == 200) {
              console.log(resp);
            }
          });
        }else{//邮箱验证
          this.axios.post("user/register/mail/data",{
            id:obj.id,
            mail:mail,
          }).then(resp => {
            console.log("邮箱验证码API测试");
            if (resp.data && resp.data.status == 200) {
              var data = resp.data.obj;
              console.log(resp);
            }
          });
        }
        
      },

      //确认修改
      ChangePassword:function() {
        console.log("checkCode:" + this.forgetForm.checkCode+"\n"+"newPassWord:" + this.forgetForm.checkPass2);
        
        this.diaglogVisible=false;
      },
      Cancel() {
        this.diaglogVisible = false;
      },

      //注册
      registerClick:function(){
        console.log("checkCode:" + this.registerForm.checkCode+"\n"+"newPassWord:" + this.registerForm.checkPass2);
        
      },
      /**
       * 是否刷新，获取验证码图片
       */
      getIdentifyCode: function() {
        this.axios.get("/graph/vcode", {
          responseType: "arraybuffer"
        }).then(response => {
          return 'data:image/png;base64,' + btoa(
            new Uint8Array(response.data).reduce((data, byte) => data + String.fromCharCode(byte), "")
          );
        }).then(data => {
          this.imgCode = data;
          console.log("data:" + data);
        }).catch(ex => {
          console.log(ex);
        })
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
    margin: 150px auto;
    width: 370px;
    padding: 0px 0px 15px 0px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .divIdentifyCode {
    margin-left: 0px;
    width: 100px;
    /*设置图片显示的宽*/
    height: 40px;
    /*图片显示的高*/
    background: #f1f1f1;
    text-align: center;
  }
  .loginForm {
    margin-left: 35px;
    margin-right: 35px;
  }
  .el-tabs__item {
    width: 186px;
    border-radius: 15px 15px 0 0;
  }
</style>