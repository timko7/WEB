package services;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import model.User;
import model.collections.Users;

@Path("/data")
public class DataService {

	@Context
	HttpServletRequest request;
	@Context
	ServletContext servletCtx;
	
	@POST
	@Path("/userEdit")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User editUser(User user) {
		Users users = Data.getUsers(servletCtx);
		User userToEdit = users.containsUsername(user.getUsername());
		
		if (userToEdit == null) {
			return user;
		}
		
		userToEdit.setName(user.getName());
		userToEdit.setSurname(user.getSurname());
		userToEdit.setPassword(user.getPassword());
		
		users.saveUsers();
		
		return userToEdit;
	}

}
