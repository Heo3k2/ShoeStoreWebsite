package com.shoestore.dao;

import java.util.Date;
import java.util.List;

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

}
