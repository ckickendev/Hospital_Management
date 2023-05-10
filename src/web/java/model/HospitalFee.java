package web.java.model;

public class HospitalFee {
	private int id;
	private String serviceName;
	private Float price;
	private String note;
	public HospitalFee(int id, String serviceName, Float price, String note) {
		super();
		this.id = id;
		this.serviceName = serviceName;
		this.price = price;
		this.note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "HospitalFee [id=" + id + ", serviceName=" + serviceName + ", price=" + price + ", note=" + note + "]";
	}
	
	

}
