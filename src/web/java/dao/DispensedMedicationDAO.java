package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.DispenseMedication;
import web.java.utils.ConnectDB;

public class DispensedMedicationDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<DispenseMedication> getDispensedMedications() {
		List<DispenseMedication> patients = new ArrayList<DispenseMedication>();
		String query = "select * from DISPENSED_MEDICATION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				patients.add(new DispenseMedication(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	public DispenseMedication findDispensedMedication(String id) {
		DispenseMedication pos = null;
		String query = "select * from DISPENSED_MEDICATION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new DispenseMedication(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getInt(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addDispensedMedication(DispenseMedication dispenseMedication) {
		String query = "insert into DISPENSED_MEDICATION(Patient_id, Medication_id, Dispense_date, Quantity, Notes) values ( ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, dispenseMedication.getPatient_id());
			ps.setInt(2, dispenseMedication.getMedical_id());
			ps.setString(3, dispenseMedication.getDispense_date());
			ps.setInt(4, dispenseMedication.getQtt());
			ps.setString(5, dispenseMedication.getNote());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDispensedMedicationById(String id) {
		String query = "delete from DISPENSED_MEDICATION where id = ?";
		try {
			System.out.print(Integer.parseInt(id));
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updatePatient(DispenseMedication dispenseMedication) {
		String query = "update DISPENSED_MEDICATION set Patient_id = ?, Medication_id = ?, Dispense_date = ?, Quantity = ?, Notes = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, dispenseMedication.getPatient_id());
			ps.setInt(2, dispenseMedication.getMedical_id());
			ps.setString(3, dispenseMedication.getDispense_date());
			ps.setInt(4, dispenseMedication.getQtt());
			ps.setString(5, dispenseMedication.getNote());
			ps.setInt(6, dispenseMedication.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
