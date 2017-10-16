package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.UserMessage;

public interface MessageService {
	UserMessage sendMessageToManager(String userId, String companyName, String messageDetial);
	List<UserMessage> getMessageList(String userId);
	UserMessage setApplyMessage(String messageId, String companyId, String apply_userId);
}
