package model.collections;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Amenity;

public class Amenities {

	public static String amenitiesFileLocation = "C:\\webProjekat-workspace\\WEB\\WebContent\\res\\amenities.txt";

	private ArrayList<Amenity> amenities;

	public Amenities() {
		this(amenitiesFileLocation);
	}

	public Amenities(String path) {
		amenities = new ArrayList<>();

		BufferedReader reader = null;

		try {
			File file = new File(path);

			reader = new BufferedReader(new FileReader(file));
			readAmenities(reader);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
				}
			}
		}
	}

	private void readAmenities(BufferedReader reader) {
		String line = null;
		StringTokenizer st;
		try {
			while ((line = reader.readLine()) != null) {
				line = line.trim();

				if (line.equals(""))
					continue;

				st = new StringTokenizer(line, "|");

				Long id = Long.parseLong(st.nextToken().trim());
				String name = st.nextToken().trim();

				boolean deleted = Boolean.parseBoolean(st.nextToken().trim());

				Amenity newAmenity = new Amenity(id, name, deleted);
				amenities.add(newAmenity);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void saveAmenities() {
		try {
			PrintWriter writer = new PrintWriter(amenitiesFileLocation);

			for (Amenity amenity : amenities) {
				writer.println(amenity.toStringFile());
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addAmenity(Amenity amenity) {
		this.amenities.add(amenity);
	}

	public ArrayList<Amenity> getAmenities() {
		return amenities;
	}

	public ArrayList<Amenity> getAmenitiesNoDeleted() {
		ArrayList<Amenity> ret = new ArrayList<>();
		for (Amenity amenity : amenities) {
			if (!amenity.isDeleted()) {
				ret.add(amenity);
			}
		}
		return ret;
	}

	public Amenity findByName(String name) {
		for (Amenity amenity : amenities) {
			String s = amenity.getName().toLowerCase();
			if (s.equals(name.toLowerCase())) {
				return amenity;
			}
		}

		return null;
	}

	public Amenity findById(Long id) {
		for (Amenity amenity : amenities) {
			if (amenity.getId().equals(id)) {
				return amenity;
			}
		}
		return null;
	}

}
