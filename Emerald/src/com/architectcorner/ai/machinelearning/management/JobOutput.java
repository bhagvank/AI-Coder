package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class JobOutput {

	private List<List<String>> output = new ArrayList();
	
	/**
	 * @return the output
	 */
	public List<List<String>> getOutput() {
		return output;
	}

	/**
	 * @param output the output to set
	 */
	public void setOutput(List<List<String>> output) {
		this.output = output;
	}

	public JobOutput() {
		// TODO Auto-generated constructor stub
	}

}
