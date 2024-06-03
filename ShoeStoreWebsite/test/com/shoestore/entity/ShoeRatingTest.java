package com.shoestore.entity;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ShoeRatingTest {

	@Test
	public void testAverageRating1() {
		Shoe shoe = new Shoe();
		
		Set<Rate> rates = new HashSet<Rate>(); 
		Rate rate = new Rate();
		rate.setRatingStars(5);
		rates.add(rate);
		
		shoe.setRates(rates);
		
		float averageRating = shoe.getAverageRating();
		
		assertEquals(5.0f, averageRating, 0.0);
	}
	
	@Test
	public void testAverageRating2() {
		Shoe shoe = new Shoe();
		
		float averageRating = shoe.getAverageRating();
		
		assertEquals(0.0, averageRating, 0.0);
	}

	@Test
	public void testAverageRating3() {
		Shoe shoe = new Shoe();
		
		Set<Rate> rates = new HashSet<Rate>(); 
		Rate rate = new Rate();
		rate.setRatingStars(5);
		rates.add(rate);
		
		Rate rate1 = new Rate();
		rate1.setRatingStars(4);
		rates.add(rate1);
		
		Rate rate2 = new Rate();
		rate2.setRatingStars(3);
		rates.add(rate2);
		
		shoe.setRates(rates);
		
		float averageRating = shoe.getAverageRating();
		
		assertEquals(4.0, averageRating, 0.0);
	}
	
	@Test
	public void testRatingString1() {
		float averageRating = 0.0f;
		Shoe shoe = new Shoe();
		
		String actual = shoe.getRatingString(averageRating);
		
		String expected = "off,off,off,off,off";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testRatingString2() {
		float averageRating = 5.0f;
		Shoe shoe = new Shoe();
		
		String actual = shoe.getRatingString(averageRating);
		
		String expected = "on,on,on,on,on";
		
		assertEquals(actual, expected);
	}
	
	@Test
	public void testRatingString3() {
		float averageRating = 3.5f;
		Shoe shoe = new Shoe();
		
		String actual = shoe.getRatingString(averageRating);
		
		String expected = "on,on,on,half,off";
		
		assertEquals(actual, expected);
	}
}
