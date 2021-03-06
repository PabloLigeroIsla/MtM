package mtm.db.jdbc;

import mtm.db.pojos.*;
import mtm.db.Interface.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;


public class JDBCManager implements DBInterface
{
	
	public Connection c = null;
	
	//Methods to create the Pojos
	
	public Order createPojoOrder(int number,String d11,String d12,String d13,String d21,String d22,String d23)
	{
		LocalDate date1Ld = StringtoLocalDate(d13,d12,d11);
		LocalDate date2Ld = StringtoLocalDate(d23,d22,d21);
		
		Date date1SQL = LocaltoSqlDate(date1Ld);
		Date date2SQL = LocaltoSqlDate(date2Ld);
		
		Order ord = new Order(number,date1SQL,date2SQL);
		return ord;
	}
	
	public Machinery createPojoMachinery(String machineryType, String stateofMachinery,String d,String m, String y, int sizeofMachinery){
		
		LocalDate date3LD = StringtoLocalDate(y,m,d);
		Date date3SQL = LocaltoSqlDate(date3LD);
		Machinery mach = new Machinery (machineryType, stateofMachinery, date3SQL, sizeofMachinery);
		return mach;
		
	}

	//Connection Methods
	public Connection openConnection()
{
	try
	{
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:./db/mtm.db");
		c.createStatement().execute("PRAGMA foreign_keys=ON");
		System.out.println("Database connection opened.");
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return c;
}	
	public void closeConnection()
	{
		try
		{
			c.close();
			System.out.println("Database Closed");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Create the tables
	public boolean createTables()
	{
		
		JDBCCreate codeCreate = new JDBCCreate(c);
		return codeCreate.createTables();
		
	}

	//Insert
	
	public void insert(Hospital obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		String selQuery = "SELECT * FROM hospital WHERE name LIKE ?";
		
		if(valExist(selQuery,-1,obj.getName()))
		{
			System.out.println("This Hospital exist");
		}else
		{
	
			codeInsert.insert(obj);
		
		}
		
	}
	
	public void insert(Order obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		codeInsert.insert(obj);
		
	}
	
	public void insert(Instrument obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		
		codeInsert.insert(obj);
		
	}
	
	public void insert(Warehouse obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		
		codeInsert.insert(obj);
		
	}
	
	public void insert(Company obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		
		codeInsert.insert(obj);
	}
	
	public void insert(Material obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		
		codeInsert.insert(obj);
	}

	public void insert(Employee obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		codeInsert.insert(obj);
			
		
	}
	
	public void insert(Machinery obj)
	{
		JDBCInsert codeInsert = new JDBCInsert(c);
		
		
		codeInsert.insert(obj);
		
	}
	
	//Delete
	
	//Pojos
	public void deleteHospital(int primaryKey)
	{
		
		String sqlQuery = "SELECT * FROM hospital WHERE hospitalID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteHospital(primaryKey);
			
			//We delate the corresponding orders related with the hospital
			
			String relationalTable = "hospital_orders";
			String pk1AttributeSearch = "orderID";
			String pkAttributeCompere = "hospitalID";
			int pkValueCompare = primaryKey;
			
			ArrayList<Integer> orderPkRelationFound = new ArrayList<Integer>();
			orderPkRelationFound = foundRelation(relationalTable,pk1AttributeSearch,pkAttributeCompere,pkValueCompare);
			boolean Shear = sharedRelation(relationalTable,pk1AttributeSearch,pkAttributeCompere,pkValueCompare);
			
			Iterator<Integer> iter = orderPkRelationFound.iterator();
			
			while(iter.hasNext())
			{
				int i = iter.next();
				if(!Shear)
				{
					deleteOrder(i);
				}
				deleteRelationHospitalOrder(i,pk1AttributeSearch);
			}
			
			
		}
		else
		{
			System.out.println("\n The hospital does not exist \n");
		}
		
	}
	
	public void deleteOrder(int primaryKey)
	{
		String sqlQuery = "SELECT * FROM orders WHERE orderID = ?";
		
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteOrder(primaryKey);
			
			//We also delete the relation
			String table = "hospital_orders";
			String  pk1AtributeSearch = "hospitalID";
			String pkAtributeCompere = "orderID";
			int pkValueCompere = primaryKey;
			if(!sharedRelation(table, pk1AtributeSearch, pkAtributeCompere, pkValueCompere))
			{
				
				String colPk = "orderID";
				deleteRelationHospitalOrder(primaryKey,colPk);
			}
			
			
			table = "instrument_orders";
			pk1AtributeSearch = "orderID";
			pkAtributeCompere = "orderID";
			pkValueCompere = primaryKey;
			if(!sharedRelation(table, pk1AtributeSearch, pkAtributeCompere, pkValueCompere))
			{
				String colPk = "orderID";
				deleteRelationInstrumentOrder(primaryKey,colPk);
			}
			
		}
		else
		{
			System.out.println("\n The Order does not exist \n");
		}
	}
	
	public void deleteEmployee(int primaryKey)
	{
		
		String sqlQuery = "SELECT * FROM employee WHERE employeeID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sql = new JDBCDelete(c);
			sql.deleteEmployee(primaryKey);
		}
		else
		{
			System.out.println("\n The Employee does not exist \n");
		}
		
	}
	
