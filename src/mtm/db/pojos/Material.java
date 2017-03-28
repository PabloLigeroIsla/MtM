package mtm.db.pojos;

import java.io.Serializable;

public class Material implements Serializable {

	private static final long serialVersionUID = -5060012550789129173L;

	
	private Integer materialID; //PRIMARY KEY
	private String materialProvided;
	private Integer volume;
	private Integer weight;
	private String machineryType;
	
	


	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	
	public Material (){
		super();
	}
	
	public Material(Integer materialID, String materialProvided, Integer weight, Integer volume, String machineryType){
		super();
		this.materialID= materialID;
		this.materialProvided= materialProvided;
		this.weight = weight;
		this.volume = volume;
		this.machineryType= machineryType;
	}
	
	public String getMaterialProvided() {
		return materialProvided;
	}
	public void setMaterialProvided(String materialProvided) {
		this.materialProvided = materialProvided;
	}
	public Integer getMaterialID() {
		return materialID;
	}
	public void setMaterialID(Integer materialID) {
		this.materialID = materialID;
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
	
	
	
	public String getMachineryType() {
		return machineryType;
	}
	public void setMachineryType(String machinery_type) {
		this.machineryType = machinery_type;
	}
	@Override
	public String toString() {
		return "Materials [materialID=" + materialID + ", materialProvided=" + materialProvided + ", volume="
				+ volume + ", weight=" + weight + ", machineryType=" + machineryType + "]";
	}
	
	
	
	
	
}
