
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.staticfile.org/jquery/2.1.2/jquery.min.js" type="text/javascript"></script>
</head>
<body>

    <div class="container">
        <c:if test="${code=='101'}">
            用户名已经存在，请重新注册
        </c:if>
        <form class="form-horizontal" id = "login_form" action="/user/login" method="post">
            <div class="form-group">
                <label for="userName" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-7">
                    <input  type="text" name = "username" class="form-control" id="userName" placeholder="请输入用户名">
                </div>
                <div class="col-sm-3">
                    <span id = "username_msg" style="display: none;color:red;font-size: 10px">* 用户名已被占用，请重新输入！</span>
                </div>
            </div>
            <div class="form-group">
                <label for="pwd" class="col-sm-2 control-label">密码</label>
                <div class="col-sm-7">
                    <input type="password" name = "password" class="form-control" id="pwd" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id = "register_btn" type="submit" class="btn btn-default">登录</button>
                </div>
            </div>
        </form>
    </div>


    <script type="text/javascript">

        $(function(){


        });

    </script>


</body>
</html>
