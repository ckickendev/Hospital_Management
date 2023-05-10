package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Medication;
import web.java.utils.ConnectDB;

public class MedicaltionDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Medication> getAllMedication() {
		List<Medication> medis = new ArrayList<Medication>();
		String query = "select * from MEDICATION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				medis.add(new Medication(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getFloat(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medis;
	}

	public Medication findMedication(String id) {
		Medication medication = null;
		String query = "select * from MEDICATION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				medication = new Medication(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getFloat(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medication;
	}

	public void addMedication(Medication medication) {
		String query = "insert into MEDICATION( Medication_name, Dosage, Notes,Price) values ( ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, medication.getName());
			ps.setString(2, medication.getDosage());
			ps.setString(3, medication.getNotes());
			ps.setFloat(4, medication.getPrice());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteMedicationById(String id) {
		String query = "delete from MEDICATION where id = ?";
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

	public void updateMedicationByID(Medication medication) {
		String query = "update MEDICATION set Medication_name = ?, Dosage=?, Notes=?, Price=? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, medication.getName());
			ps.setString(2, medication.getDosage());
			ps.setString(3, medication.getNotes());
			ps.setFloat(4, medication.getPrice());
			ps.setInt(5, medication.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
