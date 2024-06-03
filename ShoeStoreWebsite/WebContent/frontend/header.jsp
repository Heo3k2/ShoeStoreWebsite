<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div align="left">
	<table>
		<tr>
			<td>
				<a href = "${pageContext.request.contextPath}">
					<img src="images/sport-shoes-icon-vector-id121242.png" style="max-height: 250px; max-width: 250px;">
				</a>
			</td>
			
			<td>
				<h1><a href = "${pageContext.request.contextPath}">PHK Shoe Store</a></h1>

			</td>
							
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			
			<td>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
						
			<td align="right">
				<div>
				
					<c:if test="${loggedCustomer == null}">
						<a href="login">Login</a> |
						<a href="register">Sign up</a> |
					</c:if>
					
					<c:if test="${loggedCustomer != null}">
						<a href="view_profile">Welcome, ${loggedCustomer.fullName}</a> |
						<a href="view_orders">My Orders</a> |
						<a href="logout">Logout</a> |
					</c:if>
					
					<a href="cart">Your cart</a>
					
					<br>
	
					<form action="search" method="get">
						<input type="text" name="keyword" size=50/>
						<input type="submit" value="Search"/> 
					</form>
				</div>	
			</td>
		</tr>
	
	</table>
	
</div>

<div>&nbsp;</div>

<div align="center">
	<c:forEach var="type" items="${listType}">
		<a href="view_type?id=${type.typeId}">
			<font size="+1"><b><c:out value="${type.typeName}"/></b></font>
		</a>
		&nbsp;
		&nbsp;
		&nbsp;
	</c:forEach>
	
</div>