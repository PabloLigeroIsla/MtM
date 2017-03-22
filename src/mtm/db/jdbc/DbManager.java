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
	
	public void dbCreateTables()
	{
		SQLCreate codeCreate = new SQLCreate();
		
		Connection c = openConnection();
		codeCreate.createTables(c);
		closeConnection(c);
		
	}
	
	//Method to Insert
	
	public void dbInsert(Hospital hos)
	{
		SQLInsert codeInsert = new SQLInsert();
	}
	public void dbInsert(Order order)
	{
		SQLInsert codeInsert = new SQLInsert();
	}
	
	//Method to Delete
	
	public void dbDelete()
	{
		SQLDelete del = new SQLDelete();
		
	}
	
	
	
	//Method to Drop
	
	
}
