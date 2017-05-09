package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class Hospital implements Serializable
{
	
	private static final long serialVersionUID = 3198781709673295324L;

	@Id 
	@GeneratedValue(generator="hospital")
	@TableGenerator(name="hospital", table="sqlite_sequence",
	    pkColumnName="hospitalID", valueColumnName="seq", pkColumnValue="hospital")
	
	private int hospitalID; 
	private String name;
	private String location;
	private String medicalSpecialization;
	@ManyToMany(mappedBy = "hospital_orders")
	private List<Order> orderList;
	//Primary Key --> hospitalID
	//Foreign Key --> orderList
	
	//Gets and Sets
	
	public int getHospitalID() 
	{
		return hospitalID;
	}
	public void setHospitalID(Integer hospitalID) {
		this.hospitalID = hospitalID;
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

	public String getMedicalSpecialization()
	{
		return medicalSpecialization;
	}
	public void setMedicalSpecialization(String medicalSpecialization)
	{
		this.medicalSpecialization = medicalSpecialization;
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

	public Hospital(String name, String location, String medical_specialization)
	{
		super();
		this.name = name;
		this.location = location;
		this.medicalSpecialization = medical_specialization;
		this.orderList = new ArrayList<Order>();
	}
	public Hospital(Integer hospital_ID, String name, String location, String medicalSpecialization)
	{
		super();
		this.hospitalID = hospital_ID;
		this.name = name;
		this.location = location;
		this.medicalSpecialization = medicalSpecialization;
		this.orderList = new ArrayList<Order>();
	}
	public Hospital(Integer hospital_ID, String name, String location, String medicalSpecialization, List<Order> orderList)
	{
		super();
		this.hospitalID = hospital_ID;
		this.name = name;
		this.location = location;
		this.medicalSpecialization = medicalSpecialization;
		this.orderList = orderList;
	}
	// Methods
	
	public void addOrder (Order order)
	{
		if(!orderList.contains(order))
		{
			this.orderList.add(order);
		}
	}
	
	public void removeOrder (Order order)
	{
		if(orderList.contains(order))
		{
			this.orderList.remove(order);
		}
	}
	
	@Override
	public String toString() 
	{
		return "Hospital [hospitalID=" + hospitalID + ", name=" + name + ", location=" + location
				+ ", medicalSpecialization=" + medicalSpecialization + "]";
	}
	
	
	//hashCode and  equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hospitalID;
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
		Hospital other = (Hospital) obj;
		if (hospitalID != other.hospitalID)
			return false;
		return true;
	}
	
	
}
