package mtm.db.pojos;

import java.util.List;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "MtM")
@XmlType(propOrder = { "matpList", "hospList", "machList", "instList" })//Set the order of the attributes in the XML
public class MtM 
{
	//This class is created to save the Data Base as a XML
	@XmlElement(name = "Material")
	@XmlElementWrapper(name = "Materials")
	List<Material> matList;//los materiales continen compa�ias, asi que no creamos la lista de compa�ias
	
	@XmlElement(name = "Hospital")
	@XmlElementWrapper(name = "Hospitals")
	List<Hospital> hospList;//Los hospitales continen las Ordenes, asi que no ponemos lista de ordenes
	
	@XmlElement(name = "Machinery")
	@XmlElementWrapper(name = "Machineries")
	List<Machinery> machList;//Las maquinarias contienen empleados y materiales, por lo que no ponemos lista de empleados
	
	@XmlElement(name = "Instrument")
	@XmlElementWrapper(name = "Instruments")
	List<Instrument> instList;//Instruments contiene wharehouse, asi que no ponemos las listas de  Instrumentos
	
	//Getters and Setters

	public List<Material> getmatList() {
		return matList;
	}

	public void setCompList(List<Material> compList) {
		this.matList = compList;
	}

	public List<Hospital> getHospList() {
		return hospList;
	}

	public void setHospList(List<Hospital> hospList) {
		this.hospList = hospList;
	}

	public List<Machinery> getMachList() {
		return machList;
	}

	public void setMachList(List<Machinery> machList) {
		this.machList = machList;
	}

	public List<Instrument> getInstList() {
		return instList;
	}

	public void setInstList(List<Instrument> instList) {
		this.instList = instList;
	}



	
	//Constructor
	
	public MtM(List<Material> matList, List<Hospital> hospList, List<Machinery> machList, List<Instrument> instList)
	{
		super();
		this.matList = matList;
		this.hospList = hospList;
		this.machList = machList;
		this.instList = instList;
	}

	


	
}
