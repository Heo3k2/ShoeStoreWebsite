/*
 * package com.shoestore.controller.frontend.shoppingcart;
 * 
 * import static org.junit.jupiter.api.Assertions.*;
 * 
 * import java.util.Map;
 * 
 * import org.junit.BeforeClass; import org.junit.jupiter.api.Test;
 * 
 * import com.shoestore.entity.Shoe;
 * 
 * public class ShoppingCartTest { private static ShoppingCart cart;
 * 
 * @BeforeClass public static void setUpBeforeClass() throws Exception { cart =
 * new ShoppingCart(); Shoe shoe = new Shoe(1); shoe.setShoePrice(10);
 * 
 * cart.addItem(shoe); cart.addItem(shoe); }
 * 
 * @Test public void testAddItem() { Map<Shoe, Integer> items = cart.getItems();
 * Integer quantity = items.get(new Shoe(1));
 * 
 * assertEquals(1, quantity); }
 * 
 * @Test public void testRemoveItem1() { cart.removeItem(new Shoe(1));
 * 
 * assertTrue(cart.getItems().isEmpty()); }
 * 
 * @Test public void testRemoveItem2() { Shoe shoe2 = new Shoe(2);
 * cart.addItem(shoe2);
 * 
 * cart.removeItem(new Shoe(2));
 * 
 * assertNull(cart.getItems().get(shoe2)); }
 * 
 * @Test public void testGetTotalQuantity() { Shoe shoe3 = new Shoe();
 * cart.addItem(shoe3); cart.addItem(shoe3); cart.addItem(shoe3);
 * 
 * assertEquals(5, cart.getTotalQuantity()); }
 * 
 * @Test public void testGetTotalAmount1() { ShoppingCart cart = new
 * ShoppingCart(); assertEquals(0.0f, cart.getTotalAmount(), 0.0f); }
 * 
 * @Test public void testGetTotalAmount2() { assertEquals(20.0f,
 * cart.getTotalAmount(), 0.0f); }
 * 
 * @Test public void testClear() { cart.clear();
 * 
 * assertEquals(0, cart.getTotalQuantity()); } }
 */