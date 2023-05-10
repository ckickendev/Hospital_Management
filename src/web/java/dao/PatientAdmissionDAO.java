package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.PatientAdmission;
import web.java.utils.ConnectDB;

public class PatientAdmissionDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<PatientAdmission> getPatientAdmissions() {
		List<PatientAdmission> patients = new ArrayList<PatientAdmission>();
		String query = "select * from PATIENT_ADMISSION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				patients.add(new PatientAdmission(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return patients;
	}

	public PatientAdmission findPatientAdmission(String id) {
		PatientAdmission pos = null;
		String query = "select * from PATIENT_ADMISSION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new PatientAdmission(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addPatientAdmission(PatientAdmission patient) {
		String query = "insert into PATIENT_ADMISSION(Admission_date,Patient_id, Symptoms, Initial_diagnosis, Notes) values ( ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, patient.getDate());
			ps.setInt(2, patient.getPatient_id());
			ps.setString(3, patient.getSymptoms());
			ps.setString(4, patient.getInitial_dianosis());
			ps.setString(5, patient.getNotes());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deletePatientAdmissionById(String id) {
		String query = "delete from PATIENT_ADMISSION where id = ?";
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

	public void updatePatient(PatientAdmission patinAdmission) {
		String query = "update PATIENT set name = ? , Date_of_birth = ?, Gender = ?, Address = ?, Phone_number = ?, Email = ?, Id_card_number = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, patinAdmission.getDate());
			ps.setInt(2, patinAdmission.getPatient_id());
			ps.setString(3, patinAdmission.getSymptoms());
			ps.setString(4, patinAdmission.getInitial_dianosis());
			ps.setString(5, patinAdmission.getNotes());
			ps.setInt(6, patinAdmission.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
