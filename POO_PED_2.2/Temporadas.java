
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
        mapaDescuentosTemporadas.put("tempAlta", 115f);
        mapaDescuentosTemporadas.put("tempBaja", 85f);
        mapaDescuentosTemporadas.put("tempMedia", 100f);
        
        mapaTemporadas = new HashMap<PeriodoTemporada, String>();
        
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.JANUARY, 1), LocalDate.of(2019, Month.JANUARY, 8)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.APRIL, 15), LocalDate.of(2019, Month.APRIL, 21)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.APRIL, 1), LocalDate.of(2019, Month.APRIL, 30)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.AUGUST, 1), LocalDate.of(2019, Month.AUGUST, 31)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.DECEMBER, 1), LocalDate.of(2019, Month.DECEMBER, 31)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.FEBRUARY, 1), LocalDate.of(2019, Month.FEBRUARY, 28)), "tempBaja");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(2019, Month.NOVEMBER, 1), LocalDate.of(2019, Month.NOVEMBER, 30)), "tempBaja");
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
