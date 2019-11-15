<template>
    <div class="echarts-box" :id="id" ref="ref">
        hhh</div>
</template>
<script>
    var echarts = require('echarts');
    const axios = require('axios');
    export default {
        name: 'nightingaleChart',
        props: ['options', 'id'],
        data() {
            return {
                op: {
                    backgroundColor: '#ffffff',
                    title: {
                        text: '南丁格尔图',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#666',
                            fontStyle: '' //标题字体
                        }
                    },
                    tooltip: {
                        trigger: 'item'
                    },
                    //视觉映射组件，将数据映射到视觉元素上
                    visualMap: {
                        show: false,
                        min: 10,
                        max: 650,
                        dimension: 0, //选取数据的维度，如人数据：[身高，体重]，则1代表将体重进行映射，默认值为数组的最后一位
                        // seriesIndex: 4, //选取数据集合中的哪个数组，如{一班}，{二班}，默认选取data中的所有数据集
                        inRange: {
                            colorLightness: [0, 1]
                        }
                    },
                    //数据
                    series: [{
                        name: '年龄分布',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        data: [{
                                value: 335,
                                name: '18~20岁'
                            },
                            {
                                value: 310,
                                name: '50~60岁'
                            },
                            {
                                value: 274,
                                name: '40~50岁'
                            },
                            {
                                value: 235,
                                name: '30~40岁'
                            },
                            {
                                value: 400,
                                name: '20~30岁'
                            }
                        ].sort(function(a, b) {
                            return a.value - b.value;
                        }),
                        roseType: 'angle', //角度和半径展现百分比，'area'只用半径展现
                        label: { //饼图图形的文本标签
                            normal: { //下同，normal指在普通情况下样式，而非高亮时样式
                                textStyle: {
                                    color: 'rgba(100, 100, 100, 1)'
                                }
                            }
                        },
                        labelLine: { //引导线样式
                            normal: {
                                lineStyle: {
                                    color: 'rgba(100, 100, 100, 1)'
                                },
                            }
                        },
                        itemStyle: {
                            normal: {
                                color: '#f1fdff'
                            },
                            emphasis: {
                                shadowBlur: 200,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        },
                        animationType: 'scale', //初始动画效果，scale是缩放，expansion是展开
                        animationEasing: 'elasticOut', //初始动画缓动效果
                        animationDelay: function(idx) { //数据更新动画时长，idx限定了每个数据块从无到有的速度
                            return Math.random() * 200;
                        }
                    }]
                }
            }
        },
        mounted: function() {
            this.drawNightingale();
        },
        created: function() {
            axios.get('json/data.json').then(res => {
                const data = res.data;
                this.goods = data
                console.log(this.goods);
                console.log(Array.from(this.goods.xAxis.data));
            })
        },
        methods: {
            drawNightingale: function() {
                let nightingaleCHart = echarts.init(this.$refs['ref']);
                nightingaleCHart.setOption(this.op);
                nightingaleCHart.showLoading();
                axios.get("json/data.json").then((resp) => {
                    setTimeout(() => {
                        let data = resp.data;
                        let list = data.series.map(good => {
                            let list = good.data;
                            console.log("折线图：");
                            console.log(...list);
                            return [...list];
                        });
                        console.log(Array.from(...list));
                        nightingaleCHart.hideLoading();
                        nightingaleCHart.setOption({
                            title: data.title,
                            series: [{
                               // data: Array.from(...list)
                            }]
                        });
                    }, 3000);
                });
            }
        }
    }
</script>
<style scoped>
    .echarts-box {
        width: 100%;
        height: 400px;
    }
</style>