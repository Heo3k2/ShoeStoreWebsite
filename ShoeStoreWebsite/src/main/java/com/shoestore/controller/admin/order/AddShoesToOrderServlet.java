package com.shoestore.controller.admin.order;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.entity.OrderDetail;
import com.shoestore.entity.Shoe;
import com.shoestore.entity.ShoeOrder;

@WebServlet("/admin/add_shoes_to_order")
public class AddShoesToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddShoesToOrderServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int shoeId = Integer.parseInt(request.getParameter("shoeId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		ShoeDAO shoeDao = new ShoeDAO();
		Shoe shoe = shoeDao.get(shoeId);
		
		HttpSession session = request.getSession();
		ShoeOrder order = (ShoeOrder) session.getAttribute("order");
		
		float subTotal = quantity * shoe.getShoePrice();
		
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setShoe(shoe);
		orderDetail.setQuantity(quantity);
		orderDetail.setSubTotal(subTotal);
		
		float newTotal = order.getOrderSum() + subTotal;
		order.setOrderSum(newTotal);
		
		order.getOrderDetails().add(orderDetail);
		
		request.setAttribute("shoe", shoe);
		session.setAttribute("NewShoePendingToAddToOrder", true);
		
		String resultPage = "add_shoes_result.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(resultPage);
		dispatcher.forward(request, response);
	}

}
