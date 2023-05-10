package web.java.model;

public class PatientAdmission {
	private int id;
	private String date;
	private int patient_id;
	private String symptoms;
	private String initial_dianosis;
	private String notes;
	public PatientAdmission(int id, String date, int patient_id, String symptoms, String initial_dianosis, String notes) {
		super();
		this.id = id;
		this.date = date;
		this.symptoms = symptoms;
		this.patient_id = patient_id;
		this.initial_dianosis = initial_dianosis;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getInitial_dianosis() {
		return initial_dianosis;
	}
	public void setInitial_dianosis(String initial_dianosis) {
		this.initial_dianosis = initial_dianosis;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "PatientAdmission [id=" + id + ", date=" + date + ", symptoms=" + symptoms + ", initial_dianosis="
				+ initial_dianosis + ", notes=" + notes + "]";
	}
	
	

}
