/**
 * 
 */
package org.archcorner.codegen.angular;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bhagvan.kommadi
 *
 */
public class HTMLTemplate {

	private String entity;
	/**
	 * @return the entity
	 */
	public String getEntity() {
		return entity;
	}


	/**
	 * @param entity the entity to set
	 */
	public void setEntity(String entity) {
		this.entity = entity;
	}


	/**
	 * @return the idEntity
	 */
	public String getIdEntity() {
		return idEntity;
	}


	/**
	 * @param idEntity the idEntity to set
	 */
	public void setIdEntity(String idEntity) {
		this.idEntity = idEntity;
	}


	/**
	 * @return the nameEntity
	 */
	public String getNameEntity() {
		return nameEntity;
	}


	/**
	 * @param nameEntity the nameEntity to set
	 */
	public void setNameEntity(String nameEntity) {
		this.nameEntity = nameEntity;
	}


	/**
	 * @return the pojoMembers
	 */
	public List<String> getPojoMembers() {
		return pojoMembers;
	}


	/**
	 * @param pojoMembers the pojoMembers to set
	 */
	public void setPojoMembers(List<String> pojoMembers) {
		this.pojoMembers = pojoMembers;
	}


	private String idEntity;
	private String nameEntity;
	private List<String> pojoMembers;
	private String app;
	private String page;
	private String webservices;
	private String webservicesUpdate;
	
	private List<String> entityColumns;
	
	
	/**
	 * @return the entityColumns
	 */
	public List<String> getEntityColumns() {
		return entityColumns;
	}


	/**
	 * @param entityColumns the entityColumns to set
	 */
	public void setEntityColumns(List<String> entityColumns) {
		this.entityColumns = entityColumns;
	}


	/**
	 * @return the webservicesUpdate
	 */
	public String getWebservicesUpdate() {
		return webservicesUpdate;
	}


	/**
	 * @param webservicesUpdate the webservicesUpdate to set
	 */
	public void setWebservicesUpdate(String webservicesUpdate) {
		this.webservicesUpdate = webservicesUpdate;
	}


	/**
	 * @return the webservices
	 */
	public String getWebservices() {
		return webservices;
	}


	/**
	 * @param webservices the webservices to set
	 */
	public void setWebservices(String webservices) {
		this.webservices = webservices;
	}


	/**
	 * @return the page
	 */
	public String getPage() {
		return page;
	}


	/**
	 * @param page the page to set
	 */
	public void setPage(String page) {
		this.page = page;
	}


	/**
	 * @return the app
	 */
	public String getApp() {
		return app;
	}


	/**
	 * @param app the app to set
	 */
	public void setApp(String app) {
		this.app = app;
	}
	
