package mtm.db.Interface;

import static mtm.db.Interface.Validator.*;

 class EclipseInterface 
{
	public static void main()
	{
		int option = openMenu();
		
		
	}



	public static int openMenu()
	{
		int option;
		int numOptions = 4; //Numero de opciones que podemos seleccionar con esta función
		imprimirMenu();
		option = writeNumber(numOptions);
		
		return option;
	}

	public static void imprimirMenu()
	{
		//Si añades opciones, recuerda mirar elmétodo abrirMenu
		System.out.println("Opcion 1.- Crear Tabla\n"
				+ "Opcion 2.- Borrar Tabla\n"
				+ "Opcion 3.- Introduce Valores de Tabla\n"
				+ "Opción 4.- Borrar Valores de la Tabla\n");
	}
	
	
}