package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.DeviceDAO;
import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;

@Repository("deviceDAO")
public class DeviceDAOMybatisImpl implements DeviceDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public boolean save(DeviceParams dp) {
		try {
			sst.insert("com.riti.cool.dao.DeviceDAO.save", dp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<DeviceParams> findAll(QueryDeviceParams qdp) {
		return sst.selectList("com.riti.cool.dao.DeviceDAO.findAll", qdp);
	}

	public DeviceParams findById(int id) {
		return sst.selectOne("com.riti.cool.dao.DeviceDAO.findById", id);
	}

	public boolean modify(DeviceParams emp) {
		try {
			sst.update("com.riti.cool.dao.DeviceDAO.modify", emp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
