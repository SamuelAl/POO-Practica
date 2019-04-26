
/**
 * Write a description of class BuscadorDescuentos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;

public class BuscadorDescuentos
{
    // instance variables - replace the example below with your own
    private HashMap<String, Float> mapaDescuentos ;

    /**
     * Constructor for objects of class BuscadorDescuentos
     */
    public BuscadorDescuentos()
    {
        // initialise instance variables
        mapaDescuentos = new HashMap<String, Float>();
        mapaDescuentos.put("carnet joven", 10f);
        mapaDescuentos.put("discapacitado", 20f);
        mapaDescuentos.put("estudiante", 10f);
        mapaDescuentos.put("veterano", 10f);
        mapaDescuentos.put("senior", 35f);
    }

    public float getDescuento(String key)
    {
        return mapaDescuentos.get(key);
    }
}
