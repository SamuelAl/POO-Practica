
/**
 * Write a description of class EntradaGen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.time.*;

public class EntradaGen extends Entrada
{
    // instance variables - replace the example below with your own
    private HashMap<String, Float> descuentosApl;
    private float precio;

    /**
     * Constructor for objects of class EntradaGen
     */
    public EntradaGen(LocalDate fecha, int edad)
    {
        super(fecha, edad);
        precio = super.PRECIO_ADULTO;
    }
    
    protected float getBasePrecio()
    {
        return precio;
    }
    
    public void applyDescuento(String tipo ,float descuento)
    {
        precio = precio * ((100 - descuento)/100);
        descuentosApl.put(tipo, descuento);
    }

    public String getTipo()
    {
        String tipos = "";
        for (String key : descuentosApl.keySet())
        {
            tipos += key + " - ";
        }
        tipos = tipos.substring(0, tipos.length()-3);
        return tipos;
    }
}
