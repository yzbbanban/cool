package com.riti.rfid.entity;

import java.io.Serializable;
import java.util.Date;

import com.riti.cool.entity.User;

public class RfidOrderTrack implements Serializable {
	private Long rfidOrderTrackId;// rfidOrderId
	private String rfidUserTrackId;// rfidid
	private RfidUser rfidUser;
	private String rfidIdTrackName;// 客户名 D1000001606
	private String rfidOrderTrackNum;// 单号
	private String idName;// 单号名称
	private Long idTime;// 读取次数
	private Date rfidOrderTrackCreateTime;// 创建时间
	private boolean checked;
	private int stockType;// 0入库或1出库

	public Long getRfidOrderTrackId() {
		return rfidOrderTrackId;
	}

	public void setRfidOrderTrackId(Long rfidOrderTrackId) {
		this.rfidOrderTrackId = rfidOrderTrackId;
	}

	public String getRfidUserTrackId() {
		return rfidUserTrackId;
	}

	public void setRfidUserTrackId(String rfidUserTrackId) {
		this.rfidUserTrackId = rfidUserTrackId;
	}

	public RfidUser getRfidUser() {
		return rfidUser;
	}

	public void setRfidUser(RfidUser rfidUser) {
		this.rfidUser = rfidUser;
	}

	public String getRfidIdTrackName() {
		return rfidIdTrackName;
	}

	public void setRfidIdTrackName(String rfidIdTrackName) {
		this.rfidIdTrackName = rfidIdTrackName;
	}

	public String getRfidOrderTrackNum() {
		return rfidOrderTrackNum;
	}

	public void setRfidOrderTrackNum(String rfidOrderTrackNum) {
		this.rfidOrderTrackNum = rfidOrderTrackNum;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	public Date getRfidOrderTrackCreateTime() {
		return rfidOrderTrackCreateTime;
	}

	public void setRfidOrderTrackCreateTime(Date rfidOrderTrackCreateTime) {
		this.rfidOrderTrackCreateTime = rfidOrderTrackCreateTime;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public int getStockType() {
		return stockType;
	}

	public void setStockType(int stockType) {
		this.stockType = stockType;
	}

	@Override
	public String toString() {
		return "RfidOrderTrack [rfidOrderTrackId=" + rfidOrderTrackId
				+ ", rfidUserTrackId=" + rfidUserTrackId + ", rfidUser="
				+ rfidUser + ", rfidIdTrackName=" + rfidIdTrackName
				+ ", rfidOrderTrackNum=" + rfidOrderTrackNum + ", idName="
				+ idName + ", idTime=" + idTime + ", rfidOrderTrackCreateTime="
				+ rfidOrderTrackCreateTime + ", checked=" + checked
				+ ", stockType=" + stockType + "]";
	}

}
