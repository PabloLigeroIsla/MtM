package mtm.db.Interface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Validator
{
	//This class contains some functions that we should use in order to know if the user is
	//introducing the type of value we are storing in the variable.
	
	static BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
	
	public static int writeNumber() 
	{
        boolean out = false;
        int answer = 0;
        String stringNumber = "";
        try
        {
        	 do {
        		    
                 System.out.println("Introduce a number, anything else");
   
                     stringNumber = c.readLine();
                     if (valNumString(stringNumber)) 
                     {
                         answer = Integer.parseInt(stringNumber);
                         out = true;
                     }
                
          } while (!out);//Mientras que no me introduzca un numero, no le dejo salir
        }catch(IOException ex)
        {
        	 ex.printStackTrace();
        }

        return answer;
    }
	
	public static boolean valNumString(String validar) {
        try {
            Integer.parseInt(validar);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }

    }
}
