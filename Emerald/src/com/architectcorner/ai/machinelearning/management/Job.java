package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class Job implements IJob{
 
	private List<ITask> tasks = new ArrayList();
	
	private JobInput input = new JobInput();
	
	/**
	 * @return the input
	 */
	public JobInput getInput() {
		return input;
	}

	/**
	 * @param input the input to set
	 */
	public void setInput(JobInput input) {
		this.input = input;
	}

	/**
	 * @return the output
	 */
	public JobOutput getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(JobOutput output) {
		this.output = output;
	}

	private JobOutput output = new JobOutput();
	
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

	public Job() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runTasks() {
		// TODO Auto-generated method stub
		
		System.out.println("Running Tasks");
		
		for(ITask task: tasks)
		{
			task.perform();
		}
	}

}
