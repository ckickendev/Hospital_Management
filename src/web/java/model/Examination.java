package web.java.model;

import java.sql.Date;

import web.java.dao.EmployeeDAO;
import web.java.dao.PatientDAO;

public class Examination {
	private int id;
	private int patientId;
	private int doctorId;
	private String date;
	private String symptoms;
	private String diagnosis;
	private String notes;
	public Examination(int id, int patientId, int doctorId, String date, String symptoms, String diagnosis,
			String notes) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.date = date;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient () {
		return new PatientDAO().findPatient(Integer.toString(patientId));
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public Employee getEmployee() {
		return new EmployeeDAO().getUserById(Integer.toString(doctorId));
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Examination [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", date=" + date
				+ ", symptoms=" + symptoms + ", diagnosis=" + diagnosis + ", notes=" + notes + "]";
	}
	
	
	
}
