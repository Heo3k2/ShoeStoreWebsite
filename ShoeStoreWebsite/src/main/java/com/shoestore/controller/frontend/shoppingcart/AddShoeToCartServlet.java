package com.shoestore.controller.frontend.shoppingcart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.entity.Shoe;

@WebServlet("/add_to_cart")
public class AddShoeToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddShoeToCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer shoeId = Integer.parseInt(request.getParameter("shoe_id"));
		
		Object cartOject = request.getSession().getAttribute("cart");
		
		ShoppingCart shoppingCart = null;
		
		if(cartOject != null && cartOject instanceof ShoppingCart) {
			shoppingCart = (ShoppingCart) cartOject;
		} else {
			shoppingCart = new ShoppingCart();
			request.getSession().setAttribute("cart", shoppingCart);
		}
		
		ShoeDAO shoeDAO = new ShoeDAO();
		Shoe shoe = shoeDAO.get(shoeId);
		
		shoppingCart.addItem(shoe);
		
		String cartPage = request.getContextPath().concat("/view_cart");
		response.sendRedirect(cartPage);
	}

}
