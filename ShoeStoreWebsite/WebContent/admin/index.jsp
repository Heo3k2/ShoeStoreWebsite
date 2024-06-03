<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Shoe Store Administration</title>
	<link rel="stylesheet" href="../css/style.css">
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>Administrative Dashboard</h1>
		<hr width="70%">
	</div>
	
	<div align="center">
		<h1>Actions:</h1>
		<a href="createShoes">New shoes</a> &nbsp;
		<a href="createUser">New user</a> &nbsp;
		<a href="createType">New type of shoes</a> &nbsp;
		<a href="createCustomer">New customer</a> &nbsp;
		<hr width="70%">
	</div>
	
	<div align="center">
		<h2>Recent sales:</h2>
		<hr width="70%">
	</div>
	
	<div align="center">
		<h2>Recent rates:</h2>
		<hr width="70%">
	</div>
	
	<div align="center">
		<h2>Statistics:</h2>
		<hr width="70%">
	</div>
	
	<br><br><br><br>
	<jsp:directive.include file="footer.jsp"/>
</body>
</html>