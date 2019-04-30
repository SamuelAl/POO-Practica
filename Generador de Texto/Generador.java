
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
        int month = 0;
        int day = 0;
        
        
        try
        {
        FileWriter fw = new FileWriter("Visitantes.txt");
        PrintWriter pw = new PrintWriter(fw);
        
            for (int j = 1; j < 13; j++)
            {
                int monthN = rand.nextInt(10) + 1;
                int dayIndex = 1;
                int dayN = rand.nextInt(20) + 1;
                while (dayIndex <= 28)
                {
                    for (int k = 0; k < dayN; k++)
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
                       line += Integer.toString(dayIndex) + ";";
                       line += Integer.toString(j) + ";";
                       
                       pw.println(line);
                
                       line = "";
                    }
                    dayIndex += monthN;
                }
            }
            pw.close();
        }
 
        catch (IOException e) 
        {
            out.println("ERROR");
        }
       
    }
}
