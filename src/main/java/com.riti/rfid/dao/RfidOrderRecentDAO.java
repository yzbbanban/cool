package com.riti.rfid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrder;

@Repository("rfidOrderRecentDAO")
public interface RfidOrderRecentDAO {
	/**
	 * 添加订单数据
	 * 
	 * @param rfidOrder
	 * @return
	 */
	int addOrderRecentListTask(RfidOrder rfidOrder);

	/**
	 * 根据客户地点获取rfid Order 列表
	 * 
	 * @param qrp
	 * @return
	 */
	List<RfidOrder> getOrderRecentListTaskById(QueryRfidParams qrp);

	/**
	 * 获取查询的数据量
	 * 
	 * @param qrp
	 * @return
	 */
	int getRfidRecentCount(QueryRfidParams qrp);

}
