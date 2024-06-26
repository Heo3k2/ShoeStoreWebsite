<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title> My Order Details - PHK Shoestore </title>
	<style><%@include file="../css/style.css"%></style>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<c:if test="${order == null}">
		<div align="center">
			<h2 class="pageheading">Sorry! You are not authorized to view this order!</h2>
		</div>
	</c:if>
	
	
	<c:if test="${order != null}">
		<div align="center">
			<h2 class="pageheading"> Your Order ID: ${order.orderId} </h2>
		</div>
		
		<div align="center">
			<table>	
				<tr>
					<td><b>Order Status: </b></td>
					<td>${order.status}</td>
				</tr>
				<tr>
					<td><b>Order Date: </b></td>
					<td>${order.orderDate}</td>
				</tr>					
				<tr>
					<td><b>Quantity: </b></td>
					<td>${order.shoeAmount}</td>
				</tr>
				<tr>
					<td><b>Total Amount: </b></td>
					<td><fmt:formatNumber value="${order.orderSum}" type="currency" /></td>
				</tr>			
				<tr>
					<td><b>Recipient Name: </b></td>
					<td>${order.recipientName}</td>
				</tr>
				<tr>
					<td><b>Recipient Phone: </b></td>
					<td>${order.recipientPhone}</td>
				</tr>
				<tr>
					<td><b>Ship to: </b></td>
					<td>${order.toAddress}</td>
				</tr>	
				<tr>
					<td><b>Payment Method: </b></td>
					<td>${order.payment}</td>
				</tr>										
			</table>
		</div>
		<div align="center">
			<h2>Ordered Shoes</h2>
			<table border="1">
				<tr>
					<th>No</th>
					<th>Shoes</th>
					<th>Brand</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
				</tr>
				<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>
						<img style="vertical-align: middle;" src="data:image/jpg;base64,${orderDetail.shoe.base64Image}" width="48" height="64" />
						${orderDetail.shoe.shoeName}
					</td>
					<td>${orderDetail.shoe.brand}</td>
					<td><fmt:formatNumber value="${orderDetail.shoe.shoePrice}" type="currency" /></td>
					<td>${orderDetail.quantity}</td>
					<td><fmt:formatNumber value="${orderDetail.subTotal}" type="currency" /></td>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<b><i>TOTAL:</i></b>
					</td>
					<td>
						<b>${order.shoeAmount}</b>
					</td>
					<td>
						<b><fmt:formatNumber value="${order.orderSum}" type="currency" /></b>
					</td>
				</tr>
			</table>
		</div>
	</c:if>	
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>