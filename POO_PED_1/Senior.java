
/**
 * Write a description of class Senior here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Senior extends Visitante
{

    private float DESCUENTO_SENIOR = 100;
    /**
     * Constructor for objects of class Senior
     */
    public Senior(int edad, String dni)
    {
        super(edad, dni);
    }
    
    public void comprarEntrada(EntradaIF entrada)
    {
        if (super.entrada == null)
        {
             super.entrada = entrada;
        }
        
        entrada.applyDescuento(DESCUENTO_SENIOR);
    }
   
}
