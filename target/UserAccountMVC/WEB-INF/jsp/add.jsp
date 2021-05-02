
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv ="Pragma" content = "no-cache"/>
    <meta http-equiv="Cache-Control" content="no cache" />
    <meta http-equiv="Expires" content="0" />
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">

</head>
<body>
    <!--<h3 align="center">添加客户</h3>-->
    <form class="layui-form" action="/userAccount/addUserAccountSubmit" method="get">
<%--        <input type="hidden" name="method" value="add">--%>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="name" placeholder="请输入姓名"
                       required lay-verify="name|required"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" title="男" value="男" checked = checked/>
                <input type="radio" name="gender" title="女" value="女" />
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="password" name="password"  placeholder="请输入密码"
                       required lay-verify="phone|required"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="birth" id="birth" lay-verify="birth" placeholder="请输入生日"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">账户金额</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="deposit" placeholder="请输入金额" required lay-verify="required"/>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">添加用户</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <script>
        layui.use(['form','laydate'], function () {
            var form = layui.form;
            var laydate = layui.laydate;

            //常规用法
            laydate.render({
                elem: '#birth'
            });
            form.render('radio');
        });

    </script>
</body>
</html>
