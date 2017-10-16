package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.TagListDAO;
import com.riti.cool.entity.DeviceList;

@Repository("tagListDAO")
public class TagListDAOMybatisImpl implements TagListDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public int saveTagList(DeviceList deviceList) {
		return sst.insert("com.riti.cool.dao.TagListDAO.addDeviceList",
				deviceList);
	}

	public List<DeviceList> getTagList(String userId) {
		return sst.selectList("com.riti.cool.dao.TagListDAO.getDeviceList",
				userId);
	}

	public DeviceList getDevice(DeviceList deviceList) {
		return sst.selectOne("com.riti.cool.dao.TagListDAO.getDevice",
				deviceList);
	}

}
