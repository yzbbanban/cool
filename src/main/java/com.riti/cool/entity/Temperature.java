package com.riti.cool.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature implements Serializable{
	//标签标志
	@JsonProperty(value="Uid")
	private int Uid;
	//货物名称
	@JsonProperty(value="GoodsName")
	private String GoodsName;
	//时间
	@JsonProperty(value="DateTime")
	private String DateTime;
	//温度上限
	@JsonProperty(value="MaxTemperature")
	private double MaxTemperature;
	//温度下限
	@JsonProperty(value="MinTemperature")
	private double MinTemperature;
	//温度
	@JsonProperty(value="Temperature")
	private double Temperature;
	//温度状态 0正常，1超限
	@JsonProperty(value="Status")
	private int Status;
	//湿度上限
	@JsonProperty(value="MaxHum")
	private double MaxHum;
	//湿度下限
	@JsonProperty(value="MinHum")
	private double MinHum;
	//湿度
	@JsonProperty(value="Hum")
	private double Hum;
	//湿度状态 0正常，1超限
	@JsonProperty(value="HumStatus")
	private int HumStatus;

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		this.Uid = uid;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		this.GoodsName = goodsName;
	}

	public String getDateTime() {
		return DateTime;
	}

	public void setDateTime(String dateTime) {
		this.DateTime = dateTime;
	}

	public double getMaxTemperature() {
		return MaxTemperature;
	}

	public void setMaxTemperature(double maxTemperature) {
		this.MaxTemperature = maxTemperature;
	}

	public double getMinTemperature(double v) {
		return MinTemperature;
	}

	public void setMinTemperature(double minTemperature) {
		this.MinTemperature = minTemperature;
	}

	public double getTemperature() {
		return Temperature;
	}

	public void setTemperature(double temperature) {
		this.Temperature = temperature;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		this.Status = status;
	}

	public double getMinTemperature() {
		return MinTemperature;
	}

	public double getMaxHum() {
		return MaxHum;
	}

	public void setMaxHum(double maxHum) {
		this.MaxHum = maxHum;
	}

	public double getMinHum() {
		return MinHum;
	}

	public void setMinHum(double minHum) {
		this.MinHum = minHum;
	}

	public double getHum() {
		return Hum;
	}

	public void setHum(double hum) {
		this.Hum = hum;
	}

	public int getHumStatus() {
		return HumStatus;
	}

	public void setHumStatus(int humStatus) {
		this.HumStatus = humStatus;
	}

	@Override
	public String toString() {
		return "UploadingTem{" + "Uid=" + Uid + ", GoodsName='" + GoodsName + '\'' + ", DateTime='" + DateTime + '\''
				+ ", MaxTemperature=" + MaxTemperature + ", MinTemperature=" + MinTemperature + ", Temperature="
				+ Temperature + ", Status=" + Status + ", MaxHum=" + MaxHum + ", MinHum=" + MinHum + ", Hum=" + Hum
				+ ", HumStatus=" + HumStatus + '}';
	}
}
