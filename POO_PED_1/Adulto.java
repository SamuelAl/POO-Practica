
/**
 * Write a description of class Adulto here.
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public class Adulto extends Visitante
{
    // instance variables - replace the example below with your own
    private boolean esEstudiante;
    private boolean esDescapacitado;
    private boolean esDesempleado;
    private float DESCUENTO_ADULTO = 100;
    private float DESCUENTO_DESEMPLEADO = 100;
    private float DESCUENTO_ESTUDIANTE = 100;
    private float DESCUENTO_DESCAPACITADO = 100;
    
    /**
     * Constructor for objects of class Adulto
     */
    public Adulto(int edad, String dni)
    {
        super(edad, dni);
        esEstudiante = false;
        esDescapacitado = false;
        esDesempleado = false;
    }
    
    /**
     * Metodo setter para atributo de
     * esEstudiante 
     * esEstudiante = true;
     *
     */
    public void setEstudiante()
    {
        this.esEstudiante = true;
    }
    
    /**
     * Metodo getter que devuelve si el
     * visitante es un estudiante
     *
     * @return    atributo esEstudiante
     */
    public boolean getEstudiante()
    {
        return esEstudiante;
    }
    
    /**
     * Metodo setter para atributo de
     * esDescapacitado
     * esDescapacitado = true;
     *
     */
    public void setDescapacitado()
    {
        this.esDescapacitado = true;
    }
    
    /**
     * Metodo getter que devuelve si el
     * visitante tiene diversidad funcional
     *
     * @return    atributo esDescapacitado
     */
    public boolean getDescapacitado()
    {
        return esDescapacitado;
    }
    
   /**
     * Metodo setter para atributo de
     * esDesempleado
     * esDesempleado = true;
     *
     */
    public void setDesempleado()
    {
        this.esDesempleado = true;
    }
    
    /**
     * Metodo getter que devuelve si el
     * visitante es desempleado
     *
     * @return    atributo esDesemplado
     */
    public boolean getDesempleado()
    {
        return esDesempleado;
    }
    
    public void comprarEntrada(EntradaIF entrada)
    {
        if (super.entrada == null)
        {
             super.entrada = entrada;
        }
        
        entrada.applyDescuento(DESCUENTO_ADULTO);
        if (esDesempleado) {entrada.applyDescuento(DESCUENTO_DESEMPLEADO);}
        if (esEstudiante) {entrada.applyDescuento(DESCUENTO_ESTUDIANTE);}
        if (esDescapacitado) {entrada.applyDescuento(DESCUENTO_DESCAPACITADO);}
    }
    
   
    
}
