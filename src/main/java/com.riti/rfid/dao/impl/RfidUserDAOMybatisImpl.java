package com.riti.rfid.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.DeviceDAO;
import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;
import com.riti.rfid.dao.RfidUserDAO;
import com.riti.rfid.entity.RfidUser;

@Repository("rfidUserDAO")
public class RfidUserDAOMybatisImpl implements RfidUserDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public int addRfidUser(RfidUser rfidUser) {
		return sst.insert("com.riti.rfid.dao.RfidUserDAO.addRfidUser", rfidUser);
	}

	public int updateRfidUser(RfidUser rfidUser) {
		return sst.update("com.riti.rfid.dao.RfidUserDAO.updateRfidUser", rfidUser);
	}

	public int deleteRfidUser(String id) {
		return sst.delete("com.riti.rfid.dao.RfidUserDAO.deleteRfidUser", id);
	}

	public List<RfidUser> getRfidUserList(String id) {
		return sst.selectList("com.riti.rfid.dao.RfidUserDAO.findRfidUserById",id);
	}
	public RfidUser getRfidUser(String name) {
		return sst.selectOne("com.riti.rfid.dao.RfidUserDAO.findRfidUserByName",name);
	}

}
