
/**
 * Write a description of class RespAtraccion here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RespAtraccion extends Trabajador
{
     private  TiposTrabajadores tipo; 
     private float sueldo;

    /**
     * Constructor for objects of class AtencionCl
     */
    public RespAtraccion()
    {
        super();
        tipo = TiposTrabajadores.RESP_ATRACC;
    }
    

   public TiposTrabajadores getTipo()
   {
       return tipo;
   }
   
   public float getSueldo()
   {
       return sueldo;
    }
}
