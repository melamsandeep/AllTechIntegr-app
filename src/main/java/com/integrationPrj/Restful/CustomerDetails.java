package com.integrationPrj.Restful;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import com.integrationPrj.DAO.Customer;
import com.integrationPrj.DAO.CustomerJDBCImp;


@Path("/hello")
//@RequestMapping(value = "/hello", headers = {"Accept=application/json"})
public class CustomerDetails {

	CustomerJDBCImp custimp = new CustomerJDBCImp();
	Customer cust = new Customer();

	@GET
	@Path("{id}")
	// @Produces("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Customer findCustomerbyId(@PathParam("id") int id) {// ,
																// @RequestHeader
																// HttpHeaders
																// headers) {
		// System.out.print("findCustomerbyId is called, id : " + id);
		String username = "No Value";
	
		// if (headers != null)
		// {
		// username = headers.getFirst("username");
		// pwd = headers.getFirst("Password");
		// }
		System.out.println("username = " + username);

		cust = custimp.findCustomer(id);
		// System.out.print("findCustomerbyId is called, cust.getName() : " +
		// cust.getName());
		return cust;
		// return Response.status(200)
		// .entity("getUserByName is called, name : " + id).build();

	}

	@POST
	@Path("/upload")
	// @Consumes("application/x-www-form-urlencoded")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response uploadEmployee(@FormParam("Name") String name, @FormParam("Age") int age,
			@FormParam("Sex") String sex, @FormParam("Id") int id) {
		System.out.println("Welcome");

		custimp.insertCustomerDetails(name, age, sex, id);
		return Response.status(200).entity("Welcome").build();

	}

}
