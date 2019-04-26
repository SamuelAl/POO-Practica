
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

    public AtraccionIF nuevaAtraccion(String tipo, boolean accesoVIP, float minAlturaCM,
                            int minEdad, boolean accesoNiños, int numRespAtracc,
                            int numAyuAtracc)
    {
        atraccionActual = new Atraccion(tipo);
        atraccionActual.setVIP(accesoVIP);
        atraccionActual.setMinAlturaCM(minAlturaCM);
        atraccionActual.setMinEdad(minEdad);
        atraccionActual.setAccesoNiños(accesoNiños);
        atraccionActual.setNumRespAtracc(numRespAtracc);
        atraccionActual.setNumAyuAtracc(numAyuAtracc);
        
        return atraccionActual;
    }
}
