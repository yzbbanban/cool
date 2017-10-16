package com.riti.rfid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.rfid.entity.RfidUser;
@Repository("rfidUserDAO")
public interface RfidUserDAO {
	/**
	 * 添加用户信息到数据库
	 * 
	 * @param rfidUser
	 * @return
	 */
	int addRfidUser(RfidUser rfidUser);
	/**
	 * 修改用户信息到数据库
	 * 
	 * @param rfidUser
	 * @return
	 */
	int updateRfidUser(RfidUser rfidUser);
	/**
	 * 删除用户信息到数据库
	 * 
	 * @param id
	 * @return
	 */
	int deleteRfidUser(String id);
	/**
	 * 查询用户信息到数据库
	 * 
	 * @param name
	 * @return
	 */
	RfidUser getRfidUser(String name);
	/**
	 * 查询用户信息到数据库
	 * 
	 * @param id
	 * @return
	 */
	List<RfidUser> getRfidUserList(String id);
}
