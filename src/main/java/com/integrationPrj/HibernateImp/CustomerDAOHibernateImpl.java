package com.integrationPrj.HibernateImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerDAO;

@Component("customerDAOHibernateImpl")
public class CustomerDAOHibernateImpl implements CustomerDAO{
	@Autowired
	 private SessionFactory sessionFactory;
	 
//	    public void setSessionFactory(SessionFactory sessionFactory) {
//	        this.sessionFactory = sessionFactory;
//	    }
	@Override
	public Customer findCustomer(int id) {	
		return null;
	}

	@Override
	public void insertCustomerDetails(String name, int age, String sex, int id) {
		System.out.println("Welcome to Hibernate");
		 Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        Customer p = new Customer();
	        p.setName(name);
	        p.setAge(age);
	        p.setSex(sex);
	        p.setId(id);
	        session.persist(p);
	        tx.commit();
	        session.close();
		
	}

}
