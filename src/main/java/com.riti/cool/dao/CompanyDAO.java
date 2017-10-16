package com.riti.cool.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.riti.cool.entity.Company;
@Repository("companyDAO")
public interface CompanyDAO {
	int addCompany(Company company);
	Company findCompanyByName(String name);
	Company findCompanyById(String companyId);
	List<Company> findCompanyByBlurName(String name);
}
