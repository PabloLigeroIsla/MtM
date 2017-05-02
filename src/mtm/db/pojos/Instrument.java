package mtm.db.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instrument implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8136208930132488298L;
	//

	
	private Integer instrumentID;
	private String name;
	private String model;
	private String purpose;
	private Integer amount;
	private Integer numberUses;
	private String bodyLocation;
	private Integer price;
	private Warehouse warehouse;
	private List<Order> orderList;
	private List<Machinery> machineryTypeList;


		


	public Instrument(int instrumentID2, String name2, String model2, String purpose2, Integer amount2, Integer numberUses2,
			String bodyLocation2, Integer price2, Warehouse warehouseID2) {
	}




	public Instrument(int instrumentID2, String name2, String model2, String purpose2, Integer amount2, Integer numberUses2,
			String bodyLocation2, Integer price2) {
	}


	// Additional method to add and remove from a list	

	public Instrument() {
	}







	public Instrument(String name, String model, String purpose, int amount, int numberUses, String bodyL,
			int price) {
		
		this.name = name;
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.numberUses = numberUses;
		this.bodyLocation = bodyL;
		this.setPrice(price);
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


	public void addWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public void removeWarehouse(Warehouse warehouse){
		this.warehouse = null;
	}
	








	









	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instrumentID == null) ? 0 : instrumentID.hashCode());
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
		if (instrumentID == null) {
			if (other.instrumentID != null)
				return false;
		} else if (!instrumentID.equals(other.instrumentID))
			return false;
		return true;
	}




	public Integer getInstrumentID() {
		return instrumentID;
	}




	public void setInstrumentID(Integer instrumentID) {
		this.instrumentID = instrumentID;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public Warehouse getWarehouse() {
		return warehouse;
	}




	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
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





