package com.riti.cool.entity;

public class Manager {
	private String managerId;
	private String userId;
	private String companyId;
	private String tagListId;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getTagListId() {
		return tagListId;
	}

	public void setTagListId(String tagListId) {
		this.tagListId = tagListId;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", userId=" + userId
				+ ", companyId=" + companyId + ", tagListId=" + tagListId + "]";
	}

}
