
/**
 * Write a description of class Lector here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.io.*;
import static java.lang.System.*;


public class Lector
{
    
    
    public static void main (String[] args)
    {
    String tipo = "";
    int age = 0;
    
    try 
    {
        BufferedReader br = new BufferedReader(new FileReader("Visitantes.txt"));
        String line = null;
        
        while ((line = br.readLine()) != null) {
            String tmp[] = line.split(";");
            tipo = tmp[0];
            age = Integer.parseInt(tmp[1]);
            
            System.out.println(tipo + "\t" + age);
            
        }
    }
    
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
}
