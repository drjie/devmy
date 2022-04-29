
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String scheme = request.getScheme(); // 获取访问协议 http
    String serverName = request.getServerName(); // 获取服务器名称 localhost
    int serverPort = request.getServerPort(); // 获取端口号 8888
    String contextPath = request.getContextPath(); // 项目路径 / /bb

    String basePath = scheme + "://" + serverName + ":" + serverPort ;
    request.setAttribute("basePath",basePath);


%>