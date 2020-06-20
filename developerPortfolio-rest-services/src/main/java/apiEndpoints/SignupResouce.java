package apiEndpoints;

import javax.ejb.EJB;
//import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.User;
import security.PasswordService;
import security.PasswordServiceImpl;
import services.SignupServiceImpl;
import servicesInterfaces.SignupService;

@Path("signup")
//@Consumes({MediaType.APPLICATION_JSON})
public class SignupResouce {

	private SignupService service = new SignupServiceImpl();
	//TODO:Move password Service and JWT Service to ResourceBase class
	private PasswordService passwordService = new PasswordServiceImpl();

	@POST
	@Path("/register")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response registration(User user){
		try{
			//Creating hashed Password and setting ...
			user.setPassword(passwordService.createPassword(user.getPassword()));
			service.registerUser(user);
			return Response.ok("User registered successfully !" + user.toString()).build();
		}catch(Exception e){
			return Response.ok("Error in registering user !").build();
		}
	}

	@GET
	@Path("/validateCredentials/{email}/{password}")
	public Response testResource(@PathParam("email") String email,@PathParam("password") String inputPassword){
		String foundUserPassword = "ulvRs5TBJ4II+fpZOaRcJmukUCEhzPEWNjZWdtFnjcYVH1ksriGx/6hgk6M57A9Gz/j5V3iGv/ZtZcHPJHej1GFL2ZkPj+/ky3oZ0A==";
		boolean isValidUser = passwordService.authenticatePassword(inputPassword,foundUserPassword);
		String msg = isValidUser ? "Passwords Match Successful!" : "Incorrect Password!";
		return Response.ok(msg).build();
	}
	
	@GET
	@Path("/test/{username}")
	public Response testResource(@PathParam("username")String username){
		return Response.ok("Signup resource working fine!.."+username).build();
	}
	
}
