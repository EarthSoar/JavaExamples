<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>购物车</h3>
	${SHOPPINGCART_IN_SESSION.items}
	<table border="1" cellpadding="0" cellspacing="0" >
		<tr>
			<td>商品名</td>
			<td>零售价</td>
			<td>购买数</td>
			<td>操作</td>
		</tr>
		<tr>
			<td>1</td>
			<td>1</td>
			<td>1</td>
			<td>1</td>
		</tr>
	</table>
</body>
</html>