
/**
 * Write a description of class CreadorAtracciones here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
