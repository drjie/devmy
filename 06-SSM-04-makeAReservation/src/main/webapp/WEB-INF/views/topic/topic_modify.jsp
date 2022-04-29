<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="pragma" content="no-cache"/>
    <meta http-equiv="cache-control" content="no-cache"/>
    <meta http-equiv="expires" content="0"/>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3"/>
    <meta http-equiv="description" content="This is my page"/>
    <title>新闻中国</title>
    <script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <link href="../css/admin.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div id="main">
    <div>
        <%--<iframe src="console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>--%>
        <%@ include file="../console_element/top.jsp" %>
    </div>
    <div id="opt_list">
        <%--<iframe src="console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>--%>
        <%@ include file="../console_element/left.html" %>
    </div>
    <div id="opt_area">
        <h1 id="opt_type"> 修改主题： </h1>
        <form action="/update_topic" method="post" id="topic_form">
            <p>
                <input type="hidden" name="id" value="${topic.tid}">
                <label> 主题名称 </label>
                <input name="tname" type="text" class="opt_input" id="tname" value="${topic.tname}"/>
            </p>
            <input type="button" value="提交" id="save_btn" class="opt_sub"/>
        </form>
    </div>
    <%--<iframe src="console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>--%>
    <%@ include file="../console_element/bottom.html" %>

    <script>
        $(function(){

          $("#save_btn").click(function (){
              let tname = $("#tname").val();
              if(tname != ''){
                  $("#topic_form").submit();
              }else{
                  alert("请输入修改的主题名称");
              }
          });

        });
    </script>
</div>
</body>
</html>	