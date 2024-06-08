<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Edit Order Details - PHK Shoestore </title>
<style><%@include file="../css/style.css"%></style>
<script src="<c:url value="../js/jquery-3.7.0.min.js" />"></script>
<script src="<c:url value="../js/jquery.validate.min.js" />"></script>
</head>
<body>
	<jsp:directive.include file="header.jsp"/>
	<div align="center">
		<h2 class="pageheading"> Edit Order ID: ${order.orderId} </h2>
	</div>
	
	<c:if test="${message != null}">
		<div align="center">
			<h4 class="message">${message}</h4>
		</div>
	</c:if>
	<form action="update_order" method="post" id="orderForm">
	
	
		<div align="center">
			<table>
				<tr>
					<td><b>Order By: </b></td>
					<td>${order.customer.fullName}</td>
				</tr>			
				<tr>
					<td><b>Order Date: </b></td>
					<td>${order.orderDate}</td>
				</tr>
				<tr>
					<td><b>Recipient Name: </b></td>
					<td><input type="text" name="recipientName" value="${order.recipientName}" size="45"/></td>
				</tr>
				<tr>
					<td><b>Recipient Phone: </b></td>
					<td><input type="text" name="recipientPhone" value="${order.recipientPhone}" size="45"/></td>
				</tr>			
				<tr>
					<td><b>Ship To: </b></td>
					<td><input type="text" name="shippingAddress" value="${order.toAddress}" size="45"/></td>
				</tr>
				<tr>
					<td><b>Payment Method: </b></td>
					<td>
						<select name="paymentMethod">
							<option value="Cash On Delivery">Cash On Delivery</option>
						</select>
					</td>
				</tr>
				<tr>
					<td><b>Order Status: </b></td>
					<td>
					<select name="orderStatus">
						<option value="Processing" <c:if test="${order.status eq 'Processing' }">selected='selected'</c:if> >Processing</option>
						<option value="Shipping" <c:if test="${order.status eq 'Shipping' }">selected='selected'</c:if>>Shipping</option>
						<option value="Delivered" <c:if test="${order.status eq 'Delivered' }">selected='selected'</c:if>>Delivered</option>
						<option value="Completed" <c:if test="${order.status eq 'Completed' }">selected='selected'</c:if>>Completed</option>
						<option value="Cancelled" <c:if test="${order.status eq 'Cancelled' }">selected='selected'</c:if>>Cancelled</option>
					</select>
				</td>
				</tr>																
			</table>
		</div>
		<div align="center">
			<h2>Ordered Shoes</h2>
			<table border="1">
				<tr>
					<th>Index</th>
					<th>Shoe's Name</th>
					<th>Brand</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Subtotal</th>
					<th></th>
				</tr>
				<c:forEach items="${order.orderDetails}" var="orderDetail" varStatus="status">
				<tr>
					<tr>
				<td>${status.index + 1}</td>
				<td>${orderDetail.shoe.shoeName}</td>
				<td>${orderDetail.shoe.brand}</td>
				<td>
					<input type="hidden" name="price" value="${orderDetail.shoe.shoePrice}" />
					<fmt:formatNumber value="${orderDetail.shoe.shoePrice}" type="currency" />
				</td>
				<td>
					<input type="hidden" name="shoeId" value="${orderDetail.shoe.shoeId}" />
					<input type="text" name="quantity${status.index + 1}" value="${orderDetail.quantity}" size="5" />
				</td>
				
				<td><fmt:formatNumber value="${orderDetail.subTotal}" type="currency" /></td>
				<td><a href="remove_shoes_from_order?id=${orderDetail.shoe.shoeId}">Remove</a></td>
			</tr>
				</tr>
				</c:forEach>
				<tr>
					<td colspan="4" align="right">
						<b><i>TOTAL:</i></b>
					</td>
					<td>
						<b>${order.shoeAmount}</b>
					</td>
					<td>
						<b><fmt:formatNumber value="${order.orderSum}" type="currency" /></b>
					</td>
					<td></td>
				</tr>
			</table>
		</div>	
		<div align="center">
			</br>
			<a href="javascript:showAddShoesPopup()">Add Shoes</a>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="submit" value="Save"/>
			&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
			<input type="button" value="Cancel" onclick="javascript:window.location.href='list_orders';"/>
		</div>
	
	</form>	
	
	<jsp:directive.include file="footer.jsp"/>
	
	<script>
		function showAddShoesPopup() {
			var width = 600;
			var height = 250;
			var left = (screen.width - width) / 2;
			var top = (screen.height - height) / 2;
			
			window.open('add_shoes_form', '_blank', 
					'width=' + width + ', height=' + height + ', top=' + top + ', left=' + left);
		}
		
		$(document).ready(function() {
			$("#orderForm").validate({
				rules: {	
					recipientName: "required",
					recipientPhone: "required",
					shippingAddress: "required",
					
					<c:forEach items="${order.orderDetails}" var="shoe" varStatus="status">
						quantity${status.index + 1}: {
							required: true, number: true, min: 1
						},
					</c:forEach>					
				},
				
				messages: {
					recipientName: "Please enter recipient name",
					recipientPhone: "Please enter recipient phone",
					shippingAddress: "Please enter shipping address",
					
					<c:forEach items="${order.orderDetails}" var="shoe" varStatus="status">
						quantity${status.index + 1}: { 
							required: "Please enter quantity",
							number: "Quantity must be a number",
							min: "Quantity must be greater than 0"
						},
					</c:forEach>						
				}
			});
			
		});		
	</script>
</body>
</html>