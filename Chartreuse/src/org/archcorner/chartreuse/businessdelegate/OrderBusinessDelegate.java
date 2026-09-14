/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.OrderDAO;
import org.archcorner.chartreuse.pojo.Order;

/**
 * @author bhagvan_kommadi
 *
 */
public class OrderBusinessDelegate {

	/**
	 * 
	 */
	public OrderBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}


	public void insertOrder(Order order)
	{
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insertOrder(order);
	}
	
	public void updateOrder(Order order)
	{
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
	
	public List<Order> getAll()
	{
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getOrders();
	}
	
	public void deleteOrder(Order order)
	{
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.deleteOrder(order);
	}
	
	public int getHighestId()
	{
		OrderDAO orderDAO = new OrderDAO();
		return orderDAO.getHighestId();
	}
}
