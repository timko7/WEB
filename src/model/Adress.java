package model;

public class Adress {
	
	private String streetAndNumb;
	private String place;
	private int postalCode;

	public Adress() {
	}

	public Adress(String streetAndNumb, String place, int postalCode) {
		super();
		this.streetAndNumb = streetAndNumb;
		this.place = place;
		this.postalCode = postalCode;
	}

	public String getStreetAndNumb() {
		return streetAndNumb;
	}

	public void setStreetAndNumb(String streetAndNumb) {
		this.streetAndNumb = streetAndNumb;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

}
