package web.java.model;

import web.java.dao.MedicaltionDAO;
import web.java.dao.PatientDAO;

public class DispenseMedication {
	private int id;
	private int medical_id;
	private String dispense_date;
	private int qtt;
	private String note;
	private String dispense_id;
	public DispenseMedication(int id, int medical_id, String dispense_date, int qtt, String note, String dispense_id) {
		super();
		this.id = id;
		this.dispense_id = dispense_id;
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
	public String getDispense_id() {
		return this.dispense_id;
	}
	public void setDispense_id(String dispense_id) {
		this.dispense_id = dispense_id;
	}
	public Medication getMedication() {
		return new MedicaltionDAO().findMedication(Integer.toString(this.medical_id));
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
		return "DispenseMedication [id=" + id + ", dispense_id=" + dispense_id + ", medical_id=" + medical_id
				+ ", dispense_date=" + dispense_date + ", qtt=" + qtt + ", note=" + note + "]";
	}
	
	
	
}
