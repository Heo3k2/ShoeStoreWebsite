package com.shoestore.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Map;

import com.shoestore.entity.Shoe;

public class ShoppingCart {
	private Map<Shoe, Integer> cart = new HashMap<>();
	
	public void addItem(Shoe shoe) {
		if(cart.containsKey(shoe)) {
			Integer quantity = cart.get(shoe) + 1;
			cart.put(shoe, quantity);
		} else {
			cart.put(shoe, 1);
		}
	}
	
	public void removeItem(Shoe shoe) {
		cart.remove(shoe);
	}
	
	public Map<Shoe, Integer> getItems() {
		return this.cart;
	}
}
