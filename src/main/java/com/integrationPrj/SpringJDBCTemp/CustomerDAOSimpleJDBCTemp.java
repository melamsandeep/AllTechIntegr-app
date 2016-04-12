package com.integrationPrj.SpringJDBCTemp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerDAO;
import com.integrationPrj.DAO.SqlUtil.SQLUtil;

@Component("customerDAOSimpleJDBCTemp")
public class CustomerDAOSimpleJDBCTemp implements CustomerDAO {

	@Autowired
	private JdbcTemplate template;
	@Override
	public Customer findCustomer(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCustomerDetails(String name, int age, String sex, int id) {
		// TODO Auto-generated method stub
		
		Object[] values = new Object[]{name,age,sex,id};
		template.update(SQLUtil.CUSTOMER_INS, values);
	}

}
