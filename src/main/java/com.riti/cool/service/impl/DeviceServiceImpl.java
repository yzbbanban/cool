package com.riti.cool.service.impl;

import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.dao.DeviceDAO;
import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;
import com.riti.cool.service.DeviceService;
import com.riti.cool.service.exception.DeviceException;
import com.riti.cool.util.JsonParseUtils;
import com.riti.cool.util.ResultCode;

@Service("deviceService")
public class DeviceServiceImpl implements DeviceService {
	@Resource(name = "deviceDAO")
	private DeviceDAO dao;

	@Resource
	private JsonParseUtils jsonParseUtils;

	/**
	 * 保存设备
	 */
	public ResultCode<String> saveDeviceParams(String dpJson) {
		ResultCode<String> resultCode = new ResultCode<String>();
		try {
			DeviceParams dp = jsonParseUtils.getObj(dpJson, DeviceParams.class);// 解析字符串
			if (dao.findById(dp.getUid()) != null) {// 确定无数据
				boolean updateResult = dao.modify(dp);
				System.out.println(updateResult + " dp: " + dp);
				if (updateResult) {// 更新成功，正常情况
					resultCode = setSaveDeviceResult(ServiceResult.GET_MESSAGE_SUCCESS);
				} else {// 更新失败
					resultCode = setSaveDeviceResult(ServiceResult.GET_MESSAGE_NO_DATA);
				}
				return resultCode;
			}
			boolean saveResult = dao.save(dp);// 保存数据
			if (saveResult) {// 保存成功，正常情况
				resultCode = setSaveDeviceResult(ServiceResult.GET_MESSAGE_SUCCESS);
			} else {// 保存失败
				resultCode = setSaveDeviceResult(ServiceResult.GET_MESSAGE_FALSE);
			}
		} catch (Exception e) {
			if (e instanceof Exception) {// 上传参数异常解析异常)
				resultCode = setSaveDeviceResult(ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;
	}

	/**
	 * 设置返回数据
	 * 
	 * @param resultCode
	 * @param gson
	 * @param message
	 * @return
	 */
	private ResultCode<String> setSaveDeviceResult(ServiceResult message) {
		ResultCode<String> resultCode = new ResultCode<String>();
		resultCode.setCode(message.getIndex());
		resultCode.setMessage(message.getName());
		resultCode.setResult(null);
		return resultCode;
	}

	/**
	 * 查询内所有设备
	 */
	public ResultCode<List<DeviceParams>> queryDeviceParams(
			QueryDeviceParams qdp) {
		ResultCode<List<DeviceParams>> resultCode = new ResultCode<List<DeviceParams>>();
		try {
			List<DeviceParams> deviceParams = dao.findAll(qdp);// 获取数据
			if (deviceParams != null && deviceParams.size() > 0) {// 获取成功，正常情况
				resultCode = setQueryDeviceResult(deviceParams,
						ServiceResult.GET_MESSAGE_SUCCESS);
			} else {// 查询失败没数据
				resultCode = setQueryDeviceResult(deviceParams,
						ServiceResult.GET_MESSAGE_NO_DATA);
			}
		} catch (Exception e) {
			if (e instanceof ParseException) {// 上传参数异常解析异常)
				resultCode = setQueryDeviceResult(null,
						ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;
	}

	/**
	 * 根据uid获取设备信息
	 */
	public DeviceParams getDeviceParams(int uid) {
		DeviceParams device = dao.findById(uid);
		if (device != null) {
			return device;
		} else {
			throw new DeviceException("无设备信息");
		}
	}

	private ResultCode<List<DeviceParams>> setQueryDeviceResult(
			List<DeviceParams> deviceParams, ServiceResult message) {
		ResultCode<List<DeviceParams>> resultCode = new ResultCode<List<DeviceParams>>();
		resultCode.setCode(message.getIndex());
		resultCode.setMessage(message.getName());
		resultCode.setResult(deviceParams);
		return resultCode;
	}

}
