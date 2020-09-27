package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class PizzaOrderBean {
	
	private Integer orderId;
	private Integer pizzaId;
	
	@Size(min=1,max=10,  message="Given name is not in the defined range")
	private String customerName;
	
	@Size(min=10, max=10 , message="Contact number should have 10 digits")
	private String contactNumber;
	
	private Double bill;
	
	@NotNull(message="No of orders should not be empty")
	//@Range(min=1, max=10 , message="No of orders should be greater than1")
	private Integer numberOfPiecesOrdered;
	
	
	
	@Override
	public String toString() {
		return "PizzaOrderBean [orderId=" + orderId + ", pizzaId=" + pizzaId + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", bill=" + bill + ", numberOfPiecesOrdered="
				+ numberOfPiecesOrdered + "]";
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(Integer pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Integer getNumberOfPiecesOrdered() {
		return numberOfPiecesOrdered;
	}
	public void setNumberOfPiecesOrdered(Integer numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
	
	
}
