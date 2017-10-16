package com.riti.rfid.service;


import com.riti.rfid.entity.OrderCount;
import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrderParams;

public interface RfidOrderService {
	/**
	 * 插入列表
	 * 
	 * @param orderJs
	 * @return
	 */
	String addOrderListTask(String orderJs);
	/**
	 * 获取rfid order列表
	 * @param id	查询标志
	 * @param type 查询类型
	 * @return
	 */
	RfidOrderParams getOrderListTask(QueryRfidParams qrp);
	/**
	 * 获取所有吨桶数量
	 * @param qrp
	 * @return
	 */
	OrderCount getRfidOrderCountTask(QueryRfidParams qrp);

}
