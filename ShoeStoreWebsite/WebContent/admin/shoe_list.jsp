<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Managing Shoes</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Shoes Management</h1>
		<hr width="70%">
		<h3><a href="new_shoe">Create new Shoes</a></h3>
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
				<th>Image</th>
				<th>Shoes' name</th>
				<th>Brand</th>
				<th>Type of shoes</th>
				<th>Price</th>
				<th>Released date</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="shoe" items="${listShoes}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${shoe.shoeId}</td>
				
				<td>
					<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
				</td>
				
				<td>${shoe.shoeName}</td>
				<td>${shoe.brand}</td>
				<td>${shoe.type.typeName}</td>
				<td>$${shoe.shoePrice}</td>
				<td><f:formatDate pattern='dd/MM/yyyy' value='${shoe.releasedDate}'/></td>
				
				<td>
					<a href="edit_shoe?id=${shoe.shoeId}">Edit</a>	&nbsp;
					<a href="javascript:void(0)" class="deleteLink" id="${shoe.shoeId}">Delete</a> &nbsp;
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
				shoeId = $(this).attr("id");
				if(confirm("Are you sure you want to delete the shoe with shoe's id: " + shoeId + " ?")){
					window.location = "delete_shoe?id=" + shoeId;
				}
			})
		});
	});
</script>

</html>