package mtm.db.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import mtm.db.Interface.*;
import mtm.db.pojos.*;

public class JPAManager implements DBInterface
{
	//
	EntityManager em = Persistence.createEntityManagerFactory("MtM").createEntityManager();
	
	public void openJPAConnection()
	{
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();
	}
	public void closeJPAConnection()
	{
		em.close();
	}
	
	
	//Material
	public Material selectMaterial(int primaryKey)
	{
		Material mat = new Material();
		String sql = "SELECT * FROM material WHERE material_ID = ?";
		
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
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	
	public void deleteMachinery(int primaryKey)
	{
		
	}
	
	public void updateMachinery(int pkSearch, int b)
	{
		
	}
	
}
