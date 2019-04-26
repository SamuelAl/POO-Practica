
/**
 * Write a description of class Niño here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.time.*;

public class Niño extends EntradaGen implements EntradaIF
{
    private EntradaGen acompañante;

    /**
     * Constructor for objects of class Niño
     */
    public Niño(LocalDate fecha ,int edad, EntradaGen acompañante)
    {
        super(fecha, edad);
        this.acompañante = acompañante;
        super.applyDescuento("niño", PARAMETROS.DESCUENTO_NIÑO);

    }
    
    
    public EntradaGen getAcompañante()
    {
        return acompañante;
    }
    
    
}
