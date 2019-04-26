
/**
 * Abstract class Visitante - Clase abstracta visitante
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */
public abstract class Visitante
{
    // instance variables - replace the example below with your own
    private String dni;
    private int edad;
    protected EntradaIF entrada;
    
    public Visitante(int edad, String dni)
    {
        this.edad = edad;
        this.dni = dni;
    }

    /**
     * Metodo getter que devuelve edad del visitante
     *
     * @return    edad del visitante
     */
    public int getEdad()
    {
        // return edad
        return this.edad;
    }
    
    /**
     * Metodo para añadir entrada al visitante
     *
     */
    abstract public void comprarEntrada(EntradaIF entrada);
    
    /**
     * Metodo setter para añadir entrada al visitante
     *
     * @return    entrada del visitante
     */
    public EntradaIF getEntrada()
    {
        return this.entrada;
    }
    
    
}
