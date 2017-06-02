package mtm.db.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



@Entity
@Table(name = "instrument")
@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "Instrument")
@XmlType(propOrder = { "instrumentID", "name", "model", "purpose", "amount", "numberUses","bodyLocation","price","warehouse","orderList","machineryList" })//Set the attributes in the XML

public class Instrument implements Serializable {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1514530835720427306L;
	
	
	@Id 
	@GeneratedValue(generator="instrument")
	@TableGenerator(name="instrument", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="instrument")
	
	@XmlAttribute
	private Integer instrumentID;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String model;
	@XmlAttribute
	private String purpose;
	@XmlAttribute
	private Integer amount;
	@XmlAttribute
	private Integer numberUses;
	@XmlAttribute
	private String bodyLocation;
	@XmlAttribute
	private Integer price;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "warehouseID")
	@XmlElement(name = "Warehouse")
	private Warehouse warehouse;
	
	@ManyToMany // the mappedBy is in the pojo Order only
	@JoinTable(name="instrument_orders",
	joinColumns={@JoinColumn(name="instrumentID", referencedColumnName="instrumentID")},
    inverseJoinColumns={@JoinColumn(name="orderID", referencedColumnName="orderID")})
	@XmlElement(name = "Order")
	@XmlElementWrapper(name = "Orders")
	private List<Order> orderList;
	
	@ManyToMany // the mappedBy is in the pojo Machinery
	@JoinTable(name="instrument_machinery",
	joinColumns={@JoinColumn(name="instrumentID", referencedColumnName="instrumentID")},
    inverseJoinColumns={@JoinColumn(name="machineryID", referencedColumnName="machineryID")})
	@XmlElement(name = "Machinery")
	@XmlElementWrapper(name = "Machineries")
	private List<Machinery> machineryList;


		

	public Instrument(int instrumentID, String name, String model, String purpose, int amount, int numberUses,
			String bodyLocation, int price, Warehouse warehouse) {
		super();
		this.instrumentID = instrumentID;
		this.name = name;
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyLocation;
		this.setPrice(price);
		this.warehouse = warehouse;
		this.orderList = new ArrayList<Order>();
		this.machineryList = new ArrayList<Machinery>();
		
	}

	
	public Instrument(String name, String model, String purpose, int amount, int numberUses, String bodyL,
			int price) {
		super();
		this.name = name;
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyL;
		this.setPrice(price);
		this.orderList = new ArrayList<Order>();
		this.machineryList = new ArrayList<Machinery>();
	}

	
	// Additional method to add and remove from a list	

	
	public Instrument() {
		super();
		this.orderList = new ArrayList<Order>();
		this.machineryList = new ArrayList<Machinery>();
	}


	public void addOrder(Order order) {
		if (!orderList.contains(order)) {
			this.orderList.add(order);
		}
	}
		
	public void removeOrder(Order order) {
		if (orderList.contains(order)) {
			this.orderList.remove(order);
		}
	}
	
	public void addMachinery(Machinery machinery){
		if (!machineryList.contains(machinery)) {
			this.machineryList.add(machinery);
		}
	}
	
	public void removeMachinery(Machinery machinery){
		if (machineryList.contains(machinery)) {
			this.machineryList.remove(machinery);
		}
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrumentID == null) ? 0 : instrumentID.hashCode());
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
		Instrument other = (Instrument) obj;
		if (instrumentID == null) {
			if (other.instrumentID != null)
				return false;
		} else if (!instrumentID.equals(other.instrumentID))
			return false;
		return true;
	}


	public void printInstrument(){
		System.out.printf("\n");		
		System.out.printf("Instrument ID: %d\n", this.instrumentID);
		System.out.printf("Name of the instrument: %s\n", this.name);
		System.out.printf("Model of the instrument: %s\n", this.model);
		System.out.printf("Purpose of the instrument: %s\n", this.purpose);
		System.out.printf("Amount of instruments: %d\n", this.amount);
		System.out.printf("Number of uses: %d\n", this.numberUses);
		System.out.printf("Body location of the instrument: %s\n", this.bodyLocation);
		System.out.printf("Price of the instrument: %d\n", this.price);


	}


	public Integer getInstrumentID() {
		return instrumentID;
	}




	public void setInstrumentID(Integer instrumentID) {
		this.instrumentID = instrumentID;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}


	public Warehouse getWarehouse() {
		return warehouse;
	}




	public void setWarehouseID(Warehouse warehouse) {
		this.warehouse = warehouse;
	}




	public String getModel() {
		return model;
	}




	public void setModel(String model) {
		this.model = model;
	}




	public String getPurpose() {
		return purpose;
	}




	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	public Integer getNumberUses() {
		return numberUses;
	}




	public void setNumberUses(Integer numberUses) {
		this.numberUses = numberUses;
	}




	public String getBodyLocation() {
		return bodyLocation;
	}




	public void setBodyLocation(String bodyLocation) {
		this.bodyLocation = bodyLocation;
	}


	public Integer getPrice() {
		return price;
	}


	public void setPrice(Integer price) {
		this.price = price;
	}


	public List<Order> getOrderList() {
		return orderList;
	}


	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}


	public List<Machinery> getMachineryList() {
		return machineryList;
	}


	public void setMachineryList(List<Machinery> machineryList) {
		this.machineryList = machineryList;
	}


}
