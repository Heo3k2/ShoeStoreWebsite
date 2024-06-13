<div align="center" style="width: 80%; margin: 0 auto;">
	<div style="display: flex; flex-wrap: wrap; justify-content: center; gap: 20px;">
		<!-- Repeat this block for each shoe -->
		<div style="margin: 20px; width: 250px;">
			<div>
				<a href="view_shoe?id=${shoe.shoeId}">
					<img src="data:image/jpg;base64,${shoe.base64Image}" width="250" height="240"/>
				</a>
			</div>
			<div style="font-size: 25px">
				<a href="view_shoe?id=${shoe.shoeId}">
					<b>${shoe.shoeName}</b>
				</a>
			</div>
			<div>
				<jsp:directive.include file="shoe_rating.jsp" />
			</div>
			<div>From: ${shoe.brand}</div>
			<div><b>Price: $${shoe.shoePrice}</b></div>
		</div>
		<!-- End of shoe block -->
	</div>
</div>
