
/**
 * Write a description of class Descuentos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.time.*;
public class Temporadas
{
    // instance variables - replace the example below with your own
    private HashMap<String, Float> mapaDescuentosTemporadas;
    private HashMap<PeriodoTemporada, String> mapaTemporadas;

    /**
     * Constructor for objects of class Descuentos
     */
    public Temporadas()
    {
        mapaDescuentosTemporadas = new HashMap<String, Float>();
        mapaDescuentosTemporadas.put("tempAlta", 100f);
        mapaDescuentosTemporadas.put("tempBaja", 100f);
        mapaDescuentosTemporadas.put("tempMedia", 100f);
        
    }

   public float get(String key)
   {
       return mapaDescuentosTemporadas.get(key);
   }
   
   public String checkTemporada(LocalDate fecha)
   {
       for (PeriodoTemporada periodo : mapaTemporadas.keySet())
       {
           if (periodo.enPeriodo(fecha))
           {
               return mapaTemporadas.get(periodo);
           }
        }
       
        return "tempMedia";
    }
}
