
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/jquery/2.1.2/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">我要订餐 <span class="sr-only">(current)</span></a></li>
                <li><a href="#">查看餐袋</a></li>
                <li><a href="#">签收订单</a></li>
                <li><a href="#">删除订单</a></li>
                <li><a href="#">我要点赞</a></li>
                <li><a href="/shopcar/list">查看购物车</a></li>
            </ul>
            <form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">退出</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
    <div class="container">

        <form class="form-horizontal" id = "" action="/order/save" method="post">
            <div class="form-group">
                <label for="orderName" class="col-sm-2 control-label">收货人</label>
                <div class="col-sm-7">
                    <input  type="text" name = "orderName" class="form-control" id="ordername" value="${sessionScope.currUser.username}">
                </div>
            </div>
            <div class="form-group">
                <label for="tel" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-7">
                    <input type="text" name = "tel" class="form-control" id="tel" value="${sessionScope.currUser.tel}">
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-7">
                    <input type="text" name = "address" class="form-control" id="address" value="${sessionScope.currUser.address}">
                </div>
            </div>
            <div class="form-group">
                <label for="orderPrice" class="col-sm-2 control-label">订单总金额</label>
                <div class="col-sm-7">
                    <input type="text" name = "orderPrice" class="form-control" id="orderPrice" value="${orderInfo.totalPrice}" readonly>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id = "register_btn" type="submit" class="btn btn-default">确认，支付</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
