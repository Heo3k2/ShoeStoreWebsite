package com.shoestore.controller.admin;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@WebFilter("/admin/*")
public class AdminLoginFilter extends HttpServlet implements Filter {

    public AdminLoginFilter() {
        
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		
		boolean loggedIn = session != null && session.getAttribute("userEmail") != null;
		String loginURI = httpRequest.getContextPath() + "/admin/login";
		
		System.out.println(loggedIn);
		System.out.println(loginURI);
		System.out.println(httpRequest.getRequestURI());
		
		boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
		boolean loginPage = httpRequest.getRequestURI().endsWith("login.jsp");
		
		
		if(loggedIn && (loginRequest || loginPage)) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/");
			requestDispatcher.forward(request, response);
		}
		
		else if(loggedIn || loginRequest) {
			chain.doFilter(request, response);
		}
		else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
			requestDispatcher.forward(request, response);
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
