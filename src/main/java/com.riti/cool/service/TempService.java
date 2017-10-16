package com.riti.cool.service;

import java.util.List;

import com.riti.cool.entity.GetNewTempParams;
import com.riti.cool.entity.QueryTempParams;
import com.riti.cool.entity.TempCountParams;
import com.riti.cool.entity.Temperature;
import com.riti.cool.util.ResultCode;

public interface TempService {
	/**
	 * 保存温度数据
	 * 
	 * @param tempJson
	 * @return
	 */
	ResultCode<String> saveTempData(String tempJson);

	/**
	 * 查询温度数据
	 * 
	 * @param qtp
	 * @return
	 */
	ResultCode<TempCountParams> queryTempData(QueryTempParams qtp); 
	
	/**
	 * 查询温度数据
	 * 
	 * @param qtp
	 * @return
	 */
	ResultCode<List<Temperature>> queryTempChartData(QueryTempParams qtp); 

	/**
	 * 根据 uid 获取最新的一条温度数据采用集合形式
	 * 
	 * @param gntp
	 * @return
	 */
	ResultCode<Temperature> getNewTempData(GetNewTempParams gntp);
}