   public String getDeleteFormCode()
   {
	   CodeManager manager = new CodeManager();
	   String code = manager.openHTMLCode(app);
	   code = code + "<head> \n";
		code = code + "<meta charset=\"utf-8\"> \n";
       code = code + "<title>"+ page+"Form" +"</title> \n";
       code = code + "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js\"></script>\n";
       code = code +"<script>\n";
       code = code +"var "+app +"= angular.module('"+app+"', []);\n";
       code = code + app+".controller('"+entity+"Ctrl', function ($scope, $http,$location){\n";
       code = code + "var str = $location.absUrl();\n";
       code = code + "var params = str.split(\"?\");\n";
       code = code + "var param_id = params[1].split(\"=\");\n";
       code = code + "$scope."+entity.toLowerCase()+"s = [];\n";
       code = code +"$scope."+entity.toLowerCase()+"Form = {\n";
       code = code +entity.toLowerCase()+"id : param_id[1] };\n";
       code = code +"_refresh"+entity+"Data(){\n";
       code = code +"$http({\n";
       code = code + "method : 'POST',\n";
       code = code + "'"+webservices+"',\n";
       code = code + "	       data : angular.toJson($scope."+entity.toLowerCase()+"Form),\n";
       code = code + "headers : {\n";
       code = code + "'Content-Type' : 'application/json'\n";
       code = code + "}\n";
	   code = code + "}).then(function successCallback(response) {\n";
	   code = code + "$scope."+entity.toLowerCase()+"Form = response.data;\n";
	   code = code + "     }, function errorCallback(response) {   }); }\n";
	   code = code + " });\n";
	   code = code +"})(window.angular);\n";
	   code = code + "</script>\n";
	   code = code + "</head>\n";
       code = code + "<body>\n";
       code = code + "<title>"+entity+"Delete </title>\n";
       code = code + "<h1>AngularJS "+entity+"</h1>\n";
       code = code +"<h2> "+entity+ " deleted</h2>\n";
       
	   code = code+"</body>\n";
		code = code + manager.closeHTMLCode();
		
		return code;
	   
   }
   public  String getEditFormCode()
   {
	   
	   CodeManager manager = new CodeManager();
	   String code = manager.openHTMLCode(app);
	   code = code + "<head> \n";
		code = code + "<meta charset=\"utf-8\"> \n";
       code = code + "<title>"+ page+"Form" +"</title> \n";
       code = code + "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js\"></script>\n";
       code = code +"<script>\n";
       code = code +"var "+app +"= angular.module('"+app+"', []);\n";
       code = code + app+".controller('"+entity+"Ctrl', function ($scope, $http,$location){\n";
       code = code + "var str = $location.absUrl();\n";
       code = code + "var params = str.split(\"?\");\n";
       code = code + "var param_id = params[1].split(\"=\");\n";
       code = code + "$scope."+entity.toLowerCase()+"s = [];\n";
       code = code +"$scope."+entity.toLowerCase()+"Form = {\n";
       code = code +entity.toLowerCase()+"id : param_id[1] };\n";
       code = code +"_refresh"+entity+"Data(){\n";
       code = code +"$http({\n";
       code = code + "method : 'POST',\n";
       code = code + "'"+webservices+"',\n";
       code = code + "	       data : angular.toJson($scope."+entity.toLowerCase()+"Form),\n";
       code = code + "headers : {\n";
       code = code + "'Content-Type' : 'application/json'\n";
       code = code + "}\n";
	   code = code + "}).then(function successCallback(response) {\n";
	   code = code + "$scope."+entity.toLowerCase()+"Form = response.data;\n";
	   code = code + "     }, function errorCallback(response) {   }); }\n";
       code = code + "$scope.submit"+entity+" = function() {\n";	  	       
       code = code + "method = \"POST\";\n";
       code = code + "url = \""+webservicesUpdate+"\"";
       code = code +"$http({\n";
       code = code + "method : method,\n";
       code = code + "url : url,\n";
       code = code + "data : angular.toJson($scope."+entity.toLowerCase()+"Form),\n";
       code = code + "headers : {\n";
       code = code + "'Content-Type' : 'application/json'\n";
       code = code + "}\n";
	   code = code + "}).then(_success,_error); };\n";	     
       code = code + "function _success(response) {\n";
	   code = code + "_clearFormData();\n";          
	   code = code + "}\n";
	   
	   code = code + "function _error(response) {\n";
	   code = code + "console.log(response.statusText);}\n";
	   code = code + "function _clearFormData() {\n";
	   
	   for(String pojoMember: pojoMembers)
       {
          code = code +"$scope."+entity.toLowerCase() +"Form."+pojoMember.toLowerCase()+"=\"\";\n"; 
       }
	   code = code + "};\n";
	   code = code + " });\n";
	   code = code +"})(window.angular);\n";
	   code = code + "</script>\n";
	   code = code + "</head>\n";
       code = code + "<body>\n";
       code = code + "<div ng-app=\""+ app+"\" ng-controller=\""+entity+"Ctrl\">\n";
       code = code + "<form ng-submit=\"submit"+entity+"()\">\n"; 
       code = code +"<input type=\"hidden\" ng-model=\""+entity.toLowerCase()+"Form."+idEntity+"\" />\n";
       
       for(String pojoMember: pojoMembers)
       {
       	code = code + "<div>\n";
          code = code + "<label>"+pojoMember+":<sup>*</sup></label>\n"; 	
          code = code +"<input type=\"text\" ng-model=\""+entity.toLowerCase()+"Form."+pojoMember+"\" />\n"; 
          code = code+"</div>\n";
       }
       code = code + "</form>";
       code = code+"</div>\n";  
	   code = code+"</body>\n";
		code = code + manager.closeHTMLCode();
		
		return code;
   }

