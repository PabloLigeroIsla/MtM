package mtm.db.pojos;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import mtm.db.pojos.Employee;

@Entity
@Table(name = "machinery") //sql table name  (Compatible with JDBC)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Machinery")
@XmlType(propOrder = { "machineryID", "machineryType", "stateofMachinery", "dateofInstallation", "sizeofMachinery" })

public class Machinery implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5275135022867594008L;
	//Attributes
	
	@Id 
	@GeneratedValue(generator="machinery")
	@TableGenerator(name="machinery", table="sqlite_sequence",
	    pkColumnName="name", valueColumnName="seq", pkColumnValue="machinery")
	
	@XmlAttribute
	private int machineryID;
	@XmlAttribute
	private String machineryType;
	@XmlAttribute
	private String stateofMachinery;
	@XmlAttribute
	private Date dateofInstallation;
	@XmlAttribute
	private int sizeofMachinery;

	
	@OneToMany(mappedBy="machinery")
	@XmlElement(name = "Material") 
    @XmlElementWrapper(name = "Materials")
	private List <Material> materialList; //FOREIGN KEY

	@XmlTransient ////////////////////////////////////////////////////////////////////////////////////////////
	@ManyToMany(mappedBy = "machineryTypeList")
	private List <Instrument> instrumentList; //FOREIGN KEY
	
	@OneToMany(mappedBy="machineryType")
	@XmlElement(name = "Employee")
	@XmlElementWrapper(name = "Employees")
	private List <Employee> employeeList; //FOREIGN KEY	

	//materialList
	public List<Material> getMaterialList() {
		return materialList;
	}
	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}
	public void addMaterial (Material material){
		if(!materialList.contains(material)){
			this.materialList.add(material);
		}
	}
	
	public void removeMaterial(Material material) {
		if (materialList.contains(material)) {
			this.materialList.remove(material);
		}
	}
	
	//Gets and Sets

	public void setMaterialList(List<Material> materialList) 
	{
		this.materialList = materialList;
	}
	
	public List<Instrument> getInstrumentList() 
	{
		return instrumentList;
	}
	public void setInstrumentList(List<Instrument> instrumentList) 
	{
		this.instrumentList = instrumentList;
	}
	
	public List<Employee> getEmployeeList() 
	{
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) 
	{
		this.employeeList = employeeList;
	}
	
	public String getMachineryType() {
		return machineryType;
	}

	public int getMachineryID() {
		return machineryID;
	}

	public void setMachineryID(int machineryID) {
		this.machineryID = machineryID;
	}

	public void setMachineryType(String machineryType) {
		this.machineryType = machineryType;
	}

	public String getStateofMachinery() {
		return stateofMachinery;
	}

	public void setStateofMachinery(String stateofMachinery) {
		this.stateofMachinery = stateofMachinery;
	}

	public Date getDateofInstallation() {
		return dateofInstallation;
	}

	public void setDateofInstallation(Date dateofInstallation) {
		this.dateofInstallation = dateofInstallation;
	}

	public int getSizeofMachinery() {
		return sizeofMachinery;
	}

	public void setSizeofMachinery(int sizeofMachinery) {
		this.sizeofMachinery = sizeofMachinery;
	}

	// Constructors	

	public Machinery() {
		super();
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();

	}
	
	public Machinery(String machineryType, String stateofMachinery, Date dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();
	}
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, Date dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryID = machineryID;
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();

	}	
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, Date dateofInstallation, 
			int sizeofMachinery, List<Instrument> instrumentList, List<Material> materialList, List<Employee> employeeList) {
		super();
		this.machineryID = machineryID;
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();
		
	}	
	
	public Machinery (int mid)
	{
		this.machineryID = mid;
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();
	}
	
	
	// Methods
	
	public void addInstrument(Instrument instrument)
	{
		if(!instrumentList.contains(instrument))
		{
			this.instrumentList.add(instrument);
		}
	}
	public void addEmployee(Employee employee)
	{
		if(!employeeList.contains(employee))
		{
			this.employeeList.add(employee);
		}
	}
	
	public void removeInstrument(Instrument instrument)
	{
		if(instrumentList.contains(instrument))
		{
			this.instrumentList.remove(instrument);
		}
	}
	
	public void removeEmployee(Employee employee)
	{
		if(employeeList.contains(employee))
		{
			this.employeeList.remove(employee);
		}
	}
	
	
	@Override
	public String toString() 
	{
		return "Machinery [machineryID=" + machineryID + ",machineryType=" 
	+ machineryType + ",stateofMachinery=" + stateofMachinery + ", dateofInstallation=" 
	+ dateofInstallation + ", sizeofMachinery=" + sizeofMachinery + "]";
	}

	public void printMach(boolean b){
		
		System.out.printf("Machinery information:\n Id: %d" + "Machinery Type: %s\n" 
			+ "State of machinery: %s\n"+"Date of installation: %s\n"+ "Size of machinery:%d\n\n"
			,this.getMachineryID(),this.getMachineryType(),this.getStateofMachinery(),
			this.getDateofInstallation(),this.getSizeofMachinery());
		if(b){
			//With relations
			
			
			Iterator <Employee> iter = this.getEmployeeList().iterator();
			while(iter.hasNext())
			{
				Employee emp  = iter.next();
				System.out.printf("Employees Related:\n"
						+ "Id: %d\n"+"Name: %s",emp.getEmployeeID(),emp.getName());
			}
			Iterator <Material> iter2 = this.getMaterialList().iterator();
			while(iter2.hasNext())
			{
				Material mat  = iter2.next();
				System.out.printf("Materials Related:\n"
						+ "Id: %d\n"+"Type: %s",mat.getMaterialID(),mat.getType());
			}
			Iterator <Instrument> iter3 = this.getInstrumentList().iterator();
			while(iter3.hasNext())
			{
				Instrument inst  = iter3.next();
				System.out.printf("Instruments Related:\n"
						+ "Id: %d\n"+"Name: %s",inst.getInstrumentID(),inst.getName());
			}
			
		}
		 
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + machineryID;
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
		Machinery other = (Machinery) obj;
		if (machineryID != other.machineryID)
			return false;
		return true;
	}

}
