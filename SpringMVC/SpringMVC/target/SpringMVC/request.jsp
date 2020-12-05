<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>请求</title>
    </head>
    <body>
        <h2>请求参数绑定</h2>
<%--        <a href="/param/test?username=gg&password=1234">入门程序</a>--%>
        <form action="/param/saveAccount" method="post">
            用户名：<input type="text" name="username"><br>
            密码：<input type="text" name="password"><br>
            金额：<input type="text" name="money"><br>
            <%-- 把数据封装到类中的类属性中 --%>
            姓名：<input type="text" name="user.name"><br>
            年龄：<input type="text" name="user.age"><br>
            <%-- 把数据封装到类中的List中 --%>
            姓名：<input type="text" name="userList[0].name"><br>
            年龄：<input type="text" name="userList[0].age"><br>
            <%-- 自定义类型转换 --%>
            生日：<input type="text" name="birthday"><br>
            <input type="submit">
        </form>

        <br><br>
        <a href="/param/testPathVariable/10">占位符</a>
    </body>
</html>
