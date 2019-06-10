<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#carouselTable").jqGrid({
            url:"${pageContext.request.contextPath}/carousel/queryAll",
            datatype:"json",
            autowidth:true,
            multiselect:true,
            editurl:"${pageContext.request.contextPath}/carousel/edit",
            colNames:["编号","名称","描述","状态","日期","预览"],
            colModel:[
                {name:"id"},
                {name:"name",editable:true},
                {name:"description",editable:true},
                {name:"status",editable:true},
                {name:"createTime",editable:true,edittype:"date"},
                {name:"imgPath",editable:true , edittype:"file",formatter:function(cellvalue){
                    console.log(cellvalue)
                        return "<img style='width:100px;height:80px' src='${pageContext.request.contextPath}/upload/"+cellvalue+"'/>"
                    }}
            ],
            pager:"#carouselPager",
            rowNum:3,
            rowList:[3,5,7],
            viewrecords:true,
            page:1,
            rownumbers:true,
            styleUI:"Bootstrap",
        }).jqGrid("navGrid","#carouselPager",{edit:true},{
            closeAfterEdit:true,
            beforeShowForm:function (obj) {
                obj.find("#createTime").attr("readonly",true)
                obj.find("#imgPath").attr("disabled",true)
            }
        },{
            closeAfterAdd:true,
            afterSubmit:function (response) {
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/carousel/upload",
                    type:"post",
                    fileElementId:"imgPath",
                    data:{id:response.responseText},
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
    <h2>轮播图管理</h2>
</div>
<table id="carouselTable"></table>
<div id="carouselPager"></div>

