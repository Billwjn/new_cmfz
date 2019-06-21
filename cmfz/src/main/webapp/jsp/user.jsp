<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<script>
    function clickExport(){
        location.href="${pageContext.request.contextPath}/user/export"
    }
    $(function(){

        $("#userTable").jqGrid({
            url:"${pageContext.request.contextPath}/user/queryAll",
            datatype:"json",
            colNames:["用户编号","电话","用户名","省","市","性别","头像","状态","注册时间"],
            colModel:[
                {name:"id"},
                {name:"phone"},
                {name:"username"},
                {name:"province"},
                {name:"city"},
                {name:"gender"},
                {name:"profile"},
                {name:"status"},
                {name:"registTime"}
            ],
            pager:"userPager",
            rowNum:3,
            rowList:[3,5,7],
            viewrecords:true,
            autowidth:true,
            height:"100%",
            multiselect:true,
            rownumbers:true,
            styleUI:"Bootstrap"
        })
    })

</script>
<h1 class="page-header">
    用户展示
</h1>
<div>
    <button class="btn btn-default" style="margin-bottom: 10px" onclick="clickExport()">一键导出</button>
</div>
<table id="userTable"></table>
<div id="userPager"></div>