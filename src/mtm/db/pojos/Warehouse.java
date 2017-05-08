package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -554480961908721094L;
//
	/**
	 * 
	 */
	
	
	
	
	private Integer warehouseID;
	private String warehouseLocation;
	private Integer capacity;
	private Integer filledSpace;
	private List<Instrument> instrumentList;
	private List<Material> materialTypeList;
	
	public Warehouse(String warehouseLocation, Integer capacity, Integer filledSpace) {
		super();
		this.warehouseLocation = warehouseLocation;
		this.capacity = capacity;
		this.filledSpace = filledSpace;
		this.instrumentList = new ArrayList<Instrument>();
		this.materialTypeList = new ArrayList<Material>();
	}
	
	
	public Warehouse(int warehouseID2, String warehouseLocation2, Integer capacity2, Integer filledSpace2) {
		// TODO Auto-generated constructor stub
	}


	public Warehouse() {
		// TODO Auto-generated constructor stub
	}


	//metodos para añadir y borrar elementos de las listas
	
	
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
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((filledSpace == null) ? 0 : filledSpace.hashCode());
		result = prime * result + ((instrumentList == null) ? 0 : instrumentList.hashCode());
		result = prime * result + ((materialTypeList == null) ? 0 : materialTypeList.hashCode());
		result = prime * result + ((warehouseID == null) ? 0 : warehouseID.hashCode());
		result = prime * result + ((warehouseLocation == null) ? 0 : warehouseLocation.hashCode());
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
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (filledSpace == null) {
			if (other.filledSpace != null)
				return false;
		} else if (!filledSpace.equals(other.filledSpace))
			return false;
		if (instrumentList == null) {
			if (other.instrumentList != null)
				return false;
		} else if (!instrumentList.equals(other.instrumentList))
			return false;
		if (materialTypeList == null) {
			if (other.materialTypeList != null)
				return false;
		} else if (!materialTypeList.equals(other.materialTypeList))
			return false;
		if (warehouseID == null) {
			if (other.warehouseID != null)
				return false;
		} else if (!warehouseID.equals(other.warehouseID))
			return false;
		if (warehouseLocation == null) {
			if (other.warehouseLocation != null)
				return false;
		} else if (!warehouseLocation.equals(other.warehouseLocation))
			return false;
		return true;
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



	
	