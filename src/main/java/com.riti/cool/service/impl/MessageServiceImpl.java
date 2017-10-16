package com.riti.cool.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.dao.CompanyDAO;
import com.riti.cool.dao.MessageDAO;
import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.User;
import com.riti.cool.entity.UserMessage;
import com.riti.cool.service.MessageService;
import com.riti.cool.service.exception.MessageException;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	private CompanyDAO companyDao;
	@Resource
	private UserDAO userDao;
	@Resource
	private MessageDAO messageDao;

	/**
	 * 申请加入公司消息
	 */
	public UserMessage sendMessageToManager(String userId, String companyName,
			String messageDetial) {
		UserMessage message = new UserMessage();
		try {

			// 根据公司名获取公司id
			String companyId = companyDao.findCompanyByName(companyName)
					.getId();
			User user = new User();
			// 设置为管理者
			user.setCompanyId(companyId);
			user.setUserLevel(1);
			// 查询公司管理者userId
			User u = userDao.findUserByCompany(user);
			// 设置接收方为公司管理者
			message.setHandleId(u.getId());
			message.setUserId(userId);
			String id = UUID.randomUUID().toString();
			message.setId(id);
			// 设置基本信息
			message.setCompanyId(companyId);
			message.setMessageDetial(messageDetial);
			// 现在创建的时间
			java.util.Date createTime = new java.util.Date(
					System.currentTimeMillis());
			message.setCreateTime(createTime);

			int row = messageDao.addMessage(message);
			if (row == 1) {
				return message;
			} else {
				throw new MessageException("消息发送失败，请重试");
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new MessageException("消息发送失败，请重试");
		}

	}

	/**
	 * 获取消息列表
	 */
	public List<UserMessage> getMessageList(String userId) {
		List<UserMessage> messages = messageDao.getMessageList(userId);
		if (messages != null && messages.size() > 0) {
			return messages;
		} else {
			throw new MessageException("没有消息");
		}

	}

	/**
	 * TODO 设置同意申请
	 */
	public UserMessage setApplyMessage(String messageId, String companyId,
			String apply_userId) {
		// 设置userId为公司ID
		User user = new User();
		user.setCompanyId(companyId);
		user.setId(apply_userId);
		user.setUserLevel(20);
		// 存入user信息
		int n=userDao.updateUserCompanyLevel(user);
		UserMessage message = new UserMessage(companyId, apply_userId);
		// 删除消息
		int row=messageDao.deleteMessageById(message);
		if(n==1 && row==1){
			return message;
		}else{
			throw new MessageException("同意失败");
		}
	
	}

}
