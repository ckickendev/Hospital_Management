package web.java.model;

import java.awt.Container;

import web.java.dao.FeeDAO;
import web.java.dao.PatientDAO;

public class Fee {
	private int id;
	private int patient_id;
	private float priceInpatient;
	private String date;
	private int status;

	public Fee(int id, int patient_id, float priceInpatient, String date, int status) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.priceInpatient = priceInpatient;
		this.date = date;
		this.status = status;
	}

	public float getFeeOfUser() {
		float fee = 0;
		FeeDAO feeDAO = new FeeDAO();
		fee += priceInpatient + feeDAO.getMedicineFeeByPatientID(patient_id) + feeDAO.getTestFeeByPatientID(patient_id);
		return fee;
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

	public float getPriceInpatient() {
		return priceInpatient;
	}

	public void setPriceInpatient(float priceInpatient) {
		this.priceInpatient = priceInpatient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", patient_id=" + patient_id + ", priceInpatient=" + priceInpatient + ", date=" + date
				+ ", status=" + status + "]";
	}

}
