<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Managing Rates</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Rates Management</h1>
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
				<th>ID</th>
				<th>Shoe</th>
				<th>Rating Stars</th>
				<th>Headline</th>
				<th>Customer</th>
				<th>Rating Detail</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var="rate" items="${listRates}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${rate.rateId}</td>
				<td>${rate.shoe.shoeName}</td>
				<td>${rate.ratingStars}</td>
				<td>${rate.headline}</td>
				<td>${rate.customer.fullName}</td>
				<td>${rate.ratingDetail}</td>
				<td>
					<a href="edit_rate?id=${rate.rateId}">Edit</a>	&nbsp;
					<a href="javascript:void(0)" class="deleteLink" id="${rate.rateId}">Delete</a> &nbsp;
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
				rateId = $(this).attr("id");
				if(confirm("Are you sure you want to delete the rate with rate's id: " + rateId + " ?")){
					window.location = "delete_rate?id=" + rateId;
				}
			})
		});
	});
</script>

</html>