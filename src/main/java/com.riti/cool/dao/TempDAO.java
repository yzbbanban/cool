package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.GetNewTempParams;
import com.riti.cool.entity.QueryTempParams;
import com.riti.cool.entity.Temperature;

@Repository("tempDAO")
public interface TempDAO {
	/**
	 * 保存温标设备
	 * 
	 * @param temp 温度信息
	 */
	boolean save(Temperature temp);

	/**
	 * 根据 uid 和时间段查找所有数据
	 * 
	 * @return 温度集合
	 */
	List<Temperature> findAll(QueryTempParams qtp);

	/**
	 * 根据 uid 查找温标数据
	 * 
	 * @param id
	 *            uid
	 * @return
	 */
	public List<Temperature> findById(int id);

	/**
	 * 更新设备
	 * 
	 * @param temp 设备信息
	 */
	boolean modify(Temperature temp);

	/**
	 * 根据 uid 查询最新的一条温度数据
	 * 
	 * @param id
	 * @return
	 */
	Temperature findByDateTime(int id);

	/**
	 * 根据 uid 查询数据量
	 * 
	 * @param params
	 * @return
	 */
	int getCount(QueryTempParams params);

	/**
	 * 根据页数查找数据
	 * 
	 * @param qtp
	 * @return
	 */
	List<Temperature> findAllByPage(QueryTempParams qtp);
}
