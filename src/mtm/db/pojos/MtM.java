package mtm.db.pojos;

import java.util.List;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD) //Be able to use XML
@XmlRootElement(name = "MtM")
@XmlType(propOrder = { "compList", "hospList", "machList", "wareList" })//Set the order of the attributes in the XML
public class MtM 
{
	//This class is created to save the Data Base as a XML
	@XmlElement(name = "Company")
	@XmlElementWrapper(name = "Companies")
	List<Company> compList;//Las compañias no continen nada, pero deben ser guardadas
	@XmlElement(name = "Hospital")
	@XmlElementWrapper(name = "Hospitals")
	List<Hospital> hospList;//Los hospitales continen las Ordenes, asi que no ponemos lista de ordenes
	@XmlElement(name = "Machinery")
	@XmlElementWrapper(name = "Machineries")
	List<Machinery> machList;//Las maquinarias contienen empleados, por lo que no ponemos lista de empleados
	@XmlElement(name = "Warehouse")
	@XmlElementWrapper(name = "Wharehouses")
	List<Warehouse> wareList;//WhareHouse contiene Material e Instruments, asi que no ponemos las listas de Materiales ni Instrumentos
	
	//Getters and Setters

	
	public List<Company> getCompList() 
	{
		return compList;
	}
	

	public void setCompList(List<Company> compList) 
	{
		this.compList = compList;
	}

	
	public List<Hospital> getHospList() 
	{
		return hospList;
	}

	
	public void setHospList(List<Hospital> hospList) 
	{
		this.hospList = hospList;
	}

	
	public List<Machinery> getMachList() 
	{
		return machList;
	}

	
	public void setMachList(List<Machinery> machList) 
	{
		this.machList = machList;
	}

	
	public List<Warehouse> getWareList() 
	{
		return wareList;
	}

	
	public void setWareList(List<Warehouse> wareList) 
	{
		this.wareList = wareList;
	}


	
	//Constructor
	
	public MtM(List<Company> compList, List<Hospital> hospList, List<Machinery> machList, List<Warehouse> wareList)
	{
		super();
		this.compList = compList;
		this.hospList = hospList;
		this.machList = machList;
		this.wareList = wareList;
	}
	
}
