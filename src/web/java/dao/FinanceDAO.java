package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Finance;
import web.java.utils.ConnectDB;

public class FinanceDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Finance> getFinances() {
		List<Finance> finances = new ArrayList<Finance>();
		String query = "select * from FINANCE";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				finances.add(new Finance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return finances;
	}

	public Finance findFinance(String id) {
		Finance pos = null;
		String query = "select * from FINANCE where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Finance(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4),
						rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addFinance(Finance finance) {
		String query = "insert into FINANCE(Patient_id, Date_of_service,service_id,Notes) values ( ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, finance.getPatient_id());
			ps.setString(2, finance.getDate());
			ps.setInt(3, finance.getService_id());
			ps.setString(4, finance.getNotes());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFinance(String id) {
		String query = "delete from FINANCE where id = ?";
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

	public void updatePatient(Finance finance) {
		String query = "update PATIENT set Patient_id = ?, Date_of_service = ?,service_id = ?,Notes = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, finance.getPatient_id());
			ps.setString(2, finance.getDate());
			ps.setInt(3, finance.getService_id());
			ps.setString(4, finance.getNotes());
			ps.setInt(5, finance.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
