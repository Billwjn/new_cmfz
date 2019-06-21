<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="../jqgrid/extend/css/trirand/ui.jqgrid-bootstrap.css">
    <script src="../boot/js/jquery-3.3.1.min.js"></script>
    <script src="../boot/js/bootstrap.3.3.7.min.js"></script>
    <script src="../jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="../jqgrid/extend/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="../boot/js/ajaxfileupload.js"></script>
    <script src="../echarts/echarts.js"></script>
    <script src="../echarts/china.js"></script>
    <title>用户注册</title>
</head>
<body>
<h1 class="page-header">
    用户注册
</h1>
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/user/regist">
    <div class="form-group">
        <label for="inputUsername">用户名</label>
        <input type="text" class="form-control" id="inputUsername" placeholder="username" name="username">
    </div>
    <div class="form-group">
        <label for="inputPassword">密码</label>
        <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
    </div>
    <div class="form-group">
        <label for="inputMobile">手机</label>
        <input type="text" class="form-control" id="inputMobile" placeholder="mobile" name="mobile">
    </div>
    <div class="form-group">
        <label for="inputDharmaName">上师名称</label>
        <input type="text" class="form-control" id="inputDharmaName" placeholder="dharmaName" name="dharmaName">
    </div>
    <div class="form-group">
        <label for="inputProvince">省</label>
        <input type="text" class="form-control" id="inputProvince" placeholder="province" name="province">
    </div>
    <div class="form-group">
        <label for="inputCity">市</label>
        <input type="text" class="form-control" id="inputCity" placeholder="city" name="city">
    </div>
    <div class="form-group">
        <label for="inputGender">性别</label>
        <select class="form-control" id="inputGender" name="gender">
            <option value="男">男</option>
            <option value="女">女</option>
        </select>
    </div>
    <div class="form-group">
        <label for="inputSign">个性签名</label>
        <input type="text" class="form-control" id="inputSign" placeholder="sign" name="sign">
    </div>
    <div class="form-group">
        <label for="inputFile">选择头像</label>
        <input type="file" id="inputFile" name="imgFile">
        <p class="help-block">请选择上传的头像</p>
    </div>
    <div class="form-group">
        <label for="inputTime">注册时间</label>
        <input type="date" class="form-control" id="inputTime" placeholder="registTime" name="registTime">
    </div>
    <button type="submit" class="btn btn-default">提交</button>
</form>
</body>
</html>