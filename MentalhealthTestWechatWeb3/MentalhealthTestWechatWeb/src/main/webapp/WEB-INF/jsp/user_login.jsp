<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zxx">
<head>
<title>后台系统登录</title>
<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<meta name="keywords" content="">
<script>
	addEventListener("load", function() {
		setTimeout(hideURLbar, 0);
	}, false);

	function hideURLbar() {
		window.scrollTo(0, 1);
	}
</script>
<link href="static/login/style.css" type="text/css" rel="stylesheet">
</head>

<body>
	<h1>后台系统用户登录</h1>
	<div class="w3ls-login box">

		<form action="adminLogin" method="post">
			<div class="agile-field-txt">
				<input type="number" name="Atel" placeholder="请输入电话" required="" />
			</div>
			<div class="agile-field-txt">
				<input type="password" name="Apwd" placeholder="请输入密码"
					required="" id="myInput" />
			</div>
			
			<div class="w3ls-bot">
				<input type="submit" name="Submit" value="用户登录">
			</div>
		</form>
	</div>
	<!-- //form ends here -->
	<!--copyright-->
	<div class="copy-wthree">
		<p>
			谢谢访问
		</p>
	</div>
	<!--//copyright-->
</body>

</html>