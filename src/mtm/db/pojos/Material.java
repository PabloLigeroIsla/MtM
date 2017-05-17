package mtm.db.pojos;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "material") //sql table name  (Compatible with JDBC)
public class Material implements Serializable {
	

	private static final long serialVersionUID = -5060012550789129173L;
	
	@Id 
	@GeneratedValue(generator="material")
	@TableGenerator(name="material", table="sqlite_sequence",
	    pkColumnName="materialID", valueColumnName="seq", pkColumnValue="material")
	
	private Integer materialID; //PRIMARY KEY
	private Integer weight;
	private Integer volume;
	private String type;
	
	@JoinColumn(name = "companyID")
	Company companyID; //FOREIGN KEY
	@JoinColumn(name = "machinery_ID")
	Machinery machineryID; //FOREIGN KEY
	@JoinColumn(name = "warehouse_ID")
	Warehouse warehouseID; //FOREIGN KEY
	
	

	public Material (){
		super();
	}
	
	public Material(Integer materialID, Integer weight, Integer volume, String type, Company c_id, Machinery m_id, Warehouse h_id){
		super();
		this.materialID= materialID;
		this.weight = weight;
		this.volume = volume;
		this.type= type;
		this.companyID = c_id;
		this.machineryID = m_id;
		this.warehouseID = h_id;
	}
	
	public Material(Integer weight, Integer volume, String type, Company companyID){
		super();
		this.weight = weight;
		this.volume = volume;
		this.type= type;
		this.companyID = companyID;
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
		this.companyID = companyID2;
		this.machineryID = machineryID2;
		this.warehouseID = warehouseID2; 
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

	public Company getCompanyID() {
		return companyID;
	}

	public void setCompanyID(Company companyID) {
		this.companyID = companyID;
	}

	public Machinery getMachineryID() {
		return machineryID;
	}

	public void setMachineryID(Machinery machineryID) {
		this.machineryID = machineryID;
	}

	public Warehouse getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(Warehouse warehouseID) {
		this.warehouseID = warehouseID;
	}


	public String printMaterial() {
		return "Material [materialID=" + materialID + ", weight=" + weight + ", volume=" + volume + ", type=" + type
				+ ", companyID=" + companyID.getCompanyID() + ", machineryID=" + machineryID.getMachineryID() + ", warehouseID=" + warehouseID.getWarehouseID() + "]";
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
