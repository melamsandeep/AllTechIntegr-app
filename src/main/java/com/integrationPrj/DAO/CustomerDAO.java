package com.integrationPrj.DAO;

public interface CustomerDAO {
	
	public Customer findCustomer(int id);
	public void insertCustomerDetails(String name, int age, String sex, int id);

}
