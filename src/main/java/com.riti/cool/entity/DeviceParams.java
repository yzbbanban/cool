package com.riti.cool.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeviceParams implements Serializable {
	// 设备唯一码
	@JsonProperty(value="Uid")
	private Integer Uid;
	// 公司名
	@JsonProperty(value="Company")
	private String Company;
	// 标签编号
	@JsonProperty(value="DeviceNum")
	private String DeviceNum;
	// 货品名
	@JsonProperty(value="GoodsName")
	private String GoodsName;
	// 延时间隔
	@JsonProperty(value="Start")
	private Integer Start;
	// 采集间隔
	@JsonProperty(value="Interval")
	private Integer Interval;
	// 温度上限
	@JsonProperty(value="MaxTemperature")
	private Float MaxTemperature;
	// 温度下限
	@JsonProperty(value="MinTemperature")
	private Float MinTemperature;
	// 存储方式：循环1、一次0
	@JsonProperty(value="Model")
	private Integer Model;
	// 读停启用:0；未启用:1
	@JsonProperty(value="ReadStop")
	private Integer ReadStop;
	// 1:insert；2:update
	@JsonProperty(value="DataUploadMode")
	private Integer DataUploadMode;
	// 1：NFC；2：bluetooth
	@JsonProperty(value="TagType")
	private Integer TagType;
	// 湿度上限
	@JsonProperty(value="MaxHum")
	private Float MaxHum;
	// 湿度下限
	@JsonProperty(value="MinHum")
	private Float MinHum;

	public Integer getUid() {
		return Uid;
	}

	public void setUid(Integer uid) {
		Uid = uid;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getDeviceNum() {
		return DeviceNum;
	}

	public void setDeviceNum(String deviceNum) {
		DeviceNum = deviceNum;
	}

	public String getGoodsName() {
		return GoodsName;
	}

	public void setGoodsName(String goodsName) {
		GoodsName = goodsName;
	}

	

	public Integer getStart() {
		return Start;
	}

	public void setStart(Integer start) {
		Start = start;
	}

	public Integer getInterval() {
		return Interval;
	}

	public void setInterval(Integer interval) {
		Interval = interval;
	}

	public Float getMaxTemperature() {
		return MaxTemperature;
	}

	public void setMaxTemperature(Float maxTemperature) {
		MaxTemperature = maxTemperature;
	}

	public Float getMinTemperature() {
		return MinTemperature;
	}

	public void setMinTemperature(Float minTemperature) {
		MinTemperature = minTemperature;
	}

	public Integer getModel() {
		return Model;
	}

	public void setModel(Integer model) {
		Model = model;
	}

	public Integer getReadStop() {
		return ReadStop;
	}

	public void setReadStop(Integer readStop) {
		ReadStop = readStop;
	}

	public Integer getDataUploadMode() {
		return DataUploadMode;
	}

	public void setDataUploadMode(Integer dataUploadMode) {
		DataUploadMode = dataUploadMode;
	}

	public Integer getTagType() {
		return TagType;
	}

	public void setTagType(Integer tagType) {
		TagType = tagType;
	}

	public Float getMaxHum() {
		return MaxHum;
	}

	public void setMaxHum(Float maxHum) {
		MaxHum = maxHum;
	}

	public Float getMinHum() {
		return MinHum;
	}

	public void setMinHum(Float minHum) {
		MinHum = minHum;
	}

	@Override
	public String toString() {
		return "DeviceParams [Uid=" + Uid + ", Company=" + Company + ", DeviceNum=" + DeviceNum + ", GoodsName="
				+ GoodsName + ", Start=" + Start + ", Interval=" + Interval + ", MaxTemperature=" + MaxTemperature
				+ ", MinTemperature=" + MinTemperature + ", Model=" + Model + ", ReadStop=" + ReadStop
				+ ", DataUploadMode=" + DataUploadMode + ", TagType=" + TagType + ", MaxHum=" + MaxHum + ", MinHum="
				+ MinHum + "]";
	}

}
