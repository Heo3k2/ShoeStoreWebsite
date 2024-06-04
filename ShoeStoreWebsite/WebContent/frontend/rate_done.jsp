<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Rate Posted - PKH Shoe Store</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
			<table class="normal" width="60%">
			 	<tr>
			 		<td><h2>Your Rates</h2></td>
			 		<td>&nbsp;</td>
			 		<td><h2>${loggedCustomer.fullName}</h2></td>
			 	</tr>
			 	<tr>
			 		<td colspan ="3"><hr/></td>
			 	</tr>
			 	<tr>
			 		<td>
				 		<h2>${shoe.shoeName}</h2><br>
				 		<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
			 		</td>
			 		<td colspan="2">
						<h3>Your rate has been posted. Thank you!</h3>
			 		</td>
			 	</tr>
			</table>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>

</html>