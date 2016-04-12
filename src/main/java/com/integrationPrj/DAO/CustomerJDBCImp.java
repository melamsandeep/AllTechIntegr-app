package com.integrationPrj.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.integrationPrj.DAO.SqlUtil.SQLUtil;

public class CustomerJDBCImp {
	
	private String driverName;
	private String dbName;
	private String userName;
	private String password;
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	Connection con = null; 
	Customer cust = new Customer();

	//For CustomerDetailsMVC.java
//	public CustomerJDBCImp()
//	{
//	
//	}
	
	//For CustomerDetails.java
	public CustomerJDBCImp()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
						
		try {
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "suri");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	
	}
	
	public void creatConnection()
	{
		System.out.println("creatConnection");
		try {
			Class.forName(getDriverName());
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
						
		try {
			this.con = DriverManager.getConnection(getDbName(), getUserName(), getPassword());

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Customer findCustomer(int id)
	{
		try {
			//creatConnection();
			System.out.println("Before");
			java.sql.PreparedStatement st =  con.prepareStatement(SQLUtil.CUSTOMER_SELECT);
			System.out.println("After");
			st.setInt(1, id);
			
			ResultSet rs = st.executeQuery(); 
			
			while(rs.next())
			{
				cust.setName(rs.getString(1));
				cust.setAge(rs.getInt(2));
				cust.setSex(rs.getString(3));
				cust.setId(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cust;
	}
	
	public void insertCustomerDetails(String name, int age, String sex, int id)
	{
		try {
			//creatConnection();
			System.out.println("Welcome to Insert Stmt");
			java.sql.PreparedStatement st =  con.prepareStatement(SQLUtil.CUSTOMER_INS);
			st.setString(1, name);
			st.setInt(2, age);
			st.setString(3, sex);
			st.setInt(4, id);
			
		 st.executeUpdate(); 	

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
