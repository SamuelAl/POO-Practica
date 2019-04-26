
/**
 * Write a description of class Niño here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.time.*;

public class Niño extends Entrada
{
    private float DESCUENTO;
    private float precio;
    private Entrada acompañante;

    /**
     * Constructor for objects of class Niño
     */
    public Niño(LocalDate fecha ,int edad, Entrada acompañante)
    {
        super(fecha, edad);
        this.acompañante = acompañante;
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
    
    public Entrada getAcompañante()
    {
        return acompañante;
    }
    
    public TiposEntradas getTipo()
    {
        return TiposEntradas.NIÑO;
    }
}
