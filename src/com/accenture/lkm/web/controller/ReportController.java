package com.accenture.lkm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.lkm.business.bean.BillRangeBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.service.PizzaService;
@Controller
public class ReportController {
	
	@Autowired
	PizzaService pizzaService;
	
	@RequestMapping(value="loadOrder.html")
	public ModelAndView loadDateRangeReportPage() {
		ModelAndView mv= new ModelAndView();
		BillRangeBean billRangeBean= new BillRangeBean();
		mv.addObject("bill", billRangeBean);
		mv.setViewName("OrderReport");
		return mv;	
		}
	
	@RequestMapping(value="orderList.html")
	public ModelAndView getOrderDetails(@ModelAttribute("bill") BillRangeBean billRangeBean) throws Exception {
		ModelAndView mv= new ModelAndView();
		List<PizzaOrderBean> list =pizzaService.getOrderDetails(billRangeBean.getFromPrice(), billRangeBean.getToPrice());
		mv.addObject("OrderList", list);
		mv.setViewName("OrderReport");
		
		return mv;
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
