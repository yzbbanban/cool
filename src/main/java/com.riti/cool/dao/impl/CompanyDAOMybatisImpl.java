package com.riti.cool.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.riti.cool.dao.CompanyDAO;
import com.riti.cool.entity.Company;
import com.riti.cool.entity.DeviceParams;

@Repository("companyDAO")
public class CompanyDAOMybatisImpl implements CompanyDAO {
	@Resource(name = "sst")
	private SqlSessionTemplate sst;

	public int addCompany(Company company) {

		return sst.insert("com.riti.cool.dao.CompanyDAO.addCompany", company);

	}

	public Company findCompanyByName(String name) {
		return sst.selectOne("com.riti.cool.dao.CompanyDAO.findCompanyByName",
				name);
	}

	public Company findCompanyById(String companyId) {
		return sst.selectOne("com.riti.cool.dao.CompanyDAO.findCompanyById",
				companyId);
	}

	public List<Company> findCompanyByBlurName(String name) {
		return sst.selectList("com.riti.cool.dao.CompanyDAO.findCompanyByBlurName",
				name);
	}
}
