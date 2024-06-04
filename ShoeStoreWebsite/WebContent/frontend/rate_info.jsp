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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<form id="rateForm">
			<table class="normal" width="60%">
			 	<tr>
			 		<td><h3>You already wrote a rate for this shoe!</h3></td>
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
			 		<td>
			 			<div id="rateYo"></div>
			 			<br/> 
			 			<input type="text" name="headline" size="60" readonly="readonly" value="${rate.headline}"/>
			 			<br/>
			 			<br/>
			 			<textarea name="comment" rows="10" cols="70" readonly="readonly">${rate.ratingDetail}</textarea>
			 		</td>
			 	</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">
	$(document).ready(function(){
			
		$("#rateYo").rateYo({
		    starWidth: "40px",
		    fullStar: true,
		    rating: ${rate.ratingStars},
		    readOnly: true
		  });
		
	});
</script>
</html>