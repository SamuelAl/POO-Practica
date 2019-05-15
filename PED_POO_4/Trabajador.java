
/**
 * Clase abstracta Trabajador con metodos
 * comunes a todos los trabajadores.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;

public abstract class Trabajador
{
   private List<AtraccionIF> atracciones; 
   
   public Trabajador()
   {
       atracciones = new LinkedList<AtraccionIF>();
   }
    
   abstract public TiposTrabajadores getTipo();
   
   //Devuelve lista con las atracciones en las que trabaja
   public List<AtraccionIF> getAtracciones()
   {
       return atracciones;
   }
   
   //Asigna al trabajador lista de atracciones en las que trabaja
   public void setAtracciones(LinkedList<AtraccionIF> atracciones)
   {
       this.atracciones = new LinkedList(atracciones); 
   }
   
   public void addAtraccion(AtraccionIF atraccion)
   {
       atracciones.add(atraccion);
   }
   
   public void removeAtraccion(AtraccionIF atraccion)
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
   
   abstract public float getSueldo();
}
