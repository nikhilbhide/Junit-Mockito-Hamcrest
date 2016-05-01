package com.mock.service.order.bo;

/**
 * OrderBO main implementation class. It provides implementation of apis of order management services {@link OrderBOInterface}
 * 
 * @author nikhil.bhide  $Date : April 27, 2016$
 **/
import com.mock.service.order.dao.OrderDaoInterface;

/**
 * OrderBO implementation. It provides implementation of business services of order management system.
 ** 
 * @author nikhil.bhide  $Date : April 27, 2016$
 **/

import com.mock.service.order.dto.Order;

public class OrderBOImpl implements OrderBOInterface {
	private OrderDaoInterface orderDao;
	
	//getter for order dao
	public OrderDaoInterface getOrderDao() {
		return orderDao;
	}

	//setter for order dao
	public void setOrderDao(OrderDaoInterface orderDao) {
		this.orderDao = orderDao;
	}

	/**
	 * This method places order in the system. It calls {@link OrderDaoInterface} to persist order data in the system.
	 * 
	 * @param Order The order to be placed
	 * @return long The Id of order
	 */
	public long placeOrder(Order order) {
		order.setStatus("Ordered");
		return orderDao.create(order);
	}

	/**
	 * This method updates order in the system. This implementation updates the status of the order.
	 * 
	 * @param Order The order to be placed
	 * @param Status The status of the order
	 * @return long The Id of order
	 */	
	public long updateOrder(Order order, String status) {
		order.setStatus(status);
		return orderDao.update(order);
	}

	/**
	 * This method returns order in the system. This implementation updates the status of the order.
	 * 
	 * @param Order The order to be placed
	 * @return long The Id of order
	 */
	public boolean returnOrder(Order order) {
		order.setStatus("Returned");
		return orderDao.delete(order);
	}
	
	/**
	 * This method cancels order in the system. This implementation updates the status of the order.
	 * 
	 * @param Order The order to be placed
	 * @return long The Id of order
	 */

	public boolean cancelOrder(Order order) {
		order.setStatus("Cancelled");
		return orderDao.delete(order);
	}

	/**
	 * Calculates amount to refund in case order is returned or cancelled.
	 * Calculation is based on the discount and fixed constant percentage (penalty percentage) 
	 * 
	 * @param Order The order to be placed
	 * 	 * @return long The Id of order
	 */
	public double getAmoutToRefund(Order order) {
		double amount = order.getPrice();
		double discount = order.getDiscount();
		return amount + amount * 0.05 + discount;		
	}

	/**
	 *  Calculates total revenue generated from all orders which are complete.
	 * 
	 ** @return amount - The sum of prices of all orders which are complete
	 */
	public double getTotalRevenue() {
		return orderDao.getAllOrders()
				.stream()
				.filter(p -> p.getStatus().equals("Completed"))
				.mapToDouble(p->p.getPrice())
				.sum();
	}
}