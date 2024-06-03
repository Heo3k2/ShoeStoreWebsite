package com.shoestore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shoestore.entity.Customer;
import com.shoestore.entity.Rate;
import com.shoestore.entity.Shoe;

public class RateDAOTest {
	
	private static RateDAO rateDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rateDao = new RateDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		rateDao.close();
	}

	@Test
	public void testCreateRate() {
		Rate rate = new Rate();
		Shoe shoe = new Shoe();
		shoe.setShoeId(2);
		
		Customer customer = new Customer();
		customer.setCustomerId(6);
		
		rate.setShoe(shoe);
		rate.setCustomer(customer);
		
		rate.setHeadline("This is a very good shoes!");
		rate.setRatingStars(5);
		rate.setRatingDetail("I feel so good");
		
		Rate saveRate = rateDao.create(rate);
		
		assertTrue(saveRate.getRateId() > 0);
	}

	@Test
	public void testGet() {
		Integer rateId = 3;
		Rate rate = rateDao.get(rateId);
		
		assertNotNull(rate);
	}
	
	@Test
	public void testUpdateRate() {
		Integer rateId = 1;
		Rate rate = rateDao.get(rateId);
		rate.setHeadline("Excellent shoes");
		
		Rate updateRate = rateDao.update(rate);
		
		assertEquals(rate.getHeadline(), updateRate.getHeadline());
	}

	@Test
	public void testDeleteRate() {
		int rateId = 2;
		rateDao.delete(rateId);
		
		Rate rate = rateDao.get(rateId);
		
		assertNull(rate);
	}

	@Test
	public void testListAll() {
		List<Rate> listRate = rateDao.listAll();
		
		for(Rate rate : listRate)
		{
			System.out.println(rate.getRateId() + " - " + rate.getShoe().getShoeName() 
					+ " - " + rate.getCustomer().getFullName()
					+ " - " + rate.getHeadline() + " - " + rate.getRatingStars());
		}
		
		assertTrue(listRate.size() > 0);
	}

	@Test
	public void testCount() {
		Long totalRate = rateDao.count();
		System.out.println("Total Rates: " + totalRate);
		assertTrue(totalRate > 0);
	}

}
