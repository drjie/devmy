<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <title>添加新闻--管理后台</title>
    <link href="../..//css/admin.css" rel="stylesheet" type="text/css" />

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
        <h1 id="opt_type"> 修改新闻： </h1>
        <form action="/update" method="post">
            <p>
                <%--新闻id--%>
                    <input type="hidden" name="newsId" value="${news.nid}">
                <label> 主题 </label>
                <select name="ntid">
                    <c:forEach items="${topicList}" var="topic">
                        <option value="${topic.tid}" ${topic.tid==news.ntid ? 'selected':''}>${topic.tname}</option>
                    </c:forEach>
                </select>
            </p>
            <p>
                <label> 标题 </label>
                <input name="ntitle" type="text" class="opt_input" value="${news.ntitle}"/>
            </p>
            <p>
                <label> 作者 </label>
                <input name="nauthor" type="text" class="opt_input" value = "${news.nauthor}"/>
            </p>
            <p>
                <label> 摘要 </label>
                <textarea name="nsummary" cols="40" rows="3">${news.nsummary}</textarea>
            </p>
            <p>
                <label> 内容 </label>
                <textarea name="ncontent" cols="70" rows="10">${news.ncontent}</textarea>
            </p>
            <p>
                <label> 上传图片 </label>
                <input name="file" type="file" class="opt_input" />
            </p>
            <input name="action" type="hidden" value="addnews"/>
            <input type="submit" value="修改" class="opt_sub" />
        </form>
    </div>
    <%@ include file="../console_element/bottom.html"%>
</div>
</body>
</html>
