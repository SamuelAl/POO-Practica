
/**
 * Clase que se ocupa de almacenar y suministrar los posibles
 * descuentos de las entradas.
 *
 * @author (Samue Alarco)
 * @version (v1.0)
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

    /**
     * Method getDescuento
     * 
     * Metodo para buscar un descuento especifico
     *
     * @param key Clave del descuento
     * @return Valor (porcentaje) del descuento
     */
    public float getDescuento(String key)
    {
        if (mapaDescuentos.containsKey(key))
        {
            return mapaDescuentos.get(key);
        }
        else
        {
            System.out.println("Descuento no existe");
            return 0f; // No se aplica ningun descuento
        }
    }
    
    /**
     * Method addDescuento
     *
     * Metodo para añdir nuevos descuentos 
     * al objeto
     *
     * @param key Identificacion del descuento (String)
     * @param descuento Valor del descuento (porcentaje a descontar)
     */
    public void addDescuento(String key, float descuento)
    {
        if (descuento < 1)
        {
            System.out.println("Descuento no valido");
        }
        else
        {
            mapaDescuentos.put(key, descuento);
        }
    }
    
    /**
     * Method obtenerDescuentos
     * 
     * Metodo para obtener copia del
     * HashMap de descuentos
     *
     * @return The return value
     */
    public HashMap<String, Float> obtenerDescuentos()
    {
        HashMap<String, Float> copiaDescuentos = new HashMap<String, Float>(mapaDescuentos);
        return copiaDescuentos;
    }
}
