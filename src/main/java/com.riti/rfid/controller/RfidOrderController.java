package com.riti.rfid.controller;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.rfid.entity.OrderCount;
import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrderParams;
import com.riti.rfid.service.RfidOrderService;
import com.riti.rfid.service.exception.RfidOrderException;
import com.riti.rfid.util.ResultCode;
/**
 * 
 * @author brander
 *
 */
@Controller
@RequestMapping("/rfidOrder")
public class RfidOrderController {

	@Resource
	private RfidOrderService service;

	/**
	 * 添加标识号列表
	 * 
	 * @param orderJs
	 * @return
	 */
	@RequestMapping(value = "/addRfidOrderList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<String> addOrderList(String orderJs) {
		// System.out.println(orderJs);
		String result = service.addOrderListTask(orderJs);
		System.out.println(result);
		return new ResultCode(result, "提交成功");
	}

	/**
	 * 获取所有吨桶列表
	 * 
	 * @param qrp
	 * @return
	 */
	@RequestMapping(value = "/getRfidOrderList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<RfidOrderParams> getOrderList(QueryRfidParams qrp) {
		System.out.println(qrp);
		RfidOrderParams result = service.getOrderListTask(qrp);
		System.out.println(result);
		return new ResultCode(result, "获取成功");
	}
	
	/**
	 * 获取所有吨桶数量
	 * 
	 * @param qrp
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/getRfidOrderCount", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<OrderCount> getRfidOrderCount(QueryRfidParams qrp) {
		System.out.println("getRfidOrderCount");
		OrderCount result = service.getRfidOrderCountTask(qrp);
		return new ResultCode(result, "获取成功");
	}

	// 添加错误
	@ExceptionHandler(RfidOrderException.class)
	@ResponseBody
	public ResultCode<String> handleMessage(RfidOrderException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

}
