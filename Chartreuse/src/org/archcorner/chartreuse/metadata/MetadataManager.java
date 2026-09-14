package org.archcorner.chartreuse.metadata;

import java.lang.reflect.Method;
import java.util.*;

import org.archcorner.chartreuse.pojo.User;

public class MetadataManager {

	private static final String POJO = "org.archcorner.chartreuse.pojo.";
	private static final String BUSINESSDELEGATE = "org.archcorner.chartreuse.businessdelegate.";

	public MetadataManager() {
		// TODO Auto-generated constructor stub
	}
	public void deleteEntityValue(String entityName,String entityId, List<String> fields, List<String> values,List<String> fieldClassTypes)
	{
		try
		{
			Class entityClass = Class.forName(BUSINESSDELEGATE+entityName+"BusinessDelegate");
			Object object = entityClass.newInstance();
			Class pojoClass = Class.forName(POJO+entityName);
			Class[] parameterTypes = new Class[1];
			parameterTypes[0] = pojoClass;
			Object pojoObject = pojoClass.newInstance();
			int index=0;
			for(String field: fields)
			{
				Class[] pojoSetParameterTypes = new Class[1];
				pojoSetParameterTypes[0] = Class.forName("java.lang."+fieldClassTypes.get(index));
				Method pojoMethod = pojoClass.getDeclaredMethod("set"+field, pojoSetParameterTypes);
				pojoMethod.invoke(pojoObject, values.get(index));
				index++;
			}
			Class[] pojoIdParameterTypes = new Class[1];
			pojoIdParameterTypes[0] = int.class;
			Method pojoMethod = pojoClass.getDeclaredMethod("set"+entityName+"Id", pojoIdParameterTypes);
			pojoMethod.invoke(pojoObject, Integer.parseInt(entityId));
			
			Method method = entityClass.getDeclaredMethod("delete"+entityName, parameterTypes);
			method.invoke(object, pojoObject);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}
	public void updateEntityValue(String entityName, String entityId,List<String> fields, List<String> values,List<String> fieldClassTypes)
	{
		try
		{
			Class entityClass = Class.forName(BUSINESSDELEGATE+entityName+"BusinessDelegate");
			Object object = entityClass.newInstance();
			Class pojoClass = Class.forName(POJO+entityName);
			Class[] parameterTypes = new Class[1];
			parameterTypes[0] = pojoClass;
			Object pojoObject = pojoClass.newInstance();
			int index=0;
			for(String field: fields)
			{
				Class[] pojoSetParameterTypes = new Class[1];
				pojoSetParameterTypes[0] = Class.forName("java.lang."+fieldClassTypes.get(index));
				Method pojoMethod = pojoClass.getDeclaredMethod("set"+field, pojoSetParameterTypes);
				pojoMethod.invoke(pojoObject, values.get(index));
				index++;
			}
			
			Class[] pojoIdParameterTypes = new Class[1];
			pojoIdParameterTypes[0] = int.class;
			Method pojoMethod = pojoClass.getDeclaredMethod("set"+entityName+"Id", pojoIdParameterTypes);
			pojoMethod.invoke(pojoObject, Integer.parseInt(entityId));
			
			Method method = entityClass.getDeclaredMethod("update"+entityName, parameterTypes);
			method.invoke(object, pojoObject);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
	public void storeEntityValue(String entityName, List<String> fields, List<String> values, List<String> fieldClassTypes)
	{
		
		
		try
		{
			Class entityClass = Class.forName(BUSINESSDELEGATE+entityName+"BusinessDelegate");
			Object object = entityClass.newInstance();
			Class pojoClass = Class.forName(POJO+entityName);
			Class[] parameterTypes = new Class[1];
			parameterTypes[0] = pojoClass;
			Object pojoObject = pojoClass.newInstance();
			int index =0;
			for(String field: fields)
			{
				Class[] pojoSetParameterTypes = new Class[1];
				pojoSetParameterTypes[0] = Class.forName("java.lang."+fieldClassTypes.get(index));
				Method pojoMethod = pojoClass.getDeclaredMethod("set"+field, pojoSetParameterTypes);
				pojoMethod.invoke(pojoObject, values.get(index));
				index++;
			}
			Method method = entityClass.getDeclaredMethod("insert"+entityName, parameterTypes);
			
			method.invoke(object, pojoObject);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
	}
	
	public List<String> getEntityFieldValues(String entityName,String id, List<String> fields)
	{
		List<String> entityFieldValues = new ArrayList<String>();
		try
		{
			Class entityClass = Class.forName(BUSINESSDELEGATE+entityName+"BusinessDelegate");
			Object object = entityClass.newInstance();
			Class[] parameterTypes = new Class[1];
			parameterTypes[0] = int.class;
			Method method = entityClass.getDeclaredMethod("get"+entityName+"ById", parameterTypes);
			
	        Object entityObject = method.invoke(object, Integer.parseInt(id));
			
			
			
			for(String field: fields)
			{
				String value =  getValue(entityObject,"get"+field);
				entityFieldValues.add(value);
			}
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		
		return entityFieldValues;
		
	}
	public List<List<String>> getAllEntityValues(String entityName,List<String> fields)
	{
		List<List<String>> entityValues = new ArrayList();
		
		
		try {
			Class entityClass = Class.forName(BUSINESSDELEGATE+entityName+"BusinessDelegate");
			
			Object object = entityClass.newInstance();
			
			Method method = entityClass.getDeclaredMethod("getAll", null);
			
		  List<?> objectList = (List<?>) method.invoke(object, null);
			
		  for(Object entityObject: objectList)
		  {
			  
			  
			  List<String> fieldValues = new ArrayList();
			  
			  for(String field: fields)
			  {
				  String value = getValue(entityObject, "get"+field);
				  fieldValues.add(value);
			  }
			  
			  entityValues.add(fieldValues);
		  }
		  
		   
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
		
		return entityValues;
		
	}

	public String getValue(Object object,String methodName)
	{
		String value = null;
        Class objectClass = object.getClass();
        
        Method method;
		try 
		{
			method = objectClass.getDeclaredMethod(methodName, null);
			
			 Object valueObject = method.invoke(object, null);
			 
			// System.out.println(valueObject);
			 
			 if(valueObject.getClass().getName().equals(String.class.getName()))
			 {
			  value = (String) valueObject;
			 }
			 else if(valueObject.getClass().getName().equals(Integer.class.getName()))
			 {
		//		 System.out.println("integer");
				value = Integer.toString(((Integer) valueObject).intValue());
			 }
		} catch (Exception exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}
        
       
        
		return value;
	}
	
	public static void main(String[] args)
	{
		MetadataManager manager = new MetadataManager();
		User user = new User();
		user.setUserId(0);
		String userId = manager.getValue(user, "getUserId");
		
		//System.out.println(userId);
		
		List<String> fields = new ArrayList();
		
		fields.add("UserId");
		fields.add("UserName");
		fields.add("Password");
		
		
		List<List<String>> entityValues = manager.getAllEntityValues("User", fields);
		
		for(List<String> fieldValues: entityValues)
		{
			for(String value:fieldValues)
			{
				System.out.println(value);
			}
		}
	}
}
