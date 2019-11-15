<!--折线图组件-->
<template>
    <div id="lineChart" style="width: 100%;height: 400px;">
    </div>
</template>
<script>
    let echarts = require('echarts');
    const axios = require('axios').create({
        baseURL: '',
        timeout: 5000,
        headers: {
            'Content-type': 'multipart/form-data'
        }
    });
    export default {
        name: "lineChart",
        props: ['options', 'id'],
        data() {
            return {
                msg: 'BarChart',
                goods: {},
                option: {
                    legend: {data:[]},
                    xAxis: {
                        type: 'category',
                        data: [],
                        name: '',
                        nameTextStyle: {
                            fontWeight: 600,
                            fontSize: 18
                        }
                    },
                    yAxis: {
                        type:'value',
                        name:'',
                        nameTextStyle: {
                            fontWeight: 600,
                            fontSize: 18
                        }
                    },
                    label: {},
                    tooltip: {trigger:'item'},
                    series: [{name:'',data:[],type:'line'}]
                }
            }
        },
        mounted() {
            this.drawLine();
        },
        created() {
            axios.get('json/data.json').then(res => {
                const data = res.data;
                this.goods = data
                console.log(this.goods);
                console.log(Array.from(this.goods.xAxis.data));
            })
        },
        methods: {
            drawLine: function() {
                // 基于准备好的dom，初始化echarts实例
                let lineChart = echarts.init(document.getElementById('lineChart'));
                lineChart.setOption(this.option);
                axios.get("json/data.json").then((resp)=>{
                    setTimeout(()=>{
                        let data = resp.data;
                        let list = data.series.map(good =>{
                            let list = good.data;
                            console.log("折线图：");
                            console.log(...list);
                            return [...list];
                        });
                        console.log(Array.from(...list));
                        lineChart.hideLoading();
                        lineChart.setOption({
                            title:data.title,
                            xAxis:[{data:data.xAxis.data}],
                            series:[{
                                data:Array.from(...list)
                            }]
                        });
                    },3000);
                });
            }
        }
    }
</script>