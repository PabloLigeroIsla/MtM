package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SQLCreate 
{
	public static void main()
	{
		try
		{
	//Open Data Base Connection
	Class.forName("org.sqlite.JDBC");
	Connection c = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
	c.createStatement().execute("PRAGMA foreign_keys=ON");
	System.out.println("Database connection opened.");
			
			//Charo
			
			
			//Celia
			
			
			//Alejandro
			
			
			//Pablo
			
	//Close the Data Base Connection
	c.close();
	System.out.println("Database connection closed.");
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
			
		}
	}
}
