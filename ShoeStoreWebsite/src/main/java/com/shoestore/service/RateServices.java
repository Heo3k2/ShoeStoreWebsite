package com.shoestore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.RateDAO;
import com.shoestore.entity.Rate;

public class RateServices {
	private RateDAO rateDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public RateServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.rateDAO = new RateDAO();
	}
	
	public void listAllRate() throws ServletException, IOException {
		listAllRate(null);
		
	}
	
	public void listAllRate(String message) throws ServletException, IOException {
		List<Rate> listRates = rateDAO.listAll();
		
		request.setAttribute("listRates", listRates);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String listPage = "rate_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void editRate() throws ServletException, IOException {
		Integer rateId = Integer.parseInt(request.getParameter("id"));
		Rate rate = rateDAO.get(rateId);
		
		request.setAttribute("rate", rate);
		
		String listPage = "rate_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void updateRate() throws ServletException, IOException {
		Integer rateId = Integer.parseInt(request.getParameter("rateId"));
		String headline = request.getParameter("headline");
		String ratingDetail = request.getParameter("ratingDetail");
		
		Rate rate = rateDAO.get(rateId);
		rate.setHeadline(headline);
		rate.setRatingDetail(ratingDetail);
		
		rateDAO.update(rate);
		
		String message = "The rate has been updated successfully.";
		
		listAllRate(message);
	}

	public void deleteRate() throws ServletException, IOException {
		Integer rateId = Integer.parseInt(request.getParameter("id"));
		rateDAO.delete(rateId);
		
		String message = "The rate has been delete successfully.";
		
		listAllRate(message);
	}
}
