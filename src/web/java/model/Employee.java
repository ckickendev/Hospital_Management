package web.java.model;

public class Employee {
	private int id;
    private String name;
    private int position;
    private String department;
    private String email;
    private String phone_number;
    private String username;
    private String password;
    private int role;
    public Employee() {
    	
    }
	public Employee(int id, String name, int position, String department, String email, String phone_number,
			String username, String password, int role) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.department = department;
		this.email = email;
		this.phone_number = phone_number;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		System.out.println("role"+ role);
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", position=" + position + ", department=" + department
				+ ", email=" + email + ", phone_number=" + phone_number + ", username=" + username + ", password="
				+ password + ", role=" + role + "]";
	}
    
   
}
