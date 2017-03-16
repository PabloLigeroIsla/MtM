package mtm.db.pojos;

import java.io.Serializable;
import java.util.List;

public class Company implements Serializable {

	private static final long serialVersionUID = 5399354394170770491L;

	
	private String resource; //PRIMARY KEY
	private String location;
	private String company_name;
	
	private List<Materials>  materialList;
	
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
	public List<Materials> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(List<Materials> materialList) {
		this.materialList = materialList;
	}
	
	
	public Company(){

	}
	
	public Company(String resource, String location, String company_name, List<Materials> materialList){
		this.resource= resource;
		this.location=location;
		this.company_name=company_name;
		this.materialList=materialList;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Company [resource=" + resource + ", location=" + location + ", company_name=" + company_name
				+ ", materialList=" + materialList + "]";
	}
	
	
	
}
