
/**
 * Write a description of class Generador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import static java.lang.System.*;

public class Generador
{
   public static void main (String[] args)
    {
        try {
            FileWriter fw = new FileWriter("Visitantes.txt");
            PrintWriter pw = new PrintWriter(fw);
            
            pw.println("Adulto;45");
            pw.println("Senior;60");
            
            pw.close();
        }
        catch (IOException e) 
        {
            out.println("ERROR");
        }
    }
}
