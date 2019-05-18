
/**
 * Implementacion de la Atraccion Tipo A.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.List;
import java.util.LinkedList;
public class AtraccionA implements AtraccionIF
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
    private List usuarios;


    /**
     * Constructor for objects of class AtraccionTipo
     */
    public AtraccionA()
    {
        this.tipo = "A";
        trabajadores =  new LinkedList<Trabajador>();
        usuarios =  new LinkedList<EntradaIF>();
        // Valores default
        accesoVIP = true;
        minAlturaCM = 120; // no minimo de altura
        maxAlturaCM = 0;
        minEdad = 0; // no minimo de edad;
        accesoNiños = true;
        accesoAdultos = true;
        numRespAtracc = 1;
        numAyuAtracc = 6;
    }

    /**
     * Method getTipo
     * 
     * Devuelve el tipo de atraccion
     *
     * @return Tipo de atraccion (String)
     */
    public String getTipo()
    {
      return this.tipo;
    }

    /**
     * Method getVIP
     * 
     * Indica si la atraccion tiene
     * acceso VIP.
     *
     * @return True si la atraccion tiene acceso VIP
     */
    public boolean getVIP()
    {
        return accesoVIP;
    }

    /**
     * Method setVIP
     * 
     * Modifica el atributo accesoVIP
     * de la atraccion
     *
     * @param VIP nuevo estado accesoVIP (boolean)
     */
    public void setVIP(boolean VIP)
    {
        this.accesoVIP = VIP;
    }

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
    public float getMinAlturaCM()
    {
        return this.minAlturaCM;
    }

    /**
     * Method setMinAlturaCM
     * 
     * Modifica la altura minima
     * de acceso a la atraccion
     *
     * @param min Nueva altura minima
     */
    public void setMinAlturaCM(float min)
    {
        this.minAlturaCM = min;
    }

    /**
     * Method getMaxAlturaCM
     * 
     * Devuelve la altura maxima de acceso a la
     * atraccion en CM
     * Si no hay altura maxima devuelve 0
     *
     * @return Altura maxima en CM
     */
    public float getMaxAlturaCM()
    {
        return this.maxAlturaCM;
    }

    /**
     * Method setMaxAlturaCM
     * 
     * Modifica la altura maxima de acceso
     * a la atraccion
     *
     * @param max Altura maxima de acceso a la atraccion
     */
    public void setMaxAlturaCM(float max)
    {
        this.maxAlturaCM = max;
    }

    /**
     * Method getEdad
     * 
     * Devuelve la edad minima de acceso a la atraccion
     * Si no hay edad minima devuelve 0
     *
     * @return Edad minima de acceso a la atraccion
     */
    public int getEdad()
    {
        return this.minEdad;
    }

    /**
     * Method setMinEdad
     * 
     * Modifica la edad minima
     * de entrada a la atraccion
     *
     * @param min Edad minima de entrada a la atraccion
     */
    public void setMinEdad(int min)
    {
        this.minEdad = min;
    }

    /**
     * Method getAccesoNiños
     * 
     * Indica si la atraccion permite
     * el acceso a visitantes con entrada 
     * de niño
     *
     * @return Acceso de niños - True si se permite el acceso
     */
    public boolean getAccesoNiños()
    {
        return this.accesoNiños;
    }

    /**
     * Method setAccesoAdultos
     * 
     * Modifica el acceso a no-niños
     * a la atraccion
     *
     * @param acceso Acceso a no-niños (boolean)
     */
    public void setAccesoAdultos(boolean acceso)
    {
        this.accesoAdultos= acceso;
    }

    /**
     * Method getAccesoAdultos
     * 
     * Indica si la atraccion permite
     * el acceso de visitantes que no
     * sean niños
     *
     * @return Acceso de adultos - True si se permite
     */
    public boolean getAccesoAdultos()
    {
        return this.accesoAdultos;
    }

    /**
     * Method setAccesoNiños
     *
     * Modifica el acceso a niños
     * de la atraccion
     *
     * @param acceso Acceso a niños (boolean)
     */
    public void setAccesoNiños(boolean acceso)
    {
        this.accesoNiños= acceso;
    }

    /**
     * Method setNumRespAtracc
     * 
     * Modifica el numero de Responsables
     * de Atraccion necesarios para el uso de la
     * atraccion
     *
     * @param num Numero de Responsables de Atraccion necesarios
     */
    public void setNumRespAtracc(int num)
    {
        this.numRespAtracc = num;
    }

    /**
     * Method getNumRespAtracc
     * 
     * Devuelve el numero de Responsables
     * de Atraccion necesarios para el uso de la
     * atraccion.
     *
     * @return Numero de Responsables de Atraccion necesarios
     */
    public int getNumRespAtracc()
    {
        return numRespAtracc;
    }

    /**
     * Method setNumAyuAtracc
     * 
     * Modifica el numero de Ayudantes de
     * Atraccion necesario para el uso de la
     * atraccion
     *
     * @param num Numero de Ayudantes de Atraccion necesarios
     */
    public void setNumAyuAtracc(int num)
    {
        numAyuAtracc = num;
    }

    /**
     * Method getNumAyuAtracc
     * 
     * Devuelve el numero de Ayudantes de
     * Atraccion necesario para el uso de la
     * atraccion
     *
     * @return Numero de Ayudantes de Atraccion necesarios
     */
    public int getNumAyuAtracc()
    {
        return numAyuAtracc;
    }

    /**
     * Method addTrabajador
     *
     *  Añade un nuevo trabajador a la lista
     *  de trabajadores de la atraccion
     *
     * @param trabajador Nuevo trabajador
     */
    public void addTrabajador(Trabajador trabajador)
    {
        trabajadores.add(trabajador);
    }

    /**
     * Method getTrabajadores
     * 
     * Devuelve la lista de trabajadores de la atraccion
     *
     * @return Lista de trabajadores de la atraccion
     */
    public List getTrabajadores()
    {
      return trabajadores;
    }

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
    public void usar(EntradaIF entrada)
    {
         contador++;
        if (!(((entrada instanceof Niño) && !getAccesoNiños()) || (!(entrada instanceof Niño) && !getAccesoAdultos())))
        {
            usuarios.add(entrada);
            //System.out.println("Acceso permitido a la atraccion");
        }
        else
        {
            System.out.println("Acceso denegado a la atraccion");
        }

    }

    /**
     * Method getUsuarios
     *
     *  Devuelve la lista de visitantes
     *  de la atraccion
     *
     * @return Lista de visitantes de la atraccion
     */
    public List getUsuarios()
    {
      return this.usuarios;
    }


}
