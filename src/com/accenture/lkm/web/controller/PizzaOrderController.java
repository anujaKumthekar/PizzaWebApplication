package com.accenture.lkm.web.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;

@Controller
public class PizzaOrderController {
	@Autowired
	PizzaService pizzaService;
	
	@RequestMapping(value="loadPizza.html")
	public ModelAndView loadSavePizza() {
		ModelAndView mv= new ModelAndView();
		PizzaOrderBean pizzaOrderBean= new PizzaOrderBean();
		mv.addObject("pizza", pizzaOrderBean);
		mv.setViewName("PizzaOrder");
		return mv;

	}
	
	@RequestMapping(value="savePizza.html", method=RequestMethod.GET)
	public ModelAndView saveCustomer(@Valid @ModelAttribute("pizza") PizzaOrderBean pizzaOrderBean, BindingResult result) {
		ModelAndView mv= new ModelAndView();
		if(result.hasErrors()) {
			mv.setViewName("PizzaOrder");

		}else {
			PizzaOrderBean pizzaOrderBean1= pizzaService.addPizzaOrderDetails(pizzaOrderBean);
			mv.setViewName("PizzaOrderSuccess");
			mv.addObject("message", "Hi: "+pizzaOrderBean1.getCustomerName()+
					",your order is placed with orderId:"+pizzaOrderBean1.getOrderId()+
					", Bill to be paid is:"+pizzaOrderBean1.getBill()); 
		}
		
		return mv;
		
	}
	
	@ModelAttribute("nameList")
	public Map<Integer, String> findAllPizzaDetails(){
		return pizzaService.findAllPizzaDetails();
	}
	//Error Handler:
		@ExceptionHandler(value=Exception.class)
		public ModelAndView handleAllExceptions(Exception exception){
			ModelAndView  modelAndView = new ModelAndView();
			modelAndView.setViewName("GeneralizedExceptionHandlerPage");
			modelAndView.addObject("message", exception.getMessage());
			return modelAndView;
		}
}
