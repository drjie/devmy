<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加主题--管理后台</title>
   <script type="text/javascript">
		function check(){
			var tname = document.getElementById("tname");
	
			if(tname.value == ""){
				alert("请输入主题名称！！");
				tname.focus();
				return false;
			}		
			return true;
		}
	</script>
</head>
<body>
  <div id="main">
      <div>
		  <%@ include file="console_element/top.html"%>
	  </div> 
      <div id="opt_list">
		  <%@ include file="console_element/left.html"%>
      </div>
	  <div id="opt_area">
	    <h1 id="opt_type"> 添加主题： </h1>
	    <form action="${pageContext.request.contextPath}/topic.html" method="post" onsubmit="return check()" >
	      <p>
	        <label> 主题名称 </label>
	        <input name="tname" type="text"  value="${param.tname}" class="opt_input" />
			  <span style="color: red">${error}</span>
	      </p>
	      <input name="action" type="hidden" value="addtopic">
	      <input type="submit" value="提交" class="opt_sub" />
	      <input type="reset" value="重置" class="opt_sub" />
	    </form>
	  </div>
	  <%@ include file="console_element/bottom.html"%>
  </div>
</body>
</html>		