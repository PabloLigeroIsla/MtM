package mtm.db.jdbc;

import mtm.db.pojos.*;
import mtm.db.Interface.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.format.DateTimeFormatter;


public class JDBCManager implements DBInterface
{
	
	public Connection c = null;
	
	//Methods to create the Pojos
	
	public Order createPojoOrder(int number,String d11,String d12,String d13,String d21,String d22,String d23)
	{
		LocalDate date1SQL = StringtoLocalDate(d13,d12,d11);
		LocalDate date2SQL = StringtoLocalDate(d23,d22,d21);
		Order ord = new Order(number,date1SQL,date2SQL);
		return ord;
	}
	
	public Machinery createPojoMachinery(String machineryType, String stateofMachinery,String d,String m, String y, int sizeofMachinery){
		
		LocalDate date3SQL = StringtoLocalDate(y,m,d);
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
	public void createTableHospital()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableHospital();
		
		
	}
	public void createTableOrder()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableOrder();
		
	}
	public void createTableCompany()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableCompany();
		
	}
	public void createTableEmployee()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableEmployee();
		
	}
	public void createTableInstrument()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableInstrument();
		
	}
	public void createTableMachinery()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		codeCreate.createTableMachinery();
		
	}
	public void createTableMaterial()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableMaterial();
		
	}
	public void createTableWarehouse()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		
		codeCreate.createTableWarehouse();
		
	}
	//Relational Tables
	public void createTableHospitalOrder()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		codeCreate.createTableHospitalOrders();
	}
	
	public void createTableInstrumentOrder()
	{
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		codeCreate.createTableInstrumentOrders();
		
	}
	
	public void createTableInstrumentMachinery(){
	
		JDBCCreate codeCreate = new JDBCCreate(c);
		
		codeCreate.createTableInstrumentMachinery();
		
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
		
		String sqlQuery = "SELECT * FROM hospital WHERE hospital_ID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteHospital(primaryKey);
			
			//We delate the corresponding orders related with the hospital
			
			String relationalTable = "hospital_orders";
			String pk1AttributeSearch = "order_ID";
			String pkAttributeCompere = "hospital_ID";
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
		String sqlQuery = "SELECT * FROM orders WHERE order_ID = ?";
		
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteOrder(primaryKey);
			
			//We also delete the relation
			String table = "hospital_orders";
			String  pk1AtributeSearch = "hospital_ID";
			String pkAtributeCompere = "order_ID";
			int pkValueCompere = primaryKey;
			if(!sharedRelation(table, pk1AtributeSearch, pkAtributeCompere, pkValueCompere))
			{
				
				String colPk = "order_ID";
				deleteRelationHospitalOrder(primaryKey,colPk);
			}
			
			
			table = "instrument_orders";
			pk1AtributeSearch = "order_ID";
			pkAtributeCompere = "order_ID";
			pkValueCompere = primaryKey;
			if(!sharedRelation(table, pk1AtributeSearch, pkAtributeCompere, pkValueCompere))
			{
				String colPk = "order_ID";
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
		
		String sqlQuery = "SELECT * FROM employee WHERE employee_ID = ?";
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
		
		String sqlQuery = "SELECT * FROM instrument WHERE instrument_ID = ?";
		if(valExist(sqlQuery,primaryKeyInstrument,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			
			sqlDelete.deleteInstrument(primaryKeyInstrument);
			
			
			// We also delete the relation with the order in which it is contained
			
			String table = "instruments_order";
			String pk1AtSearch = "order_ID";
			String pk1Compare = "instrument_ID";
			int pkValueCompare = primaryKeyInstrument;
			if(!sharedRelation(table, pk1AtSearch, pk1Compare, pkValueCompare))
			{
				sqlDelete.deleteInstrument(primaryKeyInstrument);
				
				String colPk = "instrument_ID";
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
		
		String sqlQuery = "SELECT * FROM warehouse WHERE warehouse_ID = ?";
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
		String sqlQuery = "SELECT * FROM company WHERE company_ID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			JDBCDelete sqlDelete = new JDBCDelete(c);
			sqlDelete.deleteCompany(primaryKey);
			
			//delete relations
			ArrayList <Integer> arrayPks = foundRelation("material","material_ID","company_ID",primaryKey);
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
		String sqlQuery = "SELECT * FROM material WHERE material_ID = ?";
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
			if(emp.getMachineryType().getMachineryID() == pkMachinery)
			{
				deleteEmployee(pkMachinery);
			}
		}
	}
	
 	public void deleteRelationInstrumentWarehouse(int instID, int warID){
		try {
		String table = "instrument_warehouse";
		String sql = "DELETE FROM"+table+"WHERE instrument_ID="+instID;
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
		String selQuery = "SELECT * FROM "+table+" WHERE hospital_ID = ?";
		
		
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
		String selQuery = "SELECT * FROM orders WHERE order_ID = ?";
		
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
 		String selQuery = "SELECT * FROM company WHERE company_ID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Company comp = new Company();
	 	
			comp= sqlSelect.selectCompany(selQuery,primaryKey);
			
			return comp;
		}else
		{
			System.out.println("We dont find the primary key\n");
			return null;
		}
 	}

 	public Material selectMaterial(int primaryKey){
 		String selQuery = "SELECT * FROM material WHERE material_ID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			JDBCSelect sqlSelect = new JDBCSelect(c);
	 		Material mat = new Material();
	 		
			mat= sqlSelect.selectMaterial(selQuery,primaryKey);

			
			return mat;
		}else
		{
			System.out.println("We dont find the primary key\n");
			return null;
		}
 	}

 	public Employee selectEmployee(int primaryKey)
 	{
 		String table = "employee";
 		String selQuarry = "SELECT * FROM "+table+" WHERE employee_ID = ?";
 		
 		
 		if(valExist(selQuarry,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		Employee emp = new Employee();
 	 		
 			emp = sqlSelect.selectEmployee(selQuarry,primaryKey);
 			
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
 		String selQuarry = "SELECT * FROM "+table+" WHERE machinery_ID = ?";
 		
 		
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
 		String selQuarry = "SELECT * FROM machinery WHERE machinery_ID = ?";
 		
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
 		String table = "instrument";
 		String selQuarry = "SELECT * FROM "+table+" WHERE instrument_ID = ?";
 		
 		
 		if(valExist(selQuarry,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		Instrument instrument = new Instrument();
 	 		
 			
 			instrument = sqlSelect.selectInstrument(selQuarry,primaryKey);
 			
 			
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
 		String selQuery = "SELECT * FROM "+table+" WHERE warehouse_ID = ?";
 			
 		if(valExist(selQuery,primaryKey,null))
 		{
 			JDBCSelect sqlSelect = new JDBCSelect(c);
 				
 			Warehouse warehouse = new Warehouse();
 			warehouse = sqlSelect.selectWarehouse(selQuery,primaryKey);
 			
 			return warehouse;
 		}else
 		{
 			System.out.println("/nWe dont find the primary key\n");
 				
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
 	
 	public ArrayList<Material> selectAllMaterials(){
 		ArrayList<Material> materialList = new ArrayList<Material>();
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 		
		materialList = sqlSelect.selectAllMaterials();

		
 		return materialList;
 	}
 	
 	public ArrayList<Employee> selectAllEmployees(){
	 		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		JDBCSelect sqlSelect = new JDBCSelect(c);
		
		emp = sqlSelect.selectAllEmployee();
		
		return emp;
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
 		JDBCSelect sqlSelect = new JDBCSelect(c);
 	 		
 	 	
 		instrumentList = sqlSelect.selectAllInstruments();
 			
 			
 		return instrumentList;
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
 		String selQuery = "SELECT name FROM "+table+" WHERE hospital_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 			
 			
 		}
 		
 	}
 	
 	public void updateOrder(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "orders";
 		String selQuery = "SELECT * FROM orders WHERE order_ID = ?";
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
 		String table = "machinery";
 		String selQuery = "SELECT name FROM "+table+" WHERE machinery_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateMachinery(pkSearch,workingState);

 		}

 	}
 	
 	public void updateMaterial(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "material";
 		String selQuery = "SELECT name FROM "+table+" WHERE material_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 			
 			
 		}
 		
 	}
 	
 	public void updateCompany(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "company";
 		String selQuery = "SELECT * FROM o WHERE company_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.update(table,colChange,stringChange,intChange,colSearch,pkSearch);
 		
 			
 		}
 		
 	}

 	public void updateWarehouse(int pkSearch, int filledSpaceUpdated)
 	{ 	
 		
 		String table = "warehouse";
		String selQuery = "SELECT warehouse_ID FROM "+table+" WHERE warehouse_ID = ?";
		if(valExist(selQuery,pkSearch,null))
		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateWarehouse(pkSearch,filledSpaceUpdated);
		}
 			
 		
 	} 	
 	
 	public void updateWarehouseL(int pkSearch, String locationUpdated)
 	{ 	
 		
 		String table = "warehouse";
		String selQuery = "SELECT warehouse_ID FROM "+table+" WHERE warehouse_ID = ?";
		if(valExist(selQuery,pkSearch,null))
		{
 		
 			JDBCUpdate sqlUpdate= new JDBCUpdate(c);
 			sqlUpdate.updateWarehouseL(pkSearch,locationUpdated);
		}
 			
 		
 	} 	

		
 	
	//Set ID's
	public Company setCompanyID(Company com){
		ArrayList <Company> arraycom = selectAllCompanies();
		Iterator<Company> iter = arraycom.iterator();
		int pkSearch = 0;
		while(iter.hasNext()){
			pkSearch = iter.next().getCompanyID();
		} 
		
		com.setCompanyID(pkSearch);
		
		return com;
	}
	
	public Hospital setHospitalID(Hospital hosp)
	{
		ArrayList <Hospital> arrayHosp = selectAllHospitals();
		Iterator<Hospital> iter = arrayHosp.iterator();
		int pkSearch = 0;
		while(iter.hasNext())
		{
			pkSearch = iter.next().getHospitalID();
		} 
		hosp.setHospitalID(pkSearch);
		return hosp;
	}

	public Order setOrderID(Order ord)
	{
		ArrayList<Order> arrayOrd = selectAllOrders();
		Iterator<Order> iter = arrayOrd.iterator();
		int pkSearch = 0;
		while(iter.hasNext())
		{
			pkSearch = iter.next().getOrderID();
		}
		
		ord.setOrderID(pkSearch);
		return ord;
	}
	
	public Instrument setInstrumentID(Instrument inst){
		ArrayList<Instrument> arrayinst = selectAllInstruments();
		Iterator<Instrument> iter = arrayinst.iterator();
		int pkSearch = 0;
		while(iter.hasNext()){
			pkSearch = iter.next().getInstrumentID();
		}
		inst.setInstrumentID(pkSearch);
		return inst;
	}
	
	public Warehouse setWarehouseID(Warehouse war){
		ArrayList<Warehouse> arrayWar = selectAllWarehouses();
		Iterator<Warehouse> iter = arrayWar.iterator();
		int pkSearch = 0;
		while(iter.hasNext()){
			pkSearch = iter.next().getWarehouseID();
		}
		war.setWarehouseID(pkSearch);
		return war;
	}

	public Machinery setMachineryID(Machinery mach)
	{
		ArrayList<Machinery> arrayMach = selectAllMachineries();
		Iterator <Machinery> iter = arrayMach.iterator();
		int pkSearch = 0;
		while(iter.hasNext())
		{
			pkSearch = iter.next().getMachineryID();
		}
		
		mach.setMachineryID(pkSearch);
		return mach;
	}
	
	//SetRelations
	
	//Pojos
	public Hospital setHospitalRelations(Hospital hosp)
	{
		String relationalTable = "hospital_orders";
		String pk1AtributeSearch = "order_ID";
		String pkAtributeCompere = "hospital_ID";
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
		String pkAtributeCompere = "order_ID";
		int pkValueCompere = ord.getOrderID();
		
		//Hospital List
		String relationalTable = "hospital_orders";
		String pk1AtributeSearch = "hospital_ID";
		
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
		pk1AtributeSearch = "instrument_ID";
		
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
		
		//relation instrument-orders
		String relationalTable = "instrument_orders";
		String pk1AttSearchOrder = "order_ID";
		
		String pkAttCompare = "instrument_ID";
		int pkValueCompare = inst.getInstrumentID();
		
		ArrayList<Integer> instPkRelationFound = new ArrayList<Integer>();
		instPkRelationFound = foundRelation(relationalTable, pk1AttSearchOrder, pkAttCompare, pkValueCompare);
		Iterator<Integer> iter = instPkRelationFound.iterator();
		while(iter.hasNext()){
			int i = iter.next();
			inst.addOrder(selectOrder(i));
		}
		
		//relation instrument-machinery
		relationalTable = "instrument_machinery";
		String pkAttSearchMach = "machinery_ID";
		
		instPkRelationFound = foundRelation(relationalTable, pkAttSearchMach, pkAttCompare, pkValueCompare);
		iter = instPkRelationFound.iterator();
		while(iter.hasNext()){
			int i = iter.next();
			inst.addMachinery(selectMachinery(i));
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
			if(mat.getWarehouseID() == war.getWarehouseID()){
				war.addMaterial(mat);
			}
		}
		
		//relation instrument
		ArrayList<Instrument>allInstruments = selectAllInstruments();
		Iterator<Instrument> iter2 = allInstruments.iterator();
		while(iter2.hasNext()){
			Instrument inst = iter2.next();
			if(inst.getWarehouseID() == war.getWarehouseID()){
				war.addInstrument(inst);;
			}
		}
		
			
		return war;
	}
	
	public Machinery setMachineryRelations(Machinery mach){
		//relation employee
		ArrayList<Employee>allEmployees = selectAllEmployees();
		Iterator<Employee> iter1 = allEmployees.iterator();
		while(iter1.hasNext()){
			Employee a = iter1.next();
			if(a.getMachineryType().getMachineryID() == mach.getMachineryID()){
				mach.addEmployee(a);
			}
		}
		
		//relation material
		ArrayList<Material>allMaterials = selectAllMaterials();
		Iterator<Material> iter2 = allMaterials.iterator();
		while(iter2.hasNext()){
			Material b = iter2.next();
			if(b.getMachineryID() == mach.getMachineryID()){
				mach.addMaterial(b);
			}
		}
		
		
		//Instrument List
		String relationalTable = "instrument_machinery";
		String pkAtributeS = "instrument_ID";
		
		String pkAttCompare = "machinery_ID";
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
			if(aux.getCompanyID() == com.getCompanyID()){
				com.addMaterial(aux);
			}
		}
		return com;
	}
	
	//Insert relations Tables
	
	public void setRelationHospitalOrder(int hosp, int order, int amOrd)
	{
		
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertHospitalOrderRelation( hosp, order, amOrd);
		
	}
		
	public void setRelationInstrumentOrder(int inst, int ord)
	{
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertInstrumentOrderRelation(inst,ord);
	}
		
	public void setRelationInstrumentMachinery(int instID, int machID, int time){
		
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertMachineryInstrumentRelation(instID,machID,time);
		
	}
	
	public void setRelationInstrumentWarehouse(int instID, int warID){
		JDBCInsert sqlInsert = new JDBCInsert(c);
		sqlInsert.insertInstrumentWarehouseRelation(instID,warID);
		
	}
			
	//Relation Help Methods
	public ArrayList<Integer> foundRelation(String table,String pk1AttributeSearch,String pkAttributeCompare ,int pkValueCompare)
	{
		String query = "SELECT "+pk1AttributeSearch+" FROM "+table+" WHERE "+pkAttributeCompare+" = ?";
		
		ArrayList<Integer> pkArray = new ArrayList<Integer>();
		
		JDBCSearch sqlSearch = new JDBCSearch(c);
		
		pkArray=sqlSearch.searchPkRelation(query, pkValueCompare, pk1AttributeSearch);
		
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
		
	}
	
}
