<%@page isELIgnored="false" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../boot/css/bootstrap.min.css">
    <link rel="stylesheet" href="../jqgrid/extend/css/trirand/ui.jqgrid-bootstrap.css">
    <script src="../boot/js/jquery-3.3.1.min.js"></script>
    <script src="../boot/js/bootstrap.3.3.7.min.js"></script>
    <script src="../jqgrid/js/i18n/grid.locale-cn.js"></script>
    <script src="../jqgrid/extend/js/trirand/jquery.jqGrid.min.js"></script>
    <script src="../boot/js/ajaxfileupload.js"></script>
    <title>持明法洲后台管理系统</title>
    <style>
        .panel{
            margin-bottom: 0;
        }
    </style>
</head>
<body>
    <%--标题导航条--%>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <a class="navbar-brand" href="#">持明法洲后台管理系统</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎：小黑 <span class="glyphicon glyphicon-user"></span> </a></li>
                <li><a href="#">退出登录 <span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
        </div>
    </nav>
    <%--页面主体--%>
    <div class="container-fluid">
        <div class="row">
            <%--左边分类导航栏--%>
            <div class="col-sm-2">
                <%--手风琴--%>
                    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                        <%--管理员--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#adminManager">
                                        管理员管理
                                    </a>
                                </h4>
                            </div>
                            <div id="adminManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <a href="">管理员列表</a>
                                </div>
                            </div>
                        </div>
                        <%--用户--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#userManager">
                                        用户管理
                                   </a>
                                </h4>
                            </div>
                            <div id="userManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">用户信息</a></li>
                                        <li><a href="">用户反馈</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <%--轮播图--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#carouselManager">
                                        轮播图
                                    </a>
                                </h4>
                            </div>
                            <div id="carouselManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#center').load('carousel.jsp')">轮播图列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <%--专辑--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#albumManager">
                                        专辑管理
                                    </a>
                                </h4>
                            </div>
                            <div id="albumManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="javascript:$('#center').load('album.jsp')">专辑列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><%--上师--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#guruManager">
                                        上师管理
                                    </a>
                                </h4>
                            </div>
                            <div id="guruManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">上师列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><%--文章--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#articleManager">
                                        文章管理
                                    </a>
                                </h4>
                            </div>
                            <div id="articleManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">文章列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><%--功课--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#workManager">
                                        功课管理
                                    </a>
                                </h4>
                            </div>
                            <div id="workManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">功课列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><%--日志--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#logManager">
                                        日志管理
                                    </a>
                                </h4>
                            </div>
                            <div id="logManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">日志列表</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><%--统计分析--%>
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#countManager">
                                        统计分析
                                    </a>
                                </h4>
                            </div>
                            <div id="countManager" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li><a href="">近半年用户注册信息</a></li>
                                        <li><a href="">用户地域分布</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                    </div>
            </div>
            <%--右边轮播图部分--%>
            <div class="col-sm-9" id="center">
                <%--巨幕--%>
                <div class="jumbotron">
                    <h2>欢迎来到持明法洲后台管理系统</h2>
                </div>
                <%--轮播图--%>
                    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active">
                                <img src="../img/1.png" alt="..." class="center-block">
                                <div class="carousel-caption">
                                </div>
                            </div>
                            <div class="item">
                                <img src="../img/2.png" alt="..." class="center-block">
                                <div class="carousel-caption">
                                </div>
                            </div><div class="item">
                                <img src="../img/3.png" alt="..." class="center-block">
                                <div class="carousel-caption">
                                </div>
                            </div><div class="item">
                                <img src="../img/4.png" alt="..." class="center-block">
                                <div class="carousel-caption">
                                </div>
                            </div>
                        </div>

                        <!-- Controls -->
                        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
            </div>
        </div>
    </div>
    <%--页尾--%>
    <div class=""></div>
    <div class="panel panel-default">
        <div class="panel-footer">
            <h5 style="text-align:center;">@百知教育 baizhi@zparkhr.com.cn</h5>
        </div>
    </div>
</body>
</html>