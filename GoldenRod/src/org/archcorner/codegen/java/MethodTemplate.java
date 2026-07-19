package org.archcorner.codegen.java;

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
