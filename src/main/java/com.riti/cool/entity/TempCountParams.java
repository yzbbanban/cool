package com.riti.cool.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 用户发送给界面信息
 * 
 * @author brander
 * 
 */
public class TempCountParams implements Serializable{
	private int count;
	private List<Temperature> temperatures;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Temperature> getTemperatures() {
		return temperatures;
	}

	public void setTemperatures(List<Temperature> temperatures) {
		this.temperatures = temperatures;
	}

	@Override
	public String toString() {
		return "TempCountparams [count=" + count + ", temperatures="
				+ temperatures + "]";
	}

}
