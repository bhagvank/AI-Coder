package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class JobManager {

	private List<IJob> jobs = new ArrayList();
	
	/**
	 * @return the jobs
	 */
	public List<IJob> getJobs() {
		return jobs;
	}

	/**
	 * @param jobs the jobs to set
	 */
	public void setJobs(List<IJob> jobs) {
		this.jobs = jobs;
	}

	public void addJob(IJob job)
	{
		jobs.add(job);
	}
	
	public void runJobs()
	{
		for(IJob job: jobs)
		{
			job.runTasks();
		}
	}
	public JobManager() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)
	{
		JobManager jobManager = new JobManager();
		
		Job job = new Job();
		
		JobInput input = new JobInput();
		
		job.setInput(input);
		
		List<ITask> tasks = job.getTasks();
		
		BigDataTask task = new BigDataTask();
		tasks.add(task);
		jobManager.addJob(job);
		
		jobManager.runJobs();
	}
}
