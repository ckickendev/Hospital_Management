package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import web.java.model.Dispense;
import web.java.model.DispenseMedication;
import web.java.utils.ConnectDB;

public class DispensedMedicationDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<DispenseMedication> getDispensedMedications() {
		List<DispenseMedication> dis = new ArrayList<DispenseMedication>();
		String query = "select * from DISPENSED_MEDICATION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				dis.add(new DispenseMedication(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dis;
	}

	public List<Dispense> getDispenses() {
		List<Dispense> dis = new ArrayList<Dispense>();
		String query = "select * from DISPENSE";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("rs.getString" + rs.getString(1));
				List<DispenseMedication> dispenseMedications = findDispensedMedicationByDispense(rs.getString(1));
				if (dispenseMedications.size() > 0) {
					dis.add(new Dispense(rs.getString(1), rs.getInt(2), dispenseMedications));
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("All dispensed medication" + dis);

		return dis;
	}
	
	public Dispense findDispense(String id) {
		Dispense pos = null;
		String query = "select * from dispense where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Dispense(rs.getString(1), rs.getInt(2), findDispensedMedicationByDispense(rs.getString(1)));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}
	
//	public Dispense findDispenseByPatient(String id) {
//		Dispense pos = null;
//		String query = "select * from dispense where id = ?";
//		try {
//			conn = new ConnectDB().getDBConnection();
//			ps = conn.prepareStatement(query);
//			ps.setString(1, id);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				pos = new Dispense(rs.getString(1), rs.getInt(2), findDispensedMedicationByDispense(rs.getString(1)));
//			}
//			rs.close();
//			ps.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return pos;
//	}

	static String getAlphaNumericString(int n) {

		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(n);

		for (int i = 0; i < n; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}

	public void addNewEnpense(String patient_id, DispenseMedication dispenseMedication) {
		String query = "insert into dispense(id, patient_id) values (?, ?) ";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			String randomID = getAlphaNumericString(10);
			ps.setString(1, randomID);
			ps.setInt(2, Integer.parseInt(patient_id));
			ps.executeUpdate();
			dispenseMedication.setDispense_id(randomID);
			addDispensedMedication(dispenseMedication);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
				pos = new DispenseMedication(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5),
						rs.getString(6));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public List<DispenseMedication> findDispensedMedicationByDispense(String id) {
		List<DispenseMedication> dispenseMedications = new ArrayList<DispenseMedication>();
		String query = "select * from DISPENSED_MEDICATION where dispense_id = ?";
		try {
			Connection con1;
			PreparedStatement ps1;
			ResultSet rs1;
			con1 = new ConnectDB().getDBConnection();
			ps1 = con1.prepareStatement(query);
			ps1.setString(1, id);
			rs1 = ps1.executeQuery();
			while (rs1.next()) {
				dispenseMedications.add(new DispenseMedication(rs1.getInt(1), rs1.getInt(2), rs1.getString(3),
						rs1.getInt(4), rs1.getString(5), rs1.getString(6)));
			}
			ps1.close();
			rs1.close();
			con1.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (DispenseMedication dispenseMedication : dispenseMedications) {
			System.out.println("ten thuoc database : " + dispenseMedication.getMedication().getName());
		}
		return dispenseMedications;
	}

	public void addDispensedMedication(DispenseMedication dispenseMedication) {
		String query = "insert into DISPENSED_MEDICATION( Medication_id, Dispense_date, Quantity, Notes, dispense_id) values ( ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, dispenseMedication.getMedical_id());
			ps.setString(2, dispenseMedication.getDispense_date());
			ps.setInt(3, dispenseMedication.getQtt());
			ps.setString(4, dispenseMedication.getNote());
			ps.setString(5, dispenseMedication.getDispense_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteDispensedMedicationById(String id) {
		String query = "delete from DISPENSED_MEDICATION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateDisMedication(DispenseMedication dispenseMedication) {
		String query = "update DISPENSED_MEDICATION set Medication_id = ?, Dispense_date = ?, Quantity = ?, Notes = ?, dispense_id=? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, dispenseMedication.getMedical_id());
			ps.setString(2, dispenseMedication.getDispense_date());
			ps.setInt(3, dispenseMedication.getQtt());
			ps.setString(4, dispenseMedication.getNote());
			ps.setString(5, dispenseMedication.getDispense_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
