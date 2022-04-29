
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
        <form class="form-horizontal" id = "register_form" action="/user/register" method="post">
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
                <label for="tel" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-7">
                    <input type="text" name = "tel" class="form-control" id="tel" placeholder="请输入电话">
                </div>
            </div>

            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">地址</label>
                <div class="col-sm-7">
                    <input type="text" name = "address" class="form-control" id="address" placeholder="请输入地址">
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id = "register_btn" type="button" class="btn btn-default">注册</button>
                </div>
            </div>
        </form>
    </div>


    <script type="text/javascript">

        $(function(){

            //定义一个标志
            var flag = true;

            $("#register_btn").click(function (){
                if(!flag){
                    return false;
                }
                let userName = $("#userName").val();
                let pwd = $("#pwd").val();
                let tel = $("#tel").val();
                let address = $("#address").val();
                //拼装json数据
                let user = {username:userName,password:pwd,tel:tel,address:address};


                $.ajax({
                    url:"/user/ajaxRegister",
                    contentType:"application/json;charset=utf-8",
                    data:JSON.stringify(user),
                    dataType:"json",
                    type:"post",
                    success:function(result){
                       if(result == '1'){
                           alert("注册成功！");
                       }
                    }
                });


                /*let data = $("#register_form").serialize();
                console.log(data);
                $.post("/user/ajaxRegister",{data:data},function(result){

                });*/

            });




            //通过ajax校验用户名是否重复
            $("#userName").blur(function(){
                //获取输入的用户名
                let userName = $("#userName").val();
                //发送Ajax请求做校验
                $.get("/user/checkUserName",{userName:userName},function (result){
                    if(!result){
                        //显示提示信息
                        $("#username_msg").show();
                        flag = false;
                    }
                });
            });

        });

    </script>


</body>
</html>
