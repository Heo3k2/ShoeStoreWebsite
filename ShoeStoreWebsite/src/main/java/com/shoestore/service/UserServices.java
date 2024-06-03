package com.shoestore.service;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.UserDAO;
import com.shoestore.entity.Users;

public class UserServices {
	private UserDAO userDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public UserServices(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		
		userDAO = new UserDAO();
	}
	
	public void listUser() throws ServletException, IOException {
		listUser(null);
	}
	
	//Lấy ra danh sách các user có trong database và đẩy lên view
	public void listUser(String message) throws ServletException, IOException  {
		List<Users>listUsers = userDAO.listAll();
		request.setAttribute("listUsers", listUsers);
		
		request.setAttribute("message", message);
		String path = "user_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		
		requestDispatcher.forward(request, response);
	}
	
	//Thêm 1 user mới vào database
	public void createUser() throws ServletException, IOException {
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
		
		//Kiểm tra user này có trong database chưa bằng email (Email: Unique Key)
		Users existUser = userDAO.findByEmail(email);
		if(existUser != null) {
			String message = "Could not create user. A user with email " + email + " already exists";
			request.setAttribute("message", message);
			
			//Điều hướng đến view cần hiển thị
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			
			//Đi đến view đó
			requestDispatcher.forward(request, response);
		}
		else {
			Users user = new Users(email, fullName, password);
			userDAO.create(user);
			listUser("Create a new user successfully");
		}
	}
	
	public void editUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		Users user = userDAO.get(userId);
		
		String path = "user_form.jsp";
		request.setAttribute("user", user);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	public void updateUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String email = request.getParameter("email");
		String fullName = request.getParameter("fullname");
		String password = request.getParameter("password");
			
		Users userById = userDAO.get(userId);
		Users userByEmail = userDAO.findByEmail(email);
		
		//Kiểm tra xem email có tồn tại và thuộc quyền sở hữu của user khác không
		if(userByEmail != null && userByEmail.getUserId() != userById.getUserId()) {
			String message = "Could not update the user. User with email " + email + " already exists";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Users user = new Users(userId, email, fullName, password);
			userDAO.update(user);
			
			String message = "User has been updated successfully";
			listUser(message);
		}
	}

	public void deleteUser() throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		userDAO.delete(userId);
		
		String message = "User has been deleted successfully";
		listUser(message);
	}
	
	public void login() throws ServletException, IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean loginRes = userDAO.checkLogin(email, password);
		
		if(loginRes) {
			request.getSession().setAttribute("userEmail", email);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		}
		else {
			String message = "Login failed, please check your email and password again";
			request.setAttribute("message", message);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
			requestDispatcher.forward(request, response);
			
		}
	}
}
