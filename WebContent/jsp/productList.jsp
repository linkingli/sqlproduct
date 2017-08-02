<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1" width="90%">
		<tr>
			<td><input type="button" onclick="deleteAll()" value="删除选中"></td>
		</tr>
		<tr>
			<td><input type="checkbox" onclick="seletAll(this)"></td>
			<td>唯一标识</td>
			<td>名称</td>
			<td>市场价</td>
			<td>超市价</td>
			<td>图片</td>
			<td>日期</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		<form id="formId" method="post" action="${pageContext.request.contextPath}/DeleteAll">
		
			<c:forEach items="${plist}" var="p">
				<tr>
					<td><input type="checkbox" name="pid" value="${p.pid}"></td>
					<td >${p.pid}</td>
					<td>${p.pname}</td>
					<td>${p.market_price}</td>
					<td>${p.shop_price}</td>
					<td >
						<img src="${pageContext.request.contextPath}/${p.pimage}" width="120" height="120">
					</td>
					<td>${p.pdate}</td>
					<td>${p.pdesc}</td>
					<td width="15%">
					<a href="${pageContext.request.contextPath}/Find?pid=${p.pid}">修改</a>
					|
					<a href="javascript:void(0)" onclick="deleteByid('${p.pid}')">删除</a>
					</td>
				</tr>
			</c:forEach>
		</form>
	</table>

</body>
<script type="text/javascript">
	function deleteByid(pid) {
		if(confirm("你真舍得丢弃我吗?")){
			//发送请求
			location.href="${pageContext.request.contextPath}/Delete?pid="+pid;
		}
	}
	
	function seletAll(obj) {
		//获取所有的复选框
		var arr=document.getElementsByName("pid");
		
		//遍历数组 修改选中状态
		for(var i=0;i<arr.length;i++){
			arr[i].checked=obj.checked;
			//checked：复选框
		}
		
	}
	
	function deleteAll() {
		//提交表单
		document.getElementById("formId").submit();
	}
</script>
</body>
</html>