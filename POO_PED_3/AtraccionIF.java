
/**
 * Write a description of class Atraccion here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
public interface AtraccionIF 
{
    

    /**
     * Constructor for objects of class Atraccion
     */
 
    
    public boolean getVIP();
    
    public void setVIP(boolean VIP);
 
    public float getMinAlturaCM();
    
    public void setMinAlturaCM(float max);
    
    public float getMaxAlturaCM();
    
    public void setMaxAlturaCM(float max);
    
    public int getEdad();
    
    public void setMinEdad(int min);
    
    public boolean getAccesoNiños();
        
    public void setAccesoNiños(boolean acceso);
    
    public boolean getAccesoAdultos();
        
    public void setAccesoAdultos(boolean acceso);
        
    public void setNumRespAtracc(int num);
        
    public int getNumRespAtracc();
        
    public void setNumAyuAtracc(int num);
        
    public int getNumAyuAtracc();
       
    public void addTrabajador(Trabajador trabajador);
        
    public void usar(EntradaIF entrada);
        
}
