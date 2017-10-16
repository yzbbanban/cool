package com.riti.rfid.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RfidUser implements Serializable {
	private String rfidUserId;
	private String userId;
	private String rfidUserName;
	private String rfidUserLocation;
	private Date rfidUserCreatTime;
	private int rfidOrderCount;

	public int getRfidOrderCount() {
		return rfidOrderCount;
	}

	public void setRfidOrderCount(int rfidOrderCount) {
		this.rfidOrderCount = rfidOrderCount;
	}

	public Date getRfidUserCreatTime() {
		return rfidUserCreatTime;
	}

	public void setRfidUserCreatTime(Date rfidUserCreatTime) {
		this.rfidUserCreatTime = rfidUserCreatTime;
	}

	public String getRfidUserId() {
		return rfidUserId;
	}

	public void setRfidUserId(String rfidUserId) {
		this.rfidUserId = rfidUserId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRfidUserName() {
		return rfidUserName;
	}

	public void setRfidUserName(String rfidUserName) {
		this.rfidUserName = rfidUserName;
	}

	public String getRfidUserLocation() {
		return rfidUserLocation;
	}

	public void setRfidUserLocation(String rfidUserLocation) {
		this.rfidUserLocation = rfidUserLocation;
	}

	@Override
	public String toString() {
		return "RfidUser [rfidUserId=" + rfidUserId + ", userId=" + userId
				+ ", rfidUserName=" + rfidUserName + ", rfidUserLocation="
				+ rfidUserLocation + ", rfidUserCreatTime=" + rfidUserCreatTime
				+ ", orderCount=" + rfidOrderCount + "]";
	}

}
