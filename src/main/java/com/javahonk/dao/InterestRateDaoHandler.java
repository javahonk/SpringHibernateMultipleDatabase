package com.javahonk.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
 

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javahonk.model.JavahonkTestModel;
 
@Repository
@Transactional
public class InterestRateDaoHandler<T> 
			implements InterestRateDao<T> {
	
	@Autowired
	private SessionFactory sessionFactoryAnotherDatabase;
	
	@Value("${query_getInterestRates}")
	private String query_getInterestRates;
	
	@Value("${query_getIntereestRateBasedOnRicAndDate}")
	private String query_getIntereestRateBasedOnRicAndDate;
	
	@SuppressWarnings("unchecked")
	public List<T> getInterestRatesUsingNativeQuery() {
		
		Session session = sessionFactoryAnotherDatabase.getCurrentSession();
		Query query = session.createSQLQuery("SELECT * FROM p_sami01.dbo.v_EqSwap_libor_rate where ric_code = :ric_code AND libor_rate_date = :libor_rate_date")
				.addEntity(JavahonkTestModel.class);
		
		query.setParameter("ric_code", "USD1MFSR=");
		query.setParameter("libor_rate_date", Integer.valueOf(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)));
		
		List<T> javahonkTestModelList = query.list();
		
		return javahonkTestModelList;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getInterestRates() {
		
		Session session = sessionFactoryAnotherDatabase.getCurrentSession();
		Query query = session.getNamedQuery(query_getInterestRates);
		List<T> javahonkTestModelList = query.list();
		return javahonkTestModelList;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getIntereestRateBasedOnRicAndDate(String ricCode) {
		
		Session session = sessionFactoryAnotherDatabase.getCurrentSession();
		Query query = session.getNamedQuery(query_getIntereestRateBasedOnRicAndDate);
		query.setParameter("ric_code", "USD1MFSR=");
		query.setParameter("libor_rate_date", Integer.valueOf(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE)));
		
		List<T> javahonkTestModelList = query.list();
		
		return javahonkTestModelList;
	}
	
}