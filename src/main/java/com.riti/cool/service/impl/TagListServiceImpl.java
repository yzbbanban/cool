package com.riti.cool.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.dao.TagListDAO;
import com.riti.cool.entity.DeviceList;
import com.riti.cool.service.TagListService;
import com.riti.cool.service.exception.TagListException;

@Service
public class TagListServiceImpl implements TagListService {
	@Resource
	private TagListDAO tagListDao;

	public DeviceList addTagList(String userId, String uid) {
		try {
			DeviceList deviceList = new DeviceList();
			deviceList.setUid(uid);
			deviceList.setUserId(userId);

			DeviceList dev = tagListDao.getDevice(deviceList);
			if (dev != null) {// 判断数据库中是否有相同数据
				return dev;
			} else {
				String id = UUID.randomUUID().toString();
				deviceList.setId(id);
				tagListDao.saveTagList(deviceList);
				return deviceList;
			}
		} catch (Exception e) {
			throw new TagListException("插入失败");
		}

	}

	public List<DeviceList> getTagDeviceLists(String userId) {
		List<DeviceList> deviceLists = tagListDao.getTagList(userId);
		if (deviceLists != null && deviceLists.size() > 0) {
			return deviceLists;
		} else {
			throw new TagListException("此用户无标签数据");
		}
	}

}
