package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {

    private List<ITask> tasks = new ArrayList();
	/**
	 * @return the tasks
	 */
	public List<ITask> getTasks() {
		return tasks;
	}

	/**
	 * @param tasks the tasks to set
	 */
	public void setTasks(List<ITask> tasks) {
		this.tasks = tasks;
	}

	public TaskManager() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTask(ITask task)
	{
		tasks.add(task);
	}
	
	

}
