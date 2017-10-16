package com.riti.cool.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;
import com.riti.cool.service.DeviceService;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/device")
public class DeviceController {
	@Resource(name = "deviceService")
	private DeviceService service;

	/**
	 * 上传设备
	 * 
	 * @param req
	 * @param res
	 * @param dpJson
	 * @return
	 */
	@RequestMapping(value = "/uploadDevice", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<String> saveDevicePost(HttpServletRequest req,
			HttpServletResponse res, String
			dpJson) {
		ResultCode<String> result = new ResultCode<String>();
		System.out.println("sendDevice");
		System.out.println("json: " + dpJson);
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.saveDeviceParams(dpJson);
			System.out.println("result: " + result);
			if (!"null".equals(result)) {// 数据存入成功
				// out.println(result);
				return result;
			} else {// 数据存入失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}
	}

	/**
	 * 获取所有设备信息 测试用
	 * 
	 * @param qdp
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/queryDeviceList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<DeviceParams>> queryDevicePost(
			QueryDeviceParams qdp, HttpServletResponse res) {
		System.out.println("queryDevie");
		ResultCode<List<DeviceParams>> result = new ResultCode<List<DeviceParams>>();
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.queryDeviceParams(qdp);
			System.out.println("result: " + result);
			if (!"null".equals(result)) {// 数据获取成功
				// out.println(result);
				return result;
			} else {// 数据获取失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}
	}

	/**
	 * 获取单个设备信息
	 * 
	 * @param qdp
	 * @param res
	 * @return
	 */
	@RequestMapping(value = "/queryDevice", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<DeviceParams> queryDeviceGet(int uid) {
		System.out.println("queryDevie");
		DeviceParams deviceParams=service.getDeviceParams(uid);
		return new ResultCode(deviceParams, "获取设备成功");
	}
}
