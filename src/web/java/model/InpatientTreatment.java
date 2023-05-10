package web.java.model;

public class InpatientTreatment {
	private int id;
	private int doctor_id;
	private int inpatient_id;
	private String date;
	private String symptoms;
	private String diagnotis;
	private String notes;
	public InpatientTreatment(int id, int doctor_id, int inpatient_id, String date, String symptoms, String diagnotis,
			String notes) {
		super();
		this.id = id;
		this.doctor_id = doctor_id;
		this.inpatient_id = inpatient_id;
		this.date = date;
		this.symptoms = symptoms;
		this.diagnotis = diagnotis;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public int getInpatient_id() {
		return inpatient_id;
	}
	public void setInpatient_id(int inpatient_id) {
		this.inpatient_id = inpatient_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnotis() {
		return diagnotis;
	}
	public void setDiagnotis(String diagnotis) {
		this.diagnotis = diagnotis;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "InpatientTreatment [id=" + id + ", doctor_id=" + doctor_id + ", inpatient_id=" + inpatient_id
				+ ", date=" + date + ", symptoms=" + symptoms + ", diagnotis=" + diagnotis + ", notes=" + notes + "]";
	}
	
	
}
