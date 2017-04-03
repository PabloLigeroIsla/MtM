package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3297814757811814786L;
	
	private String employeeID;
	private String name;
	private String specializationType;
	private String typeofContract;
	private String machinery;

	private List<Machinery> machineryList;

	public String getEmployee_ID() {
		return employeeID;
	}

	public void setEmployee_ID(String employeeID) {
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

	public String getMachinery() {
		return machinery;
	}

	public void setMachinery(String machinery) {
		this.machinery = machinery;
	}

	public List<Machinery> getMachineryList() {
		return machineryList;
	}

	public void setMachineryList(List<Machinery> machineryList) {
		this.machineryList = machineryList;
	}

	public Employee() {
		super();
		this.machineryList = new ArrayList<Machinery>();
	}

	public Employee(String employeeID, String name, String specializationType, String typeofContract,
			String machinery) {
		super();
		this.employeeID = employeeID;
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machinery = machinery;
	}
	
	public Employee(int employeeID2, String name2, String typeofContract2, String specializationType2) {
		// TODO Auto-generated constructor stub
	}

	public void addMachinery (Machinery machinery)
	{
		if(!machineryList.contains(machinery))
		{
			this.machineryList.add(machinery);
		}
	}
	
	public void removeMachinery (Machinery machinery)
	{
		if(machineryList.contains(machinery))
		{
			this.machineryList.remove(machinery);
		}
	}

	@Override
	public String toString() 
	{
		return "Emplyee [employeeID=" + employeeID + ", name=" + name + ", specializationType=" 
		+ specializationType + ", typeofContract=" + typeofContract + ", machinery=" + machinery + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeID == null) ? 0 : employeeID.hashCode());
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
		if (employeeID == null) {
			if (other.employeeID != null)
				return false;
		} else if (!employeeID.equals(other.employeeID))
			return false;
		return true;
	}

}
