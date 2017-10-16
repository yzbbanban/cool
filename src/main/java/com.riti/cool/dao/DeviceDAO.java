package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.QueryDeviceParams;

@Repository("deviceDAO")
public interface DeviceDAO {
	/**
	 * 保存温标设备
	 * 
	 * @param dp 设备信息
	 */
	boolean save(DeviceParams dp);

	/**
	 * 查找所有数据
	 * 
	 * @return 设备集合
	 */
	List<DeviceParams> findAll(QueryDeviceParams qdp);

	/**
	 * 根据 id查找设备数据
	 * 
	 * @return 设备集合
	 */
	DeviceParams findById(int id);

	/**
	 * 更新设备
	 * 
	 * @param dp 设备信息
	 */
	boolean modify(DeviceParams dp);

}
