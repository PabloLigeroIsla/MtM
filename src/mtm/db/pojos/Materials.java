package mtm.db.pojos;

import java.io.Serializable;

public class Materials implements Serializable {

	private static final long serialVersionUID = -4285912514873004463L;
	
	
	private Integer material_ID; //PRIMARY KEY
	private String material_provided;
	private Integer volume;
	private Integer weight;
	private String machinery_type;
	
	


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
	
	
	public Materials (){
		super();
	}
	
	public Materials(Integer material_ID, String material_provided, Integer weight, Integer volume, String machinery_type){
		super();
		this.material_ID= material_ID;
		this.material_provided= material_provided;
		this.weight = weight;
		this.volume = volume;
		this.machinery_type= machinery_type;
	}
	
	public String getMaterial_provided() {
		return material_provided;
	}
	public void setMaterial_provided(String material_provided) {
		this.material_provided = material_provided;
	}
	public Integer getMaterial_ID() {
		return material_ID;
	}
	public void setMaterial_ID(Integer material_ID) {
		this.material_ID = material_ID;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((material_ID == null) ? 0 : material_ID.hashCode());
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
		Materials other = (Materials) obj;
		if (material_ID == null) {
			if (other.material_ID != null)
				return false;
		} else if (!material_ID.equals(other.material_ID))
			return false;
		return true;
	}
	
	
	
	public String getMachinery_type() {
		return machinery_type;
	}
	public void setMachinery_type(String machinery_type) {
		this.machinery_type = machinery_type;
	}
	@Override
	public String toString() {
		return "Materials [material_ID=" + material_ID + ", material_provided=" + material_provided + ", volume="
				+ volume + ", weight=" + weight + ", machinery_type=" + machinery_type + "]";
	}
	
	
	
	
	
}
