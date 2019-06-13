<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<script charset="utf-8" src="../kindeditor/kindeditor-all.js"></script>
<script charset="utf-8" src="../kindeditor/lang/zh-CN.js"></script>
<script>
    KindEditor.ready(function(K) {
        window.editor = K.create('#editor_id',{
            width:'1700px',
            uploadJson:'${pageContext.request.contextPath}/kindeditor/upload',
            fileManagerJson:'${pageContext.request.contextPath}/kindeditor/show',
            allowFileManager:true,
            filePostName:'file'
        });
    });
</script>
<form action="${pageContext.request.contextPath}/article/test" method="post">
<textarea id="editor_id" name="content" style="width:700px;height:300px;">
&lt;strong&gt;HTML内容&lt;/strong&gt;
</textarea>
    <input type="submit">
</form>