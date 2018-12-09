<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/product" method="POST">
		名称<input type="text" name="productName" value="${qo.productName}"/>
		价格<input type="number" name="minSalePrice" value="${qo.minSalePrice}"/> --
		<input type="number" name="maxSalePrice" value="${qo.maxSalePrice}"/>
		<input type="submit" value="查询"/>
	</form>
	<a href="/product?cmd=edit">添加</a>
	<table border="1" width="80%" cellpadding="0" cellspacing="0" >
		<tr>
			<th>ID</th>
			<th>名称</th>
			<th>分类编号</th>
			<th>零售价</th>
			<th>供应商</th>
			<th>制造商</th>
			<th>折扣</th>
			<th>成本价</th>
			<th>操作</th>
		</tr>
		
		<c:forEach items="${list}" var="pro" varStatus="vs">
		<tr style="background-color: ${vs.count % 2 == 0 ? 'gray':'' }">
			<td align="center">${pro.id}</td>
			<td align="center">${pro.productName}</td>
			<td align="center">
				<c:choose>
					<c:when test="${pro.dir_id == 1}">鼠标</c:when>
					<c:when test="${pro.dir_id == 2}">无线鼠标</c:when>
					<c:when test="${pro.dir_id == 3}">有线鼠标</c:when>
					<c:when test="${pro.dir_id == 4}">游戏鼠标</c:when>
				</c:choose>
			</td>
			<td align="center">${pro.salePrice}</td>
			<td align="center">${pro.supplier}</td>
			<td align="center">${pro.brand}</td>
			<td align="center">${pro.cutoff}</td>
			<td align="center">${pro.costPrice}</td>
			<td align="center">
				<a href="/product?cmd=delete&id=${pro.id}">删除</a>
				<a href="/product?cmd=edit&id=${pro.id}">编辑</a>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>