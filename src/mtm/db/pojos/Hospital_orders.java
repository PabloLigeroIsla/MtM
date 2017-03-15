//¿?Need a new variable that is the combination of both
//¿?hascode and equals should have both integers

// @hasCode and equals
// @Implement the final serialVersionUID

package mtm.db.pojos;

import java.io.Serializable;

public class Hospital_orders implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Integer hospital_ID;
	private Integer order_ID;
	//Primary Key --> hospital_ID + order_ID
	//Foreign Key --> hospital_ID, order_ID
	
	//Gets and Sets
	
	public Integer getHospital_ID() 
	{
		return hospital_ID;
	}
	public void setHospital_ID(Integer hospital_ID) 
	{
		this.hospital_ID = hospital_ID;
	}
	
	public Integer getOrder_ID() {
		return order_ID;
	}
	public void setOrder_ID(Integer order_ID) 

	{
		this.order_ID = order_ID;
	}
	
	//Constructors
	public Hospital_orders()
	 {
		 super();
	 }
	 
	public Hospital_orders(Integer hospital_ID, Integer order_ID) 
	{
		super();
		this.hospital_ID = hospital_ID;
		this.order_ID = order_ID;
	}
	
	//Methods
	
	@Override
	public String toString() 
	{
		return "Hospital_orders [hospital_ID=" + hospital_ID + ", order_ID=" + order_ID + "]";
	}
	
	//hasCode and Equals
	
	
}
