
/**
 * Write a description of class Atraccion here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
public class Atraccion
{
    private String tipo;
    private boolean accesoVIP;
    private float minAlturaCM;
    private int minEdad;
    private boolean accesoNiños;
    private int numRespAtracc;
    private int numAyuAtracc;
    private int contador;
    
    private List trabajadores;


    /**
     * Constructor for objects of class Atraccion
     */
    public Atraccion(String tipo)
    {
        this.tipo = tipo;
        trabajadores =  new LinkedList<Trabajador>();
        // Valores default
        accesoVIP = true;
        minAlturaCM = 0; // no minimo de altura
        minEdad = 0; // no minimo de edad;
        accesoNiños = true;
        numRespAtracc = 1;
        numAyuAtracc = 1;
    }
    
    public boolean getVIP()
    {
        return accesoVIP;
    }
    
    public void setVIP(boolean VIP)
    {
        this.accesoVIP = VIP;
    }
    
    public float getMinAlturaCM()
    {
        return this.minAlturaCM;
    }
    
    public void setMinAlturaCM(float min)
    {
        this.minAlturaCM = min;
    }
    
    public int getEdad()
    {
        return this.minEdad;
    }
    
    public void setMinEdad(int min)
    {
        this.minEdad = min;
    }
    
    public boolean getAccesoNiños()
    {
        return this.accesoNiños;
    }
    
    public void setAccesoNiños(boolean acceso)
    {
        this.accesoNiños= acceso;
    }
    
    public void setNumRespAtracc(int num)
    {
        this.numRespAtracc = num;
    }
    
    public int getNumRespAtracc()
    {
        return numRespAtracc;
    }
    
    public void setNumAyuAtracc(int num)
    {
        numAyuAtracc = num;
    }
    
    public int getNumAyuAtracc()
    {
        return numAyuAtracc;
    }
    
    public void addTrabajador(Trabajador trabajador)
    {
        trabajadores.add(trabajador);
    }
    
    public void usar()
    {
        contador++;
    }

    
}
