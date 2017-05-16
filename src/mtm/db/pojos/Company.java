package mtm.db.pojos;

import java.io.Serializable;
import java.util.ArrayList;


public class Company implements Serializable {
	

	private static final long serialVersionUID = 3043355853522402172L;
	private int companyID; //PRIMARY KEY
	private String location;
	private String companyName;
	
	private ArrayList<Material>  materialList;
	
	public void printCompany(){
		System.out.println("Company ID: "+this.companyID+"\nCompany Location: "+this.location+"\nCompany Name: "+this.companyName);
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