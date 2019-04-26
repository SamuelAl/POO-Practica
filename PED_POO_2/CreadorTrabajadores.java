
/**
 * Write a description of class CreadorTrabajadores here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
