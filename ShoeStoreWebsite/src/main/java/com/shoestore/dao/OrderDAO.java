package com.shoestore.dao;

import java.util.Date;
import java.util.List;

import com.shoestore.entity.OrderDetailId;
import com.shoestore.entity.ShoeOrder;

public class OrderDAO extends JPADAO<ShoeOrder> implements GenericDAO<ShoeOrder> {

	@Override
	public ShoeOrder create(ShoeOrder order) {
		order.setOrderDate(new Date());
		order.setPayment("Cash On Delivery");
		order.setStatus("Processing");
		return super.create(order);
	}
	
	public ShoeOrder update(ShoeOrder order) {
		
		return super.update(order);
	}

	@Override
	public ShoeOrder get(Object orderId) {
		
		return super.find(ShoeOrder.class, orderId);
	}

	@Override
	public void delete(Object id) {
		super.delete(ShoeOrder.class, id);
	}

	@Override
	public List<ShoeOrder> listAll() {
		return super.findWithNamedQuery("ShoeOrder.findAll");
	}	

	@Override
	public long count() {
		return super.countWithNamedQuery("ShoeOrder.countAll");
	}

}
