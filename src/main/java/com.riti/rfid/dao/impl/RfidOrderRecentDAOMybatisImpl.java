package com.riti.rfid.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.rfid.dao.RfidOrderRecentDAO;
import com.riti.rfid.entity.QueryRfidParams;
import com.riti.rfid.entity.RfidOrder;

@Repository("rfidOrderRecentDAO")
public class RfidOrderRecentDAOMybatisImpl implements RfidOrderRecentDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public int addOrderRecentListTask(RfidOrder rfidOrder) {
		return sst.insert("com.riti.rfid.dao.RfidOrderRecentDAO.addRfidOrderRecent",
				rfidOrder);
	}

	public List<RfidOrder> getOrderRecentListTaskById(QueryRfidParams qrp) {
		return sst.selectList(
				"com.riti.rfid.dao.RfidOrderRecentDAO.findRfidOrderRecentById", qrp);
	}

	public int getRfidRecentCount(QueryRfidParams qrp) {
		return sst
				.selectOne("com.riti.rfid.dao.RfidOrderRecentDAO.getRfidRecentCount", qrp);
	}

}
