package mtm.db.pojos;

import java.io.Serializable;

public class Warehouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2150121666397926334L;
	private String warehouseLocation;
	private Integer capacity;
	private Integer filledSpace;
	
	
	public Warehouse(String warehouseLocation, Integer capacity, Integer filledSpace) {
		super();
		this.warehouseLocation = warehouseLocation;
		this.capacity = capacity;
		this.filledSpace = filledSpace;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((filledSpace == null) ? 0 : filledSpace.hashCode());
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
		if (warehouseLocation == null) {
			if (other.warehouseLocation != null)
				return false;
		} else if (!warehouseLocation.equals(other.warehouseLocation))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Warehouse [warehouseLocation=" + warehouseLocation + ", capacity=" + capacity + ", filledSpace="
				+ filledSpace + "]";
	}



	public String getWarehouseLocation() {
		return warehouseLocation;
	}


	public void setWarehouse_location(String warehouseLocation) {
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


	public void setFilled_space(Integer filledSpace) {
		this.filledSpace = filledSpace;
	}
}



	
	