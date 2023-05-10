package web.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import web.java.model.Employee;
import web.java.utils.ConnectDB;

public class EmployeeDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public String getEncodedString(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}

	public List<Employee> getAllUser() {
		List<Employee> users = new ArrayList<Employee>();
		String query = "select * from EMPLOYEE";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public List<Employee> getAllDoctor() {
		List<Employee> users = new ArrayList<Employee>();
		String query = "select * from EMPLOYEE where POSITION = 2";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public List<Employee> getAllUserInPage(int page) {
		List<Employee> users = new ArrayList<Employee>();
		int start = (page - 1) * 10;
		String query = "select * from EMPLOYEE limit ?, ? ";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, start);
			ps.setInt(2, 10);
			rs = ps.executeQuery();
			while (rs.next()) {
				users.add(new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public int countUser() {
		String query = "select count(id) from EMPLOYEE";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 1;
	}

	public void signUp(String username, String password, String email, String fullname) {
		String query = "insert into EMPLOYEE(username, password, email, Name) values (?, ?, ?, ?)";

		String passEncode = getEncodedString(password);
		System.out.print("New account: " + passEncode);
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, passEncode);
			ps.setString(3, email);
			ps.setString(4, fullname);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteUserById(String id) {
		String query = "delete from EMPLOYEE where id = ?";
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

	public Employee getUserById(String id) {
		Employee user = new Employee();
		String query = "select * from EMPLOYEE where id = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public Employee getUserByUsername(String username) {
		Employee user = new Employee();
		String query = "select * from EMPLOYEE where username = ?";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Employee(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public void updateUserById(Employee employee) {
		String query = "UPDATE EMPLOYEE SET Name = ?, Position = ?, Department = ?, Email = ?, Phone_number = ?, role=? WHERE Id = ?;";
		try {
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setInt(2, employee.getPosition());
			ps.setString(3, employee.getDepartment());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPhone_number());
			ps.setInt(6, employee.getRole());
			ps.setInt(7, employee.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean login(String username, String password) {
		String query = "select * from Employee where username = ? and password = ?";
		try {
			System.out.print(password);
			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			System.out.print(ps);
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void editUserNotPass(String id, String email, String fullname, String phone, String avatar) {
		String query = "update user set email=?, fullname=?, phone = ?, avatar=? where id = ?";
		try {

			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, fullname);
			ps.setString(3, phone);
			ps.setString(4, avatar);
			ps.setString(5, id);
			System.out.print(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void editUserHavePass(String id, String password, String email, String fullname, String phone,
			String avatar) {
		String query = "update user set password = ?, email=?, fullname=?, phone = ?, avatar=? where id = ?";
		try {
			String newPass = getEncodedString(password);

			conn = new ConnectDB().getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, newPass);
			ps.setString(2, email);
			ps.setString(3, fullname);
			ps.setString(4, phone);
			ps.setString(5, avatar);
			ps.setString(6, id);
			System.out.print(ps);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
