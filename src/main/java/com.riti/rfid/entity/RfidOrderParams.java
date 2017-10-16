package com.riti.rfid.entity;

import java.util.List;

import com.riti.cool.entity.User;

public class RfidOrderParams {
	private int count;
	private User user;
	private List<RfidOrder> rfidOrders;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<RfidOrder> getRfidOrders() {
		return rfidOrders;
	}

	public void setRfidOrders(List<RfidOrder> rfidOrders) {
		this.rfidOrders = rfidOrders;
	}

	@Override
	public String toString() {
		return "RfidOrderParams [count=" + count + ", user=" + user
				+ ", rfidOrders=" + rfidOrders + "]";
	}

}
