package com.shoestore.dao;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shoestore.entity.Shoe;
import com.shoestore.entity.ShoeOrder;
import com.shoestore.entity.Customer;
import com.shoestore.entity.OrderDetail;
import com.shoestore.entity.OrderDetailId;

public class OrderDAOTest {
	
	private static OrderDAO orderDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		orderDAO = new OrderDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		orderDAO.close();
	}

	@Test
	public void testCreateShoeOrder() {
		
		  ShoeOrder order = new ShoeOrder(); 
		  Customer customer = new Customer();
		  customer.setCustomerId(2);
		  
		  order.setCustomer(customer); 
		  order.setPayment("Debit Card");
		  order.setRecipientName("Tommy Hilfiger");
		  order.setRecipientPhone("18001900");
		  order.setToAddress("300 Zjinwan Avenue, Changai, China");
		  
		  Set<OrderDetail> orderDetails = new HashSet<>(); 
		  OrderDetail orderDetail = new OrderDetail();
		  
		  Shoe shoe = new Shoe(4); 
		  orderDetail.setShoe(shoe);
		  orderDetail.setQuantity(1); 
		  orderDetail.setSubTotal(24.33f);
		  orderDetail.setShoeOrder(order); 
		  orderDetails.add(orderDetail);
		  order.setOrderDetails(orderDetails); 
		  orderDAO.create(order);
		  assertTrue(order.getOrderId() > 0);
		 
	}

	@Test
	public void testUpdateShoeOrder() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUpdateShoeOrderShippingAddress() {
		int orderId = 5;
		ShoeOrder order = orderDAO.get(orderId);
		order.setToAddress("New Port, Connecticut, USA");
		orderDAO.update(order);
		ShoeOrder updatedOrder = orderDAO.get(orderId);
		assertEquals(order.getToAddress(), updatedOrder.getToAddress());
		
	}
	
	@Test
	public void testUpdateShoeOrderDetail() {
		Integer orderId = 5;
		ShoeOrder order = orderDAO.get(orderId);
		
		Iterator<OrderDetail> iterator = order.getOrderDetails().iterator();
		
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if (orderDetail.getShoe().getShoeId() == 4) {
				orderDetail.setQuantity(3);
				orderDetail.setSubTotal(81.99f);
			}
		}
			
		orderDAO.update(order);
		
		ShoeOrder updatedOrder = orderDAO.get(orderId);
		
		iterator = order.getOrderDetails().iterator();
		
		int expectedQuantity = 3;
		float expectedSubtotal = 81.99f;
		int actualQuantity = 3;
		float actualSubtotal = 81.99f;
		
		while (iterator.hasNext()) {
			OrderDetail orderDetail = iterator.next();
			if (orderDetail.getShoe().getShoeId() == 5) {
				actualQuantity = orderDetail.getQuantity();
				actualSubtotal = orderDetail.getSubTotal();
			}
		}		
		
		assertEquals(expectedQuantity, actualQuantity);
		assertEquals(expectedSubtotal, actualSubtotal, 0.0f);
		
	}	

	@Test
	public void testGet() {
		Integer orderId = 5;
		ShoeOrder order = orderDAO.get(orderId);
		assertEquals(1, order.getOrderDetails().size());
	}

	@Test
	public void testDeleteOrder() {
		int orderId = 5;
		orderDAO.delete(orderId);
		ShoeOrder order = orderDAO.get(orderId);
		assertNull(order);
	}

	@Test
	public void testListAll() {
		List<ShoeOrder> listOrders = orderDAO.listAll();
		for (ShoeOrder shoeOrder : listOrders) {
			System.out.println(shoeOrder.getOrderId() + " - " + shoeOrder.getCustomer().getFullName()
					+ " - " + shoeOrder.getOrderSum() + " - " + shoeOrder.getStatus());
			for (OrderDetail detail : shoeOrder.getOrderDetails()) {
				Shoe shoe = detail.getShoe();
				int quantity = detail.getQuantity();
				float subtotal = detail.getSubTotal();
				System.out.println("\t" + shoe.getType() + " - " + quantity + " - " + subtotal);
			}
		}
		assertTrue(listOrders.size() > 0);
	}

	@Test
	public void testCount() {
		long totalOrders = orderDAO.count();
		assertEquals(1, totalOrders);
	}
	
	@Test
	public void testListByCustomerNoOrders() {
		Integer customerId = 99;
		List<ShoeOrder> listOrders = orderDAO.listByCustomer(customerId);
		assertTrue(listOrders.isEmpty());
	}
	
	@Test
	public void testListByCustomerHaveOrders() {
		Integer customerId = 2;
		List<ShoeOrder> listOrders = orderDAO.listByCustomer(customerId);
		assertTrue(listOrders.size() > 0);
	}	
	
	/*
	 * @Test public void testGetByIdAndCustomerNull() { Integer orderId = 10;
	 * Integer customerId = 99; ShoeOrder order = orderDAO.get(orderId, customerId);
	 * assertNull(order); }
	 * 
	 * @Test public void testGetByIdAndCustomerNotNull() { Integer orderId = 4;
	 * Integer customerId = 2; ShoeOrder order = orderDAO.get(orderId, customerId);
	 * assertNotNull(order); }
	 * 
	 * @Test public void testListMostRecentSales() { List<ShoeOrder> recentOrders =
	 * orderDAO.listMostRecentSales(); assertEquals(3, recentOrders.size()); }
	 */
}
