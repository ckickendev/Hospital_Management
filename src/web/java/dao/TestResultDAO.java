package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import web.java.model.TestResult;
import web.java.utils.ConnectDB;

public class TestResultDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public List<TestResult> getTestResults() {
		List<TestResult> TestResults = new ArrayList<TestResult>();
		String query = "select * from TEST_RESULT";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				TestResults.add(new TestResult(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return TestResults;
	}

	public TestResult findTestResult(String id) {
		TestResult pos = null;
		String query = "select * from TEST_RESULT where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				pos = new TestResult(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pos;
	}

	public void addTestResult(TestResult testResult) {
		String query = "insert into TEST_RESULT(patient_id,service_id, test_date,notes, result) values ( ?, ?, ?, ?, ?)";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, testResult.getPatient_id());
			ps.setInt(2, testResult.getTest_id());
			ps.setString(3, testResult.getDate());
			ps.setString(4, testResult.getNotes());
			ps.setString(5, testResult.getResult());
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteTestResultById(String id) {
		String query = "delete from TEST_RESULT where id = ?";
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

	public void updateTestResult(TestResult testResult) {
		String query = "update TEST_RESULT set patient_id = ?,service_id = ?, test_date = ?,notes = ?, result = ? where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, testResult.getPatient_id());
			ps.setInt(2, testResult.getTest_id());
			ps.setString(3, testResult.getDate());
			ps.setString(4, testResult.getNotes());
			ps.setString(5, testResult.getResult());
			ps.setInt(6, testResult.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
