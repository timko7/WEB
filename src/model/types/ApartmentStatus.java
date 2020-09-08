package model.types;

public enum ApartmentStatus {
	
	ACTIVE, INACTIVE;
	
	public static ApartmentStatus parseString(String value) {
		switch (value.toUpperCase()) {
		case "ACTIVE":
			return ACTIVE;
		case "INACTIVE":
			return INACTIVE;
		default:
			return null;
		}
	}

}
