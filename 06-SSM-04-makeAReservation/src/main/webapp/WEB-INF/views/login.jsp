<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加主题--管理后台</title>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.2/jquery.min.js"></script>
</head>
<body>
<div id="main">
    <div>
        <%@ include file="console_element/top.html" %>
    </div>
    <%--<div id="opt_list">
        <%@ include file="console_element/left.html"%>
    </div>--%>
    <div id="opt_area">
        <c:if test="${param.errCode == 101}">
            <span>登录失败！请重新登录！</span>
        </c:if>
        <h1 id="opt_type"> 管理员登录： </h1>
        <form action="/login" method="post" id="login_form">
            <p>
                <label> 账号 </label>
                <input name="uname" type="text" id="name_text" class="opt_input"/><span id="name_msg"
                                                                                        style="color:red;display: none">*请输入账号</span>
            </p>
            <label> 密码 </label>
            <input name="upwd" type="text" id = "pwd_text" class="opt_input"/><span id="pwd_msg"
                                                                    style="color:red;display: none">*请输入密码</span>

            </p>
            <input type="button" value="登录" class="opt_sub" id="form_btn"/>

        </form>
    </div>
    <%@ include file="console_element/bottom.html" %>
    <script type="text/javascript">

        $(function () {
            let flag = true;
            //blur:失去焦点触发事件
            //change : 元素发生改变并且离开焦点触发
            $("#name_text").change(function () {
                let name = $("#name_text").val();

                if(name.length < 5){
                    flag = false;
                    $("#name_msg").show();
                }
            });

            $("#pwd_text").change(function () {
                let pwd = $("#pwd_text").val();

                if(pwd.length < 5){
                    flag = false;
                    $("#pwd_msg").show();
                }
            });

            $("#name_text").focus(function (){
                $("#name_msg").hide();
                flag = true;
            });

            $("#pwd_text").focus(function (){
                $("#pwd_msg").hide();
                flag = true;
            });

            $("#form_btn").click(function (){
                if(flag){

                    $("#login_form").submit();
                }
            });
        });

    </script>
</div>
</body>
</html>		