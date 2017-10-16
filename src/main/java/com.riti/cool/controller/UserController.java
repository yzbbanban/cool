package com.riti.cool.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.imageio.spi.ServiceRegistry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;
import com.riti.cool.service.UserService;
import com.riti.cool.service.exception.ManagerException;
import com.riti.cool.service.exception.PasswordException;
import com.riti.cool.service.exception.UserNameException;
import com.riti.cool.service.exception.UserNotFoundException;
import com.riti.cool.service.exception.UserUpdateException;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/user")
public class UserController extends AbstractController {
	@Resource
	private UserService userService;

	// 登录
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<User> login(String name, String password) {
		User user = userService.login(name, password);
		System.out.println("user: " + user);
		return new ResultCode(user, "登陆成功");
	}

	// 注册
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<User> regist(String name, String nick, String password) {
		User user = userService.regist(name, nick, password);
		System.out.println(user);
		return new ResultCode(user, "注册成功");
	}

	/**
	 * 获取用户列表
	 * 
	 * @param companyId
	 * @return
	 */
	@RequestMapping(value = "/getUserList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<User>> execute(String userId,String companyId,int level) {
		List<User> users=userService.getUserList(userId, companyId, level);
		return new ResultCode(users,"查找成功");
	}

	/**
	 * 更新用户的公司信息
	 * 
	 * @param company
	 * @return
	 */
	@RequestMapping(value = "/updateUserCompany", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<User> updateUserByCompany(String userId, Company company) {
		System.out.println("userId: " + userId + "company: " + company);
		ResultCode<User> result = new ResultCode<User>();

		return result;
	}

	/**
	 * 取消用户的公司绑定
	 * 
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/logOffUserCompany", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<User> logOffCompany(String userId) {
		System.out.println(userId);
		User user = userService.logOffCompany(userId);
		return new ResultCode(user, "取消绑定成功");
	}

	// 无用户
	@ExceptionHandler(UserNotFoundException.class)
	@ResponseBody
	public ResultCode<String> handleUserNotFound(UserNotFoundException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 密码错误
	@ExceptionHandler(PasswordException.class)
	@ResponseBody
	public ResultCode<String> handlePassword(PasswordException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 用户名有误
	@ExceptionHandler(UserNameException.class)
	@ResponseBody
	public ResultCode<String> handleUserName(UserNameException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 更新用户信息失败
	@ExceptionHandler(UserUpdateException.class)
	@ResponseBody
	public ResultCode<String> handleUserUpdate(UserUpdateException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

	// 总管理员不能删除公司信息
	@ExceptionHandler(ManagerException.class)
	@ResponseBody
	public ResultCode<String> handleManager(ManagerException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}
}
