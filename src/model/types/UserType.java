package model.types;

public enum UserType {
	
	ADMIN, GUEST, HOST;
	
	public static UserType parseString(String value) {
		switch (value.toUpperCase()) {
		case "ADMIN":
			return ADMIN;
		case "GUEST":
			return GUEST;
		case "HOST":
			return HOST;
		default:
			return null;
		}
	}

}
