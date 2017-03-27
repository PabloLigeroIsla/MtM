package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;
import java.io.IOException;
import mtm.db.jdbc.DbManager;

 class EclipseInterface 
{
	 
	 static DbManager dbManager = new DbManager();
	 
	public static void main()
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
				case 2:
					
					waitEnter();
				case 3:
					intValTable();
					waitEnter();
				case 4:
					
					waitEnter();
				case 5:
					
					waitEnter();
				case 12:
					System.out.println("The End");
					waitEnter();
				}
		}while(option!=12);
	}


	//User Methods
	public static int openMenu()
	{
		int option;
		int numOptions = 6; //Numero de opciones que podemos seleccionar con esta función
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void printMenu()
	{
		//Si añades opciones, recuerda mirar el metodo abrirMenu
		System.out.println("Option 1.- Create Tables\n"
				+ "Option 2.- Show tables\n"
				+ "Option 3.- Introduce values to a Table\n"
				+ "Option 4.- Delete value of a Table\n"
				+ "Option 5.- Drop Table"//Method to select one of the the table
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
			case 2:
				dbManager.createTableEmployee();
			case 3:
				dbManager.createTableHospital();
			case 4:
				dbManager.createTableInstrument();
			case 5:
				dbManager.createTableMachinery();
			case 6:
				dbManager.createTableMaterial();
			case 7:
				dbManager.createTableOrder();
			case 8:
				dbManager.createTableWarehouse();
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
			dbManager.insert(dbManager.createPojoHospital(a,b,c));
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
		
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		}
		
		
	}
	
	//Extra Methods
    public static void waitEnter()
    {	
        System.out.println("Press enter to continue: \n");
        try{
            String a = c.readLine();
            a = a+"a";
        }catch(IOException ex){
        	ex.printStackTrace();
        }
    }
}