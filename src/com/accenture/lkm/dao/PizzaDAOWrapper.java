package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accenture.lkm.business.bean.PizzaBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.entity.PizzaEntity;
import com.accenture.lkm.entity.PizzaOrderEntity;

@Repository
public class PizzaDAOWrapper {
	
	@Autowired
	PizzaDAO pizzaDAO;
	
	@Autowired
	PizzaOrderDAO pizzaOrderDAO;
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<PizzaBean> findAllPizzaDetails(){
		
		List<PizzaEntity> pizzaEntity= pizzaDAO.findAllPizzaDetails();
		List<PizzaBean> pizzaBeans = new ArrayList<PizzaBean>();
		for(PizzaEntity entity: pizzaEntity) {
			PizzaBean bean= new PizzaBean();
			BeanUtils.copyProperties(entity, bean);
			pizzaBeans.add(bean);
		}
		return pizzaBeans; 
		
		
	}
	
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) {
		PizzaOrderEntity orderEntity= new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaBean, orderEntity);
		PizzaOrderEntity entity1= pizzaOrderDAO.save(orderEntity);
		PizzaOrderBean orderBean= new PizzaOrderBean();
		BeanUtils.copyProperties(entity1, orderBean);
		return orderBean;
		
	}
	
	public Double getPizzaPrice(Integer pizzaId) {
		PizzaEntity pizzaEntity= entityManager.find(PizzaEntity.class, pizzaId);
		return pizzaEntity.getPrice();
		
	}
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill){
		List<PizzaOrderEntity> orderEntities;
		Query q=entityManager.createQuery("select k from PizzaOrderEntity k where bill between ?1 and ?2");
		q.setParameter(1, fromBill);
		q.setParameter(2, toBill);
		orderEntities= q.getResultList();
		List<PizzaOrderBean> pizzaOrderBeans = new ArrayList<PizzaOrderBean>();
		for(PizzaOrderEntity entity: orderEntities) {
			PizzaOrderBean orderBean= new PizzaOrderBean();
			BeanUtils.copyProperties(entity, orderBean);
			pizzaOrderBeans.add(orderBean);
		}
		return pizzaOrderBeans; 
		
	}

}
