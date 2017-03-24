package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

import java.io.IOException;

import mtm.db.jdbc.*;

 class EclipseInterface 
{
	public static void main()
	{
		
		//Object jdbc
		DbManager dbManager = new DbManager();
		
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
					//dropTable();
					waitEnter();
				case 3:
					
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
		DbManager dbManager = new DbManager();
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
			//Select the option introduced
			if(option == 1)
			{
				dbManager.createTableCompany();
			}
			if(option == 2)
			{
				dbManager.createTableEmployee();
			}
			if(option == 3)
			{
				dbManager.createTableHospital();
			}
			if(option == 4)
			{
				dbManager.createTableInstrument();
			}
			if(option == 5)
			{
				dbManager.createTableMachinery();
			}
			if(option == 6)
			{
				dbManager.createTableMaterial();
			}
			if(option == 7)
			{
				dbManager.createTableOrder();
			}
			if(option == 8)
			{
				dbManager.createTableWarehouse();
			}
		}
		
	}

	
	//Extra Methods
    public static void waitEnter()
    {	
        System.out.println("Press enter to continue: \n");
        try{
            String a = c.readLine();
        }catch(IOException ex){
        	ex.printStackTrace();
        }
    }
}