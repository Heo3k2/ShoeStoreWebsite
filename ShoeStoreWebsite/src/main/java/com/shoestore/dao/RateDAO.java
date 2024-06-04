package com.shoestore.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shoestore.entity.Rate;

public class RateDAO extends JPADAO<Rate> implements GenericDAO<Rate> {
	
	@Override
	public Rate create(Rate rate) {
		rate.setRateTime(new Date());
		return super.create(rate);
	}
	
	@Override
	public Rate get(Object RateId) {
		return super.find(Rate.class, RateId);
	}

	@Override
	public void delete(Object RateId) {
		super.delete(Rate.class, RateId);
	}

	@Override
	public List<Rate> listAll() {
		return super.findWithNamedQuery("Rate.listAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Rate.countAll");
	}
	
	public Rate findByCustomerAndShoe(int customerId, int shoeId) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("customerId", customerId);
		parameters.put("shoeId", shoeId);
		
		List<Rate> result = super.findWithNamedQuery("Rate.findByCustomerAndShoe", parameters);
		
		if(!result.isEmpty())
		{
			return result.get(0);
		}
		
		return null;
	}
}
