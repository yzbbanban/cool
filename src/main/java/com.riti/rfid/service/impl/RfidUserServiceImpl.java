package com.riti.rfid.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.User;
import com.riti.cool.service.exception.UserNotFoundException;
import com.riti.rfid.dao.RfidUserDAO;
import com.riti.rfid.entity.RfidUser;
import com.riti.rfid.service.RfidUserService;
import com.riti.rfid.service.exception.RfidUserException;

@Service
public class RfidUserServiceImpl implements RfidUserService {

	@Resource
	RfidUserDAO rfidUserDAO;
	@Resource
	private UserDAO userDao;

	public RfidUser addRfidUserTask(RfidUser rfidUser) {
		// 先查找有无重复数
		String name = rfidUser.getRfidUserName();
		RfidUser ru = rfidUserDAO.getRfidUser(name);
		if (ru != null) {
			throw new RfidUserException("仓库名重复，请更换");
		} else {

			String rfidUserId = UUID.randomUUID().toString();
			rfidUser.setRfidUserId(rfidUserId);
			rfidUser.setRfidUserCreatTime(new Date());
			int row = rfidUserDAO.addRfidUser(rfidUser);
			if (row == 1) {
				return rfidUser;
			} else {
				throw new RfidUserException("添加失败，请重试");
			}
		}

	}

	public RfidUser updateRfidUserTask(RfidUser rfidUser) {
		rfidUser.setRfidUserCreatTime(new Date());
		System.out.println("updateRfidUserTask: " + rfidUser);
		int row = rfidUserDAO.updateRfidUser(rfidUser);
		if (row == 1) {
			return rfidUser;
		} else {
			throw new RfidUserException("更新失败，请重试");
		}
	}

	public RfidUser deleteRfidUserTask(String id) {

		System.out.println("updateRfidUserTask: " + id);
		int row = rfidUserDAO.deleteRfidUser(id);
		if (row == 1) {
			return new RfidUser();
		} else {
			throw new RfidUserException("删除失败，请重试");
		}
	}

	public List<RfidUser> getRfidUserTask(String id) {
		List<RfidUser> rusList = rfidUserDAO.getRfidUserList(id);
		if (rusList != null && rusList.size() > 0) {
			return rusList;
		} else {
			throw new RfidUserException("无数据请添加");
		}
	}

	public List<RfidUser> getRfidUserByCompanyTask(String userId,
			String companyId, int level) {
		User user = new User();
		user.setCompanyId(companyId);
		user.setId(userId);
		user.setUserLevel(level);
		List<User> users = new ArrayList<User>();
		users = userDao.findUserByCompanyId(user);
		User u = userDao.findUserById(userId);
		if (u != null) {
			users.add(0, u);
		} else {
			throw new UserNotFoundException("没有用户");
		}
		System.out.println(users);
		if (users != null && users.size() > 0) {
			//users 所有用户
			//查询所有用户下的客户
			
			
		} else {
			
		}

		return null;
	}

}
