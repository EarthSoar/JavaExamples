<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品编辑界面</title>
</head>
<body>
	<s:property value='fieldErrors["product.productName"][0]'/>
	<s:form namespace="/" action="product_save" theme="simple">
		<s:hidden name="product.id"/>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<td>货品分类</td>
				<td><s:textfield name="product.productName"/></td>
			</tr>
			<tr>
				<td>货品品牌</td>
				<td><s:textfield name="product.brand"/></td>
			</tr>
			<tr>
				<td>供&nbsp;应&nbsp;商</td>
				<td><s:textfield name="product.supplier"/></td>
			</tr>
			<tr>
				<td>零&nbsp;售&nbsp;价</td>
				<td><s:textfield name="product.salePrice"/></td>
			</tr>
			<tr>
				<td>成&nbsp;本&nbsp;价</td>
				<td><s:textfield name="product.costPrice"/></td>
			</tr>
			<tr>
				<td>折&emsp;&emsp;扣</td>
				<td><s:textfield name="product.cutoff"/></td>
			</tr>
			<tr>
				<td>货品分类</td>
				<td>
				<s:select name="product.dir_id" list="#dirs" listKey="id" listValue="dirName" headerKey="-1" headerValue="--请选择--"></s:select>
				</td>
			</tr>
			<tr>  
				<td colspan="2"><s:submit value="保存"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>