//¿?Need a new variable that is the combination of both
//¿?hascode and equals should have both integers

// @hasCode and equals
// @Implement the final serialVersionUID

package mtm.db.pojos;

import java.io.Serializable;

public class Instrument_orders implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Integer order_ID;
	private Integer instrument_ID;
	private Integer amount_order;
	// Primary Key --> order_ID + instrument_ID
	// Foreign key --> order_ID, instrument_ID
	
	//Gets and Sets
	
	public Integer getOrder_ID() 
	{
		return order_ID;
	}
	public void setOrder_ID(Integer order_ID) 
	{
		this.order_ID = order_ID;
	}
	
	public Integer getInstrument_ID() 
	{
		return instrument_ID;
	}
	public void setInstrument_ID(Integer instrument_ID) 
	{
		this.instrument_ID = instrument_ID;
	}
	
	public Integer getAmount_order() 
	{
		return amount_order;
	}
	public void setAmount_order(Integer amount_order) 
	{
		this.amount_order = amount_order;
	}
	
	//Constructors
	
	public Instrument_orders()
	{
		super();
	}
	
	public Instrument_orders(Integer order_ID, Integer instrument_ID, Integer amount_order) {
		super();
		this.order_ID = order_ID;
		this.instrument_ID = instrument_ID;
		this.amount_order = amount_order;
	}
	
	//Methods
	
	@Override
	public String toString() 
	{
		return "Instrument_orders [order_ID=" + order_ID + ", instrument_ID=" + instrument_ID + ", amount_order="
				+ amount_order + "]";
	}
	
	//hasCode and equals
	
	
}
