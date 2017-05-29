package mtm.db.Interface;

import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;

public interface DBInterface 
{
	//Material
		//Create
		public void insert(Material obj);
		//Select
		public Material selectMaterial(int primaryKey);
		//Delete
		public void deleteMaterial(int primaryKey);
		//show
			
			
	//Machinery//
		//Create
		public void insert(Machinery obj);
		//Select
		public Machinery selectMachinery(int primaryKey);
		//Delete
		public void deleteMachinery(int primaryKey);
		//Update
		public void updateMachinery(int pkSearch, int b);
		//Show
}
