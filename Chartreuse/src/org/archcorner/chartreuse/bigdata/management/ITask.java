/**
 * 
 */
package org.archcorner.chartreuse.bigdata.management;

import java.util.List;
/**
 * @author bhagvan_kommadi
 *
 */
public interface ITask {

	public List<List<String>> getTaskInput();
	public void setTaskInput(List<List<String>> taskInput);
	public void perform();
}
