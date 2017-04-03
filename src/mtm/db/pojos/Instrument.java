package mtm.db.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9207473196538155848L;
	private Integer instrumentID;
	private String model;
	private String purpose;
	private Integer amount;
	private Integer numberUses;
	private String bodyLocation;
	private Integer price;
	private List<Warehouse> warehouseLocationList;
	private List<Order> orderList;


		
	public Instrument(String model, String purpose, Integer amount, Integer numberUses, String bodyLocation, Integer price, List<Warehouse> warehouseLocation) {
		super();
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyLocation;
		this.setPrice(price);
		this.warehouseLocationList = new ArrayList<Warehouse>();
		this.orderList = new ArrayList<Order>();
		
		
	}
	
	






	public Instrument(String model2, String purpose2, Integer amount2, Integer numberUses2, String bodyLocation2,
			Integer price2) {
		// este metodo esta creado porque DbManager lo necesita porque tengo un objeto Instrument sin la lista
		
		this.model = model2;
		this.purpose = purpose2;
		this.amount = amount2;
		this.numberUses = numberUses2;
		this.bodyLocation = bodyLocation2;
		this.setPrice(price2);
		
		
	}








	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bodyLocation == null) ? 0 : bodyLocation.hashCode());
		result = prime * result + ((instrumentID == null) ? 0 : instrumentID.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((numberUses == null) ? 0 : numberUses.hashCode());
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((warehouseLocationList == null) ? 0 : warehouseLocationList.hashCode());
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
		Instrument other = (Instrument) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (bodyLocation == null) {
			if (other.bodyLocation != null)
				return false;
		} else if (!bodyLocation.equals(other.bodyLocation))
			return false;
		if (instrumentID == null) {
			if (other.instrumentID != null)
				return false;
		} else if (!instrumentID.equals(other.instrumentID))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (numberUses == null) {
			if (other.numberUses != null)
				return false;
		} else if (!numberUses.equals(other.numberUses))
			return false;
		if (orderList == null) {
			if (other.orderList != null)
				return false;
		} else if (!orderList.equals(other.orderList))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (warehouseLocationList == null) {
			if (other.warehouseLocationList != null)
				return false;
		} else if (!warehouseLocationList.equals(other.warehouseLocationList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Instrument [instrumentID=" + instrumentID + ", model=" + model + ", purpose=" + purpose + ", amount="
				+ amount + ", numberUses=" + numberUses + ", bodyLocation=" + bodyLocation + ", warehouseLocationList="
				+ warehouseLocationList + ", orderList=" + orderList + "]";
	}
	
	public Integer getInstrument_id() {
		return instrumentID;
	}

	public void setInstrument_id(Integer instrument_id) {
		this.instrumentID = instrument_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getNumber_uses() {
		return numberUses;
	}

	public void setNumber_uses(Integer number_uses) {
		this.numberUses = number_uses;
	}

	public String getBody_location() {
		return bodyLocation;
	}

	public void setBody_location(String body_location) {
		this.bodyLocation = body_location;
	}

	public List<Warehouse> getWarehouse_location() {
		return warehouseLocationList;
	}

	public void setWarehouse_location(List<Warehouse> warehouse_location) {
		this.warehouseLocationList = warehouse_location;
	}

	
	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public void addWarehouse(Warehouse warehouseLocation) {
		if (!warehouseLocationList.contains(warehouseLocation)) {
			this.warehouseLocationList.add(warehouseLocation);
		}
	}
	
	
	
	// Additional method to remove from a list
	public void removeWarehouse(Warehouse warehouseLocation) {
		if (warehouseLocationList.contains(warehouseLocation)) {
			this.warehouseLocationList.remove(warehouseLocation);
		}
	}
		
		
	public void addOrder(Order order) {
		if (!orderList.contains(order)) {
			this.orderList.add(order);
		}
	}
		
	public void removeOrder(Warehouse order) {
		if (orderList.contains(order)) {
			this.orderList.remove(order);
		}
	}








	public Integer getPrice() {
		return price;
	}








	public void setPrice(Integer price) {
		this.price = price;
	}

}
