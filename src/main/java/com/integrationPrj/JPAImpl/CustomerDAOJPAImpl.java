package com.integrationPrj.JPAImpl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerDAO;

//@Repository("customerDAOJPAImpl") 
@Component("customerDAOJPAImpl") // This also worked
@Transactional(propagation = Propagation.REQUIRED)
public class CustomerDAOJPAImpl implements CustomerDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Customer findCustomer(int id) {	
		return null;
	}

	@Override
	public void insertCustomerDetails(String name, int age, String sex, int id) {
		System.out.println("Welcome to JPA");
		 Customer p = new Customer();
	        p.setName(name);
	        p.setAge(age);
	        p.setSex(sex);
	        p.setId(id);
		entityManager.persist(p);
		
	}
	
	/**
	 * @return the entityManager
	 */
//	public EntityManager getEntityManager()
//	{
//		    return entityManager;
//	}

	/**
	 * @param entityManager the entityManager to set
	 */
//	public void setEntityManager(EntityManager entityManager)
//	{
//		    this.entityManager = entityManager;
//	}
		  
}
