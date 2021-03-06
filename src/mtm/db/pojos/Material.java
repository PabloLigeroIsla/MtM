package mtm.db.pojos;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;




@Entity
@Table(name = "material") //sql table name  (Compatible with JDBC)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Material")
@XmlType(propOrder = { "weight", "volume", "type","company","warehouse"})


public class Material implements Serializable {
	

	private static final long serialVersionUID = -8114612240247882836L;
	
	@Id 
	@GeneratedValue(generator="material")
	@TableGenerator(name="material", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="material")
	
	
	@XmlAttribute
	private Integer materialID; //PRIMARY KEY
	@XmlAttribute
	private Integer weight;
	@XmlAttribute
	private Integer volume;
	@XmlAttribute
	private String type;
	
	@ManyToOne
	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companyID")
	//@XmlTransient
	@XmlElement(name = "Company")
	private Company company; //FOREIGN KEY
	
	@ManyToOne
	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machineryID")
	@XmlTransient
	private Machinery machinery; //FOREIGN KEY
	
	@ManyToOne
	//@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "warehouseID")
	@XmlElement(name = "Warehouse")
	private Warehouse warehouse; //FOREIGN KEY

	

	public Material (){
		super();
	}
	
	public Material(Integer materialID, Integer weight, Integer volume, String type, Company c_id, Machinery m_id, Warehouse h_id){
		super();
		this.materialID= materialID;
		this.weight = weight;
		this.volume = volume;
		this.type= type;
		this.company = c_id;
		this.machinery = m_id;
		this.warehouse = h_id;
	}
	
	public Material(Integer weight, Integer volume, String type, Company companyID){
		super();
		this.weight = weight;
		this.volume = volume;
		this.type= type;
		this.company = companyID;
	}
	
	public Material(Integer weight, Integer volume, String type){
		super();
		this.weight = weight;
		this.volume = volume;
		this.type= type;
	}


	public Integer getMaterialID() {
		return materialID;
	}

	public void setMaterialID(Integer materialID) {
		this.materialID = materialID;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompanyID(Company companyID) {
		this.company = companyID;
	}

	public Machinery getMachineryID() {
		return machinery;
	}

	public void setMachineryID(Machinery machineryID) {
		this.machinery = machineryID;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


	public void printMaterial(boolean relate) {
		
		System.out.println("Material information:\n materialID:" + materialID + "\nWeight:" + weight + "\nVolume=" + volume + "\nType:" + type);
		System.out.printf("\nRelated Machinery id: %d\n",machinery.getMachineryID());
		System.out.printf("\nRelated Company id: %d\n",company.getCompanyID());
		System.out.printf("\nRelated Warehouse id: %d\n\n",warehouse.getWarehouseID());


	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((materialID == null) ? 0 : materialID.hashCode());
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
		Material other = (Material) obj;
		if (materialID == null) {
			if (other.materialID != null)
				return false;
		} else if (!materialID.equals(other.materialID))
			return false;
		return true;
	}

}
