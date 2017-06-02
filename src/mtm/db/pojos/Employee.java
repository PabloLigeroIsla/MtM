package mtm.db.pojos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@Entity
@Table(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Employee")
@XmlType(propOrder = { "employeeID", "name", "specializationType", "typeofContract","machineryID" })

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

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "machineryID")//Variable in jdbc that makes reference
	@XmlElement
	private Machinery machineryID; //FOREIGN KEY

	
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

	public Machinery getMachineryID() {
		return machineryID;
	}
	
	public void setMachineryID(Machinery machineryID) {
		this.machineryID = machineryID;
	}
	
	// Constructors	
	public Employee() {
		super();

	}
	
	public Employee(String name, String specializationType, String typeofContract, Machinery machineryID) 
	{
		super();
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machineryID = machineryID;
	}
	
	public Employee(int employeeID, String name, String specializationType, String typeofContract,
			Machinery machineryID) {
		super();
		this.employeeID=employeeID;
		this.name = name;
		this.specializationType = specializationType;
		this.typeofContract = typeofContract;
		this.machineryID = machineryID;
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
			System.out.printf("\nEmployee  id: %d, name: %s, type of contract: %s\n",getEmployeeID(),getName(),getSpecializationType());
			System.out.printf("\nRelated Machinery id: %d\n\n",getMachineryID().getMachineryID());
		
	}
	
	@Override
	public String toString() 
	{
		return "Emplyee [employeeID=" + employeeID + ", name=" + name + ", specializationType=" 
		+ specializationType + ", typeofContract=" + typeofContract + ", machineryID=" + machineryID + "]";
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
