package mtm.db.Interface;


import static mtm.db.Interface.Validator.*;
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
					//DeleteOption//
					delValTable();
					waitEnter();
					break;

				case 6:
					//Modify
					updValTable();
					waitEnter();
					break;
				case 7:
					dbManager.closeConnection();
					waitEnter();
					break;
				}
		}while(option!=7);
	}

	// Menu
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
				System.out.println(""
						+ "Option 1.- Create Tables\n" 
							//Option 1.1: all the tables?
							//Option 1.2: One table //y se las ense�as
								//option 1.2.1: Select the table
							
						+ "Option 2.- List entities\n"
							//Option: Do you want to see all the relations? (Condition)					
								//Option 2.1: What table do you want to see? //y se las ense�as
									//Listas el objeto 
									//Seleccioname 1 
									//muestras
						+ "Option 3.- Show table"
							//Seleccioname la tabla que quieres ver
							//Muestramela con todo
						
						+ "Option 4.- Introduce value to a table"
							//Option 3.1: What table do you want to insert the value to? //y se las ense�as
								//Listas tablas
								//Select the table
								//Introduces
								
						//aqui ademas se debe llamar a UPDATE la tabla, y la relacion con otra tabla si la tiene
						
						+ "Option 5.- Delete value of a Table\n"
							///Option 4.1: What table do you want to delete a value from? //y se las ense�as
								//Select the table
						
						+ "Option 6.- Modify value\n"
							//mostrar entidades
							//Option 6.1: Select a table to madify a value
							// mostrar valores d la tabla
							// seleccionar la fila 
							// seleccionas la columna
							// Das el valor
							// update

						+ "Option 7.- BUUUUUU \n");

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
    		//Menu for the Update
    		System.out.println("\n\nSelect the table you want to Drop:\n"
    				+ "6:Machinery\n"
    				+ "7:WareHouse");
    		break;
    	case 7:
    		//BUUUUUUU
    		System.out.println("Are you Sure?");
    		break;
    	}
    	
    }
    
	//Data Base Methods
	
	public static void createTable()
	{
		System.out.println(" Do you want to create all the tables?\n");
		
		String a = writeString();
		if(writeOption(a)){
		dbManager.createTables();
		}else{
			//See entity names
			selectionMenu(1);
			int op=0;
			switch(op){
				case 1: dbManager.createTableCompany();
					break;
				case 2: dbManager.createTableEmployee();
					break;
				case 3: dbManager.createTableHospital();
					break;
				case 4: dbManager.createTableInstrument();
					break;
				case 5: dbManager.createTableMachinery();
					break;
				case 6: dbManager.createTableMaterial();
					break;
				case 7: dbManager.createTableWarehouse();
					break;
			
			}
		}
		

	}

	public static void listEntity()
	{
		System.out.println("Do you want to see the relations? Write YES or NOT");
		boolean relationOption = writeOption(writeString());
		
		System.out.println("What table do you want to list?");
		selectionMenu(2);
		int option = writeNumber(8);
		
		switch(option)
		{
		case 1:
			listCompanies(relationOption);
			break;
		case 2:
			listEmployees(relationOption);
			break;
		case 3:
			listHospitals(relationOption);
			break;
		case 4:
			listInstruments(relationOption);
			break;
		case 5:
			listMachinery(relationOption);
			break;
		case 6:
			listMaterials(relationOption);
			break;
		case 7:
			listOrders(relationOption);
			break;
		case 8:
			showWarehouse(1);
			break;
		}
		
	}
	
	public static void showTable()
	{
		selectionMenu(3);
		int option = writeNumber(8);
		switch(option)
		{
		case 1:
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
	
	public static void intValTable()
	{
		System.out.println("What table do you want to insert the value to? \n");
		selectionMenu(1);
		int op=0;
		
		switch(op){
		
		case 1: //Company   
			Company comp = createCompany();
			dbManager.insert(comp);
			break;
		case 2: //Employee
			Employee emp = 
			dbManager.insert(emp);
			break;
		case 3: //Hospital 
			Hospital hosp = createHospital();
			dbManager.insert(hosp);
			break;
		case 4: //Instrument
			Instrument inst = createInstrument();
			dbManager.insert(inst);
			break;
		case 5: //Machinery
			Machinery mach = createMachinery();
			dbManager.insert(mach);
			break;
		case 6: //Material
			Material mat = createMaterial(); 
			dbManager.insert(mat);
			break;
		case 7: // Warehouse
			Warehouse war = createWarehouse();
			dbManager.insert(war);
			break;
		}
		
		
	}
	public static void delValTable()
	{
		System.out.println("What table do you want to delete a value from? \n");
		selectionMenu(1);
		int op=0;
		
		switch(op){
		
		case 1: //Company 
			listCompanies(false);
			System.out.println("What company do you want to delete from this table? \n");
			int pk1 = writeNumber();
			dbManager.deleteCompany(pk1);
			break;
		case 2: //Employee
			listEmployees(false);
			System.out.println("What employee do you want to delete from this table? \n");
			int pk2 = writeNumber();
			dbManager.deleteEmployee(pk2);
			break;
		case 3: //Hospital 
			listHospitals(false);
			System.out.println("What hospital do you want to delete from this table? \n");
			int pk3 = writeNumber();
			dbManager.deleteHospital(pk3);
			break;
		case 4: //Instrument
			listInstruments(false);
			System.out.println("What instrument do you want to delete from this table? \n");
			int pk4 = writeNumber();
			dbManager.deleteInstrument(pk4);
			break;
		case 5: //Machinery
			listMachineries(false);
			System.out.println("What machinery do you want to delete from this table? \n");
			int pk5 = writeNumber();
			dbManager.deleteMachinery(pk5);
			break;
		case 6: //Material
			listMaterials(false);
			System.out.println("What material do you want to delete from this table? \n");
			int pk6 = writeNumber();
			dbManager.deleteMaterial(pk6);
			break;
		case 7: // Warehouse
			listWarehouse(false);
			System.out.println("What warehouse do you want to delete from this table? \n");
			int pk7 = writeNumber();
			dbManager.deleteWarehouse(pk7);
			break;
		}
		
	}
	//Extra Methods
    
    
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
    
    public static Employee createEmployee(){

	System.out.println("\nName of the employee:");
	String a = writeString();
	System.out.println("\nType of contract: ");
	String b = writeString();
	System.out.println("\nSpecialization type:");
	String c = writeString();
	System.out.println("\nIn which machinery is the employee specializated in?");
	
	
	
	
	

	Employee emp = new Employee(a,b,c);
	
	return emp;
    
    }
   
    public static Machinery createMachinery(){
    	
	Machinery mach = new Machinery();
	
    	System.out.println("\nMachinery type");
		String a=writeString();
		System.out.println("\nState of machinery");
		String b=writeString();
		System.out.println("\nDate of installation:");		
		String c1[] = new String[2];	
		c1 = createDate();

		System.out.println("\nSize of machinery");
		int d=writeNumber();

		mach = dbManager.createPojoMachinery(a,b,c1[0],c1[1],c1[2],d);
		
		return mach;
}
    
    //Show the Objects
    
    
    public static void showHospital(int pk)
    {
    	Hospital hosp = new Hospital();
		hosp = dbManager.selectHospital(pk);
		dbManager.setHospitalRelations(hosp);
		hosp.toString();
    }
    public static void listHospitals(boolean relation)
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
			if(relation)
			{
				dbManager.setHospitalRelations(hosp);
				System.out.printf("id: %d,name: %s, relation: %d\n",id,name,hosp.getOrderList().toString());
				count++;
			}else{
				System.out.printf("id: %d,name: %s\n",id,name);
				count++;
			}
		}
    }
    
    public static void showOrder(int pk)
    {
    	Order ord = new Order();
    	ord = dbManager.selectOrder(pk);
    	dbManager.setOrderRelations(ord);
    	ord.toString();
    }
    public static void listOrders(boolean relation)
    {
    	Order ord = new Order();
    	ArrayList<Order> ordList = new ArrayList<Order>();
    	ordList = dbManager.selectAllOrders();
    	
    	int count = 0;
    	
    	while(count < ordList.size())
    	{
    		if(relation)
    		{
    			dbManager.setOrderRelations(ord);
    			System.out.printf("id: %d, relations: %d\n",ord.getOrderID(),ord.getHospitalList().toString());
    		}else
    		{
    			ord = ordList.get(count);
    			System.out.printf("id: %d\n",ord.getOrderID());
    		}
    		
    	}
    	
    }
        
    public static void showInstrument(int pk){
    	Instrument inst = new Instrument();
    	inst = dbManager.selectInstrument(pk);
    	inst.toString();
    	
    }
    
    public static void listInstruments(boolean relation){
    	Instrument inst = new Instrument();
    	ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
    	instrumentList = dbManager.selectAllInstruments();
    	int count = 0;
    	
    	while(count < instrumentList.size()){
    		if(relation){
    			dbManager.setInstrumentRelations(inst);
    			System.out.printf("id: %d, relations: %d\n",inst.getInstrumentID(),inst.getOrderList().toString());
    			System.out.printf("id: %d, relations: %d\n",inst.getInstrumentID(),inst.getMachineryTypeList().toString());
    			System.out.printf("id: %d, relations: %d\n",inst.getInstrumentID(),inst.getWarehouseID().toString());	
    		}else{
    			inst = instrumentList.get(count);
    			System.out.printf("id: %d\n",inst.getInstrumentID());
    		}
    	}		
    }
    public static void showWarehouse(int pk){
    	Warehouse war = new Warehouse();
    	war = dbManager.selectWarehouse(pk);    		
    	war.toString();
    }
        	
    /*
    public static void showEmployee(int pk)
    {
    	Employee emp = new Employee();
    	emp = dbManager.selectEmployee(pk);
    	emp.toString();
    }
    public static void listEmployee()
    {
    	Employee emp = new Employee();
    	ArrayList<Employee> ordList = new ArrayList<Employee>();
    	empList = dbManager.selectAllEmployee();
    	
    	int count = 0;
    	
    	while(count < empList.size())
    	{
    		emp = empList.get(count);
    		System.out.printf("id: %d\n",emp.getEmployeeID());
    	}
    	
    	
    	
    	
    }
    
    /*
    public static void showMachinery(int pk)
    {
    	Machinery mach = new Machinery();
    	mach = dbManager.selectMachinery(pk);
    	mach.toString();
    }
    public static void listMachinery()
    {
    	Machinery mach = new Machinery();
    	ArrayList<Machinery> ordList = new ArrayList<Machinery>();
    	machList = dbManager.selectAllMachinery();
    	
    	int count = 0;
    	
    	while(count < machList.size())
    	{
    		mach =machList.get(count);
    		System.out.printf("id: %d\n",mach.getMachineryID());
    	}
    
    */
}
