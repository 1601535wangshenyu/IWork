<template>
    <div class="ForgetPassword">
        <el-form class="loginForm" :model="forgetForm" ref="forgetRef" :rules="forgetRules" label-position="left" label-width="100px" v-loading="loading">
          <el-radio-group v-model="forgetRadio" @change="changeForgetRadio" style="margin-bottom: 30px;">
            <el-radio-button :label="1" >邮箱验证</el-radio-button>
            <el-radio-button :label="2" >手机验证</el-radio-button>
          </el-radio-group>
          <el-form-item prop="id" label="员工ID：">
            <el-input type="text" v-model="forgetForm.id" prefix-icon="el-icon-bank-card" auto-complete="off" placeholder="员工ID"></el-input>
          </el-form-item>
          <el-form-item prop="tel" label="手机：" v-if="isTel" >
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
              <el-button plain style="font-size:14px;width:100%;margin-top:-10px;" @click="sendCode('forget')" :disabled="forDisCodeBtn">{{btntxt}}</el-button>
          </el-form-item>
          <el-form-item prop="checkPass1" label="新密码：">
            <el-input type="password" v-model="forgetForm.checkPass1" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="新密码"></el-input>
          </el-form-item>
          <el-form-item prop="checkPass2" label="确认密码：">
            <el-input type="password" v-model="forgetForm.checkPass2" prefix-icon="el-icon-unlock" auto-complete="off" placeholder="确认新密码"></el-input>
          </el-form-item>
          <el-button type="primary" @click="ForgetClick">确认</el-button>
          <el-button  @click="Cancel">取消</el-button>
        </el-form>
    </div>
</template>
<script>
import {validatePhone,validateMail,isEngNumLine} from "@/utils/validate";
export default {
    name:'ForgetPassword',
    props:['btntxt'],
    data(){
        return{
            forgetForm:{
                id: '',
                checkPass1: '',
                checkPass2: '',
                tel:'',
                mail:'',
                checkCode:'',
            },
            radio:'1',
            isTel:false,
            diaglogVisible:false,
            forgetRadio:'1',
            forDisCodeBtn:false,
            loading:false,
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
        }
        
    },
    methods:{
        changeForgetRadio:function(){
        console.log(!this.isTel);
        this.isTel = !this.isTel;
      },
      sendCode: function(str) {
        this.forDisCodeBtn = true;
        let datas={phone:this.forgetForm.tel};
        //手机号验证
        this.$emit("startTimer");
        if (this.isTel) {
          this.axios.post("/message/vcode/register",datas).then(resp => {
            if (resp.data && resp.data.result == true) {
              console.log("手机验证码API测试"+resp);
            }else{
            }
          });
        }else{//邮箱验证
          datas={mail:this.forgetForm.mail}
          this.axios.post("/mail/vcode/register",datas).then(resp => {
            if (resp.data && resp.data.result == true) {
              var data = resp.data.obj;
              console.log("邮箱验证码API测试"+resp);
            }else{
            }
          });
        }
        
      },

      //确认修改
      ForgetClick:function() {
        console.log("checkCode:" + this.forgetForm.checkCode+"\n"+"newPassWord:" + this.forgetForm.checkPass2);
        this.$refs.forgetRef.validate(async valid=>{
          if (valid) {
            console.log("忘记密码表单验证测试成功！")
            const res = await this.axios.post("",{
              workId:this.forgetForm.id,
              password:this.forgetForm.checkPass2,
              vcode:this.forgetForm.checkCode,
              phone:this.forgetForm.tel,
              mail:this.forgetForm.mail
            }).then(resp=>{
              if (resp.data && resp.data.result == true) {
                  var data = resp.data.obj;
                  console.log(resp);
              }else{
              }
            });
            if (res.data.error == 0) {
              this.$message.success(res.data.message);
            }
          }else{
            console.log("请按正确格式填写");
          }
        });
        this.$emit("changeDialog",false);
      },
      Cancel() {
        this.$emit("changeDialog",false);
      },
    }
}
</script>