package web.java.model;

public class Finance {
	private int id;
	private int patient_id;
	private String date;
	private int service_id;
	private String notes;
	public Finance(int id, int patient_id, String date, int service_id, String notes) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.date = date;
		this.service_id = service_id;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Finance [id=" + id + ", patient_id=" + patient_id + ", date=" + date + ", service_id=" + service_id
				+ ", notes=" + notes + "]";
	}
	
	
	
	
	

}
