package mtm.db.pojos;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "material") //sql table name  (Compatible with JDBC)
public class Material implements Serializable {
	

	private static final long serialVersionUID = -5060012550789129173L;
	
//	@material_ID //This attribute is going to be the primary key of the DataBase
	@GeneratedValue(generator="material")
	@TableGenerator(name="material", table="sqlite_sequence", valueColumnName="seq", pkColumnValue="material")
	
	private Integer materialID; //PRIMARY KEY
	private Integer weight;
	private Integer volume;
	private String type;
	private int companyID; //FOREIGN KEY
	private int machineryID; //FOREIGN KEY
	private int warehouseID; //FOREIGN KEY
	
	


	
	public int getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(int warehouseID) {
		this.warehouseID = warehouseID;
	}

	public Material (){
		super();
	}
	
	public Material(Integer materialID, Integer weight, Integer volume, String type, int c_id, int m_id){
		super();
		this.materialID= materialID;
		this.weight = weight;
		this.volume = volume;
		this.type= type;
		this.companyID = c_id;
		this.machineryID = m_id;
	}
	
	public Material(Integer weight, Integer volume, String type, Integer companyID){
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

	public Material(Integer weight2, Integer volume2, String type2, int companyID2, int machineryID2) {
		this.weight = weight2;
		this.volume = volume2;
		this.type = type2;
		this.companyID = companyID2;
		this.machineryID = machineryID2;
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

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public int getMachineryID() {
		return machineryID;
	}

	public void setMachineryID(int machineryID) {
		this.machineryID = machineryID;
	}

	@Override
	public String toString() {
		return "Material [materialID=" + materialID + ", weight=" + weight + ", volume=" + volume + ", type=" + type
				+ ", companyID=" + companyID + ", machineryID=" + machineryID + ", warehouseID=" + warehouseID + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + companyID;
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
		if (companyID != other.companyID)
			return false;
		return true;
	}



	
	
}
