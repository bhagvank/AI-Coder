package org.aicoder.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.archcorner.chartreuse.pojo.Blog;
import org.archcorner.chartreuse.util.JDBCManager;

public class BlogDAO{ 


private String highestIDSQL = "SELECT MAX(BLOGID) AS MAXBLOGID FROM BLOG";
private String selectSQL = "SELECT * FROM BLOG WHERE BLOGNAME=?";
private String selectIdSQL = "SELECT * FROM BLOG WHERE BLOGID=?";
private String insertSQL = "INSERT INTO BLOG(BLOGID,BLOGNAME,BLOGADDRESS,BLOGCITY,BLOGSTATE,BLOGCOUNTRY,BLOGZIPCODE) VALUES(?,?,?,?,?,?,?)";
private String updateSQL = "UPDATE BLOG SET BLOGNAME=?,BLOGADDRESS=?,BLOGCITY=?,BLOGSTATE=?,BLOGCOUNTRY=?,BLOGZIPCODE=? WHERE BLOGID=?";
private String deleteSQL = "DELETE FROM BLOG WHERE BLOGID=?";
private String selectAllSQL = "SELECT * FROM BLOG";

public int getHighestId(){
 Connection connection = JDBCManager.getConnection();
 Statement statement = null;
 int highestId=0;
 try
 {
  statement = connection.createStatement();
  ResultSet resultSet = statement.executeQuery(highestIDSQL);
  while(resultSet.next())
   {
    highestId = resultSet.getInt("MAXBLOGID");
   }
  resultSet.close();
  }
 catch(Exception exception)
  {
   exception.printStackTrace();
  }
 finally
  {
  try
   {
     statement.close();
   }
  catch(Exception exception)
   {
    exception.printStackTrace();
   }
  JDBCManager.closeConnection(connection);
 }
 return highestId;
}

public Blog getBlogById(int blogid)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Blog blog = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectIdSQL);
     preparedStatement.setInt(1, blogid);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("blogid");
      String blogname = resultSet.getString("BLOGNAME");
      String blogaddress = resultSet.getString("BLOGADDRESS");
      String blogcity = resultSet.getString("BLOGCITY");
      String blogstate = resultSet.getString("BLOGSTATE");
      String blogcountry = resultSet.getString("BLOGCOUNTRY");
      String blogzipcode = resultSet.getString("BLOGZIPCODE");
      blog = new Blog();
      blog.setBlogId(id);
      blog.setBlogName(blogname);
      blog.setBlogAddress(blogaddress);
      blog.setBlogCity(blogcity);
      blog.setBlogState(blogstate);
      blog.setBlogCountry(blogcountry);
      blog.setBlogZipCode(blogzipcode);
      }
    }
    catch(Exception exception)
     {
      exception.printStackTrace();
     }
    finally
    {
   try
    {
     preparedStatement.close();
    }
   catch(Exception exception)
    {
     exception.printStackTrace();
   }
   JDBCManager.closeConnection(connection);
	}
  return blog;
 }

public Blog getBlog(String blogname)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
   Blog blog = null;
   try
    {
     preparedStatement = connection.prepareStatement(selectSQL);
     preparedStatement.setString(1, blogname);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BlogId");
      blogname = resultSet.getString("BLOGNAME");
      String blogaddress = resultSet.getString("BLOGADDRESS");
      String blogcity = resultSet.getString("BLOGCITY");
      String blogstate = resultSet.getString("BLOGSTATE");
      String blogcountry = resultSet.getString("BLOGCOUNTRY");
      String blogzipcode = resultSet.getString("BLOGZIPCODE");
      blog = new Blog();
      blog.setBlogId(id);
      blog.setBlogName(blogname);
      blog.setBlogAddress(blogaddress);
      blog.setBlogCity(blogcity);
      blog.setBlogState(blogstate);
      blog.setBlogCountry(blogcountry);
      blog.setBlogZipCode(blogzipcode);
      }
    }
    catch(Exception exception)
     {
      exception.printStackTrace();
     }
    finally
    {
   try
    {
     preparedStatement.close();
    }
   catch(Exception exception)
    {
     exception.printStackTrace();
   }
   JDBCManager.closeConnection(connection);
	}
  return blog;
 }

