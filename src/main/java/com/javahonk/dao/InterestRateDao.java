package com.javahonk.dao;

import java.util.List;

public interface InterestRateDao<T> {
 
	public List<T> getInterestRates();
	
	public List<T> getIntereestRateBasedOnRicAndDate(String ricCode);
	
}