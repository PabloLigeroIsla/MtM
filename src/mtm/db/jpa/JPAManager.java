package mtm.db.jpa;

import mtm.db.Interface.*;
import mtm.db.pojos.*;

public class JPAManager implements DBInterface
{
	//Material
	public Material selectMaterial(int primaryKey)
	{
		Material mat = new Material();
		return mat;
	}
	
	public void insert(Material obj)
	{
		
	}
	
	public void deleteMaterial(int primaryKey)
	{
		
	}
	
		
		
	//Machinery
	
	public Machinery selectMachinery(int primaryKey)
	{
		Machinery mach = new Machinery();
		return mach;
	}
	
	public void insert(Machinery obj)
	{
		
	}
	
	public void deleteMachinery(int primaryKey)
	{
		
	}
	
	public void updateMachinery(int pkSearch, int b)
	{
		
	}
	
}
