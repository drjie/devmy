<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/static/css/admin.css" rel="stylesheet" type="text/css" />
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="${requestScope.basePath}/static/images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="${requestScope.basePath}/static/images/a_b01.gif" alt="" /></div>
  </div>
</div>

<div id="admin_bar">
  <c:if test="${!empty sessionScope.currUser}">
    <div id="status">管理员：${sessionScope.currUser.uname}   &#160;&#160;&#160;&#160; <a href="/logout">login out</a></div>
  </c:if>
  <div id="channel"> </div>
</div>
