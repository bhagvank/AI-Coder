/**
 * 
 */
package org.archcorner.chartreuse.businessservices;

import java.util.List;
import java.util.StringTokenizer;

import org.archcorner.chartreuse.dal.dao.OrderDAO;
import org.archcorner.chartreuse.pojo.Order;

/**
 * @author bhagvan_kommadi
 *
 */
public class OrderService {

	/**
	 * 
	 */
	public OrderService() {
		// TODO Auto-generated constructor stub
	}

	public void insertOrder(String orderProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(orderProperties,"@@");
		
		Order order = new Order();
		//order.setOrderId(Integer.parseInt(stringTokenizer.nextToken()));
		order.setCustomerName(stringTokenizer.nextToken());
		order.setProductName(stringTokenizer.nextToken());
		order.setProductModel(stringTokenizer.nextToken());
		order.setOrderDate(stringTokenizer.nextToken());
		order.setDeliveryDate(stringTokenizer.nextToken());
		order.setContactNo(stringTokenizer.nextToken());
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insertOrder(order);
	}
	
	public void updateOrder(String orderProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(orderProperties,"@@");
		
		Order order = new Order();
		order.setOrderId(Integer.parseInt(stringTokenizer.nextToken()));
		order.setCustomerName(stringTokenizer.nextToken());
		order.setProductName(stringTokenizer.nextToken());
		order.setProductModel(stringTokenizer.nextToken());
		order.setOrderDate(stringTokenizer.nextToken());
		order.setDeliveryDate(stringTokenizer.nextToken());
		order.setContactNo(stringTokenizer.nextToken());
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.updateOrder(order);
	}
	
	public Order getOrderById(int orderId)
	{
		OrderDAO orderDAO = new OrderDAO();
		 return orderDAO.getOrderById(orderId);
	}
	public Order getOrder(String orderName)
	{
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getOrder(orderName);
	}
	
	public Order[] getAll()
	{
		OrderDAO orderDAO = new OrderDAO();
		
		List<Order> orderList = orderDAO.getOrders();
		 
		Order[] orders = new Order[orderList.size()];
		return orderList.toArray(orders);
	}
	
	public void deleteOrder(String orderProperties)
	{
		StringTokenizer stringTokenizer = new StringTokenizer(orderProperties, "@@");
		Order order = new Order();
		order.setOrderId(Integer.parseInt(stringTokenizer.nextToken()));
		order.setCustomerName(stringTokenizer.nextToken());
		order.setProductName(stringTokenizer.nextToken());
		order.setProductModel(stringTokenizer.nextToken());
		order.setOrderDate(stringTokenizer.nextToken());
		order.setDeliveryDate(stringTokenizer.nextToken());
		order.setContactNo(stringTokenizer.nextToken());
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.deleteOrder(order);
	}
	
	public int getHighestId()
	{
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getHighestId();
	}
}
