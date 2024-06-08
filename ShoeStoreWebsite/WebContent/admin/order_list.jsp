<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Managing Orders</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Shoe Orders Management</h1>
		<hr width="70%">
	</div>
	
	<c:if test="${message != null}">
		<div align="center" style="color: red;">
			<h4>${message}</h4>
		</div>
	</c:if>
		
	<div align="center">
		<table border="1" cellpadding="5">
			<tr>
				<th>Index</th>
				<th>Order ID</th>
				<th>Order by</th>
				<th>Shoe amount</th>
				<th>Total</th>
				<th>Payment method</th>
				<th>Status</th>
				<th>Order Date</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="order" items="${listOrder}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${order.orderId}</td>
				<td>${order.customer.fullName}</td>
				<td>${order.shoeAmount}</td> 
				<td><fmt:formatNumber value="${order.orderSum}" type="currency" /></td>
				<td>${order.payment}</td>
				<td>${order.status}</td>
				<td>${order.orderDate}</td>
				<td>
					<a href="view_order?id=${order.orderId}">Details</a> &nbsp;
					<a href="edit_order?id=${order.orderId}">Edit</a> &nbsp;
					<a href="javascript:void(0)" class="deleteLink" id="${order.orderId}">Delete</a> &nbsp;
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
	
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script>
		$(document).ready(function() {
			$(".deleteLink").each(function() {
				$(this).on("click", function() {
					orderId = $(this).attr("id");
					if (confirm('Are you sure you want to delete the order with ID ' +  orderId + '?')) {
						window.location = 'delete_order?id=' + orderId;
					}					
				});
			});
		});	
</script>

</html>