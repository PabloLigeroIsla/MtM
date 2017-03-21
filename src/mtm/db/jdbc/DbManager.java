package mtm.db.jdbc;

public class DbManager {
	
	//Different Methods to interact with the dataBase
	
	//Method to Create the table
	
	public void dbCreateTables()
	{
		SQLCreate codeCreate = new SQLCreate();
		
	}
	
	//Method to Insert
	
	public void dbInsert()
	{
		SQLInsert codeInsert = new SQLInsert();
		
	}
	
	//Method to Delete
	
	public void dbDelete(<> at)
	{
		SQLDelete del = new SQLDelete();
		del.delObject(at);
	}
	
	//Method to Drop
	
	
}
