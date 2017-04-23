package mtm.db.Interface;

import static mtm.db.Interface.Validator.createDate;
import static mtm.db.Interface.Validator.waitEnter;
import static mtm.db.Interface.Validator.writeNumber;
import static mtm.db.Interface.Validator.writeString;
import java.util.ArrayList;
import mtm.db.jdbc.DbManager;
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Instrument;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Order;
import mtm.db.pojos.Warehouse;

public class UserInterface 
{

	 
	static DbManager dbManager = new DbManager();
	 
	public static void main(String args[]) 
	{
		
		int option;
		dbManager.openConnection();
		do{
			//Start of the db
			option = openMenu();
		
			switch(option)
				{
				case 1:
					//Create tables
					createTable();
					waitEnter();
					break;
				case 2:
					//List Entities
					listEntity();
					waitEnter();
				case 3:
					//show table
					showTable();
					waitEnter();
					break;
				case 4:
					//Introduce Value
					intValTable();
					waitEnter();
					break;
				case 5:
					//DeleteOption
					delValTable();
					waitEnter();
					break;
				case 6:
					//Drop
					dropTable();
					waitEnter();
					break;
				case 7:
					//Modify
					updValTable();
					waitEnter();
					break;
				case 8:
					dbManager.closeConnection();
					waitEnter();
					break;
				}
		}while(option!=8);
	}

	// Menu
	public static int openMenu()
	{
		int option;
		int numOptions = 6; //Numero de opciones que podemos seleccionar con esta funciï¿½n
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}
    
    public static void printMenu()
	{
		//Si aï¿½ades opciones, recuerda mirar el metodo abrirMenu
				System.out.println(""
						+ "Option 1.- Create Tables\n" 
							//Option 1.1: all the tables?
							//Option 1.2: One table //y se las enseñas
								//option 1.2.1: Select the table
							
						+ "Option 2.- List entities\n"
							//Option: Do you want to see all the relations? (Condition)					
								//Option 2.1: What table do you want to see? //y se las enseï¿½as
									//Listas el objeto 
									//Seleccioname 1 
									//muestras
						+ "Option 3.- Show table"
							//Seleccioname la tabla que quieres ver
							//Muestramela con todo
						
						+ "Option 4.- Introduce value to a table"
							//Option 3.1: What table do you want to insert the value to? //y se las enseï¿½as
								//Listas tablas
								//Select the table
								//Introduces
								
						//aqui ademas se debe llamar a UPDATE la tabla, y la relacion con otra tabla si la tiene
						
						+ "Option 5.- Delete value of a Table\n"
							///Option 4.1: What table do you want to delete a value from? //y se las enseï¿½as
								//Select the table
						
						
						+ "Option 6.- Drop Tables\n"
							//Option 5.1: all the tables?
							//Option 5.2: One table //y se las enseï¿½as (pero no tiene sentido borrar hospital, warehouse, company?
								//Select the table
						//si es solo una tabla, tras esto delete la tabla con relaciones que afecten a la tabla eliminada
						
						+ "Option 7.- Modify value\n"
							//mostrar entidades
							//Option 6.1: Select a table to madify a value
							// mostrar valores d la tabla
							// seleccionar la fila 
							// seleccionas la columna
							// Das el valor
							// update

						+ "Option 8.- Salir de la base de datos\n");

	}
	
    public static void selectionMenu(int option)
    {
    	//The option of this menu select the type of menu we wnat to print
    	switch(option)
    	{
    	case 1:
    		//This case is used to the method CreateTables
    		System.out.println("\n\nSelect the table you want to create:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery"
    				+ "6:Material\n"
    				+ "7:Order"
    				+ "8:Warehouse\n");
    		
    		break;
    	case 2:
    		//This case is used when you want to list an Entity
    		System.out.println("\n\nSelect the table you want to List:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery"
    				+ "6:Material\n"
    				+ "8:Warehouse\n");
    		break;
    	case 3:
    		System.out.println("\n\nSelect the table you want to show:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery"
    				+ "6:Material\n"
    				+ "7:Order"
    				+ "8:Warehouse\n");
    		break;
    	case 4:
    		//This case is used whuen you want to introduce a value in the dataBase
    		System.out.println("\n\nSelect the table where ypu wsnt to insert the value:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery"
    				+ "6:Material\n"
    				+ "7:Warehouse\n");
    		break;
    	case 5:
    		//Menu for the delete option
    		System.out.println("\n\nSelect the table where you want to delate a value:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Order\n");
    		break;
    	case 6:
    		//Drop option menu
    		System.out.println("\n\nSelect the table you want to Drop:\n"
    				+ "1:Company\n"
    				+ "2:Employee\n"
    				+ "3:Hospital\n"
    				+ "4:Instrument\n"
    				+ "5:Machinery"
    				+ "6:Material\n"
    				+ "7:Order"
    				+ "8:Warehouse\n");
    		break;
    	case 7:
    		//Menu for the Update
    		System.out.println("\n\nSelect the table you want to Drop:\n"
    				+ "6:Machinery\n"
    				+ "7:WareHouse");
    		break;
    	case 8:
    		//
    		System.out.println("Are you Sure?");
    		break;
    	}
    	
    }
    
	//Data Base Methods
	
	public static void createTable()
	{
		System.out.println("Create one or all the tables?");
		int op = writeNumber(2);
		switch(op)
		{
		case 1:
			System.out.println("cual");
			selectionMenu(1);
			int i = writeNumber();
			break;
		case 2:
			
		}
	}

	public static void listEntity()
	{
		
	}
	
	public static void showTable()
	{}
	
