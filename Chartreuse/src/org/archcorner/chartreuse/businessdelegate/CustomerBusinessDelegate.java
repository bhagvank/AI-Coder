/**
 * 
 */
package org.archcorner.chartreuse.businessdelegate;

import java.util.List;

import org.archcorner.chartreuse.dal.dao.CustomerDAO;
import org.archcorner.chartreuse.pojo.Customer;

/**
 * @author bhagvan_kommadi
 *
 */
public class CustomerBusinessDelegate {

	/**
	 * 
	 */
	public CustomerBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}


	public void insertCustomer(Customer customer)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.insertCustomer(customer);
	}
	
	public void updateCustomer(Customer customer)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.updateCustomer(customer);
	}
	
	public Customer getCustomerById(int customerId)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		 return customerDAO.getCustomerById(customerId);
	}
	public Customer getCustomer(String customerName)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getCustomer(customerName);
	}
	
	public List<Customer> getAll()
	{
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getCustomers();
	}
	
	public void deleteCustomer(Customer customer)
	{
		CustomerDAO customerDAO = new CustomerDAO();
		customerDAO.deleteCustomer(customer);
	}
	
	public int getHighestId()
	{
		CustomerDAO customerDAO = new CustomerDAO();
		return customerDAO.getHighestId();
	}

}
