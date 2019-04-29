import java.io.*;
import static java.lang.System.*;
import java.time.*;

public class GeneradorVisitantes
{
    
    
    public static void generarVisitantes (ParqueManager manager)
    {
    int tipo = 0;
 
    int edad = 0;
    boolean familia = false;
    boolean vip = false;
    Month month;
    LocalDate fecha;
    String[] tipos = { "niño", "senior", "carnet joven", "discapacitado", "estudiante", "veterano"};
    
    try 
    {
        BufferedReader br = new BufferedReader(new FileReader("Visitantes.txt"));
        String line = null;
        
        while ((line = br.readLine()) != null) {
            String tmp[] = line.split(";");
            tipo = Integer.parseInt(tmp[0]);
            
            edad = Integer.parseInt(tmp[1]);
            if (Integer.parseInt(tmp[2]) == 1)
            {
                vip = true;
            }
            if (Integer.parseInt(tmp[3]) == 1)
            {
                familia = true;
            }
             switch (Integer.parseInt(tmp[5]))
             {
                 case 1:
                    month = Month.JANUARY;
                    break;
                 case 2:
                    month = Month.FEBRUARY;
                    break;
                 case 3:
                    month = Month.MARCH;
                    break;
                 case 4:
                    month = Month.APRIL;
                    break;
                 case 5:
                    month = Month.MAY;
                    break;
                 case 6:
                    month = Month.JUNE;
                    break;
                 case 7:
                    month = Month.JULY;
                    break;
                 case 8:
                    month = Month.AUGUST;
                    break;
                 case 9:
                    month = Month.SEPTEMBER;
                    break;
                 case 10:
                    month = Month.OCTOBER;
                    break;
                 case 11:
                    month = Month.NOVEMBER;
                    break;
                 case 12:
                    month = Month.DECEMBER;
                    break;
                 default:
                    month = Month.JANUARY;
             }
            fecha = LocalDate.of(2019, month, Integer.parseInt(tmp[4]));
            System.out.println("Visitante: " + tipos[tipo]);
            
            if (tipo == 0)
            {
                manager.addEntradaNiño(fecha, edad, vip, familia, "ninguno");
            }
            else
            {
                manager.addEntrada(fecha, edad, vip, familia, tipos[tipo]);
            }
            
        }
    }
    
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
}