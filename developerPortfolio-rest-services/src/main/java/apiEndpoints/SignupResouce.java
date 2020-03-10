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

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
import entities.User;
import services.SignupServiceImpl;
import servicesInterfaces.SignupService;

@Path("signup")
//@Consumes({MediaType.APPLICATION_JSON})
public class SignupResouce {

	private SignupService service = new SignupServiceImpl();
	
	@POST
	@Path("/register")
	@Consumes({MediaType.APPLICATION_JSON})
	public Response registration(User user){
		try{
			service.registerUser(user);
			return Response.ok("User registered successfully !" + user.toString()).build();
		}catch(Exception e){
			return Response.ok("Error in registering user !").build();
		}
	}
	
	@GET
	@Path("/test/{username}")
	public Response testResource(@PathParam("username")String username){
		return Response.ok("Signup resource working fine!.."+username).build();
	}
	
}
