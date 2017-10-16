package com.riti.rfid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrder;

@Repository("rfidOrderDAO")
public interface RfidOrderDAO {
	/**
	 * 添加订单数据
	 * 
	 * @param rfidOrder
	 * @return
	 */
	int addOrderListTask(RfidOrder rfidOrder);
	

	/**
	 * 根据客户地点获取rfid Order 列表
	 * 
	 * @param qrp
	 * @return
	 */
	List<RfidOrder> getOrderListTaskById(QueryRfidParams qrp);

	/**
	 * 根据单号获取rfid Order 列表
	 * 
	 * @param qrp
	 * @return
	 */
	List<RfidOrder> getOrderListTaskByNum(QueryRfidParams qrp);

	/**
	 * 获取查询的数据量
	 * 
	 * @param qrp
	 * @return
	 */
	int getRfidCount(QueryRfidParams qrp);

	/**
	 * 根据吨桶id查询客户列表的结果
	 * 
	 * @param qrp
	 * @return
	 */
	List<RfidOrder> getOrderListTaskByRfidName(QueryRfidParams qrp);


}
