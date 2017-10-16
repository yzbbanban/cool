package com.riti.cool.service;

import java.util.List;

import com.riti.cool.util.ResultCode;

public interface ManagerService {
	ResultCode<Object> updateManager(String userId, String managerId);
}
