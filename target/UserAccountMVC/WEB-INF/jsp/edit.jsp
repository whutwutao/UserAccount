
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑信息</title>
    <script type="text/javascript" src="/resources/layui/layui.all.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">

</head>

<body>
    <!--<h3 align="center">编辑客户</h3>-->
    <form class="layui-form" action="/userAccount/editUserAccountSubmit" method="post">
        <input type="hidden" name="id" value="${userAccount.id}">
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="name" required lay-verify="required" value="${userAccount.name}"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="gender" title="男" value="男" <c:if test="${userAccount.gender eq '男'}">checked</c:if>/>
                <input type="radio" name="gender" title="女" value="女" <c:if test="${userAccount.gender eq '女'}">checked</c:if> />
            </div>
        </div>

        <div class="layui-form-item" hidden>
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
            <input class="layui-input" type="text" name="password" lay-verify="password" value="${userAccount.password}"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">生日</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="birth" id="birth" lay-verify="date" value="<fmt:formatDate value="${userAccount.birth}" pattern="yyyy-MM-dd"/>"/>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">账户金额</label>
            <div class="layui-input-inline">
                <input class="layui-input" type="text" name="deposit" placeholder="请输入金额" value="${userAccount.deposit}" required lay-verify="required"/>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" type="submit">完成</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>

    <script>
        layui.use(['form','laydate'], function () {
            var form = layui.form;
            form.render('radio');
            var laydate = layui.laydate;
            laydate.render({
                elem: '#birth'
            })
        });
    </script>
</body>
</html>
