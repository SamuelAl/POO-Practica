
/**
 * Write a description of class Niño here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Niño extends Visitante
{
    // instance variables - replace the example below with your own
    private Visitante acompañante;
    private float DESCUENTO_NIÑO; 
    /**
     * Constructor for objects of class Niño
     */
    public Niño(int edad)
    {
        super(edad, "no dni");
    }

    /**
     * Metodo setter para el atributo de
     * acompañante
     *
     * @param  acompañante  el acompañante -tipo Visitante
     */
    public void setAcompañante(Visitante acompañante)
    {
        if(acompañante instanceof Adulto || acompañante instanceof Senior)
        {
            this.acompañante = acompañante;
        }
    }
    
    public Visitante getAcompañante()
    {
        return this.acompañante;
    }
    
    public void comprarEntrada(EntradaIF entrada)
    {
        if (super.entrada == null)
        {
             super.entrada = entrada;
        }
        
        entrada.applyDescuento(DESCUENTO_NIÑO);
    }
}
