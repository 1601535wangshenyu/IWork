<template>
  <el-tabs type="border-card" class="login-container" strech="true" >
  <el-tab-pane label="登录" style="">
  <el-form :rules="rules" class="loginForm"  label-position="left" label-width="0px" v-loading="loading">
    <h3 class="login_title">登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="loginForm.key" prefix-icon="el-icon-user" auto-complete="off" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="loginForm.password" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-form-item prop="checkCode">
      <el-row>
        <el-col :span="8">
          <el-input type="text" v-model="loginForm.vcode" auto-complete="off" prefix-icon="el-icon-key" style="width:180px" placeholder="验证码">
          </el-input>
        </el-col>
        <el-col :span="2" :offset="2">
          <div class="divIdentifyCode" @click="getIdentifyCode">
            <!-- <SIdentify :identifyCode="identifyCode"></SIdentify> -->
            <img :src="imgCode" id="imgCode">
          </div>
        </el-col>
      </el-row>
    </el-form-item>
    <el-form-item style="width: 100%">
      <el-button type="primary" style="width: 100%" @click="submitClick">登录</el-button>
    </el-form-item>

    <!-- 忘记密码+注册 -->
    <el-button type="text" @click="forgetPass" >忘记密码</el-button>

    <el-dialog></el-dialog>
  </el-form>
  </el-tab-pane>
  <el-tab-pane label="注册"></el-tab-pane>
  </el-tabs>
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
          }],
          checkCode:[{
            required:false,
            message:'请输入验证码',
            trigger:'blur'
          }]
        },
        checked: true,
        loginForm: {
          key: '',
          password: '',
          vcode:''
        },
        identifyCode: "",
        identifyCodes: [],
        loading: false,
        randomNum: function() {},
        contentWidth: 100,
        contentHeight: 40,
        imgCode:'url'
      }
    },
    created(){
      this.getIdentifyCode();
    },
    methods: {
      submitClick: function() {
        var _this = this;
       // console.log(_this);
        console.log("click");
        // var path = _this.$route.query.redirect;
        // this.$router.replace({path:"/home"});//56-58行：测试
        this.loading = true;
        this.axios.post("/user/password/login/operation", {
          key:"admin",//this.loginForm.username,
          password:"123",// this.loginForm.password,
          vcode:"1234"
        }).then(response => {
          console.log(response);
          _this.loading = false;
          if (resp && resp.status == 200) {
            var data = response.data
            _this.$store.commit("login", data.obj);
            // var roleId = data.roleInfos[0].roleId
            // this.$store.state.user.userId = data.userId
            // this.$store.state.user.username = data.username
            // this.$store.state.user.cname = data.cname
            // this.$store.state.user.roleId = data.roleInfos[0].roleId
            // this.$store.state.user.roleName = data.roleInfos[0].roleDesc
            // this.$store.state.user.roleDepart = data.roleDepart
            // this.initRoutesStore(data.roleInfos[0].sysFuns)
            // 当前登录用户的第一个子地址
            // var firstSubUri = data.roleInfos[0].sysFuns[0].subSysFunList[0].nodeURL;
            var path = _this.$route.query.redirect;
            _this.$router.replace({
              path: path == "/" || path == undefined ? "/home" : path
            })
            //管理员端：
            // if (this.$store.state.user.roleId === 1) {
            //   _this.$router.replace({
            //     path: path == "/" || path == undefined ? "/schedule/note" : path
            //   })
            // }
            // //普通用户端
            // else if (this.$store.state.user.roleId === 2) {
            //   _this.$router.replace({
            //     path: path == "/" || path == undefined ? "/attendence/staff" : path
            //   })
            // }
            // // 其他的用户
            // else {
            //   _this.$router.replace({
            //     path: path == "/" || path == undefined ? firstSubUri : path
            //   })
            // }
          }
        })
      },
      /**
       * 是否刷新
       */

      getIdentifyCode: function() {
        // this.identifyCode = "";
        // this.makeCode(this.identifyCodes, 4);
        // console.log("验证码：" + this.identifyCodes);
        // var num = Math.ceil(Math.random()*10);
        // this.imgCode = 'url'+num;
        this.axios.get("/graph/vcode",{
        responseType:"arraybuffer"
        }).then(response=>{
          return 'data:image/png;base64,'+btoa(
            new Uint8Array(response.data).reduce((data,byte)=>data+String.fromCharCode(byte),"")
          );
        // console.log("created:")
        // let data = response.data;
        // console.log(data);
        // this.imgCode="";
        // this.imgCode=this.imgCode+data;
      }).then(data=>{
        this.imgCode = data;
        console.log("data:"+data);
      }).catch(ex=>{
        console.log(ex);
      })
      },
        makeCode(o, l) {
          for (let index = 0; index < l; index++) {
            console.log("makeCode():this.identifyCode.length:" + this.identifyCodes.length)
            this.identifyCode += this.identifyCodes[this.randomNum(0, this.identifyCodes.length)];
          }
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
    margin-left: 74px;
    width: 100px;
    /*设置图片显示的宽*/
    height: 40px;
    /*图片显示的高*/
    background: #f1f1f1;
    text-align: center;
  }
  .loginForm{
    margin-left: 35px;
    margin-right: 35px;
  }
  
  .el-tabs_item{
    width: 180px;
  }
</style>