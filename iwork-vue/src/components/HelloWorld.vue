<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <h2>跨域请求天气</h2>
    <ul v-for="item in data" :key="item.id">
      <li>{{item}}</li>
    </ul>
  </div>
</template>

<script>
//引入axios
import axios from "axios";
export default {
  name: "HelloWorld",
  data() {
    return {
      msg: "请求成功",
      data: null
    };
  },
  created() {
    //创建实例时设置配置的默认值
    const httpHandler = axios.create({
      headers: { "Content-Type": "application/json;charset=utf-8" }, //即将被发送的自定义请求头
      withCredentials: true //表示跨域请求时是否需要使用凭证


  });
   let uri = "apis/weather/city/101030100"; 
   httpHandler .get(uri) .then(result => { console.log(result); this.data = result; }) .catch(error => { console.error(error); }); } }; 
   </script>