	public String getFormCode()
	{
		CodeManager manager = new CodeManager();
		String code = manager.openHTMLCode(app);
		code = code + "<head> \n";
		code = code + "<meta charset=\"utf-8\"> \n";
        code = code + "<title>"+ page+"Form" +"</title> \n";
        code = code + "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js\"></script>\n";
       // code = code +"<script>\n";
        code = code +"<script>\n";
        code = code + "(function(angular) {\n";
        code = code + "'use strict';\n";
        code = code +"var "+app +"= angular.module('"+app+"', []);\n";
        code = code + app+".controller('"+entity+"Ctrl', function ($scope, $http){\n";
        code = code + "$scope."+entity.toLowerCase()+"Form = { };\n";
        
        
        code = code +"$scope.submit"+entity+" = function() {\n";
    		
    	
    	code = code +"var method = \"\";\n";
    	code = code + "var url = \"\";\n";
    	
    	code = code + "method = \"POST\";\n";
    	code = code + "url = \""+webservices+"\";\n";
    	
    	
    	code = code +"$http({\n";
    	code = code +"method : method,\n";
    	code = code +"url : url,\n";
    	code = code +"data : angular.toJson($scope."+entity.toLowerCase()+"Form),\n";
    	code = code+"headers : {\n";
    	code = code+"'Content-Type' : 'application/json'\n";
    	code = code +"}\n";
    	code = code +"}).then( _success, _error );\n";
    	
    	code = code +"};\n";
    	
        code = code + "function _success(response) {\n";
    	code = code + "_clearFormData()\n";
    	code = code + "   }\n";
    	code = code + "function _error(response) {\n";
    	code = code + "console.log(response.statusText);\n";
    	code = code + "alert(response.statusText);\n";
	    code = code + "}\n";
        code = code + "function _clearFormData() {\n";
        
        for(String pojoMember: pojoMembers)
        {
          code = code + "$scope."+entity.toLowerCase()+"Form."+pojoMember+" = \"\";\n";
          
          
        }
        code = code + "}\n"; 
        
        code = code +"});\n";
        code = code +"})(window.angular);\n";
        code = code + "</script>\n";
        code = code + "</head>\n";
        code = code + "<body>\n";
        code = code + "<div ng-app=\""+ app+"\" ng-controller=\""+entity+"Ctrl\">\n";
        code = code + "<form ng-submit=\"submit"+entity+"()\">\n"; 
        //code = code + "<li ng-repeat=\""+entity.toLowerCase()+" in "+entity.toLowerCase()+"s\">\n";
       // code = code +"<input type=\"text\" ng-model=\""+entity.toLowerCase()+"Form."+idEntity+"\" />\n";
        
        for(String pojoMember: pojoMembers)
        {
        	code = code + "<div>\n";
           code = code + "<label>"+pojoMember+":<sup>*</sup></label>\n"; 	
           code = code +"<input type=\"text\" ng-model=\""+entity.toLowerCase()+"Form."+pojoMember+"\" />\n"; 
           code = code+"</div>\n";
        }
        
        code = code + "<input type=\"submit\" value=\"Submit\" class=\"blue-button\" />\n";
        code = code + "</form>\n";
        code = code+"</div>\n";
        code = code+"</body>\n";
		code = code + manager.closeHTMLCode();
		
		return code;
	}
	public String getCode()
	{
		CodeManager manager = new CodeManager();
		String code = manager.openHTMLCode(app);
		code = code + "<head> \n";
		code = code + "<meta charset=\"utf-8\"> \n";
        code = code + "<title>"+ page+"List" +"</title> \n";
        code = code + "<script src=\"http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js\"></script>\n";
        code = code +"<script>\n";
        code = code + "(function(angular) {\n";
        code = code + "'use strict';\n";
        code = code +"var "+app +"= angular.module('"+app+"', []);\n";
        code = code + app+".controller('"+entity+"Ctrl', function ($scope, $http){\n";
        code = code + "$scope."+entity.toLowerCase()+"s = [];\n";
        code = code +"_refresh"+entity+"();\n";
        code = code +"function _refresh"+entity+"() {\n";
        code = code +"var method = \"\";\n";
    	code = code + "var url = \"\";\n";
    	
    	code = code + "method = \"GET\";\n";
    	code = code + "url = \""+webservices+"\";\n";
    	
    	
    	code = code +"$http({\n";
    	code = code +"method : method,\n";
    	code = code +"url : url,\n";
    	code = code+"headers : {\n";
    	code = code+"'Content-Type' : 'application/json'\n";
    	code = code +"}\n";
    	code = code +"}).then( _success, _error );\n";
    	
    	code = code +"};\n";
    	
        code = code + "function _success(response) {\n";
    	code = code + "$scope."+entity.toLowerCase()+"s = response.data;\n";
    	code = code + "   }\n";
    	code = code + "function _error(response) {\n";
    	code = code + "console.log(response.statusText);\n";
    	code = code + "alert(response.statusText);\n";
	    code = code + "}\n";
        
        code = code +"});\n";
        code = code +"})(window.angular);\n";
        code = code + "</script>\n";
        
        code = code + "</head>\n";
        code = code + "<body>\n";
        code = code + "<div ng-app=\""+ app+"\" ng-controller=\""+entity+"Ctrl\">\n";
        code = code + "<ul>\n"; 
        code = code + "<li ng-repeat=\""+entity.toLowerCase()+" in "+entity.toLowerCase()+"s\">\n";
        
        for(String entityColumn:entityColumns)
        {
           code = code +"{{"+entity.toLowerCase() +"."+entityColumn.toLowerCase()+"}}\n"; 
        }
        code = code + "<td><a href=\"edit"+entity+".html?id={{"+entity.toLowerCase()+"."+entity.toLowerCase()+"id}}\">Edit</a> | <a href=\"delete"+entity+".html?id={{"+entity.toLowerCase()+"."+entity.toLowerCase()+"id}}\">Delete</a>\n";
        code = code+"</li>\n";
        code = code+"</ul>\n";
        code = code+"</div>\n";
        code = code+"</body>\n";
		code = code + manager.closeHTMLCode();
		
		return code;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HTMLTemplate template = new HTMLTemplate();

        CodeManager manager = new CodeManager();
		
		
		String entity = "Customer";
		
		
		
		template.setEntity(entity);
		
		String idEntity = "customerID";
		
		template.setIdEntity(idEntity);
		
		String nameEntity = "CUSTOMERNAME";
		
		template.setNameEntity(nameEntity);
		
		String app = "customersApp";
		
		template.setApp(app);
		
		String page = "Customers";
		
		template.setPage(page);
		
		String webservices = "Customers.php";
		template.setWebservices(webservices);
		
		List<String> entityColumns = new ArrayList<String>();
		entityColumns.add("CUSTOMERNAME");
		entityColumns.add("CITY");
		entityColumns.add("STATE");
		entityColumns.add("ZIPCODE");
		entityColumns.add("CONTACTNO");
		entityColumns.add("STREETADDRESS");
		entityColumns.add("COUNTRY");
		
	
		
		template.setEntityColumns(entityColumns);
		
		
		List<String> pojoMembers = new ArrayList<String>();
		pojoMembers.add("Name");
		pojoMembers.add("City");
		pojoMembers.add("State");
		pojoMembers.add("ZipCode");
		pojoMembers.add("ContactNo");
		pojoMembers.add("StreetAddress");
		pojoMembers.add("Country");
		
		template.setPojoMembers(pojoMembers);
		
		String path = "angular";
		manager.createFolder(path);
		manager.createHTML(path,page);
		String code = template.getCode();
		manager.writeCode(code);
		manager.closeClass();
		
		webservices = "InsertCustomer.php";
		template.setWebservices(webservices);
		
		
		manager.createFolder(path);
		manager.createHTML(path,entity+"Form");
		code = template.getFormCode();
		manager.writeCode(code);
		manager.closeClass();
		
		webservices = "GetCustomer.php";
		String webServicesUpdate = "UpdateCustomer.php";
		template.setWebservices(webservices);
		template.setWebservicesUpdate(webServicesUpdate);
		
		manager.createFolder(path);
		manager.createHTML(path,"Edit"+entity+"Form");
		code = template.getEditFormCode();
		manager.writeCode(code);
		manager.closeClass();
		
		
		webservices = "DeleteCustomer.php";
		template.setWebservices(webservices);
		manager.createFolder(path);
		manager.createHTML(path,"Delete"+entity+"Form");
		code = template.getDeleteFormCode();
		manager.writeCode(code);
		manager.closeClass();
	}

}
