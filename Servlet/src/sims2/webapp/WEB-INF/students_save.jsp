<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/student/save" method="POST">
		<input type="hidden" name="id" value="${id}"/>
		姓名:<input type="text" name="name" value="${stu.name}"/><br/>
		年龄:<input type="number" name="age" value="${stu.age}"/><br/>
		<input type="submit" value='保存学生'>
	</form>
</body>
</html>