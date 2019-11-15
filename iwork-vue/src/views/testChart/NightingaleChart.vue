<template>
    <div class="echarts-box" :id="id" ref="ref">
        hhh</div>
</template>
<script>
    var echarts = require('echarts');
    export default {
        name:'nightingaleChart',
        props: ['options', 'id'],
        data() {
            return {
                op: {
                    //需要的话下面内容copy到主体代码块即可
                    backgroundColor: '#ffffff',
                    //标题
                    title: {
                        text: '员工年龄分布',
                        left: 'center',
                        top: 20,
                        textStyle: {
                            color: '#666',
                            fontStyle: '' //标题字体
                        }
                    },
                    // //图例，选择要显示的项目
                    // legend: {
                    //     orient: 'vertical',
                    //     left: 'left',
                    //     data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎'] //注意要和数据的name相对应
                    // },
                    
                    //视觉映射组件，将数据映射到视觉元素上
                    visualMap: {
                        show: false,
                        min: 10,
                        max: 650,
                        dimension: 0, //选取数据的维度，如人数据：[身高，体重]，则1代表将体重进行映射，默认值为数组的最后一位
                        // seriesIndex: 4, //选取数据集合中的哪个数组，如{一班}，{二班}，默认选取data中的所有数据集
                        inRange: {
                            //选定了要映射的对象，用inRange详细写要渲染的具体细节，[x，y]中x指最小值对应的量（亮度，饱和度等），y指最大值对应的量，其余的按各自value线性渲染
                            
                            colorLightness: [0, 1]
                        }
                    },
                    //数据
                    series: [{
                        name: '年龄分布',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '50%'],
                        formatter: '{d}%',
                        data: [
                            {value: 335, name: '18~20岁'},
                            {value: 310,name: '50~60岁'},
                            {value: 274,name: '40~50岁'},
                            {value: 235,name: '30~40岁'},
                            {value: 400,name: '20~30岁'}
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
                        itemStyle: { //图例样式
                            normal: {
                                color: '#f1fdff',
                                shadowBlur: 200, //阴影模糊程度
                                shadowColor: 'rgba(0, 0, 0, 0.5)' //阴影颜色，一般黑
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
            console.log("echarts")
            let myChart = echarts.init(this.$refs['ref']);
            myChart.setOption(this.op);
        }
    }
</script>
<style scoped>
    .echarts-box {
        width: 100%;
        height: 400px;
    }
</style>