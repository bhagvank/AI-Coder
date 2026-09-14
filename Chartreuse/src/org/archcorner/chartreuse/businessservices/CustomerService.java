/**
 * 
 */
package org.archcorner.chartreuse.businessservices;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import org.archcorner.chartreuse.dal.dao.CustomerDAO;
import org.archcorner.chartreuse.pojo.Customer;


/**
 * @author bhagvan_kommadi
 *
 */
public class CustomerService {

	/**
	 * 
	 */
	public CustomerService() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */

		

		public void insertCustomer(String customerProperties)
		{
			StringTokenizer stringTokenizer = new StringTokenizer(customerProperties,"@@");
			
			Customer customer = new Customer();
			//customer.setCustomerId(Integer.parseInt(stringTokenizer.nextToken()));
			customer.setCustomerName(stringTokenizer.nextToken());
			customer.setStreetAddress(stringTokenizer.nextToken());
			customer.setCity(stringTokenizer.nextToken());
			customer.setState(stringTokenizer.nextToken());
			customer.setCountry(stringTokenizer.nextToken());
			customer.setZipCode(stringTokenizer.nextToken());
			customer.setContactNo(stringTokenizer.nextToken());
			
			CustomerDAO customerDAO = new CustomerDAO();
			customerDAO.insertCustomer(customer);
		}
		
		public void updateCustomer(String customerProperties)
		{
			StringTokenizer stringTokenizer = new StringTokenizer(customerProperties,"@@");
			
			Customer customer = new Customer();
			customer.setCustomerId(Integer.parseInt(stringTokenizer.nextToken()));
			customer.setCustomerName(stringTokenizer.nextToken());
			customer.setStreetAddress(stringTokenizer.nextToken());
			customer.setCity(stringTokenizer.nextToken());
			customer.setState(stringTokenizer.nextToken());
			customer.setCountry(stringTokenizer.nextToken());
			customer.setZipCode(stringTokenizer.nextToken());
			customer.setContactNo(stringTokenizer.nextToken());
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
		
		public Customer[] getAll()
		{
			CustomerDAO customerDAO = new CustomerDAO();
			
			List<Customer> customerList = customerDAO.getCustomers();
			 
			Customer[] customers = new Customer[customerList.size()];
			return customerList.toArray(customers);
		}
		
		public void deleteCustomer(String customerProperties)
		{
			StringTokenizer stringTokenizer = new StringTokenizer(customerProperties, "@@");
			Customer customer = new Customer();
			customer.setCustomerId(Integer.parseInt(stringTokenizer.nextToken()));
			customer.setCustomerName(stringTokenizer.nextToken());
			customer.setStreetAddress(stringTokenizer.nextToken());
			customer.setCity(stringTokenizer.nextToken());
			customer.setState(stringTokenizer.nextToken());
			customer.setCountry(stringTokenizer.nextToken());
			customer.setZipCode(stringTokenizer.nextToken());
			customer.setContactNo(stringTokenizer.nextToken());
			CustomerDAO customerDAO = new CustomerDAO();
			customerDAO.deleteCustomer(customer);
		}
		
		public int getHighestId()
		{
			CustomerDAO customerDAO = new CustomerDAO();
			return customerDAO.getHighestId();
		}

}
