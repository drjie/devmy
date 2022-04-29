<%@ page language="java"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
<title>编辑主题--管理后台</title>
   <script type="text/javascript">

	</script>
</head>
<body>
  <div id="main">
      <div>
<%--	    <iframe src="console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>--%>
		  <%@ include file="../console_element/top.jsp"%>
	  </div> 
      <div id="opt_list">
		  <%@ include file="../console_element/left.html"%>
      </div> 
	  <div id="opt_area">
	    <ul class="classlist">

			<c:forEach items="${topicList}" var="topic">
				<li> ${topic.tname}
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="/update_topic?id=${topic.tid}">修改</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a href="/del_topic?id=${topic.tid}">删除</a>
				</li>

			</c:forEach>
		</ul>
	  </div>
	  <%@ include file="../console_element/bottom.html"%>
  </div>
</body>
</html>	