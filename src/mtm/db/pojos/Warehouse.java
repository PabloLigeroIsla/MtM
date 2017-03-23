package mtm.db.pojos;

import java.io.Serializable;

public class Warehouse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2150121666397926334L;
	private String warehouse_location;
	private Integer capacity;
	private Integer filled_space;
	
	
	public Warehouse(String warehouse_location, Integer capacity, Integer filled_space) {
		super();
		this.warehouse_location = warehouse_location;
		this.capacity = capacity;
		this.filled_space = filled_space;
	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((filled_space == null) ? 0 : filled_space.hashCode());
		result = prime * result + ((warehouse_location == null) ? 0 : warehouse_location.hashCode());
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
		if (filled_space == null) {
			if (other.filled_space != null)
				return false;
		} else if (!filled_space.equals(other.filled_space))
			return false;
		if (warehouse_location == null) {
			if (other.warehouse_location != null)
				return false;
		} else if (!warehouse_location.equals(other.warehouse_location))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Warehouse [warehouse_location=" + warehouse_location + ", capacity=" + capacity + ", filled_space="
				+ filled_space + "]";
	}



	public String getWarehouse_location() {
		return warehouse_location;
	}


	public void setWarehouse_location(String warehouse_location) {
		this.warehouse_location = warehouse_location;
	}


	public Integer getCapacity() {
		return capacity;
	}


	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}


	public Integer getFilled_space() {
		return filled_space;
	}


	public void setFilled_space(Integer filled_space) {
		this.filled_space = filled_space;
	}
}



	
	