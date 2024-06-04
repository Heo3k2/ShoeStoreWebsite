<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${shoe.shoeName} - PHK shoes store</title>
	<link rel="stylesheet" href="css/style.css">
	
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>

	<div align="center">
		<table width="60%" border="0">
			<tr>
				<td>
					<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
				</td>
				
				<td>
					<h2>${shoe.shoeName}</h2><br>
					From: ${shoe.brand}
					<h2><jsp:directive.include file="shoe_rating.jsp" /></h2>
					<a href="#rates">${fn:length(shoe.rates)} Rates</a>
					<h2>Price: $${shoe.shoePrice}</h2>
					<button type="submit">Add to your cart</button>
				</td>
			</tr>
		</table>
		
		
		<br><br><br><br>
		<div>
			<h2>Shoes' Description</h2>
			${shoe.description}
		</div>
		
		<br><br><br><br>
		<div>
			<h2><a id="rates">Customer's Rates</a></h2>
			<button id="buttonWriteRate">Rate shoes now</button>
			<table border="0">
				<c:forEach items="${shoe.rates}" var="rate">
					<tr>
						<td>
							<c:forTokens items="${rate.stars}" delims="," var="star">
								<c:if test="${star eq 'on'}">
									<img src="images/rating_on.png">
								</c:if>
								<c:if test="${star eq 'off'}">
									<img src="images/rating_off.png">
								</c:if>
							</c:forTokens>
							<b> - ${rate.ratingDetail}</b>
						</td>
					</tr>
					<tr>
						<td>by ${rate.customer.fullName} on ${rate.rateTime}</td>
					</tr>
					<tr><td><i>${rate.ratingDetail}</i></td></tr>
					<tr><td>&nbsp;</td></tr>
				</c:forEach>	
			</table>
		</div>
		
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#buttonWriteRate").click(function() {
				window.location = 'write_rate?shoe_id=' + ${shoe.shoeId};
			});
		})
	</script>
</body>
</html>