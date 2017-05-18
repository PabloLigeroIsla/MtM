package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import java.time.LocalDate;


@Entity
@Table(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "Order")
@XmlType(propOrder = { "orderId", "TotalAmountInstruments", "orderDate", "deliveryDate", "instrumentList" })
public class Order implements Serializable
{

	private static final long serialVersionUID = -1476135363454640411L;
	
	@Id 
	@GeneratedValue(generator="orders")
	@TableGenerator(name="orders", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="orders")
	@XmlAttribute
	private int orderID;
	@XmlAttribute
	private int totalAmountInstruments;
	@XmlAttribute
	private LocalDate orderDate;
	@XmlAttribute
	private LocalDate deliveryDate;
	
	@ManyToMany
	private List <Hospital> hospitalList;
	@XmlElement(name = "Instrument")
	@XmlElementWrapper(name = "Instruments")
	
	@ManyToMany(mappedBy = "instrument_orders")
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
	
	public void printOrder(boolean relate)
	{
		if(relate)
		{
			System.out.printf("Order Information:\n Id: %d\n"
					+ "Total Amount Instruments: %d\n"
					+ "Order Date: %d\n"
					+ "Delivery Date: %d\n"
					+ "",this.getOrderID(),this.getTotalAmountInstruments(),this.getOrderDate(),this.getDeliveryDate());
			
			Iterator <Instrument> iterIns = this.getInstrumentList().iterator();
			Instrument inst;
			Iterator <Hospital> iterHosp = this.getHospitalList().iterator();
			Hospital hosp;
			
			while(iterIns.hasNext())
			{
				inst = iterIns.next();
				System.out.printf("Instrument %d\n"
						+ "Name: %d\n"
						+ "Price: %d",inst.getInstrumentID(),inst.getName(),inst.getPrice());
			}
			while(iterHosp.hasNext())
			{
				hosp = iterHosp.next();
				System.out.printf("Related Hospital info \n"
						+ "Name: %d\n"
						+ "id: %d\n"
						+ "Location: %d\n",hosp.getName(),hosp.getHospitalID(),hosp.getLocation());
			}
			
		}
		else
		{
			System.out.printf("Order Information:\n Id: %d\n"
					+ "Total Amount Instruments: %d\n"
					+ "Order Date: %d\n"
					+ "Delivery Date: %d\n"
					+ "",this.getOrderID(),this.getTotalAmountInstruments(),this.getOrderDate(),this.getDeliveryDate());
		
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
