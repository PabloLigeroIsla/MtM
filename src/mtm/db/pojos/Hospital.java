package mtm.db.pojos;

import java.io.Serializable;

public class Hospital implements Serializable
{

	private static final long serialVersionUID = -8534133295501375045L;
	
	private Integer hospital_ID; 
	private String name;
	private String location;
	private String medical_specialization;
	//Primary Key --> hospital_ID
	//Foreign Key --> NO
	
	//Gets and Sets
	public void setHospital_ID(int hosp_id)
	{
		this.hospital_ID = hosp_id;
	}
	public void setName(String name2)
	{
		this.name = name2;
	}
	public void setLocation(String location2)
	{
		this.location = location2;
	}
	public void setMedical_specialization(String med_esp)
	{
		this.medical_specialization = med_esp;
	}
	
	public int getHospital()
	{
		return this.hospital_ID;
	}
	public String getName()
	{
		return this.name;
	}
	public String getLocation()
	{
		return this.location;
	}
	public String getMedical_specialization()
	{
		return this.medical_specialization;
	}
	
	@Override
	public String toString()
	{
		return "Hospital [ hospital_ID = " + hospital_ID +", name =" + name + ", location = "+ 
				location + ", medical_specialization = "+ medical_specialization + " ]";
	}
	
	// Constructors
	
	public Hospital()
	{
		super();
	}
	
	public Hospital(Integer hospital_ID, String name, String location, String medical_specialization) {
		super();
		this.hospital_ID = hospital_ID;
		this.name = name;
		this.location = location;
		this.medical_specialization = medical_specialization;
	}

	
	// Methods
	
	//hashCode and  Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hospital_ID == null) ? 0 : hospital_ID.hashCode());
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
		if (hospital_ID == null) {
			if (other.hospital_ID != null)
				return false;
		} else if (!hospital_ID.equals(other.hospital_ID))
			return false;
		return true;
	}
	
}
