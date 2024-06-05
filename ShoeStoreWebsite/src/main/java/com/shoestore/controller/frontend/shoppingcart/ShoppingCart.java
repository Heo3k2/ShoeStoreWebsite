package com.shoestore.controller.frontend.shoppingcart;

import java.util.HashMap;
import java.util.Iterator;
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
	
	public int getTotalQuantity() {
		int total = 0;
		
		Iterator<Shoe> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Shoe next = iterator.next();
			Integer quantity = cart.get(next);
			total += quantity;
		}
		
		return total;
	}
	
	public double getTotalAmount() {
		double total = 0.0f;
		
		Iterator<Shoe> iterator = cart.keySet().iterator();
		
		while(iterator.hasNext()) {
			Shoe shoe = iterator.next();
			Integer quantity = cart.get(shoe);
			double subTotal = quantity * shoe.getShoePrice();
			total += subTotal;
		}
		
		return total;
	}
	
	public void clear() {
		cart.clear();
	}
	
	public int getTotalItems() {
		return cart.size();
	}
	
	public Map<Shoe, Integer> getItems() {
		return this.cart;
	}
}