	public static void intValTable()
	{	
		int option = writeNumber();;
		switch(option)
		{
		case 1:
			
		case 2:
//la pk se pone sola??

			/*System.out.println("\nName of the employee:");
			String ae = writeString();
			System.out.println("\nSpeialization type of the employee: ");
			String be = writeString();
			System.out.println("\nType of contract:");
			String ce = writeString();
			System.out.println("\nMachinery:");
			String de = writeString();			
			Employee emp = new Employee(ae,be,ce,de);
			dbManager.insert(emp);
			break;*/
			
		case 3:
			//In hospital we have 1 int and 3 Strings (int is the primary key with the autoincrement)
			Hospital hosp = createHospital();
			
			dbManager.insert(hosp);
			break;
		case 4:
			//In instrument we have 3 ints, 3 Strings and 2 List
			
			Instrument inst = createInstrument();
			dbManager.insert(inst);
			
			break;
			
			
		case 5:
			
			/*System.out.println("\nMachinery type:");
			String am = writeString();
			System.out.println("\nState of machinery: ");
			String bm = writeString();
			System.out.println("\nDate of installation:");
			String cm[] = new String[2];
			cm = createDate();

			System.out.println("\nSize of machinery:");
			int dm = writeNumber();
			Mahinery mach = new Machinery(am,bm,cm,dm);
			dbManager.insert(mach);*/
			break;
		case 6:  

		case 8:
			//In warehouse we have 2 ints and 1 String
			
			Warehouse warehouse = createWarehouse();
			
			dbManager.insert(warehouse);
		}
		
		
	}
	
    public static void delValTable()
    {	
    	
    }
    
    public static void dropTable()
    {
    	
    }
    
    public static void updValTable()
    {
    	
    }
    
    //Creation of Objects
    public static Hospital createHospital()
    {
    	System.out.println("\nName of the hosital:");
		String a = writeString();
		System.out.println("\nLocation of the Hospital: ");
		String b = writeString();
		System.out.println("\nMedical Specialization of he hospital:");
		String c = writeString();
		
		Hospital hosp = new Hospital(a,b,c);
		
		System.out.println("Do you want to create an order for this hospital. YES or NO:\n");
		String option = writeString();
		if(option.equals("YES"))
		{
			boolean keepRelating = true;
			while(keepRelating)
			{
				System.out.println("\nThe Order allready exixt?. YES or NO");
				option = writeString();
				if(option.equals("YES"))
				{
					System.out.println("Select one of the Orders");
					listOrders();
					int op = writeNumber();
					System.out.println("Insert the amountOrder");
					int tao = writeNumber();
					dbManager.setRelationHospitalOrder(hosp.getHospitalID(),op,tao);
				}else
				{
					Order ord = createOrder();
					dbManager.insert(ord);
					System.out.println("Insert the amountOrder");
					int tao = writeNumber();
					dbManager.setRelationHospitalOrder(hosp.getHospitalID(),ord.getOrderID(),tao);
				}
				System.out.println("\n Do you want to keep relating? YES,NO\n");
				option = writeString();
				if(option.equals("NO"))
				{
					keepRelating = false;
				}
				
			}
		}else
		{
			System.out.println("No Order will be related");
		}
		
		return hosp;
    } 
    public static Order createOrder()
    {
    	System.out.println("\nIntroduce the values\n");
    	Order ord = new Order();
    	System.out.println("\nTotal Amount of Instruments\n");
		int d = writeNumber();
		
		String d1[] = new String[2];
		String d2[] = new String[2];
		
		System.out.println("\nOrder Date\n");
		d1 = createDate();
		System.out.println("Delivery Date");
		d2 = createDate();
		
		ord = dbManager.createPojoOrder(d,d1[0],d1[1],d1[2],d2[0],d2[1],d2[2]);
		
		return ord;
    }
    
    public static Warehouse createWarehouse(){
    	
    	System.out.println("\nLocation of the warehouse\n");
		String warehouseLocation=writeString();
		System.out.println("\nCapacity of the warehouse\n");
		int capacity=writeNumber();
		System.out.println("\nFilled space in the warehouse\n");
		int filledSpace=writeNumber();
		
		Warehouse warehouse = new Warehouse( warehouseLocation,capacity,filledSpace);
		
		return warehouse;
    }

    public static Instrument createInstrument(){
    	
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
		System.out.println("\nID of the warehouse where the instrument is\n");
		
		Instrument inst = new Instrument (model,purpose,amount,numberUses,bodyLocation,price);
		
		return inst;
		
    	
    }
    
    
    //Show the Objects
    public static void showHospital(int pk)
    {
    	Hospital hosp = new Hospital();
		hosp = dbManager.selectHospital(pk);
		hosp.toString();
    }
    public static void listHospitals()
    {
    	Hospital hosp = new Hospital();
		ArrayList<Hospital> hospList = new ArrayList<Hospital>();
		hospList = dbManager.selectHospitals();
			
		int count= 0;
			
		while(count < hospList.size())
		{
			hosp = hospList.get(count);
			String name = hosp.getName();
			int id = hosp.getHospitalID();
			System.out.printf("id: %d,name: %s\n",id,name);
		}
    }
    
    public static void showOrder(int pk)
    {
    	Order ord = new Order();
    	ord = dbManager.selectOrder(pk);
    	ord.toString();
    }
    public static void listOrders()
    {
    	Order ord = new Order();
    	ArrayList<Order> ordList = new ArrayList<Order>();
    	ordList = dbManager.selectAllOrders();
    	
    	int count = 0;
    	
    	while(count < ordList.size())
    	{
    		ord = ordList.get(count);
    		System.out.printf("id: %d\n",ord.getOrderID());
    	}
    	
    }
    
  
}
