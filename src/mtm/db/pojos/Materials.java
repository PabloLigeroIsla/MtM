package mtm.db.pojos;

import java.io.Serializable;

public class Materials implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String type;
	private Integer volume;
	private Integer weight;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
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
	
	public Materials(Integer id, String type, Integer weight, Integer volume){
		super();
		this.id= id;
		this.type= type;
		this.weight = weight;
		this.volume = volume;
	}
	
	
	
	
}
