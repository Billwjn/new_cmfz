<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<script>
    $(function(){
        $("#albumTable").jqGrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            datatype:"json",
            height:400,
            colNames:["编号","名称","封面","数目","得分","作者","播音员","简介","发布时间"],
            colModel:[
                {name:"id"},
                {name:"title",editable:true},
                {name:"cover",editable:true,edittype:"file",formatter:function(cellvalue){
                        return "<img style='width:100px;height:80px' src='${pageContext.request.contextPath}/upload/"+cellvalue+"'/>";
                    }},
                {name:"count",editable:true},
                {name:"score",editable:true},
                {name:"author",editable:true},
                {name:"broadcast",editable:true},
                {name:"brief",editable:true},
                {name:"publishTime",editable:true,edittype:"date"}
            ],
            pager:"#albumPager",
            rowNum:3,
            rowList:[3,5,7],
            viewrecords:true,
            autowidth:true,
            editurl:"${pageContext.request.contextPath}/album/edit",
            multiselect:true,
            page:1,
            rownumbers:true,
            styleUI:"Bootstrap",
        }).jqGrid("navGrid","#albumPager",{edit:true},{
            closeAfterEdit:true,
            beforeShowForm:function(obj){
                console.log(obj)
                obj.find("#cover").attr("disabled",true);
                obj.find("#publishTime").attr("readonly",true);
            }
        },{
            closeAfterAdd:true,
            afterSubmit:function(response){
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/album/upload",
                    type: "post",
                    fileElementId: "cover",
                    data:{id:response.responseText},
                    success:function(){
                        $("#albumTable").trigger("reloadGrid")
                    }
                })
                return "hello";
            }
        })
    })
</script>
<div class="page-header">
    <h2>专辑管理</h2>
</div>
<table id="albumTable"></table>
<div id="albumPager"></div>