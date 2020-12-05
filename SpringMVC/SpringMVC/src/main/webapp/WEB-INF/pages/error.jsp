<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/11/28
  Time: 下午6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
    <head>
        <title>错误信息页面</title>
    </head>
    <body>
        <h3>${empty errorMsg?"这里有一个错误信息":errorMsg}</h3>
    </body>
</html>
