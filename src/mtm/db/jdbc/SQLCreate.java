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
	//NEED TO CHANGE, THIS IS WRONG (company.db should be owr data base, but we need to change the name)
	Class.forName("org.sqlite.JDBC");
	Connection c = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
	c.createStatement().execute("PRAGMA foreign_keys=ON");
	System.out.println("Database connection opened.");
			
			//Charo
			
			
			//Celia
			
			
			//Alejandro
			
			
			//Pablo
	        	// fPt -->firstPablotable //sqlp1 --> sqlpablo1
			Statement fPt = c.createStatement();
			String sqlp1 = "CREATE TABLE hospital("
					+ "hospital_ID    INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL,"
					+ "location TEXT NOT NULL,"
					+ "medical_specialization TEXT NOT NULL)";
			fPt.executeUpdate(sqlp1);
			fPt.close();
			
			Statement sPt = c.createStatement();
			String sqlp2 = "CREATE TABLE orders("
					+ "order_ID INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "total_amount_instruments INTEGER NOT NULL,"
					+ "order_date DATE NOT NULL,"
					+ "delivery_date DATE NOT NULL)";
			sPt.executeUpdate(sqlp2);
			sPt.close();
			
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
