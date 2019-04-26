
/**
 * Write a description of class EntradaGen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.HashMap;
import java.time.*;

public class EntradaGen implements EntradaIF
{
    // instance variables - replace the example below with your own
    private HashMap<String, Float> descuentosApl;
    private float precio;
    
    private LocalDate fecha;
    private int edad;
    
    private boolean isVIP;
    private boolean isFamilia;
    private String temporada;
    
    private Temporadas temporadas = new Temporadas();
    public static float DESCUENTO_FAMILIA = 10 ;

    /**
     * Constructor for objects of class EntradaGen
     */
    public EntradaGen(LocalDate fecha, int edad)
    {
        this.fecha = fecha;
        this.edad = edad;
        precio = PARAMETROS.PRECIO_BASE;
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
        return precio;
    }
    
    public void applyDescuento(String tipo ,float descuento)
    {
        precio = precio * ((100 - descuento)/100);
        descuentosApl.put(tipo, descuento);
    }

    public String getTipo()
    {
        String tipos = "";
        for (String key : descuentosApl.keySet())
        {
            tipos += key + " - ";
        }
        tipos = tipos.substring(0, tipos.length()-3);
        return tipos;
    }
    
    protected HashMap<String, Float> getDescuentos()
    {
        return descuentosApl;
    }
    
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
        if (isVIP) 
        {
            if (getDescuentos().get("senior") != null)
            {
                precio += (precio * (0.83333));
            } else if (getDescuentos().get("niño") != null)
            {
                precio += (precio * (0.83333));
            } else 
            {
                precio += PARAMETROS.PRECIO_VIP_BASE;
            }
        }
    }
    
    public String getTemporada()
    {
        return this.temporada;
    }
    
    public void setTemporada()
    {
        this.temporada = temporadas.checkTemporada(fecha);
        precio = precio * (temporadas.get(temporada) / 100);
    }
    
    public boolean getFamilia()
    {
        return this.isFamilia;
    }
    
    public void setFamilia()
    {
        isFamilia = true;
        if (isFamilia) 
            {precio = precio * ((100 - DESCUENTO_FAMILIA) / 100);
        }
    }
}
