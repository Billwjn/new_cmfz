<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: 'BC-82da440207614095b697816ca3ef5935'
    });
    $(function(){
        $.ajax({
            url:"${pageContext.request.contextPath}/user/queryStatistics",
            type:"post",
            success:function(){

            }
        })
    })
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    goEasy.subscribe({
        channel:'demo_channel',
        onMessage: function(message){
            var obj = message.content;
            var data = JSON.parse(obj);
            var option = {
                tooltip: {},
                legend: {
                    data:['注册人数']
                },
                xAxis: {
                    data: data.months
                },
                yAxis: {},
                series: [{
                    name: '注册人数',
                    type: 'bar',
                    data: data.counts
                }]
            };
            // 使用刚指定的配置项和数据显示图表。
            myChart.setOption(option);
        }
    });

</script>
<h1 class="page-header">
    每月注册用户统计图
</h1>
<body>
    <!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
    <div id="main" style="width: 1200px;height:600px;"></div>
</body>