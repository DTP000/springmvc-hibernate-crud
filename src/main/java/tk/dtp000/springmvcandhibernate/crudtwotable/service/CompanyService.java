package tk.dtp000.springmvcandhibernate.crudtwotable.service;

import java.util.List;

import tk.dtp000.springmvcandhibernate.crudtwotable.entity.Company;

public interface CompanyService {
	
	public List<Company> getCompanies();
	
	public void save(Company company);
	
	public Company find(int id);
	
	public void destroy(int id);
}
