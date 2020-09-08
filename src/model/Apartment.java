package model;

import java.util.ArrayList;
import java.util.Date;

import model.types.ApartmentType;
import model.types.ApartmentStatus;

public class Apartment {

	private Long id; // TODO: ovde je id length od ukupno
	private String userNameHost;
	private ApartmentType apartmentType;
	private int numberOfRooms;
	private int numberOfGuests;
	private Location location;
	private ArrayList<Date> dates; // entered dates for rent
	private ArrayList<Date> freeDates;
	private ArrayList<String> comments;
	private ArrayList<String> pictures;
	private int price;
	private int timeCheckIn; // initial 2pm
	private int timeCheckOut; // initial 10am
	private ApartmentStatus aprtmentStatus;
	private ArrayList<Amenity> amenities;

	public Apartment() {
		super();
	}

	public Apartment(Long id, String userNameHost, ApartmentType apartmentType, int numberOfRooms, int numberOfGuests,
			Location location, ArrayList<Date> dates, ArrayList<Date> freeDates, ArrayList<String> comments,
			ArrayList<String> pictures, int price, int timeCheckIn, int timeCheckOut, ApartmentStatus aprtmentStatus,
			ArrayList<Amenity> amenities) {
		super();
		this.id = id;
		this.userNameHost = userNameHost;
		this.apartmentType = apartmentType;
		this.numberOfRooms = numberOfRooms;
		this.numberOfGuests = numberOfGuests;
		this.location = location;
		this.dates = dates;
		this.freeDates = freeDates;
		this.comments = comments;
		this.pictures = pictures;
		this.price = price;
		this.timeCheckIn = timeCheckIn;
		this.timeCheckOut = timeCheckOut;
		this.aprtmentStatus = aprtmentStatus;
		this.amenities = amenities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserNameHost() {
		return userNameHost;
	}

	public void setUserNameHost(String userNameHost) {
		this.userNameHost = userNameHost;
	}

	public ApartmentType getApartmentType() {
		return apartmentType;
	}

	public void setApartmentType(ApartmentType apartmentType) {
		this.apartmentType = apartmentType;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public ArrayList<Date> getDates() {
		return dates;
	}

	public void setDates(ArrayList<Date> dates) {
		this.dates = dates;
	}

	public ArrayList<Date> getFreeDates() {
		return freeDates;
	}

	public void setFreeDates(ArrayList<Date> freeDates) {
		this.freeDates = freeDates;
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public void setComments(ArrayList<String> comments) {
		this.comments = comments;
	}

	public ArrayList<String> getPictures() {
		return pictures;
	}

	public void setPictures(ArrayList<String> pictures) {
		this.pictures = pictures;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getTimeCheckIn() {
		return timeCheckIn;
	}

	public void setTimeCheckIn(int timeCheckIn) {
		this.timeCheckIn = timeCheckIn;
	}

	public int getTimeCheckOut() {
		return timeCheckOut;
	}

	public void setTimeCheckOut(int timeCheckOut) {
		this.timeCheckOut = timeCheckOut;
	}

	public ApartmentStatus getAprtmentStatus() {
		return aprtmentStatus;
	}

	public void setAprtmentStatus(ApartmentStatus aprtmentStatus) {
		this.aprtmentStatus = aprtmentStatus;
	}

	public ArrayList<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(ArrayList<Amenity> amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		return "Apartment [id=" + id + ", userNameHost=" + userNameHost + ", apartmentType=" + apartmentType
				+ ", numberOfRooms=" + numberOfRooms + ", numberOfGuests=" + numberOfGuests + ", location=" + location
				+ ", dates=" + dates + ", freeDates=" + freeDates + ", comments=" + comments + ", pictures=" + pictures
				+ ", price=" + price + ", timeCheckIn=" + timeCheckIn + ", timeCheckOut=" + timeCheckOut
				+ ", aprtmentStatus=" + aprtmentStatus + ", amenities=" + amenities + "]";
	}

}
