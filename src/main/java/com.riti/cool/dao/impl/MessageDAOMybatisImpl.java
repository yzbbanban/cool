package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.MessageDAO;
import com.riti.cool.entity.DeviceParams;
import com.riti.cool.entity.UserMessage;

@Repository("messageDAO")
public class MessageDAOMybatisImpl implements MessageDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public int addMessage(UserMessage message) {
		return sst.insert("com.riti.cool.dao.MessageDAO.addMessage", message);
	}

	public List<UserMessage> getMessageList(String userId) {

		return sst.selectList("com.riti.cool.dao.MessageDAO.getMessageListById", userId);

	}

	public int deleteMessageById(UserMessage message) {
		return sst.delete("com.riti.cool.dao.MessageDAO.deleteMessageById", message);
	}
}
