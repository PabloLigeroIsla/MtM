package mtm.db.pojos;

import java.io.Serializable;

public class Employee implements Serializable {

	//
	/**
	 * 
	 */
	private static final long serialVersionUID = -8477517713230030048L;
	
	//Atributes
	
	private int employeeID;
	private String name;
	private String specializationType;
	private String typeofContract;
	private Machinery machineryType;
	
	//Gets and Sets

	public int getEmployee_ID() {
		return employeeID;
	}

	public void setEmployee_ID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecializationType() {
		return specializationType;
	}

	public void setSpecializationType(String specializationType) {
		this.specializationType = specializationType;
	}

	public String getTypeofContract() {
		return typeofContract;
	}

	public void setTypeofContract(String typeofContract) {
		this.typeofContract = typeofContract;
	}

	public Machinery getMachineryType() {
		return machineryType;
	}
	
	public void setMachineryType(Machinery machineryType) {
		this.machineryType = machineryType;
	}
	
	// Constructors	
	public Employee() {
		super();

	}
	
	public Employee(String name, String specializationType, String typeofContract) {
		super();
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
	}
	
	public Employee(String name, String specializationType, String typeofContract,
			Machinery machineryType) {
		super();
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machineryType = machineryType;
	}
	
	public Employee(int employeeID, String name, String specializationType, String typeofContract,
			Machinery machineryType) {
		super();
		this.employeeID=employeeID;
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machineryType = machineryType;
	}
	

	public Employee(Integer employeeID, String name, String specializationType, String typeofContract) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		
	}

	// Methods

	@Override
	public String toString() 
	{
		return "Emplyee [employeeID=" + employeeID + ", name=" + name + ", specializationType=" 
		+ specializationType + ", typeofContract=" + typeofContract + ", machineryType=" + machineryType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeID;
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
		Employee other = (Employee) obj;
		if (employeeID != other.employeeID)
			return false;
		return true;
	}
	
	


}
