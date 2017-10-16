package com.riti.rfid.entity;

public class OrderCount {
	private long orderSum;
	private long waySum;
	private long stockSum;

	public long getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(long orderSum) {
		this.orderSum = orderSum;
	}

	public long getWaySum() {
		return waySum;
	}

	public void setWaySum(long waySum) {
		this.waySum = waySum;
	}

	public long getStockSum() {
		return stockSum;
	}

	public void setStockSum(long stockSum) {
		this.stockSum = stockSum;
	}

	@Override
	public String toString() {
		return "OrderCount [orderSum=" + orderSum + ", waySum=" + waySum
				+ ", stockSum=" + stockSum + "]";
	}

}
