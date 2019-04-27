import java.io.*;
import static java.lang.System.*;
import java.time.*;

public class GeneradorVisitantes
{
    
    
    public static void generarVisitantes (ParqueManager manager)
    {
    String tipo = "";
    int age = 0;
    boolean familia = false;
    boolean vip = false;
    LocalDate fecha;
    
    try 
    {
        BufferedReader br = new BufferedReader(new FileReader("Visitantes.txt"));
        String line = null;
        
        while ((line = br.readLine()) != null) {
            String tmp[] = line.split(";");
            tipo = tmp[0];
            edad = Integer.parseInt(tmp[1]);
            if (Integer.parseInt(tmp[2]) == 1)
            {
                vip = true;
            }
            if (Integer.parseInt(tmp[3]) == 1)
            {
                familia = true;
            }
            fecha = LocalDate.of(2019, Integer.parseInt(tmp[5]), Integer.parseInt(tmp[4]));
            System.out.println(tipo + "\t" + age);
            
        }
    }
    
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
}