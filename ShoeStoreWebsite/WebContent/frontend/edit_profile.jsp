<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<c:if test="${customer != null}">
			Edit My Profile
		</c:if>
	
	</title>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/jquery-ui.min.css">

	<script type="text/javascript" src="js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>
			Edit My Profile
		</h1>
	</div>
		
	<div align="center">

		<form action="update_profile" method="post" id="customerForm">
	
		
		<table>		
			<tr>
				<td align="left">Email:</td>
				<td align="left"><b>${loggedCustomer.email }</b>(Cannot be changed)</td>
			</tr>
			
			<tr>
				<td align="left">Full Name:</td>
				<td align="left"><input type="text" id="fullName" name="fullName" size="45" value="${loggedCustomer.fullName }"/></td>
			</tr>
						
			<tr>
				<td align="left">Phone Number:</td>
				<td align="left"><input type="text" id="phone" name="phone" size="45" value="${loggedCustomer.phoneNumber }"/></td>
			</tr>
			
			<tr>
				<td align="left">Address:</td>
				<td align="left"><input type="text" id="address" name="address" size="45" value="${loggedCustomer.address }"/></td>
			</tr>
			
			<tr>
				<td align="left">City:</td>
				<td align="left"><input type="text" id="city" name="city" size="45" value="${loggedCustomer.city }"/></td>
			</tr>
			
			<tr>
				<td align="left">Zip Code:</td>
				<td align="left"><input type="text" id="zipCode" name="zipCode" size="45" value="${loggedCustomer.zip }"/></td>
			</tr>
			
			<tr>
				<td align="left">Country:</td>
				<td align="left"><input type="text" id="country" name="country" size="45" value="${loggedCustomer.country }"/></td>
			</tr>			
			
			<tr>
				<td colspan="2">
					<i>(Leave password fields blank if you don't want to change password)</i>
				</td>
			</tr>	
						
			<tr>
				<td align="left">Password:</td>
				<td align="left"><input type="password" id="password" name="password" size="45"/></td>
			</tr>
			
			<tr>
				<td align="left">Confirm Password:</td>
				<td align="left"><input type="password" id="confirmPassword" name="confirmPassword" size="45"/></td>
			</tr>	
			
			<tr><td>&nbsp;</td></tr>
				
			<tr>
				<td colspan="2" align="center">
					<button type = "submit">Save</button>
					<button id="buttonCancel">Cancel</button>
				</td>
			</tr>
		</table>
	</div>
	
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#customerForm").validate({
			rules: {
				email: {
					required: true,
					email: true
				},
				fullName: "required",
				confirmPassword: {
					equalTo: "#password"
				},
				phone: "required",
				address: "required",
				city: "required",
				zipCode: "required",
				country: "required",
			},
			
			messages: {
				email: {
					required: "Please enter e-mail address",
					email: "Please enter a valid e-mail address"
				},
				fullName: "Please enter full name",
				confirmPassword: {
					equalTo: "Confirm password does not match password"
				},
				phone: "Please enter phone number",
				address: "Please enter address",
				city: "Please enter city",
				zipCode: "Please enter zipcode",
				country: "Please enter country",
			}
		});
		
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
		
	});
	
</script>
</html>