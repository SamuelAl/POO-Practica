
/**
 * Write a description of class AtencionCl here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.List;

public class AtencionCl extends Trabajador
{
   private  TiposTrabajadores tipo; 
   private float sueldo;

    /**
     * Constructor for objects of class AtencionCl
     */
    public AtencionCl()
    {
        super();
        tipo = TiposTrabajadores.ATENCION_CL;
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
