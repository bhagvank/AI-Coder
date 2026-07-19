package org.archcorner.codegen.java;

import java.util.List;

public class ClassTemplate {
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MemberTemplate> getMembers() {
		return members;
	}
	public void setMembers(List<MemberTemplate> members) {
		this.members = members;
	}
	public List<MethodTemplate> getMethods() {
		return methods;
	}
	public void setMethods(List<MethodTemplate> methods) {
		this.methods = methods;
	}
   private String name;
   private List<MemberTemplate> members;
   private List<MethodTemplate> methods;
   
}
