package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.BloodBank;
import web.java.utils.ConnectDB;

public class BloodBankDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<BloodBank> getBloodBanks() {
		List<BloodBank> bloodBanks = new ArrayList<BloodBank>();
		String query = "select * from BLOOD_BANK";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				bloodBanks.add(new BloodBank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bloodBanks;
	}

	public BloodBank findBloodBank(String id) {
		BloodBank pos = null;
		String query = "select * from BLOOD_BANK where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new BloodBank(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addBloodBank(BloodBank BloodBank) {
		String query = "insert into BLOOD_BANK(Blood_bank_name, Address, Phone_number, Remain) values ( ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, BloodBank.getBbname());
			ps.setString(2, BloodBank.getAddress());
			ps.setString(3, BloodBank.getPhoneNumber());
			ps.setString(4, BloodBank.getRemain());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteBloodBankById(String id) {
		String query = "delete from BLOOD_BANK where id = ?";
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

	public void updateBloodBank(BloodBank bloodBank) {
		String query = "update BLOOD_BANK set Blood_bank_name = ?, Address = ?, Phone_number = ?, Remain = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, bloodBank.getBbname());
			ps.setString(2, bloodBank.getAddress());
			ps.setString(3, bloodBank.getPhoneNumber());
			ps.setString(4, bloodBank.getRemain());
			ps.setInt(5, bloodBank.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
