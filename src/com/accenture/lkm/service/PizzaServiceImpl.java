package com.accenture.lkm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PizzaBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;
import com.accenture.lkm.entity.PizzaOrderEntity;
@Service
public class PizzaServiceImpl implements PizzaService{
	@Autowired
	PizzaDAOWrapper daoWrapper;
	
	 
	@Override
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception {
		List<PizzaOrderBean> list= daoWrapper.getOrderDetails(fromBill, toBill) ;
		if(list==null || list.isEmpty()) {
			throw new Exception("No records found for given bill range");
		}
	    return list;
	}
 
	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
		// TODO Auto-generated method stub
		Double price=daoWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
		Double bill= price*pizzaOrderBean.getNumberOfPiecesOrdered(); 
		pizzaOrderBean.setBill(bill);
		return daoWrapper.addPizzaOrderDetails(pizzaOrderBean);
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() {
		// TODO Auto-generated method stub
		List<PizzaBean> beanList= daoWrapper.findAllPizzaDetails();
		Map<Integer, String> pizzaMap= new HashMap<Integer, String>();
		for(PizzaBean b :beanList) {
			pizzaMap.put(b.getPizzaId(), b.getPizzaName());
		}
		return pizzaMap;
	}
}
