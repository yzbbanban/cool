package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.DeviceList;

@Repository("tagListDAO")
public interface TagListDAO {
	/**
	 * 设备列表信息
	 * 
	 * @param deviceList
	 * @return
	 */
	int saveTagList(DeviceList deviceList);

	/**
	 * 用于不重复插入数据
	 * 
	 * @param deviceList
	 * @return
	 */
	DeviceList getDevice(DeviceList deviceList);

	/**
	 * 获取用户的温标数据
	 * 
	 * @param userId
	 * @return
	 */
	List<DeviceList> getTagList(String userId);
}
