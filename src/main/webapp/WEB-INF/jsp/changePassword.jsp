<%--
  Created by IntelliJ IDEA.
  User: WuTao
  Date: 2021/4/30
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
</head>
<body>
    <form class="layui-form" action="/userAccount/changPassword">
        <input type="hidden" name="id" value="${userAccount.id}">
        <input type="hidden" id="password" value="${userAccount.password}">
        <div class="layui-form-item">
            <label class="layui-form-label">原密码</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="password" id="oldPassword" name="oldPassword" required onkeyup="checkOldPassword()">
            </div>
        </div>
        <script type="text/javascript">
            function checkOldPassword() {
                if (document.getElementById("oldPassword").value != document.getElementById("password").value) {
                    document.getElementById("password_check").innerHTML = "原密码输入错误";
                } else {
                    document.getElementById("password_check").innerHTML = "";
                }
            }
        </script>
        <div class="layui-form-item">
            <label class="layui-form-label">新密码</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="password" id="newPassword" name="newPassword" required>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">确认新密码</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="password" id="repassword" name="confirmPassword" required onkeyup="check()">
            </div>
        </div>
        <div id="password_check" style="margin-left: 31px;color: red"><span></span></div>
        <script type="text/javascript">
            function check() {
                if (document.getElementById("newPassword").value != document.getElementById("repassword").value) {
                    document.getElementById("password_check").innerHTML = "两次密码输入不一致";
                } else {
                    document.getElementById("password_check").innerHTML = "";
                }
            }
        </script>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">修改</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</body>
</html>
