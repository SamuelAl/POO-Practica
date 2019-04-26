
/**
 * Clase principal del programa para almacenar y gestionar
 * los objetos y funcionalidades principales del programa
 *
 * @author (Samuel Alaro)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;

public class Parque
{
    private List<Atraccion> AtraccionesParque;
    private List<Trabajador> TrabajadoresParque;
    private List<Visitante> VisitantesParque;
    private MaquinaEntradas generadorEntradas;
    /**
     * Constructor for objects of class Parque
     */
    public Parque()
    {
        AtraccionesParque = new LinkedList<Atraccion>();
        TrabajadoresParque = new LinkedList<Trabajador>();
        VisitantesParque = new LinkedList<Visitante>();
        generadorEntradas = new MaquinaEntradas();
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    
}
