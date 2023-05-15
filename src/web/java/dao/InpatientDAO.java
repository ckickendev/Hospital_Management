package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Inpatient;
import web.java.utils.ConnectDB;

public class InpatientDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Inpatient> getInpatients() {
		List<Inpatient> inpatient = new ArrayList<Inpatient>();
		String query = "select * from INPATIENT";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				inpatient.add(new Inpatient(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inpatient;
	}

	public Inpatient findInpatient(String id) {
		Inpatient pos = null;
		String query = "select * from INPATIENT where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Inpatient(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addInpatient(Inpatient inpatient) {
		String query = "insert into INPATIENT(Patient_id, Admission_date, Discharge_date, Room, Notes) values ( ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, inpatient.getPatient_id());
			ps.setString(2, inpatient.getAdmission_date());
			ps.setString(3, inpatient.getDischarge_date());
			ps.setString(4, inpatient.getRoom());
			ps.setString(5, inpatient.getNotes());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteInpatient(String id) {
		String query = "delete from INPATIENT where id = ?";
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

	public void updateInpatient(Inpatient inpatient) {
		String query = "update INPATIENT set Patient_id = ?, Admission_date = ? , Discharge_date = ?, Room = ?, Notes = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, inpatient.getPatient_id());
			ps.setString(2, inpatient.getAdmission_date());
			ps.setString(3, inpatient.getDischarge_date());
			ps.setString(4, inpatient.getRoom());
			ps.setString(5, inpatient.getNotes());
			ps.setInt(6, inpatient.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
