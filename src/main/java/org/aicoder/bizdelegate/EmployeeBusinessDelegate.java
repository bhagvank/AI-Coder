package org.aicoder.bizdelegate;
import java.util.List;
import org.archcorner.chartreuse.dal.dao.EmployeeDAO;
import org.archcorner.chartreuse.pojo.Employee;

public class EmployeeBusinessDelegate{ 


private EmployeeDAO employeeDAO ;

public int getHighestId()
 {
  employeeDAO = new EmployeeDAO();
   int id=employeeDAO.getHighestId();
   return id;
 } 

public void insertEmployee(Employee employee)
 {
  employeeDAO = new EmployeeDAO();
  employeeDAO.insertEmployee(employee);
 } 

public void updateEmployee(Employee employee)
 {
  employeeDAO = new EmployeeDAO();
  employeeDAO.updateEmployee(employee);
 } 

public void deleteEmployee(Employee employee)
 {
  employeeDAO = new EmployeeDAO();
  employeeDAO.deleteEmployee(employee);
 } 

public Employee  getEmployeeById(int employeeId)
 {
  employeeDAO = new EmployeeDAO();
  Employee employee= employeeDAO.getEmployeeById(employeeId);
 return employee;
 } 

public Employee  getEmployee(String employeeName)
 {
  employeeDAO = new EmployeeDAO();
  Employee employee= employeeDAO.getEmployee(employeeName);
 return employee;
 } 

public List<Employee>  getAll( )
 {
  employeeDAO = new EmployeeDAO();
   List<Employee>  employees = employeeDAO.getEmployees( );
 return employees;
 } 

} 

