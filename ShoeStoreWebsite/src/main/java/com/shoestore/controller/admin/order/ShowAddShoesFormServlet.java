package com.shoestore.controller.admin.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.entity.Shoe;

@WebServlet("/admin/add_shoes_form")
public class ShowAddShoesFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowAddShoesFormServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShoeDAO shoeDAO = new ShoeDAO();
		List<Shoe> listShoe = shoeDAO.listAll();
		request.setAttribute("listShoe", listShoe);
		String addFormPage = "add_shoes_form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(addFormPage);
		dispatcher.forward(request, response);
	}

}
