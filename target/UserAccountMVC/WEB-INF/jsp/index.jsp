﻿<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	
<head>
		<meta charset="utf-8">
		 <title>登录页面-</title> 
        <meta name="keywords" content=",PHP在线教程,PHP视频教程,Mysql教程,html模板下载,网页特效,PHP面试题,mysql面试题,技术论坛,技术文章,励志文章,html教程,javascript教程," />
    <meta name="description" content="为集在线课程、模板下载、网页特效、资源下载、技术文章、专业平台接口等于一体的，服务于广大技术人员的网络平台。平台提供许多免费数据供广大技术人员参考使用，技术改变命运，望广大技术人员给与多多支持与鼓励。" />
		<link rel="stylesheet" href="/resources/css/reset.css" />
		<link rel="stylesheet" href="/resources/css/common.css" />
		<link rel="stylesheet" href="/resources/css/font-awesome.min.css" />
	</head>
	<body>
		<div class="wrap login_wrap">
			<div class="content">
				<div class="logo"></div>
				<div class="login_box">	
					
					<div class="login_form">
						<div class="login_title">
							登录
						</div>
						<form action="/userAccount/login" method="post">
							
							<div class="form_text_ipt">
								<input name="name" type="text" placeholder="姓名">
							</div>
							<div class="ececk_warning"><span>姓名不能为空</span></div>
							<div class="form_text_ipt">
								<input name="password" type="password" placeholder="密码">
							</div>
							<div class="ececk_warning"><span>密码不能为空</span></div>
							<div class="form_check_ipt">
								<div class="left check_left">
									<label><input name="" type="checkbox"> 下次自动登录</label>
								</div>
								<div class="right check_right">
									<a href="#">忘记密码</a>
								</div>
							</div>
							<div class="form_btn">
								<button type="submit">登录</button>
							</div>
							<div class="form_reg_btn">
								<span>还没有帐号？</span><a href="/userAccount/toRegister">马上注册</a>
							</div>
						</form>
						<div class="other_login">
							<div class="left other_left">
								<span>其它登录方式</span>
							</div>
							<div class="right other_right">
								<a href="#"><i class="fa fa-qq fa-2x"></i></a>
								<a href="#"><i class="fa fa-weixin fa-2x"></i></a>
								<a href="#"><i class="fa fa-weibo fa-2x"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script type="text/javascript" src="/resources/js/jquery.min.js" ></script>
		<script type="text/javascript" src="/resources/js/common.js" ></script>
		<div style="text-align:center;">

</div>
	<style>
.copyrights{text-indent:-9999px;height:0;line-height:0;font-size:0;overflow:hidden;}
</style>
<div class="copyrights" id="links20210126">
	Collect from <a href="http://www.cssmoban.com/"  title="网站模板">模板之家</a>
	<a href="http://cooco.net.cn/" title="组卷网">组卷网</a>
</div>
</body>
</html>
