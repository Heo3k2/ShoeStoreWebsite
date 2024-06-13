<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>PHK shoes store</title>
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>

	<div align="center">
		<h3>This is the main content</h3>
		<h2 align="left" style="margin-left: 190px">New shoes</h2>
			<div align="center" style="width: 80%; margin: 0 auto;" >
				<c:forEach var="shoe" items="${listNewShoes}">
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
					<div>
						<jsp:directive.include file="shoe_rating.jsp" />
					</div>
					<div>From: ${shoe.brand}</div>
					<div><b>Price: $${shoe.shoePrice}</b></div>
				</div>
			</c:forEach>
	</div>
		
		<h2 align="left" style="margin-left: 190px">Top-Selling shoes</h2>
		<div align="center" style="width: 80%; margin: 0 auto;" >
				<c:forEach var="shoe" items="${listBestSellingShoes}">
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
					<div>
						<jsp:directive.include file="shoe_rating.jsp" />
					</div>
					<div>From: ${shoe.brand}</div>
					<div><b>Price: $${shoe.shoePrice}</b></div>
				</div>
			</c:forEach>
		</div>
		
		<h2 align="left" style="margin-left: 190px">Most-favorite Shoes</h2>
		<div align="center" style="width: 80%; margin: 0 auto;">
				<c:forEach var="shoe" items="${listMostFavoredShoes}">
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
					<div>
						<jsp:directive.include file="shoe_rating.jsp" />
					</div>
					<div>From: ${shoe.brand}</div>
					<div><b>Price: $${shoe.shoePrice}</b></div>
				</div>
			</c:forEach>
		</div>
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>