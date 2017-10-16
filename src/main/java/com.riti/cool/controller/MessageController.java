package com.riti.cool.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.entity.UserMessage;
import com.riti.cool.service.MessageService;
import com.riti.cool.service.exception.MessageException;
import com.riti.cool.service.exception.PasswordException;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Resource
	private MessageService messageService;

	@RequestMapping(value = "/sendMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<UserMessage> sendMessage(String userId,
			String companyName, String messageDetial) {
		System.out.println(userId + "," + companyName + "," + messageDetial);
		UserMessage message = messageService.sendMessageToManager(userId,
				companyName, messageDetial);
		System.out.println(message);
		return new ResultCode(message, "消息发送成功");
	}

	@RequestMapping(value = "/getMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<UserMessage>> getMessage(String userId) {
		System.out.println("getMessage: " + userId);
		List<UserMessage> messages = messageService.getMessageList(userId);
		return new ResultCode(messages, "获取消息成功");
	}
	
	@RequestMapping(value = "/sendApplyMessage", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<UserMessage> sendApplyMessage(String messageId,String companyId,String apply_userId) {
		System.out.println("getMessage: " + apply_userId);
		UserMessage message=messageService.setApplyMessage(messageId, companyId, apply_userId);
		return new ResultCode(message, "处理成功");
	}
	
	

	// 密码错误
	@ExceptionHandler(MessageException.class)
	@ResponseBody
	public ResultCode<String> handleMessage(MessageException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

}
