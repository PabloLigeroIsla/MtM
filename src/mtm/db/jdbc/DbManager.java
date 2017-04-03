package mtm.db.jdbc;

import mtm.db.pojos.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	public Instrument createPojoInstrument (String model, String purpose, Integer amount, Integer numberUses, String bodyLocation, Integer price) 
	{
		Instrument instrument = new Instrument(model,purpose,amount,numberUses,bodyLocation,price);
		return instrument;
	}
	
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
	
	//Method to Create the tables
	
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
	
	//Method to Insert
	
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
	//Method to Delete
	
	//Pablo
	public void deleteHospital(int primaryKey)
	{
		
		String sqlQuery = "SELECT * FROM hospital WHERE hospital_ID == ?";
		if(valExist(sqlQuery,primaryKey,null))
		{
			SQLDelete sqlDelete = new SQLDelete();
			Connection c = openConnection();
			sqlDelete.deleteHospital(c,primaryKey);
			closeConnection(c);
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
		}
		else
		{
			System.out.println("\n The Order does not exist \n");
		}
	}
	
	//Celia
	
	//Charo
	
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
		String selQuarry = "SELECT name FROM "+table+" WHERE hospital_ID == ?";
		
		
		if(valExist(selQuarry,primaryKey,null))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Hospital hosp = new Hospital();
	 		
			Connection c = openConnection();
			hosp = sqlSelect.selectHospital(c,selQuarry,primaryKey);
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
	
}
