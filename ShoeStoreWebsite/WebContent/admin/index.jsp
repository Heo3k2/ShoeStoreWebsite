<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shoe Store Administration</title>
	<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Administrative Dashboard</h1>
		<hr width="70%">
	</div>
	
	<div align="center">
		<h1>Quick Actions:</h1>
		<a href="new_shoe">New shoes</a> &nbsp;
		<a href="user_form.jsp">New user</a> &nbsp;
		<a href="type_form.jsp">New type of shoes</a> &nbsp;
		<a href="customer_form.jsp">New customer</a> &nbsp;
		<hr width="70%">
	</div>
	
	<div align="center">
		<h2>Recent sales:</h2>
		<table border="1">
			<tr>
				<th>Order ID</th>
				<th>Ordered By</th>
				<th>Shoes Amount</th>
				<th>Total</th>
				<th>Payment Method</th>
				<th>Status</th>
				<th>Order Date</th>
			</tr>
			<c:forEach items="${listMostRecentSales}" var="order" varStatus="status">
			<tr>
				<td><a href="view_order?id=${order.orderId}">${order.orderId}</a></td>
				<td>${order.customer.fullName}</td>
				<td>${order.shoeAmount}</td>
				<td><fmt:formatNumber value="${order.orderSum}" type="currency" /></td>
				<td>${order.payment}</td>
				<td>${order.status}</td>
				<td>${order.orderDate}</td>
			</tr>
			</c:forEach>
		</table>
	<hr width="70%">	

	</div>
	
	<div align="center">
		<h2>Recent rates:</h2>
		<hr width="70%">
		<table border="1">
			<tr>
				<th>Shoes</th>
				<th>Rating</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Review On</th>
			</tr>
			<c:forEach items="${listMostRecent}" var="rate">
			<tr>
				<td>${rate.shoe.shoeName}</td>
				<td>${rate.ratingStars}</td>
				<td><a href="edit_review?id=${rate.rateId}">${rate.headline}</a></td>
				<td>${rate.customer.fullName}</td>
				<td>${rate.rateTime}</td>
			</tr>
			</c:forEach>
		</table>
		
	</div>
	
	<div align="center">
		<h2>Statistics:</h2>
			Total Users: ${totalUsers} &nbsp;&nbsp;&nbsp;&nbsp;
			Total Shoes: ${totalBooks} &nbsp;&nbsp;&nbsp;&nbsp;
			Total Customers: ${totalCustomers} &nbsp;&nbsp;&nbsp;&nbsp;
			Total Rates: ${totalRates} &nbsp;&nbsp;&nbsp;&nbsp;
			Total Orders: ${totalOrders}
		
		<hr width="70%">
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>