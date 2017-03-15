package mtm.db.pojos;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable
{

	private static final long serialVersionUID = -9031849638857899772L;

	private Integer order_ID;
	private Integer total_amount_instruments;
	private Date order_Date;
	private Date delivery_Date;
	//Primary Key --> order_ID
	//Foreign Key --> NO
	
	// Gets and Sets
	public Integer getOrder_ID()
	{
		return order_ID;
	}
	public void setOrder_ID(Integer order_ID)
	{
		this.order_ID = order_ID;
	}
	
	public Integer getTotal_amount_instruments()
	{
		return total_amount_instruments;
	}
	public void setTotal_amount_instruments(Integer total_amount_instruments) 
	{
		this.total_amount_instruments = total_amount_instruments;
	}
	
	public Date getOrder_Date()
	{
		return order_Date;
	}
	public void setOrder_Date(Date order_Date) 
	{
		this.order_Date = order_Date;
	}
	
	public Date getDelivery_Date() 
	{
		return delivery_Date;
	}
	public void setDelivery_Date(Date delivery_Date) 
	{
		this.delivery_Date = delivery_Date;
	}
		
	//Constructors
	
	public Order()
	{
		super();
	}
	
	public Order(Integer order_ID, Integer total_amount_instruments, Date order_Date, Date delivery_Date) {
		super();
		this.order_ID = order_ID;
		this.total_amount_instruments = total_amount_instruments;
		this.order_Date = order_Date;
		this.delivery_Date = delivery_Date;
	}
	
	//Methods
	
	//hashCode and Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delivery_Date == null) ? 0 : delivery_Date.hashCode());
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
		Order other = (Order) obj;
		if (delivery_Date == null) {
			if (other.delivery_Date != null)
				return false;
		} else if (!delivery_Date.equals(other.delivery_Date))
			return false;
		return true;
	}
	
}
