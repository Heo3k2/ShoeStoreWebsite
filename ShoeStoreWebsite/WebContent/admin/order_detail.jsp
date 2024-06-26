<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Order Details </title>
<style><%@include file="../css/style.css"%></style>
<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Details of Orders ID: ${order.orderId} </h2>
	</div>
	
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	
	<div align="center">
		<h2>Order Overview</h2>
		<table>
			<tr>
				<td><b>Order By: </b></td>
				<td>${order.customer.fullName}</td>
			</tr>	
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
	<div align="center">
		</br>
		<a href="edit_order?id=${order.orderId}">Edit this Order</a>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<a href="">Delete this Order</a>
	</div>
	<jsp:directive.include file="footer.jsp"/>
	<script type="text/javascript">
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click", function(){
				reviewId = $(this).attr("id");
				if(confirm('Are you sure you want to delete review with ID ' + reviewId + ' ?')){
					window.location = 'delete_review?id=' + reviewId;
				}
			});
		});
	});
	</script>
</body>
</html>