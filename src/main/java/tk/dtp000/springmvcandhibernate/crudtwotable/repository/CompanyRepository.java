package tk.dtp000.springmvcandhibernate.crudtwotable.repository;

import java.util.List;

import tk.dtp000.springmvcandhibernate.crudtwotable.entity.Company;

public interface CompanyRepository {
	public List<Company> getCompanies();
	
	public void save(Company company);
	
	public Company find(int id);
	
	public void destroy(int id);
}
