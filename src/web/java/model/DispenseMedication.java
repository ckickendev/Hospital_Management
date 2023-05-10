package web.java.model;

public class DispenseMedication {
	private int id;
	private int patient_id;
	private int medical_id;
	private String dispense_date;
	private int qtt;
	private String note;
	public DispenseMedication(int id, int patient_id, int medical_id, String dispense_date, int qtt, String note) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.medical_id = medical_id;
		this.dispense_date = dispense_date;
		this.qtt = qtt;
		this.note = note;
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
	public int getMedical_id() {
		return medical_id;
	}
	public void setMedical_id(int medical_id) {
		this.medical_id = medical_id;
	}
	public String getDispense_date() {
		return dispense_date;
	}
	public void setDispense_date(String dispense_date) {
		this.dispense_date = dispense_date;
	}
	public int getQtt() {
		return qtt;
	}
	public void setQtt(int qtt) {
		this.qtt = qtt;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "DispenseMedication [id=" + id + ", patient_id=" + patient_id + ", medical_id=" + medical_id
				+ ", dispense_date=" + dispense_date + ", qtt=" + qtt + ", note=" + note + "]";
	}
	
	
	
}
