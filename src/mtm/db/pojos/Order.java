package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import java.time.LocalDate;


@Entity
@Table(name = "orders")
public class Order implements Serializable
{
	
	private static final long serialVersionUID = 1821406767918661646L;
	@Id 
	@GeneratedValue(generator="orders")
	@TableGenerator(name="orders", table="sqlite_sequence",
	    pkColumnName="order_ID", valueColumnName="seq", pkColumnValue="orders")
	
	private int orderID;
	private int totalAmountInstruments;
	private LocalDate orderDate;
	private LocalDate deliveryDate;
	
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
	
	public int getOrderID()
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
	
	public LocalDate getOrderDate()
	{
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) 
	{
		this.orderDate = orderDate;
	}
	
	public LocalDate getDeliveryDate() 
	{
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) 
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


	public Order(int orderID,int totalAmountInstruments, LocalDate orderDate, LocalDate deliveryDate)
	{
		super();
		this.orderID = orderID;
		this.totalAmountInstruments = totalAmountInstruments;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int totalAmountInstruments, LocalDate orderDate, LocalDate deliveryDate)
	{
		super();
		this.totalAmountInstruments = totalAmountInstruments;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.hospitalList = new ArrayList<Hospital>();
		this.instrumentList = new ArrayList<Instrument>();
	}
	
	public Order(int orderID, int totalAmountInstruments, LocalDate orderDate, LocalDate deliveryDate, List<Hospital> hospitalList, List<Instrument> instrumentList)
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
	
	public void addHospital(Hospital hospital)
	{
		if(!hospitalList.contains(hospital))
		{
			this.hospitalList.add(hospital);
		}
	}
	public void addInstrument(Instrument instrument)
	{
		if(!instrumentList.contains(instrument))
		{
			this.instrumentList.add(instrument);
		}
	}
	
	public void removeHospital(Hospital hospital)
	{
		if(hospitalList.contains(hospital))
		{
			this.hospitalList.remove(hospital);
		}
	}
	public void removeInstrument(Instrument instrument)
	{
		if(instrumentList.contains(instrument))
		{
			this.instrumentList.remove(instrument);
		}
	}
	
	
	@Override
	public String toString() 
	{
		return "Order [orderID=" + orderID + ", totalAmountInstruments=" + totalAmountInstruments + ", orderDate="
				+ orderDate + ", deliveryDate=" + deliveryDate + ", hospitalList=" + hospitalList + ", instrumentList="
				+ instrumentList + "]";
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
