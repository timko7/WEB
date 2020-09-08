package model;

public class Location {

	private String latitude;
	private String longitude;
	private Adress adress;

	public Location() {
		super();
	}

	public Location(String latitude, String longitude, Adress adress) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.adress = adress;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

}
