<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shoes of ${type.typeName} - PSK Shoe Store</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br>

	<div align="center">
		<h2>${type.typeName}</h2>
	</div>
	
	<div align="center" style="width: 80%; margin: 0 auto;">
		<c:forEach var="shoe" items="${listShoes}">
			<div style="float: left; display: inline-block; margin: 20px">
				<div>
					<a href="view_shoe?id=${shoe.shoeId}">
						<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
					</a>
				</div>
				<div style="font-size: 25px">
					<a href="view_shoe?id=${shoe.shoeId}">
						<b>${shoe.shoeName}</b>
					</a>
				</div>
				<div>
					<jsp:directive.include file="shoe_rating.jsp" />
				</div>
				<div>From: ${shoe.brand}</div>
				<div><b>Price: $${shoe.shoePrice}</b></div>
			</div>
		</c:forEach>
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>