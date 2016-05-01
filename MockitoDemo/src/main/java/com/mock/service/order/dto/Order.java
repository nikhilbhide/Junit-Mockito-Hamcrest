package com.mock.service.order.dto;
/**
 * Order DTO class.
 ** 
 * @author nikhil.bhide  $Date : April 27, 2016$
 **/
public class Order {
	public Order(long id, String itemName, String description, double price, String orderingCustomerName,
			String sellerName, double discount, String status) throws IllegalAccessException {
		setId(id);
		setItemName(itemName);
		setDescription(description);
		setPrice(price);
		setOrderingCustomerName(orderingCustomerName);
		setSellerName(sellerName);
		setDiscount(discount);
		setStatus(status);
	}
	
	private long id;
	private String itemName;
	private String description;
	private double price;
	private String orderingCustomerName;
	private String sellerName;
	private double discount;
	private String status;
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		if(discount<0|| discount>100)
			throw new IllegalArgumentException();
		this.discount = discount;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		if(id<=0) 
			throw new IllegalArgumentException();
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		if(itemName==null || itemName.equals(""))
			throw new IllegalArgumentException();
		this.itemName = itemName.toUpperCase();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		if(description==null || description.equals(""))
			throw new IllegalArgumentException();
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		if(price < 0) 
			throw new IllegalArgumentException();
		this.price = price;
	}
	
	public String getOrderingCustomerName() {
		return orderingCustomerName;
	}
	
	public void setOrderingCustomerName(String orderingCustomerName) {
		if(orderingCustomerName==null || orderingCustomerName.equals(""))
			throw new IllegalArgumentException();
		this.orderingCustomerName = orderingCustomerName;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
}