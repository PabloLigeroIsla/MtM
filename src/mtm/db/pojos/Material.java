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
@XmlType(propOrder = { "weight", "volume", "type","company","machinery","warehouse"})


public class Material implements Serializable {
	

	private static final long serialVersionUID = -5060012550789129173L;
	
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
	@JoinColumn(name = "machinery_ID")
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

	public Material(Integer weight2, Integer volume2, String type2, Company companyID2, Machinery machineryID2, Warehouse warehouseID2) {
		this.weight = weight2;
		this.volume = volume2;
		this.type = type2;
		this.company = companyID2;
		this.machinery = machineryID2;
		this.warehouse = warehouseID2; 
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

	public Warehouse getWarehouseID() {
		return warehouse;
	}

	public void setWarehouseID(Warehouse warehouseID) {
		this.warehouse = warehouseID;
	}


	public void printMaterial() {
		System.out.println("Material [materialID=" + materialID + ", weight=" + weight + ", volume=" + volume + ", type=" + type
				+ ", companyID=" + company.getCompanyID() + ", machineryID=" + machinery.getMachineryID() + ", warehouseID=" + warehouse.getWarehouseID() + "]");
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
