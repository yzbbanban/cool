package com.riti.cool.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riti.cool.entity.GetNewTempParams;
import com.riti.cool.entity.QueryTempParams;
import com.riti.cool.entity.TempCountParams;
import com.riti.cool.entity.Temperature;
import com.riti.cool.service.TempService;
import com.riti.cool.util.ResultCode;

@Controller
@RequestMapping("/temp")
public class TempController {
	@Resource
	private TempService service;

	// 保存温度数据
	@RequestMapping(value = "/uploadTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<String> saveTempPost(HttpServletResponse res,
			String tempJson) {
		ResultCode<String> result = new ResultCode<String>();
		System.out.println("saveTempPost");
		System.out.println("json: " + tempJson);
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.saveTempData(tempJson);
			System.out.println("result: " + result);
			if (!"null".equals(result)) {// 数据存入成功
				// out.println(result);
				return result;
			} else {// 数据存入失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}
	}

	// 获取温度数据
	@RequestMapping(value = "/queryTempByPage", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<TempCountParams> queryTempPost(HttpServletResponse res,
			QueryTempParams qtp) {
		ResultCode<TempCountParams> result = new ResultCode<TempCountParams>();
		System.out.println(qtp);
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.queryTempData(qtp);
			System.out.println("result: " + result);
			if (!"".equals(result)) {// 数据获取成功
				// out.println(result);
				System.out.println("!!");
				return result;
			} else {// 数据获取失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}

	}

	// 获取温度数据
	@RequestMapping(value = "/queryTempChart", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<List<Temperature>> queryTempChart(HttpServletResponse res,
			QueryTempParams qtp) {
		ResultCode<List<Temperature>> result = new ResultCode<List<Temperature>>();
		System.out.println(qtp);
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.queryTempChartData(qtp);
			System.out.println("result: " + result);
			if (!"".equals(result)) {// 数据获取成功
				// out.println(result);
				System.out.println("!!");
				return result;
			} else {// 数据获取失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}

	}

	// 测试用
	@RequestMapping(value = "/getQueryTemp", method = RequestMethod.GET)
	@ResponseBody
	public ResultCode<List<Temperature>> queryTempGet() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ResultCode<List<Temperature>> rc = new ResultCode<List<Temperature>>();
		List<Temperature> temps = new ArrayList<Temperature>();
		for (int i = 0; i < 100; i++) {
			Temperature temp = new Temperature();
			temp.setUid(1111112);
			temp.setDateTime(sdf
					.format(new Date(1502696936203L + i * 1000 * 60)));
			temp.setGoodsName("good" + i);
			temp.setMinTemperature(-10);
			temp.setMaxTemperature(20);
			temp.setTemperature(10);
			temp.setStatus(0);
			temp.setHum(80);
			temp.setMinHum(60);
			temp.setMaxHum(90);
			temp.setHumStatus(0);
			temps.add(temp);
		}
		rc.setCode("10000");
		rc.setMessage("正常");
		rc.setResult(temps);
		System.out.println(rc);
		return rc;
	}

	@RequestMapping(value = "/getNewTemp", method = RequestMethod.POST)
	@ResponseBody
	public ResultCode<Temperature> queryNewTempPost(HttpServletResponse res,
			GetNewTempParams gntp) {

		ResultCode<Temperature> result = new ResultCode<Temperature>();
		res.setCharacterEncoding("utf-8");
		try {
			// PrintWriter out = res.getWriter();
			result = service.getNewTempData(gntp);
			System.out.println("result: " + result);
			if (!"".equals(result)) {// 数据获取成功
				// out.println(result);
				System.out.println("!!");
				return result;
			} else {// 数据获取失败
				// out.println(result);
				return result;
			}
		} catch (Exception e) {
			return result;
		}
	}

}
