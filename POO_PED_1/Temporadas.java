
/**
 * Write a description of class Descuentos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;

public class Temporadas
{
    // instance variables - replace the example below with your own
    private HashMap<String, Float> mapaTemporadas;

    /**
     * Constructor for objects of class Descuentos
     */
    public Temporadas()
    {
        mapaTemporadas = new HashMap<String, Float>();
        mapaTemporadas.put("tempAlta", 115f);
        mapaTemporadas.put("tempBaja", 85f);
        mapaTemporadas.put("tempMedia", 100f);
    }

   public float get(String key)
   {
       return mapaTemporadas.get(key);
   }
}
