<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/basePath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>添加主题--管理后台</title>
    <link href="${requestScope.basePath}/static/css/admin.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="main">
    <div>
        <%--	    <iframe src="../newspages/console_element/top.html" scrolling="no" frameborder="0" width="947px" height="180px"></iframe>--%>
        <%@ include file="console_element/top.jsp" %>
    </div>
    <div id="opt_list">
        <%--	 	<iframe src="../newspages/console_element/left.html" scrolling="no" frameborder="0" width="130px"></iframe>--%>
        <%@ include file="console_element/left.html" %>
    </div>
    <div id="opt_area">
        <ul class="classlist">
            <c:forEach items="${page.list}" var="news">
                <li><a href="/read?id=${news.nid}">${news.ntitle}</a> <span> 作者：${news.nauthor}&#160;&#160;&#160;&#160; <a
                        href='/update?id=${news.nid}'>修改</a> &#160;&#160;&#160;&#160; <a
                        href='/del_news?id=${news.nid}'>删除</a> </span></li>
            </c:forEach>
            <li class='space'></li>
            <p align="right"> 当前页数:[${page.pageNum}/${page.pages}]&nbsp;
                <a href="/news/list/${page.navigateFirstPage}">首页</a>
                <c:choose>
                    <c:when test="${page.hasPreviousPage}">
                        <a href="/news/list/${page.prePage}">上一页</a>
                    </c:when>
                    <c:otherwise>
                        <a href="javascript:void(0)">上一页</a>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${page.hasNextPage}">
                        <a href="/news/list/${page.nextPage}">下一页</a>

                    </c:when>
                    <c:otherwise>
                        <a href="javascript:void(0)">下一页</a>
                    </c:otherwise>
                </c:choose>
                <a href="/news/list/${page.navigateLastPage}">末页</a>

            </p>
        </ul>
    </div>
    <%--	  <iframe src="console_element/bottom.html" scrolling="no" frameborder="0" width="947px" height="190px"></iframe>--%>
    <%@ include file="console_element/bottom.html" %>
</div>
</body>
</html>

	