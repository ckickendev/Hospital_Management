package web.java.model;

public class Medication {
	private int id;
	private String name;
	private String dosage;
	private String notes;
	private float price;
	public Medication(int id, String name, String dosage, String notes, float price) {
		super();
		this.id = id;
		this.name = name;
		this.dosage = dosage;
		this.notes = notes;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Medication [id=" + id + ", name=" + name + ", dosage=" + dosage + ", notes=" + notes + ", price="
				+ price + "]";
	}
	
	
}
