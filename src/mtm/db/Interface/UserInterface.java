package mtm.db.Interface;


import static mtm.db.Interface.Validator.*;
import java.util.ArrayList;
<<<<<<< HEAD
import mtm.db.jdbc.DbManager;
import mtm.db.pojos.Company;
=======
import mtm.db.jdbc.JDBCManager;
>>>>>>> branch 'master' of https://github.com/papsers/MtM.git
import mtm.db.pojos.Employee;
import mtm.db.pojos.Hospital;
import mtm.db.pojos.Instrument;
import mtm.db.pojos.Machinery;
import mtm.db.pojos.Material;
import mtm.db.pojos.Order;
import mtm.db.pojos.Warehouse;

public class UserInterface 
{

	 
	static JDBCManager jdbcManager = new JDBCManager();
	 
	public static void main(String args[]) 
	{
		
		int option;
		jdbcManager.openConnection();
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
					jdbcManager.closeConnection();
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
							//Muestramela con todo (relaciones incluidas)
						
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
		jdbcManager.createTables();
		}else{
			//See entity names
			selectionMenu(1);
			int op=0;
			switch(op){
				case 1: jdbcManager.createTableCompany();
					break;
				case 2: jdbcManager.createTableEmployee();
					break;
				case 3: jdbcManager.createTableHospital();
					break;
				case 4: jdbcManager.createTableInstrument();
					break;
				case 5: jdbcManager.createTableMachinery();
					break;
				case 6: jdbcManager.createTableMaterial();
					break;
				case 7: jdbcManager.createTableWarehouse();
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
			listCompanies(false);
			System.out.printf("Select the ID of the company you want to see");
			showCompany(writeNumber());
			break;
		case 2:
			listEmployees(false);
			System.out.printf("Select the ID of the employee you want to see");
			showEmployee(writeNumber());
			break;
		case 3:
			listHospitals(false);
			System.out.printf("Select the ID of the hospital you want to see");
			showHospital(writeNumber());
			break;
		case 4:
			listInstruments(false);
			System.out.printf("Select the ID of the instrument you want to see");
			showInstrument(writeNumber());
			break;
		case 5:
			listMachinery(false);
			System.out.printf("Select the ID of the machinery you want to see");
			showEMachinery(writeNumber());
			break;
		case 6:
			listMaterials(false);
			System.out.printf("Select the ID of the material you want to see");
			showMaterial(writeNumber());
			break;
		case 7:
			listOrders(false);
			System.out.printf("Select the ID of the order you want to see");
			showOrder(writeNumber());
			break;
		case 8:
			showWarehouse(1);
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
			jdbcManager.insert(comp);
			break;
		case 2: //Employee
			Employee emp = 
			jdbcManager.insert(emp);
			break;
		case 3: //Hospital 
			Hospital hosp = createHospital();
			jdbcManager.insert(hosp);
			break;
		case 4: //Instrument
			Instrument inst = createInstrument();
			jdbcManager.insert(inst);
			break;
		case 5: //Machinery
			Machinery mach = createMachinery();
			jdbcManager.insert(mach);
			break;
		case 6: //Material
			Material mat = createMaterial(); 
			jdbcManager.insert(mat);
			break;
		case 7: // Warehouse
			Warehouse war = createWarehouse();
			jdbcManager.insert(war);
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
			jdbcManager.deleteCompany(pk1);
			break;
		case 2: //Employee
			listEmployees(false);
			System.out.println("What employee do you want to delete from this table? \n");
			int pk2 = writeNumber();
			jdbcManager.deleteEmployee(pk2);
			break;
		case 3: //Hospital 
			listHospitals(false);
			System.out.println("What hospital do you want to delete from this table? \n");
			int pk3 = writeNumber();
			jdbcManager.deleteHospital(pk3);
			break;
		case 4: //Instrument
			listInstruments(false);
			System.out.println("What instrument do you want to delete from this table? \n");
			int pk4 = writeNumber();
			jdbcManager.deleteInstrument(pk4);
			break;
		case 5: //Machinery
			listMachineries(false);
			System.out.println("What machinery do you want to delete from this table? \n");
			int pk5 = writeNumber();
			jdbcManager.deleteMachinery(pk5);
			break;
		case 6: //Material
			listMaterials(false);
			System.out.println("What material do you want to delete from this table? \n");
			int pk6 = writeNumber();
			jdbcManager.deleteMaterial(pk6);
			break;
		case 7: // Warehouse
			showWarehouse(1);
			System.out.println("What warehouse do you want to delete from this table? \n");
			int pk7 = writeNumber();
			jdbcManager.deleteWarehouse(pk7);
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
					listOrders(false);
					int op = writeNumber();
					System.out.println("Insert the amountOrder");
					int tao = writeNumber();
					jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),op,tao);
				}else
				{
					Order ord = createOrder();
					jdbcManager.insert(ord);
					System.out.println("Insert the amountOrder");
					int tao = writeNumber();
					jdbcManager.setRelationHospitalOrder(hosp.getHospitalID(),ord.getOrderID(),tao);
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
		
		ord = jdbcManager.createPojoOrder(d,d1[0],d1[1],d1[2],d2[0],d2[1],d2[2]);
		
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

		mach = jdbcManager.createPojoMachinery(a,b,c1[0],c1[1],c1[2],d);
		
		return mach;
}
    
    public static Company createCompany(){
    	
    	
    	boolean aux = true;
    	System.out.println("\nCompany location");
    	String a=writeString();
    	System.out.println("\nCompany name");
    	String b=writeString();
    	int pos = 0;
    	
    	Company com = new Company();

    	System.out.println("\nDo you want to add materials provided by the Company? YES or NO:\n");
    	String answ = writeString();
    	if(answ.equals("YES")){
    		while(aux){
    			Material mat = createMaterial();
    			com.addMaterial(mat);
    			
    			System.out.println("\nDo you want to add another material provided by the Company? YES or NO:\n");
    			String answ2 = writeString();
    			jdbcManager.insert(mat);
    			if(answ2.equals("NO")){
    				aux = false;
    			}
    	}
    	}
    	jdbcManager.insert(com);
    	return com;
    }
    
    public static Material createMaterial()
    {
    	
    	System.out.println("\nWeight");
    	int a = writeNumber();
    	System.out.println("\nVolume");
    	int b = writeNumber();
    	System.out.println("\nType");
    	String c = writeString();
    	
    	System.out.println("This material is provided by a company from the database YES or NO: \n");
    	String answ = writeString();
    	if(answ.equals("YES")){
    		
    	}else{
    		Company com = createCompany();
    	}
    	
    	Material mat = new Material(a,b,c);
    	
    	return mat;
    	
    }

    
    
    //Show the Objects
    
    public static void showCompany(int pk){
    	Company com = new Company();
		com = jdbcManager.selectCompany(pk);
		jdbcManager.setCompanyRelations(com);
		com.toString();
    }
    
    public static void listMaterials(boolean relation){
        	Material mat = new Material();
        	ArrayList<Material> matList = new ArrayList<Material>();
        	matList = jdbcManager.selectAllMaterials();
        	
        	int count = 0;
        	
        	while(count < matList.size())
        	{
        		if(relation)
        		{
        			jdbcManager.setOrderRelations(mat);
        			System.out.printf("id: %d, relations: %d\n",ord.getOrderID(),ord.getHospitalList().toString());
        		}else
        		{
        			ord = ordList.get(count);
        			System.out.printf("id: %d\n",ord.getOrderID());
        		}
        		
        	}
        	
        }
    
    
    public static void showHospital(int pk)
    {
    	Hospital hosp = new Hospital();
		hosp = jdbcManager.selectHospital(pk);
		jdbcManager.setHospitalRelations(hosp);
		hosp.toString();
    }
    public static void listHospitals(boolean relation)
    {
    	Hospital hosp = new Hospital();
		ArrayList<Hospital> hospList = new ArrayList<Hospital>();
		hospList = jdbcManager.selectHospitals();
			
		int count= 0;
			
		while(count < hospList.size())
		{
			hosp = hospList.get(count);
			String name = hosp.getName();
			int id = hosp.getHospitalID();
			if(relation)
			{
				jdbcManager.setHospitalRelations(hosp);
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
    	ord = jdbcManager.selectOrder(pk);
    	jdbcManager.setOrderRelations(ord);
    	ord.toString();
    }
    public static void listOrders(boolean relation)
    {
    	Order ord = new Order();
    	ArrayList<Order> ordList = new ArrayList<Order>();
    	ordList = jdbcManager.selectAllOrders();
    	
    	int count = 0;
    	
    	while(count < ordList.size())
    	{
    		if(relation)
    		{
    			jdbcManager.setOrderRelations(ord);
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
    	inst = jdbcManager.selectInstrument(pk);
    	jdbcManager.setInstrumentRelations(inst);
    	inst.toString();
    	
    }
    
    public static void listInstruments(boolean relation){
    	Instrument inst = new Instrument();
    	ArrayList<Instrument> instrumentList = new ArrayList<Instrument>();
    	instrumentList = jdbcManager.selectAllInstruments();
    	int count = 0;
    	
    	while(count < instrumentList.size()){
    		if(relation){
    			jdbcManager.setInstrumentRelations(inst);
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
    	war = jdbcManager.selectWarehouse(pk);    		
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
