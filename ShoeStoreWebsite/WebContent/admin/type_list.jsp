<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Managing Types</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Types Management</h1>
		<hr width="70%">
		<h3><a href="type_form.jsp">Create new Type</a></h3>
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
				<th>Type Name</th>
				<th>Actions</th>
			</tr>
			
			<c:forEach var="type" items="${listType}" varStatus="status">
			<tr>
				<td>${status.index + 1}</td>
				<td>${type.typeId}</td>
				<td>${type.typeName}</td>
				<td>
					<a href="edit_type?id=${type.typeId}">Edit</a>	&nbsp;
					<a href="javascript:void(0)" class="deleteLink" id="${type.typeId}">Delete</a> &nbsp;
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
				typeId = $(this).attr("id");
				if(confirm("Are you sure you want to delete the type with type's id: " + typeId + " ?")){
					window.location = "delete_type?id=" + typeId;
				}
			})
		});
	});
</script>

</html>