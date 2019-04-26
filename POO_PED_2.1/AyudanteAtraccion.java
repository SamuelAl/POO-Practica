
/**
 * Write a description of class AyudanteAtraccion here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
