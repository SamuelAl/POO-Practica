
/**
 * Write a description of class Niño here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.time.*;

public class Niño extends Entrada
{
    private float DESCUENTO;
    private float precio;
    private HashMap<String, Float> descuentosApl;
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
    
     public void applyDescuento(String tipo ,float descuento)
    {
        precio = precio * ((100 - descuento)/100);
        descuentosApl.put(tipo, descuento);
    }
    
    public Entrada getAcompañante()
    {
        return acompañante;
    }
    
    public String getTipo()
    {
        return "Niño";
    }
}
