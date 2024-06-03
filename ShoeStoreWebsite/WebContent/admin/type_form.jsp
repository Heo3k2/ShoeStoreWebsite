<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<c:if test="${type != null}">
			Edit
		</c:if>
				
		<c:if test="${type == null}">
			Create
		</c:if>
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
			<c:if test="${type != null}">
				Edit Type
			</c:if>
			
			<c:if test="${type == null}">
				Create New Type
			</c:if>
		</h1>
	</div>
		
	<div align="center">
		<c:if test="${type != null}">
			<form action="update_type" method="post" id="listForm">
			<input type="hidden" name="typeId" value="${type.typeId}">
			
		</c:if>
		
		<c:if test="${type == null}">
			<form action="create_type" method="post" id="listForm">
			
		</c:if>
		
		<table>
			<tr>
				<td align="left">Name's type:</td>
				<td align="right"><input type="text" id="typeName" name="typeName" size="20" value="${type.typeName}"/></td>
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
		$("#listForm").validate({
			rules: {
				typeName: "required"

			},
			
			messages: {
				typeName: "Please enter the name's type"
			}
		});
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
	});
</script>
</html>