package com.riti.cool.entity;

public class DeviceList {
	// 设备列表id
	private String id;
	// 用户id
	private String userId;
	// 设备id
	private String uid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "DeviceList [id=" + id + ", userId=" + userId + ", uid=" + uid
				+ "]";
	}

}
