package com.shoestore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoestore.dao.CustomerDAO;
import com.shoestore.entity.Customer;

public class CustomerServices {
	private CustomerDAO customerDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public CustomerServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.customerDAO = new CustomerDAO();
	}
	
	public void listCustomer(String message) throws ServletException, IOException {
		List<Customer> listCustomer = customerDAO.listAll();
		
		if(message != null)
		{
			request.setAttribute("message", message);
		}
		
		request.setAttribute("listCustomer", listCustomer);
		
		String listPage = "customer_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
	}
	
	public void listCustomer() throws ServletException, IOException {
		listCustomer(null);
	}
	
	public void createCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		
		if(existCustomer != null)
		{
			String message = "Could not create customer: the email " + email + " is already registered by another customer.";
			listCustomer(message);
		}
		else
		{
			Customer newCustomer = new Customer();
			updateCustomerFieldsFormForm(newCustomer);
			customerDAO.create(newCustomer);
			
			String message = "New customer has been create successfully.";
			listCustomer(message);
		}
	}
	
	private void updateCustomerFieldsFormForm(Customer customer) {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullName");
		String password= request.getParameter("password");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipCode = request.getParameter("zipCode");
		String country = request.getParameter("country");
		
		if(email != null && !email.equals(""))
			customer.setEmail(email);
		
		customer.setFullName(fullName);
		
		if(password != null && !password.equals(""))
			customer.setPassword(password);
		
		customer.setPhoneNumber(phone);
		customer.setAddress(address);
		customer.setCity(city);
		customer.setZip(zipCode);
		customer.setCountry(country);
	}
	
	public void registerCustomer() throws ServletException, IOException {
		String email = request.getParameter("email");
		Customer existCustomer = customerDAO.findByEmail(email);
		String message;
		
		if(existCustomer != null)
		{
			message = "Could not register. The email " + email + " is already registered by another customer.";
		}
		else
		{
			Customer newCustomer = new Customer();
			updateCustomerFieldsFormForm(newCustomer);
			customerDAO.create(newCustomer);
			
			message = "You have registered successfully! Thank you.<br/>"
					+ "<a href='login'>Click here</a> to login";
		}
		
		String messagePage = "frontend/message.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(messagePage);
		request.setAttribute("message", message);
		requestDispatcher.forward(request, response);
	}
	
	public void editCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		Customer customer = customerDAO.get(customerId);
		
		request.setAttribute("customer", customer);
		
		String editPage = "customer_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("customerId"));
		String email = request.getParameter("email");
		
		Customer customerByEmail = customerDAO.findByEmail(email);
		String message = null;
		
		if(customerByEmail != null && customerByEmail.getCustomerId() != customerId)
		{
			message = "Could not update the customer ID " + customerId + " because there is an existing customer having the same email.";
			
		}
		else
		{
			
			Customer customerById = customerDAO.get(customerId);
			updateCustomerFieldsFormForm(customerById);
			
			customerDAO.update(customerById);
			
			message = "The customer has been updated successfully.";
		}
		
		listCustomer(message);
	}

	public void deleteCustomer() throws ServletException, IOException {
		Integer customerId = Integer.parseInt(request.getParameter("id"));
		customerDAO.delete(customerId);
		
		String message = "The customer has been delete successfully.";
		listCustomer(message);
	}

	public void showLogin() throws ServletException, IOException {
		String loginPage = "frontend/login.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(loginPage);
		dispatcher.forward(request, response);
	}

	public void doLogin() throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		if(customer == null) {
			String message = "Login failed. Please check your email and password!";
			request.setAttribute("message", message);
			showLogin();
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("loggedCustomer", customer);
			Object objectRedirectURL = session.getAttribute("redirectURL");
			
			if(objectRedirectURL != null)
			{
				String redirectURL = (String) objectRedirectURL;
				session.removeAttribute("redirectURL");
				response.sendRedirect(redirectURL);
			}
			else
			{
				showCustomerProfile();
			}
		}
		
	}
	
	public void showCustomerProfile() throws ServletException, IOException {
		String profilePage = "frontend/customer_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(profilePage);
		dispatcher.forward(request, response);
	}

	public void showCustomerProfileEditForm() throws ServletException, IOException {
		String editPage = "frontend/edit_profile.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}

	public void updateCustomerProfile() throws ServletException, IOException {
		Customer customer = (Customer) request.getSession().getAttribute("loggedCustomer");
		updateCustomerFieldsFormForm(customer);
		customerDAO.update(customer);
		
		showCustomerProfile();
	}
}
