<%-- 每个jsp文件中都加入下面两句 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   <%--注意：需要放一个jstl.jar包到Tomcat的WEB-INF/lib下--%>

<!DOCTYPE html>
<head>
    <title>主界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv ="Pragma" content = "no-cache"/>
    <meta http-equiv="Cache-Control" content="no cache" />
    <meta http-equiv="Expires" content="0" />

    <script type="text/javascript" src="/resources/layui/layui.js"></script>
    <link rel="stylesheet" href="/resources/layui/css/layui.css">
    <link rel="stylesheet" href="/resources/layui/css/my.css">

</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">Admin</div>
        <%-- 头部区域（可配合layui已有的水平导航） --%>
<%--        <ul class="layui-nav layui-layout-left">--%>
<%--            <li class="layui-nav-item"><a href="">控制台</a>--%>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">邮件管理</a></dd>--%>
<%--                    <dd><a href="">消息管理</a></dd>--%>
<%--                    <dd><a href="">授权管理</a></dd>--%>
<%--                </dl>--%>
<%--            </li>--%>
<%--        </ul>--%>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    管理员
                </a>
<%--                <dl class="layui-nav-child">--%>
<%--                    <dd><a href="">基本资料</a></dd>--%>
<%--                    <dd><a href="">安全设置</a></dd>--%>
<%--                </dl>--%>
            </li>
            <li class="layui-nav-item"><a href="/userAccount/toLogin">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black" id="left-side">
        <div class="layui-side-scroll">
            <%-- 左侧导航区域（可配合layui已有的垂直导航） --%>
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item">
                    <a href="javascript:;">个人中心</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/userAccount/edit/${userAccount.id}" target="option">个人资料</a></dd>
                        <dd><a href="/userAccount/toChangePassword/${userAccount.id}" target="option">密码修改</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="javascript:;">用户管理</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/userAccount/allUserAccountList/1" target="option">用户信息</a></dd>
                        <dd><a href="/userAccount/add" target="option">添加用户</a></dd>
                        <dd><a href="/userAccount/query" target="option">用户查询</a></dd>
                    </dl>
                </li>
<%--                <li class="layui-nav-item"><a href="/customer/DevelopDoc" target="option">开发日志</a></li>--%>
            </ul>
        </div>
    </div>

    <div class="layui-tab layui-tab-brief"  >
        <%-- 内容主体区域 --%>
        <div class="layui-body" >
            <iframe id="option" name="option" width="100%" height="100%"></iframe>
        </div>

    </div>
</div>

<script type="text/javascript" src="/resources/layui/layui.all.js"></script>
<script>
    layui.use('element', function () {
       var element = layui.element;


    });
</script>

</body>
</html>
