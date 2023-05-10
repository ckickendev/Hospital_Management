package web.java.model;

public class BloodBank {
	private int id;
	private String bbname;
	private String address;
	private String phoneNumber;
	private String remain;
	public BloodBank(int id,String bbname, String address, String phoneNumber, String remain) {
		super();
		this.id = id;
		this.bbname = bbname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.remain = remain;
	}
	public String getBbname() {
		return bbname;
	}
	public void setBbname(String bbname) {
		this.bbname = bbname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRemain() {
		return remain;
	}
	public void setRemain(String remain) {
		this.remain = remain;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "BloodBank [bbname=" + bbname + ", address=" + address + ", phoneNumber=" + phoneNumber + ", email="
				+ remain + "]";
	}
	
	
}
