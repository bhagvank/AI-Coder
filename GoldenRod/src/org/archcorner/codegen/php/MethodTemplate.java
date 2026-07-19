package org.archcorner.codegen.php;

import java.util.List;

public class MethodTemplate {
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ParameterTemplate> getParameters() {
		return parameters;
	}
	public void setParameters(List<ParameterTemplate> parameters) {
		this.parameters = parameters;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
private String name;
   private List<ParameterTemplate> parameters;
   private String type;
   private List<VariableTemplate> variables;
   
   /**
 * @return the variables
 */
public List<VariableTemplate> getVariables() {
	return variables;
}
/**
 * @param variables the variables to set
 */
public void setVariables(List<VariableTemplate> variables) {
	this.variables = variables;
}
/**
 * @return the access
 */
public String getAccess() {
	return access;
}
/**
 * @param access the access to set
 */
public void setAccess(String access) {
	this.access = access;
}
/**
 * @return the returnType
 */
public String getReturnType() {
	return returnType;
}
/**
 * @param returnType the returnType to set
 */
public void setReturnType(String returnType) {
	this.returnType = returnType;
}
private String access;
   private String returnType;
	
}
