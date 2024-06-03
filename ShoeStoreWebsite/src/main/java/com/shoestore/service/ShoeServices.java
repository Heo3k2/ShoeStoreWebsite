package com.shoestore.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.shoestore.dao.ShoeDAO;
import com.shoestore.dao.TypeDAO;
import com.shoestore.entity.Shoe;
import com.shoestore.entity.Type;

public class ShoeServices {
	private ShoeDAO shoeDAO;
	private TypeDAO typeDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public ShoeServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		
		shoeDAO = new ShoeDAO();
		typeDAO = new TypeDAO();
	}
	
	public void listShoes() throws ServletException, IOException {
		listShoes(null);
	}
	
	public void listShoes(String message) throws ServletException, IOException {
		List<Shoe> listShoes = shoeDAO.listAll();
		request.setAttribute("listShoes", listShoes);
		
		if(message != null) {
			request.setAttribute("message", message);
		}
		
		String path = "shoe_list.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
	
	public void showShoeNewForm() throws ServletException, IOException {
		List<Type> listType = typeDAO.listAll();
		request.setAttribute("listType", listType);
		
		String path = "shoe_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}	

	public void createShoe() throws ServletException, IOException {
		String shoeName = request.getParameter("shoeName");
		Shoe existShoe = shoeDAO.findByName(shoeName);
		
		//Kiểm tra trùng tên giày
		if(existShoe != null) { 
			String message = "Could not create new shoes since there is already a pair of shoes with the name: " + shoeName; 
			listShoes(message);
			return;
		} 
		
		Shoe newShoe = new Shoe();
		readFields(newShoe);
		
		Shoe createdShoe = shoeDAO.create(newShoe);
		
		if(createdShoe.getShoeId() > 0) {
			String message = "A new pair of shoes has been created successfully";
			listShoes(message);
		}
	}

	public void editShoe() throws ServletException, IOException {
		//Đổ dữ liệu vào combo box Type
		List<Type> listType = typeDAO.listAll();
		request.setAttribute("listType", listType);
		
		Integer shoeId = Integer.parseInt(request.getParameter("id"));
		Shoe shoe = shoeDAO.get(shoeId);
		
		request.setAttribute("shoe", shoe);
		
		
		
		String path = "shoe_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	public void readFields(Shoe shoe) throws ServletException, IOException {
		Integer typeId = Integer.parseInt(request.getParameter("type"));
		String shoeName = request.getParameter("shoeName");
		String brand = request.getParameter("brand");
		String description = request.getParameter("description");
		Float shoePrice = Float.parseFloat(request.getParameter("shoePrice"));
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date releasedDate;
		
		try {
			releasedDate = df.parse(request.getParameter("releasedDate"));
		}
		catch(ParseException ex) {
			ex.printStackTrace();
			throw new ServletException("Error parsing released date (format is: dd/MM/yyyy");
		}
		

		Type type = typeDAO.get(typeId);
		
		shoe.setType(type);
		shoe.setShoeName(shoeName);
		shoe.setBrand(brand);
		shoe.setDescription(description);
		shoe.setShoePrice(shoePrice);
		shoe.setReleasedDate(releasedDate);
		
		Part part = request.getPart("shoeImage");
		
		if(part != null && part.getSize() > 0) {
			long size = part.getSize();
			byte[] imageBytes = new byte[(int)size];
			
			InputStream inputStream = part.getInputStream();
			inputStream.read(imageBytes);
			inputStream.close();
		
			shoe.setShoeImage(imageBytes);
		}
		
	}
	
	public void updateShoe() throws ServletException, IOException {
		Integer shoeId = Integer.parseInt(request.getParameter("shoeId"));
		String shoeName = request.getParameter("shoeName");
		
		Shoe existShoe = shoeDAO.get(shoeId);
		Shoe shoeByName = shoeDAO.findByName(shoeName);
		
		if(shoeByName != null && !existShoe.equals(shoeByName)) {
			String message = "Unable to update this pair of shoes because there is another pair shoes has the name: " + shoeName;
			listShoes(message);
			return;
		}
		
		readFields(existShoe);
		
		shoeDAO.update(existShoe);
		
		String message = "The pair of shoes has been updated successfully";
		listShoes(message);
	}

	public void deleteShoe() throws ServletException, IOException {
		Integer shoeId = Integer.parseInt(request.getParameter("id"));
		
		shoeDAO.delete(shoeId);
		
		String message = "The pair of shoes has been deleted successfully";
		listShoes(message);
	}

	public void listShoesByType() throws ServletException, IOException {
		int typeId = Integer.parseInt(request.getParameter("id"));
		List<Shoe> listShoes = shoeDAO.listByType(typeId);
		Type type = typeDAO.get(typeId);

		request.setAttribute("type", type);
		request.setAttribute("listShoes", listShoes);

		String path = "frontend/shoes_list_by_type.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	public void viewShoeDetail() throws ServletException, IOException {
		int shoeId = Integer.parseInt(request.getParameter("id"));
		Shoe shoe = shoeDAO.get(shoeId);

		request.setAttribute("shoe", shoe);
	
		String path = "frontend/shoe_detail.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}

	public void search() throws ServletException, IOException {
		String keyword = request.getParameter("keyword");
		List<Shoe>resList = null;
		
		if(keyword.equals("")) {
			resList = shoeDAO.listAll();
		}
		else {
			resList = shoeDAO.search(keyword);
		}
		
		request.setAttribute("keyword", keyword);
		request.setAttribute("result", resList);
		
		String path = "frontend/search_result.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	}
}
