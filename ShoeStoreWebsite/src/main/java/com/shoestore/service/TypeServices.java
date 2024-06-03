package com.shoestore.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.dao.TypeDAO;
import com.shoestore.entity.Type;



public class TypeServices {
	private TypeDAO typeDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public TypeServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;

		typeDAO = new TypeDAO();
	}

	public void listType() throws ServletException, IOException {
		listType(null);
	}
	
	public void listType(String message) throws ServletException, IOException {
		List<Type> listType = typeDAO.listAll();
		
		request.setAttribute("listType", listType);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String path = "type_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		
		requestDispatcher.forward(request, response);
		
	}
	
	public void createType() throws ServletException, IOException {
		String typeName = request.getParameter("typeName");
		Type existType = typeDAO.findByName(typeName);
		
		if(existType != null) {
			String message = "Could not create new type. Type already exists with the name: " + typeName;
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			
			requestDispatcher.forward(request, response);
		}
		else {
			Type type = new Type(typeName);
			typeDAO.create(type);
			
			String message = "A new type has been added successfully";
			listType(message);
		}
	}
	
	//Hiển thị dữ liệu lên form để edit
	public void editType() throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("id"));
		Type type = typeDAO.get(typeId);
		request.setAttribute("type", type);
		
		String path = "type_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	//Cập nhật dữ liệu lên db sau khi đã hiệu chỉnh trên form
	public void updateType() throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("typeId"));
		String typeName = request.getParameter("typeName");
		
		Type typeById = typeDAO.get(typeId);
		Type typeByName = typeDAO.findByName(typeName);
		
		if(typeByName != null && typeById.getTypeId() != typeByName.getTypeId()) {
			String message = "Could not update type. Type's name: " + typeName + " already exists";
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			
			requestDispatcher.forward(request, response);
		}
		else {
			typeById.setTypeName(typeName);
			typeDAO.update(typeById);
			
			String message = "The type has been updated successfully";
			listType(message);
		}
	}

	public void deleteType() throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("id"));
		ShoeDAO shoeDAO = new ShoeDAO();
		long numberOfShoes = shoeDAO.countByType(typeId);
		String message;
		
		if(numberOfShoes > 0) {
			message = "Could not delete type with type's id: %d, there are some shoes belong to this type";
			message = String.format(message, typeId);
		}
		else {
			typeDAO.delete(typeId);
			message = "The type with id: " + typeId + " has been deleted successfully";

		}
				
		listType(message);
	}
}
