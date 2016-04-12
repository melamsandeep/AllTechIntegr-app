package com.integrationPrj.Restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerJDBCImp;

@RestController
@RequestMapping(value = "/customer", headers = {"Accept=application/json"})
public class CustomerDetailsMVC {

	@Autowired
	private CustomerJDBCImp custimp;

	// private CustomerJDBCImp custimp = new CustomerJDBCImp();

	Customer cust = new Customer();

	@RequestMapping(value = "/getdetails/{id}", method = RequestMethod.GET, produces = "application/json")
	// @RequestMapping(value = "/getdetails/{id}", method = RequestMethod.GET,headers="Accept=application/json")
	// public Customer findCustomerbyId(@PathVariable("id") int id, @RequestHeader HttpHeaders headers) {
	public Customer findCustomerbyId(@PathVariable("id") int id) {
		// System.out.print("findCustomerbyId is called, id : " + id);
		String username = "No Value";

		// if (headers != null)
		// {
		// username = headers.getHeaderString("username");
		// pwd = headers.getHeaderString("Password");
		// }
		System.out.println("username = " + username);

		cust = custimp.findCustomer(id);

		return cust;
		// return Response.status(200)
		// .entity("getUserByName is called, name : " + id).build();

	}

	@RequestMapping(value = "/sandeep", method = RequestMethod.GET)
	public ModelAndView student1() {
		return new ModelAndView("EmployeeDetails", "command", new Customer());
	}

	@RequestMapping(value = "/uploadmvcRestfull", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
	public void addStudent(Customer cus) {
		custimp.insertCustomerDetails(cus.getName(), cus.getAge(), cus.getSex(), cus.getId());
	}

}
