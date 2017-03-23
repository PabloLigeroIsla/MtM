package mtm.db.jdbc;

import java.sql.Connection;
import java.sql.Statement;

public class SQLCreate 
{
	
	public void createTables(Connection c)
	{
		try
		{
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
			//Alex
			
			//Charo
			
			//Celia
			
			
		}catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("Conection Error, Ask Rodrigo for Help");
		
		}
		
	}
	

	//Pablo
	
	//Charo
	
	//Celia
	
	//Alex
}
