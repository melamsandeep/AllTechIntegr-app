package com.integrationPrj.SpringJDBCTemp;

import org.springframework.stereotype.Component;

import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerDAO;

@Component("qualifierTestingClass")
public class QualifierTestingClass implements CustomerDAO{

	@Override
	public Customer findCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCustomerDetails(String name, int age, String sex, int id) {
		// TODO Auto-generated method stub
		
	}

}
