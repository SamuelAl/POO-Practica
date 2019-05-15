
/**
 * Esta clase se ocupa de la creacion
 * de nuevas atracciones.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;

public class CreadorAtracciones
{
   private AtraccionIF atraccionActual;
    /**
     * Constructor for objects of class CreadorAtracciones
     */
    public CreadorAtracciones()
    {
       
    }

    /**
     * Method nuevaAtraccion
     * 
     * Crea y devuelve una nueva atraccion
     * segun el tipo de atraccion 
     * especificado
     *
     * @param tipo Tipo de atraccion (String)
     * @return Nueva atraccion
     */
    public AtraccionIF nuevaAtraccion(String tipo)
    {
        switch(tipo) {
            case "A":
                atraccionActual = new AtraccionA();
                break;
            case "B":
                atraccionActual = new AtraccionB();
                break;
            case "C":
                atraccionActual = new AtraccionC();
                break;
            case "D":
                atraccionActual = new AtraccionD();
                break;
            case "E":
                atraccionActual = new AtraccionE();
                break;
            default:
                atraccionActual = new AtraccionA();
        }
        return atraccionActual;
    }
}
