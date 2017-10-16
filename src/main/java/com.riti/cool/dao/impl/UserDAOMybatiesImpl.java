package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.User;

@Repository("userDAO")
public class UserDAOMybatiesImpl implements UserDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	/**
	 * 根据名字查找用户
	 */
	public User findUserByName(String name) {
		return sst.selectOne("com.riti.cool.dao.UserDAO.findUserByName", name);
	}

	/**
	 * 添加用户
	 */
	public int addUser(User user) {
		return sst.insert("com.riti.cool.dao.UserDAO.addUser", user);
	}

	/**
	 * 根据用户id查询用户
	 */
	public User findUserById(String userId) {
		return sst.selectOne("com.riti.cool.dao.UserDAO.findUserById", userId);
	}

	/**
	 * 更新用户company信息
	 */
	public int updateUserCompany(User user) {

		return sst.update("com.riti.cool.dao.UserDAO.updateUserCompany", user);
	}

	/**
	 * 根据公司查找管理员用户
	 */
	public User findUserByCompany(User user) {
		return sst.selectOne("com.riti.cool.dao.UserDAO.findUserByCompany",
				user);
	}

	/**
	 * 根据公司查找子用户
	 */
	public List<User> findUserByCompanyId(User user) {
		return sst.selectList("com.riti.cool.dao.UserDAO.findUserByCompanyId",
				user);
	}

	public int updateUserCompanyLevel(User user) {
		return sst.update("com.riti.cool.dao.UserDAO.updateUserCompanyLevel",
				user);
	}

}
