<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
	
<a href="javascript:go(1);">首页</a>
<a href="javascript:go(${pageResult.prevPage});">上页</a>
<a href="javascript:go(${pageResult.nextPage});">下页</a>
<a href="javascript:go(${pageResult.totalPage});">末页</a>
当前第${pageResult.currentPage}/${pageResult.totalPage}页,
一共${pageResult.totalCount}条数据 跳转到
<input type="number" min="1" max="${pageResult.totalPage}"
	id="currentPage" value="${pageResult.currentPage}" style="width: 50px"
	name="qo.currentPage" />
页
<input type="button" value="GO" onclick="go();" />
每页
<s:select name="qo.pageSize" list="{3,5,10}" onchange="go(1);" />条