package com.shoestore.service;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shoestore.controller.frontend.shoppingcart.ShoppingCart;
import com.shoestore.dao.OrderDAO;
import com.shoestore.entity.Customer;
import com.shoestore.entity.OrderDetail;
import com.shoestore.entity.Shoe;
import com.shoestore.entity.ShoeOrder;

public class OrderServices {
	private OrderDAO orderDAO;
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public OrderServices(HttpServletRequest request, HttpServletResponse response) {
		super();
		this.request = request;
		this.response = response;
		this.orderDAO = new OrderDAO();
	}



	public void listAllOrder() throws ServletException, IOException {
		listAllOrder(null);
		
	}
	
	public void listAllOrder(String message) throws ServletException, IOException {
		List<ShoeOrder> listOrder = orderDAO.listAll();
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		request.setAttribute("listOrder", listOrder);
		
		String listPage = "order_list.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(listPage);
		dispatcher.forward(request, response);
	}

	public void viewOrderDetailForAdmin() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		ShoeOrder order = orderDAO.get(orderId);
		request.setAttribute("order", order);
		
		String detailPage = "order_detail.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}



	public void showCheckOutForm() throws ServletException, IOException {
		String checkOutPage = "frontend/checkout.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(checkOutPage);
		dispatcher.forward(request, response);
	}



	public void placeOrder() throws ServletException, IOException {
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String zipcode = request.getParameter("zipcode");
		String country = request.getParameter("country");
		String payment = request.getParameter("payment");
		String toAddress = address + ", " + city + ", " + zipcode + ", " + country;
		
		ShoeOrder order = new ShoeOrder();
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setToAddress(toAddress);
		order.setPayment(payment);
		
		HttpSession	session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		order.setCustomer(customer);
		
		ShoppingCart shoppingCart =  (ShoppingCart) session.getAttribute("cart");
		Map<Shoe, Integer> items = shoppingCart.getItems();
		
		Iterator<Shoe> iterator = items.keySet().iterator();
		
		Set<OrderDetail> orderDetails = new HashSet<>();
		
		while (iterator.hasNext()) {
			Shoe shoe = iterator.next();
			Integer quantity = items.get(shoe);
			float subTotal = quantity * shoe.getShoePrice();
			
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setShoe(shoe);
			orderDetail.setShoeOrder(order);
			orderDetail.setQuantity(quantity);
			orderDetail.setSubTotal(subTotal);
			
			orderDetails.add(orderDetail);
		}
	
		order.setOrderDetails(orderDetails);
		order.setOrderSum(shoppingCart.getTotalAmount());
		
		orderDAO.create(order);
		
		shoppingCart.clear();
		
		String message = "Thank you. Your order has been received. We will deliver your shoes withn the few days.";
		request.setAttribute("message", message);
		String messagePage = "frontend/message.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(messagePage);
		dispatcher.forward(request, response);
	}



	public void listOrderByCustomer() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		List<ShoeOrder> listOrders = orderDAO.listByCustomer(customer.getCustomerId());
		request.setAttribute("listOrders", listOrders);
		
		String historyPage = "frontend/order_list.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(historyPage);
		dispatcher.forward(request, response);
		}


	public void showOrderDetailForCustomer() throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedCustomer");
		
		ShoeOrder order = orderDAO.get(orderId, customer.getCustomerId());
		request.setAttribute("order", order);
		
		String detailPage = "frontend/order_detail.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(detailPage);
		dispatcher.forward(request, response);
	}



	public void showEditOrderForm() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));		
		
		HttpSession session = request.getSession();
		Object isPendingShoe = session.getAttribute("NewShoePendingToAddToOrder"); 
		if (isPendingShoe == null) {
			ShoeOrder order = orderDAO.get(orderId);
			session.setAttribute("order", order); 
		}
		else {
			session.removeAttribute("NewShoePendingToAddToOrder");
		}
		
		String editPage = "order_form.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(editPage);
		dispatcher.forward(request, response);
	}


	public void updateOrder() throws ServletException, IOException {
		HttpSession session = request.getSession();
		ShoeOrder order = (ShoeOrder) session.getAttribute("order");
		
		String recipientName = request.getParameter("recipientName");
		String recipientPhone = request.getParameter("recipientPhone");
		String shippingAddress = request.getParameter("shippingAddress");
		String paymentMethod = request.getParameter("paymentMethod");
		String orderStatus = request.getParameter("orderStatus");
		
		order.setRecipientName(recipientName);
		order.setRecipientPhone(recipientPhone);
		order.setToAddress(shippingAddress);
		order.setPayment(paymentMethod);
		order.setStatus(orderStatus);
		
		String[] arrayShoeId = request.getParameterValues("shoeId");
		String[] arrayPrice = request.getParameterValues("price");
		String[] arrayQuantity = new String[arrayShoeId.length];
		
		for (int i = 1; i <= arrayQuantity.length; i++) {
			arrayQuantity[i - 1] = request.getParameter("quantity" + i);
		}
		
		Set<OrderDetail> orderDetails = order.getOrderDetails();
		orderDetails.clear();
		float totalAmount = 0.0f;
		
		for (int i = 0; i < arrayShoeId.length; i++) {
			int shoeId = Integer.parseInt(arrayShoeId[i]);
			int quantity = Integer.parseInt(arrayQuantity[i]);
			float price = Float.parseFloat(arrayPrice[i]);
			float subtotal = price * quantity;
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setShoe(new Shoe(shoeId));
			orderDetail.setQuantity(quantity);
			orderDetail.setSubTotal(subtotal);
			orderDetail.setShoeOrder(order);
			orderDetails.add(orderDetail);
			totalAmount += subtotal;
		}
		
		order.setOrderSum(totalAmount);
		orderDAO.update(order);
		String message = "The order " + order.getOrderId() + " has been updated successfully";
		listAllOrder(message);
	}



	public void deleteOrder() throws ServletException, IOException {
		Integer orderId = Integer.parseInt(request.getParameter("id"));		
		orderDAO.delete(orderId);
		
		String message = "The order ID " + orderId + " has been deleted.";
		listAllOrder(message);
	}
}
