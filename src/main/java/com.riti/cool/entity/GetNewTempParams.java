package com.riti.cool.entity;

import java.io.Serializable;

public class GetNewTempParams implements Serializable{
	//设备id
	private int uid;
	//最新温度时间
	private String newTime;
	//备注
	private String remark;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getNewTime() {
		return newTime;
	}
	public void setNewTime(String newTime) {
		this.newTime = newTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "GetNetTempParams [uid=" + uid + ", newTime=" + newTime + ", remark=" + remark + "]";
	}
	
}
