package com.shoestore.controller.admin.rate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.service.RateServices;

@WebServlet("/admin/delete_rate")
public class DeleteRateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RateServices rateServices = new RateServices(request, response);
		rateServices.deleteRate();
	}

}
