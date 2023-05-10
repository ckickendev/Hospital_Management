package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.HospitalFee;
import web.java.utils.ConnectDB;

public class HospitalFeeDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<HospitalFee> getHospitalFees() {
		List<HospitalFee> hospitalFees = new ArrayList<HospitalFee>();
		String query = "select * from HOSPITAL_FEE";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				hospitalFees.add(new HospitalFee(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hospitalFees;
	}

	public HospitalFee findHospitalFee(String id) {
		HospitalFee pos = null;
		String query = "select * from HOSPITAL_FEE where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new HospitalFee(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addHospitalFee(HospitalFee hospitalFee) {
		String query = "insert into HOSPITAL_FEE(Service_name, Price, Notes) values ( ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, hospitalFee.getServiceName());
			ps.setFloat(2, hospitalFee.getPrice());
			ps.setString(3, hospitalFee.getNote());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFee(String id) {
		String query = "delete from HOSPITAL_FEE where id = ?";
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

	public void updateHospitalFee(HospitalFee hospitalFee) {
		String query = "update HOSPITAL_FEE set Service_name = ?, Price = ?, Notes = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, hospitalFee.getServiceName());
			ps.setFloat(2, hospitalFee.getPrice());
			ps.setString(3, hospitalFee.getNote());
			ps.setInt(4, hospitalFee.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
