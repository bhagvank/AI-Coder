import java.util.List;
import org.archcorner.chartreuse.dal.dao.BlogDAO;
import org.archcorner.chartreuse.pojo.Blog;

public class BlogBusinessDelegate{ 


private BlogDAO blogDAO ;

public int getHighestId()
 {
  blogDAO = new BlogDAO();
   int id=blogDAO.getHighestId();
   return id;
 } 

public void insertBlog(Blog blog)
 {
  blogDAO = new BlogDAO();
  blogDAO.insertBlog(blog);
 } 

public void updateBlog(Blog blog)
 {
  blogDAO = new BlogDAO();
  blogDAO.updateBlog(blog);
 } 

public void deleteBlog(Blog blog)
 {
  blogDAO = new BlogDAO();
  blogDAO.deleteBlog(blog);
 } 

public Blog  getBlogById(int blogId)
 {
  blogDAO = new BlogDAO();
  Blog blog= blogDAO.getBlogById(blogId);
 return blog;
 } 

public Blog  getBlog(String blogName)
 {
  blogDAO = new BlogDAO();
  Blog blog= blogDAO.getBlog(blogName);
 return blog;
 } 

public List<Blog>  getAll( )
 {
  blogDAO = new BlogDAO();
   List<Blog>  blogs = blogDAO.getBlogs( );
 return blogs;
 } 

} 

