
/**
 * Write a description of class AtraccionTipo here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
public class AtraccionE implements AtraccionIF
{
    private String tipo;
    private boolean accesoVIP;
    private float minAlturaCM, maxAlturaCM;
    private int minEdad;
    private boolean accesoNiños;
    private boolean accesoAdultos;
    private int numRespAtracc;
    private int numAyuAtracc;
    private int contador;
    
    private List trabajadores;


    /**
     * Constructor for objects of class AtraccionTipo
     */
    public AtraccionE()
    {
        this.tipo = "E";
        trabajadores =  new LinkedList<Trabajador>();
        // Valores default
        accesoVIP = true;
        minAlturaCM = 0; // no minimo de altura
        maxAlturaCM = 0;
        minEdad = 0; // no minimo de edad;
        accesoNiños = false;
        accesoAdultos = true;
        numRespAtracc = 1;
        numAyuAtracc = 7;
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
    
     public float getMaxAlturaCM()
    {
        return this.maxAlturaCM;
    }
    
    public void setMaxAlturaCM(float max)
    {
        this.maxAlturaCM = max;
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
    
    public void setAccesoAdultos(boolean acceso)
    {
        this.accesoAdultos= acceso;
    }
    
    public boolean getAccesoAdultos()
    {
        return this.accesoAdultos;
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
