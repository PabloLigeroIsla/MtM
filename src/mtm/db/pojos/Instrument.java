package mtm.db.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 529944640208225941L;
	/**
	 * 
	 */

	

	
	private Integer instrumentID;
	private String model;
	private String purpose;
	private Integer amount;
	private Integer numberUses;
	private String bodyLocation;
	private Integer price;
	private Warehouse warehouse;
	private List<Order> orderList;
	private List<Machinery> machineryTypeList;


		
	public Instrument(String model, String purpose, Integer amount, Integer numberUses, String bodyLocation, Integer price, Warehouse warehouseID) {
		super();
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyLocation;
		this.setPrice(price);
		this.warehouse = warehouseID;
		this.orderList = new ArrayList<Order>();
		this.machineryTypeList = new ArrayList<Machinery>();
		
	}
	
	


/*	public Instrument(String model2, String purpose2, Integer amount2, Integer numberUses2, String bodyLocation2,
			Integer price2) {
		// este metodo esta creado porque DbManager lo necesita porque tengo un objeto Instrument sin la lista
		
		this.model = model2;
		this.purpose = purpose2;
		this.amount = amount2;
		this.numberUses = numberUses2;
		this.bodyLocation = bodyLocation2;
		this.setPrice(price2);
		
		
	}
	*/
	



	public Instrument(int instrumentID2, String model2, String purpose2, Integer amount2, Integer numberUses2,
			String bodyLocation2, Integer price2, Warehouse warehouseID2) {
	}




	public Instrument(int instrumentID2, String model2, String purpose2, Integer amount2, Integer numberUses2,
			String bodyLocation2, Integer price2) {
	}


	// Additional method to add and remove from a list	

	public Instrument() {
	}




	public Instrument(String model2, String purpose2, int amount2, int numberUses2, String bodyLocation2, int price2) {
	}




	public void addOrder(Order order) {
		if (!orderList.contains(order)) {
			this.orderList.add(order);
		}
	}
		
	public void removeOrder(Order order) {
		if (orderList.contains(order)) {
			this.orderList.remove(order);
		}
	}
	
	public void addMachinery(Machinery machineryType){
		if (!machineryTypeList.contains(machineryType)) {
			this.machineryTypeList.add(machineryType);
		}
	}
	
	public void removeMachinery(Machinery machineryType){
		if (machineryTypeList.contains(machineryType)) {
			this.machineryTypeList.remove(machineryType);
		}
	}









	



	@Override
	public String toString() {
		return "Instrument [instrumentID=" + instrumentID + ", model=" + model + ", purpose=" + purpose + ", amount="
				+ amount + ", numberUses=" + numberUses + ", bodyLocation=" + bodyLocation + ", price=" + price
				+ ", warehouseLocation=" + warehouse + ", orderList=" + orderList + ", machineryTypeList="
				+ machineryTypeList + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((bodyLocation == null) ? 0 : bodyLocation.hashCode());
		result = prime * result + ((instrumentID == null) ? 0 : instrumentID.hashCode());
		result = prime * result + ((machineryTypeList == null) ? 0 : machineryTypeList.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((numberUses == null) ? 0 : numberUses.hashCode());
		result = prime * result + ((orderList == null) ? 0 : orderList.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
		result = prime * result + ((warehouse == null) ? 0 : warehouse.hashCode());
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
		if (machineryTypeList == null) {
			if (other.machineryTypeList != null)
				return false;
		} else if (!machineryTypeList.equals(other.machineryTypeList))
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
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
			return false;
		if (warehouse == null) {
			if (other.warehouse != null)
				return false;
		} else if (!warehouse.equals(other.warehouse))
			return false;
		return true;
	}




	public Integer getInstrumentID() {
		return instrumentID;
	}




	public void setInstrumentID(Integer instrumentID) {
		this.instrumentID = instrumentID;
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




	public Integer getNumberUses() {
		return numberUses;
	}




	public void setNumberUses(Integer numberUses) {
		this.numberUses = numberUses;
	}




	public String getBodyLocation() {
		return bodyLocation;
	}




	public void setBodyLocation(String bodyLocation) {
		this.bodyLocation = bodyLocation;
	}




	public Integer getPrice() {
		return price;
	}




	public void setPrice(Integer price) {
		this.price = price;
	}




	




	



	public Warehouse getWarehouseID() {
		return warehouse;
	}




	public void setWarehouseID(Warehouse warehouseID) {
		this.warehouse = warehouseID;
	}




	public List<Order> getOrderList() {
		return orderList;
	}




	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}




	public List<Machinery> getMachineryTypeList() {
		return machineryTypeList;
	}




	public void setMachineryTypeList(List<Machinery> machineryTypeList) {
		this.machineryTypeList = machineryTypeList;
	}




	




}





