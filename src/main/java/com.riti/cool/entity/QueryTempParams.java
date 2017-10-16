package com.riti.cool.entity;

import java.io.Serializable;

public class QueryTempParams implements Serializable {

	private int uid;// 设备 uid
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private int startPage;// 开始第几条
	private int endPage;// 结束第几条

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "QueryTempParams [uid=" + uid + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", startPage=" + startPage
				+ ", endPage=" + endPage + "]";
	}
}
