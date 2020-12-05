<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2020/11/28
  Time: 上午9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>响应</title>
        <script src="js/jquery.min.js"></script>
        <script>
            $(function () {
                //给btn绑定单击事件
                $("#btn").click(function () {
                    // alert("hello");
                    $.ajax({
                        //编写json格式，设置属性和值
                        url:"/param/testAjax",
                        contentType:"application/json;charset=UTF-8",
                        data:'{"username":"天","password":"123","money":"5000"}',
                        dataType:"json",
                        type:"post",
                        success:function (msg) {
                            alert(msg);
                            alert(msg.username);
                            alert(msg.password);
                        }
                    })
                })
            })
        </script>
    </head>
    <body>
        <a href="/param/testString">响应返回string</a><br>
        <a href="/param/testVoid">响应返回void</a><br>
        <a href="/param/testForwardAndRedirect">使用关键字进行转发和重定向</a><br>
        <button id="btn">发送Ajax请求</button><br>
        <a href="/param/testModelAndView">testModelAndView</a>
    </body>
</html>
