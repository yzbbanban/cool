package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.UserMessage;

@Repository("messageDAO")
public interface MessageDAO {
	int addMessage(UserMessage message);
	List<UserMessage> getMessageList(String userId);
	int deleteMessageById(UserMessage message);
}
