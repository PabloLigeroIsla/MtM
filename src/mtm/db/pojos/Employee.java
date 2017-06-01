package mtm.db.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@XmlType(propOrder = { "employeeID", "name", "specializationType", "typeofContract" })

public class Employee implements Serializable {

	private static final long serialVersionUID = -8477517713230030048L;
	
	//Atributes
	
	@Id 
	@GeneratedValue(generator="employee")
	@TableGenerator(name="employee", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="employee")
	
	@XmlAttribute
	private int employeeID;
	@XmlAttribute
	private String name;
	@XmlAttribute
	private String specializationType;
	@XmlAttribute
	private String typeofContract;
	@XmlAttribute
	
	@ManyToOne 
	@JoinColumn(name = "machineryID")//Variable in jdbc that makes reference
	@XmlTransient
	private Machinery machineryType; //FOREIGN KEY

	
	//Gets and Sets

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
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
	
	public Employee(String name, String specializationType, String typeofContract, Machinery machineryType) 
	{
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

	public void printEmployee(boolean relate)
	{
			System.out.printf("\nid: %d, name: %s, Type of contract: %s\n",getEmployeeID(),getName(),getSpecializationType());
			System.out.printf("\nRelated Machinery id: %d\n",getMachineryType().getMachineryID());
		
	}
	
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
