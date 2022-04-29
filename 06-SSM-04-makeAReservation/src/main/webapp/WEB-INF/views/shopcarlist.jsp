<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet"
          type="text/css">
    <script src="https://cdn.staticfile.org/jquery/2.1.2/jquery.min.js" type="text/javascript"></script>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
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
    <table class="table table-hover">
        <tr>
            <th>菜品名称</th>
            <th>菜品单价</th>
            <th>菜品数量</th>
            <th>菜品总价</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${result.shopCarList}" var="shopCar">
            <tr>
                <td>${shopCar.dishName}</td>
                <td>${shopCar.price}</td>
                <td>${shopCar.dishNum}</td>
                <td>${shopCar.totalPrice}</td>
                <td><a href="/shopcar/remove?dishId=${shopCar.dishId}">移除</a></td>
            </tr>
        </c:forEach>
        <c:if test="${empty result.shopCarList}">
            <tr>
                <td colspan="5" class="text-right" style="padding-right:80px">购物车都饿了，赶快&nbsp;&nbsp<a href="/dish/list">购买吧</a>
                </td>
            </tr>
        </c:if>
        <c:if test="${not empty result.shopCarList}">
            <tr>
                <td colspan="5" class="text-right" style="padding-right:80px">总价：${result.totalPrice}元&nbsp;&nbsp;&nbsp;<a
                        href="/order/orderform">去下单</a></td>
            </tr>
        </c:if>
    </table>

</div>
</body>
</html>