	public void deleteMachinery(int primaryKey)
	{
		String sqlQuery = "SELECT * FROM orders WHERE machineryID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sql = new JDBCDelete(c);
			sql.deleteMachinery(primaryKey);
		}
		else
		{
			System.out.println("\n The Machinery does not exist \n");
		}
	}

	public void deleteInstrument(int primaryKeyInstrument)
	{
		
		String sqlQuery = "SELECT * FROM instrument WHERE instrumentID = ?";
		if(valExist(sqlQuery,primaryKeyInstrument,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteInstrument(primaryKeyInstrument);
			
			
			// We also delete the relation with the order in which it is contained
			
			String table = "instruments_order";
			String pk1AtSearch = "orderID";
			String pk1Compare = "instrumentID";
			int pkValueCompare = primaryKeyInstrument;
			if(!sharedRelation(table, pk1AtSearch, pk1Compare, pkValueCompare))
			{
				sqlDelete.deleteInstrument(primaryKeyInstrument);
				
				String colPk = "instrumentID";
				deleteRelationInstrumentOrder(primaryKeyInstrument,colPk);
			}			

		}
		else
		{
			System.out.println("\n The instrument does not exist \n");
		}
	}
	
	public void deleteWarehouse(int primaryKeyWarehouse)
	{
		
		String sqlQuery = "SELECT * FROM warehouse WHERE warehouseID = ?";
		if(valExist(sqlQuery,primaryKeyWarehouse,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteWarehouse(primaryKeyWarehouse);
			
		}
		else
		{
			System.out.println("\n The warehouse does not exist \n");
		}
		
	}
	
	public void deleteCompany(int primaryKey){
		String sqlQuery = "SELECT * FROM company WHERE companyID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			sqlDelete.deleteCompany(primaryKey);
			
			//delete relations
			ArrayList <Integer> arrayPks = foundRelation("material","materialID","companyID",primaryKey);
			Iterator<Integer> iter = arrayPks.iterator();
			while(iter.hasNext()){
				deleteMaterial(iter.next());
			}
		}
		else
		{
			System.out.println("\n The company does not exist \n");
		}
	}

	public void deleteMaterial(int primaryKey){
		String sqlQuery = "SELECT * FROM material WHERE materialID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			sqlDelete.deleteMaterial(primaryKey);

		}
		else
		{
			System.out.println("\n The material does not exist \n");
		}
	}
	
	//Relations
	
	public void deleteRelationHospitalOrder(int pkCol,String colPk)
	{
		String table = "hospital_orders";
	
		JDBCDelete sqlDelete = new JDBCDelete(c);
		sqlDelete.deleteRelationNtoN( table, colPk, pkCol);
	}
	
	public void deleteRelationInstrumentOrder(int pkCol,String colPk)
	{
		String table = "instrument_orders";
		
		JDBCDelete sqlInsert = new JDBCDelete(c);
		sqlInsert.deleteRelationNtoN(table,colPk,pkCol);
	}
	
	public void deleteRelationInstrumentMachinery(int pkCol,String colPk)
	{
		String table = "instrument_machinery";
		JDBCDelete sqlDelete = new JDBCDelete(c);
		sqlDelete.deleteRelationNtoN( table, colPk, pkCol);
		
	}
	
	public void deleteRelationMachineryEmployee(int pkMachinery)
	{
		ArrayList<Employee> emplist = selectAllEmployees();
		Iterator<Employee> iter = emplist.iterator();
		while(iter.hasNext())
		{
			Employee emp = iter.next();
			if(emp.getMachineryID().getMachineryID() == pkMachinery)
			{
				deleteEmployee(pkMachinery);
			}
		}
	}
	
 	public void deleteRelationInstrumentWarehouse(int instID, int warID){
		try {
		String table = "instrument_warehouse";
		String sql = "DELETE FROM"+table+"WHERE instrumentID="+instID;
		PreparedStatement prep = c.prepareStatement(sql);
		prep.setInt(1, warID);
		prep.executeUpdate();
		
		} catch (Exception e) {
		System.out.println(e.getMessage());
		}
	}
	
	//Select
	
	//Pojos
	public Hospital selectHospital(int primaryKey)
	{
		String table = "hospital";
		String selQuery = "SELECT * FROM "+table+" WHERE hospitalID = ?";
		
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Hospital hosp = new Hospital();
	 		
			
			hosp = sqlSelect.selectHospital(selQuery,primaryKey);
		
			
			return hosp;
		}else
		{
			System.out.println("We dont find the primary key\n");
			
			return null;
		}
	}
 	
	public Hospital selectHospital(String nameHospital)
 	{
		String selQuarry = "SELECT * FROM hospital WHERE name LIKE ?";
		
		if(valExist(selQuarry,-1,nameHospital))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Hospital hosp = new Hospital();
	 		
			
			hosp = sqlSelect.selectHospital(selQuarry,nameHospital);
			
			
			return hosp;
		}else
		{
			System.out.println("We dont find the primary key\n");
			
			return null;
		}
 		
 	}

 	public Order selectOrder(int primaryKey)
	{
		String selQuery = "SELECT * FROM orders WHERE orderID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Order order = new Order();
	 		
	
			order= sqlSelect.selectOrder(selQuery,primaryKey);
			
			
			return order;
		}else
		{
			System.out.println("We dont find the primary key\n");
			return null;
		}
	}

 	public Company selectCompany(int primaryKey){
 		String selQuery = "SELECT * FROM company WHERE companyID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 	
	 		Company comp= sqlSelect.selectCompany(selQuery,primaryKey);
			
			return comp;
		}else
		{
			System.out.println("We dont find the primary key\n");
			return null;
		}
 	}

 	public Material selectMaterial(int primaryKey){
 		String selQuery = "SELECT * FROM material WHERE materialID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Material mat = new Material();
	 		Material matf = new Material();
	 		
			mat= sqlSelect.selectMaterial(selQuery,primaryKey);
			int idComp = mat.getCompany().getCompanyID();
			mat.setCompanyID(selectCompany(idComp));
			int idMach = mat.getMachineryID().getMachineryID();
			mat.setMachineryID(selectMachinery(idMach));
			int idWare = mat.getWarehouse().getWarehouseID();
			mat.setWarehouse(selectWarehouse(idWare));
			
			
			
			return matf;
		}else
		{
			System.out.println("We dont find the primary key\n");
			return null;
		}
 	}

 	public Employee selectEmployee(int primaryKey)
 	{
 		
 		String selQuery = "SELECT * FROM employee WHERE employeeID = ?";
 		
 		
 		if(valExist(selQuery,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		Employee emp = new Employee();
 	 		
 			emp = sqlSelect.selectEmployee(selQuery,primaryKey);
 			int machID = emp.getMachineryID().getMachineryID();
 			emp.setMachineryID(selectMachinery(machID));
 			return emp;
 		}else
 		{
 			System.out.println("We dont find the primary key\n");
 			
 			return null;
 		}
 	}

 	public Employee selectEmployee(String nameEmployee)
 	{
 		String selQuarry = "SELECT location FROM employee WHERE name LIKE ?";
 		
 		if(valExist(selQuarry,-1,nameEmployee))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		Employee emp = new Employee();
 	 		
 			emp = sqlSelect.selectEmployee(selQuarry,nameEmployee);
 			
 			return emp;
 		}else
 		{
 			System.out.println("We dont find the primary key\n");
 			
 			return null;
 		}
 			
 	}
 		
 	public Machinery selectMachinery(int primaryKey)
 	{
 		String table = "machinery";
 		String selQuarry = "SELECT * FROM "+table+" WHERE machineryID = ?";
 		
 		
 		if(valExist(selQuarry,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 			
 			Machinery mach = new Machinery();
 	 		
 			mach = sqlSelect.selectMachinery(selQuarry,primaryKey);
 			
 			
 			return mach;
 		}else
 		{
 			System.out.println("We dont find the primary key\n");
 			
 			return null;
 		}
 	}
 	
 	public Machinery selectMachinery(String nameMachinery)
 	{
 		String selQuarry = "SELECT * FROM machinery WHERE machineryType LIKE ?";
 		
 		if(valExist(selQuarry,-1,nameMachinery))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 			Machinery mach = new Machinery();
 	 		
 			mach = sqlSelect.selectMachinery(selQuarry,nameMachinery);
 			
 			return mach;
 		}else
 		{
 			System.out.println("We dont find the primary key/n");
 			
 			return null;
 		}
 			
 	}

 	public Instrument selectInstrument(int primaryKey)
 	{
 		String selQuery = "SELECT * FROM instrument WHERE instrumentID=?";
 		
 		
 		if(valExist(selQuery,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		Instrument instrument = new Instrument();
 	 		
 			
 			instrument = sqlSelect.selectInstrument(selQuery,primaryKey);
 			int wID = instrument.getWarehouse().getWarehouseID();
 			instrument.setWarehouseID(selectWarehouse(wID)); 			
 			return instrument;
 		}else
 		{
 			System.out.println("We dont find the primary key\n");
 			
 			return null;
 		}
 	}
 	
 	public Warehouse selectWarehouse(int primaryKey)
 	{
 		String table = "warehouse";
 		String selQuery = "SELECT * FROM "+table+" WHERE warehouseID = ?";
 			
 		if(valExist(selQuery,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 				
 			Warehouse warehouse = new Warehouse();
 			warehouse = sqlSelect.selectWarehouse(selQuery,primaryKey);
 			
 			return warehouse;
 		}else
 		{
 			System.out.println("We dont find the primary key\n");
 				
 			return null;
 		}
 	}
	
 	//Arrays of Pojos
	
	public ArrayList<Hospital> selectAllHospitals()
	{
		
		ArrayList<Hospital> hosp = new ArrayList<Hospital>();
		JDBCSelect sqlSelect = new JDBCSelect(c);
		
		hosp = sqlSelect.selectAllHospitals();
		
		
		return hosp;
	}
 	
 	public ArrayList<Order> selectAllOrders()
 	{
 		ArrayList<Order> orderList = new ArrayList<Order>();
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 		
 		
		orderList = sqlSelect.selectAllOrders();
		
 		return orderList;
 	}

 	public ArrayList<Company> selectAllCompanies(){
 		ArrayList<Company> companiesList = new ArrayList<Company>();
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 		
		companiesList = sqlSelect.selectAllCompanies();
		
 		return companiesList;
 	}
 	
 	public ArrayList<Material> selectAllMaterials()
 	{
 		ArrayList<Material> materialList = new ArrayList<Material>();
 		ArrayList<Material> materialListFinal = new ArrayList<Material>();
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 		
		materialList = sqlSelect.selectAllMaterials();
		Iterator<Material> itMat = materialList.iterator();
		while(itMat.hasNext())
		{
			Material mat = itMat.next();
			
			int com = mat.getCompany().getCompanyID();
			mat.setCompanyID(selectCompany(com));
			int mach = mat.getMachineryID().getMachineryID();
			mat.setMachineryID(selectMachinery(mach));
			int war = mat.getWarehouse().getWarehouseID();
			mat.setWarehouse(selectWarehouse(war));
			
			materialListFinal.add(mat);
		}

		
 		return materialListFinal;
 	}
 	
 	public ArrayList<Employee> selectAllEmployees(){
	 		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		ArrayList<Employee> empFinal = new ArrayList<Employee>();
		
		JDBCSelect sqlSelect = new JDBCSelect(c);
		
		emp = sqlSelect.selectAllEmployee();
		Iterator<Employee> empIter = emp.iterator();
		
		while(empIter.hasNext())
		{
			Employee empObj = empIter.next();
			int machID = empObj.getMachineryID().getMachineryID();
			empObj.setMachineryID(selectMachinery(machID));
			empFinal.add(empObj);
		}
		
		return empFinal;
	}
	
 	public ArrayList<Machinery> selectAllMachineries()
	{
		ArrayList<Machinery> mach = new ArrayList<Machinery>();
		JDBCSelect sqlSelect = new JDBCSelect(c);
		
		mach = sqlSelect.selectAllMachinery();
		
		return mach;
	}
 	
 	public ArrayList<Instrument> selectAllInstruments()
 	{
 		ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
 		ArrayList<Instrument> instrumentListFinal = new ArrayList<Instrument>();
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		
 	 	
 		instrumentList = sqlSelect.selectAllInstruments();
 		Iterator<Instrument> insIter = instrumentList.iterator();
 		while(insIter.hasNext())
 		{
 			Instrument inst =insIter.next();
 			
 			int wID = inst.getWarehouse().getWarehouseID();
 			inst.setWarehouseID(selectWarehouse(wID));
 			
 			instrumentListFinal.add(inst);
 			
 		}
 			
 			
 		return instrumentListFinal;
 	}
 	
 	public ArrayList<Warehouse> selectAllWarehouses()
	{
		ArrayList<Warehouse> warehouseList = new ArrayList<Warehouse>();
		JDBCSelect sqlSelect = new JDBCSelect(c);
		
		warehouseList = sqlSelect.selectAllWarehouses();
	
		return warehouseList;
	}
 	 		 	
 	// Update
 	
 	public void updateHospital(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "hospital";
 		String selQuery = "SELECT name FROM "+table+" WHERE hospitalID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 			
 			
 		}
 		
 	}
 	
 	public void updateOrder(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "orders";
 		String selQuery = "SELECT * FROM orders WHERE orderID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 		
 			
 		}
 		
 	}
 	
 	public void updateMachinery(int pkSearch, int b)
 	{
 		String workingState=null;
 		if(b==1){
 			workingState="work";
 		}
 		else{
 			workingState="no work";
 			
 		}

 		String selQuery = "SELECT name FROM machinery WHERE machineryID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateMachinery(pkSearch,workingState);

 		}

 	}
 	
 	public void updateMaterial(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "material";
 		String selQuery = "SELECT name FROM "+table+" WHERE materialID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 			
 			
 		}
 		
 	}
 	
 	public void updateCompany(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "company";
 		String selQuery = "SELECT * FROM o WHERE companyID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 		
 			
 		}
 		
 	}

 	public void updateWarehouse(int pkSearch, int filledSpaceUpdated)
 	{ 	
 		
 		String table = "warehouse";
		String selQuery = "SELECT warehouseID FROM "+table+" WHERE warehouseID = ?";
		if(valExist(selQuery,pkSearch,null))
		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateWarehouse(pkSearch,filledSpaceUpdated);
		}
 			
 		
 	} 	
 	
 	public void updateWarehouseL(int pkSearch, String locationUpdated)
 	{ 	
 		
 		String table = "warehouse";
		String selQuery = "SELECT warehouseID FROM "+table+" WHERE warehouseID = ?";
		if(valExist(selQuery,pkSearch,null))
		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateWarehouseL(pkSearch,locationUpdated);
		}
 			
 		
 	} 	

		
 	
	//Set ID's
	public Company setCompanyID(Company com){
		
		int pkSearch = 0;
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "company";
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		
		com.setCompanyID(pkSearch);
		
		return com;
	}
	
	public Hospital setHospitalID(Hospital hosp)
	{

		int pkSearch = 0;
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "hospital";
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		
		hosp.setHospitalID(pkSearch);
		return hosp;
	}

	public Order setOrderID(Order ord)
	{

		int pkSearch = 0;
		
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "orders";
		
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		
		ord.setOrderID(pkSearch);
		
		return ord;
	}
	
	public Instrument setInstrumentID(Instrument inst){
		int pkSearch = 0;
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "instrument";
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		inst.setInstrumentID(pkSearch);
		return inst;
	}
	
	public Warehouse setWarehouseID(Warehouse war){
		int pkSearch = 0;
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "warehouse";
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		war.setWarehouseID(pkSearch);
		return war;
	}

	public Machinery setMachineryID(Machinery mach)
	{
		int pkSearch = 0;
		String query = "SELECT seq FROM sqlite_sequence WHERE name=?";
		String table = "machinery";
		JDBCSelect sqlSelect = new JDBCSelect(c);
		pkSearch = sqlSelect.selectIdTable(query,table);
		
		mach.setMachineryID(pkSearch);
		
		return mach;
	}
	
	//SetRelations
	
	//Pojos
	public Hospital setHospitalRelations(Hospital hosp)
	{
		String relationalTable = "hospital_orders";
		String pk1AtributeSearch = "orderID";
		String pkAtributeCompere = "hospitalID";
		int pkValueCompere = hosp.getHospitalID();
		
		
		ArrayList<Integer> orderPkRelationFound = new ArrayList<Integer>();
		orderPkRelationFound = foundRelation(relationalTable,pk1AtributeSearch,pkAtributeCompere,pkValueCompere);
		Iterator<Integer> iter = orderPkRelationFound.iterator();
		while(iter.hasNext())
		{
			int i = iter.next();
			hosp.addOrder(selectOrder(i));
		}
		return hosp;
	}
	
	public Order setOrderRelations(Order ord)
	{
		String pkAtributeCompere = "orderID";
		int pkValueCompere = ord.getOrderID();
		
		//Hospital List
		String relationalTable = "hospital_orders";
		String pk1AtributeSearch = "hospitalID";
		
		ArrayList<Integer> hospitalPkRelationFound = new ArrayList<Integer>();
		
		hospitalPkRelationFound = foundRelation(relationalTable,pk1AtributeSearch,pkAtributeCompere,pkValueCompere);
		Iterator<Integer> iter = hospitalPkRelationFound.iterator();
		
		while(iter.hasNext())
		{
			int i = iter.next();
			ord.addHospital(selectHospital(i));
		}
		
		//Instrument List
		
		relationalTable = "instrument_orders";
		pk1AtributeSearch = "instrumentID";
		
		ArrayList<Integer> instrumentPkRelationFound = new ArrayList<Integer>();
		instrumentPkRelationFound = foundRelation(relationalTable,pk1AtributeSearch,pkAtributeCompere,pkValueCompere);
		Iterator<Integer> iter2 = instrumentPkRelationFound.iterator();
		while(iter2.hasNext())
		{
			int i = iter2.next();
			ord.addInstrument(selectInstrument(i));
		}
	return ord;
	}
	
	public Instrument setInstrumentRelations(Instrument inst){
		
		//relation instrument-orders//
		
		String relationalTable = "instrument_orders";
		String pk1AttSearchOrder = "orderID";
		String pkAttCompareInst = "instrumentID";
		int pkValueCompare = inst.getInstrumentID();
		
		ArrayList<Integer> instPkRelationFound1 = new ArrayList<Integer>();
		
		instPkRelationFound1 = foundRelation(relationalTable, pk1AttSearchOrder, pkAttCompareInst, pkValueCompare);
		Iterator<Integer> iter1 = instPkRelationFound1.iterator();
		
		while(iter1.hasNext())
		{
			int i1 = iter1.next();
			inst.addOrder(selectOrder(i1));
	
		}
		
		//relation instrument-machinery
		relationalTable = "instrument_machinery";
		String pkAttSearchMach = "machineryID";
		pkAttCompareInst = "instrumentID";
		
		
		ArrayList<Integer> instPkRelationFound2 = new ArrayList<Integer>();
		
		instPkRelationFound2 = foundRelation(relationalTable, pkAttSearchMach, pkAttCompareInst, pkValueCompare);
		Iterator<Integer> iter2 = instPkRelationFound2.iterator();
		
		while(iter2.hasNext()){
			int i2 = iter2.next();
			System.out.printf("%d",i2);
			inst.addMachinery(selectMachinery(i2));

		}
		
		//relation instrument-warehouse
		
		
		
		return inst;		
	}
	
	public Warehouse setWarehouseRelations(Warehouse war){
		
		//relation material
		ArrayList<Material>allMaterials = selectAllMaterials();
		Iterator<Material> iter = allMaterials.iterator();
		while(iter.hasNext()){
			Material mat = iter.next();
			if(mat.getWarehouse().getWarehouseID() == war.getWarehouseID()){
				war.addMaterial(mat);
			}
		}
		
		//relation instrument
		ArrayList<Instrument>allInstruments = selectAllInstruments();
		Iterator<Instrument> iter2 = allInstruments.iterator();
		while(iter2.hasNext()){
			Instrument inst = iter2.next();
			if(inst.getWarehouse().getWarehouseID() == war.getWarehouseID()){
				war.addInstrument(inst);;
			}
		}
		
			
		return war;
	}
	
	public Machinery setMachineryRelations(Machinery mach)
	{
		//relation employee
		ArrayList<Employee>allEmployees = selectAllEmployees();
		Iterator<Employee> iter1 = allEmployees.iterator();
		while(iter1.hasNext())
		{
			Employee a = iter1.next();
			if(a.getMachineryID().getMachineryID() == mach.getMachineryID())
			{
				mach.addEmployee(a);
			}
		}
		
		//relation material
		ArrayList<Material>allMaterials = selectAllMaterials();
		Iterator<Material> iter2 = allMaterials.iterator();
		
		while(iter2.hasNext())
		{
			Material b = iter2.next();
			if(mach.getMachineryID() == b.getMachineryID().getMachineryID())
			{
				mach.addMaterial(b);
			}
		}	
		//Instrument List
		String relationalTable = "instrument_machinery";
		String pkAtributeS = "instrumentID";
		
		String pkAttCompare = "machineryID";
		int pkValueCompare = mach.getMachineryID();
		
		ArrayList<Integer> machineryPkRelationFound = new ArrayList<Integer>();
		machineryPkRelationFound = foundRelation(relationalTable,pkAtributeS, pkAttCompare, pkValueCompare);
		
		Iterator<Integer> iter = machineryPkRelationFound.iterator();
		while(iter.hasNext())
		{
			int i = iter.next();
			mach.addInstrument(selectInstrument(i));

		}
		
		return mach;
	}
	
	public Company setCompanyRelations(Company com){
		//insert the materials
		ArrayList<Material> allMaterials = selectAllMaterials();
		
		Iterator<Material> iter = allMaterials.iterator();
		while(iter.hasNext()){
			Material aux = iter.next();
			if(aux.getCompany().getCompanyID() == com.getCompanyID()){
				com.addMaterial(aux);
			}
		}
		return com;
	}
	
	//Insert relations Tables
	
	public void setRelationHospitalOrder(int hosp, int order)
	{
		
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertHospitalOrderRelation( hosp, order);
		
	}
		
	public void setRelationInstrumentOrder(int inst, int ord)
	{
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertInstrumentOrderRelation(inst,ord);
	}
		
	public void setRelationInstrumentMachinery(int instID, int machID){
		
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertMachineryInstrumentRelation(instID,machID);
		
	}
	
			
	//Relation Help Methods
	public ArrayList<Integer> foundRelation(String table,String pk1AttributeSearch,String pkAttributeCompare ,int pkValueCompare)
	{
		String query = "SELECT "+pk1AttributeSearch+" FROM "+table+" WHERE "+pkAttributeCompare+"=?";
		
		ArrayList<Integer> pkArray = new ArrayList<Integer>();
		
		JDBCSearch sqlSearch = new JDBCSearch(c);
		
		pkArray = sqlSearch.searchPkRelation(query, pkValueCompare, pk1AttributeSearch);
		
		return pkArray;
		
	}
		
	public boolean sharedRelation(String table,String pk1AtrivuteSearch,String pkAtrivuteCompere ,Integer pkValueCompere)
	{
		boolean a = false;
		ArrayList<Integer> b = foundRelation(table,pk1AtrivuteSearch,pkAtrivuteCompere,pkValueCompere);
		
		if(b.size()<=1)
		{
			a = false;
		}else
		{
			a = true;
		}
		return a;
	}
	
	
 	//DB management Methods
	
	private LocalDate StringtoLocalDate(String year,String month,String day)
	{
		String fullDate = ""+year+"-"+month+"-"+day+"";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate locDate = LocalDate.parse(fullDate, formatter);
		return locDate;
	}
	
	public boolean valExist(String query, int pkInt, String pkString)
	{
		
		boolean a;
		
		 JDBCSearch sel = new JDBCSearch(c);
		
		
		if(pkString == null)
		{
			a = sel.valPKInt(query,pkInt);
		}
		else
		{
			a = sel.valPKString(query,pkString);
		}
		
	
		return a;
		
	}//
	
	public boolean valExist(String query)
	{
		
		 boolean bool;
		 JDBCSearch sel = new JDBCSearch(c);
		 
		 bool = sel.valGen(query);
		 
		return bool;
	}
	
	private java.sql.Date LocaltoSqlDate(LocalDate locDate) 
	{
		java.sql.Date sqlDate;
		sqlDate = java.sql.Date.valueOf(locDate);
		return sqlDate;
		    
	}

}
