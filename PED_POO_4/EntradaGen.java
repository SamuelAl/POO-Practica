
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
    protected HashMap<String, Float> descuentosApl;
    protected float precio;
    protected float descuentoTotal;
    
    private LocalDate fecha;
    private int edad;
    
    private boolean isVIP;
    private boolean VIPAplicado = false;
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
        descuentosApl = new HashMap<String, Float>();
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
        if (descuentoTotal < 90)
        {
            precio = precio * ((100 - descuento)/100);
            descuentosApl.put(tipo, descuento);
            descuentoTotal += descuento;
            if (isVIP && !VIPAplicado) 
            {
                if (tipo.equals("senior"))
                {
                    precio += (precio * (0.83333));
                } else if (tipo.equals("niño"))
                {
                    precio += (precio * (0.83333));
                } else 
                {
                    precio += PARAMETROS.PRECIO_VIP_BASE;
                }
                
                VIPAplicado = true;
            }
        }
        else
        {
            System.out.println("No se pueden aplicar mas descuentos");
        }
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
