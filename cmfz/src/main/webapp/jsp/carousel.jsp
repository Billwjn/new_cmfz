<%@page contentType="text/html; UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<script>
    $(function(){
        $("#carouselTable").jqGrid({
            url:"${pageContext.request.contextPath}/carousel/queryAll",
            datatype:"json",
            styleUI:"Bootstrap",
            colNames:["编号","名称","图片","描述","状态","创建时间"],
            colModel:[
                {"name":"carouselId", editable:true},
                {"name":"name",editable:true},
                {"name":"imgPath",formatter:function(cellvalue, options, rowObject){
                        return "<img style='width:50px;height:50px' src='${pageContext.request.contextPath}/upload/"+cellvalue+"'/>"
                    },editable:true,edittype:"file"},
                {"name":"description",editable:true},
                {"name":"status",editable:true,edittype:"select",editoptions: {value:'on:正在展示;off:不展示'}},
                {"name":"createTime",editable:true,edittype:"date"}],
            autowidth:true,
            multiselect:true,
            pager:"#carouselPager",
            rowNum:3,
            height:300,
            rowList:[3,5,7],
            viewrecords:true,
            rownumbers:true,
            editurl:"${pageContext.request.contextPath}/carousel/edit"
        }).jqGrid('navGrid','#carouselPager',{},{
            closeAfterEdit:true,
        },{
            //添加方法
            closeAfterAdd:true,
            afterSubmit:function(response){
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/carousel/upload",
                    type:"post",
                    fileElementId:"imgPath",
                    data:{"id":response.responseText},
                    success:function(){
                        $("#carouselTable").trigger("reloadGrid")
                    }
                })
                return "hello";
            }
        })
    })
</script>
<div class="page-header">
    <h1>轮播图管理</h1>
</div>
<table id="carouselTable"></table>
<div id="carouselPager"></div>