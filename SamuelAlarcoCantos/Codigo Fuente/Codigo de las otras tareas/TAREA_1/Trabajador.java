
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
   
   
   /**
    * Method getTipo
    * 
    * Devuelve el tipo de trabajador
    *
    * @return Tipo de trabajador
    */
   abstract public TiposTrabajadores getTipo();
   
   public List<AtraccionIF> getAtracciones()
   {
       return atracciones;
   }
   
   /**
    * Method setAtracciones
    * 
    * Añade una lista de atracciones
    * al atributo atracciones del trabajador
    *
    * @param atracciones Lista de atracciones
    */
   public void setAtracciones(LinkedList<AtraccionIF> atracciones)
   {
       this.atracciones = new LinkedList(atracciones); 
   }
   
   /**
    * Method addAtraccion
    * 
    * Añade una nueva atraccion a la lista
    * de atracciones
    *
    * @param atraccion A parameter
    */
   public void addAtraccion(AtraccionIF atraccion)
   {
       atracciones.add(atraccion);
   }
   
   /**
    * Method removeAtraccion
    * 
    * Elimina una atraccion especifica de la lista 
    * de atracciones
    *
    * @param atraccion Atraccion que se debe eliminar
    */
   public void removeAtraccion(AtraccionIF atraccion)
   {
       if (atracciones.contains(atraccion))
       {
           atracciones.remove(atraccion);
       }
       
   }
   
   /**
    * Method clearAtracciones
    * 
    * Elimina todas las atracciones de la lista
    * de atracciones
    *
    */
   public void clearAtracciones()
   {
       atracciones.clear();
   }
   
   /**
    * Method numeroDeAtracciones
    * 
    * Devuelve el numero de atracciones
    * en la lista de atracciones del
    * trabajador
    *
    * @return Numero de atracciones
    */
   public int numeroDeAtracciones()
   {
       return atracciones.size();
   }
   
   /**
    * Method getSueldo
    * 
    * Devuelve el sueldo del trabajador
    *
    * @return Sueldo del trabajador
    */
   abstract public float getSueldo();
}
