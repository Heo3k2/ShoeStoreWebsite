package com.shoestore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shoestore.entity.Customer;

public class CustomerDAOTest {
	private static CustomerDAO customerDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDao = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDao.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("billy.jane@gmail.com");
		customer.setFullName("Jane Billy");
		customer.setCity("New York");
		customer.setCountry("United States");
		customer.setAddress("100 North Avenue");
		customer.setPassword("secret");
		customer.setPhoneNumber("18001900");
		customer.setZip("100000");
		
		Customer savedCustomer = customerDao.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDao.get(customerId);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDao.get(1);
		String fullName = "Tom Tom Tom";
		customer.setFullName(fullName);
		
		Customer updateCustomer = customerDao.update(customer);
		
		assertTrue(updateCustomer.getFullName().equals(fullName));
	}

	@Test
	public void testDeleteObject() {
		Integer customerId = 2;
		customerDao.delete(customerId);
		Customer customer = customerDao.get(1);
		
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDao.listAll();
		
		for(Customer customer : listCustomers)
		{
			System.out.println(customer.getFullName());
		}
		
		assertFalse(listCustomers.isEmpty());
	}
	
	@Test
	public void testCount() {
		long totalCustomers = customerDao.count();
		
		assertEquals(2, totalCustomers);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "tom@gmail.com13";
		Customer customer = customerDao.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "tom@gmail.com";
		String password = "secret";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "asfg@gmail.com";
		String password = "secret";
		
		Customer customer = customerDao.checkLogin(email, password);
		
		assertNull(customer);
	}
}
