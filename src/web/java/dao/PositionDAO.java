package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Medication;
import web.java.model.Position;
import web.java.utils.ConnectDB;

public class PositionDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Position> getAllPosition() {
		List<Position> pos = new ArrayList<Position>();
		String query = "select * from POSITION";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos.add(new Position(rs.getInt(1), rs.getString(2)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public Position findPosition(String id) {
		Position pos = null;
		String query = "select * from POSITION where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Position(rs.getInt(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

//	public void addMedication(Medication medication) {
//		String query = "insert into MEDICATION( Medication_name, Dosage, Notes,Price) values ( ?, ?, ?, ?)";
//		try {
//			conn = new ConnectDB().getDBConnection();
//			ps = conn.prepareStatement(query);
//			ps.setString(1, medication.getName());
//			ps.setString(2, medication.getDosage());
//			ps.setString(3, medication.getNotes());
//			ps.setFloat(4, medication.getPrice());
//			ps.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void deleteMedicationById(String id) {
//		String query = "delete from MEDICATION where id = ?";
//		try {
//			System.out.print(Integer.parseInt(id));
//			conn = new ConnectDB().getDBConnection();
//			ps = conn.prepareStatement(query);
//			ps.setInt(1, Integer.parseInt(id));
//			ps.executeUpdate();
//			ps.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void updateMedicationByID(Medication medication) {
//		String query = "update MEDICATION set Medication_name = ?, Dosage=?, Notes=?, Price=? where id = ?";
//		try {
//			conn = new ConnectDB().getDBConnection();
//			ps = conn.prepareStatement(query);
//			ps.setString(1, medication.getName());
//			ps.setString(2, medication.getDosage());
//			ps.setString(3, medication.getNotes());
//			ps.setFloat(4, medication.getPrice());
//			ps.setInt(5, medication.getId());
//			ps.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
