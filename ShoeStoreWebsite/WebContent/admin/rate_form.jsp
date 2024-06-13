<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
			Edit Rate
	</title>
	<link rel="stylesheet" href="../css/style.css">
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>
				Edit Rate
		</h1>
	</div>
		
	<div align="center">
		<form action="update_rate" method="post" id="rateForm">
		<input type="hidden" name="rateId" value="${rate.rateId}">
		
		<table>
			<tr>
				<td align="left">Shoe:</td>
				<td align="right"><b>${rate.shoe.shoeName}</b></td>
			</tr>
			<tr>
				<td align="left">Rating Star:</td>
				<td align="right"><b>${rate.ratingStars}</b></td>
			</tr>
			<tr>
				<td align="left">Customer:</td>
				<td align="right"><b>${rate.customer.fullName}</b></td>
			</tr>
			<tr>
				<td align="left">Headline:</td>
				<td align="right"><input type="text" size="60" name="headline" value="${rate.headline}"/></td>
			</tr> 
			<tr>
				<td align="left">Rating Detail:</td>
				<td align="right"><textarea rows="5" cols="70" name="ratingDetail">${rate.ratingDetail}</textarea></td>
			</tr> 
			<tr><td>&nbsp;</td></tr>
				
			<tr>
				<td colspan="2" align="center">
					<button type = "submit">Save</button>
					<input type="button" id="buttonCancel" value="Cancel"/>
				</td>
			</tr>
		</table>
	</div>
	
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#rateForm").validate({
			rules: {
				headline: "required",
				ratingDetail: "required"
			},
			
			messages: {
				headline: "Please enter headline",
				ratingDetail: "Please enter Rating Detail"
			}
		});
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
	});
</script>
</html>