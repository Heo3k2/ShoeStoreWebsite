<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Managing Customer</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Customer Management</h1>
		<hr width="70%">
		<h3><a href="customer_form.jsp">Create new Customer</a></h3>
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
				<th>ID</th>
				<th>E-mail</th>
				<th>Full Name</th>
				<th>City</th>
				<th>Country</th>
				<th>Registered date</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="customer" items="${listCustomer}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${customer.customerId}</td>
				<td>${customer.email}</td>
				<td>${customer.fullName}</td>
				<td>${customer.city}</td>
				<td>${customer.country}</td>
				<td>${customer.signUpDate}</td>
				<td>
					<a href="edit_customer?id=${customer.customerId}">Edit</a>	&nbsp;
					<a href="javascript:void(0);" class="deleteLink" id="${customer.customerId}">Delete</a> &nbsp;
				</td>
			</tr>
			</c:forEach>
			
		</table>
	</div>
	
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script>
	$(document).ready(function(){
		$(".deleteLink").each(function(){
			$(this).on("click", function(){
				customerId = $(this).attr("id");
				if(confirm("Are you sure you want to delete the customer with customer's id: " + customerId + " ?")){
					window.location = "delete_customer?id=" + customerId;
				}
			})
		});
	});
</script>

</html>