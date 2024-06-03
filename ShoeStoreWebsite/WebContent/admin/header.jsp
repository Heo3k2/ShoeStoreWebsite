<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div align="left">
	<a href="${pageContext.request.contextPath}/admin/">
		<img src="../images/Privacy_private_security-512.png" style="max-height: 100px; max-width: 100px;">
	</a>
</div>

<div align="center">
	<div>
		<h1>Welcome, <c:out value="${sessionScope.userEmail}"></c:out> </h1>
		<a href="logout">Logout</a>
	</div>
		
		<br><br>
		
	<div id = "headerMenu">
		<div>
			<a href = "list_users">
				<img src="../images/User.png" id = "logoSize"><br>User
			</a>
		</div>
		
		<div>
			<a href = "list_type">
				<img src="../images/Type.png" id = "logoSize"><br>Type
			</a>
		</div>
		
		<div>
			<a href = "list_shoes">
				<img src="../images/Shoes.png" id = "logoSize"><br>Shoes
			</a>
		</div>
		
		<div>
			<a href = "list_customer">
				<img src="../images/Customer.png" id = "logoSize"><br>Customer
			</a>
		</div>
		
		<div>
			<a href = "list_rate">
				<img src="../images/Rate.png" id = "logoSize"><br>Rate
			</a>
		</div>
		
		<div>
			<a href = "orders">
				<img src="../images/Order.png" id = "logoSize"><br>Order
			</a>
		</div>
	
	</div>		
</div>