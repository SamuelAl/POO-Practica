
/**
 * Extiende clase Trabajador para
 * Ayudante de Atraccion.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public class AyudanteAtraccion extends Trabajador
{
     private  TiposTrabajadores tipo; 
     private float sueldo;
    /**
     * Constructor for objects of class AtencionCl
     */
    public AyudanteAtraccion()
    {
        super();
        tipo = TiposTrabajadores.AYU_ATRACC;
        sueldo = 31.67f; // sueldo diario
    }
    

   /**
    * Method getTipo
    * 
    * Devuelve el tipo de trabajador
    *
    * @return The return value
    */
   public TiposTrabajadores getTipo()
   {
       return tipo;
   }
   
   /**
    * Method getSueldo
    * 
    * Devuelve el sueldo del trabajador
    *
    * @return The return value
    */
   public float getSueldo()
   {
       return sueldo;
    }
}
