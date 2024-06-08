package com.shoestore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoestore.entity.Customer;
import com.shoestore.entity.OrderDetailId;
import com.shoestore.entity.ShoeOrder;

public class OrderDAO extends JPADAO<ShoeOrder> implements GenericDAO<ShoeOrder> {

	@Override
	public ShoeOrder create(ShoeOrder order) {
		order.setOrderDate(new Date());
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
	
	public ShoeOrder get(Integer orderId, Integer customerId) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("orderId", orderId);
		parameters.put("customerId", customerId);

		List<ShoeOrder> result = super.findWithNamedQuery("ShoeOrder.findByIdAndCustomer", parameters );
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
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
	
	public List<ShoeOrder> listByCustomer (Integer customerId) {
		
		
		return super.findWithNamedQuery("ShoeOrder.findByCustomer", "customerId", customerId);
	}

}
