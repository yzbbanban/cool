package com.riti.rfid.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.User;
import com.riti.cool.util.JsonParseUtils;
import com.riti.rfid.dao.RfidOrderDAO;
import com.riti.rfid.dao.RfidOrderRecentDAO;
import com.riti.rfid.entity.OrderCount;
import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrder;
import com.riti.rfid.entity.RfidOrderParams;
import com.riti.rfid.service.RfidOrderService;
import com.riti.rfid.service.exception.RfidOrderException;

@Service
public class RfidOrderServiceImpl implements RfidOrderService {
	@Resource
	RfidOrderDAO rfidOrderDAO;
	@Resource
	RfidOrderRecentDAO rfidOrderRecentDAO;
	@Resource
	UserDAO userDAO;
	@Resource
	private JsonParseUtils jsonParseUtils;

	public String addOrderListTask(String orderJs) {
		// System.out.println(orderJs);
		// 解析为集合
		List<RfidOrder> rfidOrders = jsonParseUtils.getOrderObjList(orderJs,
				ArrayList.class, RfidOrder.class);
		// System.out.println(rfidOrders);
		for (int i = 0; i < rfidOrders.size(); i++) {
			System.out.println(rfidOrders.size());
			RfidOrder rfidOrder = rfidOrders.get(i);
			rfidOrder.setRfidOrderCreateTime(new Date());
			int row = rfidOrderDAO.addOrderListTask(rfidOrder);
			int rowRecent = rfidOrderRecentDAO
					.addOrderRecentListTask(rfidOrder);
			System.out.println(row + "," + rowRecent);
			if (row != 1 && rowRecent != 1) {// 有一条不成功则失败
				throw new RfidOrderException("提交失败");
			}
		}
		return "插入成功";
	}

	public RfidOrderParams getOrderListTask(QueryRfidParams qrp) {
		System.out.println("getOrderListTask: " + qrp);
		RfidOrderParams params = new RfidOrderParams();

		List<RfidOrder> rfidOrders = new ArrayList<RfidOrder>();
		if (qrp.getType() == 0 && qrp.getStockType() != 0) {// 按照客户查询,入库出库
			rfidOrders = rfidOrderDAO.getOrderListTaskById(qrp);
		} else if (qrp.getType() == 1 && qrp.getStockType() != 0) {// 按照单号查询,入库出库
			rfidOrders = rfidOrderDAO.getOrderListTaskByNum(qrp);
		} else if (qrp.getType() == 2 && qrp.getStockType() != 0) {// 按照吨桶id查询入,库出库
			rfidOrders = rfidOrderDAO.getOrderListTaskByRfidName(qrp);
		} else if (qrp.getStockType() == 0) {// 资产统计
			rfidOrders = rfidOrderRecentDAO.getOrderRecentListTaskById(qrp);
		}

		if (rfidOrders != null && rfidOrders.size() > 0) {
			int count = 0;
			if (qrp.getStockType() == 0) {
				count = rfidOrderRecentDAO.getRfidRecentCount(qrp);
			} else {
				count = rfidOrderDAO.getRfidCount(qrp);
			}
			User user = userDAO.findUserById(rfidOrders.get(0).getRfidUser()
					.getUserId());
			// System.out.println("count: " + count);
			params.setCount(count);
			params.setRfidOrders(rfidOrders);
			params.setUser(user);
			return params;
		} else {
			throw new RfidOrderException("无数据");
		}
	}

	/**
	 * 获取所有吨桶数量
	 */
	public OrderCount getRfidOrderCountTask(QueryRfidParams qrp) {
		// 总数
		long orderSum = rfidOrderRecentDAO.getRfidRecentCount(qrp);
		qrp.setStockType(1);// 在库
		long waySum = rfidOrderRecentDAO.getRfidRecentCount(qrp);
		qrp.setStockType(0);// 在途
		long stockSum = rfidOrderRecentDAO.getRfidRecentCount(qrp);
		OrderCount oc = new OrderCount();
		oc.setOrderSum(orderSum);
		oc.setStockSum(stockSum);
		oc.setWaySum(waySum);
		return oc;
	}

}
