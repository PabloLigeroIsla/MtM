package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "company") //sql table name  (Compatible with JDBC)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")
@XmlType(propOrder = { "companyID","location","companyName","materialList"})
public class Company implements Serializable {

	@Id 
	@GeneratedValue(generator="company")
	@TableGenerator(name="company", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq", pkColumnValue="company")
	
	private static final long serialVersionUID = -8663787080395108472L;

	@XmlAttribute
	private int companyID; //PRIMARY KEY
	@XmlAttribute
	private String location;
	@XmlAttribute
	private String companyName;
	

	@OneToMany(mappedBy="company") //one company has many materials
	@XmlElement(name = "Material") 
    @XmlElementWrapper(name = "Materials")	

	private ArrayList<Material>  materialList;


	
	//metodos
	public void printCompany() {
		System.out.println("Company [companyID=" + companyID + ", location=" + location + ", companyName=" + companyName);
	}

	public ArrayList<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(ArrayList<Material> materialList) {
		this.materialList = materialList;
	}

	public Company(){

	}
	
	public Company(int company_id, String location, String companyName, ArrayList<Material> materialList){
		this.companyID= company_id;
		this.location=location;
		this.companyName=companyName;
		this.materialList=materialList;
	}
	
	
	public Company(int company_id, String location, String companyName){
		this.companyID = company_id;
		this.location = location;
		this.companyName = companyName;
		this.materialList = new ArrayList<Material>();

	}

	public Company(String location, String companyName){
		this.location = location;
		this.companyName = companyName;
		this.materialList = new ArrayList<Material>();
	}
	
	public Company (int idCompany)
	{
		this.companyID = idCompany;
		this.materialList = new ArrayList<Material>();
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

	public int getCompanyID() {
		return companyID;
	}

	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

	
	

	
	
	
}