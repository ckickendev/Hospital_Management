package web.java.model;

import java.util.ArrayList;
import java.util.List;

import web.java.dao.PatientDAO;

public class Dispense {
	private String id;
	private int patient_id;
	private List<DispenseMedication> dispense_medications;

	public Dispense(String id, int patient_id, List<DispenseMedication> dispense_medications) {
		super();
		this.id = id;
		this.patient_id = patient_id;
		this.dispense_medications = dispense_medications;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Patient getPatient() {
		System.out.println(new PatientDAO().findPatient(Integer.toString(this.patient_id)));
		return new PatientDAO().findPatient(Integer.toString(this.patient_id));
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public List<String> getDispense_medication() {
		List<String> hList = new ArrayList<>();
		for (DispenseMedication dispenseMedication : dispense_medications) {
			System.out.println("dispense_medications" + dispenseMedication.getMedication().getName());
			hList.add(dispenseMedication.getMedication().getName() + " x " + dispenseMedication.getQtt());
		}
		return hList;
	}

//	public List<DispenseMedication> getDispense_medication() {
//		System.out.println("List duoc tra ve trong dispense");
//		for (DispenseMedication dispenseMedication : dispense_medications) {
//			System.out.println(dispenseMedication);
//		}
//		return this.dispense_medications;
//	}
	public List<DispenseMedication> getListDispense_medications() {
		return this.dispense_medications;
	}

	public float getTotal() {
		float total = 0;
		for (DispenseMedication dispenseMedication : dispense_medications) {
			total += dispenseMedication.getQtt() * dispenseMedication.getMedication().getPrice();
			;
		}
		return total;
	}

	public void setDispense_medication(List<DispenseMedication> dispense_medications) {
		this.dispense_medications = dispense_medications;
	}

	@Override
	public String toString() {
		return "Dispense [id=" + id + ", patient_id=" + patient_id + ", dispense_medication="
				+ dispense_medications.size();
	}

}
