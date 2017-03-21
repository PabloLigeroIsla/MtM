package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

import java.io.IOException;

import mtm.db.jdbc.*;

 class EclipseInterface 
{
	public static void main()
	{
		
		//Object jdbc
		DbManager mtmDataBase = new DbManager();
		
		int option;
		do{
			//Start of the db
			option = openMenu();
		
			switch(option)
				{
			
				case 1:
					
					waitEnter();
				case 2:
					
					waitEnter();
				case 3:
					
					waitEnter();
				case 4:
					
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
		int numOptions = 4; //Numero de opciones que podemos seleccionar con esta función
		printMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void printMenu()
	{
		//Si añades opciones, recuerda mirar el metodo abrirMenu
		System.out.println("Option 1.- Create Tables\n"
				+ "Option 2.- Drop Table\n"
				+ "Option 3.- Introduce values to a Table\n"
				+ "Option 4.- Delete value of a Table\n"
				+ "Option 12.- Exit");
	}
	
	//Data Base Methods
	
	
	
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