<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script>
    $(function(){
        $("#albumTable").jqGrid({
            url:"${pageContext.request.contextPath}/album/queryAll",
            datatype:"json",
            styleUI:"Bootstrap",
            rowNum:3,
            colNames:["专辑编号","专辑名称","专辑封面","音频数量","专辑得分","作者","播音员","专辑简介","发布时间"],
            colModel:[
                {name:"id"},
                {name:"title",editable:true},
                {name:"cover",editable:true,edittype:"file",formatter:function(cellvalue, options, rowObject){
                    return "<img style='width:50px;height:50px' src='${pageContext.request.contextPath}/upload/"+cellvalue+"'/>"
                    }},
                {name:"count"},
                {name:"score",editable:true},
                {name:"author",editable:true},
                {name:"broadcast",editable:true},
                {name:"brief",editable:true},
                {name:"publishTime",editable:true,edittype:"date"}
                ],
            pager:"#albumPager",
            rowList:[3,5,7],
            viewrecords:true,
            autowidth:true,
            editurl:"${pageContext.request.contextPath}/album/edit",
            height:"100%",
            multiselect:true,
            subGrid:true,
            subGridRowExpanded:function(subgrid_id, row_id) {
                var subgrid_table_id, pager_id;
                subgrid_table_id = subgrid_id + "_t";
                pager_id = "p_" + subgrid_table_id;
                $("#" + subgrid_id).html(
                    "<table id='" + subgrid_table_id
                    + "' class='scroll'></table><div id='"
                    + pager_id + "' class='scroll'></div>");
                jQuery("#" + subgrid_table_id).jqGrid(
                    {
                        url : "${pageContext.request.contextPath}/chapter/queryAll?albumId="+row_id,
                        datatype : "json",
                        styleUI:"Bootstrap",
                        colNames : ["章节编号","专辑","标题","大小","下载路径","上传时间"],
                        colModel : [
                            {name:"id"},
                            {name:"albumId",editable:true},
                            {name:"title",editable:true},
                            {name:"size",editable:true},
                            {name:"downPath",editable:true,edittype:"file"},
                            {name:"uploadTime",editable:true,edittype:"date"}
                        ],
                        rowNum : 3,
                        pager : pager_id,
                        height : '100%',
                        rowList:[3,5,7],
                        viewrecords:true,
                        autowidth:true,
                        editurl:"${pageContext.request.contextPath}/chapter/edit",
                        multiselect:true
                    }).jqGrid('navGrid', '#'+pager_id, {},{
                        closeAfterEdit: true,
                        beforeShowForm:function(){
                            $("#albumId").attr("readonly",true);
                        },
                },{
                        closeAfterAdd: true,
                        beforeShowForm:function(){
                            $("#albumId").val(row_id)
                            $("#albumId").attr("readonly",true);
                        },
                        afterSubmit:function(response){
                            $.ajaxFileUpload({
                                url:"${pageContext.request.contextPath}/chapter/upload",
                                fileElementId:"downPath",
                                type:"post",
                                data:{id:response.responseText},
                                success:function(){
                                    $("#albumTable").trigger("reloadGrid");
                                }
                            })
                            return [true];
                        }
                });
            },
        }).jqGrid('navGrid', '#albumPager', {},{
            closeAfterEdit:true,
        },{
            closeAfterAdd:true,
            afterSubmit:function (response) {
                $.ajaxFileUpload({
                    url:"${pageContext.request.contextPath}/album/upload",
                    fileElementId:"cover",
                    type:"post",
                    data:{id:response.responseText},
                    success:function(){
                        $("#albumTable").trigger("reloadGrid");
                    }
                })
                return [true];
            }
        })
    })
</script>
<div class="page-header">
    <h1>专辑管理</h1>
</div>
<table id="albumTable"></table>
<div id="albumPager"></div>
<table id="chapterTable"></table>
<div id="chapterPager"></div>
