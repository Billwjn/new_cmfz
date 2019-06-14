<%@page contentType="text/html; utf-8" pageEncoding="UTF-8" isELIgnored="false"%>
<script charset="utf-8" src="../kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
<h1 class="page-header">
    文章管理
</h1>

<script>

    $(function(){
        KindEditor.create('#editor_id',{
            width:'700px',
            uploadJson:'${pageContext.request.contextPath}/kindeditor/upload',
            fileManagerJson:'${pageContext.request.contextPath}/kindeditor/show',
            allowFileManager:true,
            filePostName:'file',
            afterBlur : function() {
                this.sync();
            }
        });

        $("#articleTable").jqGrid({
            url:"${pageContext.request.contextPath}/article/queryAll",
            datatype:"json",
            styleUI:"Bootstrap",
            colNames:["文章编号","文章标题","图片路径","上传时间","预览"],
            colModel:[
                {name:"id"},
                {name:"title"},
                {name:"imgPath"},
                {name:"publishTime"},
                {name:"preview",formatter:function(cellvalue, options, rowObject){
                    var id = rowObject.id;
                    return "<button onclick=\"showArticle('"+id+"')\" data-toggle=\"modal\" data-target=\"#previewModal\" type=\"button\" class=\"btn btn-primary btn-lg\">预览</button><button type=\"button\" class=\"btn btn-warning btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">修改</button><button type=\"button\" onclick=\"deleteArticle('"+id+"')\" class=\"btn btn-danger btn-lg\">删除</button>"
                }}
            ],
            pager:"articlePager",
            rowNum:3,
            rowList:[3,5,7],
            viewrecords:true,
            autowidth:true,
            multiselect:true,
            rownumbers:true,
            toolbar:[true,"top"],

        });
        $("#t_articleTable").append("<button onclick='selectGurus()' type=\"button\" class=\"btn btn-primary btn-lg\" data-toggle=\"modal\" data-target=\"#myModal\">添加</button>")
        $("#addArticle")
    })
    function selectGurus(){

        $.ajax({
            url:"${pageContext.request.contextPath}/article/queryGurus",
            type:"json",
            success:function(gurus){
                $("#gurus").append(gurus);
            }
        })
    }
    function addSubmit(){
        var form = new FormData(document.getElementById("addForm"));
        $.ajax({
            url:"${pageContext.request.contextPath}/article/addArticle",
            type:"post",
            //告诉jQuery不要去处理发送的数据
            processData:false,
            //告诉jQuery不要去设置Content-Type请求头,因为表单已经设置了multipart/form-data
            contentType:false,
            data:form,
            success:function(){
                $("#myModal").modal('toggle');
                $("#articleTable").trigger("reloadGrid");
            }
        })
    }
    function showArticle(id){
        $.ajax({
            url:"${pageContext.request.contextPath}/article/queryOneArticle",
            type:"post",
            data:{'id':id},
            datatype:"json",
            success:function(data){
                $("#articleDetail").append(data)
            }
        })
    }
    function deleteArticle(id){
        $.ajax({
            url:"${pageContext.request.contextPath}/article/removeArticle",
            data:{id:id},
            success:function(){
                $("#articleTable").trigger("reloadGrid");
            }
        })
    }
</script>
<button class="btn btn-default" type="submit">Button</button>
<button class="btn btn-default" type="submit">Button</button>
<table id="articleTable"></table>
<div id="articlePager"></div>

<!-- 添加的模态框 -->
<div class="modal fade" id="myModal" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">添加文章</h4>
            </div>
            <form id="addForm" action="#" method="post" enctype="multipart/form-data">
            <div class="modal-body">
                选择上师：<select name="guruId" id="gurus" ></select><br>
                文章名称：<input type="text" name="title"/><br>
                <textarea id="editor_id" name="content" style="width:700px;height:300px;"></textarea><br>
                上传图片：<input type="file" name="imgFile"/><br>
                上传时间：<input type="date" name="publishTime"/><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="addSubmit()">提交</button>
            </div>
            </form>
        </div>
    </div>
</div>

<!-- 预览的模态框 -->
<div class="modal fade" id="previewModal" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body" id="articleDetail">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>