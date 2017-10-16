package com.riti.rfid.service;

import java.util.List;

import com.riti.rfid.entity.RfidUser;

public interface RfidUserService {
	/**
	 * 添加rfid用户信息
	 * 
	 * @param rfidUser
	 * @return
	 */
	RfidUser addRfidUserTask(RfidUser rfidUser);

	/**
	 * 修改用户信息到数据库
	 * 
	 * @param rfidUser
	 * @return
	 */
	RfidUser updateRfidUserTask(RfidUser rfidUser);

	/**
	 * 删除用户信息到数据库
	 * 
	 * @param rfidUser
	 * @return
	 */
	RfidUser deleteRfidUserTask(String id);

	/**
	 * 查询用户信息到数据库
	 * 
	 * @param rfidUser
	 * @return
	 */
	List<RfidUser> getRfidUserTask(String id);

	/**
	 * 根据公司查询所有客户信息
	 * 
	 * @param userId
	 * @param companyId
	 * @param level
	 * @return
	 */
	List<RfidUser> getRfidUserByCompanyTask(String userId, String companyId,
                                            int level);
}
