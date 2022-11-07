package tk.dtp000.springmvcandhibernate.crudtwotable.repository;

import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tk.dtp000.springmvcandhibernate.crudtwotable.entity.Company;

@Repository
public class CompanyRepositoryImpl implements CompanyRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Company> getCompanies() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Company> cq = cb.createQuery(Company.class);
		Root<Company> root = cq.from(Company.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void save(Company company) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(company);
	}

	@Override
	public Company find(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Company c = currentSession.get(Company.class, id);
		return c;
	}

	@Override
	public void destroy(int id) {
		Session session = sessionFactory.getCurrentSession();
		Company book = session.byId(Company.class).load(id);
		session.delete(book);
	}
	
}
