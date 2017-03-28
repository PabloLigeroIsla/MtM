package mtm.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable
{
	
	private static final long serialVersionUID = 1821406767918661646L;
	
	private int orderID;
	private int totalAmountInstruments;
	private Date orderDate;
	private Date deliveryDate;
	
	private List <Hospital> hospitalList;
	private List <Instrument> instrumentList;
	//Primary Key --> order_ID
	//Foreign Key --> hospitalList,instrumentList
	
	// Gets and Sets
	
	public List<Hospital> getHospitalList() 
	{
		return hospitalList;
	}
	public void setHospitalList(List<Hospital> hospitalList) 
	{
		this.hospitalList = hospitalList;
	}
	
	public List<Instrument> getInstrumentList() 
	{
		return instrumentList;
	}
	public void setInstrumentList(List<Instrument> instrumentList) 
	{
		this.instrumentList = instrumentList;
	}
	
	public Integer getOrderID()
	{
		return orderID;
	}
	public void setOrderID(Integer orderID)
	{
		this.orderID = orderID;
	}
	
	public Integer getTotalAmountInstruments()
	{
		return totalAmountInstruments;
	}
	public void setTotalAmountInstruments(Integer totalAmountInstruments) 
	{
		this.totalAmountInstruments = totalAmountInstruments;
	}
	
	public Date getOrderDate()
	{
		return orderDate;
	}
	public void setOrderDate(Date orderDate) 
	{
		this.orderDate = orderDate;
	}
	
	public Date getDeliveryDate() 
	{
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) 
	{
		this.deliveryDate = deliveryDate;
	}
		
	//Constructors
	
	public Order()
	{
		super();
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}


	public Order(int orderID,int totalAmountInstruments, java.sql.Date orderDate, java.sql.Date deliveryDate)
	{
		super();
		this.orderID = orderID;
		this.totalAmountInstruments = totalAmountInstruments;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int totalAmountInstruments, java.sql.Date orderDate, java.sql.Date deliveryDate)
	{
		super();
		this.totalAmountInstruments = totalAmountInstruments;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int orderID, int totalAmountInstruments, java.sql.Date orderDate, java.sql.Date deliveryDate, List<Hospital> hospitalList, List<Instrument> instrumentList)
	{
		super();
		this.orderID = orderID;
		this.totalAmountInstruments = totalAmountInstruments;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.hospitalList = hospitalList;
		this.instrumentList = instrumentList;
	}
	//Methods
	
	public void addHospitalList(Hospital hospital)
	{
		if(hospitalList.contains(hospital))
		{
			this.hospitalList.add(hospital);
		}
	}
	public void addInstrumentList(Instrument instrument)
	{
		if(instrumentList.contains(instrument))
		{
			this.instrumentList.add(instrument);
		}
	}
	
	public void removeHospitalList(Hospital hospital)
	{
		if(!hospitalList.contains(hospital))
		{
			this.hospitalList.remove(hospital);
		}
	}
	public void removeInstrumentList(Instrument instrument)
	{
		if(!instrumentList.contains(instrument))
		{
			this.instrumentList.remove(instrument);
		}
	}
	
	@Override
	public String toString() 
	{
		return "Order [orderID=" + orderID + ", totalAmountInstruments=" + totalAmountInstruments
				+ ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + "]";
	}
	
	//hashCode and equals
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
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
		Order other = (Order) obj;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
			return false;
		return true;
	}
	
}
