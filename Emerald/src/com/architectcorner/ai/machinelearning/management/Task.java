package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class Task implements ITask{

	private List<List<String>> taskInput = new ArrayList();
	
	public Task() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void perform() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<List<String>> getTaskInput() {
		// TODO Auto-generated method stub
		return taskInput;
	}

	@Override
	public void setTaskInput(List<List<String>> taskInput) {
		// TODO Auto-generated method stub
		
		this.taskInput = taskInput;
		
	}

}
