<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
    $(function(){
        $("#albumTable").jqGrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            datatype:"json",
            colNames:[]
        })
    })
</script>
<div class="page-header">
    <h1>专辑管理</h1>
</div>
<table id="albumTable"></table>
<div id="albumPager"></div>
