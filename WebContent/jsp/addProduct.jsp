<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/Add" method="post">
	商品名称:<input type="text" name="pname"><br>
	市场价格:<input type="text" name="market_price"><br>
	商城价:<input type="text" name="shop_price"><br>
	描述:<input type="text" name="pdesc"><br>
	<input type="submit" value="确认">
</form>


</body>
</html>