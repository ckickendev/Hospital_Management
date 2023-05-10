package web.java.model;

public class Test {
	private int id;
	private int service_id;
	private String notes;
	public Test(int id, int service_id, String notes) {
		super();
		this.id = id;
		this.service_id = service_id;
		this.notes = notes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getService_id() {
		return service_id;
	}
	public void setService_id(int service_id) {
		this.service_id = service_id;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", service_id=" + service_id + ", notes=" + notes + "]";
	}
	
	
	

}
