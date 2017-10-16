package com.riti.cool.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;
import com.riti.cool.service.UserService;
import com.riti.cool.service.exception.ManagerException;
import com.riti.cool.service.exception.PasswordException;
import com.riti.cool.service.exception.UserNameException;
import com.riti.cool.service.exception.UserNotFoundException;
import com.riti.cool.service.exception.UserUpdateException;

@Service("userService")
public class UserServiceImpl implements UserService {
	// 加密用
	@Value("#{jdbc.salt}")
	private String salt;
	@Resource
	private UserDAO userDao;

	// 登录
	public User login(String name, String password)
			throws UserNotFoundException, PasswordException {
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("密码空");
		}
		if (name == null || name.trim().isEmpty()) {
			throw new UserNotFoundException("用户名空");
		}
		User user = userDao.findUserByName(name.trim());
		if (user == null) {
			throw new UserNotFoundException("用户名错误");
		}

		String pwd = DigestUtils.md5Hex(salt + password.trim());
		if (pwd.equals(user.getPassword())) {
			return user;
		}
		throw new PasswordException("密码错误");
	}

	// 注册
	public User regist(String name, String nick, String password)
			throws UserNameException, PasswordException {
		// 检查name, 不能重复
		if (name == null || name.trim().isEmpty()) {
			throw new UserNameException("请填写用户名");
		}
		User one = userDao.findUserByName(name);
		if (one != null) {
			throw new UserNameException("用户已注册，请重新填写用户名");
		}
		// 检查密码
		if (password == null || password.trim().isEmpty()) {
			throw new PasswordException("请填写密码");
		}

		// 检查nick
		if (nick == null || nick.trim().isEmpty()) {
			nick = name;
		}
		String id = UUID.randomUUID().toString();
		String token = "";

		password = DigestUtils.md5Hex(salt + password);
		// 设置user信息
		// user创建时间
		Date date = new Date(System.currentTimeMillis());
		// id,登录名，密码，token，昵称，创建时间，用户权限为最高
		User user = new User(id, name, password, token, nick, date);
		int n = userDao.addUser(user);
		if (n != 1) {
			throw new RuntimeException("添加用户失败!");
		}
		return user;
	}

	/**
	 * 获取用户列表
	 */
	public List<User> getUserList(String companyId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 更新用户的公司信息为空
	 */
	public User logOffCompany(String userId) {
		User user = userDao.findUserById(userId);
		if (user.getUserLevel() == 1) {
			// TODO 不能删除因为是总管理员
			throw new ManagerException("总管理员不能删除公司信息");
		}
		user.setCompanyId("");
		user.setId(userId);
		int row = userDao.updateUserCompany(user);
		if (row == 1) {
			user = userDao.findUserById(userId);
		} else {
			// TODO 更新user信息失败 异常
			throw new UserUpdateException("更新用户信息失败");
		}

		return user;
	}

	/**
	 * 获取子用户列表
	 */
	public List<User> getUserList(String userId, String companyId, int level) {
		User user = new User();
		user.setCompanyId(companyId);
		user.setId(userId);
		user.setUserLevel(level);
		List<User> users = new ArrayList<User>();
		users = userDao.findUserByCompanyId(user);
		// System.out.println("ssss");
		User u = userDao.findUserById(userId);
		if(u!=null){
			users.add(0, u);
		}else {
			throw new UserNotFoundException("没有用户");
		}
		System.out.println(users);
		if (users != null && users.size() > 0) {
			return users;
		} else {
			throw new UserNotFoundException("没有用户");
		}
	}
}
