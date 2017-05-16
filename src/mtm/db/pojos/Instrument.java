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
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "instrument")
@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "Instrument")
@XmlType(propOrder = { "instrumentID", "name", "model", "purpose", "amount", "numberUses","bodyLocation","price","warehouse","orderList","machineryTypeList" })//Set the attributes in the XML

public class Instrument implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1788155612443950967L;
	
	
	@Id 
	@GeneratedValue(generator="instrument")
	@TableGenerator(name="instrument", table="sqlite_sequence",
	    pkColumnName="instrumentID", valueColumnName="seq", pkColumnValue="instrument")
	
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
	// This @XmlTransient is here to avoid infinite loops --- hay que decidir si el warehouse muestra instrument o al contrario,
	// si no, llegamos a un bucle infinito.
	@XmlTransient
	private Warehouse warehouse;
	
	@ManyToMany(mappedBy = "instrument_orders")
	@XmlElement(name = "Order")
	@XmlElementWrapper(name = "Orders")
	private List<Order> orderList;
	
	@ManyToMany(mappedBy = "instrument_machinery")
	@XmlElement(name = "Machinery")
	@XmlElementWrapper(name = "Machineries")
	private List<Machinery> machineryTypeList;


		


	public Instrument(int instrumentID, String name, String model, String purpose, int amount, int numberUses,
			String bodyLocation, int price) {
		super();
		this.instrumentID = instrumentID;
		this.name = name;
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyLocation;
		this.setPrice(price);
		
	}

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
		
	}
	
	public Instrument (int iid)
	{
		this.instrumentID = iid;
	}
	
	public Instrument(String name, String model, String purpose, int amount, int numberUses, String bodyL,
			int price,Warehouse warehouse) {
		super();
		this.name = name;
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyL;
		this.setPrice(price);
		this.warehouse = warehouse;
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
	}

	
	// Additional method to add and remove from a list	

	public Instrument() {
		super();
		this.orderList = new ArrayList<Order>();
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
	
	public void addMachinery(Machinery machineryType){
		if (!machineryTypeList.contains(machineryType)) {
			this.machineryTypeList.add(machineryType);
		}
	}
	
	public void removeMachinery(Machinery machineryType){
		if (machineryTypeList.contains(machineryType)) {
			this.machineryTypeList.remove(machineryType);
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




	public List<Machinery> getMachineryTypeList() {
		return machineryTypeList;
	}




	public void setMachineryTypeList(List<Machinery> machineryTypeList) {
		this.machineryTypeList = machineryTypeList;
	}






	




}





