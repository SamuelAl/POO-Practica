
/**
 * Clase para las entradas tipo Niño.
 * Extiende a la clase EntradaGen e 
 * implementa la interfaz EntradaIF
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
import java.util.HashMap;
import java.time.*;

public class Niño extends EntradaGen implements EntradaIF
{
    private EntradaGen acompañante;

    /**
     * Constructor for objects of class Niño
     */
    public Niño(LocalDate fecha ,int edad, Temporadas temporadas,EntradaGen acompañante)
    {
        super(fecha, edad, temporadas);
        this.acompañante = acompañante;
        super.applyDescuento("niño", PARAMETROS.DESCUENTO_NIÑO);

    }
    
    
    /**
     * Method getAcompañante
     *
     * Devuelve la entrada del acompañante
     * del niño
     *
     * @return Entrada del acompañante del niño..
     */
    public EntradaGen getAcompañante()
    {
        return acompañante;
    }
    
    
}
