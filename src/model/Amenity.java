package model;

public class Amenity {

	private Long id; // TODO: ovde je id length od ukupno
	private String name;
	private boolean deleted; // True-deleted, false-not

	public Amenity() {
	}

	public Amenity(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Amenity(Long id, String name, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.deleted = deleted;
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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Amenity [id=" + id + ", name=" + name + ", deleted=" + deleted + "]";
	}

	public String toStringFile() {
		return id + "|" + name + "|" + deleted;
	}

}
