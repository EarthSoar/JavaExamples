<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>货品显示列表</title>
</head>
	<script type="text/javascript">
		function go(pageNo){
			//把需要跳转的页码设置到<input type="number" name="currentPage"/>上
			if(pageNo){
				document.getElementById("currentPage").value = pageNo;
			}
			//提交表单
			document.forms[0].submit();
		}
	</script>
<body>
	<s:a  namespace="/" action="product_input">
		添加商品
	</s:a>
	<s:form namespace="/" action="product">
		名称:<s:textfield name="qo.productName" theme="simple"/>
		价格:<s:textfield name="qo.minSalePrice"/>--<s:textfield name="qo.maxSalePrice"/>
		商品分类:<s:select name="qo.dirId" list="#dirs" listKey="id" listValue="dirName" headerKey="-1" headerValue="所有商品"/>
		关键字:<s:textfield name="qo.keyword"/>
		<s:submit value="查询"/>
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
		<s:iterator value="#pageResult.listData">
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
				<s:a namespace="/" action="product_input">
					<s:param name="product.id" value="id"/>
					编辑
				</s:a>
				<s:a namespace="/" action="product_delete">
					<s:param name="product.id" value="id"/>
					删除
				</s:a>
			</td>
		</tr>	
		</s:iterator>
		 <tr>
			<td colspan="9">
				<a href="javascript:go(1);">首页</a>
				<a href="javascript:go(${pageResult.prevPage});">上页</a>
				<a href="javascript:go(${pageResult.nextPage});">下页</a>
				<a href="javascript:go(${pageResult.totalPage});">末页</a>
				当前第${pageResult.currentPage}/${pageResult.totalPage}页,
				一共${pageResult.totalCount}条数据
				
				跳转到<input type="number" min="1" max="${pageResult.totalPage}" id="currentPage" value="${pageResult.currentPage}" 
					style="width: 50px" name="qo.currentPage"/> 页
				<input type="button" value="GO" onclick="go();"/>
				每页<s:select name="qo.pageSize" list="{3,5,10}" onchange="go(1);"/>
			</td>
		</tr>
	</table>
	</s:form>
</body>
</html>