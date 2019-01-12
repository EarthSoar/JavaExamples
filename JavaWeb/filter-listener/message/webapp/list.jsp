<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>留言列表</title>
</head>
<body>
	<table border="1" cellpadding="0" cellspacing="0" width="400">
		<tr>
			<th>主题</th>
			<th>内容</th>
		</tr>
		<c:forEach items="${list}" var="msg">
			<tr>
				<td>${msg.title}</td>
				<td>${msg.content}</td>
			</tr>
		</c:forEach>
	</table>
	<hr color=red size=10 />
	<form action="/msg?cmd=save" method="post">

		主题:<input type="text" name="title" /><br /> 
		内容
			<textarea  name="content" rows="5" cols="20"></textarea>
		<br /> <input type="submit" value='submit' /><br />
	</form>
</body>
</html>