package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;
import java.util.ArrayList;
import mtm.db.jdbc.DbManager;
import mtm.db.pojos.*;

 class EclipseInterface 
{
	 
	static DbManager dbManager = new DbManager();
	 
	public static void main(String args[]) 
	{
		
		//Object jdbc
		
		
		int option;
		do{
			//Start of the db
			option = openMenu();
		
			switch(option)
				{
			
				case 1:
					createTables();
					waitEnter();
					break;
				case 2:
					showObject();
					waitEnter();
				case 3:
					intValTable();
					waitEnter();
					break;
				case 4:
					
					waitEnter();
					break;
				case 5:
					
					waitEnter();
					break;
				case 6:
					waitEnter();
					break;
				case 7:
					waitEnter();
					break;
				case 8:
					waitEnter();
					break;
				case 9:
					waitEnter();
					break;
				case 10:
					waitEnter();
					break;
				case 11:
					waitEnter();
					break;
				case 12:
					System.out.println("The End");
					waitEnter();
					break;
				}
		}while(option!=12);
	}


	//User Methods
	public static int openMenu()
	{
		int option;
		int numOptions = 6; //Numero de opciones que podemos seleccionar con esta funci�n
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void printMenu()
	{
		//Si a�ades opciones, recuerda mirar el metodo abrirMenu
		System.out.println("Option 1.- Create Tables\n"
				+ "Option 2.- Show tables\n"
				+ "Option 3.- Introduce values to a Table\n"
				+ "Option 4.- Delete value of a Table\n"
				+ "Option 5.- Drop Table\n\n"
				+ "Option 6.-\n"
				+ "Option 7.-\n"
				+ "Option 8.-\n"
				+ "Option 9.-\n"
				+ "Option 10.-\n"
				+ "Option 11.-\n"
				+ "Option 12.- Exit");
	}
	
	//Data Base Methods
	
	public static void createTables()
	{
		
		System.out.println("Option 1: Create all tables\n"
				+ "Option 2: Create 1 specific table\n"
				+ "Option Selected: ");
		int option = writeNumber(2);
		if(option == 1)
		{
			//Option 1: All the tables
			dbManager.createTables();
		}else
		{
		//Select if we want to create one specific table or all the tables
			System.out.println("\n\nSelect the table you want to create:\n"
				+ "1:Company\n"
				+ "2:Employee\n"
				+ "3:Hospital\n"
				+ "4:Instrument\n"
				+ "5:Machinery"
				+ "6:Material\n"
				+ "7:Order\n"
				+ "8:Warehouse\n"
				+ "Introduce Option number: ");
			option = writeNumber(8);
			
			switch(option)
			{
			case 1:
				dbManager.createTableCompany();
				break;
			case 2:
				dbManager.createTableEmployee();
				break;
			case 3:
				dbManager.createTableHospital();
				break;
			case 4:
				dbManager.createTableInstrument();
				break;
			case 5:
				dbManager.createTableMachinery();
				break;
			case 6:
				dbManager.createTableMaterial();
				break;
			case 7:
				dbManager.createTableOrder();
				break;
			case 8:
				dbManager.createTableWarehouse();
				break;
			}
			
			
		}
		
	}

	public static void intValTable()
	{
		System.out.println("\n\nSelect the table where you want to introduce a value:\n"
				+ "1:Company\n"
				+ "2:Employee\n"
				+ "3:Hospital\n"
				+ "4:Instrument\n"
				+ "5:Machinery"
				+ "6:Material\n"
				+ "7:Order\n"
				+ "8:Warehouse\n"
				+ "Introduce Option number: ");
		int  option = writeNumber(8);
		
		switch(option)
		{
		case 1:
			//In hospital we have 1 int and 3 Strings (int is the primary key with the autoincrement)
			System.out.println("\nName of the hosital:");
			String a = writeString();
			System.out.println("\nLocation of the Hospital: ");
			String b = writeString();
			System.out.println("\nMedical Specialization of he hospital:");
			String c = writeString();
			Hospital hosp= new Hospital(a,b,c);
			dbManager.insert(hosp);
			break;
		case 2:
			//In Order we have 2 ints and 2 Strings (The first int is the primary key)
			System.out.println("\nTotal Amount of Instruments\n");
			int d = writeNumber();
			
			String d1[] = new String[2];
			String d2[] = new String[2];
			
			System.out.println("\nOrder Date\n");
			d1 = createDate();
			System.out.println("Delivery Date");
			d2 = createDate();

			dbManager.insert(dbManager.createPojoOrder(d,d1[0],d1[1],d1[2],d2[0],d2[1],d2[2]));
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
		
		
	}
	//Extra Methods

    public static void showObject()
    {
    	//Option is set to select the table, and Option1 is set to print a list or one object
    	int option,option1;
    	System.out.println("\n\nSelect the table you want to show:\n"
				+ "1:Company\n"
				+ "2:Employee\n"
				+ "3:Hospital\n"
				+ "4:Instrument\n"
				+ "5:Machinery"
				+ "6:Material\n"
				+ "7:Order\n"
				+ "8:Warehouse\n"
				+ "Introduce Option number: ");
    	option = writeNumber(8);
    	
    	System.out.println("\nSelect one option:\n"
    			+ "1:Print just one Object\n"
    			+ "2:Print the whole table of Objects");
    	System.out.println("\n\n");
    	option1 = writeNumber(2);
    	
    	switch(option)
    	{
    	case 1:
    		break;
    	case 2:
    		break;
    	case 3:
    		Hospital hosp = new Hospital();
    		if(option1 == 1)
    		{
    			int pk = writeNumber();
    			hosp = dbManager.selectHospital(pk);
    			hosp.toString();
    			
    		}else
    		{
    			ArrayList<Hospital> hospList = new ArrayList<Hospital>();
    			hospList = dbManager.selectHospitals();
    			
    			int count= 0;
    			
    			while(count < hospList.size())
    			{
    				hosp = hospList.get(count);
    				hosp.toString();
    			}
    		}
    		break;
    	case 4:
    		break;
    	case 5:
    		break;
    	case 6:
    		break;
    	case 7:
    		break;
    	case 8:
    		break;
    	}
    }
}