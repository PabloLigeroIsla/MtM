package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "warehouse")
@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "Warehouse")
@XmlType(propOrder = { "warehouseID", "warehouseLocation", "capacity", "filledSpace" })//Set the attributes in the XML

public class Warehouse implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -554480961908721094L;
//
	/**
	 * 
	 */
	
	@Id 
	@GeneratedValue(generator="warehouse")
	@TableGenerator(name="warehouse", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="warehouse")
	
	
	@XmlAttribute
	private Integer warehouseID;
	@XmlAttribute
	private String warehouseLocation;
	@XmlAttribute
	private Integer capacity;
	@XmlAttribute
	private Integer filledSpace;
	
	@OneToMany(mappedBy="warehouse") //one warehouse has many instruments
	@XmlTransient
	private List<Instrument> instrumentList;

	@OneToMany(mappedBy="warehouse") //one warehouse has many materials
	@XmlTransient
	private List <Material> materialTypeList; //FOREIGN KEY
	
	
	public Warehouse(String warehouseLocation, Integer capacity, Integer filledSpace) {
		super();
		this.warehouseLocation = warehouseLocation;
		this.capacity = capacity;
		this.filledSpace = filledSpace;
		this.instrumentList = new ArrayList<Instrument>();
		this.materialTypeList = new ArrayList<Material>();
		
	}
	
	
	public Warehouse(int warehouseID, String warehouseLocation, Integer capacity, Integer filledSpace) {
		super();
		this.warehouseID = warehouseID;
		this.warehouseLocation = warehouseLocation;
		this.capacity = capacity;
		this.filledSpace = filledSpace;
		this.instrumentList = new ArrayList<Instrument>();
		this.materialTypeList = new ArrayList<Material>();
		
	}
	
	public Warehouse(int wid)
	{
		this.warehouseID = wid;
		this.instrumentList = new ArrayList<Instrument>();
		this.materialTypeList = new ArrayList<Material>();
	}


	public Warehouse() {
		super();
		this.instrumentList = new ArrayList<Instrument>();
		this.materialTypeList = new ArrayList<Material>();		}
	
	
	public void addInstrument(Instrument instrument){
		if (!instrumentList.contains(instrument)) {
			this.instrumentList.add(instrument);
		}
	}
	
	
	public void removeInstrument(Instrument instrument) {
		if (instrumentList.contains(instrument)) {
			this.instrumentList.remove(instrument);
		}
	}
	
	public void addMaterial(Material material){
		if (!materialTypeList.contains(material)) {
			this.materialTypeList.add(material);
		}
	}
	
	
	public void removeMaterial(Material material) {
		if (materialTypeList.contains(material)) {
			this.materialTypeList.remove(material);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((warehouseID == null) ? 0 : warehouseID.hashCode());
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
		Warehouse other = (Warehouse) obj;
		if (warehouseID == null) {
			if (other.warehouseID != null)
				return false;
		} else if (!warehouseID.equals(other.warehouseID))
			return false;
		return true;
	}


	public void printWarehouse(boolean relate){
		System.out.printf("Warehouse ID: %d\n", this.warehouseID);
		System.out.printf("Warehouse location: %s\n", this.warehouseLocation);
		System.out.printf("Warehouse capacity: %d\n", this.capacity);
		System.out.printf("Warehouse filled space: %d\n", this.filledSpace);

	}
	
	@Override
	public String toString() {
		return "Warehouse [warehouseID=" + warehouseID + ", warehouseLocation=" + warehouseLocation + ", capacity="
				+ capacity + ", filledSpace=" + filledSpace + "]";
	}

	public Integer getWarehouseID() {
		return warehouseID;
	}


	public void setWarehouseID(Integer warehouseID) {
		this.warehouseID = warehouseID;
	}


	public String getWarehouseLocation() {
		return warehouseLocation;
	}


	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public Integer getFilledSpace() {
		return filledSpace;
	}


	public void setFilledSpace(Integer filledSpace) {
		this.filledSpace = filledSpace;
	}


	public List<Instrument> getInstrumentList() {
		return instrumentList;
	}


	public void setInstrumentList(List<Instrument> instrumentList) {
		this.instrumentList = instrumentList;
	}


	public List<Material> getMaterialTypeList() {
		return materialTypeList;
	}


	public void setMaterialTypeList(List<Material> materialTypeList) {
		this.materialTypeList = materialTypeList;
	}

}



	
	