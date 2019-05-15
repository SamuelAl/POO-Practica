
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

    public void setAccesoAdultos(boolean acceso)
    {
        this.accesoAdultos= acceso;
    }

    public boolean getAccesoAdultos()
    {
        return this.accesoAdultos;
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

    public List getTrabajadores()
    {
      return trabajadores;
    }

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
            //System.out.println("Acceso denegado a la atraccion");
        }

    }

    public List getUsuarios()
    {
      return this.usuarios;
    }


}
