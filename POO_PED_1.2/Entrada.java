
/**
 * Clase entrada que implementa Entrada
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.time.*;

public abstract class Entrada implements EntradaIF
{
    private LocalDate fecha;
    private int edad;
    
    private boolean isVIP;
    private boolean isFamilia;
    private String temporada;
    
    private Temporadas temporadas = new Temporadas();
    
    protected float PRECIO_ADULTO;
    public static float PRECIO_VIP;
    public static float DESCUENTO_FAMILIA;
    
    
    public Entrada(LocalDate fecha, int edad)
    {
        this.fecha = fecha;
        this.edad = edad;
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

    public float getPrecio()
    {
        float precio = getBasePrecio();
        
        precio = precio * (temporadas.get(temporada) / 100);
        if (isFamilia) {precio = precio * (DESCUENTO_FAMILIA / 100);}
        if (isVIP) {precio += PRECIO_VIP;}
        
        return precio;
    }
    
    abstract protected float getBasePrecio();
    
    public LocalDate getDate()
    {
        return this.fecha;
    }
    
    public boolean getVIP()
    {
        return this.isVIP;
    }
    
    public void setVIP()
    {
        isVIP = true;
    }
    
    public String getTemporada()
    {
        return this.temporada;
    }
    
    public void setTemporada()
    {
        this.temporada = temporadas.checkTemporada(fecha);
    }
    
    public boolean getFamilia()
    {
        return this.isFamilia;
    }
    
    public void setFamilia()
    {
        isFamilia = true;
    }
    
    abstract public void applyDescuento(String tipo, float descuento);
    
    abstract public String getTipo();
    
}
