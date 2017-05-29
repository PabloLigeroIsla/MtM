package mtm.db.jpa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import mtm.db.Interface.*;
import mtm.db.pojos.*;


public class JPAManager implements DBInterface
{
	
	//Conection
	
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
	
	//Company
	
	
	
	//Employee
	
	public Employee selectEMployee(int primaryKey)
	{
		
		Query sql = em.createNativeQuery("SELECT * FROM employee WHERE employee_ID = ?",Employee.class);
		sql.setParameter(1, primaryKey);
		
		Employee emp = (Employee) sql.getSingleResult();
		return emp;
	}
	
	
	//Material
	
	public Material selectMaterial(int primaryKey)
	{
		Material mat = new Material();
		Query sql = em.createNativeQuery("SELECT * FROM material WHERE materialID = ?",Material.class);
		sql.setParameter(1, primaryKey);
		
		mat = (Material) sql.getSingleResult();
		
		return mat;
	}
	
	public void insert(Material obj)
	{
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}
	
	public void deleteMaterial(int primaryKey)
	{
		Material mat = selectMaterial(primaryKey);
		
		em.getTransaction().begin();
		em.remove(mat);
		em.getTransaction().commit();
	}
	
	
	//Machinery
	
	public Machinery setJava2JPAFormat(Machinery obj)
	{
		Machinery finalMach = new Machinery();
		
		finalMach.setMachineryID(obj.getMachineryID());
		finalMach.setMachineryType(obj.getMachineryType());
		finalMach.setStateofMachinery(obj.getStateofMachinery());
		finalMach.setDateofInstallation(obj.getDateofInstallation());
		finalMach.setSizeofMachinery(obj.getSizeofMachinery());
		
		return finalMach;
	}
	
	public Machinery selectMachinery(int primaryKey)
	{	
		Query sql = em.createNativeQuery("SELECT * FROM machinery WHERE machineryID = ?",Machinery.class);
		sql.setParameter(1, primaryKey);
		
		Machinery mach = (Machinery) sql.getSingleResult();
		
		
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
	
		Machinery mach = selectMachinery(primaryKey);
		
		em.getTransaction().begin();
		em.remove(mach);
		em.getTransaction().commit();
	}
	
	public void updateMachinery(int pkSearch, int b)
	{
		
		String workingState;
		Machinery mach = selectMachinery(pkSearch);
		
		if(b==1){
 			workingState="work";
 		}
 		else{
 			workingState="no work";
 			
 		}
		em.getTransaction().begin();
		mach.setStateofMachinery(workingState);
		em.getTransaction().commit();
		
	}
	
	
	//ORDER
	
	public Order selectOrder(int primaryKey)
	{
		
		
		Query sql = em.createNativeQuery("SELECT * FROM orders WHERE orderID = ?",Order.class);
		sql.setParameter(1, primaryKey);
		Order ord = (Order) sql.getSingleResult();
		return ord;
	}
	
	//INSTRUMENT
	
	public Instrument selectInstrument(int primaryKey)
	{
		Query sql = em.createNativeQuery("SELECT * FROM instruments WHERE instrument_ID = ?",Order.class);
		sql.setParameter(1, primaryKey);
		
		Instrument inst = (Instrument) sql.getSingleResult();
		
		return inst;
	}
	
	
	// WAREHOUSE
	
	public void insertWareHouse()
	{
		
	}
	
	public Warehouse selectWarehouse(int primaryKey)
	{
		Query sql = em.createNativeQuery("SELECT * FROM warehouse WHERE warehouseID = ?",Warehouse.class);
		sql.setParameter(1, primaryKey);
		
		Warehouse ware = (Warehouse) sql.getSingleResult();
		return ware;
	}
}
