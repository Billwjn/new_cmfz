<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
    $(function(){
        $("#albumTable").jqGrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            datatype:"json",
            colNames:["专辑编号","专辑名称","专辑封面","音频数量","专辑得分","作者","播音员","专辑简介","发布时间"],
            colModel:[
                {"name":"id"},
                {"name":"title"},
                {"name":"cover"},
                {"name":"count"},
                {"name":"score"},
                {"name":"author"},
                {"name":"broadcast"},
                {"name":"brief"},
                {"name":"publishTime"}
                ]
        })
    })
</script>
<div class="page-header">
    <h1>专辑管理</h1>
</div>
<table id="albumTable"></table>
<div id="albumPager"></div>
