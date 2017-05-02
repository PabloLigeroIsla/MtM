package mtm.db.Interface;

import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;

public interface DBInterface 
{
	//Material
		//Create
		public void createTableMaterial();
		//Insert
		public void insert(Material obj);
		//Delete
		public void deleteMaterial(int primaryKey);
		//show
			// Select
			public Material selectMaterial(int primaryKey);
	//Machinery
		//Create
		public void createTableMachinery();
		//Insert
		public void insert(Machinery obj);
		//Delete
		public void deleteMachinery(int primaryKey);
		//Update
		public void updateMachinery(int pkSearch, int b);
		//Show
			// Select
			public Machinery selectMachinery(int primaryKey);
}
