package com.riti.rfid.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.rfid.dao.RfidOrderDAO;
import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrder;

@Repository("rfidOrderDAO")
public class RfidOrderDAOMybatisImpl implements RfidOrderDAO{
	@Resource(name = "sst")
	private SqlSessionTemplate sst;
	
	public int addOrderListTask(RfidOrder rfidOrder) {
		return sst.insert("com.riti.rfid.dao.RfidOrderDAO.addRfidOrder", rfidOrder);
	}

	public List<RfidOrder> getOrderListTaskById(QueryRfidParams qrp) {
		return sst.selectList("com.riti.rfid.dao.RfidOrderDAO.findRfidOrderById", qrp);
	}

	public List<RfidOrder> getOrderListTaskByNum(QueryRfidParams qrp) {
		return sst.selectList("com.riti.rfid.dao.RfidOrderDAO.findRfidOrderByNum", qrp);
	}

	public int getRfidCount(QueryRfidParams qrp) {
		return sst.selectOne("com.riti.rfid.dao.RfidOrderDAO.getRfidCount", qrp);
	}

	public List<RfidOrder> getOrderListTaskByRfidName(QueryRfidParams qrp) {
		return sst.selectList("com.riti.rfid.dao.RfidOrderDAO.findRfidOrderByRfidName", qrp);
	}

	public List<RfidOrder> getOrderStockListTaskByRfidName(QueryRfidParams qrp) {
		return sst.selectList("com.riti.rfid.dao.RfidOrderDAO.findRfidOrderStockListByRfidName", qrp);
	}

}
