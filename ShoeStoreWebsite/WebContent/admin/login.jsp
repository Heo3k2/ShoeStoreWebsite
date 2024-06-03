<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Admin Login</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<div align="center">
		<h1>Shoe Store Administration</h1>
		<h2>Admin Login Page</h2>
		
		<c:if test="${message != null}">
			<div align="center" style="color: red;">
				<h4>${message}</h4>
			</div>
		</c:if>
		
		<form id="formLogin" action="login" method="post">
			<table>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" id="email" size="20"></td>
				</tr>
				
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="password" size="21"></td>
				</tr>
			
				<tr>
					<td colspan="2" align="center">
						<button type="submit">Login</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
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