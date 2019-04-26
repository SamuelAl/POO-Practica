
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
        
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1,1,2019), LocalDate.of(8,1,2019)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(15, 4, 2019), LocalDate.of(21, 4, 2019)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1, 4, 2019), LocalDate.of(30, 4, 2019)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1, 8, 2019), LocalDate.of(31, 8, 2019)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1, 12, 2019), LocalDate.of(31, 12, 2019)), "tempAlta");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1, 2, 2019), LocalDate.of(28, 2, 2019)), "tempBaja");
        mapaTemporadas.put(new PeriodoTemporada(LocalDate.of(1, 11, 2019), LocalDate.of(31, 11, 2019)), "tempBaja");
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
