
/**
 * Clase entrada que implementa Entrada
 *
 * @author (Samuel Alarco)
 * @version (v1.0)
 */

import java.util.Date;

public class Entrada implements EntradaIF
{
    private Date fecha;
    private float precio;
    
    private boolean isVIP;
    private boolean isFamilia;
    private boolean descuento;
    private String tipo;
    
    private Temporadas temporadas = new Temporadas();
    
    public static final float PRECIO_BASE = 30;
    public static final float PRECIO_VIP = 20;
    public static final float DESCUENTO_FAMILIA = 15;
    

    /**
     * Constructor for objects of class Entrada
     */
    public Entrada(Date fecha)
    {
        this.fecha = fecha;
        this.precio = PRECIO_BASE;
    }

    public float getPrecio()
    {
        return this.precio;
    }
    
    public Date getDate()
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
        precio += PRECIO_VIP;
    }
    
    public String getTipo()
    {
        return this.tipo;
    }
    
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
        applyDescuento(temporadas.get(tipo));
    }
    
    public boolean getFamilia()
    {
        return this.isFamilia;
    }
    
    public void setFamilia()
    {
        isFamilia = true;
        applyDescuento(DESCUENTO_FAMILIA);
    }
    
    public void applyDescuento(float descuento)
    {
        precio = precio * (descuento/100);
        this.descuento = true;
    }
}
