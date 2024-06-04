<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write Rate - PKH Shoe Store</title>
	<link rel="stylesheet" href="css/style.css">
	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<form>
			<table class="normal">
			 	<tr>
			 		<td><h2>Your Rates</h2></td>
			 		<td><h2>${loggedCustomer.fullName}</h2></td>
			 	</tr>
			</table>
		</form>
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