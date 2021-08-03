package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.CustomerDAO;
import org.archcorner.chartreuse.pojo.Customer;

public class CustomerBusinessDelegate{ 


private CustomerDAO customerDAO ;

public int getHighestId()
 {
  customerDAO = new CustomerDAO();
   int id=customerDAO.getHighestId();
   return id;
 } 

public void insertCustomer(Customer customer)
 {
  customerDAO = new CustomerDAO();
  customerDAO.insertCustomer(customer);
 } 

public void updateCustomer(Customer customer)
 {
  customerDAO = new CustomerDAO();
  customerDAO.updateCustomer(customer);
 } 

public void deleteCustomer(Customer customer)
 {
  customerDAO = new CustomerDAO();
  customerDAO.deleteCustomer(customer);
 } 

public Customer  getCustomerById(int customerId)
 {
  customerDAO = new CustomerDAO();
  Customer customer= customerDAO.getCustomerById(customerId);
 return customer;
 } 

public Customer  getCustomer(String customerName)
 {
  customerDAO = new CustomerDAO();
  Customer customer= customerDAO.getCustomer(customerName);
 return customer;
 } 

public List<Customer>  getAll( )
 {
  customerDAO = new CustomerDAO();
   List<Customer>  customers = customerDAO.getCustomers( );
 return customers;
 } 

} 

