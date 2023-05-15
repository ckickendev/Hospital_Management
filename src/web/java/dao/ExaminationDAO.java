package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Examination;
import web.java.model.Medication;
import web.java.utils.ConnectDB;

public class ExaminationDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Examination> getExaminations() {
		List<Examination> examinations = new ArrayList<Examination>();
		String query = "select * from MEDICAL_EXAMINATION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				examinations.add(new Examination(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examinations;
	}

	public Examination findExamination(String id) {
		Examination pos = null;
		String query = "select * from MEDICAL_EXAMINATION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Examination(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addExam(Examination examination) {
		String query = "insert into MEDICAL_EXAMINATION(Patient_id, Doctor_id, Examination_date, Symptoms, Diagnosis, Notes) values ( ?, ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, examination.getPatientId());
			ps.setInt(2, examination.getDoctorId());
			ps.setString(3, examination.getDate());
			ps.setString(4, examination.getSymptoms());
			ps.setString(5, examination.getDiagnosis());
			ps.setString(6, examination.getNotes());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteExam(String id) {
		String query = "delete from MEDICAL_EXAMINATION where id = ?";
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

	public void updateExam(Examination examination) {
		String query = "update MEDICAL_EXAMINATION set Patient_id = ?, Doctor_id = ?, Examination_date = ?, Symptoms = ?, Diagnosis = ?, Notes = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, examination.getPatientId());
			ps.setInt(2, examination.getDoctorId());
			ps.setString(3, examination.getDate());
			ps.setString(4, examination.getSymptoms());
			ps.setString(5, examination.getDiagnosis());
			ps.setString(6, examination.getNotes());
			ps.setInt(7,examination.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
