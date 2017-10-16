package com.riti.cool.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.entity.DeviceList;
import com.riti.cool.service.TagListService;
import com.riti.cool.service.exception.AddCompanyException;
import com.riti.cool.service.exception.TagListException;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/tagList")
public class TagListController {
	@Resource
	private TagListService tagListService;

	@RequestMapping(value = "/sendTagList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<DeviceList> setTagList(String userId, String uid) {
		System.out.println("sendTagList: " + userId + "," + uid);
		DeviceList deviceList = tagListService.addTagList(userId, uid);
		return new ResultCode(deviceList, "上传成功");
	}

	@RequestMapping(value = "/getTagList", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<DeviceList>> getTagList(String userId) {
		System.out.println("getTagList: " + userId);
		List<DeviceList> deviceLists = tagListService.getTagDeviceLists(userId);
		return new ResultCode(deviceLists, "获取数据成功");
	}

	// 保存公司失败
	@ExceptionHandler(TagListException.class)
	@ResponseBody
	public ResultCode<String> getTagListError(TagListException e) {
		e.printStackTrace();
		return new ResultCode(ServiceResult.GET_MESSAGE_FALSE.getIndex(), e);
	}

}
