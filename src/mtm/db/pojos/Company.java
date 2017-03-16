package mtm.db.pojos;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = 5399354394170770491L;

	
	private String resource;
	private String location;
	private String company_name;
	
	private List<Order>  materialList;
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	
}
