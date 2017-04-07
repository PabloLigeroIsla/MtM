package mtm.db.jdbc;

import mtm.db.pojos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.Date;

public class DbManager 
{
	// 8 Objects
	//Different Methods to interact with the dataBase
	//Different Methods to create the Objects
	
	//Methods to create the Pojos

	
	public Order createPojoOrder(int number,String d11,String d12,String d13,String d21,String d22,String d23)
	{
		Date date1SQL = dateConverterSQL(d13,d12,d11);
		Date date2SQL = dateConverterSQL(d23,d22,d21);
		Order ord = new Order(number,date1SQL,date2SQL);
		return ord;
	}
	
	//Charo
	public Instrument createPojoInstrument (String model, String purpose, Integer amount, Integer numberUses, String bodyLocation, Integer price, Warehouse warehouseID) 
	{
		Instrument instrument = new Instrument(model,purpose,amount,numberUses,bodyLocation,price,warehouseID);
		return instrument;
	}//DEBO QUITAR WAREHOUSE???
	
	public Warehouse createPojoWarehouse (String warehouseLocation, Integer capacity, Integer filledSpace)
	{
		Warehouse warehouse = new Warehouse (warehouseLocation,capacity,filledSpace);
		return warehouse;
	}
	//Alex
	
	//Celia
	public Employee createPojoEmployee(int employeeID,String name, String typeofContract, String specializationType )
	{
		Employee emp = new Employee(employeeID,name,typeofContract,specializationType);
		return emp;
		
	}
	
	//public Machinery createPojoMachinery(String machineryType,String stateofMachinery, String d,String m,String y,int sizeofMachinery){
		
		//Date date3SQL = dateConverterSQL(d,m,y);
		//Machinery mach = new Machinery (machineryType, stateofMachinery, d, m, y, sizeofMachinery);
		//return mach;
		
	//}
	
