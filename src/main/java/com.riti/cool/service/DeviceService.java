package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;
import com.riti.cool.util.ResultCode;

public interface DeviceService {
	/**
	 * 保存设备信息
	 * 
	 * @param dpJson
	 * @return
	 */
	ResultCode<String> saveDeviceParams(String dpJson);

	/**
	 * 获取设备信息 测试用
	 * 
	 * @param qdp
	 * @return
	 */
	ResultCode<List<DeviceParams>> queryDeviceParams(QueryDeviceParams qdp);

	/**
	 * 根据uid获取设备信息
	 * 
	 * @param uid
	 * @return
	 */
	DeviceParams getDeviceParams(int uid);

}
