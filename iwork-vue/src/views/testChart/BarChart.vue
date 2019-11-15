<!--柱状图组件-->
<template>
    <div id="myChart" style="width: 100%;height: 400px;">
    </div>
</template>

<script>
    var echarts = require('echarts');
    const axios = require('axios').create({
                        baseURL: '',
                        timeout: 5000,
                        headers: {'Content-type': 'multipart/form-data'}
                    });

    export default {
        name: 'barChart',
        props: ['options', 'id'],
        data() {
            return {
                msg: 'BarChart',
                goods: {}
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
            drawLine() {
                // 基于准备好的dom，初始化echarts实例
                let myChart = echarts.init(document.getElementById('myChart'))
                // 绘制图表
                myChart.setOption({
                    title: {}, //{text: '异步数据加载示例'},
                    tooltip: {},
                    xAxis: {
                        data: [] //横坐标数据
                    },
                    yAxis: {},
                    series: [{
                        name: '销量',
                        type: 'bar',
                        data: [] //纵坐标数据
                    }]
                });
                //显示加载动画
                myChart.showLoading();
                axios.get("json/data.json").then((res) => {
                    setTimeout(() => { //未来让加载动画效果明显,这里加入了setTimeout,实现3s延时
                        const data = res.data;
                        const list = data.series.map(good => {
                            let list = good.data;
                            console.log(...list);
                            return [...list]
                        })
                        console.log(list);
                        console.log(Array.from(...list));
                        myChart.hideLoading(); //隐藏加载动画
                        myChart.setOption({
                            title: data.title,
                            xAxis: [{
                                data: data.xAxis.data
                            }],
                            series: [{
                                name: '销量',
                                type: 'bar',
                                data: Array.from(...list) //[5, 20, 36, 10, 10, 20]
                            }]
                        });
                    }, 3000)
                })
            }
        }
    }
</script>