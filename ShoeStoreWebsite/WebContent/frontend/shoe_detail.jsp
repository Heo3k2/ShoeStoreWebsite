<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${shoe.shoeName} - PHK shoes store</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>

	<div align="center">
		<table width="60%" border="0">
			<tr>
				<td>
					<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
				</td>
				
				<td>
					<h2>${shoe.shoeName}</h2><br>
					From: ${shoe.brand}
					<h2>Rating *****</h2>
					<h2>Price: $${shoe.shoePrice}</h2>
					<button type="submit">Add to your cart</button>
				</td>
			</tr>
		</table>
		
		
		<br><br><br><br>
		<div>
			<h2>Shoes' Description</h2>
			${shoe.description}
		</div>
		
		<br><br><br><br>
		<div>
			<h2>Customer's Rate</h2>
			<button>Rate our shoes</button>
		</div>
		
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>