package com.riti.cool.service.impl;

import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.consts.ServiceResult;
import com.riti.cool.dao.TempDAO;
import com.riti.cool.entity.GetNewTempParams;
import com.riti.cool.entity.QueryTempParams;
import com.riti.cool.entity.TempCountParams;
import com.riti.cool.entity.Temperature;
import com.riti.cool.service.TempService;
import com.riti.cool.util.JsonParseUtils;
import com.riti.cool.util.ResultCode;

@Service("tempService")
public class TempServiceImpl implements TempService {
	@Resource
	private TempDAO tempDAO;
	@Resource
	private JsonParseUtils jsonParseUtils;

	/**
	 * 保存温度数据
	 */
	public ResultCode<String> saveTempData(String tempJson) {
		ResultCode<String> resultCode = new ResultCode<String>();
		try {
			// 解析为集合
			List<Temperature> temperatures = jsonParseUtils.getObjList(
					tempJson, ArrayList.class, Temperature.class);

			// System.out.println(temperatures);
			boolean saveSuccess = false;// 判断是否成功标志
			for (int i = 0; i < temperatures.size(); i++) {
				saveSuccess = tempDAO.save(temperatures.get(i));
				if (!saveSuccess) {// 有一条不成功则失败
					resultCode = setSaveTempResult(ServiceResult.GET_MESSAGE_FALSE);
				}
			}
			resultCode = setSaveTempResult(ServiceResult.GET_MESSAGE_SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof ParseException) {// 上传参数异常解析异常)
				resultCode = setSaveTempResult(ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;
	}

	/**
	 * 查询温度数据
	 */
	public ResultCode<TempCountParams> queryTempData(QueryTempParams qtp) {
		ResultCode<TempCountParams> resultCode = new ResultCode<TempCountParams>();
		try {
			List<Temperature> temps = tempDAO.findAllByPage(qtp);// 获取数据
			if (temps != null && temps.size() > 0) {// 获取成功，正常情况
				resultCode = setQueryTempCountResult(qtp, temps,
						ServiceResult.GET_MESSAGE_SUCCESS);
			} else {// 查询失败
				resultCode = setQueryTempCountResult(qtp, temps,
						ServiceResult.GET_MESSAGE_NO_DATA);
			}
		} catch (Exception e) {
			if (e instanceof ParseException) {// 上传参数异常解析异常)
				resultCode = setQueryTempResult(null,
						ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;

	}

	/**
	 * 查询图表的温度数据
	 */
	public ResultCode<List<Temperature>> queryTempChartData(QueryTempParams qtp) {
		ResultCode<List<Temperature>> resultCode = new ResultCode<List<Temperature>>();
		try {
			List<Temperature> temps = tempDAO.findAll(qtp);// 获取数据
			if (temps != null && temps.size() > 0) {// 获取成功，正常情况
				resultCode = setQueryTempResult(temps,
						ServiceResult.GET_MESSAGE_SUCCESS);
			} else {// 查询失败
				resultCode = setQueryTempResult(temps,
						ServiceResult.GET_MESSAGE_NO_DATA);
			}
		} catch (Exception e) {
			if (e instanceof ParseException) {// 上传参数异常解析异常)
				resultCode = setQueryTempResult(null,
						ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;
	}

	private ResultCode<TempCountParams> setQueryTempCountResult(
			QueryTempParams qtp, List<Temperature> temps, ServiceResult message)
			throws Exception {
		ResultCode<TempCountParams> resultCode = new ResultCode<TempCountParams>();
		resultCode.setCode(message.getIndex());
		resultCode.setMessage(message.getName());
		TempCountParams result = new TempCountParams();
		if (temps != null) {
			// 查询数量信息
			QueryTempParams params;
			int count = tempDAO.getCount(qtp);
			result.setCount(count);
			result.setTemperatures(temps);
		}
		resultCode.setResult(result);
		return resultCode;
	}

	/**
	 * 返回参数
	 * 
	 * @param resultCode
	 * @param message
	 * @return
	 */
	private ResultCode<String> setSaveTempResult(ServiceResult message) {
		ResultCode<String> resultCode = new ResultCode<String>();
		resultCode.setCode(message.getIndex());
		resultCode.setMessage(message.getName());
		resultCode.setResult(null);
		return resultCode;
	}

	/**
	 * 返回参数
	 * 
	 * @param <T>
	 * 
	 * @param resultCode
	 * @param temps
	 * @param message
	 * @return
	 */
	private <T> ResultCode<T> setQueryTempResult(T result, ServiceResult message) {
		ResultCode<T> resultCode = new ResultCode<T>();
		resultCode.setCode(message.getIndex());
		resultCode.setMessage(message.getName());
		resultCode.setResult((T) result);
		return (ResultCode<T>) resultCode;
	}

	/**
	 * 获取最新的一条数据
	 */
	public ResultCode<Temperature> getNewTempData(GetNewTempParams gntp) {
		ResultCode<Temperature> resultCode = new ResultCode<Temperature>();
		try {
			Temperature temp = tempDAO.findByDateTime(gntp.getUid());
			if (temp != null) {
				resultCode = setQueryTempResult(temp,
						ServiceResult.GET_MESSAGE_SUCCESS);
			} else {// 查询失败
				resultCode = setQueryTempResult(temp,
						ServiceResult.GET_MESSAGE_NO_DATA);
			}
		} catch (Exception e) {
			if (e instanceof ParseException) {// 上传参数异常解析异常)
				resultCode = setQueryTempResult(null,
						ServiceResult.GET_MESSAGE_FALSE);
			}
		}
		return resultCode;
	}

}
