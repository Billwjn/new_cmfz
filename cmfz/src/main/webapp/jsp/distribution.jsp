<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('distribution'));
    $.ajax({
        url:'${pageContext.request.contextPath}/user/queryDistribution',
        type:'post',
        datatype:'json',
        success:function(data){
            var option = {
                title : {
                    text: '全国注册用户分布图',
                    left: 'center'
                },
                tooltip : {
                    trigger: 'item'
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data:['男','女']
                },
                visualMap: {
                    min: 0,
                    max: 20,
                    left: 'left',
                    top: 'bottom',
                    text:['高','低'],           // 文本，默认为数值文本
                    calculable : true
                },
                toolbox: {
                    show: true,
                    orient : 'vertical',
                    left: 'right',
                    top: 'center',
                    feature : {
                        mark : {show: true},
                        dataView : {show: true, readOnly: false},
                        restore : {show: true},
                        saveAsImage : {show: true}
                    }
                },
                series : [
                    {
                        name: '背景',
                        type: 'map',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: true
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:[
                            {name: '北京',value: Math.round(0)},
                            {name: '天津',value: Math.round(0)},
                            {name: '上海',value: Math.round(0)},
                            {name: '重庆',value: Math.round(0)},
                            {name: '河北',value: Math.round(0)},
                            {name: '河南',value: Math.round(0)},
                            {name: '云南',value: Math.round(0)},
                            {name: '辽宁',value: Math.round(0)},
                            {name: '黑龙江',value: Math.round(0)},
                            {name: '湖南',value: Math.round(0)},
                            {name: '安徽',value: Math.round(0)},
                            {name: '山东',value: Math.round(0)},
                            {name: '新疆',value: Math.round(0)},
                            {name: '江苏',value: Math.round(0)},
                            {name: '浙江',value: Math.round(0)},
                            {name: '江西',value: Math.round(0)},
                            {name: '湖北',value: Math.round(0)},
                            {name: '广西',value: Math.round(0)},
                            {name: '甘肃',value: Math.round(0)},
                            {name: '山西',value: Math.round(0)},
                            {name: '内蒙古',value: Math.round(0)},
                            {name: '陕西',value: Math.round(0)},
                            {name: '吉林',value: Math.round(0)},
                            {name: '福建',value: Math.round(0)},
                            {name: '贵州',value: Math.round(0)},
                            {name: '广东',value: Math.round(0)},
                            {name: '青海',value: Math.round(0)},
                            {name: '西藏',value: Math.round(0)},
                            {name: '四川',value: Math.round(0)},
                            {name: '宁夏',value: Math.round(0)},
                            {name: '海南',value: Math.round(0)},
                            {name: '台湾',value: Math.round(0)},
                            {name: '香港',value: Math.round(0)},
                            {name: '澳门',value: Math.round(0)}
                        ]
                    },
                    {
                        name: '男',
                        type: 'map',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data.man
                    },
                    {
                        name: '女',
                        type: 'map',
                        mapType: 'china',
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true
                            }
                        },
                        data:data.woman
                    }
                ]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    })

</script>

<h1 class="page-header">
    全国注册用户分布图
</h1>
<body>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="distribution" style="width: 1200px;height:600px;"></div>
</body>