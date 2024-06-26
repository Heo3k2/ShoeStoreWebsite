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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	
	<div align="center">
		<form id="rateForm" action="submit_rate" method="post">
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
			 		<td>
			 			<div id="rateYo"></div>
			 			<input type="hidden" id="rating" name="rating"/>
			 			<input type="hidden" name="shoeId" value="${shoe.shoeId}"/>
			 			<br/> 
			 			<input type="text" name="headline" size="60" placeholder="Headline or summary for your rate (required)" />
			 			<br/>
			 			<br/>
			 			<textarea name="comment" rows="10" cols="70" placeholder="Write your review details..."></textarea>
			 		</td>
			 	</tr>
			 	<tr>
			 		<td colspan="3" align="center">
			 			<button type="submit">Submit</button>
			 			&nbsp;&nbsp;
			 			<button id="buttonCancel">Cancel</button>
			 		</td>
			 	</tr>
			</table>
		</form>
	</div>
	
	<jsp:directive.include file="footer.jsp"/>
</body>
<script type="text/javascript">

	$("#buttonCancel").click(function(){
		history.go(-1);
	});
	
	$(document).ready(function(){
		$("#rateForm").validate({
			rules: {
				headline: "required",
				comment: "required"
			},
			
			messages: {
				headline: "Please enter headline",
				comment: "Please enter rate details"
			}
		});
			
		$("#rateYo").rateYo({
		    starWidth: "40px",
		    fullStar: true,
		    onSet: function (rating, rateYoInstance) {
		    	$("#rating").val(rating);
		    }
		  });
		
	});
</script>
</html>