<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
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
</head>
<body>
    <%--标题导航栏--%>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">
                    持明法洲后台管理系统 v1.0
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎：小黑 <span class="glyphicon glyphicon-user"></span></a></li>
                <li><a href="#">退出登录 <span class="glyphicon glyphicon-log-in"></span></a></li>
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
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingOne">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#carouselManager" aria-expanded="false" aria-controls="collapseOne">
                                        轮播图
                                    </a>
                                </h4>
                            </div>
                            <div id="carouselManager" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li role="presentation"><a href="javascript:$('#center').load('carousel.jsp')">轮播图管理</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingTwo">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#albumManager" aria-expanded="false" aria-controls="collapseTwo">
                                        专辑
                                    </a>
                                </h4>
                            </div>
                            <div id="albumManager" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li role="presentation"><a href="javascript:$('#center').load('album.jsp')">专辑管理</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-default">
                            <div class="panel-heading" role="tab" id="headingThree">
                                <h4 class="panel-title">
                                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#articleManager" aria-expanded="false" aria-controls="collapseThree">
                                        文章
                                    </a>
                                </h4>
                            </div>
                            <div id="articleManager" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                <div class="panel-body">
                                    <ul class="nav nav-pills nav-stacked">
                                        <li role="presentation"><a href="javascript:$('#center').load('article.jsp')">文章管理</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <%--右侧轮播图部分--%>
            <div class="col-sm-10" id="center">
                <%--巨幕--%>
                <div class="jumbotron">
                    <h2>欢迎来到持明法洲后台管理系统</h2>
                </div>
                <%--首页轮播图--%>
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
                            <img src="../img/1.png" alt="" class="center-block">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/2.png" alt="" class="center-block">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/3.png" alt="" class="center-block">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="../img/4.png" alt="" class="center-block">
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
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="text-center">
            <br> @百知教育 baizhi@zparkhr.com.cn<br><br>
        </div>
    </nav>
</body>
</html>