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
	//Pablo
	public Hospital createPojoHospital(String name,String loc,String med_sp)
	{
		Hospital hosp = new Hospital(name,loc,med_sp);
		return hosp;
	}
	
	public Order createPojoOrder(int number,String d11,String d12,String d13,String d21,String d22,String d23)
	{
		Date date1SQL = dateConverterSQL(d13,d12,d11);
		Date date2SQL = dateConverterSQL(d23,d22,d21);
		Order ord = new Order(number,date1SQL,date2SQL);
		return ord;
	}
	//Charo
	
	//Alex
	
	//Celia
	
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
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	public void insert(Order obj)
	{
		SQLInsert codeInsert = new SQLInsert();
		
		Connection c = openConnection();
		codeInsert.insert(obj,c);
		closeConnection(c);
	}
	
	//Charo
	
	//Alex
	
	//Celia
	
	
	//Method to Delete
	
	//Pablo
	//public void deleteHospital(int primaryKey)
	//{
		//String selectQuarry = null;
		//Connection c;
		
		//Search the hospital with the primary key in the database (method to search in table hospital)
			//selectQuarry = method used to search a value 
		//if(selectQuarry == null)
		//{
			//System.out.println("This PrimaryKey doesn't exit");
		//}else
		//{
			//c = openConnection();
				//SQLDelete del = new SQLDelete();
				//del.deleteHospital(primaryKey,selectQuarry,c);
				//closeConnection(c);
		//}			
	//}
	//public void deleteOrder(int primaryKey)
	//{
		//String selectQuarry = "";
		//Connection c;
		
		//Search the hospital with the primary key in the database (method to search in table hospital)
			//selectQuarry = method used to search a value 
		//if(selectQuarry == null)
		//{
			//System.out.println("This PrimaryKey doesn't exit");
		//}else
		//{
			//c = openConnection();
				//SQLDelete del = new SQLDelete();
				//del.deleteHospital(primaryKey,selectQuarry,c);
				//closeConnection(c);
		//}
		
	//}
	
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
		String pkHospital = "hospital_ID";
		String selQuarry = "SELECT name FROM "+table+" WHERE "+pkHospital+" = "+primaryKey+"";
		
		if(valExist(selQuarry))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Hospital hosp = new Hospital();
	 		
			Connection c = openConnection();
			hosp = sqlSelect.selectHospital(c,primaryKey);
			closeConnection(c);
			
			return hosp;
		}else
		{
			System.out.println("/nWe dont find the primary key/n");
			
			return null;
		}
	}
	
 	public Order selectOrder(int primaryKey)
	{
		String table = "orders";
		String pkHospital = "order_ID";
		String selQuery = "SELECT * FROM "+table+" WHERE "+pkHospital+" = "+primaryKey+"";
		
		if(valExist(selQuery))
		{
			SQLSelect sqlSelect = new SQLSelect();
	 		Order order = new Order();
	 		
			Connection c = openConnection();
			order= sqlSelect.selectOrder(c,primaryKey);
			closeConnection(c);
			
			return order;
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
	
	public boolean valExist (String query)
	{
		SQLSearch sel = new SQLSearch();
		
		Connection c = openConnection();
		boolean a = sel.valPK1(query,c);
		closeConnection(c);
		return a;
		
	}
	
}
