package com.riti.cool.entity;

import java.io.Serializable;

public class QueryDeviceParams implements Serializable{
	private String company;// 设备公司

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "QueryDeviceParams [company=" + company + "]";
	}

}
