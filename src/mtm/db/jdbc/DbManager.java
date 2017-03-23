package mtm.db.jdbc;

import mtm.db.pojos.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class DbManager 
{
	// 8 Objects
	//Different Methods to interact with the dataBase
	
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
		codeCreate.createTableMachnery(c);
		closeConnection(c);
	}
	public void createTableMaterial()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableMachinery(c);
		closeConnection(c);
	}
	public void createTableWharhouse()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTableWarehouse(c);
		closeConnection(c);
	}
	
	//Method to Insert
	
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
	
	//Method to Delete
	
	public void delete(Hospital obj)
	{
		SQLDelete del = new SQLDelete();
		
	}
	public void delete(Order obj)
	{
		SQLDelete del = new SQLDelete();
		
	}
	
	
	
	//Method to Drop
	
	
}
