
/**
 * Write a description of class NormalAdulto here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.time.*;

public class NormalAdulto extends Adulto
{
    // instance variables - replace the example below with your own
    private float DESCUENTO;
    private float precio;

    /**
     * Constructor for objects of class NormalAdulto
     */
    public NormalAdulto(LocalDate fecha ,int edad)
    {
        super(fecha, edad);
       if (DESCUENTO != 0.0f) {precio = super.PRECIO_ADULTO * (DESCUENTO/100);}
        else {precio = super.PRECIO_ADULTO;}
    }
    
    protected float getBasePrecio()
    {
        return precio;
    }
    
    public void applyDescuento(float descuento)
    {
        precio = precio * (DESCUENTO/100);
    }
    
    public TiposEntradas getTipo()
    {
        return TiposEntradas.NORM_ADULTO;
    }
}
