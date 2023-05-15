package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.Fee;
import web.java.utils.ConnectDB;

public class FeeDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<Fee> getFees() {
		List<Fee> Fees = new ArrayList<Fee>();
		String query = "SELECT * FROM FEE right join PATIENT on FEE.patient_id = PATIENT.id";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				Fees.add(new Fee(rs.getInt(6), rs.getInt(6), rs.getFloat(4), rs.getString(3), rs.getInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Fees;
	}

	public Fee findFee(String id) {
		Fee pos = null;
		String query = "SELECT * FROM FEE right join PATIENT on FEE.patient_id = PATIENT.id where PATIENT.id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new Fee(rs.getInt(6), rs.getInt(6), rs.getFloat(4), rs.getString(3), rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addFee(Fee Fee) {
		String query = "insert into FEE(patient_id, fee_date, price_inpatient, status) values ( ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Fee.getPatient_id());
			ps.setString(2, Fee.getDate());
			ps.setFloat(3, Fee.getPriceInpatient());
			ps.setInt(4, Fee.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFee(String id) {
		String query = "delete from FEE where id = ?";
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

	public void updateFee(Fee Fee) {
		String query = "update MEDICAL_Fee set patient_id = ?, fee_date = ?, price_inpatient = ?, status = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Fee.getPatient_id());
			ps.setString(2, Fee.getDate());
			ps.setFloat(3, Fee.getPriceInpatient());
			ps.setInt(4, Fee.getStatus());
			ps.setInt(5, Fee.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public float findInpatientFeeByPatientId(String id) {
		String query = "select * from FEE where patient_id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getFloat(4);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public float getMedicineFeeByPatientID(int id) {
		float total = 0;
		String query = "select MEDICATION.Price, DISPENSED_MEDICATION.Quantity from DISPENSED_MEDICATION inner join MEDICATION on DISPENSED_MEDICATION.Medication_id = MEDICATION.Id where dispense_id in (select id from dispense where patient_id = ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				total += rs.getFloat(1) * rs.getInt(2);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
	
	public float getTestFeeByPatientID(int id) {
		float total = 0;
		String query = "select HOSPITAL_FEE.Price from HOSPITAL_FEE inner join TEST_RESULT on HOSPITAL_FEE.Id = TEST_RESULT.service_id where TEST_RESULT.patient_id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				total += rs.getFloat(1);
			}
			ps.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}
}
