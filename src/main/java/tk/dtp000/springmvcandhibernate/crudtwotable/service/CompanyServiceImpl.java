package tk.dtp000.springmvcandhibernate.crudtwotable.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tk.dtp000.springmvcandhibernate.crudtwotable.entity.Company;
import tk.dtp000.springmvcandhibernate.crudtwotable.repository.CompanyRepository;
@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired CompanyRepository companyDao;
	
	
	@Override
	@Transactional
	public List<Company> getCompanies() {
		// TODO Auto-generated method stub
		return companyDao.getCompanies();
	}

	@Override
	@Transactional
	public void save(Company company) {
		// TODO Auto-generated method stub
		companyDao.save(company);
	}

	@Override
	@Transactional
	public Company find(int id) {
		// TODO Auto-generated method stub
		return companyDao.find(id);
	}

	@Override
	@Transactional
	public void destroy(int id) {
		// TODO Auto-generated method stub
		companyDao.destroy(id);
	}
	
}
