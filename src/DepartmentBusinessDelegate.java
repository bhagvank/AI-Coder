import java.util.List;
import org.archcorner.chartreuse.dal.dao.DepartmentDAO;
import org.archcorner.chartreuse.pojo.Department;

public class DepartmentBusinessDelegate{ 


private DepartmentDAO departmentDAO ;

public int getHighestId()
 {
  departmentDAO = new DepartmentDAO();
   int id=departmentDAO.getHighestId();
   return id;
 } 

public void insertDepartment(Department department)
 {
  departmentDAO = new DepartmentDAO();
  departmentDAO.insertDepartment(department);
 } 

public void updateDepartment(Department department)
 {
  departmentDAO = new DepartmentDAO();
  departmentDAO.updateDepartment(department);
 } 

public void deleteDepartment(Department department)
 {
  departmentDAO = new DepartmentDAO();
  departmentDAO.deleteDepartment(department);
 } 

public Department  getDepartmentById(int departmentId)
 {
  departmentDAO = new DepartmentDAO();
  Department department= departmentDAO.getDepartmentById(departmentId);
 return department;
 } 

public Department  getDepartment(String departmentName)
 {
  departmentDAO = new DepartmentDAO();
  Department department= departmentDAO.getDepartment(departmentName);
 return department;
 } 

public List<Department>  getAll( )
 {
  departmentDAO = new DepartmentDAO();
   List<Department>  departments = departmentDAO.getDepartments( );
 return departments;
 } 

} 

