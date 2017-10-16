package com.riti.rfid.entity;

import java.io.Serializable;

public class QueryRfidParams implements Serializable {

	private String uid;// 识别号
	private String startTime;// 开始时间
	private String endTime;// 结束时间
	private int startPage;// 开始第几条
	private int endPage;// 结束第几条
	private int type;// 查询类型 0客户 1订单号 2吨桶号 3全部
	private int stockType;// 0入库，1出库,2在途，3全状态

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	@Override
	public String toString() {
		return "QueryRfidParams [uid=" + uid + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", type=" + type + ", stockType="
				+ stockType + "]";
	}
}
