<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/11/28
  Time: 下午2:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>文件上传</title>
    </head>
    <body>
        <form action="/param/testFileUpload" method="post" enctype="multipart/form-data">
            选择文件：<input type="file" name="upload"><br>   <!-- 此处的name必须和方法中的参数名一样 -->
            <input type="submit" value="上传">
        </form>
    </body>
</html>
