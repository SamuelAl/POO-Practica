
/**
 * Write a description of class Generador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import static java.lang.System.*;
import java.time.*;
import java.util.Random;

public class Generador
{
   public static void main (String[] args)
    {
        Random rand = new Random();
        String line = "";
        
        
        try
        {
        FileWriter fw = new FileWriter("Visitantes.txt");
        PrintWriter pw = new PrintWriter(fw);
        for (int i = 0; i < 100; i++)
        {
           int edad = rand.nextInt(99) + 1;
           
           if (edad < 13)
           {
               line += 0 + ";";
           }
           else if (edad > 64)
           {
               line += 1 + ";";
           }
           else
           {
               line += (rand.nextInt(4) + 2) + ";";
           }   
           
           line += Integer.toString(edad) + ";";//edad
           line += rand.nextInt(2) + ";";//VIP
           line += rand.nextInt(2) + ";";//Familia
           line += Integer.toString(rand.nextInt(28)+1) + ";";
           line += Integer.toString(rand.nextInt(12)+1) + ";";
           
           
           pw.println(line);
            
           line = "";

        }
        pw.close();
        }
          
        
        catch (IOException e) 
            {
                out.println("ERROR");
            }
       
    }
}
