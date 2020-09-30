package services;

import javax.servlet.ServletContext;

import model.collections.Amenities;
import model.collections.Users;

public class Data {
	
	public static Users getUsers(ServletContext sCtx) {
		Users users = (Users) sCtx.getAttribute("users");
		
		if (users == null) { 
			users = new Users();
			sCtx.setAttribute("users", users);
		}
		
		return users;
	}

	public static Amenities getAmenities(ServletContext servletCtx) {
		Amenities amenities = (Amenities) servletCtx.getAttribute("amenities");
		
		if (amenities == null) {
			amenities = new Amenities();
			servletCtx.setAttribute("amenities", amenities);
		}
		
		return amenities;
	}

}