	//Methods to connect with the DataBase
	public Connection openConnection()
	{
		Connection c = null;
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
	
	public void closeConnection(Connection c)
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
	
	//Methods to Create the tables
	
	public void createTables()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTables(c);
		closeConnection(c);
		
	}
	public void createTableHospital()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableHospital(c);
		closeConnection(c);
		
	}
	public void createTableOrder()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableOrder(c);
		closeConnection(c);
	}
	public void createTableCompany()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableCompany(c);
		closeConnection(c);
	}
	public void createTableEmployee()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableEmployee(c);
		closeConnection(c);
	}
	public void createTableInstrument()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableInstrument(c);
		closeConnection(c);
	}
	public void createTableMachinery()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableMachinery(c);
		closeConnection(c);
	}
	public void createTableMaterial()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableMachinery(c);
		closeConnection(c);
	}
	public void createTableWarehouse()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableWarehouse(c);
		closeConnection(c);
	}
		//Relational Tables
	public void createTableHospitalOrder()
	{
		SQLCreate codeCreate = new SQLCreate();
		Connection c = openConnection();
		codeCreate.createTableHospitalOrders(c);
		closeConnection(c);
	}
	
	public void createTableInstrumentOrder()
	{
		SQLCreate codeCreate = new SQLCreate();
		Connection c = openConnection();
		codeCreate.createTableInstrumentOrders(c);
		closeConnection(c);
	}
	
	//Methods to Insert
	
	//Pablo
	public void insert(Hospital obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		String selQuery = "SELECT * FROM hospital WHERE name LIKE ?";
		if(valExist(selQuery,-1,obj.getName()))
		{
			System.out.println("This Hospital exist");
		}else
		{
			Connection c = openConnection();
			codeInsert.insert(obj,c);
			closeConnection(c);
		}
		
	}
	public void insert(Order obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	
	//Charo
	
	public void insert(Instrument obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	
	public void insert(Warehouse obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	//Alex
	
	//Celia
	
	public void insert(Employee obj)
	{
		SQLInsert codeInsert = new SQLInsert();

			Connection c = openConnection();
			codeInsert.insert(obj,c);
			closeConnection(c);
		
		
	}
	public void insert(Machinery obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	
	//Methods to Delete
	
	//Pablo
	public void deleteHospital(int primaryKey)
	{
		
		String sqlQuery = "SELECT * FROM hospital WHERE hospital_ID = ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			SQLDelete sqlDelete = new SQLDelete();
			Connection c = openConnection();
			sqlDelete.deleteHospital(c,primaryKey);
			closeConnection(c);
			//We delate the corresponding orders related with the hospital
			
			String relationalTable = "hospital_orders";
			String pk1AttributeSearch = "order_ID";
			String pkAttributeCompere = "hospital_ID";
			int pkValueCompare = primaryKey;
			
			ArrayList<Integer> orderPkRelationFound = new ArrayList<Integer>();
			orderPkRelationFound = foundRelation(relationalTable,pk1AttributeSearch,pkAttributeCompere,pkValueCompare);
			
			Iterator<Integer> iter = orderPkRelationFound.iterator();
			while(iter.hasNext())
			{
				int i = iter.next();
				deleteOrder(i);
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
		String sqlQuery = "SELECT * FROM orders WHERE order_ID == ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			SQLDelete sqlDelete = new SQLDelete();
			Connection c = openConnection();
			sqlDelete.deleteOrder(c,primaryKey);
			closeConnection(c);
			
			//We also delete the relation
			String table = "hospital_orders";
			String  pk1AtrivuteSearch = "order_ID";
			String pkAtrivuteCompere = "order_ID";
			int pkValueCompere = primaryKey;
			if(!sharedRelation(table, pk1AtrivuteSearch, pkAtrivuteCompere, pkValueCompere))
			{
				String colPk = "order_ID";
				deleteRelationHospitalOrder(primaryKey,colPk);
			}
			

		}
		else
		{
			System.out.println("\n The Order does not exist \n");
		}
	}
	
	//Celia
	
	//Charo
	
	public void deleteInstrument(int primaryKeyInstrument)
	{
		
		String sqlQuery = "SELECT * FROM instrument WHERE instrumentID = ?";
		if(valExist(sqlQuery,primaryKeyInstrument,null))
		{
			SQLDelete sqlDelete = new SQLDelete();
			Connection c = openConnection();
			sqlDelete.deleteHospital(c,primaryKeyInstrument);
			closeConnection(c);
			
			// We also delete the relation with the order in which it is contained
			//We also need to delete the relation between the order just deleted and the hospital which orders it
			
			// hago el metodo que me de la pk de los orders relacionados con ese instrument, elimino la relacion intrument-order
			
		}
		else
		{
			System.out.println("\n The instrument does not exist \n");
		}
		
	}
	
	public void deleteWarehouse(int primaryKeyWarehouse)
	{
		
		String sqlQuery = "SELECT * FROM instrument WHERE instrumentID = ?";
		if(valExist(sqlQuery,primaryKeyWarehouse,null))
		{
			SQLDelete sqlDelete = new SQLDelete();
			Connection c = openConnection();
			sqlDelete.deleteHospital(c,primaryKeyWarehouse);
			closeConnection(c);
		}
		else
		{
			System.out.println("\n The warehouse does not exist \n");
		}
		
	}
	
	//Alex
	
	//Method to Select
	public ArrayList<Hospital> selectHospitals()
	{
		ArrayList<Hospital> hosp = new ArrayList<Hospital>();
		SQLSelect sqlSelect = new SQLSelect();
		
		Connection c = openConnection();
		hosp = sqlSelect.selectAllHospitals(c);
		closeConnection(c);
		
		return hosp;
	}
 	public Hospital selectHospital(int primaryKey)
	{
		String table = "hosital";
		String selQuery = "SELECT name FROM "+table+" WHERE hospital_ID = ?";
		
		
		if(valExist(selQuery,primaryKey,null))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Hospital hosp = new Hospital();
	 		
			Connection c = openConnection();
			hosp = sqlSelect.selectHospital(c,selQuery,primaryKey);
			closeConnection(c);
			
			return hosp;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			
			return null;
		}
	}
 	public Hospital selectHospital(String nameHospital)
 	{
		String selQuarry = "SELECT location FROM hospital WHERE name LIKE ?";
		
		if(valExist(selQuarry,-1,nameHospital))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Hospital hosp = new Hospital();
	 		
			Connection c = openConnection();
			hosp = sqlSelect.selectHospital(c,selQuarry,nameHospital);
			closeConnection(c);
			
			return hosp;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			
			return null;
		}
 		
 	}
 	
 	public ArrayList<Order> selectAllOrders()
 	{
 		ArrayList<Order> orderList = new ArrayList<Order>();
 		SQLSelect sqlSelect = new SQLSelect();
 		
 		Connection c = openConnection();
		orderList = sqlSelect.selectAllOrders(c);
		closeConnection(c);
		
 		return orderList;
 	}
 	public Order selectOrder(int primaryKey)
	{
		String selQuery = "SELECT * FROM orders WHERE order_ID = ?";
		
		if(valExist(selQuery,primaryKey,null))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Order order = new Order();
	 		
			Connection c = openConnection();
			order= sqlSelect.selectOrder(c,selQuery,primaryKey);
			closeConnection(c);
			
			return order;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			return null;
		}
	}
 	
 	// Update
 	
 	//Pablo
 	public void updateHospital(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "hospital";
 		String selQuery = "SELECT name FROM "+table+" WHERE hospital_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			Connection c = openConnection();
 			SQLUpdate sqlUpdate= new SQLUpdate();
 			sqlUpdate.update(c,table,colChange,stringChange,intChange,colSearch,pkSearch);
 			closeConnection(c);
 			
 		}
 		
 	}
 	public void updateOrder(String colChange,String stringChange,int intChange,String colSearch,int pkSearch)
 	{
 		String table = "orders";
 		String selQuery = "SELECT * FROM orders WHERE order_ID = ?";
 		if(valExist(selQuery,pkSearch,null))
 		{
 			Connection c = openConnection();
 			SQLUpdate sqlUpdate= new SQLUpdate();
 			sqlUpdate.update(c,table,colChange,stringChange,intChange,colSearch,pkSearch);
 			closeConnection(c);
 			
 		}
 		
 	}
 	
 	//Charo
 	
 	//Celia
 	
 	//Alex
 	
	//Charo
 	
 	public Instrument selectInstrument(int primaryKey)
	{
		String table = "instrument";
		String selQuarry = "SELECT name FROM "+table+" WHERE instrumentID == ?";
		
		
		if(valExist(selQuarry,primaryKey,null))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Instrument instrument = new Instrument();
	 		
			Connection c = openConnection();
			instrument = sqlSelect.selectInstrument(c,selQuarry,primaryKey);
			closeConnection(c);
			
			return instrument;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			
			return null;
		}
	}

 	public ArrayList<Instrument> selectAllInstruments()
 	{
 		ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
 		SQLSelect sqlSelect = new SQLSelect();
 		
 		Connection c = openConnection();
 		instrumentList = sqlSelect.selectAllInstruments(c);
		closeConnection(c);
		
 		return instrumentList;
 	}
 	
 	
 	public Warehouse selectWarehouse(int primaryKey)
	{
		String table = "warehouse";
		String selQuarry = "SELECT name FROM "+table+" WHERE warehouseID == ?";
		
		
		if(valExist(selQuarry,primaryKey,null))
		{
			SQLSelect sqlSelect = new SQLSelect();
			Warehouse warehouse = new Warehouse();
	 		
			Connection c = openConnection();
			warehouse = sqlSelect.selectWarehouse(c,selQuarry,primaryKey);
			closeConnection(c);
			
			return warehouse;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			
			return null;
		}
	}
 	
 	
 	//DB management Methods
	
	private Date dateConverterSQL(String a,String b,String c) 
	{
		java.sql.Date finalDate = null;
		try
		{
			String input = "/"+a+"/"+b+"/"+c+"";
			
			java.sql.Date apptDay = null;
		    DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		    
		    apptDay = (Date) df.parse(input);
		    
		    finalDate = new Date(apptDay.getTime());
		}catch(ParseException e)
		{
			e.printStackTrace();
			System.out.println("Error in conversion");
		}
		
	    
		return finalDate;
	}
	
	public boolean valExist (String query, int pkInt, String pkString)
	{
		
		boolean a;
		
		SQLSearch sel = new SQLSearch();
		Connection c = openConnection();
		
		if(pkString == null)
		{
			a = sel.valPKInt(query,c,pkInt);
		}
		else
		{
			a = sel.valPKString(query,c,pkString);
		}
		
		closeConnection(c);
		return a;
		
	}
		
	//Relations
	public void setRelationHospitalOrder(int hosp, int order)
	{
		Connection c = openConnection();
		SQLInsert sqlInsert = new SQLInsert();
		sqlInsert.insertHospitalOrderRelation(c, hosp, order);
		closeConnection(c);
	}
	
	public void deleteRelationHospitalOrder(int pkCol,String colPk)
	{
		String table = "hospital_orders";
		Connection c = openConnection();
		SQLDelete sqlDelete = new SQLDelete();
		sqlDelete.deleteRelationNtoN(c, table, colPk, pkCol);
		closeConnection(c);
	}
	
	
	
	public Hospital setHospitalRelations(Hospital hosp)
	{
		String relationalTable = "hospital_orders";
		String pk1AtrivuteSearch = "order_ID";
		String pkAtrivuteCompere = "hospital_ID";
		int pkValueCompere = hosp.getHospitalID();
		
		
		ArrayList<Integer> orderPkRelationFound = new ArrayList<Integer>();
		orderPkRelationFound = foundRelation(relationalTable,pk1AtrivuteSearch,pkAtrivuteCompere,pkValueCompere);
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
	//Hacer create the tabla asociada instruments/order	
		String pkAtrivuteCompere = "order_ID";
		int pkValueCompere = ord.getOrderID();
		
		//Hospital List
		String relationalTable = "hospital_orders";
		String pk1AtrivuteSearch = "hospital_ID";
		
		ArrayList<Integer> hospitalPkRelationFound = new ArrayList<Integer>();
		hospitalPkRelationFound = foundRelation(relationalTable,pk1AtrivuteSearch,pkAtrivuteCompere,pkValueCompere);
		
		Iterator<Integer> iter = hospitalPkRelationFound.iterator();
		while(iter.hasNext())
		{
			int i = iter.next();
			ord.addHospital(selectHospital(i));
		}
		
		//Instrument List
		
		relationalTable = "instrument_orders";
		pk1AtrivuteSearch = "instrument_ID";
		
		ArrayList<Integer> instrumentPkRelationFound = new ArrayList<Integer>();
		instrumentPkRelationFound = foundRelation(relationalTable,pk1AtrivuteSearch,pkAtrivuteCompere,pkValueCompere);
		Iterator<Integer> iter2 = instrumentPkRelationFound.iterator();
		while(iter2.hasNext())
		{
			int i = iter2.next();
			ord.addInstrument(selectInstrument(i));
		}
	return ord;
	}
		
	//Relation Help Methods
	public ArrayList<Integer> foundRelation(String table,String pk1AtrivuteSearch,String pkAtrivuteCompere ,int pkValueCompere)
	{
		String query = "SELECT "+pk1AtrivuteSearch+" FROM "+table+" WHERE "+pkAtrivuteCompere+" = ?";
		
		ArrayList<Integer> pkArray = new ArrayList<Integer>();
		
		SQLSearch sqlSearch = new SQLSearch();
		Connection c = openConnection();
		pkArray=sqlSearch.searchPkRelation(c,query, pkValueCompere, pk1AtrivuteSearch);
		closeConnection(c);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
