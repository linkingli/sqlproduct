<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h3>查询商品</h3>
		<a href="${pageContext.request.contextPath}/findAll">查询商品</a>
		<h3>添加商品</h3>
		<a href="${pageContext.request.contextPath}/jsp/addProduct.jsp">添加商品</a>
		<h3>分页查询</h3>
		<a href="${pageContext.request.contextPath}/search?currentpage=1">查询商品</a>
</body>
</html>