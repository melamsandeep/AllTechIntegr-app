package com.integrationPrj.DAO.SqlUtil;

public class SQLUtil {
	
	public static final String CUSTOMER_SELECT = "select * from customer where id =?";
	
	public static final String CUSTOMER_INS = "insert into Customer(Name,Age,Sex,Id) values(?,?,?,?)";
	
	

}
