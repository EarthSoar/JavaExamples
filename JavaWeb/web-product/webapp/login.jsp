<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function change(){
			//重新设置<img >元素的src值
			document.getElementById("randomCodeImg").src="/randomCode?" + new Date().getTime();
		}
	</script>
	
	<h3>登录页面</h3>
	<span style="color: red">${error}</span>
	<form action="/login" method="post">
		账户<input type="text" name="username" required="required"/></br>
		密码<input type="text" name="password" required="required"/></br>
		验证码<input type="text" name="randomCode" required="required"/>
		<img src="/randomCode" id="randomCodeImg" title="看不清,换一张" style="cursor: pointer;"onclick="change();"/> </br>
		<input type="submit" value="登录"/>
	</form>
</body>
</html>