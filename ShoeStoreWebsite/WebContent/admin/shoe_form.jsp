<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>
		<c:if test="${shoe != null}">
			Edit Shoes
		</c:if>
			
		<c:if test="${shoe == null}">
			Create New Shoes
		</c:if>
	
	</title>
	<link rel="stylesheet" href="../css/style.css">
	<link rel="stylesheet" href="../css/jquery-ui.min.css">
	<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="..//css/richtext.min.css">
	
	
	
	<script type="text/javascript" src="../js/jquery-3.7.1.min.js"></script>
	<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="..//js/jquery.richtext.min.js"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<br><br><br><br>
	
	<div align="center">
		<h1>
			<c:if test="${shoe != null}">
				Edit Shoes
			</c:if>
			
			<c:if test="${shoe == null}">
				Create New Shoes
			</c:if>
		</h1>
	</div>
		
	<div align="center">
		<c:if test="${shoe != null}">
			<form action="update_shoe" method="post" id="shoeForm" enctype="multipart/form-data">
			<input type="hidden" name="shoeId" value="${shoe.shoeId}"/>
			
		</c:if>
		
		<c:if test="${shoe == null}">
			<form action="create_shoe" method="post" id="shoeForm" enctype="multipart/form-data">
			
		</c:if>
		
		<table>
			<tr>
				<td align="left">Type</td>
				<td align="left">
					<select name="type">
						<c:forEach var="type" items="${listType}">
							<c:if test="${type.typeId eq shoe.type.typeId}">
								<option value="${type.typeId}" selected>
							</c:if>
							
							<c:if test="${type.typeId ne shoe.type.typeId}">
								<option value="${type.typeId}">
							</c:if>
								${type.typeName}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		
		
			<tr>
				<td align="left">Name of the shoes</td>
				<td align="left"><input type="text" id="shoeName" name="shoeName" size="20" value="${shoe.shoeName}"/></td>
			</tr>
			
			<tr>
				<td align="left">Brand</td>
				<td align="left"><input type="text" id="brand" name="brand" size="20" value="${shoe.brand}"/></td>
			</tr>
			
			<tr>
				<td align="left">Description</td>
				<td align="left">
					<textarea rows="5" cols="50" name="description" id="description">${shoe.description}</textarea>
				</td>
			</tr>
			
			<tr>
				<td align="left">Shoes' image</td>
				<td align="left">
					<input type="file" id="shoeImage" name="shoeImage" size="20"/><br>
					<img alt="Image Preview" id="thumbnail" style="margin-top: 10px; max-height: 300px; max-width: 300px" src="data:image/jpg;base64,${shoe.base64Image}"/>	
				</td>
			</tr>
			
			<tr>
				<td align="left">Price</td>
				<td align="left"><input type="text" id="shoePrice" name="shoePrice" size="20" value="${shoe.shoePrice}"/></td>
			</tr>
			
			<tr>
				<td align="left">Released Date</td>
				<td align="left"><input type="text" id="releasedDate" name="releasedDate" size="20" 
				value="<f:formatDate pattern='dd/MM/yyyy' value='${shoe.releasedDate}'/>" /></td>
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
		$("#releasedDate").datepicker();
		
		$("#description").richText();

		
		$("#shoeForm").validate({
			rules: {
				type: "required",
				shoeName: "required",
				brand: "required",
				description: "required",
				
				<c:if test="${shoe == null}">
					shoeImage: "required",
				</c:if>
				
				shoePrice: "required",
				releasedDate: "required",
			},
			
			messages: {
				type: "Please select a type",
				shoeName: "Please enter shoes' name",
				brand: "Please enter brand's name",
				description: "Please enter description",
				shoeImage: "Please add an image",
				shoePrice: "Please enter shoes' price",
				releasedDate: "Please enter the realeased date",
			}
		});
		
		
		$("#buttonCancel").click(function(){
			history.go(-1);
		});
		
 		$("#shoeImage").change(function(){
			showImageThumbnail(this);	
		}); 
		
	});
	
	function showImageThumbnail(fileInput){
		var file = fileInput.files[0];
		
		var reader = new FileReader();
		
		reader.onload = function(e){
			$("#thumbnail").attr("src", e.target.result);
		};
		
		reader.readAsDataURL(file);
	}; 
	
</script>
</html>