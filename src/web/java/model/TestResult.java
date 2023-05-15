package web.java.model;

import web.java.dao.HospitalFeeDAO;
import web.java.dao.PatientDAO;

public class TestResult {
	private int id;
	private int patient_id;
	private int test_id;
	private String date;
	private String notes;
	private String result;

	public TestResult(int id, int patient_id, int test_id, String date, String notes, String result) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.test_id = test_id;
		this.result = result;
		this.date = date;
		this.notes = notes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return new PatientDAO().findPatient(Integer.toString(patient_id));
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public HospitalFee getHospitalFee() {
		return new HospitalFeeDAO().findHospitalFee(Integer.toString(test_id));
	}

	public int getTest_id() {
		return test_id;
	}

	public void setTest_id(int test_id) {
		this.test_id = test_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "TestResult [id=" + id + ", patient_id=" + patient_id + ", test_id=" + test_id + ", result=" + result
				+ ", date=" + date + ", notes=" + notes + "]";
	}

}
