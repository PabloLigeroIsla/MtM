package mtm.db.jpa;

import mtm.db.Interface.*;
import mtm.db.pojos.*;

public class JPAManager implements DBInterface
{
	//Material
		public void createTableMaterial()
		{
			
		}
		
		public void insert(Material obj)
		{
			
		}
		
		public void deleteMaterial(int primaryKey)
		{
			
		}
		
		
		public Material selectMaterial(int primaryKey)
		{
			Material mat = new Material();
			return mat;
		}
	//Machinery
	
		public void createTableMachinery()
		{
			
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
	
		public Machinery selectMachinery(int primaryKey)
		{
			Machinery mach = new Machinery();
			return mach;
		}
}
