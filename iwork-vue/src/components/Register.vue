<template>
    <div class="register">
        <el-form :rules="registerRules" :model="registerForm" ref="registerRef" class="loginForm" label-position="right" label-width="100px" v-loading="loading">
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
            <el-button plain style="font-size:14px;width:100%;margin-top:-10px;" @click="sendCode('register')" :disabled="regDisCodeBtn">{{btntxt}}</el-button>
        </el-form-item>
        <el-form-item prop="id" label="员工ID：">
          <el-input type="text" v-model="registerForm.id" prefix-icon="el-icon-bank-card" auto-complete="off" placeholder="员工ID"></el-input>
        </el-form-item>

        <el-form-item prop="checkPass1" label="密码：">
          <el-input type="password" v-model="registerForm.checkPass1" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="新密码"></el-input>
        </el-form-item>
        <el-form-item prop="checkPass2" label="确认密码：">
          <el-input type="password" v-model="registerForm.checkPass2" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="确认新密码"></el-input>
        </el-form-item>
          <el-button type="primary" style="width: 100%" @click="registerClick">注册</el-button>
     
      </el-form>
    </div>
</template>

<script>
import {validatePhone,validateMail,isEngNumLine} from "@/utils/validate";
export default {
    name:'Register',
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
            isTel:false,
            radio:'1',
            regDisCodeBtn:false,
            loading:false,
            btntxt:'获取验证码',
            time:60,
        }
    },
    methods:{
        changeRadio:function(){//切换手机邮箱输入
            this.isTel = !this.isTel;
        },
        sendCode: function(str) {
            this.time = 60;
            this.regDisCodeBtn = true;
            let datas={
                phone:this.registerForm.tel
            }
            this.timer();
            //手机号验证
            this.$message({message:"点击成功",type:"success"})
            if (this.isTel) {
                this.axios.post("/message/vcode/register",datas).then(resp => {
                    if (resp.data && resp.data.result == true) {
                      console.log("手机验证码API测试"+resp);
                    }else{
                      this.$message({message:"发送失败",type:"error"})
                    }
                });
            }else{//邮箱验证
                datas={mail:this.registerForm.mail}
                this.axios.post("/mail/vcode/register",datas).then(resp => {
                    if (resp.data && resp.data.result == true) {
                    var data = resp.data.obj;
                    console.log("邮箱验证码API测试"+resp);
                    //this.timer();
                    }else{
                    }
                });
            }
        },
      //注册
      registerClick:function(){
        console.log("checkCode:" + this.registerForm.checkCode+"\n"+"newPassWord:" + this.registerForm.checkPass2);
        this.$refs.registerRef.validate(async valid=>{
          if (valid) {
            console.log("注册表单验证测试成功！");
            const res2 = await this.axios.post("",{
              workId:this.registerForm.id,
              password:this.registerForm.checkPass2,
              vcode:this.registerForm.checkCode,
              phone:this.registerForm.tel,
              mail:this.registerForm.mail
            }).then(resp=>{
              if (resp.data && resp.data.result == true) {
                  var data = resp.data.obj;
                  console.log(resp);
                }
            });
            if (res2.data.error == 0) {
              this.$message.success(res2.data.message);
            }
          }else{
            console.log("请按正确格式填写");
          }
        })
      },
       //发送验证码倒计时
      timer:function() {
        if (this.time > 0) {
              this.time--;
              this.btntxt="("+this.time+")s 后重新获取";
              setTimeout(this.timer, 1000);
        } else{
              this.time=0;
              this.btntxt="获取验证码";
              this.disabled=false;
              this.forDisCodeBtn = false;
        }
      },
    }
}
</script>