
/**
 * Clase que se ocupa de la creacion de nuevos trabajadores.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public class CreadorTrabajadores
{
    // instance variables - replace the example below with your own
    private Trabajador trabajadorActual;

    /**
     * Constructor for objects of class CreadorTrabajadores
     */
    public CreadorTrabajadores()
    {
    }

    /**
     * Method nuevoTrabajador
     *
     * Crea y devuelve un nuevo trabajador
     * segun el tipo de trabajador especificado
     * en el parametro
     *
     * @param tipo Tipo de trabajador (TiposTrabajadores)
     * @return Nuevo trabajador
     */
    public Trabajador nuevoTrabajador(TiposTrabajadores tipo)
    {
        switch (tipo)
        {
            case ATENCION_CL:
              trabajadorActual = new AtencionCl();
              break;
            case RESP_ATRACC:
                trabajadorActual = new RespAtraccion();
                break;
            case AYU_ATRACC: 
                trabajadorActual = new AyudanteAtraccion();
                break;
            case REL_PUBLICAS:
                trabajadorActual = new RelPublicas();
                break;
        }
        
        return trabajadorActual;
    }
}
