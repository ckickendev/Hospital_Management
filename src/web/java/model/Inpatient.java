package web.java.model;

public class Inpatient {
	private int id;
	private int patient_id;
	private String admission_date;
	private String discharge_date;
	private String room;
	private String notes;
	public Inpatient(int id, int patient_id, String admission_date, String discharge_date, String room, String notes) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.admission_date = admission_date;
		this.discharge_date = discharge_date;
		this.room = room;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPatient_id() {
		return patient_id;
	}
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}
	public String getAdmission_date() {
		return admission_date;
	}
	public void setAdmission_date(String admission_date) {
		this.admission_date = admission_date;
	}
	public String getDischarge_date() {
		return discharge_date;
	}
	public void setDischarge_date(String discharge_date) {
		this.discharge_date = discharge_date;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Inpatient [id=" + id + ", patient_id=" + patient_id + ", admission_date=" + admission_date
				+ ", discharge_date=" + discharge_date + ", room=" + room + ", notes=" + notes + "]";
	}
	
	

}
