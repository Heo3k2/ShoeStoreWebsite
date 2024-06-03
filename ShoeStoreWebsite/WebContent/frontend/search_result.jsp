<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fnc" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Search results for ${keyword} - PHK Shoe Store</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>

	<div align="center">
		<c:if test="${fnc:length(result) == 0}">
			<h2>We are sorry but there is nothing for the keyword ${keyword}</h2>
		</c:if>
		
		<c:if test="${fnc:length(result) > 0}">
			<div align="center" style="width: 80%; margin: 0 auto;">
				<h2>Results for "${keyword}"</h2>
				<c:forEach var="shoe" items="${result}">
					<div style="display: inline-block; margin: 20px">
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
						<div><b>Rating *****</b></div>
						<div>From: ${shoe.brand}</div>
						<div><b>Price: $${shoe.shoePrice}</b></div>
					</div>
				</c:forEach>
			</div>
		</c:if>
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>