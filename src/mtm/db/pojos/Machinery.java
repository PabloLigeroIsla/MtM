package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import mtm.db.pojos.Employee;

import java.time.LocalDate;

@Entity
@Table(name = "machinery") //sql table name  (Compatible with JDBC)
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
	private int machineryID;
	private String machineryType;
	private String stateofMachinery;
	private LocalDate dateofInstallation;
	private int sizeofMachinery;
	
	@OneToMany(mappedBy="machinery")
	@XmlElement(name = "Material") 
    @XmlElementWrapper(name = "Materials")
	private List <Material> materialList; //FOREIGN KEY
	@XmlElement(name="Material")
	@XmlElementWrapper(name ="Materials")
	
	@ManyToMany(mappedBy = "machineryTypeList")
	private List <Instrument> instrumentList; //FOREIGN KEY
	@XmlElement(name="Instrument")
	@XmlElementWrapper(name ="Instruments")
	
	@OneToMany(mappedBy="machineryType")
	
	private List <Employee> employeeList; //FOREIGN KEY	
	@XmlElement(name = "Employee") 
    @XmlElementWrapper(name = "Employees")
	
	
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

	public LocalDate getDateofInstallation() {
		return dateofInstallation;
	}

	public void setDateofInstallation(LocalDate dateofInstallation) {
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
	
	public Machinery(String machineryType, String stateofMachinery, LocalDate dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
		this.materialList = new ArrayList<Material>();
		this.instrumentList = new ArrayList<Instrument>();
		this.employeeList = new ArrayList<Employee>();
	}
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, LocalDate dateofInstallation, int sizeofMachinery) {
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
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, LocalDate dateofInstallation, 
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
	
	public String printMach(){
		return "Machinery [machineryID=" + this.machineryID + ",machineryType=" 
				+ this.machineryType + ",stateofMachinery=" + this.stateofMachinery + ", dateofInstallation=" 
				+ this.dateofInstallation + ", sizeofMachinery=" + this.sizeofMachinery + "]";
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
