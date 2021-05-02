
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>高级搜索</title>
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">

</head>
<body>
    <!--<h3 align="center">高级搜索</h3>-->
    <form class="layui-form" action="/userAccount/list/1" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="name"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-inline">
                <select name="gender" lay-verify="">
                    <option value="">==请选择性别==</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">搜索</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
    <script>
        layui.use('form', function () {
            var form = layui.form;
            form.render('select');
        });
    </script>
</body>
</html>
