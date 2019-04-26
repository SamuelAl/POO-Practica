
/**
 * Write a description of interface Trabajador here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;

public abstract class Trabajador
{
   private List<Atraccion> atracciones; 
   
   public Trabajador()
   {
       atracciones = new LinkedList<Atraccion>();
   }
    
   abstract public TiposTrabajadores getTipo();
   
   //Devuelve lista con las atracciones en las que trabaja
   public List<Atraccion> getAtracciones()
   {
       return atracciones;
   }
   
   //Asigna al trabajador lista de atracciones en las que trabaja
   public void setAtracciones(LinkedList<Atraccion> atracciones)
   {
       this.atracciones = new LinkedList(atracciones); 
   }
   
   public void addAtraccion(Atraccion atraccion)
   {
       atracciones.add(atraccion);
   }
   
   public void removeAtraccion(Atraccion atraccion)
   {
       atracciones.remove(atraccion);
   }
   
   public void clearAtracciones()
   {
       atracciones.clear();
   }
   
   public int numeroDeAtracciones()
   {
       return atracciones.size();
   }
}
