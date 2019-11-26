<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/11/22
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    #msg{
        color: red;
        font-size: 18px;
    }
</style>
<head>
    <title>错误页</title>
</head>
<body>
<div id="msg"><%--${errorMsg}--%><%=request.getParameter("errorMsg")%></div>
</body>
</html>
