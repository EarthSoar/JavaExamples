<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品显示列表</title>
</head>
<body>
	<s:a  namespace="/" action="product_input">
		添加商品
	</s:a>
	<table border="1" cellpadding="0" cellspacing="0" width="90%">
		<tr>
			<th>货品编号</th>
			<th>货品名称</th>
			<th>货品品牌</th>
			<th>货品分类</th>
			<th>供&nbsp;应&nbsp;商</th>
			<th>零&nbsp;售&nbsp;价</th>
			<th>成&nbsp;本&nbsp;价</th>
			<th>折&emsp;&emsp;扣</th>
			<th>操&emsp;&emsp;作</th>
		</tr>
		<s:iterator value="#list">
		<tr>
			<td><s:property value="id"/></td>
			<td><s:property value="productName"/></td>
			<td><s:property value="brand"/></td>
			<td><s:property value="dir_id"/></td>
			<td><s:property value="supplier"/></td>
			<td><s:property value="salePrice"/></td>
			<td><s:property value="costPrice"/></td>
			<td><s:property value="cutoff"/></td>
			<td>
				<a href="">编辑</a> |
				<a href="">删除</a> 
			</td>
		</tr>	
		</s:iterator>
	</table>
</body>
</html>