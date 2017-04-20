package mtm.db.Interface;

import static mtm.db.Interface.Validator.createDate;
import static mtm.db.Interface.Validator.waitEnter;
import static mtm.db.Interface.Validator.writeNumber;
import static mtm.db.Interface.Validator.writeString;

import java.util.ArrayList;

import mtm.db.jdbc.DbManager;
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Order;

public class UserInterface 
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
		int numOptions = 6; //Numero de opciones que podemos seleccionar con esta funciï¿½n
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void printMenu()
	{
		//Si añades opciones, recuerda mirar el metodo abrirMenu
				System.out.println(""
						+ "Option 1.- Create Tables\n" 
							//Option 1.1: all the tables?
							//Option 1.2: One table //y se las enseñas
								//option 1.2.1: Select the table
							
						+ "Option 2.- List entities\n"
							//Option: Do you want to see all the relations? (Condition)					
								//Option 2.1: What table do you want to see? //y se las enseñas
									//Listas el objeto 
									//Seleccioname 1 
									//muestras
						+ "Option 3.- Show table"
							//Seleccióname la tabla
							//Muestramela 
						
						+ "Option 3.- Introduce value to a table"
							//Option 3.1: What table do you want to insert the value to? //y se las enseñas
								//Listas tablas
								//Select the table
								//Introduces
								
						//aqui ademas se debe llamar a UPDATE la tabla, y la relacion con otra tabla si la tiene
						
						+ "Option 4.- Delete value of a Table\n"
							///Option 4.1: What table do you want to delete a value from? //y se las enseñas
								//Select the table
						
						
						+ "Option 5.- Drop Tables\n"
							//Option 5.1: all the tables?
							//Option 5.2: One table //y se las enseñas (pero no tiene sentido borrar hospital, warehouse, company?
								//Select the table
						//si es solo una tabla, tras esto delete la tabla con relaciones que afecten a la tabla eliminada
						
						+ "Option 6.- Modify value\n"
							//mostrar entidades
							//Option 6.1: Select a table to madify a value
							// mostrar valores d la tabla
							// seleccionar la fila 
							// seleccionas la columna
							// Das el valor
							// update

						+ "Option 7.- Salir de la base de datos\n");

	}
	
	//Data Base Methods
	
	public static void createTables()
	{
		
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
				+ "8:Warehouse\n"
				+ "Introduce Option number: ");
		int  option = writeNumber(8);
		
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
			
			
			//HOW DO WE INTRODUCE A LISTÂ¿??
			
			
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
			
			//TENGO QUE CONSEGUIR EL ID DE ESTA RELACION Y LO ESCRIBO? TIPO WAREHOUSE??
			
			//int warehouseIDInstrument=writeNumber();
			// List<Order> orderList;
			//dbManager.insert(dbManager.createPojoInstrument(model, purpose, amount, numberUses, bodyLocation, price, warehouseIDInstrument));
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

    	
    	switch(option)
    	{
    	case 1:
    		break;
    	case 2:
    		Employee emp=new Employee();

    		ArrayList<Employee>empList = new ArrayList<Employee>();
    		//empList = dbManager.selecEmployee(pk);
    			
    		break;
    	case 3:
    		listHospitals();
    		break;
    	case 4:
    		break;
    	case 5:
    		Machinery mach=new Machinery();

    			ArrayList<Machinery>machList = new ArrayList<Machinery>();
    			//machList = dbManager.selecMachinery(pk);
    			
    		break;    	
    	
    		
    	case 6:
    		
    		break;
    	case 7:
    		
    		break;
    	case 8:
    		break;
    	}
    }
    //Menu
    public static void SelectionMenu(int option)
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
    				+ "8:Warehouse\n"
    				+ "Introduce Option number: ");
    		
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
    	}
    	
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
