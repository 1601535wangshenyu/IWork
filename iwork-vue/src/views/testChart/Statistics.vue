<!--统计图测试文件-->
<template>
<el-col>
  <el-row>
    <el-col :span="12">
      <v-echarts id="echart1" :options='echartsOptions1' ></v-echarts>
    </el-col>
    <el-col :span="12">
      <bar-chart id="echart2" :options='echartsOptions2'></bar-chart>
    </el-col>
  </el-row>
  <el-row>
    <el-col :span="12">
      <line-chart id="echart3"></line-chart>
    </el-col>
  </el-row>
</el-col>
</template>
 
<script>
import vEcharts from '@/views/testChart/NightingaleChart'
import barChart from '@/views/testChart/BarChart'
import lineChart from '@/views/testChart/LineChart'
export default {
  components:{ 
    vEcharts ,
    barChart,
    lineChart
  },
  data () {
    return {
      dateTime: '',
      searchStatus: false,
      echartsOptions1: {
      },
      echartsOptions2: {}
    }
  },
  created() {
    //this.getData();
  },
  methods: {

    // getData() {
    //   const params = { dateTime: this.DateTime };
    //   this.searchStatus = true;
    //   fetch.getData(params).then(res =>{
    //     if(res.code == 200){
    //       this.searchStatus = false;
    //       this.echartsOptions1 = { ...设置相关参数 };
    //       this.echartsOptions2 = { ...设置相关参数 };
    //     }
    //   })
    // }, 
    // search() { 
    //   this.searchStatus = true;
    //   this.echartsOptions1 = {};
    //   this.echartsOptions2 = {};
    //   this.getData();
    // }
  }
}
</script>
 
<style >
</style>