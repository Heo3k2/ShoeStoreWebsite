package com.shoestore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.dao.CustomerDAO;
import com.shoestore.dao.OrderDAO;
import com.shoestore.dao.RateDAO;
import com.shoestore.dao.UserDAO;
import com.shoestore.entity.ShoeOrder;
import com.shoestore.entity.Rate;


/**
 * Servlet implementation class AdminHomePageServlet
 */
@WebServlet("/admin")
public class AdminHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AdminHomePageServlet() {
        super();
        
    }
    
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderDAO orderDAO = new OrderDAO();
		RateDAO rateDAO = new RateDAO();
		UserDAO userDAO = new UserDAO();
		ShoeDAO shoeDAO = new ShoeDAO();
		CustomerDAO customerDAO = new CustomerDAO();
		
		List<ShoeOrder> listMostRecentSales = orderDAO.listMostRecentSales();
		List<Rate> listMostRecent = rateDAO.listMostRecent();
		
		long totalUsers = userDAO.count();
		long totalShoes = shoeDAO.count();
		long totalCustomers = customerDAO.count();
		long totalRates = rateDAO.count();
		long totalOrders = orderDAO.count();
		
		request.setAttribute("listMostRecentSales", listMostRecentSales);
		request.setAttribute("listMostRecent", listMostRecent);
		
		request.setAttribute("totalUsers", totalUsers);
		request.setAttribute("totalShoes", totalShoes);
		request.setAttribute("totalCustomers", totalCustomers);
		request.setAttribute("totalRates", totalRates);
		request.setAttribute("totalOrders", totalOrders);
		
		String homePage = "index.jsp";
		/* System.out.println("Servlet Home Page"); */
		RequestDispatcher dispatcher = request.getRequestDispatcher(homePage);
		dispatcher.forward(request, response);
	}
}
