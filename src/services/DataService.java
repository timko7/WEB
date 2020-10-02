package services;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.Amenity;
import model.User;
import model.collections.Amenities;
import model.collections.Users;
import model.types.UserType;

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

	@GET
	@Path("/getAllUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> getAllUsers() {
		User user = (User) request.getSession().getAttribute("user-info"); // only admin can get all users
		if (user.getUserType() == UserType.ADMIN) {
			return Data.getUsers(servletCtx).getUsers();
		}
		return new ArrayList<User>();
	}

	@GET
	@Path("/amenities")
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Amenity> getAllAmenities() {
		User user = (User) request.getSession().getAttribute("user-info"); // only admin can get all amenities
		if (user.getUserType() == UserType.ADMIN) {
			return Data.getAmenities(servletCtx).getAmenitiesNoDeleted();
		}
		return new ArrayList<Amenity>();
	}

	@POST
	@Path("/amenities")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postAmenity(Amenity amenityToAdd) {
		Amenities amenities = Data.getAmenities(servletCtx);

		Long id = (long) amenities.getAmenities().size();

		amenityToAdd.setName(amenityToAdd.getName().trim());

		amenityToAdd.setId(id);
		amenityToAdd.setDeleted(false);
		if (amenities.findByName(amenityToAdd.getName()) == null) {
			amenities.addAmenity(amenityToAdd);
			amenities.saveAmenities();
			return Response.ok(amenityToAdd).build();
		} else {
			return Response.status(400).entity("Amenity name already exist!").build();
		}
	}

	@GET
	@Path("/amenities/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Amenity getAmenityById(@PathParam("id") Long id) {
		Amenities amenities = Data.getAmenities(servletCtx);

		Amenity retAmenity = amenities.findById(id);

		return retAmenity;
	}

	@PUT
	@Path("/amenityChangeName/{name}")
	public Response changeAmenityName(@PathParam("name") String amenityName, String newAmenityName) {
		Amenities amenities = Data.getAmenities(servletCtx);

		Amenity retAmenity = amenities.findByName(amenityName);

		if (retAmenity == null) {
			return Response.status(Status.NOT_FOUND).entity("Amenity not found!").build();
		}

		if (newAmenityName.trim() == "") {
			return Response.status(Status.NOT_ACCEPTABLE).entity("Amenity new name is empty!").build();
		}

		if (newAmenityName.trim().toLowerCase().equals(amenityName.trim().toLowerCase())) {
			return Response.ok("Successfully renamed amenity!").build();
		}

		if (amenities.findByName(newAmenityName) == null) {
			retAmenity.setName(newAmenityName);
			amenities.saveAmenities();
			return Response.ok("Successfully renamed amenity!").build();
		} else {
			return Response.status(Status.BAD_REQUEST).entity("Amenity with that name already exist!").build();
		}

	}

	@POST
	@Path("/amenityDelete/{name}")
	public Response deleteAmenity(@PathParam("name") String amenityName) {
		Amenities amenities = Data.getAmenities(servletCtx);

		Amenity retAmenity = amenities.findByName(amenityName);
		if (retAmenity != null) {
			retAmenity.setDeleted(true);
			amenities.saveAmenities();
			return Response.ok("Successfully deleted amenity!").build();
		}
		return Response.status(Status.NOT_FOUND).entity("Amenity not found!").build();
	}

}
