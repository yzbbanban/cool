package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.TempDAO;
import com.riti.cool.entity.QueryTempParams;
import com.riti.cool.entity.Temperature;

@Repository("tempDAO")
public class TempDAOMybatisImpl implements TempDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	/**
	 * 保存温度数据
	 */
	public boolean save(Temperature temp) {
		try {
			sst.insert("com.riti.cool.dao.TempDAO.save", temp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 根据 uid 时间段，获取所有的温度数据
	 */
	public List<Temperature> findAllByPage(QueryTempParams qtp) {
		try {
			return sst.selectList("com.riti.cool.dao.TempDAO.findAllByPage",
					qtp);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 根据 uid 获取温度数据集合
	 */
	public List<Temperature> findById(int id) {
		try {
			return sst.selectOne("com.riti.cool.dao.TempDAO.findById", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/**
	 * 更新温度
	 */
	public boolean modify(Temperature temp) {
		try {
			sst.update("com.riti.cool.dap.TempDAO.modify", temp);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 根据uid 查询最新的一条温度数据
	 */
	public Temperature findByDateTime(int id) {
		try {
			return sst.selectOne("com.riti.cool.dao.TempDAO.findFirstTemp", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public int getCount(QueryTempParams params) {
		return sst.selectOne("com.riti.cool.dao.TempDAO.getCount", params);
	}

	public List<Temperature> findAll(QueryTempParams qtp) {
		try {
			return sst.selectList("com.riti.cool.dao.TempDAO.findAll",
					qtp);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
