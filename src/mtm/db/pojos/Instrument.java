package mtm.db.pojos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Instrument implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9207473196538155848L;
	private Integer instrument_id;
	private String model;
	private String purpose;
	private Integer amount;
	private Integer number_uses;
	private String body_location;
	private List<Warehouse> warehouse_location;

	public Instrument() {
		super();
		this.warehouse_location = new ArrayList<Warehouse>();
	}
		
	public Instrument(String model, String purpose, Integer amount, Integer number_uses, String body_location) {
		super();
		this.model = model;
		this.purpose = purpose;
		this.amount = amount;
		this.number_uses = number_uses;
		this.body_location = body_location;
		this.warehouse_location = new ArrayList<Warehouse>();	}
	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((body_location == null) ? 0 : body_location.hashCode());
		result = prime * result + ((instrument_id == null) ? 0 : instrument_id.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((number_uses == null) ? 0 : number_uses.hashCode());
		result = prime * result + ((purpose == null) ? 0 : purpose.hashCode());
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
		Instrument other = (Instrument) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (body_location == null) {
			if (other.body_location != null)
				return false;
		} else if (!body_location.equals(other.body_location))
			return false;
		if (instrument_id == null) {
			if (other.instrument_id != null)
				return false;
		} else if (!instrument_id.equals(other.instrument_id))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (number_uses == null) {
			if (other.number_uses != null)
				return false;
		} else if (!number_uses.equals(other.number_uses))
			return false;
		if (purpose == null) {
			if (other.purpose != null)
				return false;
		} else if (!purpose.equals(other.purpose))
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
		return "Instrument [instrument_id=" + instrument_id + ", model=" + model + ", purpose=" + purpose + ", amount="
				+ amount + ", number_uses=" + number_uses + ", body_location=" + body_location + ", warehouse_location="
				+ warehouse_location + "]";
	}


	public Integer getInstrument_id() {
		return instrument_id;
	}

	public void setInstrument_id(Integer instrument_id) {
		this.instrument_id = instrument_id;
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
		return number_uses;
	}

	public void setNumber_uses(Integer number_uses) {
		this.number_uses = number_uses;
	}

	public String getBody_location() {
		return body_location;
	}

	public void setBody_location(String body_location) {
		this.body_location = body_location;
	}

	public List<Warehouse> getWarehouse_location() {
		return warehouse_location;
	}

	public void setWarehouse_location(List<Warehouse> warehouse_location) {
		this.warehouse_location = warehouse_location;
	}

	
	public void addWarehouse(Warehouse warehouse_location) {
		if (!((List<Warehouse>) warehouse_location).contains(warehouse_location)) {
			this.warehouse_location.add(warehouse_location);
		}
	}
	
	// Additional method to remove from a list
	public void removeWarehouse(Warehouse warehouse_location) {
		if (((List<Warehouse>) warehouse_location).contains(warehouse_location)) {
			this.warehouse_location.remove(warehouse_location);
		}
	}
}
