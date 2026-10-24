package com.architectcorner.ai.machinelearning.management;

import java.util.ArrayList;
import java.util.List;

public class JobInput {

	private List<List<String>> data = new ArrayList();
	
	/**
	 * @return the data
	 */
	public List<List<String>> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<List<String>> data) {
		this.data = data;
	}

	public JobInput() {
		// TODO Auto-generated constructor stub
	}

}
