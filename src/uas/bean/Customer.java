package uas.bean;

public class Customer extends User {
	private String checkId;
	private String checkTime;

	public String getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}

	public String getCheckId() {
		return checkId;
	}
	
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

}
