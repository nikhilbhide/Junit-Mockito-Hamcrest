package com.mock.service.order.bo;

import com.mock.service.order.dto.Order;

/**
 * OrderBO interface. It provides main apis for order service management system.
 ** 
 * @author nikhil.bhide  $Date : April 27, 2016$
 **/
public interface OrderBOInterface {
	public long placeOrder(Order order);
	public long updateOrder(Order order, String status);
	public boolean returnOrder(Order order);
	public boolean cancelOrder(Order order);
	public double getAmoutToRefund(Order order);
	public double getTotalRevenue();
}