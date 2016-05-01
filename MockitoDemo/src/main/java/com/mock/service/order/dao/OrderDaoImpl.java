package com.mock.service.order.dao;

import java.util.List;
import com.mock.service.order.dto.Order;

/**
 * OrderDao implementation class which implements {@link OrderDaoInterface}
 * It provides implementation for CRUD operations on Order DTO {@link Order}
 * 
 * @author nikhil.bhide $Date : April 27, 2016$
 *
 */

public class OrderDaoImpl implements OrderDaoInterface {
	public long create(Order order) {
		System.out.println("OrderDaoImpl:create() invoked");
		return 0;
	}

	public long update(Order order) {
		return 0;
	}

	public boolean delete(Order order) {
		return false;
	}

	public List<Order> getByOrderingCustomerName(String orderingCustomerName) {
		return null;
	}

	public List<Order> getBySellerName(String sellerName) {
		return null;
	}
	
	public List<Order> getAllOrders() {
		return null;
	}
}