<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <img src="http://localhost:8081/upload/${img}">
  <form method="post" action="/file/download?filename=${img}">
    <input type="submit" value="下载">
  </form>
</body>
</html>