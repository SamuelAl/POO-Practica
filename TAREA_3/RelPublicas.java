
/**
 * Write a description of class RelPublicas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RelPublicas extends Trabajador
{
    private  TiposTrabajadores tipo;
    private float sueldo;

    /**
     * Constructor for objects of class AtencionCl
     */
    public RelPublicas()
    {
        super();
        tipo = TiposTrabajadores.REL_PUBLICAS ;
        sueldo = 38f;
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
