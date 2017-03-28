package mtm.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable
{
	
	private static final long serialVersionUID = 1821406767918661646L;
	
	private int order_ID;
	private int total_amount_instruments;
	private Date order_Date;
	private Date delivery_Date;
	
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
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}


	public Order(int order_id,int total_amount_instruments, java.sql.Date order_Date, java.sql.Date delivery_Date)
	{
		super();
		this.order_ID = order_id;
		this.total_amount_instruments = total_amount_instruments;
		this.order_Date = order_Date;
		this.delivery_Date = delivery_Date;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int total_amount_instruments, java.sql.Date order_Date, java.sql.Date delivery_Date)
	{
		super();
		this.total_amount_instruments = total_amount_instruments;
		this.order_Date = order_Date;
		this.delivery_Date = delivery_Date;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int order_ID, int total_amount_instruments, java.sql.Date order_Date, java.sql.Date delivery_Date, List<Hospital> hospitalList, List<Instrument> instrumentList)
	{
		super();
		this.order_ID = order_ID;
		this.total_amount_instruments = total_amount_instruments;
		this.order_Date = order_Date;
		this.delivery_Date = delivery_Date;
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
		return "Order [order_ID=" + order_ID + ", total_amount_instruments=" + total_amount_instruments
				+ ", order_Date=" + order_Date + ", delivery_Date=" + delivery_Date + "]";
	}
	
	//hashCode and equals
	
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((delivery_Date == null) ? 0 : delivery_Date.hashCode());
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
		if (delivery_Date == null) {
			if (other.delivery_Date != null)
				return false;
		} else if (!delivery_Date.equals(other.delivery_Date))
			return false;
		return true;
	}
	
}
