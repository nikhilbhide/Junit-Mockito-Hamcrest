package com.mockdemo.test.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import com.mock.service.order.bo.OrderBOImpl;
import com.mock.service.order.bo.OrderBOInterface;
import com.mock.service.order.dao.OrderDaoImpl;
import com.mock.service.order.dto.Order;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;
/**
 * Unit test to test order service.
 *  * 
 * @author nikhil.bhide  $Date : April 27, 2016$
 **/
@RunWith(MockitoJUnitRunner.class)
public class TestOrderService {
	@Mock
	private OrderDaoImpl orderDao;
	
	private Order order1;
	private Order order2;
	private Order order3;
	private Order order4;
	private Order order5;
	private Order order6;
	private Order order7;

	@InjectMocks
	OrderBOInterface orderBO = new OrderBOImpl();
	
	@Spy
	OrderDaoImpl orderDao_spy1 = new OrderDaoImpl();
	@Spy
	OrderDaoImpl orderDao_spy2 = new OrderDaoImpl();
	
	OrderBOImpl orderBO1 = new OrderBOImpl();
	OrderBOImpl orderBO2 = new OrderBOImpl();
		
	@Before
	public void setUp() throws IllegalAccessException{
		//Create few instances of Order class.
		order1 = new Order(1,"Tshirt","T shirt",100,"xyz01","hp1",0.00,"");
		order2 = new Order(2,"Audio Device","Audim Device",200.90,"xyz02","Samsung1",10.00,"");
		order3 = new Order(3,"Formal Shirt","Formal shirt",100,"xyz01","RYM",0.00,"Completed");
		order4 = new Order(4,"Laptop","Laptop",70000.90,"amdg","dell1",10.00,"Completed");
		order5 = new Order(5,"Tshirt","T shirt",200.90,"sgfkn","hp2",10.00,"Completed");
		order6 = new Order(6,"TV","TV",200.90,"sdfsg","LG2",10.00,"Completed");
		order7 = new Order(7,"Stationary","Stationary ",270.20,"lsdfh","Venus1",20.00,"Completed");
		
		//configure mock objects
		when(orderDao.create(order1)).thenReturn(order1.getId());
		when(orderDao.update(order1)).thenReturn(order1.getId());
		when(orderDao.delete(order1)).thenReturn(true);
		when(orderDao.getAllOrders()).thenReturn(Arrays.asList(order1,order2,order3,order4,order5,order6,order7));
		
		//difference between spy and mock
		when(orderDao_spy1.create(order2)).thenReturn(order2.getId());
		doReturn(order2.getId()).when(orderDao_spy2).create(order2);
		
		orderBO1.setOrderDao(orderDao_spy1);
		orderBO2.setOrderDao(orderDao_spy2);
	}

	@Test
	public void testCreate() {
		assertEquals(1,orderBO.placeOrder(order1));
		assertEquals("Ordered",order1.getStatus());		
	}
	
	@Test
	public void testUpdate() {
		assertEquals(1,orderBO.updateOrder(order1,"Received"));
		assertEquals("Received",order1.getStatus());
	}
	
	@Test
	public void testDelete() {
		assertEquals(true,orderBO.returnOrder(order1));
		assertEquals("Returned",order1.getStatus());
	}
	
	@Test
	public void testTotalRevenue() {
		assertEquals(70772.9,orderBO.getTotalRevenue(),0);
	}
	
	@Test
	public void testSpy() {
		assertEquals(2,orderBO1.placeOrder(order2));
		assertEquals("Ordered",order2.getStatus());		
		assertEquals(2,orderBO2.placeOrder(order2));
		assertEquals("Ordered",order2.getStatus());
	}
	
	@Test
	public void testMethodCall() {
		orderBO.placeOrder(order1);
		verify(orderDao).create(Matchers.eq(order1));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testPriceValidation() {
		order1.setPrice(-12.203);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testDiscountValidationNegativeBoundaryCase() {
		order1.setDiscount(-12.203);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testDiscountValidationAboveHunderedPercentageCase() {
		order1.setDiscount(+102.203);
	}
	
	
	@Test (expected=IllegalArgumentException.class)
	public void testInvalidObjectCreation() throws IllegalAccessException {
		new Order(100,"Stationary","Stationary ",-270.20,"lsdfh","Venus1",-20.00,"Completed");
	}
	
	@Test
	public void testValidObjectCreation() throws IllegalAccessException {
		new Order(100,"Stationary","Stationary ",1270.20,"lsdfh","Venus1",10.00,"Completed");
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void testValidIdField() {
		order1.setId(0);
	}
	
	@Test
	public void testValidItemName() {
		order1.setItemName("electric bike");
		assertThat("ELECTRIC BIKE",equalTo(order1.getItemName()));
	}
	
	@Test
	public void testValid() {
		order1.setItemName("electric bike");
		assertThat("ELECTRIC BIKE",equalTo(order1.getItemName()));
	}
	
	@Test
	public void testAmountToRefund() {
		assertThat(303.71,is(orderBO.getAmoutToRefund(order7)));
	}
}