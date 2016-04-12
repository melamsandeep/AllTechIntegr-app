package com.integrationPrj.Servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.integrationPrj.DAO.CustomerDAO;
import com.integrationPrj.SpringJDBCTemp.CustomerDAOSimpleJDBCTemp;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
				config.getServletContext());
	}
       
//	@Autowired
//	private CustomerJDBCImp custimp;
	
	//CustomerDAOSimpleJDBCTemp jdbctemp = new CustomerDAOSimpleJDBCTemp();
	@Autowired
	//@Qualifier("customerDAOSimpleJDBCTemp")
	//@Qualifier("customerDAOHibernateImpl")
	@Qualifier("customerDAOJPAImpl")
	CustomerDAO customerDaoJdbcTemp;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Servlet");
		
		String name = request.getParameter("Name");
		String age = request.getParameter("Age");
		String sex = request.getParameter("Sex");
		String id = request.getParameter("Id");
		
		//custimp.insertCustomerDetails(name, Integer.parseInt(age) , sex, Integer.parseInt(id));
		
		customerDaoJdbcTemp.insertCustomerDetails(name, Integer.parseInt(age) , sex, Integer.parseInt(id));
		
		doGet(request, response);
		
	}

}
