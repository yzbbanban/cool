package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;
import com.riti.cool.service.exception.PasswordException;
import com.riti.cool.service.exception.UserNameException;
import com.riti.cool.service.exception.UserNotFoundException;
import com.riti.cool.util.ResultCode;

/**
 * 业务层接口 
 */
public interface UserService {
	/**
	 * 登录功能, 登录成功返回用户信息, 登录失败
	 * 则抛出异常.
	 * @param name 用户名 
	 * @param password 密码
	 * @return 如果登录成功就返回登录用户信息
	 * @throws UserNotFoundException 用户不存在
	 * @throws PasswordException 密码错误
	 */
	User login(String name, String password)
		throws UserNotFoundException,
		PasswordException;
	/**
	 * UserService 中添加注册功能
	 * @param name 
	 * @param nick
	 * @param password
	 * @param confirm
	 * @return 注册成功的用户信息
	 * @throws UserNameException 用户名异常
	 * @throws PasswordException 密码异常
	 */
	User regist(String name, String nick,
                String password)
		throws UserNameException, 
		PasswordException;
	/**
	 * 获取用户列表
	 * @param company
	 * @return
	 */
	List<User> getUserList(String userId, String companyId, int level);
	/**
	 * 获取用户公司信息
	 * @param userId
	 * @return
	 */
	User logOffCompany(String userId);
}



