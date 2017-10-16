package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.DeviceList;

public interface TagListService {
	/**
	 * 添加用户绑定标签数据
	 * @param userId
	 * @param uid
	 * @return
	 */
	DeviceList addTagList(String userId, String uid);
	/**
	 * 获取用户标签列表
	 * @param userId
	 * @return
	 */
	List<DeviceList> getTagDeviceLists(String userId);
	
}
