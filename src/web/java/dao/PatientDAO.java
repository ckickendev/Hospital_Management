package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Medication;
import web.java.model.Patient;
import web.java.utils.ConnectDB;

public class PatientDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Patient> getPatients() {
		List<Patient> patients = new ArrayList<Patient>();
		String query = "select * from PATIENT";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				patients.add(new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	public Patient findPatient(String id) {
		Patient pos = null;
		String query = "select * from Patient where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Patient(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addPatient(Patient patient) {
		String query = "insert into Patient(name, Date_of_birth, Gender, Address, Phone_number, Email, Id_card_number) values ( ?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getDob());
			ps.setString(3, patient.getGender());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getPhoneNumber());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getIdCard());
			
			
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePatientById(String id) {
		String query = "delete from PATIENT where id = ?";
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

	public void updatePatient(Patient patient) {
		String query = "update PATIENT set name = ? , Date_of_birth = ?, Gender = ?, Address = ?, Phone_number = ?, Email = ?, Id_card_number = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, patient.getName());
			ps.setString(2, patient.getDob());
			ps.setString(3, patient.getGender());
			ps.setString(4, patient.getAddress());
			ps.setString(5, patient.getPhoneNumber());
			ps.setString(6, patient.getEmail());
			ps.setString(7, patient.getIdCard());
			ps.setInt(8, patient.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
