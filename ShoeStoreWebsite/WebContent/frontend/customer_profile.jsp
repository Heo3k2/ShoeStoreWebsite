<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Customer Profile - PHK shoes store</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<br/>
		<h2>Welcome, ${loggedCustomer.fullName}</h2>
		<hr width="70%">
		<br/>
		
		<table class = "customer">
			<tr>
				<td><b>E-mail Address:</b></td>
				<td>${loggedCustomer.email}</td>
			</tr>
			<tr>
				<td><b>Full Name:</b></td>
				<td>${loggedCustomer.fullName}</td>
			</tr>
			<tr>
				<td><b>Phone Number:</b></td>
				<td>${loggedCustomer.phoneNumber}</td>
			</tr>
			<tr>
				<td><b>Address:</b></td>
				<td>${loggedCustomer.address}</td>
			</tr>
			<tr>
				<td><b>City:</b></td>
				<td>${loggedCustomer.city}</td>
			</tr>
			<tr>
				<td><b>Zip Code:</b></td>
				<td>${loggedCustomer.zip}</td>
			</tr>
			<tr>
				<td><b>Country:</b></td>
				<td>${loggedCustomer.country}</td>
			</tr>
			<tr><td>&nbsp;</td></tr>
			<tr>
				<td colspan="2" align="center"><b><a href="edit_profile">Edit My Profile</a></b></td>
			</tr>
		</table>
	</div>

	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>