public void deleteBlog(Blog blog)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(deleteSQL);
    preparedStatement.setInt(1, blog.getBlogId());
    preparedStatement.executeUpdate();
   }
  catch(Exception exception)
   {
    exception.printStackTrace();
   }
  finally
   {
    try
     {
      if(preparedStatement != null)
       {
        preparedStatement.close();
       }
     }
    catch(Exception exception)
     {
      exception.printStackTrace();
     }
    JDBCManager.closeConnection(connection);
   }
 }

public void insertBlog(Blog blog)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(insertSQL);
    preparedStatement.setInt(1, getHighestId()+1);
    preparedStatement.setString(2,blog.getBlogName());
    preparedStatement.setString(3,blog.getBlogAddress());
    preparedStatement.setString(4,blog.getBlogCity());
    preparedStatement.setString(5,blog.getBlogState());
    preparedStatement.setString(6,blog.getBlogCountry());
    preparedStatement.setString(7,blog.getBlogZipCode());
    preparedStatement.execute();
   }
  catch(Exception exception)
   {
    exception.printStackTrace();
   }
  finally
   {
    try
     {
      if(preparedStatement != null)
       {
        preparedStatement.close();
       }
     }
    catch(Exception exception)
    {
     exception.printStackTrace();
    }
   JDBCManager.closeConnection(connection);
   }
 }

public void updateBlog(Blog blog)
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  try
   {
    preparedStatement = connection.prepareStatement(updateSQL);
    preparedStatement.setString(1,blog.getBlogName());
    preparedStatement.setString(2,blog.getBlogAddress());
    preparedStatement.setString(3,blog.getBlogCity());
    preparedStatement.setString(4,blog.getBlogState());
    preparedStatement.setString(5,blog.getBlogCountry());
    preparedStatement.setString(6,blog.getBlogZipCode());
    preparedStatement.setInt(7, blog.getBlogId());
    preparedStatement.executeUpdate();
   }
  catch(Exception exception)
   {
    exception.printStackTrace();
   }
  finally
   {
    try
     {
      if(preparedStatement != null)
       {
        preparedStatement.close();
       }
     }
    catch(Exception exception)
    {
     exception.printStackTrace();
    }
   JDBCManager.closeConnection(connection);
   }
 }

public List<Blog> getBlogs( )
 {
  Connection connection = JDBCManager.getConnection();
  PreparedStatement preparedStatement = null;
  List<Blog> blogList = new ArrayList<Blog>();
   try
    {
     preparedStatement = connection.prepareStatement(selectAllSQL);
     ResultSet resultSet = preparedStatement.executeQuery();
     while(resultSet.next())
      {
       int id =resultSet.getInt("BLOGID");
      String blogname = resultSet.getString("BLOGNAME");
      String blogaddress = resultSet.getString("BLOGADDRESS");
      String blogcity = resultSet.getString("BLOGCITY");
      String blogstate = resultSet.getString("BLOGSTATE");
      String blogcountry = resultSet.getString("BLOGCOUNTRY");
      String blogzipcode = resultSet.getString("BLOGZIPCODE");
      Blog blog = new Blog();
      blog.setBlogId(id);
      blog.setBlogName(blogname);
      blog.setBlogAddress(blogaddress);
      blog.setBlogCity(blogcity);
      blog.setBlogState(blogstate);
      blog.setBlogCountry(blogcountry);
      blog.setBlogZipCode(blogzipcode);
       blogList.add(blog);
      }
    }
    catch(Exception exception)
     {
      exception.printStackTrace();
     }
    finally
    {
   try
    {
     preparedStatement.close();
    }
   catch(Exception exception)
    {
     exception.printStackTrace();
   }
   JDBCManager.closeConnection(connection);
	}
  return blogList;
 }

public static void main( String[] args ) {
}

} 

