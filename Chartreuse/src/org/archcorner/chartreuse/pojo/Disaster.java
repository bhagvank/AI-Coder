/**
 * 
 */
package org.archcorner.chartreuse.pojo;

/**
 * @author bhagvan_kommadi
 *
 */
public class Disaster {

	private int disasterId;
	/**
	 * @return the disasterId
	 */
	public int getDisasterId() {
		return disasterId;
	}
	/**
	 * @param disasterId the disasterId to set
	 */
	public void setDisasterId(int disasterId) {
		this.disasterId = disasterId;
	}
	/**
	 * @return the disasterName
	 */
	public String getDisasterName() {
		return disasterName;
	}
	/**
	 * @param disasterName the disasterName to set
	 */
	public void setDisasterName(String disasterName) {
		this.disasterName = disasterName;
	}
	/**
	 * @return the locationName
	 */
	public String getLocationName() {
		return locationName;
	}
	/**
	 * @param locationName the locationName to set
	 */
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	/**
	 * @return the eventDescription
	 */
	public String getEventDescription() {
		return eventDescription;
	}
	/**
	 * @param eventDescription the eventDescription to set
	 */
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the reporterName
	 */
	public String getReporterName() {
		return reporterName;
	}
	/**
	 * @param reporterName the reporterName to set
	 */
	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}
	private String disasterName;
	private String locationName;
	private String eventDescription;
	private String contactNo;
	private String reporterName;
	/**
	 * 
	 */
	public Disaster() {
		// TODO Auto-generated constructor stub
	}

}
