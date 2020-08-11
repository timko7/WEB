package services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.User;
import model.collections.Users;
import model.types.UserState;
import model.types.UserType;

@Path("/log")
public class LoginService {
	
	@Context 
	HttpServletRequest request;
	@Context
	ServletContext servletCtx;
	
	
	
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		System.out.println("syso: Helo from: 'log/test'");
		return "Helo from: 'log/test'";
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User loginUser(User user) {
		System.out.println("LOGIN: " + user);
		
		Users users = getUsers();
		
		User userReturn = (User) request.getSession().getAttribute("user-info");
		if (userReturn == null) {
			userReturn = users.checkLogin(user);
			
			if (userReturn == null) { // If user is not registered to the app
				return null;
			}
			
			// if it is then just add object to session and continue with login
			request.getSession().setAttribute("user-info", userReturn);
		}

		if (userReturn.getUserState() == UserState.BLOCKED) {
			request.getSession().invalidate();
		}
		
		System.out.println("LOGIN(end): " + user);
		return userReturn;
	}
	
	@GET
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser() {
		User ret = (User) request.getSession().getAttribute("user-info");
		return ret;
	}
	
	@GET
	@Path("/logout")
	@Produces(MediaType.APPLICATION_JSON)
	public Response logout() {
		request.getSession().invalidate();
		return Response.status(200).build();
	}
	
	
	
	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User registration(User user) {
		System.out.println("REGISTRACIJA: " + user);
		
		Users users = getUsers();
		
		if(users.getUsers().contains(user)){
			return null;
		} else {
			
			user.setUserType(UserType.GUEST);
			user.setUserState(UserState.NORMAL);
			
			users.addUser(user);
			request.getSession().setAttribute("user-info", user);
			
			users.saveUsers();
			return user;
		}		
	}	
	
	
	/**
	 * Returns Users object from servlet context.
	 * @return Users object
	 */
	private Users getUsers() {
		Users users = (Users) servletCtx.getAttribute("users");
		
		if (users == null) { 
			users = new Users();
			servletCtx.setAttribute("users", users);
		}
		
		return users;
	}
	
	

}
