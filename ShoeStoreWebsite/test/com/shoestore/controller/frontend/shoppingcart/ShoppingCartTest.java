package com.shoestore.controller.frontend.shoppingcart;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import com.shoestore.entity.Shoe;

public class ShoppingCartTest {
	private static ShoppingCart cart;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		cart = new ShoppingCart();
		Shoe shoe = new Shoe(1);
		
		cart.addItem(shoe);
	}

	@Test
	public void testAddItem() {
		Map<Shoe, Integer> items = cart.getItems(); 
		Integer quantity = items.get(new Shoe(1));
		
		assertEquals(1, quantity);
	}
	
	@Test
	public void testRemoveItem() {
		cart.removeItem(new Shoe(1));
		
		assertTrue(cart.getItems().isEmpty());
	}

}
