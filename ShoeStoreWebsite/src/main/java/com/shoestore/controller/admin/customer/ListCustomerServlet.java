package com.shoestore.controller.admin.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.service.CustomerServices;

@WebServlet("/admin/list_customer")
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListCustomerServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CustomerServices customerServices = new CustomerServices(request, response);
		customerServices.listCustomer();
	}

}
