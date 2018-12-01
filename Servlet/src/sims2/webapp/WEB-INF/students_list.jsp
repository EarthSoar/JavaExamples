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

	<a href="/student/edit">添加</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0" >
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${students}" var="s" varStatus="vs">
		<tr style="background-color: ${vs.count % 2 == 0 ? 'red':'' }">
			<td>${s.id}</td>
			<td>${s.name}</td>
			<td>${s.age}</td>
			<td>
				<a href="/student/delete?id=${s.id}">删除</a>
				<a href="/student/edit?id=${s.id}">编辑</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>