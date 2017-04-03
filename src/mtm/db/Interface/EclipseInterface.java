package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;
import java.io.IOException;
import mtm.db.jdbc.DbManager;

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
			
		case 2:
			
		case 3:
			//In hospital we have 1 int and 3 Strings (int is the primary key with the autoincrement)
			System.out.println("\nName of the hosital:");
			String a = writeString();
			System.out.println("\nLocation of the Hospital: ");
			String b = writeString();
			System.out.println("\nMedical Specialization of he hospital:");
			String c = writeString();
			dbManager.insert(dbManager.createPojoHospital(a,b,c));
			break;
		case 4:
			//In instrument we have 3 ints, 3 Strings and 2 List
			
			//HOW DO WE INTRODUCE A LIST¿??
			
			System.out.println("\nModel of the instrument\n");
			String model=writeString();
			System.out.println("\nPurpose of the instrument\n");
			String purpose=writeString();
			System.out.println("\nAmount of instrument\n");
			int amount=writeNumber();
			System.out.println("\nNumber of uses of the instrument\n");
			int numberUses=writeNumber();
			System.out.println("\nBody location of the instrument\n");
			String bodyLocation=writeString();
			System.out.println("\nPrice of the instrument\n");
			int price=writeNumber();
			
			// List<Warehouse> warehouseLocationList;
			// List<Order> orderList;
			dbManager.insert(dbManager.createPojoInstrument(model, purpose, amount, numberUses, bodyLocation, price));
			break;
			
			
		case 5:
		case 6:
		case 7:
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
		case 8:
			//In warehouse we have 2 ints and 1 String
			
			System.out.println("\nLocation of the warehouse\n");
			String warehouseLocation=writeString();
			System.out.println("\nCapacity of the warehouse\n");
			int capacity=writeNumber();
			System.out.println("\nFilled space in the warehouse\n");
			int filledSpace=writeNumber();
			dbManager.insert(dbManager.createPojoWarehouse(warehouseLocation, capacity, filledSpace));
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

    public static void showObject()
    {
    	//Option is set to select the table, and Option1 is set to print a list or one object
    	int option,option1;
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
    	System.out.println("Select one option:\n"
    			+ "1:Print just one Hospital\n"
    			+ "2:Print the whole table ");
    	System.out.println("\n\n");
    	option1 = writeNumber(2);
    	switch(option)
    	{
    	case 1:
    		if(option1 == 1)
    		{
    			int pk = writeNumber();
    			dbManager.selectHospital(pk);
    			
    		}else
    		{
    			//printHospitalTable();
    		}
    		break;
    	case 2:
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
}