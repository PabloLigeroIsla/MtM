package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@Entity
@Table(name = "company") //sql table name  (Compatible with JDBC)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Company")
@XmlType(propOrder = { "companyID","location","companyName"})
public class Company implements Serializable {


	
	private static final long serialVersionUID = -8663787080395108472L;

	@Id 
	@GeneratedValue(generator="company")
	@TableGenerator(name="company", table="sqlite_sequence",
	pkColumnName="name", valueColumnName="seq", pkColumnValue="company")
	
	@XmlAttribute
	private int companyID; //PRIMARY KEY
	@XmlAttribute
	private String location;
	@XmlAttribute
	private String companyName;
	

	@OneToMany(mappedBy="company")//Company:Name of the object Company in the Material Object
	@XmlTransient
	//@XmlElement(name = "Material") why not?
    //@XmlElementWrapper(name = "Materials")	

	private List<Material>  materialList;
	


	
	//methods
	public void printCompany(boolean relate) 
	{
		System.out.println("Company  companyID=" + companyID + ", companyName=" + location + ",location= " + companyName);	

		if(relate){
			
			Iterator <Material> iterMat = this.getMaterialList().iterator();
			Material mat;
			
			while(iterMat.hasNext())
			{
				mat = iterMat.next();
				System.out.printf("Material  "
						+ "material ID: %d"
						+ "material type: %s\n",mat.getMaterialID(),mat.getType());
			}		
			
		}

	}

	public List<Material> getMaterialList() {
		return materialList;
	}

	public void setMaterialList(List<Material> materialList) {
		this.materialList = materialList;
	}

	public Company()
	{
		super();
		this.materialList = new ArrayList<Material>();
		
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