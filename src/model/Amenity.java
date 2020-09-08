package model;

public class Amenity {

	private Long id;	//TODO: ovde je id length od ukupno
	private String name;

	public Amenity() {
	}

	public Amenity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
