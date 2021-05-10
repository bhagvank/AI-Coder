import java.util.List;
import org.archcorner.chartreuse.dal.dao.ProjectDAO;
import org.archcorner.chartreuse.pojo.Project;

public class ProjectBusinessDelegate{ 


private ProjectDAO projectDAO ;

public int getHighestId()
 {
  projectDAO = new ProjectDAO();
   int id=projectDAO.getHighestId();
   return id;
 } 

public void insertProject(Project project)
 {
  projectDAO = new ProjectDAO();
  projectDAO.insertProject(project);
 } 

public void updateProject(Project project)
 {
  projectDAO = new ProjectDAO();
  projectDAO.updateProject(project);
 } 

public void deleteProject(Project project)
 {
  projectDAO = new ProjectDAO();
  projectDAO.deleteProject(project);
 } 

public Project  getProjectById(int projectId)
 {
  projectDAO = new ProjectDAO();
  Project project= projectDAO.getProjectById(projectId);
 return project;
 } 

public Project  getProject(String projectName)
 {
  projectDAO = new ProjectDAO();
  Project project= projectDAO.getProject(projectName);
 return project;
 } 

public List<Project>  getAll( )
 {
  projectDAO = new ProjectDAO();
   List<Project>  projects = projectDAO.getProjects( );
 return projects;
 } 

} 

