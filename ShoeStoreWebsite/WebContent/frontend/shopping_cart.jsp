<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shopping Cart</title>
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<h2>Your Shopping Cart Details</h2>
		
		<c:if test="${message != null}">
			<div align="center" style="color: red;">
				<h4>${message}</h4>
			</div>
		</c:if>
		
		<c:set var="cart" value="${sessionScope['cart']}" />
		
		<c:if test="${cart.totalItems == 0}">
			<h2>There's no items in your cart</h2>
		</c:if>
		
		<c:if test="${cart.totalItems > 0}">
			<div>
				<form>
					<table border="1">
						<tr>
							<th>No</th>
							<th colspan="2">Shoe</th>
							<th>Quantity</th>
							<th>Price</th>
							<th>Subtotal</th>
							<th>
								<a href=""><b>Clear Cart</b></a>
							</th>
						</tr>
						<c:forEach items="${cart.items}" var="item" varStatus="status">
						<tr>
							<td>${status.index + 1}</td>
							<td><img src="data:image/jpg;base64,${item.key.base64Image}" width="250" height="240"/></td>
							<td>
								${item.key.shoeName}
							</td>
							<td>${item.value}</td>
							<td><fmt:formatNumber value="${item.key.shoePrice}" type="currency"></fmt:formatNumber></td>
							<td><fmt:formatNumber value="${item.value * item.key.shoePrice}" type="currency"></fmt:formatNumber></td>
							<td><a href= "">Remove</a></td>
						</tr>
						</c:forEach>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td><b>${cart.totalQuantity} shoe(s)</b></td>
							<td>Total:</td>
							<td colspan="2"><b><fmt:formatNumber value="${cart.totalAmount}" type="currency"></fmt:formatNumber></b></td>
						</tr>
					</table>
				</form>
			</div>
		</c:if>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	
	$(document).ready(function(){
		$("#formLogin").validate({
			rules: {
				email: {
					required: true,
					email: true,
				},
				password: "required",
			},
			
			messages: {
				email: {
					required: "Please enter the email",
					email: "Please enter a valid email",
				},
				password: "Please enter password",
			}
		});
	});
</script>
</html>