
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
     * Method getTipo
     * 
     * Devuelve el tipo de atraccion
     *
     * @return Tipo de atraccion (String)
     */
    public String getTipo();
    
    /**
     * Method getVIP
     * 
     * Indica si la atraccion tiene
     * acceso VIP.
     *
     * @return True si la atraccion tiene acceso VIP
     */
    public boolean getVIP();
    
    /**
     * Method setVIP
     * 
     * Modifica el atributo accesoVIP
     * de la atraccion
     *
     * @param VIP nuevo estado accesoVIP (boolean)
     */
    public void setVIP(boolean VIP);
    
    /**
     * Method getMinAlturaCM
     * 
     * Devuelve la altura minima
     * de acceso a la atraccion 
     * en CM
     * Si no hay altura minima devuelve 0.
     *
     * @return Altura minima para acceder a la atraccion
     */
    public float getMinAlturaCM();
    
    /**
     * Method setMinAlturaCM
     * 
     * Modifica la altura minima
     * de acceso a la atraccion
     *
     * @param min Nueva altura minima
     */
    public void setMinAlturaCM(float max);
    
    /**
     * Method getMaxAlturaCM
     * 
     * Devuelve la altura maxima de acceso a la
     * atraccion en CM
     * Si no hay altura maxima devuelve 0
     *
     * @return Altura maxima en CM
     */
    public float getMaxAlturaCM();
    
    /**
     * Method setMaxAlturaCM
     * 
     * Modifica la altura maxima de acceso
     * a la atraccion
     *
     * @param max Altura maxima de acceso a la atraccion
     */
    public void setMaxAlturaCM(float max);
    
    /**
     * Method getEdad
     * 
     * Devuelve la edad minima de acceso a la atraccion
     * Si no hay edad minima devuelve 0
     *
     * @return Edad minima de acceso a la atraccion
     */
    public int getEdad();
    
    /**
     * Method setMinEdad
     * 
     * Modifica la edad minima
     * de entrada a la atraccion
     *
     * @param min Edad minima de entrada a la atraccion
     */
    public void setMinEdad(int min);
    
    /**
     * Method getAccesoNiños
     * 
     * Indica si la atraccion permite
     * el acceso a visitantes con entrada 
     * de niño
     *
     * @return Acceso de niños - True si se permite el acceso
     */
    public boolean getAccesoNiños();
    
    /**
     * Method setAccesoAdultos
     * 
     * Modifica el acceso a no-niños
     * a la atraccion
     *
     * @param acceso Acceso a no-niños (boolean)
     */
    public void setAccesoNiños(boolean acceso);
    
    /**
     * Method getAccesoAdultos
     * 
     * Indica si la atraccion permite
     * el acceso de visitantes que no
     * sean niños
     *
     * @return Acceso de adultos - True si se permite
     */
    public boolean getAccesoAdultos();
    
    /**
     * Method setAccesoNiños
     *
     * Modifica el acceso a niños
     * de la atraccion
     *
     * @param acceso Acceso a niños (boolean)
     */
    public void setAccesoAdultos(boolean acceso);
    
    /**
     * Method setNumRespAtracc
     * 
     * Modifica el numero de Responsables
     * de Atraccion necesarios para el uso de la
     * atraccion
     *
     * @param num Numero de Responsables de Atraccion necesarios
     */
    public void setNumRespAtracc(int num);
    
     /**
     * Method getNumRespAtracc
     * 
     * Devuelve el numero de Responsables
     * de Atraccion necesarios para el uso de la
     * atraccion.
     *
     * @return Numero de Responsables de Atraccion necesarios
     */
    public int getNumRespAtracc();
    
    /**
     * Method setNumAyuAtracc
     * 
     * Modifica el numero de Ayudantes de
     * Atraccion necesario para el uso de la
     * atraccion
     *
     * @param num Numero de Ayudantes de Atraccion necesarios
     */
    public void setNumAyuAtracc(int num);
    
    /**
     * Method getNumAyuAtracc
     * 
     * Devuelve el numero de Ayudantes de
     * Atraccion necesario para el uso de la
     * atraccion
     *
     * @return Numero de Ayudantes de Atraccion necesarios
     */
    public int getNumAyuAtracc();
    
    /**
     * Method addTrabajador
     *
     *  Añade un nuevo trabajador a la lista
     *  de trabajadores de la atraccion
     *
     * @param trabajador Nuevo trabajador
     */
    public void addTrabajador(Trabajador trabajador);
    
     /**
     * Method getTrabajadores
     * 
     * Devuelve la lista de trabajadores de la atraccion
     *
     * @return Lista de trabajadores de la atraccion
     */
    public List getTrabajadores();
    
    /**
     * Method usar
     * 
     * Añade un nuevo visitante a la lista de 
     * visitantes de la atraccion.
     * Tambien se encarga de verificar que el visitante
     * tenga acceso a la atraccion a partir de su entrada
     *
     * @param entrada Entrada del visitante
     */
    public void usar(EntradaIF entrada);
    
    /**
     * Method getUsuarios
     *
     *  Devuelve la lista de visitantes
     *  de la atraccion
     *
     * @return Lista de visitantes de la atraccion
     */
    public List getUsuarios();

}
