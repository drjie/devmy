<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
	<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.2/jquery.min.js"></script>
</head>
<body>
  <div id="main">
      <div>
		  <%@ include file="../console_element/top.jsp"%>
	  </div> 
      <div id="opt_list">
		  <%@ include file="../console_element/left.html"%>
      </div>
	  <div id="opt_area">
	    <h1 id="opt_type"> 添加主题： </h1>
	    <form action="/add_topic" method="post" id="topic_form">
	      <p>
	        <label> 主题名称 </label>
			  <input name="tname" type="text" id="tname" value="tom" class="opt_input" /><span id="msg" style = "color:#ed4c67;font-size: 9px;display: none">*请输入主题名称</span>

	      </p>

	      <input type="button" value="提交" class="opt_sub" id="save_name"/>
	      <input type="reset" value="重置" class="opt_sub" />
	    </form>
	  </div>
	  <%@ include file="../console_element/bottom.html"%>

	  <script type="text/javascript">

		  $(function(){

		  	$("#save_name").click(function (){
				let tname = $("#tname").val(); //获取输入框的值
				if(tname != ''){
					$("#topic_form").submit(); //jquery 提交表单
				}else{
					//alert("请输入主题，再提交！");
					$("#msg").show();
					$("#tname").focus();
				}


			});

			$("#tname").keydown(function(){

				$("#msg").hide();
			});



		  });

	  </script>

  </div>
</body>
</html>		