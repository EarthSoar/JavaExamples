<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${pro.id}
	<form action="/product?cmd=save" method="POST">
		<input type="hidden" name="id"/>
		名称:<input type="text" name="name" /><br/>
		分类编号:<input type="number" name="age"/><br/>
		<input type="submit" value='保存' />
	</form>
</body>
</html>