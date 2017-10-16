package com.riti.cool.entity;

import java.util.Date;

public class UserMessage {
	// messageId
	private String id;
	// 公司id
	private String companyId;
	// 用户id
	private String userId;
	// 处理人id
	private String handleId;
	// 消息详情
	private String messageDetial;
	// 创建时间
	private Date createTime;
	// 用户
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserMessage() {
		super();
	}

	public UserMessage(String companyId, String userId) {
		super();
		this.companyId = companyId;
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getUserId() {
		return userId;
	}

	public String getHandleId() {
		return handleId;
	}

	public void setHandleId(String handleId) {
		this.handleId = handleId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMessageDetial() {
		return messageDetial;
	}

	public void setMessageDetial(String messageDetial) {
		this.messageDetial = messageDetial;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserMessage [id=" + id + ", companyId=" + companyId
				+ ", userId=" + userId + ", handleId=" + handleId
				+ ", messageDetial=" + messageDetial + ", createTime="
				+ createTime + ", user=" + user + "]";
	}

}
