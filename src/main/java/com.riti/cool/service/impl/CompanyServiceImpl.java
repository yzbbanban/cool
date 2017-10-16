package com.riti.cool.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.riti.cool.dao.CompanyDAO;
import com.riti.cool.dao.UserDAO;
import com.riti.cool.entity.Company;
import com.riti.cool.entity.User;
import com.riti.cool.service.CompanyService;
import com.riti.cool.service.exception.AddCompanyException;
import com.riti.cool.service.exception.CompanyExistException;
import com.riti.cool.service.exception.UserUpdateException;

@Service
public class CompanyServiceImpl implements CompanyService {
	@Resource
	private CompanyDAO companyDao;
	@Resource
	private UserDAO userDao;

	public User setUserCompany(String userId, Company company) {

		// 先判断是否有此公司
		Company comp = companyDao.findCompanyByName(company.getName());
		// 判断用户是否绑定此公司
		User user = userDao.findUserById(userId);
		System.out.println("ban 创建的公司"+comp);
		if (comp == null && "".equals(user.getCompanyId())) {// 没有公司在新建
			// 生成主键
			String companyId = UUID.randomUUID().toString();
			company.setId(companyId);
			// 添加company
			int n = companyDao.addCompany(company);
			if (n == 1) {
				user.setCompanyId(companyId);
				user.setId(userId);
				int row = userDao.updateUserCompany(user);
				if (row == 1) {
					user = userDao.findUserById(userId);
				} else {
					// TODO 更新user信息失败 异常
					throw new UserUpdateException("更新用户信息失败");
				}
			} else {
				// TODO 保存公司失败 异常
				throw new AddCompanyException("保存公司失败");
			}
		} else {
			// TODO 重复公司信息 异常
			throw new CompanyExistException("重复公司信息");
		}
		return user;
	}

	/**
	 * 获取用户公司信息
	 */
	public Company getUserCompany(String userId) {
		User user = userDao.findUserById(userId);
		Company company = companyDao.findCompanyById(user.getCompanyId());
		return company;
	}

	/**
	 * 根据公司名查找公司
	 */
	public List<Company> findCompany(String companyName) {
		//获取公司列表
		List<Company> companys = companyDao.findCompanyByBlurName(companyName);
		if(companys!=null && companys.size()>0){
			return companys;
		}else{
			throw new CompanyExistException("公司不存在");
		}
	}

}
