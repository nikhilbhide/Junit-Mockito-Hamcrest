package com.mock.service.order.dao;

import java.util.List;

import com.mock.service.order.dto.Order;

public interface OrderDaoInterface {
	public long create(Order order);
	public long update(Order order);
	public boolean delete(Order order);
	public List<Order> getByOrderingCustomerName(String orderingCustomerName);
	public List<Order> getBySellerName(String sellerName);	
	public List<Order> getAllOrders();
}