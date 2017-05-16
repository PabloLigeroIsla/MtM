package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

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
	@TableGenerator(name="material", table="sqlite_sequence",
	    pkColumnName="machineryID", valueColumnName="seq", pkColumnValue="machinery")
	private int machineryID;
	private String machineryType;
	private String stateofMachinery;
	private LocalDate dateofInstallation;
	private int sizeofMachinery;
	
	@JoinColumn(name="material_ID")
	private int materialID; //FOREIGN KEY
	@JoinColumn(name = "instrument_ID")
	private int instrumentID; //FOREIGN KEY
	@JoinColumn(name = "employee_ID")
	private int employeeID; //FOREIGN KEY	
	
	private ArrayList<Material>  materialList;
	
	//materialList
	public ArrayList<Material> getMaterialList() {
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

	public int getMaterialID() {
		return materialID;
	}

	public void setMaterialID(int materialID) {
		this.materialID = materialID;
	}
	
	public int getInstrumentID() {
		return instrumentID;
	}

	public void setInstrumentID(int instrumentID) {
		this.instrumentID = instrumentID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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
	}
	
	public Machinery(String machineryType, String stateofMachinery, LocalDate dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
	}
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, LocalDate dateofInstallation, int sizeofMachinery) {
		super();
		this.machineryID = machineryID;
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;

	}	
	
	public Machinery(int machineryID,String machineryType, String stateofMachinery, LocalDate dateofInstallation, 
			int sizeofMachinery, List<Instrument> instrumentList, List<Material> materialList, List<Employee> employeeList) {
		super();
		this.machineryID = machineryID;
		this.machineryType = machineryType;
		this.stateofMachinery = stateofMachinery;
		this.dateofInstallation = dateofInstallation;
		this.sizeofMachinery = sizeofMachinery;
		
	}	
	
	// Methods
	
	@Override
	public String toString() 
	{
		return "Machinery [machineryID=" + machineryID + ",machineryType=" 
	+ machineryType + ",stateofMachinery=" + stateofMachinery + ", dateofInstallation=" 
	+ dateofInstallation + ", sizeofMachinery=" + sizeofMachinery + "]";
	}
	
	public String printMach(){
		return "Machinery [machineryID=" + machineryID + ",machineryType=" 
				+ machineryType + ",stateofMachinery=" + stateofMachinery + ", dateofInstallation=" 
				+ dateofInstallation + ", sizeofMachinery=" + sizeofMachinery + "]";
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
