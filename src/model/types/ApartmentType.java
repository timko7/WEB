package model.types;

public enum ApartmentType {

	WHOLE_APARTMENT, ROOM;

	public static ApartmentType parseString(String value) {
		switch (value.toUpperCase()) {
		case "WHOLE_APARTMENT":
			return WHOLE_APARTMENT;
		case "ROOM":
			return ROOM;
		default:
			return null;
		}
	}

}
