package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.User;

@Repository("userDAO")
public interface UserDAO {
	/**
	 * 查询名字
	 * 
	 * @param name
	 * @return
	 */
	User findUserByName(String name);

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @return
	 */
	int addUser(User user);

	/**
	 * 根据id查询用户
	 * 
	 * @param userId
	 * @return
	 */
	User findUserById(String userId);

	/**
	 * 更新user的公司信息
	 * 
	 * @param user
	 * @return
	 */
	int updateUserCompany(User user);
	/**
	 * 更新子user的公司信息
	 * @param user
	 * @return
	 */
	int updateUserCompanyLevel(User user);
	/**
	 * 根据公司查找user
	 * 
	 * @param user
	 * @return
	 */
	User findUserByCompany(User user);

	/**
	 * 根据公司查找子用户
	 * 
	 * @param user
	 * @return
	 */
	List<User> findUserByCompanyId(User user);

}
