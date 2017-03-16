package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3297814757811814786L;
	private String employee_ID;
	private String name;
	private String specializationType;
	private String typeofContract;
	private String machinery;

	private List<Machinery> machineryList;

	public String getEmployee_ID() {
		return employee_ID;
	}

	public void setEmployee_ID(String employee_ID) {
		this.employee_ID = employee_ID;
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

	public Employee(String employee_ID, String name, String specializationType, String typeofContract,
			String machinery) {
		super();
		this.employee_ID = employee_ID;
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machinery = machinery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee_ID == null) ? 0 : employee_ID.hashCode());
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
		if (employee_ID == null) {
			if (other.employee_ID != null)
				return false;
		} else if (!employee_ID.equals(other.employee_ID))
			return false;
		return true;
	}

}
