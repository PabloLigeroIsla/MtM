package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Hospital implements Serializable
{

	private static final long serialVersionUID = 1367190536405193806L;
	
	private Integer hospital_ID; 
	private String name;
	private String location;
	private String medical_specialization;
	
	private List<Order> orderList;
	//Primary Key --> hospital_ID
	//Foreign Key --> No
	
	//Gets and Sets
	
	public Integer getHospital_ID() 
	{
		return hospital_ID;
	}
	public void setHospital_ID(Integer hospital_ID) {
		this.hospital_ID = hospital_ID;
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}

	public String getLocation()
	{
		return location;
	}
	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getMedical_specialization()
	{
		return medical_specialization;
	}
	public void setMedical_specialization(String medical_specialization)
	{
		this.medical_specialization = medical_specialization;
	}
	
	public List<Order> getOrderList()
	{
		return orderList;
	}
	public void setOrderList(List<Order> orderList)
	{
		this.orderList = orderList;
	}
	
	// Constructors
	
	
	public Hospital()
	{
		super();
		this.orderList = new ArrayList<Order>();
	}
	
	public Hospital(Integer hospital_ID, String name, String location, String medical_specialization) 
	{
		super();
		this.hospital_ID = hospital_ID;
		this.name = name;
		this.location = location;
		this.medical_specialization = medical_specialization;
	}

	
	// Methods
	
	@Override
	public String toString() 
	{
		return "Hospital [hospital_ID=" + hospital_ID + ", name=" + name + ", location=" + location
				+ ", medical_specialization=" + medical_specialization + "]";
	}
	
	//hashCode and  equals
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospital_ID == null) ? 0 : hospital_ID.hashCode());
		return result;
	}

	
	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospital other = (Hospital) obj;
		if (hospital_ID == null) {
			if (other.hospital_ID != null)
				return false;
		} else if (!hospital_ID.equals(other.hospital_ID))
			return false;
		return true;
	}
	
}
